// This class contain knowledge regarding the dependsOnMethod


package Selenium.revision.date_2026_10_28;

public class DependOnMethod_Step1 {
	
	
	/*
	 * TestNG – dependsOnMethods
dependsOnMethods is used in TestNG when one test method must execute only after another test method has successfully completed.

It establishes a dependency between test methods and controls their execution order.


1. Basic syntax
@Test
public void login() {
    System.out.println("Login successful");
}

@Test(dependsOnMethods = {"login"})
public void searchProduct() {
    System.out.println("Product searched");
}


Execution flow:
1. login() executes first.
2. If login() passes, searchProduct() executes.
3. If login() fails, searchProduct() is skipped.


===========================================================================================
	 */

	
	/*
	 * 2. What happens when the dependent method fails?
@Test
public void login() {
    System.out.println("Login");
    Assert.fail("Login failed");
}

@Test(dependsOnMethods = {"login"})
public void searchProduct() {
    System.out.println("Search product");
}


Expected behavior:
- login() will execute and fail.
- searchProduct() will be marked as SKIPPED.
- TestNG will not execute the dependent method.
Important
 A dependent method is skipped when its dependency fails or is skipped.
 
 
 ------------------------------------------------------------------------------------------------------
	 */
	
	
	/*
	 * 3. Multiple dependencies
A test method can depend on multiple methods.
@Test
public void login() {
    System.out.println("Login");
}

@Test
public void selectCategory() {
    System.out.println("Category selected");
}

@Test(dependsOnMethods = {"login", "selectCategory"})
public void addToCart() {
    System.out.println("Product added to cart");
}


Here, addToCart() will execute only after both login() and selectCategory() pass.
=================================================================================================
	 */
	
	/*
	 * 4. Dependency chain
You can create a sequence of dependent test methods.
@Test
public void login() {
    System.out.println("Login");
}

@Test(dependsOnMethods = {"login"})
public void searchProduct() {
    System.out.println("Search product");
}

@Test(dependsOnMethods = {"searchProduct"})
public void addToCart() {
    System.out.println("Add to cart");
}

@Test(dependsOnMethods = {"addToCart"})
public void checkout() {
    System.out.println("Checkout");
}


Execution order:
login()

searchProduct()

addToCart()

checkout()


If searchProduct() fails, both addToCart() and checkout() will be skipped.



===========================================================================================
	 */
	
	
	/*
	 * 5. Hard dependency vs soft dependency
TestNG supports two types of dependencies:
Type	Syntax	Behavior
Hard dependency	dependsOnMethods	Dependent method is skipped if its dependency fails.
Soft dependency	alwaysRun = true with dependency	Dependent method can execute even if its dependency fails.

Example:


@Test
public void login() {
    System.out.println("Login");
    Assert.fail("Login failed");
}

@Test(dependsOnMethods = {"login"}, alwaysRun = true)
public void searchProduct() {
    System.out.println("Search product");
}


Here, searchProduct() can execute even if login() fails.

Important: alwaysRun = true does not mean the dependency passed. 

It means TestNG should allow the dependent method to run despite the dependency's failure.

====================================================================================


	 */
	
	
	/*
	 * 6. Dependency on methods from another class
You can also establish dependencies on methods belonging to another class, using the fully qualified class name.
@Test
public void login() {
    System.out.println("Login");
}


Suppose this method is inside test.LoginTest.

In another class:
@Test(dependsOnMethods = {"test.LoginTest.login"})
public void searchProduct() {
    System.out.println("Search product");
}


The dependency method must be available to TestNG in the same test execution.

=============================================================================================
	 */
	
	
	/*
	 * 7. Important points for interviews
1. dependsOnMethods controls execution dependencies, not just the order of execution.
2. TestNG automatically executes the dependency before the dependent method.
3. A dependent method is skipped if its hard dependency fails or is skipped.
4. A method can depend on multiple methods.
5. Dependencies can form a chain.
6. Avoid circular dependencies, such as A depending on B and B depending on A.
7. If you only want to control execution order without creating a dependency, use priority.
8. Dependencies are resolved by TestNG method names; use fully qualified names for dependencies across classes.
================================================================

	 */
}
