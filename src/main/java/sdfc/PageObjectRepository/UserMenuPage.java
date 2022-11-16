package sdfc.PageObjectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import sdfcReusable.ReusableMethods;
import sdfcReusable.Utility;

public class UserMenuPage extends BasePage {
	
	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#userNavButton")
	public WebElement userMenu;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	//Dropdown of usermenu
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[1]")
	public WebElement Myprofile;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[2]")
	public WebElement MySettings;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[3]")
	public WebElement DeveloperConsole;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[4]")
	public WebElement switchToLightningExp;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[5]")
	public WebElement logout;
	
	//My profile page locators
	//userprofile page display use to check the profile name displayed correctly
	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement userProfilepagenamedisplay;
	
	//edit pencil icon 
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	public WebElement editprofilebutton;
	
    //new popup window opens when we click on edit button
	@FindBy(xpath = "//div[@id='contactInfo']")
	public WebElement EditProfilePopupwindow;
	
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	public WebElement iframeid;
	
	@FindBy(xpath = "#contactInfo")
	public WebElement EditPopupwindow;
	
	@FindBy(xpath="//li[@id='aboutTab']")
	public WebElement aboutTab;

	@FindBy(xpath="//input[@id='lastName']")
	public WebElement aboutTablastname;

	@FindBy(css = "#firsttName")
	public WebElement aboutTabfirstname;
	
	@FindBy(css = "#communityNickname")
	public WebElement aboutTabNickName;
	
	@FindBy(css = "#title")
	public WebElement aboutTabTitle;
	
	@FindBy(css = "#Manager")
	public WebElement aboutTabManager;
	
	@FindBy(xpath = "//input[@class='zen-btn zen-primaryBtn zen-pas']")
	public WebElement saveall;
	
	@FindBy(xpath = "#editContactInfoCancelButton")
	public WebElement cancel;
	
	//contactTab details
	@FindBy(css = "#contactTab")
	public WebElement contactTab;
	
	@FindBy(css = "#email")
	public WebElement contactTabEmail;
	
	@FindBy(css = "#phone")
	public WebElement contactTabWorkPhone;
	
	@FindBy(css = "#cell")
	public WebElement contactTabMobilePhone;
	
	@FindBy(css = "#fax")
	public WebElement contactTabFax;
	
	@FindBy(xpath="//textarea[@id='street']")
	public WebElement contactTabStreetAddress;
	
	@FindBy(css = "#city")
	public WebElement contactTabcity;
	
	@FindBy(css = "#state")
	public WebElement contactTabstate;
	
	@FindBy(css = "#zipcode")
	public WebElement contactTabZipcode;
	
	@FindBy(css = "#country")
	public WebElement contactTabCountry;
	
	//Post link and share the link in the edit page of my profile
	// Postlink
		@FindBy(css = "#publishereditablearea")
		public WebElement postlink;

		//@FindBy(xpath = "/html/body")
		//public WebElement postcontent;
		@FindBy(xpath = "/html/body")
		public WebElement postTextArea;

		@FindBy(xpath = "//input[@id='publishersharebutton']")
		public WebElement shareButton;
		
		//file tab on the profile page
		@FindBy(xpath = "//a[@id='publisherAttachContentPost']")
		public WebElement filelink;
		
		@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
		public WebElement contentpost;
		
		@FindBy(css = "#chatterUploadFileAction")
		public WebElement Uploadfile;

		@FindBy(css = "#chatterFile")
		public WebElement Fileopen;

		@FindBy(css = "#publishersharebutton")
		public WebElement publish;

		// link tab 

		@FindBy(xpath = "//a[@id='publisherAttachLinkPost']/span[1]")
		public WebElement photolink;

		@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
		public WebElement uploadphoto;

		@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
		public WebElement uploadbutton;

		@FindBy(id = "publishersharebutton")
		public WebElement photosharebutton;
		
		// My Settings
		// personallink click and go to loginhistory 

		@FindBy(css = "#PersonalInfo_font")
		public WebElement personallink;

		@FindBy(xpath = "//a[@id='LoginHistory_font']")
		public WebElement loginHistorylink;

		//not working
		@FindBy(xpath = "//a[@id='RelatedUserLoginHistoryList_body']/div/a")
		public WebElement logindisplay;
		
		//my settings go to display and layout page
		// Display&layoutlink

		@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
		public WebElement DisplayLayoutlink;

		@FindBy(id = "CustomizeTabs_font")
		public WebElement CustomizedMyTabs;
		
		
		@FindBy(id = "//select[@id='p4']")
		public WebElement customAppContentDropDown;

