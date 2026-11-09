/*
 * Question 2 – Debugging alwaysRun
Difficulty: Hard

Consider this code:
public class DependencyTest {

    @Test
    public void createUser() {
        System.out.println("Create User");
        Assert.fail("User creation failed");
    }

    @Test(dependsOnMethods = {"createUser"}, alwaysRun = true)
    public void login() {
        System.out.println("Login");
    }

    @Test(dependsOnMethods = {"login"})
    public void updateProfile() {
        System.out.println("Update Profile");
    }
}


Answer:
1. Will login() execute even though createUser() fails?
2. Will updateProfile() execute?
3. What will be the status of all three methods?
4. What is the difference between alwaysRun = true here and alwaysRun = true on a configuration annotation such as @BeforeMethod?
 */

package Selenium.revision.date_2026_10_28;

public class DependencyTest_Step3 {
	
	/*
	 * 1. Yes because we have added alwaysRun = true;
	 * 
	 * 2. yes
	 * 
	 * 3. createUser()- fail
	 * and other two methods will be pass
	 * 
	 * 4. here alwaysRun = true means that this method must be executed even when dependent createUser() method fails.
	 * and lwaysRun = true on a configuration annotation such as @BeforeMethod means to run this method always regardless of 
	 * grouping and other
	 */

}
