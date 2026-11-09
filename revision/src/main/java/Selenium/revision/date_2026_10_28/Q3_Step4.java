/*
 * Question 3 – Practical coding challenge
Difficulty: Hard

You are automating an e-commerce application. The required execution flow is:
1. launchBrowser() – Launch browser.
2. login() – Log in to the application.
3. searchProduct() – Search for a product.
4. addToCart() – Add product to cart.
5. applyCoupon() – Apply coupon.
6. checkout() – Complete checkout.
Requirements:
- login() should execute only after launchBrowser().
- searchProduct() should execute only after login().
- addToCart() should execute only after searchProduct().
- applyCoupon() and checkout() should both depend on addToCart().
- checkout() should still execute if applyCoupon() fails.
- If addToCart() fails, applyCoupon() and checkout() should be skipped.
Your task: Write the complete TestNG class using @Test and dependsOnMethods.

Also explain why you chose alwaysRun (or did not choose it) for each relevant method.
 */
package Selenium.revision.date_2026_10_28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Q3_Step4 {
	
	WebDriver driver;
	
	
	@Test
	public void launchBrowser()
	{
		driver= new ChromeDriver();
		System.out.println("Driver launched");
	}
	
	@Test(dependsOnMethods = {"launchBrowser"})
	public void login()
	{
		System.out.println("Login");
	}
	
	@Test(dependsOnMethods = {"login"})
	public void searchProduct()
	{
		System.out.println("Search Products");
	}
	
	
	@Test(dependsOnMethods= {"searchProduct"})
	public void addToCart()
	{
		System.out.println("Add To Cart");
	}
	
	@Test(dependsOnMethods= {"addToCart"})
	public void applyCoupon()
	{
		System.out.println("Coupon applied");
		Assert.fail("Coupon expired");
	}
	
	
	@Test(dependsOnMethods= {"addToCart"})
	public void checkout()
	{
		System.out.println("Checkout successs");
	}

}
