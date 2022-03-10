package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePages;
import pages.ProductPage;

public class Search {

    private static String tittle;
    private HomePages homepage = new HomePages(DriverFactory.getDriver());
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());


    @Given("The user is on Home page")
    public void the_user_is_on_home_page() {
        DriverFactory.getDriver().get("https://www.bhinneka.com/");
        homepage.blockNotification();
        homepage.getTitle();
    }
    @When("user enter keyword on search {string}")
    public void user_enter_keyword_on_search(String search) {
        homepage.search(search);

    }
    @When("user click on 1st list")
    public void user_click_on_1st_list(){
        homepage.blockNotification();
        homepage.searchlist();

    }
    @Then("user should be successfully move to product page 1st list")
    public void user_should_be_successfully_move_to_product_page_1st_list() {
        tittle = productPage.getTitle();
        System.out.println(tittle);
        Assert.assertTrue(productPage.productisDisplayed());

    }
}
