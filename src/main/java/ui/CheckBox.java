package ui;

public class CheckBox extends Control {

    public CheckBox(String elm) {
        super(elm);
    }

    public void click() {
        element().click();
    }
}
