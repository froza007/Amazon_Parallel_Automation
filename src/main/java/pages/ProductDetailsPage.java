package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect product title link
    // Right click product title -> Inspect -> class="a-link-normal s-no-outline"
    By firstProduct =
            By.cssSelector("a.a-link-normal.s-no-outline");

    // Product title
    // Inspect -> id="productTitle"
    By productTitle = By.id("productTitle");

    // Product price
    // Inspect price span class="a-price-whole"
    By productPrice = By.xpath("//span[contains(@class,'a-price aok-align-center')]");

    // Product image container
    // Inspect -> id="imgTagWrapperId"
    By productImage = By.id("imgTagWrapperId");

    // Product description bullets
    // Inspect -> id="feature-bullets"
    By productDescription = By.id("feature-bullets");


    public void openFirstProduct(){

        String parentWindow = driver.getWindowHandle();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        // WAIT until product links appear
        wait.until(ExpectedConditions
                .elementToBeClickable(firstProduct));

        driver.findElement(firstProduct).click();

        // Switch to new tab if opened
        Set<String> handles = driver.getWindowHandles();

        for(String handle : handles){

            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
            }
        }
    }

    public boolean isTitleVisible(){

        return driver.findElement(productTitle).isDisplayed();
    }

    public boolean isPriceVisible(){

        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isImageVisible(){

        try{

            // Try primary locator
            if(driver.findElements(By.id("imgTagWrapperId")).size() > 0){
                return driver.findElement(By.id("imgTagWrapperId")).isDisplayed();
            }

            // Fallback 1
            if(driver.findElements(By.id("landingImage")).size() > 0){
                return driver.findElement(By.id("landingImage")).isDisplayed();
            }

            // Fallback 2
            if(driver.findElements(By.id("imgBlkFront")).size() > 0){
                return driver.findElement(By.id("imgBlkFront")).isDisplayed();
            }

            return false;

        }catch(Exception e){

            return false;
        }
    }


    public boolean isDescriptionVisible(){

        return driver.findElement(productDescription).isDisplayed();
    }
}
