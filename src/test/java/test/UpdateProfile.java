package test;

import helper.JsonHelper;
import model.User;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.MyLearningPage;
import page.ProfilePage;

public class UpdateProfile extends BaseTest {

    private final String JSON_TEST = "users.json";
    private final String EMAIL_TEST = "haidanga3txqt@gmail.com";

    @Test
    public void UpdateProfile() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyLearningPage myLearningPage = new MyLearningPage();
        ProfilePage profilePage = new ProfilePage();

        User user = JsonHelper.getUserByEmail(JSON_TEST, EMAIL_TEST);

        logger.infoLog("Navigate to W3Schools page at: " + URL_TEST);
        homePage.navigate(URL_TEST);
        logger.infoLog("Verify home page");
        homePage.verifyHomePage(URL_TEST);
        logger.infoLog("Click on Login button");
        homePage.clickBtnLogin();

        logger.infoLog("Verify login page");
        loginPage.verifyLoginPage();
        logger.infoLog("Input Email is " + user.getEmail());
        loginPage.inputEmail(user.getEmail());
        logger.infoLog("Input Password is " + user.getPassword());
        loginPage.inputPassword(user.getPassword());
        logger.infoLog("Click on Login button");
        loginPage.clickBtnLogin();

        logger.infoLog("Verify My learning page");
        myLearningPage.verifyMyLearningPage();
        logger.infoLog("Verify Settings button");
        myLearningPage.verifySettingButton();
        logger.infoLog("Click on Settings button");
        myLearningPage.clickBtnSetting();

        logger.infoLog("Verify profile page");
        profilePage.verifyProfilePage();
        logger.infoLog("Input firstName is " + user.getFirstName());
        profilePage.inputFirstName(user.getFirstName());
        logger.infoLog("Input lastName is " + user.getLastName());
        profilePage.inputLastName(user.getLastName());
        logger.infoLog("Click on Update profile button");
        profilePage.clickBtnUpdateProfile();
        logger.infoLog("Verify that profile is updated successfully");
        profilePage.verifyUpdateProfileSuccess();

    }

}