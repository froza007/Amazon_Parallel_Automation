package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SortingPage {

    WebDriver driver;

    public SortingPage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect sorting dropdown
    // Right click sorting dropdown -> Inspect -> id="s-result-sort-select"
    By sortDropdown = By.id("s-result-sort-select");

    // Inspect product price element
    // Inspect product price span class="a-price-whole"
    By productPrices = By.cssSelector("span.a-price-whole");

    public void sortLowToHigh(){

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("price-asc-rank");
    }

    public void sortByCustomerReview(){

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("review-rank");
    }

    public boolean verifyProductsPresent(){

        return driver.findElements(productPrices).size() > 0;
    }
}
