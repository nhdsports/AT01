package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import other.DataForRegisterW3S;
import other.WaitAndSleep;

import java.util.List;

public class RegisterW3S {

    List list;

    WebDriver driver;
    WaitAndSleep ws = new WaitAndSleep();

    By btnLogin = By.cssSelector("a#w3loginbtn");
    By btnSignUp = By.cssSelector("form > div > div > span > span");
    By inputEmail = By.cssSelector("input[name='email']");
    By inputPassword = By.cssSelector("input[name='new-password']");
    By inputTogglePassword = By.cssSelector("span._8HgG3");
    By btnSignUpForFree = By.cssSelector("button._1VfsI._OD95i");
    By inputFirstName = By.cssSelector("input[name='first_name']");
    By inputLastName = By.cssSelector("input[name='last_name']");
    By btnContinue = btnSignUpForFree;

    public RegisterW3S(WebDriver driver) {
        this.driver = driver;
    }

    // Run Register
    public void runRegister() {
        getDataFromJsonFile();
        goToRegisterPage();
        inputEmailAndPassword();
        inputName();
    }

    // Get data from json file
    public void getDataFromJsonFile() {
        DataForRegisterW3S data = new DataForRegisterW3S();
        data.convertJsonToObj();
        list = data.list;
        System.out.println("**************\n" + list + "\n**************");
    }

    // Go to Register
    public void goToRegisterPage() {
        ws.waitForElement(driver, btnLogin);
        driver.findElement(btnLogin).click();
        ws.waitForElement(driver, btnSignUp);
        driver.findElement(btnSignUp).click();
    }

    // Input Email & Password
    public void inputEmailAndPassword() {
        ws.waitForElement(driver, inputEmail);
        ws.waitForElement(driver, inputPassword);
        ws.waitForElement(driver, inputTogglePassword);
        ws.waitForElement(driver, btnSignUpForFree);
        driver.findElement(inputEmail).sendKeys((CharSequence) list.get(0));
        driver.findElement(inputPassword).sendKeys((CharSequence) list.get(1));
        for (int i = 1; i <=2; i++) {
            driver.findElement(inputTogglePassword).click();
        }
        driver.findElement(btnSignUpForFree).click();
    }

    // Input Name
    public void inputName() {
        ws.waitForElement(driver, inputFirstName);
        ws.waitForElement(driver, inputLastName);
        ws.waitForElement(driver, btnContinue);
        driver.findElement(inputFirstName).sendKeys((CharSequence) list.get(2));
        driver.findElement(inputLastName).sendKeys((CharSequence) list.get(3));
        driver.findElement(btnContinue).click();
        ws.sleepPage(5000);
    }

}
