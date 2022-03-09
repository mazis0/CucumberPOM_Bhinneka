package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class CheckoutPages {
    WebDriver driver;

    @FindBy(xpath = "//h1[.=\"Checkout\"]")
    private WebElement label_checkout;

    @FindBy(xpath = "//div[@class='bt-payment__header-title']")
    private WebElement MetodePembayaran;

    @FindBy(xpath = "//span[.=\"Pilih\"]/parent::button/parent::div/parent::div/parent::div")
    private WebElement pilihjasapengiriman;

    @FindBy (xpath = "//p[.='JNE Regular Service']/parent::div/parent::div/parent::div")
    private WebElement jneRegularService;

    @FindBy(xpath = "//span[.='Lanjut Pembayaran']")
    private WebElement lanjutPembayaran;

    @FindBy(xpath = "//div[@class=\"arrow\"]/preceding-sibling::h4/child::span")
    private WebElement subTotal;

    @FindBy(xpath = "//label[.=\"TOTAL\"]/following-sibling::p")
    private WebElement Total;

    @FindBy(xpath = "//*[@id=\"paymentIFrame\"]")
    private WebElement iframe;

    @FindBy(xpath = "//h4[.=\"Total\"]/parent::a")
    private WebElement totalMetodePembayaran;


    public CheckoutPages(WebDriver driver) {

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        this.driver = driver;
    }
    public String title(){
        return driver.getTitle();
    }

    public boolean checkoutIsDisplayed(){

       return label_checkout.isDisplayed();
    }

    public boolean metodePembayaranIsDisplayed(){
        driver.switchTo().frame(iframe);
        return MetodePembayaran.isDisplayed();
    }

    public void pilihPembayaran()throws InterruptedException{
        Thread.sleep(3000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pilihjasapengiriman)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(jneRegularService)).click();
    }


    public void lanjutPembayaran(){
        lanjutPembayaran.isDisplayed();
        lanjutPembayaran.isEnabled();
        lanjutPembayaran.click();
    }

    public boolean isSubtotalEqualTotal(){
        String subtotal = subTotal.getText();
        String total = Total.getText();
        subtotal = subtotal.replaceAll("\\D+","");
        total = total.replaceAll("\\D+","");
        subtotal.equals(total);
        return true;
    }
}
