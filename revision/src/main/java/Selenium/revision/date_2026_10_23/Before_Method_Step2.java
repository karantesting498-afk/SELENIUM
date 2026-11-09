// This class contains questions regarding the before method
package Selenium.revision.date_2026_10_23;

public class Before_Method_Step2 {
	
	/*
	 * Question 1 — Output Prediction (Medium)
Consider this code:
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Browser Setup");
    }

    @Test
    public void loginTest() {
        System.out.println("Login Test");
    }

    @Test
    public void logoutTest() {
        System.out.println("Logout Test");
    }

    public void closeBrowser() {
        System.out.println("Browser Closed");
    }
}

Assume loginTest() executes before logoutTest().

Answer these questions:
1. Write the complete console output in execution order.
2. How many times will setup() execute?
3. Will closeBrowser() execute automatically? Explain why.
	 */
	
	public void ques_01()
	{
		/*
		 * 1.OutPut:
		 * Browser Setup
		 * Login Test
		 * Browser Setup
		 * Logout Test
		 * 
		 * 
		 * 2. setup() will execute twice.
		 * 
		 * 3. No, Browser Close Will not execute automatically, because wehen we run code through testng, it will only execute the 
		 * methods with annotation @Test


		 * 
		 */
	}
	
	
	/*
	 * Question 2 — Execution Logic (Hard)
Consider this code:
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

    int count = 0;

    @BeforeMethod
    public void setup() {
        count++;
        System.out.println("Setup Count: " + count);
    }

    @Test
    public void testA() {
        System.out.println("Test A: " + count);
    }

    @Test
    public void testB() {
        System.out.println("Test B: " + count);
    }

    @Test
    public void testC() {
        System.out.println("Test C: " + count);
    }
}

Assume all tests execute in the order A → B → C, and TestNG uses the same instance of the class for all three methods.

Answer these questions:
1. What will the output be?
2. Will count keep increasing across all three tests, or will it reset before every test?
3. What would change if count were declared as a local variable inside setup() instead?
Note: The same-instance assumption is specified to isolate the behaviour we're testing.
	 */

	public void ques_02()
	{
		/*
		 * 1. OutPut:
		 * Setup Count: 1
		 * Test A: 1
		 * Setup Count: 2
		 * Test B: 2
		 * Setup Count: 3
		 * Test C: 3
		 * 
		 * 2. No it will keep increasing with each test
		 * 
		 * 3. Then it will reset with every Test Method call
		 */
	}
	
	/*
	 * Question 3 — Selenium Scenario (Hard)
You are automating an e-commerce website.

Requirements:
- Each test must start with a fresh Chrome browser.
- Test A opens the login page.
- Test B opens the product page.
- Both tests should use the same setup method.
Consider this implementation:
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testA() {
        driver.get("https://example.com/login");
        System.out.println("Login Page Opened");
    }

    @Test
    public void testB() {
        driver.get("https://example.com/products");
        System.out.println("Product Page Opened");
    }
}

Answer these questions:
1. Will TestNG create a new browser before each test method?
2. Does @BeforeMethod itself close the browser opened by the previous test?
3. What additional functionality would you need to ensure the previous browser is closed before the next test starts?
	 */
	
	public void ques_03()
	{
		/*
		 * 1. Yes New driver will be created with each test method execution
		 * 2. No , it does not close the browser. We can add Close Browser step in the test method.
		 * 3. We can use @AfterMethod annotation to close browser, or we can add Close Browser step in the test method.
		 */
	}
	
	
	
}
