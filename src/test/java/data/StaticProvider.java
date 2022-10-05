package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForDivInt")
    public static Object[][] dataForDivTest1() {
        return new Object[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
    } @DataProvider (name = "dataForDivInt2")
    public static Object[][] dataForDivTest2() {
        return new Object[][] {
                {-6, -2, 3},
                {0, 0, 0},
                {0, 1, 0},
                {6, 2, 3}
        };
    }
    @DataProvider (name = "dataForDivDouble")
    public static Object[][] dataForDivTest3() {
        return new Object[][] {
                {0.31, -0.1, -3.1},
                {-0.31, 0.1, -3.1},
                {-0.31, -0.1, 3.1},
                {0.31, 0.1, 3.1}
        };
    }
    }
