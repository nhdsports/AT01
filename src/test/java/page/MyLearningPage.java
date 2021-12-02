package page;

import ui.Button;

public class MyLearningPage extends BasePage {

    Button btnSetting = new Button("xpath = //a[contains(text(), 'Settings')]");
    Button btnSpaces = new Button("xpath = //a[contains(text(), 'Spaces')]");

    /**
     * Verify: my learning page
     */
    public void verifyMyLearningPage() {
        elm.waitForElement(driver, btnSetting.getElm());
        logger.verifyTest("The page is correct by url", driver.getCurrentUrl(), "https://my-learning.w3schools.com/");
    }

    /**
     * Verify: setting button
     */
    public void verifySettingButton() {
        boolean actual = elm.checkElementAvailable(driver, btnSetting.getElm());
        logger.verifyTest("The button is displayed", true, actual);
    }

    /**
     * Click settings
     * button
     */
    public void clickBtnSetting() {
        btnSetting.click();
    }

    /**
     * Click spaces
     * button
     */
    public void clickBtnSpaces() {
        btnSpaces.click();
    }

}
