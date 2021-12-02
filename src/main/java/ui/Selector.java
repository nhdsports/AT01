package ui;

import org.openqa.selenium.support.ui.Select;

public class Selector extends Control {

    Select select;

    public Selector(String elm) {
        super(elm);
    }

    /**
     * Selector option
     */
    public void selectByValue(String value) {
        select = new Select(element());
        select.selectByValue(value);
    }
    public void selectByText(String text) {
        select = new Select(element());
        select.selectByVisibleText(text);
    }
    public void selectByIndex(int index) {
        select = new Select(element());
        select.selectByIndex(index);
    }

}
