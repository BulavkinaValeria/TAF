package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import services.BrowsersService;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void a_validateIKTCalculationTest() {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement height = driver.findElement(By.name("height"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));
        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();

        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");


        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByVisibleText("женский");
        Thread.sleep(2000);
        WebElement creatin = driver.findElement(By.id("oCr"));
        creatin.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        WebElement button = driver.findElement(By.cssSelector("#Form1 > ul > li:nth-child(6) > input[type=button]:nth-child(1)"));
        button.click();

        WebElement mdrd = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(mdrd.getText(),"MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement mdrd1 = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(mdrd1.getText(),"ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement cg = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(cg.getText(),"Cockroft-Gault: 70 (мл/мин)");
        WebElement bsa = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(bsa.getText(),"Поверхность тела:1.58 (кв.м)");


    }

    @Test
    public void validateSKF2() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys("5");
        WebElement lenght = driver.findElement(By.id("el_f_lenght"));
        lenght.sendKeys("6");
        WebElement roomType = driver.findElement(By.id("room_type"));
        roomType.sendKeys("Ванная");
        WebElement heatingType = driver.findElement(By.id("heating_type"));
        heatingType.sendKeys("Основное отопление");
        WebElement elFLosses = driver.findElement(By.id("el_f_losses"));
        elFLosses.sendKeys("25");

        WebElement button = driver.findElement(By.cssSelector("#hf_calc > input"));
        button.click();

        WebElement floorCablePower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(floorCablePower.getAttribute("value"),"26");
        WebElement specFloorCablePower = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specFloorCablePower.getAttribute("value"),"1");
    }



        @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
