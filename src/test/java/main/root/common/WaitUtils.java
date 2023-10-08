package main.root.common;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtils extends BasePageFactory{

    public static void sleepUtil(int seconds){
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitAndClickOnElement(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForElementToBeVisible(WebElement elm){
        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    public static void waitForElementToBeInvisible(WebElement elm){
        wait.until(ExpectedConditions.invisibilityOf(elm));
    }

    public static void waitForFrameToBeAvailableAndSwitch(WebElement frame){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
