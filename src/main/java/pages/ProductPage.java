package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='css-oe1jvc enfpb2q0']/h1")
    private WebElement titleProduct;
    @FindBy(xpath = "//span[.=\"Beli\"]")
    private WebElement buy_btn;


    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;

    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean productisDisplayed(){
        titleProduct.isDisplayed();
        return true;
    }

    public void buyproduct(){
        buy_btn.isDisplayed();
        buy_btn.isEnabled();
        buy_btn.click();

    }
}
