package page;

import ui.Button;
import ui.Selector;
import ui.Text;
import ui.TextBox;

public class ShopProductPage extends BasePage {

    Text productTitle = new Text("css = .product-single__title");
    Selector selectSize = new Selector("id = SingleOptionSelector-0");
    TextBox inputQuantity = new TextBox("name = quantity");
    Button btnAddToCart = new Button("name = add");
    Text addedMessageBox = new Text("css = .cart-popup-wrapper[tabindex]");
    Button btnViewCart = new Button("css = .cart-popup__cta-link");
    Text productTitleCart;

    /**
     * Verify: title of product
     * @param productName
     */
    public void verifyProductTitle(String productName) {
        logger.verifyTest("The title is the same product name", productName, productTitle.getText());
    }

    /**
     * Select size
     * @param size
     */
    public void selectSize(String size) {
        selectSize.selectByValue(size);
    }

    /**
     * Input quantity
     * @param quantity
     */
    public void inputQuantity(int quantity) {
        inputQuantity.clear();
        inputQuantity.input("" + quantity);
    }

    /**
     * Click Add to cart button
     */
    public void clickBtnAddToCart() {
        btnAddToCart.click();
    }

    /**
     * Verify Added to cart message
     */
    public void verifyAddedMessage() {
        elm.waitForElement(driver, addedMessageBox.getElm());
        boolean actual = elm.checkElementAvailable(driver, addedMessageBox.getElm());
        logger.verifyTest("The added to cart message box is displayed", true, actual);
    }

    /**
     * Click View cart button
     */
    public void clickBtnViewCart() {
        btnViewCart.click();
    }

    /**
     * Verify product
     */
    public void verifyProduct(String productName) {
        productTitleCart = new Text("xpath = //a[contains(text(),'" + productName + "')]");
        boolean actual = elm.checkElementAvailable(driver, productTitleCart.getElm());
        logger.verifyTest("The product box is displayed in product list", true, actual);
    }

}
