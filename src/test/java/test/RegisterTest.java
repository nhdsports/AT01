package test;

import helper.JsonHelper;
import model.User;
import org.testng.annotations.*;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;

public class RegisterTest extends BaseTest {

    private final String JSON_TEST = "users.json";
    private final String EMAIL_TEST = "gra12345@gmail.com";
    private final int INDEX_USER_TEST = 0;

    @Test
    public void registerTest() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();

        // User user = JsonHelper.getDataByEmail(JSON_TEST, EMAIL_TEST);
        User user = JsonHelper.getUserByIndex(JSON_TEST, INDEX_USER_TEST);

        logger.infoLog("Navigate to W3Schools page at: " + URL_TEST);
        homePage.navigate(URL_TEST);
        logger.infoLog("Verify home page");
        homePage.verifyHomePage(URL_TEST);
        logger.infoLog("Click on Login button");
        homePage.clickBtnLogin();

        logger.infoLog("Verify login page");
        loginPage.verifyLoginPage();
        logger.infoLog("Click on Register button");
        loginPage.clickBtnRegister();

        logger.infoLog("Verify sign up box");
        registerPage.verifySignUpBox();
        logger.infoLog("Input email is " + user.getEmail());
        registerPage.inputEmail(user.getEmail());
        logger.infoLog("Input password is " + user.getPassword());
        registerPage.inputPassword(user.getPassword());
        logger.infoLog("Verify toggle password button");
        registerPage.verifyTogglePassword();
        logger.infoLog("Click on toggle password button");
        registerPage.clickTogglePassword();
        logger.infoLog("Click on Sign up for free button");
        registerPage.clickBtnSignUpForFree();
        logger.infoLog("Input firstName is " + user.getFirstName());
        registerPage.inputFirstName(user.getFirstName());
        logger.infoLog("Input lastName is " + user.getLastName());
        registerPage.inputLastName(user.getLastName());
        logger.infoLog("Click on Continue button");
        registerPage.clickBtnContinue();
        logger.infoLog("Verify that email is sent");
        registerPage.verifyEmailIsSent();

    }

}