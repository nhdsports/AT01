package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    BasePage page = new BasePage();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        page.createExtent("W3S Register Test");
        System.out.println("-- Done setup");
    }

    @AfterTest
    public void testExit() {
        page.flushExtent();
        driver.quit();
        System.out.println("-- Done all");
    }

}
