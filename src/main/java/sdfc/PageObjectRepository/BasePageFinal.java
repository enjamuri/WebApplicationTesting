package sdfc.PageObjectRepository;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageFinal {
	WebDriver driver;
	private static Logger logger = LogManager.getLogger(BasePage.class.getName());
    /*
     * getBrowser method setups the browser according to request.
     * can configure the browser in headless mode and 
     * chrome browser, firefox,edge,safari
     * if no driver is mentioned then it will return null.
     */
	public WebDriver getBrowser(String browserName, boolean headless) {

		String browser = browserName.toLowerCase();

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if (headless)
			{
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--head");
				logger.info("Chromebrowser with headless mode is configured");
				driver = new ChromeDriver(co);
			} 
			else {
				driver = new ChromeDriver();
				logger.info("Chromebrowser is configured");
			    }
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox browser is configured");
			break;
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			logger.info("Safar browser isconfigured");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is configured");
			break;

		default:
			driver = null;
		}

		return driver;
	}
	
	public boolean waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
