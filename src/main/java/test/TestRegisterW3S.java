package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import other.DataForRegisterW3S;
import page.RegisterW3S;

import java.util.concurrent.TimeUnit;

public class TestRegisterW3S {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        baseUrl = "https://www.w3schools.com/";
        System.out.println("-- Done setup");
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        RegisterW3S reg = new RegisterW3S(driver);
        reg.runRegister();
        System.out.println("-- Done test");
    }

    @AfterMethod
    public void testExit() {
        driver.quit();
        System.out.println("-- Done all");
    }

}
