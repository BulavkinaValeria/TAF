package test;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        //driver.switchTo().frame(frameElement); // webElement - поиск элементам (по тегу/айдишнику)
        //driver.switchTo().frame(0); //int - поиск по порядковому номеру (начинается с 0) - находятся на одном уровне
        driver.switchTo().frame("mce_0_ifr"); //String -  по name или id

        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        //driver.switchTo().parentFrame(); //переключиться в родительский документ (вернет всего лишь на 1 уровень выше)
        driver.switchTo().defaultContent(); //переключает в первоначальный документ

        driver.findElement(By.tagName("h3")).isDisplayed();

    }
}
