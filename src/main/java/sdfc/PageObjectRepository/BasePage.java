package sdfc.PageObjectRepository;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import sdfcReusable.ReusableMethods;



public class BasePage {
	/* 
	 * @author poojaS 
	 * This base contains browser setup,logger configurations
	 * extentReport configurations 
	 * and methods that are most commonly used through out the project
	 * like login 
	 */
	
	Logger logger= LogManager.getLogger(BasePage.class.getName());
	public void launchApp(WebDriver driver) throws IOException {
		driver.get(ReusableMethods.readPropertiesFile("logintestdata", "prod.salesforce"));
		logger.info("Launched the app");
	}

}