/*
 * Q2. Selenium Practical Coding — Shared Browser
You have three test methods in a class. You want to:
- Launch Chrome only once before all test methods.
- Execute all three test methods using the same browser instance.
- Close the browser only after all test methods have finished.
Task: Write a complete TestNG class using:
- @BeforeClass
- @Test
- @AfterClass
Requirements:
1. Declare a WebDriver instance at class level.
2. Open Chrome in @BeforeClass.
3. Write three test methods that navigate to three different URLs.
4. Close the browser using driver.quit() in @AfterClass.
5. Handle the possibility that the driver was never initialized.
 */
package Selenium.revision.date_26_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q2_Step3 {
	WebDriver driver;

	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		
	}
	
	@Test
	public void testA()
	{
		driver.get("https://exampleA.com");
	}
	
	@Test
	public void testB()
	{
		driver.get("https://exampleB.com");
	}
	
	@Test
	public void testC()
	{
		driver.get("https://exampleC.com");
	}
	
	@AfterClass
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
	
}
