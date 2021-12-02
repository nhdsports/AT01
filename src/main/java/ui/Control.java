package ui;

import factory.DriverFactory;
import helper.ElementHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Control {

    private String elm;

    /**
     * Driver current
     */
    public WebElement element() {
        return DriverFactory.getDriver().findElement(getElm());
    }

    /**
     * Get element
     * @return
     */
    public By getElm() {
        return ElementHelper.checkElement(elm);
    }

}
