/*
 * Q3. Debugging and Failure Handling
Type: Code Debugging + Theory | Hard

A tester has written the following code:
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://example.com");

        System.out.println("Browser initialized");
    }

    @Test
    public void testLogin() {
        driver.get("https://example.com/login");
        System.out.println("Login test");
    }

    @Test
    public void testDashboard() {
        driver.get("https://example.com/dashboard");
        System.out.println("Dashboard test");
    }

    @Test
    public void testProfile() {
        driver.get("https://example.com/profile");
        System.out.println("Profile test");
    }
}

Tasks:
1. Identify at least three potential problems or weaknesses.
2. Suppose browser initialization fails inside setup(). What could happen to the test methods?
3. Is it guaranteed that all three test methods will execute successfully just because @BeforeClass executed successfully?
4. Rewrite the code to improve its reliability while retaining @BeforeClass.
5. Explain whether @BeforeClass is suitable if every test requires a fresh browser session.
 */

package Selenium.revision.date_25_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest_Step4 {
	WebDriver driver;
	
	/*
	 * 1. Potential problem
	 * A. Browser session is shared with all test cases.
	 * B. No teardown scenario
	 * C. No exception handling in case we get configuration error in setup method.
	 * 
	 * A. Test execution order is not guaranteed by default.

Without priority, you should not assume that testLogin(), testDashboard(), and testProfile() will execute in the order they appear in the source code.

B. Tests are dependent on a shared browser state.

For example, testLogin() navigates to the login page. Another test might expect the browser to be on the original page.

C. No validation of the actual page.

Your tests only navigate and print messages. They don't verify whether the expected page loaded.

For example:
driver.get("https://example.com/login");
System.out.println("Login test");


This does not establish that the login page loaded successfully.

You could verify the URL or an expected page element.




	 * 
	 * 2. In case browser initialization fails inside setup(), then the test methods will be skipped.
	 * 
	 * The following happens:
1. setup() throws an exception.
2. TestNG marks the @BeforeClass configuration method as failed.
3. TestNG normally skips the dependent test methods in that class.
4. The configuration failure is reported in the test execution results.
Important distinction: TestNG does not necessarily terminate the entire test suite. Other test classes or independent configurations may still execute, depending on the suite configuration.



	 * 
	 * 3. No, We cannot gurantee it because test case might also fail.
	 * 
	 * 4. code, we can add assertion to make code more reliable
	 * 
	 * 5. No @BeforeClass method is only called once per class execution.
	 * For the requirement of a fresh browser session for every test we need to use @BeforeMethod
	 */

	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		
	       driver.get("https://example.com");
	       driver.manage().window().maximize();
	       

	        System.out.println("Browser initialized");
	        
	}
	
	 @Test
	    public void testLogin() {
	        driver.get("https://example.com/login");
	        System.out.println("Login test");
	    }

	    @Test
	    public void testDashboard() {
	        driver.get("https://example.com/dashboard");
	        System.out.println("Dashboard test");
	    }

	    @Test
	    public void testProfile() {
	        driver.get("https://example.com/profile");
	        System.out.println("Profile test");
	    }
	    
	    @AfterClass
	    public void terminate()
	    {
	    	if(driver!=null)
	    	{
	    		driver.quit();
	    		driver = null;
	    	}
	    }
}
