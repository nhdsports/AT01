package test;

import helper.JsonHelper;
import model.User;
import org.testng.annotations.Test;
import page.CreateSpacesPage;
import page.HomePage;
import page.LoginPage;
import page.MyLearningPage;

public class CreateSpacesTest extends BaseTest {

    private final String JSON_TEST = "users.json";
    private final String EMAIL_TEST = "haidanga3txqt@gmail.com";
    private final String NAME_OF_SPACES = "nhd8872zz";

    @Test
    public void CreateSpaces() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyLearningPage myLearningPage = new MyLearningPage();
        CreateSpacesPage createSpacesPage = new CreateSpacesPage();

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

        logger.infoLog("Verify my learning page");
        myLearningPage.verifyMyLearningPage();
        logger.infoLog("Click on Spaces button");
        myLearningPage.clickBtnSpaces();

        logger.infoLog("Verify spaces page");
        createSpacesPage.verifySpacesPage();
        logger.infoLog("Click on Create a space button");
        createSpacesPage.clickBtnCreateSpace();
        logger.infoLog("Click on Start with a blank page button");
        createSpacesPage.clickBtnBlankPage();
        logger.infoLog("Click on Continue button");
        createSpacesPage.clickBtnContinue();
        logger.infoLog("Input name of spaces is " + NAME_OF_SPACES);
        createSpacesPage.inputNameSpace(NAME_OF_SPACES);
        logger.infoLog("Click on Continue button");
        createSpacesPage.clickBtnContinue();
        logger.infoLog("Verify that spaces is created successfully");
        createSpacesPage.verifySpacesCreated();

    }

}
