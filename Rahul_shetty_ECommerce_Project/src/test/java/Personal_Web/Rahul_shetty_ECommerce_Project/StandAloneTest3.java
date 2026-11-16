/*
 * This class test is created using base test, global properties
 */
package Personal_Web.Rahul_shetty_ECommerce_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DisabledRetryAnalyzer;

import rahulshettyacademy.TestComponent.RetryFailure;
import rahulshettyacademy.TestComponent.TestComponent;
import rahulshettyacademy.pageobjects.CardDetails;
import rahulshettyacademy.pageobjects.Cart;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.OrderHistory;
import rahulshettyacademy.pageobjects.ProductCatelogue;

public class StandAloneTest3 extends TestComponent {

	String productToAdd = "ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException {


		ProductCatelogue catelogue = landing.loginApplication("karan@mailinator.com", "Admin@123");

		// Fetch product



		// Add to cart

		Cart cart = catelogue.addToCart(productToAdd);

		Assert.assertTrue(cart.verifyProductInCart(productToAdd));

		// Checkout cart and add payment card details

		CardDetails card = cart.checkOut();

		String deliveryCountry = "India";

		OrderConfirmation confirm = card.addCardDetails("1234 5678 1234 5678", "123", "Karan Bajaj", "New Coupon", "10",
				"29", "IND", deliveryCountry);

		Assert.assertTrue(confirm.orderConfirmationAssertion().equalsIgnoreCase("Thankyou for the order."));

	}

	
	// Verify order history
	
	@Test(dependsOnMethods = "submitOrder", retryAnalyzer = RetryFailure.class)
	public void orderHistory()
	{
		ProductCatelogue catelogue = landing.loginApplication("karan@mailinator.com", "Admin@123");

		OrderHistory orderhistory =catelogue.goToOrderHistory();
		
		Assert.assertTrue(orderhistory.verifyOrderDisplay(productToAdd));
		
		
	}
}
