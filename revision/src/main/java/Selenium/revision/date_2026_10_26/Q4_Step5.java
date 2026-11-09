/*
 * Q4. Failure Handling — Practical Scenario
Consider this scenario:
- @BeforeClass launches Chrome.
- Test 1 passes.
- Test 2 fails because an assertion fails.
- Test 3 passes.
- @AfterClass is responsible for closing the browser.
Answer:
1. Will @AfterClass normally execute after Test 2 fails?
2. Does a failed assertion automatically terminate the entire TestNG class execution?
3. What happens if @BeforeClass itself fails before the browser is initialized?
4. Write a safe @AfterClass method that prevents a NullPointerException during cleanup.
 */
package Selenium.revision.date_2026_10_26;

public class Q4_Step5 {
	
	/*
	 * 1. Yes , AfterClass method will be executed irrespective of test faliure of method2.
	 * 2. No, failed assertion marks the test method as failed.
	 * 3. driver session will not be initiated.
	 * 4. @AfterClass
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
	 */

}
