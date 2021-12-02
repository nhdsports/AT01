package page;

import ui.Button;
import ui.TextBox;

public class LoginPage extends BasePage {

    Button btnSignUp = new Button("css = form > div > div > span > span");
    TextBox inputEmail = new TextBox("name = email");
    TextBox inputPassword = new TextBox("name = current-password");
    Button btnLogin = new Button("css = button._1VfsI._OD95i");
    Button btnForgotPassword = new Button("css = ._Sg7KA > a");

    /**
     * Verify: login page
     */
    public void verifyLoginPage() {
        String expectedUrl = "https://profile.w3schools.com/login";
        String[] getUrl = driver.getCurrentUrl().split("\\?");
        String actualUrl = getUrl[0];
        logger.verifyTest("The page is correct by url", expectedUrl, actualUrl);
    }

    /**
     * Go to register page
     */
    public void clickBtnRegister() {
        btnSignUp.click();
    }

    /**
     * Input email
     */
    public void inputEmail(String email) {
        inputEmail.input(email);
    }

    /**
     * Input password
     */
    public void inputPassword(String password) {
        inputPassword.input(password);
    }

    /**
     * Click on Sign up for free button
     */
    public void clickBtnLogin() {
        btnLogin.click();
    }

    /**
     * Verify: forgot password button
     */
    public void verifyBtnForgotPassword() {
        boolean actual = elm.checkElementAvailable(driver, btnForgotPassword.getElm());
        logger.verifyTest("Verify the button is displayed", true, actual);
    }

    /**
     * Click forgot password button
     */
    public void clickBtnForgotPassword() {
        btnForgotPassword.click();
    }

}
