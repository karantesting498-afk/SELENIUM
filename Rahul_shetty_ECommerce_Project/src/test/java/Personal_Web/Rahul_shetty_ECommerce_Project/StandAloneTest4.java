/*This class test is created using the data provider
 */
package Personal_Web.Rahul_shetty_ECommerce_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.TestComponent;
import rahulshettyacademy.pageobjects.CardDetails;
import rahulshettyacademy.pageobjects.Cart;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.OrderHistory;
import rahulshettyacademy.pageobjects.ProductCatelogue;

public class StandAloneTest4 extends TestComponent {

	String productToAdd = "ZARA COAT 3";
	@Test(dataProvider = "orderProducts", groups ="PurchaseOrder")
	public void submitOrder(String email, String password, String product) throws IOException {


		ProductCatelogue catelogue = landing.loginApplication(email, password);

		// Fetch product



		// Add to cart

		Cart cart = catelogue.addToCart(product);

		Assert.assertTrue(cart.verifyProductInCart(product));

		// Checkout cart and add payment card details

		CardDetails card = cart.checkOut();

		String deliveryCountry = "India";

		OrderConfirmation confirm = card.addCardDetails("1234 5678 1234 5678", "123", "Karan Bajaj", "New Coupon", "10",
				"29", "IND", deliveryCountry);

		Assert.assertTrue(confirm.orderConfirmationAssertion().equalsIgnoreCase("Thankyou for the order."));

	}

	
	// Verify order history
	
	@Test(dependsOnMethods = "submitOrder", dataProvider = "orderProducts")
	public void orderHistory(String email, String password, String product)
	{
		ProductCatelogue catelogue = landing.loginApplication(email, password);

		OrderHistory orderhistory =catelogue.goToOrderHistory();
		
		Assert.assertTrue(orderhistory.verifyOrderDisplay(product));;
	}
	
	@DataProvider
	public Object[][] orderProducts()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "karan@mailinator.com";
		obj[0][1]= "Admin@123";
		obj[0][2]="ZARA COAT 3";
		obj[1][0] ="karan2@mailinator.com";
		obj[1][1] ="Admin@123";
		obj[1][2]="ADIDAS ORIGINAL";

		
		return obj;
	}
}
