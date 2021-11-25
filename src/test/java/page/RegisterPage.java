package page;

import helper.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    WebDriver driver;
    LogHelper logger;

    By inputEmail = By.cssSelector("input[name='email']");
    By inputPassword = By.cssSelector("input[name='new-password']");
    By inputTogglePassword = By.cssSelector("span._8HgG3");
    By btnSignUpForFree = By.cssSelector("button._1VfsI._OD95i");
    By inputFirstName = By.cssSelector("input[name='first_name']");
    By inputLastName = By.cssSelector("input[name='last_name']");
    By btnContinue = btnSignUpForFree;
    By titleVerifyEmail = By.cssSelector("div._MdeUd > div > div > h1");

    public RegisterPage(WebDriver driver, LogHelper logger) {
        this.driver = driver;
        this.logger = logger;
    }

    /**
     * Verify: Sign up box is displayed
     */
    public void verifySignUpBox() {
        boolean actualBtn = elm.compareText(driver, btnSignUpForFree, "Sign up for free");
        logger.verifyTest("Verify Sign Up For free button is displayed", true, actualBtn, "This button is displayed", "This button is not displayed");
    }

    /**
     * Input email
     * @param email
     */
    public void inputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    /**
     * Input password
     * @param password
     */
    public void inputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    /**
     * Verify: toggle password button is displayed
     * Click on this button
     */
    public void toggleShowPassword() {
        boolean actualBtn = elm.checkElementAvailable(driver, inputTogglePassword);
        logger.verifyTest("Verify toggle password button is displayed", true, actualBtn, "This button is displayed", "This button is not displayed");
        logger.infoLog("Click on toggle password button");
        for (int i = 1; i <=2; i++) {
            driver.findElement(inputTogglePassword).click();
        }
    }

    /**
     * Click on Sign up for free button
     */
    public void clickBtnSignUpForFree() {
        driver.findElement(btnSignUpForFree).click();
    }

    /**
     * Input first name
     * @param firstName
     */
    public void inputFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    /**
     * Input last name
     * @param lastName
     */
    public void inputLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    /**
     * Click continue button
     */
    public void clickBtnContinue() {
        driver.findElement(btnContinue).click();
    }

    /**
     * Verify sent email screen is displayed
     */
    public void verifyEmailIsSent() {
        elm.sleepPage(3000);
        elm.waitForElement(driver, titleVerifyEmail);
        boolean actualVerify = elm.compareText(driver, titleVerifyEmail, "Please verify email");
        logger.verifyTest("Verify sent email screen is displayed", true, actualVerify, "This screen is displayed", "This screen is not displayed");
    }

}
