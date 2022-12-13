package test;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManeMenuPage;
import steps.LoginStep;

import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {
    @Test
    public void successLoginTest() {
        LoginStep loginStep = open("", LoginStep.class);
        ManeMenuPage maneMenuPage = loginStep.loginSuccessful(ReadProperties.usernameStandard(), ReadProperties.password());
        maneMenuPage.getHeaderTitleLabelLocator().shouldBe(Condition.visible);
    }

    @Test
    public void incorrectPswTest() {
        LoginStep loginStep = open("", LoginStep.class);
        LoginPage loginPage = loginStep.loginIncorrect(ReadProperties.usernameStandard(), "someName");
        loginPage.getErrorTextElement().shouldHave(Condition.text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void incorrectUserTest() {
        LoginStep loginStep = open("", LoginStep.class);
        LoginPage loginPage = loginStep.loginIncorrect("some name", ReadProperties.password());
        loginPage.getErrorTextElement().shouldHave(Condition.text("Epic sadface: Username and password do not match any user in this service"));
    }
}