package main.root.tests;

import main.root.common.BaseClass;
import main.root.common.ConfigurationReader;
import main.root.common.WaitUtils;
import main.root.pages.ContactPage;
import main.root.pages.OrderPaymentRelatedPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OrderPaymentRelatedTest extends BaseClass {

    ContactPage contactPage = new ContactPage();
    OrderPaymentRelatedPage orderPaymentRelatedPage=new OrderPaymentRelatedPage();
   // main.root.pages.OrderPaymentRelatedPage orderPaymentRelatedPage = new main.root.pages.OrderPaymentRelatedPage();

    @BeforeMethod
    public void setUpMethod(){

        driver.get(ConfigurationReader.getProperty("bugaboo.url") +
                "/s/consumer-contact?selectedItem=Consumer_Contact_Form__c&language=en_US");
    }

    @Test
    public void orderPaymentRelatedTest(){
        Assert.assertEquals(driver.getTitle(), "Consumer Contact");
        WaitUtils.waitAndClickOnElement(contactPage.acceptCookiesBtn);
        WaitUtils.waitAndClickOnElement(contactPage.whatQuestionDrop);
        WaitUtils.waitForElementToBeVisible(contactPage.orderPayment);
        contactPage.orderPayment.click();
       contactPage.clickNextOrder();
       orderPaymentRelatedPage.submitForm();
       contactPage.clickNextOrder();
        orderPaymentRelatedPage.success();
       assertTrue(orderPaymentRelatedPage.validationMessage());
    }
}
