/*
 * Question 1 – Execution flow and dependency chain
Difficulty: Hard

Consider the following code:
public class DependencyTest {

    @Test
    public void login() {
        System.out.println("Login");
    }

    @Test(dependsOnMethods = {"login"})
    public void searchProduct() {
        System.out.println("Search Product");
        Assert.fail("Search failed");
    }

    @Test(dependsOnMethods = {"login"})
    public void viewProfile() {
        System.out.println("View Profile");
    }

    @Test(dependsOnMethods = {"searchProduct", "viewProfile"})
    public void checkout() {
        System.out.println("Checkout");
    }
}


Answer the following:
1. Which methods will execute?
2. Which methods will be marked as skipped?
3. Will checkout() execute if viewProfile() passes but searchProduct() fails?
4. Draw the execution dependency flow.
 */
package Selenium.revision.date_2026_10_28;

public class DependencyTest_Step2 {
	
	/*
	 * 1. As per alphabetic order, checkout() should be executed first but it is dependent on search and viewProfile. 
	 * and these 2 methods are dependent on login().
	 * So first method to execute will be login.
	 * 
	 * 
	 * 2. checkout method will be skipped as search fails.
	 * 
	 * 3. No, checkout will not be executed because search is failed
	 * 
	 * 4. login-> search ->
	 * Login ->  View Profile 
	 * 
	 * -> checkout
	 */

}
