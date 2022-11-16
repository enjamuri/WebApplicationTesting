package myinterview;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDataPresentInTable {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	         
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
         WebElement table=driver.findElement(By.xpath("//table[@id='customers']/tbody"));
		
		int row=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		//int column=table.findElements(By.xpath("tr[1]/td")).size();
		int col=driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		System.out.println(row +"-rows,"+col+"-col");
		
		
		System.out.println(DataPresentInWebTable("Italy",row,col));	
		
		String filepath=".\\webTableToExcel\\w3schooltable.xlsx";
		driver.close();

	}
	
	public static void writedata(String filepath,int row,int col) throws IOException
	{
		
	}
	
	public static boolean DataPresentInWebTable(String s,int row,int col) throws InterruptedException
	{
		boolean flag=false;
		
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<=col;j++)
			{
			String actualvalue=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
			   if(actualvalue.equals(s))
			   {
				   flag=true;
				   System.out.println("Found the value"+ s+" is present at "+i+"-row"+ j+"-column");
				   break;
			   }
			}
		}
	 return flag;
	}

}
