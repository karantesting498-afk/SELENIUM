package Project.ExtenetReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoStandAloneTest {
	
	ExtentReports report;
	
	@BeforeTest
	public void config()
	{
		String reportPath = System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setReportName("Rahul shetty academy autoation");
		spark.config().setDocumentTitle("Chnage title of the tab");
		
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Test Engineeer", "Karan Bajaj");
	}
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = report.createTest("Test Case Name 1");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/practice");
		
		System.out.println(driver.getTitle());
		
		test.fail("Test Case fail");
		report.flush();
	}

}
