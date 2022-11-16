package sdfcReusable;

import java.io.IOException;
import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import sdfc.Utilities;
import sdfc.Tests.BaseTest;

public class sfdclisteners extends BaseTest implements ITestListener {
	private WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
        System.out.println("listener is stated");
		test = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		
		test.pass(result.getName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Object currentClass = result.getInstance();
        WebDriver driver = BaseTest.driver;
       // WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
      
        // here we are accessing the driver object that we added in Test class  
		
		try {
		test.addScreenCaptureFromPath(Utility.captureScreenshot(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		LoginTest.test.log(Status.FAIL, result.getName()+" Failed");
		test.fail(result.getName()+" FAILED");
	}

	
/*	
  @Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
		// here we are accessing the driver object that we added in Test class

	
			try {
				test.addScreenCaptureFromPath(Utility.captureScreenshot(driver));
				//captureScreenshot(driver);
				getScreenshoot();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
//		LoginTest.test.log(Status.FAIL, result.getName()+" Failed");
		test.fail(result.getName() + " FAILED");
	}*/

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
