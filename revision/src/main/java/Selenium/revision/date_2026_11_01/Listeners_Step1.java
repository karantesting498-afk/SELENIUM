// This class contains knowledge regarding listeners
package Selenium.revision.date_2026_11_01;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_Step1 implements ITestListener{
	
	
	/*
	 * 1. What are Listeners in TestNG?
Listeners are interfaces in TestNG that allow us to listen to test execution events and perform specific actions when those events occur.

For example:
- Take a screenshot when a test fails.
- Generate custom execution logs.
- Track passed, failed, and skipped test cases.
- Perform actions before or after a test suite executes.
- Customize reporting.
Interview definition:

A TestNG Listener is an interface that monitors test execution events and allows us to execute custom logic when specific events occur, without modifying the actual test methods.


=================================================================================
	 */
	
	
	/*
	 * 2. Why do we use Listeners?
Suppose you have 100 Selenium test cases.

If you want to capture a screenshot whenever any test fails, you could write screenshot code inside every test's catch block.

However, this creates duplicated code.

Instead, you can implement a TestNG Listener and capture screenshots centrally whenever a test fails.


=========================================================
	 */
	
	
	/*
	 * 3. Important TestNG Listener interfaces
TestNG provides several listener interfaces. These are some of the most important ones for automation testing.


Listener interface	Purpose

ITestListener	Monitors individual test method execution
ISuiteListener	Monitors suite execution
IInvokedMethodListener	Monitors test and configuration method invocation
IExecutionListener	Monitors the entire TestNG execution
IReporter	Generates customized reports after execution
IAnnotationTransformer	Dynamically modifies TestNG annotations

For Selenium interviews, focus particularly on ITestListener.
====================================================
	 */
	
	
	/*
	 * 4. ITestListener – Most important
ITestListener monitors the execution status of individual test methods.

It provides several callback methods.
Method	When it executes
onStart()	Before the first test method invocation in the relevant <test> context
onTestStart()	Before each test method invocation
onTestSuccess()	When a test method passes
onTestFailure()	When a test method fails
onTestSkipped()	When a test method is skipped
onTestFailedButWithinSuccessPercentage()	When a test fails but remains within the configured success percentage
onFinish()	After all test method invocations in the relevant <test> context finish

Note: onStart() and onFinish() here refer to the TestNG <test> context, not the entire suite. Suite-level callbacks belong to ISuiteListener

====================================================================================
	 */
	
	
	/*
	 * 5. How to implement ITestListener?
Let's understand with a practical example.

Step 1: Create a Listener class


package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " +
                result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " +
                result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " +
                result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " +
                result.getName());
    }
}


Step 2: Create a test class


package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Executing valid login");
    }

    @Test
    public void invalidLogin() {
        Assert.fail("Login failed");
    }
}


Step 3: Register the Listener

There are two common ways to register a listener.


Method 1 – Using testng.xml
<suite name="Suite">

    <listeners>
        <listener class-name="listeners.MyListener"/>
    </listeners>

    <test name="Login Test">
        <classes>
            <class name="test.LoginTest"/>
        </classes>
    </test>

</suite>




Method 2 – Using @Listeners annotation

@Listeners(listeners.MyListener.class)
public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Valid Login");
    }
}



Interview important
 @Listeners is generally applied at the class level.
 
  XML registration is useful when you want to apply a listener across the entire suite without modifying individual test classes.
  
  
  ==================================================================
	 */
	
	
	/*
	 * 6. How does execution work?
Suppose your test class contains:
@Test
public void test1() {
    System.out.println("Test 1");
}

@Test
public void test2() {
    Assert.fail("Failed");
}

@Test
public void test3() {
    System.out.println("Test 3");
}


Your listener contains callbacks for start, success, and failure.

The execution flow will be:


onTestStart(test1)
       |
       v
test1 executes
       |
       v
onTestSuccess(test1)
       |
       v
onTestStart(test2)
       |
       v
test2 executes
       |
       v
onTestFailure(test2)
       |
       v
onTestStart(test3)
       |
       v
test3 executes
       |
       v
onTestSuccess(test3)


The listener does not automatically stop execution when a test fails. TestNG continues according to its execution and dependency rules.

--=======================================================================================================
	 */
	
	
	/*
	 * 7. Using ITestResult
You might have noticed that listener methods receive an ITestResult parameter.

ITestResult provides information about the test method's execution.

Some useful methods:
Method	Purpose
getName()	Returns the test method name
getStatus()	Returns the execution status
getThrowable()	Returns the exception associated with the result
getMethod()	Returns information about the test method
getStartMillis()	Returns execution start time
getEndMillis()	Returns execution end time


@Override
public void onTestFailure(ITestResult result) {

    System.out.println("Failed Test: " + result.getName());

    System.out.println("Failure Reason: " +
            result.getThrowable());
}


================================================================================
	 */
	
	
	/*
	 * 8. Real-world Selenium use case – Screenshot on failure
This is one of the most common applications of listeners in Selenium automation.
@Override
public void onTestFailure(ITestResult result) {

    WebDriver driver =
        (WebDriver) result.getTestContext()
                          .getAttribute("driver");

    File source = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);

    // Save screenshot to the desired location
  
  
  Here, the WebDriver instance must first be stored in the TestNG context, for example:
@BeforeMethod
public void setup(ITestContext context) {

    WebDriver driver = new ChromeDriver();

    context.setAttribute("driver", driver);
    
    
    Important: This is an illustrative example. In a real framework, driver lifecycle and parallel execution must be handled carefully.
    
     
     A shared context attribute can cause problems when multiple tests run in parallel; a thread-safe driver management approach is preferable.
}




======================================================================
	 */
	
	/*
	 * 9. Listener vs TestNG Annotations
This is an important interview distinction.
TestNG annotations	TestNG listeners
Define lifecycle methods and test methods	React to execution events
Examples: @BeforeMethod, @Test	Examples: ITestListener, ISuiteListener
Written inside test/configuration classes	Usually implemented in a separate class
Used to control setup, execution and teardown	Used to monitor and customize execution

For example:
- @AfterMethod executes after each applicable test method.
- onTestFailure() executes when a test method fails.
- @BeforeSuite runs before suite execution.
- onStart() of ISuiteListener runs when the suite starts.


====================================================================
	 */
	
	/*
	 * 10. Important interview points
1. A listener is an interface, not a TestNG annotation.
2. ITestListener is commonly used for test execution reporting and screenshots.
3. A listener can be registered through testng.xml or @Listeners.
4. A listener does not itself execute test cases; it monitors their execution.
5. ITestResult provides information about the current test execution.
6. Listeners help implement reusable reporting and logging logic.
7. Multiple listeners can be registered for the same TestNG execution.


Quick revision
Question	Answer
What is a listener?	An interface that monitors TestNG execution events.
Most commonly used listener?	ITestListener
Screenshot on failure?	onTestFailure()
Test passed callback?	onTestSuccess()
Test skipped callback?	onTestSkipped()
Suite start callback?	ISuiteListener.onStart()
How to register?	testng.xml or @Listeners
What is ITestResult?	Provides information about test execution.

My recommendation: Understand ITestListener thoroughly first, particularly onTestStart(), onTestSuccess(), onTestFailure(), and onTestSkipped().

 
 These are the most useful callbacks for Selenium automation frameworks.
	 */
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
		System.out.println(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("Pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("Fail   "+ result.getThrowable().getMessage());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		System.out.println("Skip");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		System.out.println("Total Test :"+ (context.getPassedTests().size()+context.getFailedTests().size()+context.getSkippedTests().size()));
		
		System.out.println("Pass count size: "+ context.getPassedTests().size());
		System.out.println("Fail count size : "+ context.getFailedTests().size());
		System.out.println("SKip count size :"+ context.getSkippedTests().size());
		
		
		
	}
	
}



	


