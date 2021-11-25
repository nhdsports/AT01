package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    /**
     * Wait element
     * @param driver
     * @param elm
     */
    public void waitForElement(WebDriver driver, By elm) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elm, 0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
    }

    /**
     * Sleep
     * @param timeSleep
     */
    public void sleepPage(int timeSleep) {
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check Available Element
     * @param driver
     * @param elm
     * @return
     */
    public boolean checkElementAvailable(WebDriver driver, By elm) {
        return driver.findElements(elm).size() > 0;
    }

    /**
     * Get Text of Element
     * @param driver
     * @param elm
     * @param textCompare
     * @return
     */
    public boolean compareText(WebDriver driver, By elm, String textCompare) {
        String textOfElement = driver.findElement(elm).getText().toLowerCase();
        String textVariable = textCompare.toLowerCase();
        return textOfElement.equals(textVariable);
    }

}
