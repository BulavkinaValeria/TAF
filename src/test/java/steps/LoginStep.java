package steps;

import pages.LoginPage;
import pages.ManeMenuPage;

import static com.codeborne.selenide.Selenide.page;


public class LoginStep {
    LoginPage loginPage;
    ManeMenuPage maneMenuPage;


    public LoginStep() {
        loginPage = new LoginPage();
        maneMenuPage = new ManeMenuPage();

    }

    public void login(String user, String psw) {
        loginPage.setEmail(user);
        loginPage.setPsw(psw);
        loginPage.clickLoginButton();
    }

    public ManeMenuPage loginSuccessful(String user, String psw) {
        login(user, psw);
        return page(ManeMenuPage.class);
    }


    public LoginPage loginIncorrect(String user, String psw) {
        login(user, psw);
        return page(LoginPage.class);
    }
}

