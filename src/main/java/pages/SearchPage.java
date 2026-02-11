package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect search input box
    // Right click search field -> Inspect -> id="twotabsearchtextbox"
    By searchBox = By.id("twotabsearchtextbox");

    // Inspect search button
    // Inspect search icon button -> id="nav-search-submit-button"
    By searchButton = By.id("nav-search-submit-button");

    // Inspect search results container
    // Inspect product grid -> div class="s-main-slot"
    By resultsContainer = By.cssSelector("div.s-main-slot");

    // Inspect product titles inside results
    // Inspect any product title -> h2 tag inside result card
    By productTitles = By.cssSelector("div.s-main-slot h2");

    public void searchProduct(String text){

        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchButton).click();
    }

    public boolean isResultsPageDisplayed(){

        return driver.findElement(resultsContainer).isDisplayed();
    }

    public boolean areProductsListed(){

        return driver.findElements(productTitles).size() > 0;
    }
}
