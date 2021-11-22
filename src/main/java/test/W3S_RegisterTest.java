package test;

import helper.JsonHelper;
import org.testng.annotations.*;
import page.BasePage;
import page.W3S_HomePage;
import page.W3S_LoginPage;
import page.W3S_RegisterPage;

public class W3S_RegisterTest extends BaseTest {

    @Test
    public void registerTest() {
        try {
            BasePage page = new BasePage();
            JsonHelper json = new JsonHelper();
            W3S_HomePage home = new W3S_HomePage(driver);
            W3S_LoginPage login = new W3S_LoginPage(driver);
            W3S_RegisterPage register = new W3S_RegisterPage(driver);
            // --------
            page.infoTest("Navigate to W3S home page");
            driver.get("https://www.w3schools.com/");
            home.clickBtnLogin();
            login.clickBtnRegister();
            register.registerTest(json.getDataFromJsonFile("registerW3S.json", "nhdvnz7@gmail.com"));
            System.out.println("-- Done test");
        }
        catch (Exception e) {
            System.out.println("-- Stop test!");
        }
    }

}