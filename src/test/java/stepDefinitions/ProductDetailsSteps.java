package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    @When("User opens first product details")
    public void openProduct(){

    	new ProductDetailsPage(BaseClass.getDriver())
.openFirstProduct();
    }

    @Then("Verify product title visible")
    public void verifyTitle(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.getDriver())
.isTitleVisible());
    }

    @Then("Verify product price visible")
    public void verifyPrice(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.getDriver())
.isPriceVisible());
    }

    @Then("Verify product image visible")
    public void verifyImage(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.getDriver())
.isImageVisible());
    }

    @Then("Verify product description visible")
    public void verifyDescription(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.getDriver())
.isDescriptionVisible());
    }
}
