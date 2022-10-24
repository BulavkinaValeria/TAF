package test;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;
import steps.LoginStep;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        loginStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());

        Assert.assertTrue(new LoginPage(driver).isPageOpened());
        Assert.assertTrue(new LoginPage(driver).isPageOpened());
    }

    @Test
    public void incorrectPswTest() {

    }
}
