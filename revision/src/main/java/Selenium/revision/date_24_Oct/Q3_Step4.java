/*
 * Question 3: Design an Independent Test Execution Strategy
Type: Theory + Practical Coding | Hard

You have two test methods:
- testLogin() logs in to an application.
- testLogout() logs out of the application.
The requirements are:
- Each test must start with a fresh browser session.
- Browser setup must happen before each test.
- Cleanup must happen after each test.
- A failure in one test should not prevent TestNG from attempting the other test under normal execution.
Tasks:
1. Write a complete TestNG class implementing these requirements.
2. Explain why @BeforeMethod and @AfterMethod are suitable here.
3. Should testLogout() depend on testLogin() to establish its logged-in state? Explain your reasoning.
4. What is the risk of making tests depend on state created by another test?
Constraint: Use only @Test, @BeforeMethod, and @AfterMethod. Do not introduce other TestNG annotations yet.
 */

package Selenium.revision.date_24_Oct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q3_Step4 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLogin()
	{
		driver.get("https://tfqa.trackofarm.in");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("loginBtn")).click();
	}
	
	@AfterMethod
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			driver = null;
		}
	}
	
	@Test
	public void testLogout()
	{
		driver.get("https://tfqa.trackofarm.in");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("loginBtn")).click();
		
		driver.findElement(By.id("logoutBtn")).click();
	}
	
	
	/*
	 * 1. Code
	 * 2. Before method creates a new browser session for each test method.
	 * 	  After method quits the browser after each test method.
	 * 
	 * 3. Yes , user can logout only after user is logged in.
	 * In our code, user login and then browser is closed through afterMethod.
	 * For logout , user will have to first login or need to add method dependency
	 * 
	 * 4. Risk is that maybe dependent method got failed or returning an staleElementReferenceException
	 * 
	 * Execution dependency: If the prerequisite test fails, the dependent test may be skipped instead of being independently executed.



Order dependency: The dependent test requires another test to execute first.



Shared-state problems: Changes made by one test can affect the outcome of another test.



Poor failure isolation: A failure in one test can cause additional tests to fail or be skipped, making defect identification harder.



Difficult debugging: It becomes harder to determine whether a failure belongs to the current test or is caused by the state left behind by another test.
	 */

}
