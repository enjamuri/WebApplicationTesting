package webTableToExcel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryPopulationTable {

	public static void main(String[] args) throws IOException {
        
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		driver.manage().window().maximize();
		
		String path=".\\src\\main\\java\\webTableTOExcel\\file.xlsx";
		
		Reusefile reuse=new Reusefile(path);
		
	    reuse.writeToExcel("sheet1", 0, 0, "country");
	    reuse.writeToExcel("sheet1", 0, 1, "Population");
	    reuse.writeToExcel("sheet1", 0, 2, "perOfTheWorld");
	    reuse.writeToExcel("sheet1", 0, 3, "Date");
	    reuse.writeToExcel("sheet1", 0, 4, "Source");
		
		WebElement table= driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody"));
		int rows=table.findElements(By.xpath("tr")).size();
		
		for(int i=1;i<=rows;i++)
		{
			//read data from web
			String country=table.findElement(By.xpath("tr["+i+"]/td[1]")).getText();
			String Population=table.findElement(By.xpath("tr["+i+"]/td[2]")).getText();
			String perOftheworld=table.findElement(By.xpath("tr["+i+"]/td[3]")).getText();
			String Date=table.findElement(By.xpath("tr["+i+"]/td[4]")).getText();
			String Source=table.findElement(By.xpath("tr["+i+"]/td[5]")).getText();
			
			System.out.println(country+Population+perOftheworld+Date+Source);
			
			//write dat to excel
			reuse.writeToExcel("Sheet1", i, 0, country);
			reuse.writeToExcel("Sheet1", i, 1, Population);
			reuse.writeToExcel("Sheet1", i, 2, perOftheworld);
			reuse.writeToExcel("Sheet1", i, 3, Date);
			reuse.writeToExcel("Sheet1", i, 4, Source);
			
		}
		driver.close();
		System.out.println("web Scrapping is successful");
	}

}
