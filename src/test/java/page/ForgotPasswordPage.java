package page;

import ui.Button;
import ui.Text;
import ui.TextBox;

public class ForgotPasswordPage extends BasePage {

    TextBox inputEmail = new TextBox("css = ._IUZHq #modalusername");
    Button btnResetPassword = new Button("css = ._3ZT8m button._1VfsI");
    Text sentEmailMessage = new Text("css = ._2NfeO");

    /**
     * Verify: forgot password page
     */
    public void verifyForgotPasswordPage() {
        logger.verifyTest("The page is correct by url", "https://profile.w3schools.com/reset", driver.getCurrentUrl());
    }

    /**
     * Input email
     * @param value
     */
    public void inputEmail(String value) {
        inputEmail.input(value);
    }

    /**
     * Click reset password button
     */
    public void clickBtnResetPassword() {
        btnResetPassword.click();
    }

    /**
     * Verify: sent email mesage is displayed
     */
    public void verifyEmailIsSent() {
        elm.waitForElement(driver, sentEmailMessage.getElm());
        boolean actual = elm.checkElementAvailable(driver, sentEmailMessage.getElm());
        logger.verifyTest("The sent email screen is displayed", true, actual);
    }

}
