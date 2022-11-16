package sdfc.Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sdfc.PageObjectRepository.AccountPage;
import sdfc.PageObjectRepository.LoginPage;
import sdfc.PageObjectRepository.UserMenuPage;
import sdfcReusable.Utility;
import sdfcReusable.sfdclisteners;
@Listeners(sfdclisteners.class)
public class AccountTest extends BaseTest{
	private LoginPage lp = null;
	private UserMenuPage ump = null;
	private AccountPage ap = null;
	
	private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeMethod
	public void driverSetup() throws IOException {
		driver = getBrowser("chrome", false);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Browser is closed.");
	}
	@Ignore
	@Test
	public void CreateAnAccount_TC10() throws IOException {
		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		ap=new AccountPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Assert.assertTrue(ap.isVerifyHomepage("maya Raj"), "home page name should be correct");
		Utility.waitForElement(driver,ap.accountTab);
		ap.accountTab.click();
		test.info("account tab from home page is selected");
		logger.info("account tab is clicked");
		Utility.waitForElement(driver,ap.accountTabNewButton);
		ap.accountTabNewButton.click();
		logger.info("new button to create is clicked");
		test.info("newbutton is selected to create account");
		//Assert.assertTrue(ap.isNewAccountDisplayed(), "new account page is displayed");
		//test.info("new account creating page is displayed successfully");
		Assert.assertTrue(ap.createNewAccount("abc",driver),"new account is created");
		test.info("new account is created");
		//need to validate
	}
	@Test
	public void CreateNewView_TC11() throws IOException {
		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		ap=new AccountPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
	   //need to validate login with correct username
		Utility.waitForElement(driver,ap.accountTab);
		ap.accountTab.click();
		test.info("account tab from home page is selected");
		logger.info("account tab is clicked");
		Utility.waitForElement(driver,ap.createNewViewButton);
		ap.createNewViewButton.click();
		ap.Createview(driver,"viewabc");
		test.info("new view is created successfully");
	}
}
