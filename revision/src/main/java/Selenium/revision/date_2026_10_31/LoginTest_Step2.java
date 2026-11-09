/*
 * Question 1 – Execution flow and debugging
Consider the following code:
public class LoginTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user", "user123"},
            {"manager", "manager123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        System.out.println("Login: " + username);

        if (username.equals("user")) {
            Assert.fail("Login failed");
        }
    }

    @Test(dependsOnMethods = "loginTest")
    public void verifyDashboard() {
        System.out.println("Dashboard verified");
    }
}


Answer these:
1. How many times will loginTest() be invoked?
2. If the second data set fails, what happens to the third data set?
3. Will verifyDashboard() execute?
4. How would you modify the code if you wanted verifyDashboard() to execute only when all data-driven login invocations passed?
 */
package Selenium.revision.date_2026_10_31;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_Step2 {

	/*
	 * 1. It will be executed 3 times.
	 * 2. Third test set will still be executed even if second fails.
	 * 3. Yes, It will be executed 2 times with test set 1 and 3.
	 * 4. We can add a count
	 */
	  @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"admin", "admin123"},
	            {"user", "user123"},
	            {"manager", "manager123"}
	        };
	    }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) {

	        System.out.println("Login: " + username);

	        if (username.equals("user")) {
	            Assert.fail("Login failed");
	        }
	        
	    }
	    
	

	    @Test(dependsOnMethods = "loginTest")
	    public void verifyDashboard() {
	    	
	        System.out.println("Dashboard verified");
	    }
}
