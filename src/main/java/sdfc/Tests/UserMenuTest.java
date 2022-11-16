package sdfc.Tests;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import sdfc.PageObjectRepository.LoginPage;
import sdfc.PageObjectRepository.UserMenuPage;
import sdfcReusable.ReusableMethods;
import sdfcReusable.Utility;
import sdfcReusable.sfdclisteners;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(sfdclisteners.class)
public class UserMenuTest extends BaseTest {
	
	private LoginPage lp = null;
	private UserMenuPage ump = null;
	private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeMethod
	public void driverSetup() throws IOException {
		driver = getBrowser("chrome", false);
//		driver = getBrowser("chrome", false);
//		threadLocalDriver.set(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		logger.info("Browser is closed.");
	}
	
	@Test
	public void Selectusermenu_TC05() throws IOException {
		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		//test=extent.createTest("TC05");
		test.info("App launched");
		Utility.waitForElement(driver, ump.userMenu);
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu should be seen");
		test.info("usermenu is displayed");
		ump.clickOnUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"User menu options should be in order");
		test.info("usermenu options are verified");
	}
	

	@Test(groups = "Usermenu", priority=1)
	public void editProfile_TC06() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		test.info("App launched");
		Utility.waitForElement(driver, ump.userMenu);
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu should be seen");
		ump.clickOnUserMenu();
		test.info("usermenu is clicked");
		Assert.assertTrue(ump.verifyUserMenuItems(),"User menu options should be in order");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "My Profile"),"My profile should be clickable");
		Utility.waitForElement(driver, ump.editprofilebutton);
		test.info("edit icon from my profile is selected");
		Assert.assertTrue(ump.openEditProfileModal(), "Edit profile modal should be opened");
		Assert.assertTrue(ump.changeLastNameInAboutTab(driver,"Raj"),"About tab should be selected");
		test.info("last name in the about tab is changed");
		Utility.waitForElement(driver, ump.postlink);
		Assert.assertTrue(ump.createAPost(driver, "Hello world"), "Post should be created");
		test.info("posted the given message in the my profile post");
	}

	@Test(groups = "Usermenu",priority=2)
	public void mySettings_TC07() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		test.info("App launched");
		Utility.waitForElement(driver, ump.userMenu);
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu should be seen");
		ump.clickOnUserMenu();
		test.info("usermenu is clicked");
		Assert.assertTrue(ump.verifyUserMenuItems(),"User menu options should be in order");
		test.info("user menu is verified");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "My Settings"),"My profile should be clickable");
		test.info("mysettings menu is selected");
		Utility.waitForElement(driver, ump.personallink);
		ump.clickOnWebElement(ump.personallink);
		Utility.waitForElement(driver,ump.loginHistorylink);
		Assert.assertTrue(ump.isloginHistorySeen(), "Login history page is displayed");
		test.info("login history page is displayed");
		Utility.waitForElement(driver,ump.DisplayLayoutlink);
		test.info("display and layout is selected");
		ump.displayandlayoutaction(driver);
		test.info("performed selected operation in the customtab");
		Assert.assertTrue(ump.isactionperformed, "Action is performed on the custom report");
		ump.emailSettingActions(driver);
		test.info("email actions are successfully performed");
	
	}	
	
	
	@Test(priority=3)
	public void selectDevConsole_tc08() throws IOException {
		
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver, ump.userMenu);
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu should be seen");
		ump.clickOnUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"User menu options should be in order");
		test.info("user menu order is verified");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Developer Console (New Window)"),"Developer console should be clickable");
	    test.info("developer console is selected");
	    Assert.assertTrue(ump.switchToNewWindows(driver),"Develeoper window is displayed and cloased successfull");
	    test.info("developer window is displayed and closed");
	    
	}
	
	@Test(priority=4)
    public void logoutOptionSelected_TC09() throws Throwable 
	   {
		//WebDriver driver = getBrowser("chrome", false);
		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver, ump.userMenu);
		Assert.assertTrue(ump.isUserMenuSeen(),"User menu should be seen");
		ump.clickOnUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems(),"User menu options should be in order");
		test.info("user menu order is verified");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clickable");
	    test.info("logout is selected");
		Assert.assertTrue(ump.isLoginpageDisplayed(driver),"Login page is displayed successfully");
		test.info("loginpage is displayed successfully");
		
    	
    }
}

