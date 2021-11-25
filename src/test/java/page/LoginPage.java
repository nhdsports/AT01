package page;

import helper.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;
    LogHelper logger;

    By btnSignUp = By.cssSelector("form > div > div > span > span");

    /**
     * Constructor
     * @param driver
     * @param logger
     */
    public LoginPage(WebDriver driver, LogHelper logger) {
        this.driver = driver;
        this.logger = logger;
    }

    /**
     * Go to register page
     */
    public void clickBtnRegister() {
        driver.findElement(btnSignUp).click();
    }

}
