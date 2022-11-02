package test;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest {

    @Test
    @Issue("AQA21-1")
    public void testIssue() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS-1")
        public void testTms() {
        Assert.assertTrue(true);
    }

    @Test
    @Link("http://onliner.by")
    @Link(name = "Onliner Catalog", type = "mylink", url = "https:onliner.by")
    public void linkTest(){
        Assert.assertTrue(true);
    }
}
