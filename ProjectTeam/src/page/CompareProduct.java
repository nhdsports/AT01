package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompareProduct {

    WebDriver driver;

    By inputSearch = By.id("skw");
    By btnSearch = By.cssSelector("form > button[type='submit']");
    By btnPrice = By.cssSelector(".filter-item.warpper-price-outside > .filter-item__title");
    By btnUnder15M = By.cssSelector(".filter-show > .filter-list.price > a[data-id='768']");
    By btnResult = By.cssSelector(".filter-item.warpper-price-outside > .filter-show > .filter-button > a.btn-filter-readmore");
    By btnSort = By.cssSelector("p.click-sort");
    By btnAtoZprice = By.cssSelector(".sort-select-main a[data-id='2']");
    By btnCompare1 = By.cssSelector(".listproduct > li[data-index='1'] > .item-ss");
    By btnCompare2 = By.cssSelector(".listproduct > li[data-index='2'] > .item-ss");
    By btnCompare3 = By.cssSelector(".listproduct > li[data-index='3'] > .item-ss");
    By btnCompareNow = By.cssSelector(".closecompare > a.doss");

    public CompareProduct(WebDriver driver) {
        this.driver = driver;
    }

    // Input search keyword
    public void setInputSearch(String keyword) {
        driver.findElement(inputSearch).sendKeys(keyword);
    }

    // Click search button
    public void clickBtnSearch() {
        driver.findElement(btnSearch).click();
    }

    // Click price button
    public void clickBtnPrice() {
        driver.findElement(btnPrice).click();
    }

    // Click under 15M price button
    public void clickBtnUnder15M() {
        driver.findElement(btnUnder15M).click();
    }

    // Click result button
    public void clickBtnResult() {
        driver.findElement(btnResult).click();
    }

    // Click sort button
    public void clickBtnSort() {
        driver.findElement(btnSort).click();
    }

    // Click A-Z price button
    public void clickBtnAtoZprice() {
        driver.findElement(btnAtoZprice).click();
    }

    // Click compare button of product 1
    public void clickBtnCompare1() {
        driver.findElement(btnCompare1).click();
    }

    // Click compare button of product 2
    public void clickBtnCompare2() {
        driver.findElement(btnCompare2).click();
    }

    // Click compare button of product 3
    public void clickBtnCompare3() {
        driver.findElement(btnCompare3).click();
    }

    // Click compare now button
    public void clickBtnCompareNow() {
        driver.findElement(btnCompareNow).click();
    }

}
