package test;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_8 {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorsTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(),"$29.99");
        Assert.assertEquals(driver.findElement(By.linkText("Sauce Labs Backpack")).getText(),"Sauce Labs Backpack");

    }
}
