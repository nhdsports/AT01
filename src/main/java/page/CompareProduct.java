package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareProduct {

    final private int TIME_WAIT = 10;   // s
    final private int TIME_SLEEP = 3000;    //ms

    WebDriver driver;

    By inputSearch = By.id("skw");
    By btnSearch = By.cssSelector("form > button[type='submit']");
    By btnPrice = By.cssSelector(".filter-item.warpper-price-outside > .filter-item__title");
    By btnUnder15M = By.cssSelector(".filter-show > .filter-list.price > a[data-id='768']");
    By btnResult = By.cssSelector(".filter-item.warpper-price-outside > .filter-show > .filter-button > a.btn-filter-readmore");
    By btnSort = By.cssSelector("p.click-sort");
    By btnPriceAtoZ = By.cssSelector(".sort-select-main a[data-id='2']");
    By btnAddCompare;
    By btnCompareNow = By.cssSelector(".closecompare > a.doss");

    public CompareProduct(WebDriver driver) {
        this.driver = driver;
    }

    // Set btnAddCompare with id product
    private void setBtnAddCompare(int idProduct) {
        btnAddCompare = By.cssSelector(".listproduct > li[data-index='" + idProduct + "'] > .item-ss");
    }

    // Run Compare Product
    public void runCompareProduct(String keyword) {

        waitForElement(inputSearch);
        driver.findElement(inputSearch).sendKeys(keyword);

        waitForElement(btnSearch);
        driver.findElement(btnSearch).click();

        waitForElement(btnPrice);
        driver.findElement(btnPrice).click();

        waitForElement(btnUnder15M);
        driver.findElement(btnUnder15M).click();

        waitForElement(btnResult);
        driver.findElement(btnResult).click();

        waitForElement(btnSort);
        driver.findElement(btnSort).click();

        waitForElement(btnPriceAtoZ);
        driver.findElement(btnPriceAtoZ).click();

        sleepPage();
        for (int i = 1; i <= 3; i++) {
            setBtnAddCompare(i);
            waitForElement(btnAddCompare);
            driver.findElement(btnAddCompare).click();
        }

        waitForElement(btnCompareNow);
        driver.findElement(btnCompareNow).click();

        sleepPage();
    }

    // Wait
    public void waitForElement(By elm) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    // Sleep
    public void sleepPage() {
        try {
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}