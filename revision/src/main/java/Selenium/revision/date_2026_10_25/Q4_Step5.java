/*
 * Q4. Real-World Automation Framework Design
Type: Practical Coding + Design | Hard

You are creating an automation framework for an e-commerce application.

You have three test methods:
- verifyLoginPage()
- verifyProductPage()
- verifyCartPage()
All three tests require:
- Browser initialization.
- Browser maximization.
- Common application URL configuration.
However, each test should be able to navigate independently.

Requirements:
1. Use @BeforeClass to initialize the browser.
2. Store the application URL in a class-level variable.
3. Use the same WebDriver instance for all tests.
4. Do not repeat browser initialization code.
5. Write all three test methods.
6. Explain how you would prevent one test's navigation from affecting another test.
Additional theory questions:
- Why is a class-level WebDriver variable necessary here?
- Why shouldn't you initialize Chrome separately inside every test?
- What are the disadvantages of sharing a browser instance across tests?
- Would this design be suitable for parallel execution? Explain.
 */
package Selenium.revision.date_2026_10_25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q4_Step5 {
	WebDriver driver;
	
	String url = "https://example.com";
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void verifyLoginPage()
	{
		driver.findElement(By.id("loginBtn")).click();
		Assert.assertTrue(driver.findElement(By.id("loginBtn")).getText().equalsIgnoreCase("Login?"));
	}
	
	@Test
	public void verifyProductPage()
	{
		driver.findElement(By.id("product")).click();
		Assert.assertTrue(driver.findElement(By.id("product")).getText().equalsIgnoreCase("product list?"));
	}
	
	@Test
	public void verifyCartPage()
	{
		driver.findElement(By.id("cart")).click();
		Assert.assertTrue(driver.findElement(By.id("cart")).getText().equalsIgnoreCase("product in cart?"));
	}

	
	@AfterClass
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			driver= null;
		}
	}
	
	/*
	 * 1. Use @BeforeClass to initialize the browser.- code
	 * 2. Store the application URL in a class-level variable. - code
	 * 3. Use the same WebDriver instance for all tests. - code
	 * 4. Do not repeat browser initialization code. - code
	 * 5. Write all three test methods.- code
	 * 6. 1. Explain how you would prevent one test's navigation from affecting another test. - We can only prevent it by adding code to revert back
	 * to original screen after code implementation or add code -> driver.get(url); 
	 * 
	 * 7. Why is a class-level WebDriver variable necessary here? - Because same driver can be utilized by multiple test methods.
	 * 8. Why shouldn't you initialize Chrome separately inside every test? - Because requiremnt is for same browser session 
	 * 9. What are the disadvantages of sharing a browser instance across tests?- One test case may affect other test cases.
	 * 
	 * 
	 * 10. - Would this design be suitable for parallel execution? Explain.- No,because we are using single browser session, 
	 * adding parallel execution might leads to errors
	 */
}
