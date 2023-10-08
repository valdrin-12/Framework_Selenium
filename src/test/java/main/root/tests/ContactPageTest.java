package main.root.tests;

import main.root.common.BaseClass;
import main.root.common.BrowserUtilities;
import main.root.common.ConfigurationReader;
import main.root.common.WaitUtils;
import main.root.pages.ContactPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTest extends BaseClass {


    ContactPage contactPage = new ContactPage();

    @BeforeMethod
    public void setUpMethod(){

        driver.get(ConfigurationReader.getProperty("bugaboo.url") +
                "/s/consumer-contact?selectedItem=Consumer_Contact_Form__c&language=en_US");
    }
    @Test
    public void blankQuestionTest()  {
        Assert.assertEquals(driver.getTitle(),"Consumer Contact" );
        WaitUtils.waitAndClickOnElement(contactPage.acceptCookiesBtn);
        WaitUtils.waitForElementToBeInvisible(contactPage.acceptCookiesBtn);

        WaitUtils.waitForElementToBeVisible(contactPage.whatQuestionDrop);
        BrowserUtilities.scrollToElement(contactPage.nextBtn);
        WaitUtils.waitForElementToBeVisible(contactPage.nextBtn);
        contactPage.nextBtn.click();

        String expectedValidationMessage = "Please choose a question.";
        String actualValidationMessage = contactPage.getValidationMessageText();
        Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
    }

}
