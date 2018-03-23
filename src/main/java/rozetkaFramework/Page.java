package rozetkaFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickOnWebElement(WebElement webElement) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

}
