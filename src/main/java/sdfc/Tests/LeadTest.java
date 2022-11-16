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

import sdfc.PageObjectRepository.LeadPageFinal;
import sdfc.PageObjectRepository.LoginPage;
import sdfc.PageObjectRepository.UserMenuPage;
import sdfcReusable.ReusableMethods;
import sdfcReusable.Utility;
import sdfcReusable.sfdclisteners;

@Listeners(sfdclisteners.class)
public class LeadTest extends BaseTest {
	private LoginPage lp = null;
	private UserMenuPage ump = null;
	
	private LeadPageFinal ldp= null;
	private static Logger logger = LogManager.getLogger(LeadTest.class.getName());
	
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
	public void checkLeadTabLink_TC20() throws Throwable {

		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		ldp = new LeadPageFinal(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver, ldp.leadtab);
		Assert.assertTrue(ldp.isLeadTabSeen(), "lead Tab should be seen");
		ldp.leadtab.click();
		Assert.assertTrue(ldp.isLeadPageDisplayed(), "lead page should be displayed");
		test.info("lead home page is verified");
		logger.info("lead home page is displayed successfully");
	}
	@Ignore
	@Test
	public void leadSelectView_TC21() throws Throwable {

		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		ldp = new LeadPageFinal(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver, ldp.leadtab);
		Assert.assertTrue(ldp.isLeadTabSeen(), "lead Tab should be seen");
		ldp.leadtab.click();
		test.info("lead tab is selected");
		Assert.assertTrue(ldp.isLeadPageDisplayed(), "lead page should be displayed");
		test.info("lead home page is verified");
		logger.info("lead home page is displayed successfully");
		ldp.dropDownLeadTab.click();
		test.info("leaddropdown is selected");
		logger.info("lead dropdown is selected ");
		//how to verify the drop down since it is disappearing quickly
		
		
	}
	@Test
	public void leadfunctionalityOfGoButton_TC22() throws Throwable {

		lp = new LoginPage(driver);
		ump = new UserMenuPage(driver);
		ldp = new LeadPageFinal(driver);
		lp.launchApp(driver);
		lp.loginToApp();
		logger.info("login into the account");
		test.info("App launched");
		Utility.waitForElement(driver, ldp.leadtab);
		Assert.assertTrue(ldp.isLeadTabSeen(), "lead Tab should be seen");
		ldp.leadtab.click();
		test.info("lead tab is selected");
		Assert.assertTrue(ldp.isLeadPageDisplayed(), "lead page should be displayed");
		test.info("lead home page is verified");
		logger.info("lead home page is displayed successfully");
		ldp.dropDownLeadTab.click();
		test.info("leaddropdown is selected");
		logger.info("lead dropdown is selected ");
		ldp.dropDownTodaysLead.click();
		test.info("dropdown todayslead is selected");
		logger.info("dropdown todaylead is selected");
		Assert.assertTrue(ldp.isdropdowntitle(), "Today's lead should be displayed");
		
		Utility.waitForElement(driver, ump.userMenu);
		test.info("Waiting for usermenu to appear");
		//Assert.assertTrue(ump.isUserMenuSeen(),"User menu options should be seen");
		ump.clickOnUserMenu();
		test.info("Clicked on user menu");
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"), "logout option should be visible and clickable");
		Utility.waitForElementToDisplay(driver, lp.username);
		lp.enterUsername(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.username"));
		test.info("Valid username is entered");
		lp.enterPassword(ReusableMethods.readPropertiesFile("logintestdata", "prod.valid.password"));
		test.info("Valid password is entered");
		lp.clickLogin();
		test.info("Login button clicked");Utility.waitForElement(driver, ldp.leadtab);
		Assert.assertTrue(ldp.isLeadTabSeen(), "lead Tab should be seen");
		ldp.leadtab.click();
		test.info("lead tab is selected");
		Assert.assertTrue(ldp.isdropdowntitle(), "Today's lead should be displayed");
		ldp.goButton.click();
		//validate the gobutton displays files 
	}
	//@Test
	//public void 
	
}
