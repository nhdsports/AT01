package page;

import ui.Button;
import ui.Text;
import ui.TextBox;

public class RegisterPage extends BasePage {

    TextBox inputEmail = new TextBox("name = email");
    TextBox inputPassword = new TextBox("name = new-password");
    Button inputTogglePassword = new Button("css = span._8HgG3");
    Button btnSignUpForFree = new Button("css = button._1VfsI._OD95i");
    TextBox inputFirstName = new TextBox("name = first_name");
    TextBox inputLastName = new TextBox("name = last_name");
    Button btnContinue = btnSignUpForFree;
    Text titleVerifyEmail = new Text("css = div._MdeUd > div > div > h1");

    /**
     * Verify: Sign up box is displayed
     */
    public void verifySignUpBox() {
        boolean actualBtn = elm.compareText(driver, btnSignUpForFree.getElm(), "Sign up for free");
        logger.verifyTest("The box is displayed by Sign Up For free button", true, actualBtn);
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
     * Verify: toggle password button is displayed
     */
    public void verifyTogglePassword() {
        boolean actualBtn = elm.checkElementAvailable(driver, inputTogglePassword.getElm());
        logger.verifyTest("The button is displayed", true, actualBtn);
    }

    /**
     * Click on this button
     */
    public void clickTogglePassword() {
        for (int i = 1; i <=2; i++) {
            inputTogglePassword.click();
        }
    }

    /**
     * Click on Sign up for free button
     */
    public void clickBtnSignUpForFree() {
        btnSignUpForFree.click();
    }

    /**
     * Input first name
     */
    public void inputFirstName(String firstName) {
        inputFirstName.input(firstName);
    }

    /**
     * Input last name
     */
    public void inputLastName(String lastName) {
        inputLastName.input(lastName);
    }

    /**
     * Click continue button
     */
    public void clickBtnContinue() {
        btnContinue.click();
    }

    /**
     * Verify sent email screen is displayed
     */
    public void verifyEmailIsSent() {
        elm.sleepPage(3000);
        elm.waitForElement(driver, titleVerifyEmail.getElm());
        boolean actualVerify = elm.compareText(driver, titleVerifyEmail.getElm(), "Please verify email");
        logger.verifyTest("The sent email screen is displayed", true, actualVerify);
    }

}
