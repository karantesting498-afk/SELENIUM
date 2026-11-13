package Personal_Web.Rahul_shetty_ECommerce_Project;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.CardDetails;
import rahulshettyacademy.pageobjects.Cart;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.ProductCatelogue;

public class StandAloneTest2 {
	
	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-save-password-bubble");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		
		LandingPage landing = new LandingPage(driver);
		
		landing.goTo("https://rahulshettyacademy.com/client/#/auth/login");
		
		
		ProductCatelogue catelogue =	landing.loginApplication("karan@mailinator.com", "Admin@123");
		
		
		//Fetch product
		
		
		String productToAdd = "ZARA COAT 3";

		// Add to cart
		
		Cart cart = catelogue.addToCart(productToAdd);
		
		
		Assert.assertTrue(cart.verifyProductInCart(productToAdd));
		
		// Checkout cart and add payment card details
		
		CardDetails card = cart.checkOut();
		
		
		String deliveryCountry = "India";

		
		card.addCardDetails("1234 5678 1234 5678", "123", "Karan Bajaj", "New Coupon", "10", "29", "IND", deliveryCountry);
		
		
		OrderConfirmation confirm = new OrderConfirmation(driver);
		
		Assert.assertTrue(confirm.orderConfirmationAssertion().equalsIgnoreCase("Thankyou for the order."));
		
	}

}
