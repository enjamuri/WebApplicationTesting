package sdfc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
//import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import sdfcReusable.ReusableMethods;

public class Report1to4TC {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	ReusableMethods rm=new ReusableMethods();
	ExtentTest test;
    
	@BeforeTest
	public void initializeReport() {
		
		String dateFormat=new SimpleDateFormat("yyyy_mm_dd_hh_ss").format(new Date());
		String reportPath=System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+dateFormat+".html";
	     extent=new ExtentReports();
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(reportPath);
		extent.attachReporter(htmlReport);
	}
	
	@Ignore
	
	@AfterTest
	public void reportTearDown() {
		extent.flush();
	}
	@BeforeClass
	public static void driversetup(){
		
		 ReusableMethods.init("chrome");
		//Utilities.driverSetUp(driver,"Chrome");
		/*Headless mode
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless","--disable-gpu","--windows-size=1920,1080","--ignore-ceriticate-errors");
		driver= new ChromeDriver(co);*/
	}
	@Ignore
	@AfterClass
    public void tearDown() {
    	ReusableMethods.driver.close();
    	
    }
    @BeforeMethod
    public void launch() {
    	
			ReusableMethods.navigateTo("https://login.salesforce.com");
		
    	//Utilities.loginPage(driver,"https://login.salesforce.com");
    }
  
    @Test
    public void TC01() throws IOException {
    	//To enter user name and verify
    	test=extent.createTest("TC01");
    	String username="maya.leo@g.com";
    	WebElement usernameelement=driver.findElement(By.id("username"));
    	usernameelement.sendKeys(username);
    	String actuser=usernameelement.getAttribute("value");
    	Assert.assertEquals(username,actuser,"Login page loaded");
    	test.log(Status.INFO, "username entered");
    	// Enter empty password and verify 
    	String exppwd="";
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.clear();
		String actpwd=pwd.getText();
		Assert.assertEquals(exppwd, actpwd,"password verification");
		test.log(Status.INFO, "Password is entered as empty");
		
		//Click on login button and verify
		
		driver.findElement(By.id("Login")).click();
		test.log(Status.INFO," login button is clicked");
		
		String Expresult="Please enter your password.";
		String actresult=driver.findElement(By.xpath("//div[@id='error']")).getText();
		Assert.assertEquals(Expresult, actresult,"Error message for empty password");
		test.pass("TC01 is passed");
		test.addScreenCaptureFromPath(Utilities.captureScreenshots(driver));
		
    }
   /*
   @Test(priority = 1)
  	public void TC02() throws InterruptedException, IOException {
	   test=extent.createTest("TC02");
      	//username validation
      	String username="maya.leo@g.com";
      	WebElement usernameelement=driver.findElement(By.id("username"));
      	usernameelement.sendKeys(username);
      	String actuser=usernameelement.getAttribute("value");
      	Assert.assertEquals(username,actuser,"Login page loaded");
      	test.log(Status.INFO,"Valid username entered");
      	//password 
      	driver.findElement(By.id("password")).sendKeys("Tester@123");
      	test.log(Status.INFO,"Valid password entered");
      	
      	//login button click and validate check
      	driver.findElement(By.id("Login")).click();
      	test.log(Status.INFO,"Login button is clicked");
      	String exphomepage="Home Page ~ Salesforce - Developer Edition";
           Thread.sleep(8000);
           String acthomepage=driver.getTitle();
      	Assert.assertEquals(acthomepage,exphomepage,"homepage is loaded");
      	test.pass("TC02 is passed");
      	test.addScreenCaptureFromPath(Utilities.captureScreenshots(driver));
  	}
    
    
    
*/
}
