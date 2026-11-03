/*
 * Q5. Advanced Scenario — @BeforeClass vs @BeforeMethod
Type: Interview Scenario + Practical Coding | Hard

You are given the following requirements:

A test class contains five test methods.
- Browser initialization is expensive.
- All five tests need the same login session.
- Each test should independently verify a different module.
- Tests should not interfere with each other's browser state.
- Browser initialization should not happen unnecessarily.
Tasks:
1. Would you choose @BeforeClass or @BeforeMethod? Justify your choice.
2. Explain the conflict between sharing a login session and maintaining test independence.
3. Design a suitable execution strategy.
4. Write a sample Java + Selenium + TestNG class demonstrating your approach.
5. What problems could arise if two test methods execute simultaneously using the same WebDriver instance?
 */
package Selenium.revision.date_25_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q5_Step6 {
	
	WebDriver driver;
	String url = "https://example.com";
	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		
	}
	
	@Test
	public void testA()
	{
		driver.get(url);
		System.out.println("1 Method");
	}
	
	@Test
	public void testB()
	{
		driver.get(url);
		System.out.println("2 Method");
	}
	
	@Test
	public void testC()
	{
		driver.get(url);
		System.out.println("3 Method");
	}
	
	@Test
	public void testD()
	{
		driver.get(url);
		System.out.println("4 Method");
	}
	
	@Test
	public void testE()
	{
		driver.get(url);
		System.out.println("5 Method");
	}
	
	/*
	 * 1. We will use @BeforeClass to initialize the browser because calling new browser for every test case is time consuming 
	 * and expensive and our requirement here is for the same browser session.
	 * 
	 * 2. Same browser login and test independence creates a conflict because sometimes we cannot find 
	 * whether the issue is from the test or from which test. this leads to make code debug more complicated.
	 * 
	 * 2. Explain the conflict between sharing a login session and maintaining test independence
Partially correct
Your answer:
Sometimes we cannot find whether the issue is from the test or from which test. This leads to more complicated debugging.

You have identified one consequence, but you haven't explained the actual conflict.

Let's understand it.

Suppose you have five test methods:
Test	Module
testA()	Profile
testB()	Products
testC()	Cart
testD()	Orders
testE()	Settings

All five tests require an authenticated user.

Now consider this scenario:
- testA() logs in successfully.
- testB() modifies the user's profile.
- testC() logs out.
- testD() tries to access orders.
- testE() tries to access settings.
What happens?

testD() and testE() might fail because testC() logged out of the application.

This is the conflict.

Sharing authentication state does not mean sharing every aspect of application state.

We want:
- Authentication state to be shared.
- Browser session to be shared.
- Each test's navigation state to be controlled independently.
- Each test's data modifications to be isolated or cleaned up.
These are different responsibilities.



	 * 
	 * 3. We can call same url again and again.
	 * 
	 * 4. code
	 * 
	 * 5. If we run parallel execution on same browser session then it will lead to error for example.
	 * one test case open profile and other open employee.
	 * now run both test case parallel, then driver will be confused which to execute
	 */

}
