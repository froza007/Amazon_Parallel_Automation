package stepDefinitions;

import org.testng.Reporter;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;


public class Hooks {

   
	@Before
	public void setup(Scenario scenario) {

		 String browser = Reporter.getCurrentTestResult()
	                .getTestContext()
	                .getCurrentXmlTest()
	                .getParameter("browser");
		
	    DriverFactory.initDriver(browser);
	}



    @After
    public void tearDown(Scenario scenario){
    	
    	// Capture screenshot only when scenario fails
        if(scenario.isFailed()){

            ScreenshotUtil.captureScreenshot(
                    BaseClass.getDriver(),
                    scenario.getName());
        }

        DriverFactory.quitDriver();
    }
}
