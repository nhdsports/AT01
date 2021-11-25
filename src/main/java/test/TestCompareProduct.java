package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CompareProduct;

import java.util.concurrent.TimeUnit;

public class TestCompareProduct {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        baseUrl = "https://www.thegioididong.com/";
        System.out.println("-- Done setup");
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        // Compare Product
        CompareProduct compare = new CompareProduct(driver);
        compare.runCompareProduct("laptop");
        System.out.println("-- Done test");
    }

    @AfterMethod
    public void testDown() {
        driver.quit();
        System.out.println("-- Done all");
    }

}
