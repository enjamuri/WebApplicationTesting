package sdfc.Tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sdfc.PageObjectRepository.LoginPage;
import sdfc.PageObjectRepository.UserMenuPage;
import sdfcReusable.ReusableMethods;
import sdfcReusable.Utility;
import sdfcReusable.sfdclisteners;

@Listeners(sfdclisteners.class)
public class LoginTest extends BaseTest{

	private LoginPage lp=null;
	private UserMenuPage ump=null;
	public static Logger logger=LogManager.getLogger(LoginTest.class.getName());
	
	
	@BeforeMethod
	public void driverSetup(ITestContext iTest) throws IOException {
		
//		driver = getBrowser("chrome", false);
//		threadLocalDriver.set(driver);
		this.context = setContext(iTest, driver);
		
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
//		if(ITestResult.FAILURE == result.getStatus()) {
//			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
//		}
		driver.quit();
		logger.info("Browser is closed.");
	}

	@Test(dataProviderClass = LoginTest.class, groups = "Login")
	public void loginErrorMessage_TC01() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		//test=extent.createTest("TC01");
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Username is entered");
		lp.clearPassword();
		test.info("Password cleared");
		lp.clickLogin();
		test.info("Login button clicked");
		Assert.assertTrue(lp.isErrorMessageSeen(), "Error message should be visible");
		test.info("Login error message is seen");
		Assert.assertEquals(lp.getErrorMessage(), ReusableMethods.readPropertiesFile("logintestdata", "login.error.emptypasssword"));
		test.info("Empty password error message verified");
	}
 @Ignore
	@Test(groups = "Login", priority = 1)
	public void loginToSFDC_TC02() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		//test=extent.createTest("TC02");
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Valid username is entered");
		lp.enterPassword(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.password"));
		test.info("Valid password is entered");
		lp.clickLogin();
		test.info("Login button clicked");
		//Assert.assertTrue(lp.isFreeTrailSeen(), "Free trial option should be available");
		//test.info("Free trial is seen");
	}
 @Ignore	
	@Test (groups = "Login",priority = 2)
	public void checkRememberMe_TC03() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Valid username is entered");
		lp.enterPassword(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.password"));
		test.info("Valid password is entered");
		Assert.assertTrue(lp.selectRemeberMeCheckbox(),"Remember me checkbox should be selected");
		test.info("Remember me checkbox selected");
		lp.clickLogin();
		test.info("Clicked on login button");
		Utility.waitForElement(driver, ump.userMenu);
		test.info("Waiting for usermenu to appear");
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu options should be seen");
		ump.clickOnUserMenu();
		test.info("Clicked on user menu");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"), "logout option should be visible and clickable");
		Utility.waitForElement(driver, lp.savedUsername);
		Assert.assertTrue(lp.isSavedUsernameSeen(), "username should be saved");
		Utility.waitForElement(driver, lp.savedUsername);
		Assert.assertEquals(lp.getSavedUsername(), ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.username"), "Saved username and entered username should be same" );
		test.info("User name is saved "+lp.getSavedUsername());
	}
 @Ignore
	@Test(groups = "Login",priority=3)
	public void forgotPassword_TC04A() throws IOException, InterruptedException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.clickForgotYourPassword();
		Utility.waitForElement(driver, lp.forgotUsername);
		Assert.assertTrue(lp.isForgotPassowrdDisplayed(), "Forgot password screen should be displayed");
		lp.enterForgotUsername(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.actualusername"));
		lp.continueButton.click();
		Assert.assertTrue(lp.passwordResetScreen.isDisplayed(), "password reset message should be seen");
		
	}
 @Ignore
	@Test(groups = "Login",priority = 4)
	public void forgotPassword_TC04B() throws IOException {
		WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		test.info("App launched");
		lp.enterUsername("123");
		test.info("entered username");
		lp.enterPassword("22131");
		test.info("entered password");
		Utility.waitForElement(driver, lp.password);
		lp.clickLogin();
		Assert.assertEquals(lp.getErrorMessage(), ReusableMethods.readPropertiesFile("logintestdata", "login.error.up"));
	    test.info("testcase passed");
	}

	

	
}
