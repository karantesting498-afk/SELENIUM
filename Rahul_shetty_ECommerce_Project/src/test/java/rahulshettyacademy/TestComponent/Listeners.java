package rahulshettyacademy.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReport;

public class Listeners extends TestComponent implements ITestListener {

	WebDriver driver ;
	ExtentReport obj = new ExtentReport();

	ExtentReports extent = obj.getReport();

	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		thread.get().fail(result.getThrowable());

		try {
			this.driver = ((TestComponent) result.getInstance()).getDriver();
//			this.driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		test.log(Status.FAIL, "Test "+ result.getMethod().getMethodName() + " is failed");
		String ssPath= null;

		try {
			ssPath = getScreenshot(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		thread.get().addScreenCaptureFromPath(ssPath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, "Test "+ result.getMethod().getMethodName() + " is skipped");
	

	

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test "+ result.getMethod().getMethodName() + " is passed");
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());
		thread.set(test);// Will assign unique thread id
	}

}
