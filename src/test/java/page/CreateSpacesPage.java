package page;

import ui.Button;
import ui.Text;
import ui.TextBox;

public class CreateSpacesPage extends BasePage {

    Button btnCreateSpace = new Button("css = ._OD95i");
    Button btnBlankPage = new Button("css = .col-lg-3:nth-child(3) > div");
    Button btnContinue = new Button("css = ._OD95i");
    TextBox inputNameSpace = new TextBox("css = .form-control");
    Text successMessage = new Text("css = .notification-wrapper > div > div.toast-header > .-text");

    /**
     * Verify: spaces page
     */
    public void verifySpacesPage() {
        logger.verifyTest("The page is correct by url", "https://spaces.w3schools.com/", driver.getCurrentUrl());
    }

    /**
     * Click create spaces button
     */
    public void clickBtnCreateSpace() {
        elm.waitForElement(driver, btnCreateSpace.getElm());
        btnCreateSpace.click();
    }

    /**
     * Click start with blank page button
     */
    public void clickBtnBlankPage() {
        btnBlankPage.click();
    }

    /**
     * Click continue button
     */
    public void clickBtnContinue() {
        btnContinue.click();
    }

    /**
     * Input name of spaces
     * @param value
     */
    public void inputNameSpace(String value) {
        inputNameSpace.input(value);
    }

    /**
     * Verify: spaces is success created
     */
    public void verifySpacesCreated() {
        elm.waitForElement(driver, successMessage.getElm());
        logger.verifyTest("The success created message is displayed", "Space created", successMessage.getText());
    }

}
