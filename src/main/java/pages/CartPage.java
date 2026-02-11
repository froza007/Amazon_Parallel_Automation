package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    // Inspect Add to Cart button
    // id="add-to-cart-button"
    By addToCartBtn = By.xpath("(//input[@id='add-to-cart-button'])[2]");

    // Inspect Cart icon
    // id="nav-cart"
    By cartIcon = By.id("nav-cart");

    // Inspect cart items
    // class="sc-list-item"
    By cartItems = By.cssSelector(".sc-list-item");

    // Inspect delete/remove button
    // input value="Delete"
    By deleteBtn = By.xpath("//input[@value='Delete']");


    public void addProductToCart(){

        driver.findElement(addToCartBtn).click();
    }

    public void openCart(){

        driver.findElement(cartIcon).click();
    }

    public boolean isProductInCart(){

        return driver.findElements(cartItems).size() > 0;
    }

    public void removeProduct(){

        driver.findElement(deleteBtn).click();
    }
}
