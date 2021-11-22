package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3S_HomePage extends BasePage {

    WebDriver driver;

    By btnLogin = By.cssSelector("a#w3loginbtn");

    public W3S_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Go to login page
    public void clickBtnLogin() {
        infoTest("Click Login button to go to W3S login page");
        driver.findElement(btnLogin).click();
    }

}
