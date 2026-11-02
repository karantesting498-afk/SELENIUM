/*
 * Question 2 — Selenium Coding (Medium–Hard)
Scenario: You need to automate Google using Selenium and TestNG.

Write a complete Java class named GoogleTest that meets these requirements:
1. Declare a WebDriver variable at class level.
2. Use @BeforeMethod to:
   - Create a new ChromeDriver instance.
   - Maximize the browser window.
3. Create a test method named openGoogle() that:
   - Opens https://www.google.com.
   - Prints the current page title.
4. Create another test method named openExample() that:
   - Opens https://example.com.
   - Prints the current page title.
5. Use @Test for both test methods.
Your task: Write the complete Java class with the required Selenium and TestNG imports.

Constraint: Do not use main().

Note: For this exercise, focus only on @Test and @BeforeMethod. We'll introduce browser cleanup separately when we study @AfterMethod.
 */

package Selenium.revision.date_23_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest_Step4 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void openGoogle()
	{
		driver.get("https://www.google.com");
		driver.getTitle();
	}
	
	
	@Test
	public void openExample()
	{
		driver.get("https://example.com");
		driver.getTitle();
	}

}
