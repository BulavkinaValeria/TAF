package defs;

import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import steps.LoginStep;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginStepDef {
    @Given("user open login page")
    public void userOpenLoginPage() {
        open("https://www.saucedemo.com/");
    }

    @When("click login button")
    public void clickLoginButton() {
        $(By.id("login-button")).click();
    }

    @Then("user pass to MainPage")
    public void mainPageIsOpened() {
        webdriver().shouldHave(url("https://www.saucedemo.com/inventory.html"));
    }

    @When("user enter Username and Password")
    public void userLogin() {
        LoginStep loginStep = new LoginStep();
        loginStep.loginSuccessful(ReadProperties.usernameStandard(),ReadProperties.password());    }
}
