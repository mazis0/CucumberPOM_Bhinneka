package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPages {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement txt_email_login;
    @FindBy (xpath = "//button[@id='next']")
    private WebElement btn_selanjutnya_login;
    @FindBy (xpath = "//input[@id='password']")
    private WebElement txt_password_login;
    @FindBy (xpath = "//button[.='MASUK']")
    private WebElement btn_masuk_login;
    @FindBy (xpath = "//span[.='Email belum terdaftar']")
    private WebElement vfy_email_login;
    @FindBy (xpath = "//span[.='Login error! Kata sandi salah']")
    private WebElement vfy_password_Login;
    @FindBy (xpath = "//div/i[@name='user']")
    private WebElement profile;
    @FindBy (xpath = "//span[.='Email belum terdaftar']")
    private WebElement wrongemailmessage;

    public LoginPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
        this.driver = driver;

    }

    public String getTittle(){
        return driver.getTitle();
    }


    public void enterEmail(String email){
        txt_email_login.isEnabled();
        txt_email_login.clear();
        txt_email_login.sendKeys(email);
    }

    public void clickOnSelanjutnya(){

        btn_selanjutnya_login.click();

    }

    public void enterPassword(String password){
        txt_password_login.isEnabled();
        txt_password_login.clear();
        txt_password_login.sendKeys(password);
    }

    public void clickOnMasuk(){

        btn_masuk_login.click();
    }

    public boolean verifyLogin(){

        return profile.isDisplayed();
    }

    public boolean verifyWrongEmail(){
        return wrongemailmessage.isDisplayed();
    }
}
