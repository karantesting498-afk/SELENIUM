/*This class test is created using the data provider as json file
 */
package Personal_Web.Rahul_shetty_ECommerce_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.TestComponent;
import rahulshettyacademy.data.DataReader;
import rahulshettyacademy.pageobjects.CardDetails;
import rahulshettyacademy.pageobjects.Cart;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.OrderHistory;
import rahulshettyacademy.pageobjects.ProductCatelogue;

public class StandAloneTest6 extends TestComponent {

	String productToAdd = "ZARA COAT 3";

	@Test(dataProvider = "orderProducts", groups = "PurchaseOrder")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatelogue catelogue = landing.loginApplication(input.get("email"), input.get("password"));

		// Fetch product

		// Add to cart

		Cart cart = catelogue.addToCart(input.get("product"));

		Assert.assertTrue(cart.verifyProductInCart(input.get("product")));

		// Checkout cart and add payment card details

		CardDetails card = cart.checkOut();

		String deliveryCountry = "India";

		OrderConfirmation confirm = card.addCardDetails("1234 5678 1234 5678", "123", "Karan Bajaj", "New Coupon", "10",
				"29", "IND", deliveryCountry);

		Assert.assertTrue(confirm.orderConfirmationAssertion().equalsIgnoreCase("Thankyou for the order."));

	}

	// Verify order history

	@Test(dependsOnMethods = "submitOrder", dataProvider = "orderProducts")
	public void orderHistory(HashMap<String, String> input) {
		ProductCatelogue catelogue = landing.loginApplication(input.get("email"), input.get("password"));

		OrderHistory orderhistory = catelogue.goToOrderHistory();

		Assert.assertTrue(orderhistory.verifyOrderDisplay(input.get("product")));
		;
	}

	@DataProvider
	public Object[][] orderProducts() throws IOException {

		List<HashMap<String, String>> map = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");

		return new Object[][] { { map.get(0) }, { map.get(1) } };
	}
}
