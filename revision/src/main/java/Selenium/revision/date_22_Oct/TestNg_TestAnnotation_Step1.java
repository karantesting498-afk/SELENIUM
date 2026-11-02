// This class contains Knowledge regarding testng and Test Annotation
package Selenium.revision.date_22_Oct;

public class TestNg_TestAnnotation_Step1 {
	
	/*
	 * 1. What is TestNG?
TestNG is a testing framework for Java that helps you organize, execute, and manage automated tests.

The name TestNG stands for Testing Next Generation.

When you use Selenium WebDriver, Selenium provides the functionality to interact with web applications.
 TestNG helps you organize those interactions into structured, executable tests.
 
 For example, imagine you're testing an e-commerce website. You need to verify:
1. Whether the login page opens.
2. Whether a user can log in successfully.
3. Whether searching for a product works.
4. Whether adding a product to the cart works.
5. Whether checkout works correctly.
You could write Java code for each scenario, but you also need a way to identify tests, execute them, verify their results, and manage failures.

This is where TestNG becomes useful.
	 */
	
	
	/*
	 * 2. Selenium versus TestNG
	 * 
This is a common interview question.

Feature										Selenium WebDriver												TestNG
Primary purpose								Automates browser interactions									Organizes and executes tests
Opens a browser								Yes, through WebDriver											Not by itself
Locates web elements						Yes																Not its primary purpose
Clicks buttons and enters text				Yes																Not by itself
Defines test methods using @Test			No																Yes
Provides testing assertions					Not its primary purpose											Yes
Supports test grouping and dependencies		No built-in test framework functionality for this				Yes
Supports data-driven testing				Provides browser interaction; does not provide 
											TestNG's @DataProvider											Yes
Generates test execution results			Browser automation logs are possible							Provides test execution 
																											results and reports


Remember this distinction:
- Selenium performs browser automation.
- TestNG manages the execution and verification of tests.
They work together but serve different purposes.


	 */
	
	
	/*
	 * 3. Your first TestNG test
Consider this simple example:
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Test
    public void loginTest() {
        System.out.println("Login test executed");
    }

    @Test
    public void searchTest() {
        System.out.println("Search test executed");
    }
}

Let's understand it line by line.


import org.testng.annotations.Test;

Imports the TestNG @Test annotation.

public class FirstTestNGTest

Defines a Java class containing our tests.

@Test

Tells TestNG that the annotated method is a test method.

loginTest() and searchTest()

These are ordinary Java methods that TestNG can identify and execute as tests.

System.out.println()

Prints a message to the console. We are using it to observe execution; 
it does not verify that a real login or search operation succeeds.

When executed through TestNG, the two methods should be identified as test methods.

The exact execution order is not something you should assume from their order in the source code.



What is a TestNG test method?
A TestNG test method is a Java method annotated with @Test.

TestNG identifies methods with this annotation and executes them as test cases.

Example:
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void verifyLogin() {
        System.out.println("Login test executed");
    }

    @Test
    public void verifyLogout() {
        System.out.println("Logout test executed");
    }
}


Here:
- LoginTest is the Java class.
- verifyLogin() and verifyLogout() are test methods.
- @Test tells TestNG to recognize those methods as test cases.
	 */
	
	
	/*
	 * 4. How does TestNG help with Selenium?
Let's integrate the two concepts.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openWebsiteTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}

Here is what happens:
1. TestNG identifies openWebsiteTest() as a test method.
2. The method creates a Chrome browser session.
3. Selenium opens Google.
4. Selenium retrieves the page title.
5. The title is printed.
6. The browser session is closed.
Notice that this example doesn't yet use a TestNG assertion. 
It opens the website and prints its title, but printing the title does not automatically verify that the title is correct.

We'll learn assertions in a later lesson.

For now, understand how TestNG and Selenium work together.
	 */
	
	
	/*
	 * 5. What happens when a TestNG test runs?
At a high level, the process is:
1. TestNG identifies the configured test methods.
2. It executes the applicable setup methods, if any.
3. It executes the test methods.
4. It runs the applicable teardown methods, if any.
5. It records the test outcomes and generates execution results.
We'll examine the execution order in detail when we study TestNG annotations.
	 */
	
	
	
	/*
	 * 2. Difference between a normal method and a TestNG method
Consider this example:
import org.testng.annotations.Test;

public class DemoTest {

    public void normalMethod() {
        System.out.println("Normal method executed");
    }

    @Test
    public void testMethod() {
        System.out.println("TestNG method executed");
    }
}


When you execute this class as a TestNG test:
Method	TestNG execution
normalMethod()	Not executed automatically as a test
testMethod()	Executed as a test

A normal Java method can still be called from a TestNG test method.

For example:
public class DemoTest {

    public void login() {
        System.out.println("Login steps");
    }

    @Test
    public void verifyLogin() {
        login();
        System.out.println("Verify login");
    }
}


Here, login() executes because verifyLogin() calls it, not because TestNG recognizes it as a test.
	 */
	
	
	/*
	 * 3. How does TestNG decide whether a test passes or fails?
This is an important concept.

TestNG does not automatically understand whether your application is working correctly.

It needs assertions to verify actual results against expected results. We'll study assertions in detail later.

Consider:
@Test
public void verifyLogin() {
    System.out.println("Login Successful");
}


Even if the application login actually fails, this test will pass unless an exception or assertion failure occurs.

TestNG records the execution outcome; it does not independently validate the business functionality.
	 */
	
	
	
	/*
	 * 4. TestNG with Selenium
Let's combine Selenium and TestNG.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void verifyGoogleTitle() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}


In this example:
- Selenium opens Chrome.
- Selenium navigates to Google.
- Selenium retrieves the page title.
- TestNG manages the execution of the test method.
Notice that we haven't verified whether the title is correct yet. That is where assertions will come in.
	 */
	
	
	/*
	 * 5. Important interview concepts
	 * 
	 * 
Question														Key concept

What makes a method a TestNG test?								@Test annotation

Can a TestNG class contain normal methods?						Yes

Will TestNG automatically execute every method?					No

Does System.out.println() verify application functionality?		No

Can TestNG execute tests without Selenium?						Yes

	 */

	
	/*
	 * 
	 */
}
