/*
 * Question 5 – Advanced listener implementation
You need to create a custom execution logger for your Selenium framework.

Your requirements:
- Print the test method name when execution starts.
- Print PASS when a test passes.
- Print FAIL along with the exception message when a test fails.
- Print SKIP when a test is skipped.
- Record the total number of passed, failed, and skipped tests.
- Print the final execution summary after all test methods finish.
Task:

Implement this using ITestListener.

Also answer:
1. Which callback methods will you use?
2. Which variables would you use to maintain the execution counts?
3. Why could ordinary static counters become problematic during parallel execution?
4. Should the final summary be printed in onFinish() or onTestSuccess()?
5. What is the difference between ITestListener and IReporter for generating execution reports?
 */
package Selenium.revision.date_2026_11_01;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Selenium.revision.date_2026_11_01.Listeners_Step1.class)
public class Q5_Step6 {
	
	
	/*
	 * 1. ONtestStart,Fail, Skipped, onFinish, onTestSuccess().
	 * 
	 * 2. we can use context to get success, fail, skip count.
	 * 
	 * 3. Because static variable is shared across whole class methods. If during parallel run multiple methods call same variable,
	 * Then there might be issue with count.
	 * 
	 * 4. onFinish because through context we can fetch all success, fail, skip data but in onTestSuccess we cannot get data of skip
	 * 
	 * 5. Don't know
	 * 
	 * Q5. Difference between ITestListener and IReporter
This is the missing answer.
ITestListener	IReporter
Monitors test execution events.	Generates customized reports after execution.
Provides callbacks such as onTestStart(), onTestFailure() and onTestSuccess().	Provides the generateReport() method.
Useful for real-time execution logging.	Useful for creating consolidated execution reports.
Can capture screenshots when a test fails.	Can generate HTML, custom summaries, and other report formats.
	 */
	
	
	@Test
	public void testA()
	{
		System.out.println("success");
	}
	
	@Test
	public void testB()
	{
		System.out.println("Fail");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = {"testB"})
	public void testC()
	{
		System.out.println("Skipped");
	}

}
