package sdfc;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsdemo {
  public static void main(String[] args) {
	    
	 //.html,.klov 
	  String dateFormat=new SimpleDateFormat("yyyy_mm_dd_hh_ss").format(new Date());
	  String reportPath= System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+dateFormat+".html";
	  
	   ExtentReports extent=new ExtentReports();
	   ExtentHtmlReporter htmlreport= new ExtentHtmlReporter(reportPath);
	
	   extent.attachReporter(htmlreport);
	   //logging to application
	   ExtentTest test1=extent.createTest("TC01");
	   test1.info("app launched");
	   test1.info("Entered username");
	   test1.info("Entered password");
	   test1.info("Click on login button");
	   test1.pass("TC01 is passed");
	   
	   ExtentTest test2=extent.createTest("TC02");
	   test2.info("app launched");
	   test2.info("Entered username");
	   test2.info("Entered password");
	   test2.info("Click on login button");
	   test2.info("Error message displayed");
	   test2.fail("TC02 is failed");
	   
	   
	   	extent.flush();
	   
}
}
