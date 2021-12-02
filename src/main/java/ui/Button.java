package ui;

public class Button extends Control {

    public Button(String elm) {
        super(elm);
    }

    /**
     * Click
     */
    public void click() {
        element().click();
    }

    /**
     * Get text
     */
    public void getText() {
        element().getText();
    }

}
