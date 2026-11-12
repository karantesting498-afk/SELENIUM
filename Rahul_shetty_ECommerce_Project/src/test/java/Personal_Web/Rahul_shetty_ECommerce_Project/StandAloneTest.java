package Personal_Web.Rahul_shetty_ECommerce_Project;

import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {

		String productToAdd = "ZARA COAT 3";
		String deliveryCountry = "India";
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-save-password-bubble");

		WebDriver driver = new ChromeDriver(options);

		// Login
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");

		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement pass = driver.findElement(By.id("userPassword"));
		WebElement loginButton = driver.findElement(By.id("login"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(email));

		email.sendKeys("karan@mailinator.com");

		wait.until(ExpectedConditions.visibilityOf(pass));

		pass.sendKeys("Admin@123");

		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

		loginButton.click();

		// Fetch product List

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section[@id='products']/descendant::div[@class='card']")));

		List<WebElement> products = driver.findElements(
				By.xpath("//section[@id='products']/descendant::div[@class='card']/child::div[@class='card-body']"));

		System.out.println("product list size:" + products.size());

		WebElement productSelected = products.stream()

				.filter(s -> s.findElement(By.xpath(".//h5")).getText().equalsIgnoreCase(productToAdd)).findFirst()

				.orElse(null);

		// Add to cart the product.

		int add = 0;
		if (productSelected != null) {

			WebElement addToCart = productSelected.findElement(By.xpath(".//button[normalize-space(.)='Add To Cart']"));

			wait.until(ExpectedConditions.elementToBeClickable(addToCart));

			addToCart.click();

			add++;
		} else {
			System.out.println("Product Not Found");
		}

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted')]")));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='toast-container']")));

		System.out.println(driver.findElement(By.xpath("//div[@id='toast-container']")).getText());

		// Check cart count;

		String productCount = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']/child::label"))
				.getText();

		int CurrentProductCount = Integer.parseInt(productCount);

		if (CurrentProductCount == add) {
			System.out.println("Product  added");
			System.out.println("Current cart count is : " + CurrentProductCount);

			driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		} else {
			System.out.println("Product not added");
		}

		// Fetch Cart products

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cart']/child::ul[1]")));
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']/child::ul"));

//		System.out.println("cart size  "+cartProducts.size());
//		
//		cartProducts.stream().map(s->s.getText()).forEach(System.out::println);

		// Check whether Product added or not

		Boolean match = cartProducts.stream()
				.anyMatch(s -> s.findElement(By.xpath(".//h3")).getText().equalsIgnoreCase(productToAdd));

		Assert.assertTrue(match);

		// Checkout

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(.)='Checkout']")));

		driver.findElement(By.xpath("//button[normalize-space(.)='Checkout']")).click();

		// Card Details

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[@class='title' and normalize-space(.)='Credit Card Number']/following-sibling::input")));

		WebElement cardNumber = driver.findElement(
				By.xpath("//div[@class='title' and normalize-space(.)='Credit Card Number']/following-sibling::input"));
		WebElement cvvCode = driver.findElement(
				By.xpath("//div[@class='title' and contains(text(),'CVV Code')]/following-sibling::input"));
		WebElement nameOnCard = driver.findElement(
				By.xpath("//div[@class='title' and normalize-space(.)='Name on Card']/following-sibling::input"));
		WebElement couponCode = driver.findElement(
				By.xpath("//div[@class='title' and normalize-space(.)='Apply Coupon']/following-sibling::input"));
		
		WebElement applyCoupon = driver.findElement(By.xpath("//button[@type='submit' and normalize-space(.)='Apply Coupon']"));
		
		WebElement placeOrder = driver.findElement(By.xpath("//a[contains(@class,'action__submit')]"));

		WebElement expiryMonth = driver.findElement(
				By.xpath("//div[@class='title' and normalize-space(.)='Expiry Date']/following-sibling::select[1]"));
		Select select = new Select(expiryMonth);
		expiryMonth.click();
		select.selectByVisibleText("10");

		WebElement expiryDate = driver.findElement(
				By.xpath("//div[@class='title' and normalize-space(.)='Expiry Date']/following-sibling::select[2]"));
		Select select2 = new Select(expiryDate);
		expiryDate.click();
		
		select2.selectByVisibleText("29");

		cardNumber.clear();
		cardNumber.sendKeys("1234 5678 1234 5678");
		cvvCode.sendKeys("123");
		nameOnCard.sendKeys("Karan Bajaj");
		couponCode.sendKeys("New Coupon");
		
		
//		System.out.println(applyCoupon.isEnabled());
//		wait.until(ExpectedConditions.elementToBeClickable(applyCoupon));
		
//		driver.findElement(By.xpath("//button[@type='submit' and normalize-space(.)='Apply Coupon']")).click();
		
//		wait.until(ExpectedConditions
//				.invisibilityOfElementLocated(By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted')]")));
		
		
		// Select Country;
		
		WebElement countryText = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		countryText.sendKeys("Ind");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[contains(@class,'ta-results')]")));
		
		
		List<WebElement> suggestions = countryText.findElements(By.xpath("./following-sibling::section[contains(@class,'ta-results')]/descendant::button"));
		for (WebElement webElement : suggestions) {
			
			if(webElement.findElement(By.xpath(".//span")).getText().equalsIgnoreCase(deliveryCountry))
			{
				webElement.click();
				break;
			}
			
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		placeOrder.click();
		
		// Verify order placed?
		
		By orderMessage = By.xpath("//h1[contains(@class,'hero-primary')]");

		wait.until(ExpectedConditions.visibilityOfElementLocated(orderMessage));

		String orderPlaced = driver.findElement(orderMessage).getText();

		System.out.println("Order confirmation: " + orderPlaced);

		Assert.assertTrue(orderPlaced.trim().equalsIgnoreCase("Thankyou for the order."));
		
	}

}
