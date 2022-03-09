package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutPages;

public class Checkout {
    private CheckoutPages checkoutPages = new CheckoutPages(DriverFactory.getDriver());

    @Then("verify label Checkout is displayed")
    public void verify_label_checkout(){
        Assert.assertTrue(checkoutPages.checkoutIsDisplayed());
    }

    @And("choose JNE Regular Service for shipping")
    public void choose_Bhinneka_Shipping()throws InterruptedException{
        checkoutPages.pilihPembayaran();
    }

    @Then("verify subtotal and total is same")
    public void verify_subtotal_total_single_product(){
        checkoutPages.isSubtotalEqualTotal();
    }

    @And("click on Lanjut Pembayaran")
    public void click_on_lanjut_pembayaran(){
        checkoutPages.lanjutPembayaran();
    }
    @Then("verify Metode Pembayaran frame is displayed")
    public void metodePembayaranisDisplayed(){

       Assert.assertTrue(checkoutPages.metodePembayaranIsDisplayed());
    }

}
