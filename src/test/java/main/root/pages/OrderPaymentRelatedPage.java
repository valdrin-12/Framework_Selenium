package main.root.pages;

import main.root.common.BasePageFactory;
import main.root.common.BrowserUtilities;
import main.root.common.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPaymentRelatedPage extends BasePageFactory {


    @FindBy (xpath = "//span[@class='current-breadcrumb']")
    private WebElement homeText;
    @FindBy (xpath = "//input[@class='slds-input' and @type='url']")
    private WebElement linkBox;

    @FindBy (xpath = "//textarea[@class='slds-textarea']")
    private WebElement descriptionBox;

    @FindBy (xpath = "//input[@name='First_Name']")
    private WebElement firstName;

    @FindBy (xpath = "//input[@name='Last_Name']")
    private WebElement lastName;

    @FindBy (xpath = "//input[@name='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Verify_EMail']")
    private WebElement verifyEmailField;

    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    private WebElement selectPrefix;

    @FindBy(xpath = "//li[@data-dial-code='383']")
    private WebElement selectKosova;

    @FindBy(xpath = "//input[@data-id='countryPhone']")
    private WebElement numberField;

    @FindBy(xpath = "//input[@name='Street_Address_1']")
    private WebElement firstAddress;

    @FindBy(xpath = "//input[@name='Street_Address_2']")
    private WebElement secondAddress;

    @FindBy(xpath = "//input[@name='City']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@class='slds-select']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@name='Postal_Code']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[contains(@name, 'FileUpload')]")
    private WebElement uploadFiles;

    @FindBy(xpath = "//button[.='Done']")
    private WebElement doneBtn;

    @FindBy(xpath = "//iframe[@id='vfFrame']")
    private WebElement mainFrame;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement secondFrame;

    @FindBy(xpath = "//div[.='reCAPTCHA']/*[last()]")
    private WebElement captchaCheck;

    @FindBy(xpath = "//p[contains(text(), 'Thank you for contacting us')]")
    private WebElement confirmMessage;

    public void submitForm(){

        String emailAddress = faker.internet().emailAddress();

        WaitUtils.waitForFrameToBeAvailableAndSwitch(mainFrame);
        WaitUtils.waitForFrameToBeAvailableAndSwitch(secondFrame);
        WaitUtils.waitAndClickOnElement(captchaCheck);
        BrowserUtilities.switchToParentFrame();
        BrowserUtilities.switchToParentFrame();
        //WaitUtils.waitForElementToBeVisible(linkBox);
        uploadFiles.sendKeys("/Users/macbookpro/Desktop/text.rtf");
        WaitUtils.waitAndClickOnElement(doneBtn);
        WaitUtils.waitForElementToBeInvisible(doneBtn);
        BrowserUtilities.scrollToElement(homeText);
        linkBox.sendKeys("https://service.bugaboo.com/");

        descriptionBox.sendKeys(faker.shakespeare().asYouLikeItQuote());
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        emailField.sendKeys(emailAddress);
        verifyEmailField.sendKeys(emailAddress);
        selectPrefix.click();
        selectKosova.click();
        numberField.sendKeys("44" + faker.number().digits(6));
        firstAddress.sendKeys(faker.address().fullAddress());
        secondAddress.sendKeys(faker.address().fullAddress());
        cityField.sendKeys(faker.address().city());
        BrowserUtilities.selectByVisibleText(countryDropdown,"Kosovo");
        postalCode.sendKeys(faker.address().zipCode());

    }

    public void success(){

        WaitUtils.waitForElementToBeVisible(confirmMessage);
    }
    public boolean validationMessage(){
        WaitUtils.waitForElementToBeVisible(confirmMessage);
        return confirmMessage.isDisplayed();
    }
}
