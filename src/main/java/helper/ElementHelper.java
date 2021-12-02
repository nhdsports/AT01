package helper;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ElementHelper {

    /**
     * Get type element
     * @return
     */
    public static By checkElement(String elm) {
        String[] split = elm.split("=");
        String by = split[0].trim().toLowerCase();
        String selector = split[1].trim();
        switch (by) {
            case "id":
                return By.id(selector);
            case "class":
                return By.className(selector);
            case "name":
                return By.name(selector);
            case "css":
                return By.cssSelector(selector);
            case "xpath":
                return By.xpath(selector);
            case "tag":
                return By.tagName(selector);
            default:
                return null;
        }
    }

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

    /**
     * Switch to tab
     */
    public static void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(tabs.get(index));
    }

}
