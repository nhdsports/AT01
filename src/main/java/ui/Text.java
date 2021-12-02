package ui;

public class Text extends Control {

    public Text(String elm) {
        super(elm);
    }

    /**
     * Get text
     */
    public String getText() {
        return element().getText();
    }

}