		@FindBy(xpath = "//*[@id='p4']/option[9]")
		public WebElement customAppDropDownOptions;
        //Available tab option 73
		@FindBy(xpath = "//*[@id='duel_select_0']/option[73]")
		public WebElement Availabletab;

		@FindBy(xpath = "//img[@class='rightArrowIcon']")
		public WebElement Add;

		@FindBy(xpath = "//td[@id='bottomButtonRow']/input[1]")
		public WebElement save;

		@FindBy(id = "tabBar")
		public WebElement tabList;
		

		// Emaillink

		@FindBy(xpath = "//div[@id='EmailSetup']")
		public WebElement emailLink;

		@FindBy(xpath = "//div[@id='EmailSetup_child']/div/a/span")
		//@FindBy(xpath="//a[@id='EmailSettings_font']")
		public WebElement myEmailSettings;
		
//email name in the myemail setting page
		@FindBy(xpath = "//input[@id='sender_name']")
		public WebElement emailName;

		@FindBy(css= "#sender_email")
		public WebElement emailAddress;

		@FindBy(xpath = "//*[@id='useremailSection']/table/tbody/tr[7]/td[2]/div")
		public WebElement bccradiobutton;
		
		@FindBy(css= "#auto_bcc1")
		public WebElement bccradiobuttonYes;
		
		@FindBy(css = "#auto_bcc1")
		public WebElement bccradiobuttonNo;
		
		@FindBy(xpath = "//input[@name='save']")
		public WebElement saveButton;
		
		@FindBy(xpath = "//input[@name='cancel']")
		public WebElement cancelButton;
       
		// Calendar and Remainders
		@FindBy(id = "CalendarAndReminders_font")
		public WebElement CalendarAndReminders;

		@FindBy(xpath = "//a[@id='Reminders_font']")
		public WebElement ActivityRemainder;

		@FindBy(id = "testbtn")
		public WebElement OpenaTestRemainder;

		@FindBy(xpath = "//*[@id='summary']")
		public WebElement SampleEventPopup;

// the methods/functions that required in this UsermenuPage
		/**
		 * This function is responsible to verify user menu items in user menu drop down
		 * This function has to be called after clicking on user menu
		 * 
		 * @return {Boolean} true if all options are verified successfully else returns
		 *         false
		 */
		public boolean verifyUserMenuItems() {
			boolean isOptionVerified = true;
			String[] expectedUserMenuItems = { "My Profile", "My Settings", "Developer Console",
					"Switch to Lightning Experience", "Logout" };
//			List<WebElement> listOfuserMenuElements 
			for (int i = 0; i < userMenuOptions.size(); i++) {
				String actualUserMenuItemValue = userMenuOptions.get(i).getText();
				if (actualUserMenuItemValue.equals(expectedUserMenuItems[i])) {
					System.out.println("The option " + expectedUserMenuItems[i] + " passed");
				} else {
					System.out.println("The option " + expectedUserMenuItems[i] + " failed");
					isOptionVerified = false;
				}
			}
			return isOptionVerified;
		}

		/**
		 * This function is responsible to select user menu item in user menu drop down
		 * by passing an option name
		 * 
		 * @param optionName example: {"My profile", "Settings"}
		 * @return true if option is selected else false
		 */
		public boolean selectOptionInUserMenuDropDown(WebDriver driver,String optionName) {
			boolean isOptionSelected = false;
			WebElement userMenuOption = driver.findElement(By.cssSelector("a[title='" + optionName + "']"));
			
			if (userMenuOption.isDisplayed()) {
				userMenuOption.click();
				logger.info("selectoption menu is clicked");
				isOptionSelected = true;
			} else {
				System.out.println("Option " + optionName + " not selected");
				logger.info("selectoption menu is not found");
			}
			return isOptionSelected;
		}

		/*
		/**
		 * This function will create a post, Should be called in my profile page
		 * @param textBox WebElement
		 * @param message to be posted in text box
		 * @param button
		 * @return true if post is created else false
		 */
		/*public boolean createAPost(WebDriver driver, String message) {
			boolean isPostCreated = false;
			if (postlink.isDisplayed()) {
				postlink.click();
				System.out.println("Clicked on the text box");
				driver.switchTo().frame(0);
				postTextArea.sendKeys(message);
				driver.switchTo().defaultContent();
				System.out.println("Entered the text in text box");
				if (shareButton.isDisplayed()) {
					shareButton.click();
					System.out.println("Clicked on the post button");
					isPostCreated = true;
				}
			}
			return isPostCreated;
		}*/
		/**
		 * This function will create a post, Should be called in my profile page
		 * @param textBox WebElement
		 * @param message to be posted in text box
		 * @param button
		 * @return true if post is created else false
		 */
		public boolean createAPost(WebDriver driver, String message) {
			boolean isPostCreated = false;
			if (postlink.isDisplayed()) {
				postlink.click();
				System.out.println("Clicked on the text box");
				driver.switchTo().frame(0);
				postTextArea.sendKeys(message);
				driver.switchTo().defaultContent();
				System.out.println("Entered the text in text box");
				if (shareButton.isDisplayed()) {
					shareButton.click();
					System.out.println("Clicked on the post button");
					isPostCreated = true;
				}
			}
			return isPostCreated;
		}
		
		
		
