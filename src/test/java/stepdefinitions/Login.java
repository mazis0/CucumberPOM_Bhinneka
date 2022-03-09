package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePages;
import pages.LoginPages;

public class Login {
    private static String tittle;
    private LoginPages login = new LoginPages(DriverFactory.getDriver());
    private HomePages homepage = new HomePages(DriverFactory.getDriver());



    @Given("the user is on login pages")
    public void the_user_is_on_login_pages() {
        DriverFactory.getDriver().get("https://accounts.bhinneka.com/login");
        tittle = login.getTittle();
        System.out.println("The tittle is: " + tittle);
    }
    @When("the user enter valid email {string}")
    public void the_user_entervalid(String email) {

        login.enterEmail(email);

    }
    @When("hits selanjutnya")
    public void hits_selanjutnya() {

        login.clickOnSelanjutnya();

    }
    @When("the user entered valid password {string}")
    public void the_user_entered_valid(String password) {


        login.enterPassword(password);

    }
    @When("hits masuk")
    public void hits_masuk() {

        login.clickOnMasuk();
        homepage.blockNotification();


    }
    @Then("The user should be login Successfully")
    public void the_user_should_be_login_successfully() {

        login.verifyLogin();

    }

    @When("the user enter not registered email {string}")
    public void the_user_enter_notregisteredemail(String email) {

        login.enterEmail(email);

    }
    @Then("error message email belum terdaftar should be displayed")
    public void error_message_email_belum_terdaftar() {
        Assert.assertTrue(login.verifyWrongEmail());
    }

    @And("verify profile is displayed")
    public void verify_profile_Displayed(){
        Assert.assertTrue(login.verifyLogin());
    }
}
