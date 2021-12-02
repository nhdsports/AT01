package ui;

import org.openqa.selenium.Keys;

public class TextBox extends Control {

    public TextBox(String elm) {
        super(elm);
    }

    /**
     * Input value and keyboard
     */
    public void input(String value) {
        element().sendKeys(value);
    }
    public void input(Keys key) {
        element().sendKeys(key);
    }


    /**
     * Clear input
     */
    public void clear() {
        element().clear();
    }
}
