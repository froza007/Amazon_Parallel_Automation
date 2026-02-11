package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.SearchPage;
import utils.ExcelUtil;
import org.testng.Assert;

public class SearchSteps {

    SearchPage search = new SearchPage(BaseClass.getDriver());

    // COMMON SEARCH METHOD
    private void performSearch(String featureValue, String excelColumn){

        String finalValue = featureValue;

        // ONLY override if placeholder detected
        if(featureValue.equalsIgnoreCase("EXCEL")) {

            finalValue = ExcelUtil.getSearchValue(excelColumn);
        }

        System.out.println("Searching using value: " + finalValue);

        search.searchProduct(finalValue);
    }

    @When("User searches valid product {string}")
    public void validSearch(String product){
        performSearch(product, "valid");
    }

    @When("User searches invalid product {string}")
    public void invalidSearch(String product){
        performSearch(product, "invalid");
    }

    @When("User searches special characters {string}")
    public void specialSearch(String product){
        performSearch(product, "special");
    }

    @Then("Verify results page displayed")
    public void verifyResults(){
        Assert.assertTrue(search.isResultsPageDisplayed());
    }

    @Then("Verify products are listed")
    public void verifyProducts(){
        Assert.assertTrue(search.areProductsListed());
    }
}
