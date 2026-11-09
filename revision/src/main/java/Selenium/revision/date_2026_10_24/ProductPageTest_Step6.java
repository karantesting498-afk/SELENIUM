/*
 * Question 5: Practical Coding Challenge — Build a Reusable Test Class
Type: Practical Coding + Design | Hard

Create a TestNG class named ProductPageTest with the following requirements:
1. Declare a class-level WebDriver variable.
2. Use @BeforeMethod to launch Chrome and maximize the browser.
3. Create three independent test methods:
   - verifyProductPage() opens a product page.
   - verifyPageTitle() opens the same page and prints its title.
   - verifyPageUrl() opens the same page and prints its current URL.
4. Use @AfterMethod to close the browser session safely.
5. If browser initialization fails, cleanup must not cause a NullPointerException.
6. The test methods must not call one another.
7. Avoid repeating browser setup and cleanup code inside the test methods.
Tasks:

Write the complete Java class with all required imports.

Then explain:
- Why the driver is declared at class level.
- Why @BeforeMethod executes separately for each test.
- Why driver.quit() is appropriate for session cleanup.
- What would happen if the browser setup failed before assigning a valid driver instance.
Constraint: Focus on @Test, @BeforeMethod, and @AfterMethod. Do not use assertions, listeners, groups, or additional annotations yet.
 */

package Selenium.revision.date_2026_10_24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest_Step6 {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		
		driver = new ChromeDriver();
		

		driver.get("https://tfqa.trackofarm.in");
				
	}
	
	@Test
	public void verifyProductPage()
	{
		driver.findElement(By.id("products")).click();
		
	}
	
	@Test
	public void verifyPageTitle()
	{
		driver.findElement(By.id("products")).click();

		System.out.println(driver.getTitle());
	}
	
	@Test
	public void verifyPageUrl()
	{
		driver.findElement(By.id("products")).click();

		System.out.println(driver.getCurrentUrl());
		
	}
	
	@AfterMethod
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			System.out.println("Resource cleaned");

			driver= null;
		}
		else
		{
			System.out.println("Resouce not initiated");
		}
	}
	
	/*
	 * 1. Driver is declared at class level so that multiple methods in same class can access the driver.
	 * 2. @BeforeMethod is executed before every @Test annoted method because TestNG only execute @Test methods.
	 * When @Test method is executed, it will check for @Before method and call it.
	 * 
	 * 3.driver.quit() is suitable because it will close all the windows in the browser and will close all the resource 
	 * allocated to the driver session.
	 * 
	 * 4. RuntimeException will be displayed => Wrong
	 * 
	 * 
	 * 
	 * Question 4: Complete explanation
There are two possible situations.

Scenario A: ChromeDriver constructor fails
driver = new ChromeDriver();


If the constructor throws an exception before returning an instance:
- Assignment does not complete.
- driver remains null.
- The setup configuration fails.
- The associated test is skipped.
- Cleanup can safely check driver != null.
Scenario B: ChromeDriver initializes, but another setup operation fails
driver = new ChromeDriver();

driver.manage().window().maximize();

throw new RuntimeException("Setup failed");


Here, the driver was already assigned.

Cleanup should still attempt to close the browser because a valid driver reference exists.
	 */

}
