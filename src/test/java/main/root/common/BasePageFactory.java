package main.root.common;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {

    protected static WebDriver driver = Driver.getDriver();
    protected static Faker faker = new Faker();
    protected static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public BasePageFactory(){
        PageFactory.initElements(driver, this);
    }
}
