/*
 * Question 4 – Listener vs configuration annotations
Consider:
public class LoginTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Before Method");
    }

    @Test
    public void login() {
        System.out.println("Login Test");
        Assert.fail("Failed");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After Method");
    }
}


Listener:
public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Listener Start");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Listener Failure");
    }
}


Questions:
1. What is the execution order of @BeforeMethod, onTestStart(), @Test, onTestFailure(), and @AfterMethod?
2. Does onTestFailure() execute before or after @AfterMethod?
3. If @BeforeMethod fails, will onTestFailure() execute for the test method?
4. Which listener callback would you expect for a test that cannot execute because its setup failed?
5. Why should screenshot capture generally happen before @AfterMethod quits the browser?
 */

package Selenium.revision.date_2026_11_01;

public class LoginTest_Step5 {
	
	/*
	 * 1. Execution order Output:
	 * Before Method
	 * Listener Start
	 * Login Test
	 * Listener Failure
	 * After Method
	 * 
	 * 2. Yes
	 * 3. No, If beforemethod failed, then subsequent method 	login will be skipped and onTestFail method will not be called.
	 * 4. ONTestSkipped()
	 * 5. Because if broweser is quit() the session ends. and  then if  we can take Screenshot ,
	 *  then dirver will not be able to access the previous session
	 */

}
