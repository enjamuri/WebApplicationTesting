package sdfc.PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPageFinal extends BasePage{
	
	public LeadPageFinal(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="Lead_Tab")
	public WebElement leadtab;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement dropDownLeadTab;

	@FindBy(css="img[class='pageTitleIcon']")
	public WebElement leadspagelogo;
	
	@FindBy(xpath="//select[@name='fcf']//option[4]")
	public WebElement dropDownTodaysLead;
	
	@FindBy(css="#tsidLabel")
	public WebElement pageDisplay;
	
	@FindBy(xpath="//input[@title='Go!']")
	public WebElement goButton;
	
	public void leadDropDown(WebDriver driver,String value) {
		WebElement element=driver.findElement(By.cssSelector("a[title='" + value + "']"));
		//option[@value='00B8V00000BgGCN']
	}
	
	public boolean isLeadTabSeen() {
		if(leadtab.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLeadPageDisplayed() throws InterruptedException {
		Thread.sleep(2000);
		if(leadspagelogo.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isdropdowntitle() {
		String actresult=dropDownLeadTab.getText();
		String expresult="Today's Leads";
		System.out.println(actresult);
		if(actresult.contains(expresult)) {
			return true;
		} else {
			return false;
		}
	}
}
