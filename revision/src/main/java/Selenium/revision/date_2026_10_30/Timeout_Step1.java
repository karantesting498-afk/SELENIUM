// This class contains knowledge regarding timeout
package Selenium.revision.date_2026_10_30;

public class Timeout_Step1 {
	
	/*
	 * The timeOut attribute in TestNG is used to define the maximum time allowed for a test method to complete execution.

If a test method takes longer than the specified time, TestNG will fail that test due to a timeout.

It is useful when you want to prevent test cases from running indefinitely or getting stuck.

=====================================================================================================================
	 */
	
	
	/*
	 * 1. Basic syntax
@Test(timeOut = 5000)
public void loginTest() throws InterruptedException {
    Thread.sleep(2000);
    System.out.println("Login successful");
}


Here:
- timeOut = 5000 means the maximum execution time is 5000 milliseconds (5 seconds).
- The method takes approximately 2 seconds.
- Since it finishes within 5 seconds, the test passes.
Result: PASS
2. What happens when the timeout is exceeded?
@Test(timeOut = 3000)
public void loginTest() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("Login successful");
}


Here:
- Maximum allowed time = 3 seconds.
- Actual execution time = approximately 5 seconds.
- The test exceeds the configured timeout.
Test failure
TestNG reports a timeout failure, and the test method does not complete normally.

======================================================================================================
	 */
	
	/*
	 * 3. timeOut syntax and units
@Test(timeOut = 10000)
public void testMethod() {
    // Test logic
}


Value	Maximum time
1000	1 second
3000	3 seconds
5000	5 seconds
10000	10 seconds
60000	1 minute

The value is specified in milliseconds.
=====================================
	 */

	/*
	 * 4. Practical example – Timeout with Selenium
Suppose a Selenium test is taking too long to complete.
@Test(timeOut = 10000)
public void loginTest() {

    WebDriver driver = new ChromeDriver();

    driver.get("https://example.com");

    // Login test steps

    driver.quit();
}


Here, TestNG allows the test method a maximum of 10 seconds.

If the method exceeds that limit, TestNG reports a timeout failure.

Important: Use try-finally or appropriate cleanup mechanisms to ensure the browser is closed even when a test fails or times out.

===========================================================================================================
	 */

	/*
	 * 5. timeOut vs Selenium WebDriverWait
This is an important interview distinction.
TestNG timeOut	Selenium WebDriverWait
Controls the maximum execution time of a test method.	Waits for a particular condition in the browser.
Applied using @Test(timeOut = ...).	Created using new WebDriverWait(...).
If exceeded, the test fails due to timeout.	If the condition is not met, a TimeoutException is thrown.
Applies to the test method's execution.	Applies to a specific wait operation.

Example of Selenium explicit wait:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.id("username")
));


Here, Selenium waits up to 10 seconds for the username field to become visible.

Remember: WebDriverWait does not set a maximum execution time for the entire TestNG test method.
=============================================================================================================================

/*
 * 6. timeOut vs invocationTimeOut
TestNG also provides invocationTimeOut, which is useful when a test method is executed multiple times.
Attribute	Purpose
timeOut	Maximum allowed execution time for a test method invocation.
invocationTimeOut	Maximum allowed total time for all invocations of a test method.

Example:
@Test(invocationCount = 5, invocationTimeOut = 10000)
public void testMethod() throws InterruptedException {
    Thread.sleep(1500);
    System.out.println("Test executed");
}


Here:
- The method is configured to execute 5 times.
- Each execution takes approximately 1.5 seconds.
- Total expected execution time is approximately 7.5 seconds.
- The overall invocation limit is 10 seconds.
If the total invocation time exceeds the configured limit, TestNG reports a timeout failure.

==================================================================================
 */
	
	/*
	 * 7. Important interview points
1. timeOut is specified in milliseconds.
2. It defines the maximum allowed execution time for a test method invocation.
3. If the execution exceeds the limit, TestNG reports a failure.
4. It can be applied directly to the @Test annotation.
5. It is different from Selenium's implicit and explicit waits.
6. invocationTimeOut controls the total time allowed for multiple invocations.
7. A timeout does not guarantee that every operation started by the test will immediately stop. Code that does not respond to interruption may continue running.


8. Quick revision
Question	Answer
Which attribute defines a test execution timeout?	timeOut
What is its unit?	Milliseconds
How to set a 5-second timeout?	@Test(timeOut = 5000)
What happens if the timeout is exceeded?	Test fails due to timeout
Is it the same as WebDriverWait?	No
What is invocationTimeOut?	Maximum total time for all invocations

Interview-ready answer:

"timeOut is an attribute of TestNG's @Test annotation that specifies the maximum time a test method is allowed to execute. The value is in milliseconds.

 If the method exceeds the configured time, TestNG reports a timeout failure."
	 */
}

