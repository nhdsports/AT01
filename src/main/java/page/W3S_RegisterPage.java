package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3S_RegisterPage extends BasePage {

    WebDriver driver;

    By inputEmail = By.cssSelector("input[name='email']");
    By inputPassword = By.cssSelector("input[name='new-password']");
    By inputTogglePassword = By.cssSelector("span._8HgG3");
    By btnSignUpForFree = By.cssSelector("button._1VfsI._OD95i");
    By inputFirstName = By.cssSelector("input[name='first_name']");
    By inputLastName = By.cssSelector("input[name='last_name']");
    By btnContinue = btnSignUpForFree;

    public W3S_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Register process
    public void registerTest(User user) {

        infoTest("Input email is " + user.getEmail());
        driver.findElement(inputEmail).sendKeys(user.getEmail());

        infoTest("Input password is " + user.getPassword());
        driver.findElement(inputPassword).sendKeys(user.getPassword());

        infoTest("Toggle click show password");
        for (int i = 1; i <=2; i++) {
            driver.findElement(inputTogglePassword).click();
        }

        infoTest("Click Sign up for free button");
        driver.findElement(btnSignUpForFree).click();

        infoTest("Input email is " + user.getFirstName());
        driver.findElement(inputFirstName).sendKeys(user.getFirstName());

        infoTest("Input email is " + user.getLastName());
        driver.findElement(inputLastName).sendKeys(user.getLastName());

        infoTest("Click Continue button");
        driver.findElement(btnContinue).click();

        ws.sleepPage(5000);

    }

}
