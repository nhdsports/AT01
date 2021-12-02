package page;

import factory.DriverFactory;
import factory.LoggerFactory;
import helper.ElementHelper;
import helper.LogHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver = DriverFactory.getDriver();
    LogHelper logger = LoggerFactory.getLogger();

    ElementHelper elm = new ElementHelper();

}
