package test;

import factory.DriverFactory;
import factory.EnvironmentFactory;
import factory.LoggerFactory;
import helper.ElementHelper;
import helper.LogHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    final String URL_TEST = "https://www.w3schools.com/";

    LogHelper logger;
    WebDriver driver;

    @BeforeClass
    @Parameters({"environment"})
    public void setUp(String environment) {

        EnvironmentFactory.setEnvironment(environment);

        WebDriverManager.chromedriver().setup();

        DriverFactory.setDriver(new ChromeDriver());
        LoggerFactory.setLogger(new LogHelper());

        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        logger = LoggerFactory.getLogger();
        logger.createExtent(getClass().getSimpleName());

    }

    @AfterClass
    public void classExit() {
        logger.flushExtent();
        DriverFactory.closeDriver();
    }

}
