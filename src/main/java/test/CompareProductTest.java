package test;

import org.testng.annotations.*;
import page.CompareProductPage;

public class CompareProductTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://www.thegioididong.com/");
        CompareProductPage compare = new CompareProductPage(driver);
        compare.runCompareProduct("laptop");
        System.out.println("-- Done test");
    }

}
