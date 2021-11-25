package page;

import helper.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;
    LogHelper logger;

    By btnLogin = By.cssSelector("a#w3loginbtn");

    /**
     * Constructor
     * @param driver
     * @param logger
     */
    public HomePage(WebDriver driver, LogHelper logger) {
        this.driver = driver;
        this.logger = logger;
    }

    /**
     * Navigate to home page
     * Verify: home page is correct and login button is displayed
     * @param url
     */
    public void navigate(String url) {
        driver.get(url);
        String actualUrl = driver.getCurrentUrl();
        logger.verifyTest("Verify home page is correct", url, actualUrl, "This page is correct", "This page is incorrect");
        boolean actualBtnLogin = elm.checkElementAvailable(driver, btnLogin);
        logger.verifyTest("Verify login button is displayed", true, actualBtnLogin, "This button is displayed", "This button is not displayed");
    }

    /**
     * Step: click login button
     * Verify: login page is correct
     */
    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
        String expectedUrl = "https://profile.w3schools.com/log-in?redirect_url=https%3A%2F%2Fmy-learning.w3schools.com";
        String actualUrl = driver.getCurrentUrl();
        logger.verifyTest("Verify login page is correct", expectedUrl, actualUrl, "This page is correct", "This page is incorrect");
    }

}
