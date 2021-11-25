package test;

import helper.LogHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LogHelper logger;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        logger = new LogHelper();
        logger.createExtent(driver, "test-output/RegisterReport.html", "W3S Register Test");
    }

    @AfterTest
    public void testExit() {
        logger.flushExtent();
        driver.quit();
    }

}
