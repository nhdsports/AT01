package page;

import ui.Button;
import ui.Text;
import ui.TextBox;

public class ProfilePage extends BasePage {

    TextBox inputFirstName = new TextBox("name = first_name");
    TextBox inputLastName = new TextBox("name = last_name");
    Button btnUpdateProfile = new Button("css = ._qyHiy > button");
    Text updateProfileSuccessMessage = new Text("css = ._2NfeO");

    /**
     * Verify: Profile page
     */
    public void verifyProfilePage() {
        logger.verifyTest("The page is correct by url", driver.getCurrentUrl(), "https://profile.w3schools.com/editprofile");
    }

    /**
     * Input first name
     * @param value
     */
    public void inputFirstName(String value) {
        inputFirstName.clear();
        inputFirstName.input(value);
    }

    /**
     * Input last name
     * @param value
     */
    public void inputLastName(String value) {
        inputLastName.clear();
        inputLastName.input(value);
    }

    /**
     * Click update profile button
     */
    public void clickBtnUpdateProfile() {
        btnUpdateProfile.click();
    }

    /**
     * Verify: update profile success
     */
    public void verifyUpdateProfileSuccess() {
        elm.waitForElement(driver, updateProfileSuccessMessage.getElm());
        String actual = updateProfileSuccessMessage.getText();
        logger.verifyTest("Success message is displayed", "Profile updated successfully", actual);
    }


}
