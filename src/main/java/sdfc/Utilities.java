package sdfc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	
	
	//static WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	/*Driver setup if its chrome or firefox or edge browsers
	 */
	public static void driverSetUp(WebDriver driver,String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("microsoftedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	/*Login username and password 
	 * 
	 */
	public static void loginPage(WebDriver driver,String Url) {

	driver.get(Url);
	driver.manage().window().maximize();
	String expresult="Login | Salesforce";
	String actresult=driver.getTitle();
	Assert.assertEquals(expresult, actresult,"Login page title is not matched");
	System.out.println("Login page is successfully loaded");
	}
	
	
	
	@DataProvider(name="userNames")
	public Object[][] userCredentials(){
		
		return new Object[][] {{"abc@gmail.com","1234"},{"maya.leo@g.com","Tester@123"},{"",""}};
	}
	
	
	
	
	
	/* enterText method sends the value to the address of the webElement
	 */
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
	/* assertEquals method verifies the actual result to the expected result
	 * and returns boolean true if matches and false it do not match 
	 */
	public boolean assertEquals(String actual, String expected) {
		try {
			Assert.assertEquals(expected, actual);
			return true;
			} catch (Exception e) {
					return false;
					}
	   }
	
	public static WebElement findElement(String text, String type,WebDriver driver) {
		WebElement element=null;
		switch(type) 
		{
		case "xpath":
			element =  driver.findElement(By.xpath(text));
			break;
			
		case "css":
			element = driver.findElement(By.cssSelector(text));
			break;
		}
		
		return element;
		
		
	}
	//Click operation
	public void onClickWebElement(WebElement element,long waitTimeInSeconds,WebDriver driver) {
		WebDriverWait webwait=new WebDriverWait(driver,Duration.ofSeconds(waitTimeInSeconds));
		WebElement elements=null;
		elements=webwait.until(ExpectedConditions.elementToBeClickable(element));
		elements.click();
		test.log(Status.INFO,"Performed click operation......");
	}
	
	//sendkeys Action
	public void sendKeysOnWebElement(WebElement element,String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
		//test.log(Status.INFO, "text is entered.......");
		System.out.println();
		
	}
	
	//selecting a value from dropdown list
	public void selectByVisibility(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	//to take screenshots
	public static String captureScreenshots(WebDriver driver) throws IOException {
		String dateFormat= new SimpleDateFormat("yyyy_mm_dd_hh_ss").format(new Date());
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		String destinationPath=System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots\\"+dateFormat+".PNG";
		File sourceFile= screenshot.getScreenshotAs(OutputType.FILE);
		
		File destiFile= new File(destinationPath);
		FileUtils.copyFile(sourceFile, destiFile);
		System.out.println("Screenshot is captured");
		return destinationPath;
		
	}
	
	//mouse hovering from one element to other element
	public void mouseHoverClickOn(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
	}
	
	//Accepting alert from UI
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	//

}
