/*
 * Question 1 – Execution flow and callback analysis
Consider the following code:
public class LoginTest {

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        Assert.fail("Test 2 failed");
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        System.out.println("Test 3");
    }
}


Your listener:
public class MyListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped: " + result.getName());
    }
}


Questions:
1. Which listener callbacks will execute for each test?
2. Will onTestStart() execute for test3()?
3. Will onTestSkipped() execute for test3()?
4. Will the listener stop the execution of test1() because test2() failed?
5. Explain the difference between a failed test and a skipped test from the listener's perspective.
 */
package Selenium.revision.date_2026_11_01;

public class LoginTest_Step2 {
	
	
	/*
	 * 1. onTestStart, onTestSuccess, onTestFailure, onTestSkipped
	 * 2. No
	 * 
	 * 
	 * Q2. Will onTestStart() execute for test3()?
Incorrect

Your answer: No.

Correct answer: Yes.

This is an important distinction.

test3() is still scheduled for execution by TestNG. TestNG starts processing the test method, but because its dependency (test2) failed, TestNG does not execute its actual method body.

Therefore:
- onTestStart() executes.
- test3() method body does not execute.
- onTestSkipped() executes.



	 * 3. yes
	 * 4. No
	 * 5. Failed test case means assertion failed and method onTestFailure will be executed 
	 * but skipped means test was not even executed and method onTestSkipped will be executed
	 * 
	 * Failed test: The test method was executed, but an assertion failed or an exception occurred. TestNG invokes onTestFailure().



Skipped test: The test method's body was not executed because TestNG determined it should be skipped, such as when a dependency fails. TestNG invokes onTestSkipped().



	 */

}
