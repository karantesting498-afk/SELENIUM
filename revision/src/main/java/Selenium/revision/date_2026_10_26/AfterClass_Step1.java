// This class contains knowledge regarding After Class methods
package Selenium.revision.date_2026_10_26;

public class AfterClass_Step1 {
	
	/*
	 * 1. What is @AfterClass?
The @AfterClass annotation tells TestNG to execute a method once after all test methods in the current test class have finished.

It is commonly used for:
- Closing the browser.
- Releasing resources.
- Closing database connections.
- Performing class-level cleanup.
- Logging final execution information.
Key point: @AfterClass executes once after all applicable test methods in the class, not after every individual test.

===================================================================================================
	 */
	
	/*
	 * 2. Basic Java + TestNG Example
Consider the following code:
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeTest {

    @BeforeClass
    public void setupClass() {
        System.out.println("Before Class");
    }

    @Test
    public void testEmployeeName() {
        System.out.println("Testing Employee Name");
    }

    @Test
    public void testEmployeeSalary() {
        System.out.println("Testing Employee Salary");
    }

    @Test
    public void testEmployeeDepartment() {
        System.out.println("Testing Employee Department");
    }

    @AfterClass
    public void teardownClass() {
        System.out.println("After Class");
    }
}

Expected execution flow
Assuming the test methods execute in the order shown:
Before Class
Testing Employee Name
Testing Employee Salary
Testing Employee Department
After Class

Understand the execution
1. @BeforeClass executes before the first test.
2. All three @Test methods execute.
3. @AfterClass executes after the test methods finish.
Notice that teardownClass() executes only once.
	 ======================================================================================================
	 *
	 */
	
	
	/*
	 * 3. Practical Selenium Example
Suppose you have three test methods that use the same Chrome browser.

Instead of closing the browser after every test, you want to close it only after all three tests finish.

You can use @BeforeClass and @AfterClass together.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GoogleTest {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        System.out.println("Browser initialized");
    }

    @Test
    public void testGoogle() {

        driver.get("https://www.google.com");

        System.out.println("Google Title: " + driver.getTitle());
    }

    @Test
    public void testExample() {

        driver.get("https://example.com");

        System.out.println("Example Title: " + driver.getTitle());
    }

    @Test
    public void testCurrentUrl() {

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @AfterClass
    public void teardownClass() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }
}

Execution flow
Execution	Action
1	@BeforeClass launches Chrome
2	testGoogle() executes
3	testExample() executes
4	testCurrentUrl() executes
5	@AfterClass closes Chrome


Important: All three test methods share the same browser session.

For example:
- testGoogle() navigates to Google.
- testExample() navigates to Example Domain.
- testCurrentUrl() reads the URL of the page currently open.
The third test may therefore depend on which page the second test left open.

This is one reason shared browser sessions require careful test design.

=================================================================================================
	 */
	
	
	/*
	 * 4. Difference Between @AfterClass and @AfterMethod
	 * 
This is an important Selenium interview question.

Feature						@AfterClass													@AfterMethod
Execution frequency			Once per class invocation									After every applicable test method

With 3 test methods			Normally executes once										Normally executes 3 times

Common purpose				Class-level cleanup											Test-level cleanup

Browser handling			Closes a shared browser										Closes the browser after each test

Resource handling			Releases shared resources									Releases resources created for individual tests


Example
Suppose you have five test methods.

Using @AfterClass:
Test A
Test B
Test C
Test D
Test E
Browser Closed

Browser cleanup happens once.

Using @AfterMethod:
Test A
Browser Closed

Test B
Browser Closed

Test C
Browser Closed

Test D
Browser Closed

Test E
Browser Closed

Browser cleanup happens after every test.

====================================================================================
	 */
	
	/*
	 * 5. What happens if a test fails?
Consider this scenario:
- You have three test methods.
- The first test passes.
- The second test fails.
- The third test executes.
Will @AfterClass execute?

Normally, yes. TestNG invokes class-level teardown after the class's test execution finishes, including when individual tests fail.

However, remember the distinction:
- If an individual test fails, class-level teardown normally still executes.
- If @BeforeClass fails, the test methods may not execute normally. Teardown behaviour can depend on the configuration failure and TestNG configuration settings.
Therefore, cleanup code should be defensive.

For example:
@AfterClass
public void teardownClass() {

    if (driver != null) {
        driver.quit();
    }
}

The null check helps prevent a NullPointerException if the driver was never initialized.

===========================================================================================
	 */
	
	
	/*
	 * 6. When Should You Use @AfterClass?
	 * 
	 * 
Use it when a resource is shared across multiple test methods and should be released only after all those tests finish.

Scenario									Suitable annotation
Close browser after every test				@AfterMethod
Close browser after all tests in a class	@AfterClass
Disconnect shared database connection		@AfterClass
Clear test-specific temporary data			@AfterMethod
Release class-level resources				@AfterClass


Important interview point
@BeforeClass and @AfterClass are commonly used together:
- @BeforeClass initializes shared resources.
- @AfterClass releases those resources.

========================================================================
	 */
	
	
	/*
	 * 7. Important Concepts to Remember
1. @AfterClass executes once after the test methods in the current class finish.
2. It is not executed after every individual test.
3. It is commonly paired with @BeforeClass.
4. It is useful for closing shared browser sessions.
5. A failed test does not normally prevent @AfterClass from executing.
6. Use null checks and defensive cleanup to handle partially initialized resources.
7. @AfterClass is not itself a test method.
=========================================================
	 */
	
	
	
	

}
