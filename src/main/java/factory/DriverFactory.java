package factory;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class DriverFactory {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        drivers.set(driver);
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void closeDriver() {
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        for (int i = 0; i < tabs.size(); i++) {
            drivers.get().switchTo().window(tabs.get(i));
            drivers.get().close();
        }
        drivers.remove();
    }

}
