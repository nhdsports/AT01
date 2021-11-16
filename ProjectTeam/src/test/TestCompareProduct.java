package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CompareProduct;

public class TestCompareProduct {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        //System.setProperty("webdriver.chrome.driver", "D:\\zAppInstall\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://www.thegioididong.com/");

        // Compare
        CompareProduct compare = new CompareProduct(driver);
        compare.setInputSearch("laptop");
        compare.clickBtnSearch();
        compare.clickBtnPrice();
        compare.clickBtnUnder15M();
        compare.clickBtnResult();
        compare.clickBtnSort();
        compare.clickBtnAtoZprice();
        compare.clickBtnCompare1();
        compare.clickBtnCompare2();
        compare.clickBtnCompare3();
        compare.clickBtnCompareNow();

    }
}
