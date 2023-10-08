package main.root.pages;

import main.root.common.BasePageFactory;
import main.root.common.BrowserUtilities;
import main.root.common.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaintenanceUsagePage extends BasePageFactory {

    @FindBy (xpath = "//span[@class='current-breadcrumb']")
    private WebElement homeText;

    @FindBy(xpath = "//input[@name='Item_Code']")
    private WebElement itemCode;

    @FindBy(xpath = "//input[@class='slds-input' and @type='url']")
    private WebElement linkField;

    @FindBy(xpath = "//textarea[@class='slds-textarea']")
    private WebElement descriptionArea;

    @FindBy(xpath = "//input[@name='First_Name']")
    private WebElement firsName;

    @FindBy(xpath = "//input[@name='Last_Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='Verify_EMail']")
    private WebElement verifyEmail;

    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    private WebElement flagDrop;

    @FindBy(xpath = "//li[@data-dial-code='383']")
    private WebElement selectKosovo;

    @FindBy(xpath = "//input[@data-id='countryPhone']")
    private WebElement numberField;

    @FindBy(xpath = "//input[@name='Street_Address_1']")
    private WebElement streetAddress;

    @FindBy(xpath = "//input[@name='Street_Address_2']")
    private WebElement secondStreetAddress;

    @FindBy(xpath = "//input[@name='City']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@name='Country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//*[contains(@name, 'FileUpload')]")
    private WebElement uploadFile;
    @FindBy(xpath = "//button[.='Done']")
    private WebElement doneBtn;
    @FindBy(xpath = "//iframe[@id='vfFrame']")
    private WebElement mainFrame;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement secondFrame;

    @FindBy(xpath = "//div[.='reCAPTCHA']/*[last()]")
    private WebElement captchaClick;

    @FindBy(xpath = "//p[contains(text(), 'Thank you for contacting us')]")
    private WebElement confirmationMessage;

    public void submitForm(){

        String emailAddress = faker.internet().emailAddress();

        WaitUtils.waitForFrameToBeAvailableAndSwitch(mainFrame);
        WaitUtils.waitForFrameToBeAvailableAndSwitch(secondFrame);
        WaitUtils.waitAndClickOnElement(captchaClick);
        BrowserUtilities.switchToParentFrame();
        BrowserUtilities.switchToParentFrame();
        uploadFile.sendKeys("/Users/macbookpro/Desktop/text.rtf");
        WaitUtils.waitAndClickOnElement(doneBtn);
        WaitUtils.waitForElementToBeInvisible(doneBtn);
        BrowserUtilities.scrollToElement(homeText);
        //I have used homeText to scroll to the top of form
        itemCode.sendKeys(faker.number().digits(5));
        linkField.sendKeys("https://service.bugaboo.com/");

        descriptionArea.sendKeys(faker.lorem().paragraph());
        firsName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(emailAddress);
        verifyEmail.sendKeys(emailAddress);
        flagDrop.click();
        selectKosovo.click();
        numberField.sendKeys("44" + faker.number().digits(6));
        streetAddress.sendKeys(faker.address().fullAddress());
        secondStreetAddress.sendKeys(faker.address().fullAddress());
        cityField.sendKeys(faker.address().city());
        BrowserUtilities.selectByVisibleText(selectCountry,"Kosovo");

    }
    public void successMessage(){

        WaitUtils.waitForElementToBeVisible(confirmationMessage);
    }

}
