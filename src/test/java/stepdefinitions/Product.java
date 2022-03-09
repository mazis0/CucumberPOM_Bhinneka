package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import pages.HomePages;
import pages.ProductPage;

public class Product {

    private HomePages homepage = new HomePages(DriverFactory.getDriver());
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());


    @And("user click on Beli button")
    public void user_click_on_Beli_button(){
        productPage.buyproduct();
    }


}
