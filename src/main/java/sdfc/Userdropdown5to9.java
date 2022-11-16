package sdfc;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Userdropdown5to9 {
	public WebDriver driver;
	public WebDriverWait wait;
    
	@BeforeSuite
	public void driversetup(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@BeforeClass
	public void launch() {
    	driver.get("https://login.salesforce.com");
    	driver.manage().window().maximize();
    	String expresult="Login | Salesforce";
    	String actresult=driver.getTitle();
    	Assert.assertEquals(expresult, actresult,"opened the home page");
    }
	@Test
	public void Login() throws InterruptedException {
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
         Thread.sleep(3000);
         String acthomepage=driver.getTitle();
    	Assert.assertEquals(acthomepage,exphomepage,"homepage is loaded");
	
	}
	@Test(priority=1)
	public void TC05() {
		driver.findElement(By.cssSelector("#userNav")).click();
	    String[] expectedMenuValues= {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
	    for(int i=0;i<expectedMenuValues.length;i++)
	    {
	    	String actValue=driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a"+"["+(i+1)+"]")).getText();
	    	if(actValue.equals(expectedMenuValues[i]))
	    	{
	    		System.out.println(expectedMenuValues[i]+" is verified succesfully");
	    	}
	    }
	}
	@Ignore
	@Test
	public void TC06() {
		// clicks on my profile
				driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[1]")).click();

				// click on edit profile
				driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']")).click();

				// Switching to an iframe

				driver.switchTo().frame("contactInfoContentId");

				driver.findElement(By.xpath("//li[@id='aboutTab']/a")).click();

				WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
				lastName.clear();
				lastName.sendKeys("Raj");
				driver.findElement(By.xpath("//*[@value='Save All']")).click();

				// come out of iframe

				driver.switchTo().defaultContent();

				driver.findElement(By.cssSelector("#publishereditablearea")).click();

				driver.switchTo().frame(0);

				driver.findElement(By.xpath("/html/body")).sendKeys("Adding my first post");
				driver.switchTo().defaultContent();
				driver.findElement(By.cssSelector("#publishersharebutton")).click();

				driver.findElement(By.cssSelector("#publisherAttachContentPost")).click();
				
//				Utilities.findElement("#publishersharebutton", "css").click();
				
//				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']/span[1]")).click();
				
				driver.findElement(By.cssSelector("#chatterUploadFileAction")).click();
				driver.findElement(By.cssSelector("#chatterFile")).sendKeys("C:\\Users\\user\\Desktop\\Framework.PNG");
				
				driver.findElement(By.cssSelector("#publishersharebutton")).click();
				if(driver.findElement(By.cssSelector("#displayBadge")).isDisplayed()) {
					driver.findElement(By.cssSelector("#displayBadge")).click();
				} else {
					System.out.println("Display badge is not visible");
				}
				driver.switchTo().frame("uploadPhotoContentId");
				driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("C:\\Users\\pooja\\Desktop\\website.logo.png");
				driver.findElement(By.name("j_id0:uploadFileForm:uploadBtn")).click();

				// explicit wait
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("j_id0:j_id7:save"))));
				
//				driver.findElement(By.name("j_id0:j_id7:save")).click();
//				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", driver.findElement(By.name("j_id0:j_id7:save")));
				
			}

	
	
	
	
    @Ignore
	@Test(priority=2)
	public void TC07() throws Exception {
		//driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]")).click();
		Thread.sleep(3000);
		//Click on personal link and select Login History link. 
		driver.findElement(By.xpath("//div[@id='PersonalInfo']/a")).click();
		driver.findElement(By.cssSelector(".leafText#LoginHistory_font")).click();
		driver.findElement(By.xpath("//div[@id='DisplayAndLayout']/a")).click();
		driver.findElement(By.xpath("//div[@id='DisplayAndLayout_child']/div/a/span")).click();
		driver.findElement(By.xpath("//select[@id=\"p4\"]/option[9]")).click();
		driver.findElement(By.xpath("//*[@id=\"duel_select_0\"]/option[73]")).click();
		driver.findElement(By.xpath("//img[@class='rightArrowIcon']")).click();
		driver.findElement(By.xpath("//td[@id=\"bottomButtonRow\"]/input[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='EmailSetup']/a")).click();
		driver.findElement(By.xpath("//div[@id='EmailSetup_child']/div/a/span")).click();
		Thread.sleep(3000);
		
		String actresult=driver.findElement(By.xpath("//div[@id='meSaveCompleteMessage']/table/tbody/tr/td[2]/div")).getText();
		String expresult="Your settings have been successfully saved.";
		Assert.assertEquals(expresult, actresult,"email sent");
	}
    
    @Ignore
    @Test(priority=3)
    public void TC08new() throws InterruptedException{

    	driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[text()='Developer Console']")).click();
    	Thread.sleep(2000);
    	
    	Set<String> windows=driver.getWindowHandles();
    	Thread.sleep(2000);
    	Iterator<String> it=windows.iterator();
    	String parentwindowid=it.next();
    	String childwindowid=it.next();
    	Thread.sleep(2000);
    	driver.switchTo().window(childwindowid);
    	System.out.println("New window opened title is "+ driver.getTitle());
    	driver.close();
    	
    	driver.switchTo().window(parentwindowid);
    	System.out.println("Came to parent main window and title is "+driver.getTitle());
    }
    @Ignore
    @Test(priority=2)
    public void TC09() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]")).click();
		//check the username checkafter logout
		Thread.sleep(3000);
		String expUrl="https://teckarch-d-dev-ed.my.salesforce.com/";
		String acturl=driver.getCurrentUrl();
		System.out.println(acturl);
		Assert.assertEquals(expUrl, acturl,"Login page is verified");
    	
    }
	
	@AfterTest
	public void Closedriver() {
		driver.close();
	}
}
