/*
 * Question 2 – timeOut vs invocationTimeOut
Hard
Consider:
public class TimeoutTest {

    @Test(
        invocationCount = 4,
        timeOut = 3000,
        invocationTimeOut = 8000
    )
    public void executeTest() throws InterruptedException {

        System.out.println("Execution Started");
        Thread.sleep(2500);
        System.out.println("Execution Completed");
    }
}


Answer:
1. How many invocations are configured?
2. What is the maximum time allowed for an individual invocation?
3. What is the maximum total time allowed for all invocations?
4. Will all four invocations complete successfully?
5. Explain which timeout limit is likely to be exceeded and why.
Assume sequential execution for this question.
 */
package Selenium.revision.date_2026_10_30;

public class TimeoutTest_Step3 {
	
	/*
	 * 1. 4
	 * 2. 3 seconds
	 * 3. 8 seconds
	 * 4. no because 4*2.5= 10 seconds but invocation time is only 8 seconds so only 3 invocation will work.
	 * 5. 4th invocation due to 4*2.5= 10 seconds but invocation time is only 8 seconds so only 3 invocation will work.

	 */

}
