package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {

    @Given("User is on Amazon home page")
    public void verifyHomePage(){

        HomePage home =
                new HomePage(BaseClass.getDriver());


        Assert.assertTrue(home.isHomePageLoaded());
    }

    @Then("Verify search box present")
    public void verifySearch(){

        HomePage home =
                new HomePage(BaseClass.getDriver());


        Assert.assertTrue(home.isSearchBoxPresent());
    }

    @Then("Verify category navigation menu present")
    public void verifyCategory(){

        HomePage home =
                new HomePage(BaseClass.getDriver());


        Assert.assertTrue(home.isCategoryMenuPresent());
    }

    @Then("Verify banner section visible")
    public void verifyBanner(){

        HomePage home =
                new HomePage(BaseClass.getDriver());


        Assert.assertTrue(home.isBannerVisible());
    }

    @When("User handles location popup")
    public void locationPopup(){

    	new HomePage(BaseClass.getDriver())
                .clickLocationPopup();
    }
}
