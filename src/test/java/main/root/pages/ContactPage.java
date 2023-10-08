package main.root.pages;

import main.root.common.BasePageFactory;
import main.root.common.BrowserUtilities;
import main.root.common.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePageFactory {
    @FindBy(xpath = "//button[@class='slds-combobox__input slds-input_faux']")
    public WebElement whatQuestionDrop;
    @FindBy(id = "combobox-button-22-1-22")
    public WebElement orderPayment;

    @FindBy(id = "combobox-button-22-4-22")
    public WebElement maintenanceUsage;
    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement acceptCookiesBtn;
    @FindBy(xpath = "//button[.='Next']")
    public WebElement nextBtn;
    @FindBy(xpath = "//span[text()='Please choose a question.']")
    private WebElement validationMessage;

    public void clickNextOrder() {
        BrowserUtilities.scrollToElement(nextBtn);
        WaitUtils.waitForElementToBeVisible(nextBtn);
        nextBtn.click();
    }
    public String getValidationMessageText() {//this is used for assertion in ContactPageTest
        WaitUtils.waitForElementToBeVisible(validationMessage);
        return validationMessage.getText();
    }
}
