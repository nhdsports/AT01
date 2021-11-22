package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3S_LoginPage extends BasePage {

    WebDriver driver;

    By btnSignUp = By.cssSelector("form > div > div > span > span");

    public W3S_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Go to register page
    public void clickBtnRegister() {
        infoTest("Click Register button to go to W3S register page");
        driver.findElement(btnSignUp).click();
    }

}
