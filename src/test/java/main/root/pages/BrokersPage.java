package main.root.pages;


import main.root.common.BasePageFactory;
import main.root.common.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//t
public class BrokersPage extends BasePageFactory {

    @FindBy(className = "input-search")
    private WebElement searchField;
    @FindBy(className = "name")
    public WebElement brokerNameHomePage;
    @FindBy(xpath = "//h3[@class='name']")
    public WebElement brokerNameForSingleBroker;

    @FindBy(xpath = "//div[@class='position']//a")
    public WebElement propertiesHomePage;
    @FindBy(css = "div.wrapper article div.position a")
    public WebElement propertiesForBroker;

    @FindBy(xpath = "//*[@class='tel-group']/*[last()-1]")
    public WebElement firstNumberHomePage;

    @FindBy(xpath = "(//span[@class='tel'])[1]")
    public WebElement firstNumberBroker;

    @FindBy(xpath = "//*[@class='tel-group']/*[last()]")
    public WebElement secondNumberHomePage;

    @FindBy(xpath = "(//span[@class='tel'])[2]")
    public WebElement secondNumberBroker;

    @FindBy(xpath = "//a[.='Load more']")
    private WebElement loadMoreBtn;

    @FindBy(xpath = "//button[.='Clear']")
    public WebElement clearBtn;

    @FindBy(xpath = "//*[@value='Understood']")
    private WebElement acceptCookies;



    public void setUpBrokersPage() {
        WaitUtils.waitAndClickOnElement(acceptCookies);
        WaitUtils.waitForElementToBeInvisible(acceptCookies);
        loadMoreBtn.click();
        WaitUtils.waitForElementToBeInvisible(loadMoreBtn);
    }

    public void searchForBroker(String broker) {
        searchField.sendKeys(broker + Keys.ENTER);
    }
}
