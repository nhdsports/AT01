package test;

import helper.JsonHelper;
import model.User;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {

    private final String JSON_TEST = "users.json";
    private final String EMAIL_TEST = "haidanga3txqt@gmail.com";

    @Test
    public void ForgotPassword() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        User user = JsonHelper.getUserByEmail(JSON_TEST, EMAIL_TEST);

        logger.infoLog("Navigate to W3Schools page at: " + URL_TEST);
        homePage.navigate(URL_TEST);
        logger.infoLog("Verify home page");
        homePage.verifyHomePage(URL_TEST);
        logger.infoLog("Click on Login button");
        homePage.clickBtnLogin();

        logger.infoLog("Verify login page");
        loginPage.verifyLoginPage();
        logger.infoLog("Verify forgot password button");
        loginPage.verifyBtnForgotPassword();
        logger.infoLog("Click on forgot password button");
        loginPage.clickBtnForgotPassword();

        logger.infoLog("Verify forgot password page");
        forgotPasswordPage.verifyForgotPasswordPage();
        logger.infoLog("Input email is " + user.getEmail());
        forgotPasswordPage.inputEmail(user.getEmail());
        logger.infoLog("Click on reset password button");
        forgotPasswordPage.clickBtnResetPassword();
        logger.infoLog("Verify that email is sent");
        forgotPasswordPage.verifyEmailIsSent();

    }

}
