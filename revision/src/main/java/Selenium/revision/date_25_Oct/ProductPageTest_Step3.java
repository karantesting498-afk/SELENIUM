/*
 * Q2. Selenium Practical Coding
Type: Hands-on Coding | Hard

You are automating an e-commerce application.

Requirements:

Create a class named ProductPageTest.
1. Declare a class-level WebDriver variable.
2. Use @BeforeClass to:
   - Launch Chrome.
   - Maximize the browser.
   - Navigate to https://example.com.
3. Create three independent test methods:
   - verifyPageTitle() – print the page title.
   - verifyCurrentUrl() – print the current URL.
   - verifyPageSource() – print the page source.
4. All three tests should use the same browser instance.
5. Do not create a new browser inside individual test methods.
6. Include all necessary imports.
Your task: Write the complete Java class.

Additional question: What could happen if one test navigates to another website before the remaining tests execute?
 */
package Selenium.revision.date_25_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest_Step3 {
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver=  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://example.com");
	}
	
	@Test
	public void verifyPageTitle()
	{
		System.out.println(driver.getTitle());
	}

	
	@Test
	public void verifyCurrentUrl()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void verifyPageSource()
	{
		System.out.println(driver.getPageSource());
	}
	
	@AfterClass
	public void tearDown() {
	    driver.quit();
	}
	
	/*
	 * 1. Additional question: What could happen if one test navigates to another website before the remaining tests execute?
	 * 
	 * even if test navigates to other website:
	 * A. Incase selenium focus is on the new page, then url , pagesource of new page will be printed
	 * 
	 * B. In Case selenium focus is still on parent page, then parent page url , page source will be dispayed.
	 * 
	 * C. In case selenium focus is on new page, then in that method we should add code to return back to the orginial page
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Your answer:
In case Selenium focus is still on parent page, then parent page URL and page source will be displayed.

This needs correction.

You are mixing up two different concepts:
1. Browser navigation.
2. Window/tab switching.
Let's understand them.
Scenario A: Test navigates to another website in the same tab
Suppose verifyPageTitle() executes:
@Test
public void verifyPageTitle() {
    driver.get("https://www.google.com");
    System.out.println(driver.getTitle());
}


Initially, the browser opens:

https://example.com

After executing driver.get(), the same browser tab navigates to Google.

Now, when another test executes:
@Test
public void verifyCurrentUrl() {
    System.out.println(driver.getCurrentUrl());
}


It prints Google's URL, not example.com's URL.

Why?

Because driver.get() navigates the current browser window/tab to the specified URL.

There is no separate parent page that Selenium automatically remembers or returns to.
Scenario B: Test opens another tab or window
Suppose you execute:
String parentWindow = driver.getWindowHandle();

driver.switchTo().newWindow(WindowType.TAB);

driver.get("https://www.google.com");


Now you have two tabs:
- Parent tab: example.com
- New tab: google.com
Selenium is currently controlling the newly opened tab.

If another test calls:
System.out.println(driver.getCurrentUrl());


It prints Google's URL because Selenium's current window context is the new tab.

To return to the original tab:
driver.switchTo().window(parentWindow);


This switches Selenium's control back to the original tab.

Important: Selenium does not automatically switch back to the parent tab when a test method finishes.
	 */
}
