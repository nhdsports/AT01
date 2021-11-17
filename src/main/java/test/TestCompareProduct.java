package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CompareProduct;

public class TestCompareProduct {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.thegioididong.com/");

        // Compare
        CompareProduct compare = new CompareProduct(driver);
        compare.setInputSearch("laptop");
        compare.clickBtnSearch();
        Thread.sleep(2000);
        compare.clickBtnPrice();
        Thread.sleep(2000);
        compare.clickBtnUnder15M();
        Thread.sleep(2000);
        compare.clickBtnResult();
        Thread.sleep(2000);
        compare.clickBtnSort();
        Thread.sleep(2000);
        compare.clickBtnAtoZprice();
        Thread.sleep(2000);
        compare.clickBtnCompare(1);
        Thread.sleep(1000);
        compare.clickBtnCompare(2);
        Thread.sleep(1000);
        compare.clickBtnCompare(3);
        Thread.sleep(1000);
        compare.clickBtnCompareNow();

    }
}
