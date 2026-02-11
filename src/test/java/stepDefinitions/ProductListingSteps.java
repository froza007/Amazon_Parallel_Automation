package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductListingPage;

public class ProductListingSteps {

    @Then("Verify multiple products displayed")
    public void verifyProducts(){

        ProductListingPage listing =
        		new ProductListingPage(BaseClass.getDriver());

        Assert.assertTrue(listing.areProductsVisible());
    }

    @When("User applies price filter")
    public void priceFilter(){

    	new ProductListingPage(BaseClass.getDriver())
    			.applyPriceFilter();
    }

    @When("User applies brand filter")
    public void brandFilter(){

    	new ProductListingPage(BaseClass.getDriver())
    				.applyBrandFilter();
    }

    @When("User clears filters")
    public void clearFilters(){

    	new ProductListingPage(BaseClass.getDriver())
    			.clearFilters();
    }
}
