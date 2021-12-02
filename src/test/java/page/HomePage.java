package page;

import ui.Button;

import java.util.ArrayList;

public class HomePage extends BasePage {

    Button btnLogin = new Button("css = a#w3loginbtn");
    Button btnShop = new Button("css = footer .tut-button");

    /**
     * Navigate to home page
     * @param url
     */
    public void navigate(String url) {
        driver.get(url);
    }

    /**
     * Verify: home page is correct and login button is displayed
     * @param url
     */
    public void verifyHomePage(String url) {
        logger.verifyTest("The page is correct by url", url, driver.getCurrentUrl());
    }

    /**
     * Step: click login button
     */
    public void clickBtnLogin() {
        btnLogin.click();
    }

    /**
     * Step: click login button
     */
    public void clickBtnShop() {
        btnShop.click();
    }

}
