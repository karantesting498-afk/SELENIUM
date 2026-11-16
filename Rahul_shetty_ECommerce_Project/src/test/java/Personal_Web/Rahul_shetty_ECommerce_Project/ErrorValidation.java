package Personal_Web.Rahul_shetty_ECommerce_Project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import rahulshettyacademy.TestComponent.TestComponent;
import rahulshettyacademy.pageobjects.CardDetails;
import rahulshettyacademy.pageobjects.Cart;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.ProductCatelogue;

public class ErrorValidation extends TestComponent{

	@Test(groups = {"ErrorHandling"})
	public void loginErrorValidation()
	{
		ProductCatelogue catelogue = landing.loginApplication("karan@mailinator.com", "Admin@1234");
		
		Assert.assertTrue(landing.getErrorMsg().equalsIgnoreCase("Incorrect email or password."));

	}
	

	@Test
	public void submitOrderValidation() throws IOException {


		ProductCatelogue catelogue = landing.loginApplication("karan2@mailinator.com", "Admin@123");

		// Fetch product

		String productToAdd = "ZARA COAT 3";

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

}
