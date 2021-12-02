package page;

import ui.Button;

public class ShopPage extends BasePage {

    Button btnProduct;

    /**
     * Click on product with product name
     * @param productName
     */
    public void clickProduct(String productName) {
        btnProduct = new Button("xpath = //a[span[contains(text(),'" + productName + "')]]");
        btnProduct.click();
    }

}
