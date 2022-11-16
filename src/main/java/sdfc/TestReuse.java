package sdfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import sdfcReusable.ReusableMethods;

public class TestReuse {
	
	//public static WebDriver driver;
	@BeforeClass
	public void driverSetup() {
		ReusableMethods.init("chrome");
	}

	@BeforeMethod
	public void launchApp() {
		ReusableMethods.navigateTo("https://login.salesforce.com");
	}
	@Ignore
	@Test
	public void TC01() {
		WebElement username= ReusableMethods.findElement("id","username");
		ReusableMethods.enterText(username,"maya.leo@g.com");
		
		WebElement password= ReusableMethods.findElement("id","password");
		ReusableMethods.enterText(password,"");
				
		WebElement login= ReusableMethods.findElement("id","Login");
		login.click();
		WebElement result=ReusableMethods.findElement("xpath","//div[@id='error']");
		String actresult=result.getText();
		ReusableMethods.assertEquals(actresult, "Please enter your password.");
	}
	
	@Test(priority=1)
	public void TC02() throws InterruptedException {
		WebElement username= ReusableMethods.findElement("id","username");
		ReusableMethods.enterText(username,"maya.leo@g.com");
		
		WebElement password= ReusableMethods.findElement("id","password");
		ReusableMethods.enterText(password,"Tester@123");
				
		WebElement login= ReusableMethods.findElement("id","Login");
		login.click();
		Thread.sleep(2000);
		//String actresult=ReusableMethods.driver.getTitle();
		String actresult=ReusableMethods.getTitlePage();
		ReusableMethods.assertEquals(actresult, "Home Page ~ Salesforce - Developer Edition");
		
		ReusableMethods.findElement("css","#tsidButton").click();
	}
	@Ignore
	@Test(priority=2)
	public void TC03() {
		//ReusableMethods.loginApp("maya.leo@g.com","Tester@123","Home Page ~ Salesforce - Developer Edition");
		WebElement username= ReusableMethods.findElement("id","username");
		ReusableMethods.enterText(username,"maya.leo@g.com");
		
		WebElement password= ReusableMethods.findElement("id","password");
		ReusableMethods.enterText(password,"Tester@123");
		
		WebElement rembrMe=ReusableMethods.findElement("xpath","//*[@id='rememberUn']");
		rembrMe.click();
				
		WebElement login= ReusableMethods.findElement("id","Login");
		login.click();
		
		String actresult=ReusableMethods.driver.getTitle();
		ReusableMethods.assertEquals(actresult, "Home Page ~ Salesforce - Developer Edition");
		 
		ReusableMethods.findElement("css","#userNav").click();
		ReusableMethods.findElement("xpath","//*[@id='userNav-menuItems']/a[5]").click();
		System.out.println("Logout is clicked");
		//String actres=ReusableMethods.driver.getPageSource();
		//ReusableMethods.assertEquals(actres,"https://teckarch-d-dev-ed.my.salesforce.com/");
		
		//boolean expcheck=true;
    	//boolean actcheck=ReusableMethods.findElement("xpath","//*[@id='rememberUn']").isEnabled();
    	//Assert.assertEquals(expcheck,actcheck);
    	System.out.println("testcase is passed");
		
	}
	
	@AfterClass
	public void tearDown() {
		ReusableMethods.driver.close();
	}
}
