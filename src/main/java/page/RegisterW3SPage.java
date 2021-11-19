package page;

import helper.JsonHelper;
import model.RegisterW3SUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.ElementHelper;

public class RegisterW3SPage {

    WebDriver driver;
    ElementHelper ws = new ElementHelper();

    By btnLogin = By.cssSelector("a#w3loginbtn");
    By btnSignUp = By.cssSelector("form > div > div > span > span");
    By inputEmail = By.cssSelector("input[name='email']");
    By inputPassword = By.cssSelector("input[name='new-password']");
    By inputTogglePassword = By.cssSelector("span._8HgG3");
    By btnSignUpForFree = By.cssSelector("button._1VfsI._OD95i");
    By inputFirstName = By.cssSelector("input[name='first_name']");
    By inputLastName = By.cssSelector("input[name='last_name']");
    By btnContinue = btnSignUpForFree;

    public RegisterW3SPage(WebDriver driver) {
        this.driver = driver;
    }

    // Run register
    public void runRegister(RegisterW3SUserModel user) {
        goToRegisterPage();
        enterInput(user);
    }

    // Get data by email from json file
    public static RegisterW3SUserModel getDataFromJsonFile(String fileName, String emailTest) {
        RegisterW3SUserModel[] registerW3SUserModels = JsonHelper.getJson(fileName);
        for (RegisterW3SUserModel registerW3SUserModel : registerW3SUserModels) {
            if (registerW3SUserModel.getEmail().equals(emailTest)) {
                return registerW3SUserModel;
            }
        }
        return null;
    }

    // Go to register page
    public void goToRegisterPage() {
        driver.findElement(btnLogin).click();
        driver.findElement(btnSignUp).click();
    }

    // Enter input and finish
    public void enterInput(RegisterW3SUserModel user) {
        driver.findElement(inputEmail).sendKeys(user.getEmail());
        driver.findElement(inputPassword).sendKeys(user.getPassword());
        for (int i = 1; i <=2; i++) {
            driver.findElement(inputTogglePassword).click();
        }
        driver.findElement(btnSignUpForFree).click();
        driver.findElement(inputFirstName).sendKeys(user.getFirstName());
        driver.findElement(inputLastName).sendKeys(user.getLastName());
        driver.findElement(btnContinue).click();
        ws.sleepPage(5000);
    }

}
