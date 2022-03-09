package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePages {
    WebDriver driver;

    @FindBy(xpath = "//input[@data-testid=\"input\"]")
    private WebElement searching;
    @FindBy(xpath = "//div[@class='css-yhj6ev']//div/descendant::p[@class='css-1yq2xbk']")
    private List<WebElement> searchlist;
    @FindBy(xpath = "//button[.='Block']")
    private WebElement blockNtf;

    public HomePages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;
    }

    public void blockNotification(){
        try{
            blockNtf.click();
        }catch (Exception e){
            System.out.println("Unable to located element");
        }
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void search(String search){
        searching.isDisplayed();
        searching.isEnabled();
        searching.clear();
        searching.sendKeys(search);
    }

    public void searchlist(){
        System.out.println(searchlist.size());
        for (int i=0;i<searchlist.size();i++){
            System.out.println(searchlist.get(0).getText());
            searchlist.get(0).click();
            break;
        }
    }


}
