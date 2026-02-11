package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",

        glue = {
                "stepDefinitions",
            
        },

        plugin = {

                "pretty",

                // HTML Report
                "html:reports/cucumber-reports/report.html",

                // JSON Report (Jenkins + advanced reporting)
                "json:target/cucumber.json",
                
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",

                // Console output formatting
                "summary"

        },

        monochrome = true
        

)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setBrowser(String browser) {

        System.setProperty("browser", browser);
    }
	
}
