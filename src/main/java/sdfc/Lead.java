package sdfc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sdfcReusable.ReusableMethods;

public class Lead {
	
	@BeforeClass
	public void driverSetup() {
		ReusableMethods.init("chrome");
	}

	@BeforeMethod
	public void launchApp() {
		ReusableMethods.navigateTo("https://login.salesforce.com");
	}

	@Test(priority=0)
	public void login() throws InterruptedException {
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
	@Test
	public void TC20() {      
		WebElement leadTab=ReusableMethods.findElement("xpath","//li[@id='Lead_Tab']/a");
		leadTab.click();
		
	}

}
