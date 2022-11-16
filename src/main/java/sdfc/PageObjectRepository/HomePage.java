package sdfc.PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#phSearchButton")
	public WebElement searchTopButton;
	
	@FindBy(css="#phSearchInput")
	public WebElement textSearchTopButton;
	
	@FindBy(css=".switch-to-lightning")
	public WebElement swtichToLightningExperience;
	
	@FindBy(css="#userNavButton")
	public WebElement userMenu;
	
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
	public WebElement Logout;
	
	
	@FindBy(css="#setupLink")
	WebElement setUp;
	
	@FindBy(css=".brandZeronaryFgr")
	WebElement help;
	
	@FindBy(id="#tsidButton")
	WebElement appMenuDropDown;
	
	//dropdowm of appMenuDropDown button
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[1]")
	WebElement sales;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[2]")
	WebElement services;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[3]")
	WebElement marketing;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[4]")
	WebElement appLauncher;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[5]")
	WebElement community;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[6]")
	WebElement sitecom;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[7]")
	WebElement salesforceChatter;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[8]")
	WebElement allTabs;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[9]")
	WebElement appExchange;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[10]")
	WebElement developerCommunity;
	
	@FindBy(xpath="//div[@id='tsid-menuItems']/a[11]")
	WebElement traiblazerCommunity;
	
	//Tabs
	@FindBy(xpath="//li[@id='home_Tab']/a")
	WebElement homeTab;
	
	@FindBy(xpath="//li[@id='Chatter_Tab']/a")
	WebElement chatterTab;
	
	@FindBy(xpath="//li[@id='ContentSearch_Tab']/a")
	WebElement contentTab;
	
	@FindBy(xpath="//li[@id='ContentSubscriptions_Tab']/a")
	WebElement subscriptionTab;
	
	@FindBy(xpath="//li[@id='Account_Tab']/a")
	WebElement accountTab;
	
	@FindBy(xpath="//li[@id='Contact_Tab']/a")
	WebElement contactTab;
	
	@FindBy(id="Lead_Tab")
	public WebElement leadTab;
	
	@FindBy(xpath="//li[@id='Order_Tab']/a")
	WebElement orderTab;
	
	@FindBy(xpath="//li[@id='Opportunity_Tab']/a")
	WebElement opportunityTab;
	
	@FindBy(xpath="//li[@id='AllTab_Tab']/a")
	WebElement moreTab;
	
	
	@FindBy(xpath="//input[@id='setupSearch']")
	WebElement quickFindSearch;
	
	@FindBy(css="#setupNavExpandAll")
	WebElement expandAll;
	
	@FindBy(css="#setupNavCollapseAll")
	WebElement collapseAll;
	
	@FindBy(xpath="//input[@value='Get Started']")
	WebElement getStartedButton;
	//Quick Links
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[1]/ul/li[1]/a")
	WebElement appQuickStart;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[1]/ul/li[2]/a")
	WebElement schemaBuilder;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[1]/ul/li[3]/a")
	WebElement newCustomApp;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[2]/ul/li[1]/a")
	WebElement newUser;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[2]/ul/li[2]/a")
	WebElement addMultipleUsers;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[2]/ul/li[3]/a")
	WebElement resetUsersPassword;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[3]/ul/li[1]/a")
	WebElement manageApps;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[3]/ul/li[2]/a")
	WebElement manageProfiles;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[3]/ul/li[3]/a")
	WebElement enableChatterFeeds;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[5]/ul/li[1]/a")
	WebElement newProfile;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[5]/ul/li[2]/a")
	WebElement newPemissionSet;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[5]/ul/li[3]/a")
	WebElement addRoles;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[6]/ul/li[1]/a")
	WebElement importAccountsContacts;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[6]/ul/li[2]/a")
	WebElement importCustomObjects;
	
	@FindBy(xpath="//div[@id='quicklinks']/div[2]/div/div[6]/ul/li[3]/a")
	WebElement massDeleteRecord;
	
	@FindBy(xpath="//td[@id='content_wrap:mruTable:0:mruName']/a")
	WebElement recentItems1stLink;
	
	@FindBy(xpath="//td[@id='content_wrap:mruTable:0:mruType']")
	WebElement recentItems2ndLink;
	
}
