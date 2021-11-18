package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import other.WaitAndSleep;

public class CompareProduct {

    WebDriver driver;
    WaitAndSleep ws = new WaitAndSleep();

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
        search(keyword);
        filter();
        sort();
        compare();
    }

    // Search
    public void search(String keyword) {
        ws.waitForElement(driver, inputSearch);
        driver.findElement(inputSearch).sendKeys(keyword);
        driver.findElement(btnSearch).click();
    }

    // Filter
    public void filter() {
        ws.waitForElement(driver, btnPrice);
        ws.waitForElement(driver, btnUnder15M);
        ws.waitForElement(driver, btnResult);
        driver.findElement(btnPrice).click();
        driver.findElement(btnUnder15M).click();
        driver.findElement(btnResult).click();
    }

    // Sort
    public void sort() {
        ws.waitForElement(driver, btnSort);
        ws.waitForElement(driver, btnPriceAtoZ);
        driver.findElement(btnSort).click();
        driver.findElement(btnPriceAtoZ).click();
        ws.sleepPage(1000);
    }

    // Click add compare on product
    public void compare() {
        for (int i = 1; i <= 3; i++) {
            setBtnAddCompare(i);
            ws.waitForElement(driver, btnAddCompare);
            driver.findElement(btnAddCompare).click();
        }
        ws.waitForElement(driver, btnCompareNow);
        driver.findElement(btnCompareNow).click();
        ws.sleepPage(3000);
    }

}