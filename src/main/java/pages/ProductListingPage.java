package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect product listing container
    // Right click any product card -> inspect -> parent div class="s-main-slot"
    By productContainer = By.cssSelector("div.s-main-slot");

    // Inspect individual product titles
    // inside each result card -> h2 tag
    By productTitles = By.cssSelector("div.s-main-slot h2");

    // Inspect price filter checkbox
    // Example: price range under filters left sidebar
    // Inspect label containing price text
    By priceFilter = By.xpath("//span[contains(text(),'₹')]/ancestor::a");

    // Inspect brand filter checkbox
    // Left sidebar brands list
    By brandFilter = By.xpath("//span[text()='Samsung']/preceding-sibling::div");

    // Inspect clear filter / any filter reset link
    // Often appears as "Clear"
    //By clearFilter = By.xpath("//span[contains(text(),'Clear')]");

    public boolean areProductsVisible(){

        return driver.findElements(productTitles).size() > 0;
    }

    public void applyPriceFilter(){

        driver.findElement(priceFilter).click();
    }

    public void applyBrandFilter(){

        driver.findElement(brandFilter).click();
    }

    public void clearFilters(){

        // Amazon filters dynamic — safest way is re-run search
        // Reusing search box resets filters

        // Inspect search input -> id="twotabsearchtextbox"
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung phone");

        // Inspect search button -> id="nav-search-submit-button"
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

}
