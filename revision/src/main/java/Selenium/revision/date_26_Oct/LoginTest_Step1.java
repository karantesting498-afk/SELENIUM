/*
 * xQ1. Execution Flow & Variable Scope — Theory + Output
Consider the following code:
public class LoginTest {

    int count = 0;

    @BeforeClass
    public void beforeClass() {
        count++;
        System.out.println("BeforeClass: " + count);
    }

    @BeforeMethod
    public void beforeMethod() {
        count++;
        System.out.println("BeforeMethod: " + count);
    }

    @Test
    public void testLogin() {
        count++;
        System.out.println("TestLogin: " + count);
    }

    @Test
    public void testLogout() {
        count++;
        System.out.println("TestLogout: " + count);
    }

    @AfterMethod
    public void afterMethod() {
        count++;
        System.out.println("AfterMethod: " + count);
    }

    @AfterClass
    public void afterClass() {
        count++;
        System.out.println("AfterClass: " + count);
    }
}

Answer these questions:
1. What will be the execution order of the methods?
2. What will be the value of count printed in each method?
3. How many times will @AfterClass execute?
4. Will @AfterClass execute if one of the @Test methods fails? Explain.
 */
package Selenium.revision.date_26_Oct;

public class LoginTest_Step1 {

	
	/*
	 * 1 and 2 answer 
	 * Output:
	 * BeforeClass: 1
	 * BeforeMethod: 2
	 * TestLogin: 3
	 * AfterMethod: 4
	 * BeforeMethod: 5
	 * TestLogout: 6
	 * AfterMethod: 7
	 * AfterClass: 8
	 * 
	 * 
	 * 3. AfterClass will only be called once in class execution
	 * 
	 * 4. Yes, after Class method will be executed after all Test method have been executed or skipped.
	 * 
	 * 

	 */
}
