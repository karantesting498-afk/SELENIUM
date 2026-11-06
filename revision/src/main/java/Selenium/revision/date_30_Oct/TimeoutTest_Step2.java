/*
 * Question 1 – Timeout and execution flow
Hard
Consider the following code:
public class TimeoutTest {

    @Test(timeOut = 4000)
    public void test1() throws InterruptedException {
        System.out.println("Test 1 Started");
        Thread.sleep(2000);
        System.out.println("Test 1 Completed");
    }

    @Test(timeOut = 3000)
    public void test2() throws InterruptedException {
        System.out.println("Test 2 Started");
        Thread.sleep(5000);
        System.out.println("Test 2 Completed");
    }

    @Test(dependsOnMethods = {"test2"})
    public void test3() {
        System.out.println("Test 3 Executed");
    }
}


Answer the following:
1. What will be the status of all three test methods?
2. Will Test 2 Completed be printed?
3. Will test3() execute?
4. If test1() passes, does it have any impact on the execution of test2()?
5. Explain the difference between a timeout failure and an assertion failure.
 */
package Selenium.revision.date_30_Oct;

public class TimeoutTest_Step2 {
	
	/*
	 * 1. 
	 * test1() - executed
	 * test2() - fail
	 * test3()- skipped
	 * 
	 * 2. No, it will not be printed.As max timeout is 3 seconds but sleep is of 5 seconds
	 * 
	 * 3. no because test3 is dependent on test2 and test 2 will fail.
	 * 
	 * 4. No
	 * 
	 * 5. Timeout failure means we did not get the response within specified time and assertion failure means our assertion is failed.
	 * Our actual output did not meet with expected output
	 * 
	 */

}
