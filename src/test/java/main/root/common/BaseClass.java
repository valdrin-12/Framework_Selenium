package main.root.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public abstract class BaseClass {

    protected static WebDriver driver = Driver.getDriver();
    protected static Select select;

    @BeforeSuite
    public void setUp(){
        driver  = Driver.getDriver();
    }

    @AfterSuite
    public void tearDown(){
        Driver.closeDriver();
    }
}

