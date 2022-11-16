package paralletesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paralleltestingdemo {

	
	
	@Test
	public void test4() throws Exception {
		System.out.println(" I am in test4 | "+ Thread.currentThread().getId());
	}
	@Test
	public void test1() throws Exception {
		System.out.println(" I am in test1 | "+ Thread.currentThread().getId());
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://facebook.com");
    	//driver.manage().window().maximize();
    	Thread.sleep(1000);
    	driver.close();
	}
	@Test(threadPoolSize = 3,invocationCount = 3,timeOut = 2000)
	public void test2() throws Exception {
		System.out.println(" I am in test2 | "+Thread.currentThread().getId());
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://google.com");
    	//driver.manage().window().maximize();
    	Thread.sleep(2000);
    	//driver.close();
	}
	@Test
	public void test3() {
		System.out.println(" I am in test3 | "+Thread.currentThread().getId());
	}
}
