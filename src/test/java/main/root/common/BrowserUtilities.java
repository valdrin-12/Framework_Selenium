package main.root.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtilities extends BaseClass {

    public static void selectByVisibleText(WebElement elm, String text) {
        select = new Select(elm);
        select.selectByVisibleText(text);
    }

    public static void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}