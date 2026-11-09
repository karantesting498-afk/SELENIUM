// This class contain knowledge regarding before method
package Selenium.revision.date_2026_10_23;

public class BeforeMethod_Step1 {
	
	/*
	 * 1. What is @BeforeMethod?
The @BeforeMethod annotation tells TestNG to execute a particular method before each @Test method in the same test class.

It is commonly used for:
- Opening a browser.
- Navigating to a starting page.
- Preparing test data.
- Setting up the test's initial state.

============================================================================
	 */

	
	/*
	 * Example 1: Basic Java example
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");
    }

    @Test
    public void testA() {
        System.out.println("Test A");
    }

    @Test
    public void testB() {
        System.out.println("Test B");
    }
}

Assuming both test methods execute, setup() will run twice—once before each test method.

The execution sequence, assuming testA() runs first, will be:
Before Method
Test A
Before Method
Test B

Remember: @BeforeMethod doesn't execute just once for the entire class. It runs before every applicable test method.

=================================================================================
	 */
	
	/*
	 * 2. Practical Selenium example
Suppose you have two test cases that both require a browser.

Without @BeforeMethod, you might repeat the browser setup code in both tests.

With @BeforeMethod:
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyGooglePage() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void verifyAnotherPage() {
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
    }
}

Here, TestNG will execute setup() before each test method.

Important: This example deliberately omits browser cleanup. We'll cover teardown separately when we learn @AfterMethod.

========================================================================
	 */
	
	/*
	 * 3. What happens if a test fails?
Suppose testA() fails.

Under normal TestNG execution, @BeforeMethod will still be invoked before testB() when TestNG proceeds to that test. The setup method isn't limited to the first test or dependent on the previous test passing.

However, if setup() itself fails, TestNG may skip the associated test method because its setup did not complete successfully.
=================================================================================
	 */
	
	/*
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
