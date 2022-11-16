package sdfc.PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage {
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="Contact_Tab")
	public WebElement contactTab;
	
	@FindBy(xpath="//input[@id='name_lastcon2']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='con4']")
	public WebElement accountName;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@name='save']")
	public WebElement saveButton;
	
	@FindBy(css=".topName")
	public WebElement contactSaved;
	
	@FindBy(xpath="//a[text()='Create New View']")
	public WebElement createNewView;

	@FindBy(css="#fname")
	public WebElement viewName;

	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement createViewPagedisplay;
	
	@FindBy(xpath="(//input[@title='Save'])[1]")
	public WebElement saveView;
	
	@FindBy(xpath="//img[@class='pageTitleIcon']")
	public WebElement viewSavedPage;
	
	public boolean isdisplayedText(WebElement element) 
	{
		if(element.isDisplayed()) 
		{
		return true;
		}
		return false;
	}
	
	@FindBy(css="#devname")
	public WebElement viewUniqueName;
	public boolean isContactPageDisplayed(String s)
	{
		String Exptitle="Contacts: Home ~ Salesforce - Developer Edition";
		//System.out.println("acttitle= " + s);
		if(s.equals(Exptitle))
		{
			return true;
		}
		else 
			return false;
	}
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newButton;
	
	public boolean isContactEditPageDisplayed(String s)
	{
		String Exptitle="Contact Edit: New Contact ~ Salesforce - Developer Edition";
		//System.out.println(s);
		if(s.equals(Exptitle))
		{
			return true;
		}
		else 
			return false;
	}
	
}
