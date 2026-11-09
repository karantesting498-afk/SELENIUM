/*
 * 	Question 4 – Parallel execution and Selenium
Consider:
@DataProvider(name = "data", parallel = true)
public Object[][] getData() {
    return new Object[][] {
        {"admin", "admin123"},
        {"user", "user123"},
        {"manager", "manager123"}
    };
}

@Test(dataProvider = "data")
public void loginTest(String username, String password) {

    WebDriver driver = new ChromeDriver();

    driver.get("https://example.com/login");

    // Login steps

    driver.quit();
}


Answer these:
1. What does parallel = true do?
2. Can all three invocations execute simultaneously?
3. What configuration controls the maximum number of DataProvider threads?
4. What problems could occur if all invocations share the same static WebDriver?
5. How would you manage WebDriver safely during parallel execution?
 */
package Selenium.revision.date_2026_10_31;

public class Q4_Step4 {
	
	/*
	 * 1. paraller=true run the multiple test set data simultaneously.
	 * 2. Yes using parallel execution.
	 *  Q2 – Can all three invocations execute simultaneously?
Your answer is partially correct.

Yes, all three can execute concurrently, provided the available DataProvider thread capacity is at least three.

However, parallel = true does not guarantee that all three start at exactly the same time.

It enables concurrent execution, subject to thread availability and scheduling.
	 * 
	 * 
	 * 
	 * 3. Parallel execution controls parallel execution
	 * Q3 – What configuration controls the maximum number of DataProvider threads?
This is where your answer needs correction.

The TestNG configuration is:
<suite name="ParallelSuite" data-provider-thread-count="3">


The attribute data-provider-thread-count controls the maximum number of threads available for parallel DataProvider execution at the suite level.

For example:
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="ParallelSuite" data-provider-thread-count="2">

    <test name="LoginTests">
        <classes>
            <class name="Selenium.revision.date_31Oct.Q4_Step4"/>
        </classes>
    </test>

</suite>


With three data sets and a thread count of two:
- Two invocations can execute concurrently.
- The remaining invocation waits for an available thread.



	 * 
	 * 
	 * 
	 * 
	 * 4. All test run will use same webDriver which will cause issue during the browser navigation,
	 * mixed test data etc.
	 * 
	 * Your answer says all test cases will run on the same thread. This is incorrect.

Parallel execution means different invocations can run on different threads.

The actual problem is that multiple threads may access the same WebDriver instance.

For example:
public static WebDriver driver;


Imagine three threads sharing this driver:
Thread	Operation
Thread 1	Opens admin login page
Thread 2	Opens user login page
Thread 3	Opens manager login page

All three threads are trying to control the same browser session.

Possible problems:
1. Browser navigation conflict: One thread navigates to a different page while another thread is performing login.
2. Mixed test data: One thread may enter credentials while another thread changes the page or interacts with the same fields.
3. Unexpected element interactions: One thread may locate an element while another thread changes the browser's current page.
4. Session interference: One thread may log out or close the browser while another thread is still executing.



	 * 
	 * 5. Using multi threading
	 * 
	 * Approach 1: Create a separate WebDriver instance for every test invocation

This is actually what the question's original code already does:


Approach 2: Use ThreadLocal WebDriver

When you need a shared WebDriver management class in an automation framework, you can use ThreadLocal.



	 * 5.
	 * 
	 */

}
