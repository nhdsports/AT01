package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    // Wait Element
    public void waitForElement(WebDriver driver, By elm) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elm, 0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    // Sleep
    public void sleepPage(int timeSleep) {
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
