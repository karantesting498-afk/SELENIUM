/*
 * Question 3 – Practical coding challenge: Screenshot on failure
You are developing a Selenium automation framework.

Your requirement is:
- Every test should execute normally.
- If any test fails, a screenshot should be captured automatically.
- Screenshot filenames should contain the test method name.
- The screenshot should be saved in a Screenshots folder.
- The listener should not contain duplicate screenshot logic in every test method.
Task:

Write the implementation using:
1. A BaseTest class to initialize WebDriver.
2. A listener implementing ITestListener.
3. onTestFailure() to capture the screenshot.
4. ITestResult to retrieve the failed test method name.
5. Proper WebDriver access from the listener.
Also explain how you would handle this implementation if tests were executed in parallel.
 */
package Selenium.revision.date_2026_11_01;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseTest_Step4 {
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
		
		driver.get("https://example.com");
		
	}
	
	@Test
	public void printURL()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void printTitle() {
		
		System.out.println(driver.getTitle());
	}
	

	
	
	
	public class MyListeners implements ITestListener{
		
		
		WebDriver driver;
		
		public void fetchDriver(ITestResult result)
		{
			Object obj = result.getInstance();
			
			BaseTest_Step4 obj2 = (BaseTest_Step4)obj;
			
			driver = obj2.getDriver();
		}
		
		@Override
		public void onTestStart(ITestResult result) {
			
			fetchDriver(result);
			// TODO Auto-generated method stub
			ITestListener.super.onTestStart(result);
			
			System.out.println(result.getTestName() +" :Test success  ");
		}
		
		@Override
		public void onTestFailure(ITestResult result) {
			fetchDriver(result);

			// TODO Auto-generated method stub
			ITestListener.super.onTestFailure(result);
			
			try {
				Path folder = Path.of( "D:\\New folder\\screenshot");
				
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String ssName = result.getMethod().getMethodName()+".png";
				Files.copy(source.toPath(), folder.resolve(ssName));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
