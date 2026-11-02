// This class contains knowledge regarding afterMethod annotation
package Selenium.revision.date_24_Oct;

public class AfterMethod_Step1 {
	
	/*
	 * 1. What is @AfterMethod?
The @AfterMethod annotation tells TestNG to execute a method after each applicable @Test method finishes.

It is commonly used for:
- Closing the browser.
- Logging out of the application.
- Clearing test data or resetting test state.
- Cleaning up resources created during a test.
=========================================================
	 */
	
	
	/*
	 * Example 1: Basic Java + TestNG
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class DemoTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");
    }

    @Test
    public void testA() {
        System.out.println("Test A");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After Method");
    }

    @Test
    public void testB() {
        System.out.println("Test B");
    }
}

Assuming testA() executes before testB(), the output will be:
Before Method
Test A
After Method
Before Method
Test B
After Method

Remember:
- @BeforeMethod runs before each test.
- @Test executes the test logic.
- @AfterMethod runs after each test method finishes.

=================================================================================
	 */
	
	
	/*
	 * 2. Practical Selenium example
Suppose each test opens a new Chrome browser. We should close that browser after the test completes.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void openExample() {
        driver.get("https://example.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

What happens during execution?
For each test:
1. @BeforeMethod creates a browser.
2. @Test performs the browser actions.
3. @AfterMethod closes the browser using driver.quit().
The next test gets its own browser instance.

Important: driver.quit() closes all browser windows managed by that WebDriver session and ends the session.
 By comparison, driver.close() closes only the current browser window.

=====================================================================================

	 */
	
	
	/*
	 * 3. What if a test fails?
Normally, TestNG invokes @AfterMethod after a test method finishes, even when the test fails.

This is important because cleanup should not depend on the test passing.

However, if the setup method fails before the test starts, teardown behaviour depends on the configuration and failure circumstances. 
Don't assume every setup failure guarantees that all cleanup code will execute
	 */

}
