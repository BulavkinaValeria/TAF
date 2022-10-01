import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BaseTest {
    @Test
    public void testDiv() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Неверная сумма...");
    }

    @Test(enabled = false)
    public void testDiv1() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Неверная сумма...");
    }

    @Test(description = "Тест с описанием")
    public void testDiv2() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Неверная сумма...");
    }

    @Test(testName = "Division")
    public void testDiv3() {
        Assert.assertEquals(calculator.div(6, 3), 2, "Неверная сумма...");
    }

    /*   @Test(timeOut = 1000)
       public void waitLongTimeTest() throws InterruptedException {
           Thread.sleep(500);
       }

       @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
       public void invocationCountTest() throws InterruptedException {
           Thread.sleep(500);
           Assert.assertEquals(calculator.div(6, 3), 2, "Неверная сумма...");
       }

       @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
       public void testDataProvider(int a, int b, int expectedResult) {
           Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверная сумма...");
       }
        @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
        public void testDataProvider(double a, double b, double expectedResult) {
            Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверная сумма...");}
        */
        @Test(expectedExceptions = ArithmeticException.class)
        public void testExceptions () {
            List list = null;
            int size = list.size();
        }
    }
