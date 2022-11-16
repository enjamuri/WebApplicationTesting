package sdfc;

import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class {

	public static void main(String[] args) {
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://www.dbs.com/sustainability/dbs-stronger-together-fund?pid=splitter-dbs-group");
	    
	    WebElement table=driver.findElement(By.xpath("//*[@id='bodywrapper']/div[2]/section/div[1]/div[2]/div/div[5]/table/tbody"));
	    
	    String firstrow=table.getText();
	    String[] s= firstrow.split("\n");
	    System.out.println(Arrays.toString(s));
	    XSSFWorkbook book=new XSSFWorkbook();
	    XSSFSheet sheet=book.createSheet();

	}

}
