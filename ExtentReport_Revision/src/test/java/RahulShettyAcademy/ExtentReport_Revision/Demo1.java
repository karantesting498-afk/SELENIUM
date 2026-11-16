package RahulShettyAcademy.ExtentReport_Revision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo1 {
	WebDriver driver;
	
	ExtentReports extent;
	
	@BeforeTest
	public void extentReportConfig()
	{
		
		
	String path = 	System.getProperty("user.dir")+"\\reports\\index.html";
		
		// Spark creates extent report at the given path
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		
		// Report Name
		
		reporter.config().setReportName("Web AUtomation Result");
		
		
		// Change tab title name
		
		reporter.config().setDocumentTitle("Automation Test Result");
		

		// Responsible to drive all the reporting execution
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Karan");
		

		
	}
	
	
	
	
	
	
	
	@Test
	public void initalDemo1()
	{
		ExtentTest test=extent.createTest("initalDemo1");

		driver = new ChromeDriver();
		
		driver.get("https://example.com");
		
		System.out.println(driver.getTitle());
//		test.addScreenCaptureFromBase64String(s);
		test.fail("do not match");
		
		extent.flush();
	}

}
