package Personal.EcommereceSeleniumProjectTests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	public static void main(String[] args) {

		// Invoke webDriver
		WebDriver driver = new EdgeDriver();


		// Open the website
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();

		// WAit
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login']")));

		// Login Cred input

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("karan@mailinator.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-body']")));

		// Get ALl Product List

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
		System.out.println(products.size());

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
		

		List<WebElement> zara = products.stream()
				.filter(d -> d.findElement(By.xpath(".//h5/b")).getText().contains("ZARA COAT"))
				.collect(Collectors.toList());
		zara.stream().findFirst().ifPresent(d -> {

			WebElement add = d.findElement(By.xpath(".//button[contains(text(),'Add To Cart')]"));
			wait.until(ExpectedConditions.elementToBeClickable(add));
			add.click();
			System.out.println("Added");
		});
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));

		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cart']//ul")));
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart']//ul"));
		
		boolean inCart = cartItems.stream().anyMatch(d-> d.findElement(By.xpath(".//h3")).getText().contains("ZARA COAT"));
		
		System.out.println(inCart);		

		driver.findElement(By.xpath("//div[contains(@class,'subtotal cf ng-star-inserted')]//button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'payment__type payment__type--cc active')]")));
		
		driver.findElement(By.xpath("//input[contains(@class,'input txt text-validated')]")).sendKeys("1234 5678 9876 5432");
		driver.findElement(By.xpath("//div[contains(text(),'CVV Code')]/following-sibling::input[contains(@class,'input txt')]")).sendKeys("123");
		
		WebElement  expiryMonth= driver.findElement(By.xpath("//div[contains(@class,'field small')]//select[contains(@class,'input ddl')][1]"));
		WebElement  expiryDate = driver.findElement(By.xpath("//div[contains(@class,'field small')]//select[contains(@class,'input ddl')][2]"));
		
		Select dateDD = new Select(expiryDate);
		dateDD.selectByContainsVisibleText("29");
		
		Select monthDD = new Select(expiryMonth);
		dateDD.selectByContainsVisibleText("10");
		
		driver.findElement(By.xpath("//div[contains(text(),'Name on Card')]/following-sibling::input[contains(@class,'input txt')]")).sendKeys("Karan Bajaj");
		driver.findElement(By.xpath("//input[contains(@name,'coupon')]")).sendKeys("Coupon");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Apply Coupon')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Apply Coupon')]")).click();
		System.out.println("Coupon added");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'field small')]//p[contains(@class,'mt-1 ng-star-inserted')]")));

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'Select Country')]")));
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Select Country')]")).sendKeys("Ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results list-group ng-star-inserted')]")));
		
		List<WebElement> countries = driver.findElements(By.xpath("//section[contains(@class,'ta-results list-group ng-star-inserted')]//button"));
		
		System.out.println(countries.size());
		
		countries.stream().filter(d-> d.findElement(By.xpath(".//span")).getText().equalsIgnoreCase("India")).findFirst().ifPresent(d->d.click());

		driver.findElement(By.xpath("//div[contains(@class,'actions')]//a[contains(@class,'btnn action__submit ng-star-inserted')]")).click();
		
	}
}
