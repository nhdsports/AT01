package test;

import helper.JsonHelper;
import model.User;
import org.testng.annotations.*;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;

public class RegisterTest extends BaseTest {

    private final String URL_TEST = "https://www.w3schools.com/";
    private final String JSON_TEST = "registerW3S.json";
    private final String EMAIL_TEST = "gra12345@gmail.com";
    private final int INDEX_USER_TEST = 0;

    @Test
    @Parameters({"environment"})
    public void registerTest(String environmentName) {

        HomePage home = new HomePage(driver, logger);
        LoginPage login = new LoginPage(driver, logger);
        RegisterPage register = new RegisterPage(driver, logger);

        // User user = JsonHelper.getDataByEmail(environmentName, JSON_TEST, EMAIL_TEST);
        User user = JsonHelper.getDataByIndex(environmentName, JSON_TEST, INDEX_USER_TEST);

        try {
            logger.infoLog("Navigate to W3Schools page at: " + URL_TEST);
            home.navigate(URL_TEST);

            logger.infoLog("Click on Login button");
            home.clickBtnLogin();

            logger.infoLog("Click on Register button");
            login.clickBtnRegister();

            register.verifySignUpBox();

            logger.infoLog("Input email is " + user.getEmail());
            register.inputEmail(user.getEmail());

            logger.infoLog("Input password is " + user.getPassword());
            register.inputPassword(user.getPassword());

            logger.infoLog("Click on toggle password button");
            register.toggleShowPassword();

            logger.infoLog("Click on Sign up for free button");
            register.clickBtnSignUpForFree();

            logger.infoLog("Input firstName is " + user.getFirstName());
            register.inputFirstName(user.getFirstName());

            logger.infoLog("Input lastName is " + user.getLastName());
            register.inputLastName(user.getLastName());

            logger.infoLog("Click on Continue button");
            register.clickBtnContinue();

            register.verifyEmailIsSent();
        }
        catch (Exception e) {
            logger.errorRunTest(e);
        }

    }

}