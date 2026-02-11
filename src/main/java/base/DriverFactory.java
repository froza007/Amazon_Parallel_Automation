package base;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // THREAD SAFE DRIVER
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void initDriver(String browser) {

        // REMOVE SELENIUM INTERNAL WARNING LOGS
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        WebDriver localDriver = null;

        System.out.println("Launching browser: " + browser);

        if(browser.equalsIgnoreCase("chrome")) {

            // AUTO DOWNLOAD ChromeDriver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Silence chrome logs
            System.setProperty("webdriver.chrome.silentOutput", "true");

            // YOUR EXISTING OPTIONS
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-infobars");
            options.addArguments("--log-level=3");
            options.addArguments("--disable-logging");

            options.addArguments(
                    "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                  + "AppleWebKit/537.36 (KHTML, like Gecko) "
                  + "Chrome/120.0.0.0 Safari/537.36"
            );

            localDriver = new ChromeDriver(options);
        }

        else if(browser.equalsIgnoreCase("edge")) {

            // USE LOCAL EDGE DRIVER (NO NETWORK)
            System.setProperty(
                    "webdriver.edge.driver",
                    System.getProperty("user.dir") + "/drivers/msedgedriver"
            );

            System.setProperty("webdriver.edge.silentOutput", "true");

            EdgeOptions options = new EdgeOptions();

            // SAME OPTIONS AS CHROME
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-infobars");

            options.addArguments(
                    "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                  + "AppleWebKit/537.36 (KHTML, like Gecko) "
                  + "Chrome/120.0.0.0 Safari/537.36"
            );

            localDriver = new EdgeDriver(options);
        }

        else {

            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.set(localDriver);

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        getDriver().get("https://www.amazon.in");
    }


    public static WebDriver getDriver() {

        return driver.get();
    }


    public static void quitDriver() {

        if(driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}
