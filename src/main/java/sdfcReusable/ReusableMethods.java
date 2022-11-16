package sdfcReusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {

	public static WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;

	/*
	 * Driver setup if its chrome or firefox or edge browsers
	 */
	public static void init(String browsertype) {
		if (browsertype.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsertype.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsertype.equalsIgnoreCase("microsoftedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
				
		private static Logger logger = LogManager.getLogger(ReusableMethods.class);

		public static String readPropertiesFile(String filename, String key) throws IOException {

			Properties p = new Properties();
			FileReader prop = new FileReader(System.getProperty("user.dir")+ "\\src\\main\\java\\sdfc\\TestData\\"+filename+".properties");
			p.load(prop);
			String value= p.getProperty(key);
			return value;
		}
	

		public static void writeToPropertiesfile() {

		}

	/*	public static String readExcel(String fileName, int rowNumber, int cellNumber) throws IOException {
//			.xlsx
			String filepathXLSX = System.getProperty("user.dir")+ "\\src\\main\\java\\testdata\\"+fileName+".xlsx";
			FileInputStream fis = new FileInputStream(filepathXLSX);
			XSSFWorkbook testData = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = testData.getSheetAt(0);
			String data = sheet1.getRow(rowNumber).getCell(cellNumber).toString();
			String pass ="";
			
//			for(int rownum = 0; rownum<sheet1.getLastRowNum(); rownum++) {
//				for (int coloumn=0; coloumn<sheet1.getRow(rownum).getLastCellNum(); coloumn++) {
//					String value = sheet1.getRow(rownum).getCell(coloumn).toString();
//				}
//			}
//			Map<String, String> loginCreds = new HashedMap<>();
//			loginCreds.put(data, pass)
			return data;
		}
		
		public void writeToExcel(String filename) throws IOException {
			
			String filepathXLSX = System.getProperty("user.dir")+ "\\src\\main\\java\\testdata\\"+filename+".xlsx";

			XSSFWorkbook workbook =  new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(filepathXLSX);
			XSSFRow row0 = sheet.createRow(0);
			row0.createCell(0).setCellValue("");
			FileOutputStream fout = new FileOutputStream("");
			workbook.write(fout);
			fout.close();
			
		}
		*/
	@DataProvider(name = "userNames")
	public Object[][] userCredentials() {

		return new Object[][] { { "abc@gmail.com", "1234" }, { "maya.leo@g.com", "Tester@123" }, { "", "" } };
	}

	/*
	 * go to the website and maximize and verifiy
	 * 
	 */
	public static void navigateTo(String Url) {

		driver.get(Url);
		driver.manage().window().maximize();
		String expresult = "Login | Salesforce";
		String actresult = driver.getTitle();
		Assert.assertEquals(expresult, actresult, "Login page title is not matched");
		System.out.println("Login page is successfully loaded");
	}
	// locating the webelement location by using id,name,class,xpath,css 
	// and returning the webelement to perform any actions on it.
	public static WebElement findElement( String type,String text) {
		WebElement element = null;
		switch (type) {
		case "id":
			element=driver.findElement(By.id(text));
			break;
			
		case "name":
			element=driver.findElement(By.name(text));
			break;
			
		case "class":
			element=driver.findElement(By.className(text));
			break;
			
		case "xpath":
			element = driver.findElement(By.xpath(text));
			break;

		case "css":
			element = driver.findElement(By.cssSelector(text));
			break;
			
		}
		return element;
	}
    //Get title
	public static String getTitlePage()
	{
		return driver.getTitle();
	}
	//explicit wait
	//public static void waitForLoad(long waitTimeInSeconds) {
		//WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
	//}
	
	
	
	// enterText method sends the value to the address of the webElement
	public static void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
		System.out.println("Entered text.....");
	}

	// Click operation performed on webelement
	public static void onClickWebElement(WebElement element, long waitTimeInSeconds) {
		WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		WebElement elements = null;
		elements = webwait.until(ExpectedConditions.elementToBeClickable(element));
		elements.click();
		System.out.println("Performed click operation......");
	}
	  
	 // assertEquals method verifies the actual result to the expected result and
	  //returns boolean true if matches and false it do not match
	  
		public static boolean assertEquals(String actual, String expected) {
			try {
				Assert.assertEquals(expected, actual);
				System.out.println("Actual Result is as expected. Test is passed ");
				return true;
			} catch (Exception e) {
				System.out.println("Actual Result is not as expected. Test is failed ");
				return false;
			}
		}
	 //login with valid credintials
		public static void loginApp(String actusername,String actpassword,String expectedPage) {
			WebElement username= findElement("id","username");
			enterText(username,actusername);
			
			WebElement password=findElement("id","password");
			enterText(password,actpassword);
					
			WebElement login=findElement("id","Login");
			login.click();
			
			String actresult=ReusableMethods.driver.getTitle();
			assertEquals(actresult, expectedPage);
			
		}
	 //selecting a value from dropdown list public void
	 /* selectByVisibility(WebElement element,String text) { Select select=new
	 * Select(element); select.selectByVisibleText(text); }
	 */
	  //to take screenshots
	 public static String captureScreenshots(WebDriver
	 driver) throws IOException { 
		 String dateFormat= new SimpleDateFormat("yyyy_mm_dd_hh_ss").format(new Date()); 
	 TakesScreenshot screenshot=(TakesScreenshot)driver; String
	  destinationPath=System.getProperty("user.dir")+ "\\src\\main\\resources\\screenshots\\"+dateFormat+".PNG"; File sourceFile=
	  screenshot.getScreenshotAs(OutputType.FILE);
	  
	  File destiFile= new File(destinationPath); FileUtils.copyFile(sourceFile,
	  destiFile); System.out.println("Screenshot is captured"); return
	  destinationPath;
	  
	  }
	  
	 /* //mouse hovering from one element to other element public void
	 * mouseHoverClickOn(WebElement element) { Actions action=new Actions(driver);
	 * action.moveToElement(element).click().build().perform();
	 * 
	 * }
	 * 
	 * //Accepting alert from UI public void acceptAlert(WebDriver driver) {
	 * driver.switchTo().alert().accept(); }
	 * 
	 */
}
