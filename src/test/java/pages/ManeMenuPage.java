package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ManeMenuPage {
    private final static String pagePath = "/inventory.html";


    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//*[text()='Products']");

    public SelenideElement getHeaderTitleLabelLocator() {
        return $(headerTitleLabelLocator);
    }
}



