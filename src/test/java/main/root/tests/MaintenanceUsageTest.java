package main.root.tests;

import main.root.common.BaseClass;
import main.root.common.ConfigurationReader;
import main.root.common.WaitUtils;
import main.root.pages.ContactPage;
import main.root.pages.MaintenanceUsagePage;
import main.root.pages.OrderPaymentRelatedPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaintenanceUsageTest extends BaseClass {
    ContactPage contactPage = new ContactPage();
    OrderPaymentRelatedPage orderPaymentRelatedPage=new OrderPaymentRelatedPage();
    MaintenanceUsagePage maintenanceUsagePage=new MaintenanceUsagePage();

    @BeforeMethod
    public void setUpMethod(){

        driver.get(ConfigurationReader.getProperty("bugaboo.url") +
                "/s/consumer-contact?selectedItem=Consumer_Contact_Form__c&language=en_US");
    }

    @Test
    public void maintenanceUsageTest(){
        Assert.assertEquals(driver.getTitle(), "Consumer Contact");
        WaitUtils.waitAndClickOnElement(contactPage.acceptCookiesBtn);
        WaitUtils.waitAndClickOnElement(contactPage.whatQuestionDrop);
        WaitUtils.waitForElementToBeVisible(contactPage.maintenanceUsage);
        contactPage.maintenanceUsage.click();
        contactPage.clickNextOrder();
        maintenanceUsagePage.submitForm();
        contactPage.clickNextOrder();
        maintenanceUsagePage.successMessage();
        // assertTrue(deliveryReturnOrRefundFormPage.isThankYouMessageDisplayed());
    }

}
