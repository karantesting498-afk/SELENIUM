/*
 * Q5. Real-World Framework Design — Shared vs Independent Browser
You are designing a Selenium automation framework with 20 test methods in one TestNG class.

Your team proposes this approach:
@BeforeClass
public void setup() {
    driver = new ChromeDriver();
}

@AfterClass
public void tearDown() {
    driver.quit();
}

However, you notice the following problems:
- One test logs out of the application.
- Another test changes user preferences.
- A third test navigates to a different page.
- Tests may eventually run in parallel.
Answer:
1. What risks can arise from sharing one browser instance across all 20 tests?
2. Would @AfterClass still be suitable for browser cleanup if you switch to one browser per test?
3. Which combination of TestNG annotations would you use for one browser per test?
4. Explain when you would prefer @AfterClass over @AfterMethod for browser cleanup.
 */
package Selenium.revision.date_2026_10_26;

public class Q5_Step6 {

	/*
	 * 1. Since all test method uses the same browser session and one of the test cases is of login , logout and other.
	 * Suppose user login and logout , then rest of the test cases will be skipped in this case.
	 * 
	 * 
	 * Your answer:
Since all test methods use the same browser session. Suppose one test case logs in and logs out, then the rest of the test cases will be skipped.

Your reasoning is correct, but there is an important distinction:

The remaining tests will not automatically be skipped just because one test logs out. They may execute, but they could fail because the shared browser is now in an unexpected state.

For example:
Test	Action	Possible impact
Test 1	Login	User becomes authenticated
Test 2	Logout	Session is terminated
Test 3	Open profile page	May be redirected to login
Test 4	Change preferences	May fail because the user is logged out
Test 5	Verify dashboard	May fail because authentication is missing

Other risks include:
1. State dependency: One test changes the application state and affects subsequent tests.
2. Test execution order dependency: Tests may pass or fail depending on their execution sequence.
3. Browser state contamination: Cookies, local storage, session storage, and navigation state may be modified by previous tests.
4. Parallel execution conflicts: Multiple tests may attempt to navigate or interact with the same browser simultaneously.
5. Debugging difficulties: Failures become harder to reproduce because the browser state depends on previous tests.
	 * 
	 * 2. No, because AfterClass is only executed when all test methods are executed or skipped.
	 * 
	 * 3. BeforeMethod and AfterMethod
	 * 
	 * 4. AfterClass in case we are quitting a shared browser, cleaning up shared browser resource.
	 * AfterClass is only executed once.
	 * 
	 * AfterMethod in case we are maintaining new browser session for each test case, cleaning up test method browser resources.
	 * AfterMethod is executed each time after TestMethod provided, no configuration error
	 */
}
