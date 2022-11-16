package sdfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testngdemo {
	public WebDriver driver;
	public WebDriverWait wait;
    
	@BeforeSuite
	public void driversetup(){
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		//Headless mode
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless","--disable-gpu","--windows-size=1920,1080","--ignore-ceriticate-errors");
		driver= new ChromeDriver(co);
	}
    @BeforeClass
    public void launch() {
    	driver.get("https://login.salesforce.com");
    	driver.manage().window().maximize();
    	String expresult="Login | Salesforce";
    	String actresult=driver.getTitle();
    	Assert.assertEquals(expresult, actresult,"opened the home page");
    }
    @Ignore
    @Test
    public void TC01() {
    	//To enter user name and verify
    	String username="maya.leo@g.com";
    	WebElement usernameelement=driver.findElement(By.id("username"));
    	usernameelement.sendKeys(username);
    	String actuser=usernameelement.getAttribute("value");
    	Assert.assertEquals(username,actuser,"Login page loaded");
    	// Enter empty password and verify 
    	String exppwd="";
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.clear();
		String actpwd=pwd.getText();
		Assert.assertEquals(exppwd, actpwd,"password verification");
		//Click on login button and verify
		driver.findElement(By.id("Login")).click();
		String Expresult="Please enter your password.";
		String actresult=driver.findElement(By.xpath("//div[@id='error']")).getText();
		Assert.assertEquals(Expresult, actresult,"Error message for empty password");
		
    }
    //@Ignore
    @Test
	public void TC02() throws InterruptedException {
    	//username validation
    	String username="maya.leo@g.com";
    	WebElement usernameelement=driver.findElement(By.id("username"));
    	usernameelement.sendKeys(username);
    	String actuser=usernameelement.getAttribute("value");
    	Assert.assertEquals(username,actuser,"Login page loaded");
    	//password 
    	driver.findElement(By.id("password")).sendKeys("Tester@123");
    	
    	//login button click and validate check
    	driver.findElement(By.id("Login")).click();
    	String exphomepage="Home Page ~ Salesforce - Developer Edition";
         Thread.sleep(8000);
         String acthomepage=driver.getTitle();
    	Assert.assertEquals(acthomepage,exphomepage,"homepage is loaded");
    	
	}
    
    @Ignore
    @Test(priority=3)
    public void TC3() throws Exception {
    	//username validation
    	driver.findElement(By.id("username")).sendKeys("maya.leo@g.com");
		driver.findElement(By.id("password")).sendKeys("Tester@123");
		//remember me checkbox
		driver.findElement(By.xpath("//*[@id='rememberUn']")).click();
		
		//login button and home page verififcation
		driver.findElement(By.id("Login")).click();
		String exphomepage="Home Page ~ Salesforce - Developer Edition";
        Thread.sleep(4000);
        String acthomepage=driver.getTitle();
     	Assert.assertEquals(acthomepage,exphomepage,"homepage is loaded");
     	
     	//logout 
     	driver.findElement(By.cssSelector("#userNav")).click();
		driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		//check the username checkafter logout
		Thread.sleep(3000);
		String expUrl="https://teckarch-d-dev-ed.my.salesforce.com/";
		String acturl=driver.getCurrentUrl();
		Assert.assertEquals(expUrl, acturl,"Login page is verified");
		String username="maya.leo@g.com";
    	String actuser=driver.findElement(By.id("username")).getAttribute("value");
    	Assert.assertEquals(username,actuser,"Login page loaded");
    	boolean expcheck=true;
    	boolean actcheck=driver.findElement(By.xpath("//*[@id='rememberUn']")).isEnabled();
    	Assert.assertEquals(expcheck,actcheck);
    	System.out.println("testcase is passed");
       }
    @Ignore
    @Test
    public void TC4A(){
    	
		//forgot password
		driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();
		//driver.findElement(By.id("wrapper"));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("maya.leo@g.com");
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
		String expresult= "Check Your Email | Salesforce";
		String actresult=driver.getTitle();
		Assert.assertEquals(expresult, actresult,"forgot password verification");
    	
    }
    @Ignore
    @Test
    public void TC4B() {
    			//Wrong username, wrong password.
    			driver.findElement(By.id("username")).sendKeys("123");
    			driver.findElement(By.id("password")).sendKeys("22131");
    			driver.findElement(By.id("Login")).click();
    			String expresult="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    			String actresult=driver.findElement(By.xpath("//div[@id='error']")).getText();
    			Assert.assertEquals(expresult, actresult,"Error message verification");
    }
    @AfterTest
    public void Closedriver() {
    	driver.close();
    }
}
