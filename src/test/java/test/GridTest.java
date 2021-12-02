package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    public WebDriver driver;

    String urlGo = "https://google.com";
    String node = "http://192.168.1.164:4444/wd/hub";

    @BeforeTest
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(node), caps);
        driver.manage().window().maximize();
    }

    @Test
    public void testGG() {
        driver.get(urlGo);
        driver.manage().window().maximize();
        driver.findElement(By.className("gLFyf")).sendKeys("nhd sports");
        driver.findElement(By.className("gNO89b")).click();
        System.out.println("Selenium Grid Standalone Testing Is Complete");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
