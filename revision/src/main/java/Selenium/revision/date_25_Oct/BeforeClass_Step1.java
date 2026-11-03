// This class contains knowledge regarding the BeforeClass method
package Selenium.revision.date_25_Oct;

public class BeforeClass_Step1 {

	
	/*
	 * 1. What is @BeforeClass?
The @BeforeClass annotation tells TestNG to execute a method once before the first test method in the current test class.

It is commonly used for:
- Initializing resources required by multiple tests.
- Performing class-level setup.
- Opening a browser when multiple tests need to share the same browser session.
- Preparing common test data.
Key point: @BeforeClass runs once per class invocation, not once before every @Test method.

=====================================================================================================
	 */
	
	/*
	 * 2. Basic Java + TestNG Example
Consider this code:
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
}

Assuming the test methods execute in the order shown, the output will be:
Before Class
Testing Employee Name
Testing Employee Salary
Testing Employee Department

What happened?
1. TestNG executes setupClass() before the first test method.
2. It executes testEmployeeName().
3. It executes testEmployeeSalary().
4. It executes testEmployeeDepartment().
The setup method executes once, even though the class contains three test methods.

=================================================================================================
	 */
	
	/*
	 * 3. Difference between @BeforeClass and @BeforeMethod
This is an important Selenium interview question.
Feature	@BeforeClass	@BeforeMethod
Execution frequency	Once per class invocation	Before every applicable test method
With 3 test methods	Normally executes once	Normally executes 3 times
Common use	Class-level initialization	Test-specific preparation
Browser strategy	Can initialize a shared browser	Can initialize a fresh browser for every test
Test isolation	Tests may share state	Can support more independent tests


Example to understand the difference
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
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

Assuming testA() runs before testB(), the output will be:
Before Class
Before Method
Test A
Before Method
Test B

Notice that @BeforeClass executes once, whereas @BeforeMethod executes before both tests.

============================================================================================================
	 */
	
	
	/*
	 * 3. Difference between @BeforeClass and @BeforeMethod
	 * 
	 * 
This is an important Selenium interview question.


Feature							@BeforeClass										@BeforeMethod
Execution frequency				Once per class invocation							Before every applicable test method

With 3 test methods				Normally executes once								Normally executes 3 times

Common use						Class-level initialization							Test-specific preparation

Browser strategy				Can initialize a shared browser						Can initialize a fresh browser for every test

Test isolation					Tests may share state								Can support more independent tests


Example to understand the difference
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
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

Assuming testA() runs before testB(), the output will be:
Before Class
Before Method
Test A
Before Method
Test B

Notice that @BeforeClass executes once, whereas @BeforeMethod executes before both tests.

4. Using @BeforeClass with Selenium

Suppose you have three tests that all need to access the same website.

You could initialize the browser in @BeforeClass so that the browser is created only once.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteTest {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Browser initialized");
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

    @Test
    public void verifyCurrentUrl() {
        System.out.println(driver.getCurrentUrl());
    }
}

How does this work?

1. @BeforeClass creates the Chrome browser.
2. openGoogle() navigates to Google.
3. openExample() navigates to Example Domain.
4. verifyCurrentUrl() prints the current URL.
All three tests use the same driver instance.

Important: This example intentionally omits browser cleanup. We will learn @AfterClass separately.
A potential problem

Because the browser is shared, one test can change its state for the next test.

For example:
- Test A navigates to Google.
- Test B navigates to Example Domain.
- Test C sees whichever page the previous test left open.
The test methods can also affect shared cookies, login sessions, local storage, and other browser state.

Therefore, a shared browser is not always the best choice.

=======================================================================================
	 */
	
	/*
	 * 4. Using @BeforeClass with Selenium
	 * 
Suppose you have three tests that all need to access the same website.

You could initialize the browser in @BeforeClass so that the browser is created only once.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebsiteTest {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Browser initialized");
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

    @Test
    public void verifyCurrentUrl() {
        System.out.println(driver.getCurrentUrl());
    }
}

How does this work?
1. @BeforeClass creates the Chrome browser.
2. openGoogle() navigates to Google.
3. openExample() navigates to Example Domain.
4. verifyCurrentUrl() prints the current URL.
All three tests use the same driver instance.

Important: This example intentionally omits browser cleanup. We will learn @AfterClass separately.


A potential problem
Because the browser is shared, one test can change its state for the next test.

For example:
- Test A navigates to Google.
- Test B navigates to Example Domain.
- Test C sees whichever page the previous test left open.
The test methods can also affect shared cookies, login sessions, local storage, and other browser state.

Therefore, a shared browser is not always the best choice.

=================================================================================================
	 */
	
	/*
	 * 5. When should you use @BeforeClass?
Use it when setup should happen once and the initialized resource can be shared across test methods.

Examples:
- Initializing class-level test data.
- Creating a shared API client.
- Opening a browser for a group of tests that intentionally share a session.
However, do not use @BeforeClass simply to make browser execution faster without considering test independence.

If each test must start with a fresh browser, @BeforeMethod is generally more appropriate.
Interview tip
Be prepared to explain the trade-off:
- @BeforeClass: less repeated setup, but potentially more shared state.
- @BeforeMethod: repeated setup, but often better test isolation.

==============================================================================================================
	 */
	
	/*
	 * 6. Important Behaviour to Remember
1. @BeforeClass executes before the first test method in the current class.
2. It normally executes once per class invocation.
3. It does not run before every @Test method.
4. It can initialize resources shared by multiple tests.
5. If @BeforeClass fails, TestNG generally cannot proceed with the class's test methods as normal; the tests may be skipped or marked as configuration failures.
6. A @BeforeClass method is not itself a test case.

============================================================================================
	 */
	
	
	/*
	 * 
	 */
}
