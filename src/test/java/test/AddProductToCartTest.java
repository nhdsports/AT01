package test;

import helper.ElementHelper;
import helper.JsonHelper;
import model.Product;
import org.testng.annotations.Test;
import page.HomePage;
import page.ShopPage;
import page.ShopProductPage;

public class AddProductToCartTest extends BaseTest {

    private final String JSON_TEST = "products.json";
    private final String NAME_PRODUCT_TEST = "Unisex Eco Hoodie Black";

    @Test
    public void AddProductToCart() {

        HomePage homePage = new HomePage();
        ShopPage shopPage = new ShopPage();
        ShopProductPage productPage = new ShopProductPage();

        Product product = JsonHelper.getProductByName(JSON_TEST, NAME_PRODUCT_TEST);

        logger.infoLog("Navigate to W3Schools page at: " + URL_TEST);
        homePage.navigate(URL_TEST);
        logger.infoLog("Verify home page");
        homePage.verifyHomePage(URL_TEST);
        logger.infoLog("Click on Shop button");
        homePage.clickBtnShop();

        logger.infoLog("Switch to Shop page");
        ElementHelper.switchToTab(1);

        logger.infoLog("Click on '" + product.getName() + "' product");
        shopPage.clickProduct(product.getName());

        logger.infoLog("Verify the title of product");
        productPage.verifyProductTitle(product.getName());
        if (product.getSize() != "") {
            logger.infoLog("Select size is " + product.getSize());
            productPage.selectSize(product.getSize());
        }
        logger.infoLog("Input quantity is " + product.getQuantity());
        productPage.inputQuantity(product.getQuantity());
        logger.infoLog("Click on Add to cart button");
        productPage.clickBtnAddToCart();
        logger.infoLog("Verify product is success added");
        productPage.verifyAddedMessage();
        logger.infoLog("Click on View cart button");
        productPage.clickBtnViewCart();
        logger.infoLog("Verify product is displayed in the cart");
        productPage.verifyProduct(product.getName());

    }

}
