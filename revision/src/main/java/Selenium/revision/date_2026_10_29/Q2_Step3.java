/*
 * Question 2 – enabled with dependsOnMethods
Difficulty: Hard

Consider this code:
public class DependencyTest {

    @Test
    public void login() {
        System.out.println("Login");
    }

    @Test(dependsOnMethods = {"login"})
    public void searchProduct() {
        System.out.println("Search Product");
    }

    @Test(dependsOnMethods = {"searchProduct"}, enabled = false)
    public void addToCart() {
        System.out.println("Add To Cart");
    }

    @Test(dependsOnMethods = {"addToCart"})
    public void checkout() {
        System.out.println("Checkout");
    }
}


Answer:
1. Which methods will execute?
2. What will happen to addToCart()?
3. Will checkout() execute even though searchProduct() passes?
4. Explain the difference between a disabled method and a failed method in this scenario.
 */
package Selenium.revision.date_2026_10_29;



public class Q2_Step3 {

	/*
	 * 1. login() and searchProduct() will be executed
	 * 2. Since enabled= false, it will be skipped.
	 * 3. No addToCart is dependent method of checkout and it is enabled =false;
	 * so checkout will be skipped.
	 * 4. Disable method it will be skipped , will not be marked as pass/fail.
	 * Fail method means assertion is failed
	 */
}
