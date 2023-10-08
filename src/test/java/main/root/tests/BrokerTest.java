package main.root.tests;


import main.root.common.BaseClass;
import main.root.common.ConfigurationReader;
import main.root.common.WaitUtils;
import main.root.pages.BrokersPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrokerTest extends BaseClass {

    private BrokersPage brokersPage = new BrokersPage();

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("yavlena.url") +"/en/broker/");
    }

    @Test
    public void searchAndVerifyBrokers(){


        Assert.assertEquals(driver.getTitle(), "Our team | Yavlena");

        brokersPage.setUpBrokersPage();

        String[] brokersToVerify = {"Aleksandar Andreev", "Anna Peycheva", "Anas Hamid"};

        for(String broker : brokersToVerify) {

            brokersPage.searchForBroker(broker);
           String expectedName = brokersPage.brokerNameForSingleBroker.getText();
           String expectedFirstPhoneNumber = brokersPage.firstNumberBroker.getText();
           String expectedSecondPhoneNumber = brokersPage.secondNumberBroker.getText();
           String expectedProperties = brokersPage.propertiesForBroker.getText();

            assertEquals(brokersPage.brokerNameHomePage.getText(), expectedName,"Broker name does not match");
            assertEquals(brokersPage.firstNumberHomePage.getText(), expectedFirstPhoneNumber,"Broker first PhoneNumber does not match");
            assertEquals(brokersPage.secondNumberHomePage.getText(), expectedSecondPhoneNumber,"Broker PhoneNumber does not match");
            assertEquals(brokersPage.propertiesHomePage.getText(), expectedProperties,"Broker Properties does not match");
            WaitUtils.sleepUtil(3);
            brokersPage.clearBtn.click();
            WaitUtils.sleepUtil(3);
        }
    }
}

