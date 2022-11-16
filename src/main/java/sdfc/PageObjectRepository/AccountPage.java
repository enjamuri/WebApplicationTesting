package sdfc.PageObjectRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sdfcReusable.Utility;

public class AccountPage extends BasePage{
	
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//click account tab
	@FindBy(css="a[title='Accounts Tab']")
	public WebElement accountTab;
	
	@FindBy(xpath="//input[@title='New']")
	public WebElement accountTabNewButton;
	
	@FindBy(css=".pageDescription")
	public WebElement newAccountPage;
	@FindBy(id="acc2")
	public WebElement accountNameAccountPage;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement saveButtonAccountPage;
	
	@FindBy(xpath="//div[@class='bFilterView']//a[text()='Create New View']")
	public WebElement createNewViewButton;
	
	@FindBy(xpath="//div[@class='requiredInput']//input[@id='fname']")
	public WebElement viewnameTextbox;
	@FindBy(xpath="//div[@class='requiredInput']//input[@id='devname']")
	public WebElement uniqueviewnameTextbox;
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement saveButton;
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement homepageaccountname;
	public boolean isNewAccountDisplayed() {
	    boolean verifyNewAccount=false;
	    if(newAccountPage.isDisplayed())
	    {
	    	verifyNewAccount=true;
	    }
	    return verifyNewAccount;
	}
	public boolean isVerifyHomepage(String expresult) {
		String actresult=homepageaccountname.getText();
		if(actresult.equals(expresult))
		{return true;
		}
		else
			return false;
	}
		
	
	public boolean createNewAccount(String name,WebDriver driver) {
		String date = new SimpleDateFormat("hh_mm_ss").format(new Date());
		String accountname=name+date;
		Utility.waitForElement(driver, accountNameAccountPage);
		
		accountNameAccountPage.sendKeys(accountname); 
		logger.info("new account name is created");
		saveButtonAccountPage.click();
		logger.info("new account is created");
		return true;
	}
	public void Createview(WebDriver driver,String viewname) {
		String date = new SimpleDateFormat("hh_mm_ss").format(new Date());
		String newviewname=viewname+date;
		Utility.waitForElementToDisplay(driver,viewnameTextbox);
		viewnameTextbox.sendKeys(newviewname);
		logger.info("view name is entered in the textbox");
		//Utility.waitForElementToDisplay(driver,uniqueviewnameTextbox);
		uniqueviewnameTextbox.sendKeys("abcd");
		logger.info("unique view name is entered");
		saveButton.click();
		logger.info("new view is saved successfully");
	}
}
