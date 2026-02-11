package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect Amazon search input box
    // Right click search box -> Inspect -> input id="twotabsearchtextbox"
    By searchBox = By.id("twotabsearchtextbox");

    // Inspect top navigation category menu
    // Inspect hamburger menu icon (id="nav-hamburger-menu")
    By categoryMenu = By.id("nav-hamburger-menu");

    // Inspect banner/deals section
    // Inspect main carousel container (id="gw-layout")
    By bannerSection = By.id("gw-layout");

    // Inspect location popup
    // Click location icon -> Inspect id="nav-global-location-popover-link"
    By locationPopup = By.id("nav-global-location-popover-link");

    public boolean isHomePageLoaded(){

        try{

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(40));

            wait.until(ExpectedConditions
                    .presenceOfElementLocated(searchBox));

            return true;

        }catch(Exception e){

            return false;
        }
    }



    public boolean isSearchBoxPresent(){

        return driver.findElement(searchBox).isDisplayed();
    }

    public boolean isCategoryMenuPresent(){

        return driver.findElement(categoryMenu).isDisplayed();
    }

    public boolean isBannerVisible(){

        return driver.findElement(bannerSection).isDisplayed();
    }

    public void clickLocationPopup(){

        driver.findElement(locationPopup).click();
    }
}
