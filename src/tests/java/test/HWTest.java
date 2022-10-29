package test;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class HWTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .contextClick(wait.waitForExists(By.id("hot-spot"))) //правый клик по элементу
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu"); //Валидация текста на алерте

        alert.accept(); //закрываем аллерт
    }

    @Test
    public void dynamicControlsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("input[type=checkbox]")).click(); //нашли и клинкнули на чекбокс
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Remove']")).click(); //нашли и нажали на кнопку Remove
        Thread.sleep(2000);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(15));
        WebElement text = wait.waitForVisibilityBy(By.id("message")); //подождали, пока появится текст
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!"); //сверили надпись

        //Assert.assertTrue(driver.findElement(By.cssSelector("input[type=checkbox]")).isDisplayed());//проверяем, что чекбокса нет

        Assert.assertFalse(driver.findElement(By.xpath("//input")).isEnabled()); //нашли input и проверили, что он disables

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        Thread.sleep(2000);
        WebElement textEnable = wait.waitForVisibilityBy(By.id("message"));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's enabled!"); //сверили надпись
        Assert.assertTrue(driver.findElement(By.xpath("//input")).isEnabled()); //нашли input и проверили, что он enabled

    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = HWTest.class.getClassLoader().getResource("pict.jpeg").getPath();
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("mce_0_ifr"); // по name или id
        Assert.assertEquals(driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).getText(),"Your content goes here.");

    }
}
