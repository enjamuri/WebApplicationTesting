package sdfc.Tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bsh.util.Util;
import sdfc.PageObjectRepository.ContactsPage;
import sdfc.PageObjectRepository.LoginPage;
import sdfc.PageObjectRepository.UserMenuPage;
import sdfcReusable.Utility;
import sdfcReusable.sfdclisteners;
@Listeners(sfdclisteners.class)
public class ContactsTest extends BaseTest {
	private LoginPage lp=null;
	private UserMenuPage ump=null;
	private ContactsPage cp=null;
	public static Logger logger=LogManager.getLogger(ContactsTest.class.getName());
	
	
	@BeforeMethod
	public void driverSetup(ITestContext iTest) throws IOException {
		driver = getBrowser("chrome", false);
		
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		driver.quit();
		logger.info("Browser is closed.");
	}
	@Ignore
	@Test
	public void createNewContact_TC25() throws Throwable {
		String dateFormat= new SimpleDateFormat("dd_hh_ss").format(new Date());
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		cp = new ContactsPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		String lname="lastname";
		String accname="AccountName";
		Utility.waitForElement(driver,cp.contactTab);
		cp.contactTab.click();
		Assert.assertTrue(cp.isContactPageDisplayed(driver.getTitle()), "Contact tab should be seen");
		Utility.waitForElement(driver,cp.newButton);
		cp.newButton.click();
		Assert.assertTrue(cp.isContactEditPageDisplayed(driver.getTitle()), "new contact page should be seen");
		Utility.waitForElement(driver,cp.lastName);
	    cp.lastName.sendKeys(lname);
	    cp.lastName.isDisplayed();
	    cp.accountName.sendKeys(accname);
	    cp.accountName.isDisplayed();
	    cp.saveButton.click();
	    //Assert.assertTrue(cp.contactSaved.isDisplayed(),"New contact is saved");
	    //need to uncomment
	}
	@Test
	public void createNewViewInContactPage_TC26() throws Throwable {
		String dateFormat= new SimpleDateFormat("dd_hh_ss").format(new Date());
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		cp = new ContactsPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver,cp.contactTab);
		cp.contactTab.click();
		Assert.assertTrue(cp.isContactPageDisplayed(driver.getTitle()), "Contact tab should be seen");
		Utility.waitForElement(driver,cp.createNewView);
		Utility.click(cp.createNewView);
		//Assert.assertTrue(cp.isdisplayedText(cp.createViewPagedisplay), "new view page in contact should be seen");
		//Assert.assertTrue(cp.viewName.isDisplayed(),"New view page in contact should be seen");
		Utility.waitForElementToDisplay(driver,cp.viewName);
		Utility.enterText(cp.viewName,"viewName");
	    Utility.click(cp.viewUniqueName);
	    Assert.assertTrue(cp.isdisplayedText(cp.viewUniqueName), "viewUniquename field is automatically filled");
	    cp.saveView.click();
	    Utility.waitForElement(driver,cp.viewSavedPage);
	    Assert.assertTrue(cp.viewSavedPage.isDisplayed(),"New contact is saved");
	}
	@Ignore
	@Test
	public void checkButtonsInNewContactPage_TC32() throws Throwable {

		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		cp = new ContactsPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver,cp.contactTab);
		cp.contactTab.click();
		Assert.assertTrue(cp.isContactPageDisplayed(driver.getTitle()), "Contact tab should be seen");
		Utility.waitForElement(driver,cp.newButton);
		cp.newButton.click();
		Assert.assertTrue(cp.isContactEditPageDisplayed(driver.getTitle()), "new contact page should be seen");
		Utility.waitForElement(driver,cp.lastName);
	    cp.lastName.sendKeys("Indian");
	    cp.lastName.isDisplayed();
	    cp.accountName.sendKeys("Global Media");
	    cp.accountName.isDisplayed();
	    cp.saveButton.click();
	    Assert.assertTrue(cp.contactSaved.isDisplayed(),"New contact is saved");
	    
	}
}