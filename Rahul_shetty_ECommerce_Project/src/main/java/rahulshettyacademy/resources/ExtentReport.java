package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public ExtentReports getReport()
	{
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		
		ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
		
		reporter.config().setReportName("Ecommerce project");
		reporter.config().setDocumentTitle("Rahul Shetty E commerce");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "QA");
		
		return extent;
		
	}

}
