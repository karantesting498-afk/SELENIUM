package Personal.EcommereceSeleniumProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		
		spark.config().setReportName("Web Automation Results");
		spark.config().setDocumentTitle("Extent Report Tab");
		
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Test Engineer : ", "Karan Bajaj");
		
		return report;
	}
}
