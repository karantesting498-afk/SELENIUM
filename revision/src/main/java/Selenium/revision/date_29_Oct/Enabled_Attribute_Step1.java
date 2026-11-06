// This class contains knowledge regarding the helper attribute
package Selenium.revision.date_29_Oct;

public class Enabled_Attribute_Step1 {
	
	
	/*
	 * TestNG – enabled Attribute
The enabled attribute in TestNG's @Test annotation is used to enable or disable a test method.

By default, enabled = true, meaning the test method is enabled and eligible for execution.


1. Basic syntax
@Test(enabled = true)
public void login() {
    System.out.println("Login test");
}

@Test(enabled = false)
public void signup() {
    System.out.println("Signup test");
}


Expected behavior:
- login() will execute.
- signup() will not execute because it is disabled.

====================================================================================
	 */
	
	
	/*
	 * 2. Default value of enabled
If you don't specify the enabled attribute, TestNG considers it true.

These two declarations are equivalent:
@Test
public void login() {
    System.out.println("Login");
}


@Test(enabled = true)
public void login() {
    System.out.println("Login");
}
============================================================================================
	 *
	 */
	
	
	/*
	 * 3. Disabling a test temporarily
Suppose you have 5 test methods, but one test is currently unstable or under development.
@Test
public void login() {
    System.out.println("Login");
}

@Test
public void searchProduct() {
    System.out.println("Search Product");
}

@Test(enabled = false)
public void addToCart() {
    System.out.println("Add to Cart");
}

@Test
public void checkout() {
    System.out.println("Checkout");
}


Here, addToCart() will not execute.

Important: The disabled test is not treated as a failed test. It is excluded from normal execution.
=======================================================================================================
	 */
	
	/*
	 * 4. Class-level enabled attribute
You can also use enabled at the class level.
@Test(enabled = false)
public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Valid Login");
    }

    @Test
    public void invalidLogin() {
        System.out.println("Invalid Login");
    }
}


Both methods will be disabled.

You can override the class-level setting at the method level:


@Test(enabled = false)
public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Valid Login");
    }

    @Test(enabled = true)
    public void invalidLogin() {
        System.out.println("Invalid Login");
    }
}


Here, invalidLogin() is explicitly enabled and can execute.
=========================================================================================
	 */
	
	
	/*
	 * 5. enabled vs dependsOnMethods
This is an important interview concept.

Consider:
@Test(enabled = false)
public void login() {
    System.out.println("Login");
}

@Test(dependsOnMethods = {"login"})
public void searchProduct() {
    System.out.println("Search Product");
}


What happens?
- login() will not execute because it is disabled.
- searchProduct() will not execute because its dependency is disabled and therefore unavailable for successful completion.
The dependent method will be skipped.

=====================================================================================
	 */
	
	
	/*
	 * 6. enabled vs priority vs groups
Attribute	Purpose
enabled	Enables or disables a test method.
priority	Controls the execution order of test methods.
groups	Categorizes and selects test methods for execution.
dependsOnMethods	Establishes dependencies between test methods.


==============================================================================
	 */
	
	
	/*
	 * 7. Important interview points
1. Default value of enabled is true.
2. enabled = false prevents a test method from being executed.
3. It can be applied at the class level or method level.
4. A method can be explicitly enabled even when its class has enabled = false.
5. A disabled test is not counted as a normal failed test.
6. Disabling a dependency can cause dependent methods to be skipped.
7. enabled is different from groups: disabling is not the same as excluding a group.


==============================================================================================
	 */
	
	
	/*
	 * 8. Quick revision
Question	Answer
What is the default value?	true
How to disable a test?	@Test(enabled = false)
Can we apply it at class level?	Yes
Does a disabled test execute?	No
Is a disabled test a failure?	No
Can a disabled method's dependent method execute normally?	No, the dependency cannot complete successfully.


==========================================================================================
	 */
	
	/*
	 * Interview-ready answer:

"enabled is an attribute of TestNG's @Test annotation used to control whether a test method should participate in execution. Its default value is true. Setting it to false disables the test method without treating it as a normal test failure."




	 */

}