		public boolean isUserMenuSeen() {
			if(userMenu.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}
		public boolean isloginHistorySeen() {
			if(loginHistorylink.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		}
		public void clickOnUserMenu() {
			if(userMenu.isDisplayed()) {
				userMenu.click();
			}
		}
		public void clickOnEditIcon() {
			if(editprofilebutton.isDisplayed()) {
				editprofilebutton.click();
			}
		}
		
		public void clickOnWebElement(WebElement element) {
			if(element.isDisplayed()) {
				element.click();
			}
		}
		
		public boolean openEditProfileModal() throws InterruptedException {
			boolean isEditProfileWindowSeen = false;
			if(editprofilebutton.isDisplayed()) {
				Thread.sleep(2000);
				editprofilebutton.click();
				if(EditProfilePopupwindow.isDisplayed()) {
					isEditProfileWindowSeen = true;
				}
			}
			return isEditProfileWindowSeen;
		}
		
		public boolean changeLastNameInAboutTab(WebDriver driver, String lastName) {
			driver.switchTo().frame("contactInfoContentId");
			boolean isLastNameChanged = false;
			if(aboutTab.isDisplayed()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aboutTab.click();
				if (aboutTablastname.isDisplayed()) {
					aboutTablastname.clear();
					aboutTablastname.sendKeys(lastName);
					saveall.click();
					isLastNameChanged = true;
				}
			} 
			driver.switchTo().defaultContent();
			return isLastNameChanged;
		}
		
		//swtich between new window
		public boolean switchToNewWindows(WebDriver driver) {
			boolean isNewWindowdisplayed=false;
			Set<String> windows=driver.getWindowHandles();
	    	Iterator<String> it=windows.iterator();
	    	String parentwindowid=it.next();
	    	String childwindowid=it.next();
	    	
	    	if(childwindowid!=null)
             {
	    		driver.switchTo().window(childwindowid);
	    		logger.info("driver is swtiched to new window: ",driver.getTitle());
	    		isNewWindowdisplayed=true;
	    		driver.close();
	    		logger.info("new window is closed");
	    		driver.switchTo().window(parentwindowid);
	    		logger.info("driver is swtiched to old window: ",driver.getTitle());
             }
	    	return isNewWindowdisplayed;
	    	
	    	
		}
		//@FindBy(xpath="//div[@id='main']")
		@FindBy(css="#logo")
		public WebElement loginpage;
		//check if logout successful validating
		public boolean isLoginpageDisplayed(WebDriver driver)
		{
			boolean loginpagedisplayed=false;
			Utility.waitForElement(driver,loginpage);
			if(loginpage.isDisplayed())
			{
				loginpagedisplayed=true;
				logger.info("login page is displayed successfully ");
			}
			return loginpagedisplayed;
		}
	//mysettings display and layout
		public void displayandlayoutaction(WebDriver driver) {
			DisplayLayoutlink.click();
			logger.info("display and layout is selected");
			Utility.waitForElement(driver,CustomizedMyTabs);
			clickOnWebElement(CustomizedMyTabs);
			logger.info("cutomized my tabs is selected");
			Utility.waitForElement(driver,customAppDropDownOptions);
			logger.info("salesforce chatter is selected from drop down");
			Utility.waitForElement(driver,Availabletab);
			Add.click();
			save.click();
			isactionperformed=true;
			logger.info("saved the selected option");
		}
		public boolean isactionperformed=false;
		public boolean isReportdisplayed() {
			if(isactionperformed)
			{
				return isactionperformed;
			}
		   return isactionperformed;
		}

		//email setting
		public void emailSettingActions(WebDriver driver){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			emailLink.click();
			//Utility.waitForElement(driver, myEmailSettings);
			clickOnWebElement(myEmailSettings);
			logger.info("Email setting is selected");
			//Utility.waitForElementToDisplay(driver,emailName);
			emailName.clear();
			emailName.sendKeys("mayaleo");
			emailAddress.clear();
			emailAddress.sendKeys("mayaleo@g.com");
			clickOnWebElement(bccradiobutton);
			clickOnWebElement(saveButton);
			logger.info("performed all the email setting actions");
			
		}
	
	
}
