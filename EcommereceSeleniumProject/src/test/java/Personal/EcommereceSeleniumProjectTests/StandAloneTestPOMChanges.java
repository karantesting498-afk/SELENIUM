package Personal.EcommereceSeleniumProjectTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Personal.EcommereceSeleniumProject.POM.CartPage;
import Personal.EcommereceSeleniumProject.POM.OrderPage;
import Personal.EcommereceSeleniumProject.POM.PaymentPage;
import Personal.EcommereceSeleniumProject.POM.ProductCatelog;
import Personal.EcommereceSeleniumProject.data.jsonDatReader;
import Personal.EcommereceSeleniumProjectTests.TestComponents.BaseTest;

public class StandAloneTestPOMChanges extends BaseTest {

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(String email, String password, String productName) throws IOException {

		ProductCatelog product = loginPage.login(email, password);

		// Get ALl Product List

		List<WebElement> products = product.getProductList();

//		for (int i = 0; i < products.size(); i++) {
//			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-body']")));
//
//			List<WebElement> freshProducts = driver.findElements(By.xpath("//div[@class='card-body']"));
//
//			String text = freshProducts.get(i).findElement(By.xpath(".//b")).getText();
//
//			
//			if(text.contains("ZARA COAT"))
//			{
//				
//				freshProducts.get(i).findElement(By.xpath(".//button[contains(text(),'Add To Cart')]")).click();
//
//				System.out.println(text);
//
//			}
//
//		}

		// using streams

		product.addToCart(productName);

		CartPage cartPage = product.gotoCart();

		List<WebElement> cartItems = cartPage.getCartItems();

		boolean inCart = cartPage.verifyProductAdded(productName);

//		assertTrue(inCart);

		PaymentPage payment = cartPage.checkOut();

		payment.inputCardDetails("1234 5678 7890 9876", "345", "29", "10", "Karan Bajaj", "Coupon");

		payment.selectDeliveryCountry("India");
		payment.placeOrderToCountry();

	}

	@Test(dataProvider = "getData2", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatelog product = loginPage.login(input.get("email"), input.get("password"));

		List<WebElement> products = product.getProductList();

		// using streams

		product.addToCart(input.get("product"));

		CartPage cartPage = product.gotoCart();

		List<WebElement> cartItems = cartPage.getCartItems();

		boolean inCart = cartPage.verifyProductAdded(input.get("product"));

//		assertTrue(inCart);

		PaymentPage payment = cartPage.checkOut();

		payment.inputCardDetails("1234 5678 7890 9876", "345", "29", "10", "Karan Bajaj", "Coupon");

		payment.selectDeliveryCountry("India");
		payment.placeOrderToCountry();

	}
	
	@Test(dataProvider = "getData3", groups = "Purchase")
	public void submitOrder1(HashMap<String, String> input) throws IOException {

		ProductCatelog product = loginPage.login(input.get("email"), input.get("password"));

		List<WebElement> products = product.getProductList();

		// using streams

		product.addToCart(input.get("product"));

		CartPage cartPage = product.gotoCart();

		List<WebElement> cartItems = cartPage.getCartItems();

		boolean inCart = cartPage.verifyProductAdded(input.get("product"));

//		assertTrue(inCart);

		PaymentPage payment = cartPage.checkOut();

		payment.inputCardDetails("1234 5678 7890 9876", "345", "29", "10", "Karan Bajaj", "Coupon");

		payment.selectDeliveryCountry("India");
		payment.placeOrderToCountry();

	}

	@Test(dependsOnMethods = "submitOrder")
	public void orderVerification() {
		ProductCatelog product = loginPage.login("karan@mailinator.com", "Admin@123");

		OrderPage orderPage = product.goToOrder();

		Assert.assertTrue(orderPage.matchOrderProduct("ZARA COAT"));
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "karan@mailinator.com", "Admin@123", "ZARA COAT" },
				{ "karan@mailinator.com", "Admin@123", "ADIDAS" } };
	}

	// Using hashSet

	@DataProvider
	public Object[][] getData2() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "karan@mailinator.com");
		map.put("password", "Admin@123");
		map.put("product", "ZARA COAT");

		return new Object[][] {{map}};
	}
	
	//JSON 
	@DataProvider
	public Object[][] getData3() throws IOException {
		
	List<HashMap<String, String>>	map  = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\Personal\\EcommereceSeleniumProject\\data\\PurchaseOrder.json");

		return new Object[][] {{map.get(0)}, {map.get(1)}};
	}
	

}
