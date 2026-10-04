package com.generics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Addcucumbertocart {

	private WebDriver driver;

	public Addcucumbertocart(WebDriver driver) {
		this.driver = driver;
	}

	public void openProject() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	public void waitMehtod(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitMehtod(WebElement product) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement isClicable = product
				.findElement(By.xpath("./ancestor::div[1]//button"));

		wait.until(ExpectedConditions.textToBePresentInElement(isClicable, "ADD TO CART"));
	}

	public void waitToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public void openCartList() {
		waitMehtod(By.xpath("//a[@class='cart-icon']"));

		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		waitToBeVisible(By.xpath("//div[contains(@class,'cart-preview')]"));

		driver.findElement(By.xpath("//div[@class='action-block']//button[contains(text(),'PROCEED TO CHECKOUT')]"))
				.click();
		
		waitMehtod(By.xpath("//input[@class='promoCode']"));
	}

	public void inputPromo()
	{
		String promomsg;
		WebElement promo = driver.findElement(By.xpath("//input[@class='promoCode']"));
		promo.sendKeys("rahulsheetyacademy2");
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		waitToBeVisible(By.xpath("//span[@class='promoInfo']"));
		promomsg = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();

		if(promomsg.equalsIgnoreCase("Invalid code ..!"))
		{
			System.out.println(promomsg);
			
			driver.findElement(By.xpath("//input[@class='promoCode']")).clear();
			promo.sendKeys("rahulshettyacademy");
			
			driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='promoInfo']"), "Code applied ..!"));

			System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

		}
		
		
	}
	public List<WebElement> getAllProducts() {
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		System.out.println(products.size());

		return products;
	}

	public boolean checkCartCount(int items) {
		waitMehtod(By.xpath("//div[@class='cart-info']//td[text()='Items']/following-sibling::td[2]/strong"));

		String count = driver
				.findElement(By.xpath("//div[@class='cart-info']//td[text()='Items']/following-sibling::td[2]/strong"))
				.getText().trim();
		int cartCount = Integer.parseInt(count);

		if (cartCount == items) {
			System.out.println(cartCount);
			return true;
		}

		else {

			return false;
		}
	}

	// for single product
	public void addToCart(String productName) {

		List<WebElement> products = getAllProducts();

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			if (name.contains(productName)) {
				System.out.println("Product do exist");

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				waitMehtod(products.get(i));

				break;
			}
		}

	}

	// for list of products
	public void addListOfProductsToCart(List<String> productNames) {
		List<WebElement> products = getAllProducts();

//		waitToBeVisible(By.xpath("./ancestor::div[1]//button[contains(text(),'ADD TO CART')]"));

		for (WebElement product : products) {
			String name = product.getText();
			String formattedName = name.split("-")[0].trim();

			if (productNames.contains(formattedName)) {
				product.findElement(By.xpath("./ancestor::div[1]//button[contains(text(),'ADD TO CART')]")).click();
				waitMehtod(product);
				if (checkCartCount(productNames.size())) {
					System.out.println("method is used");
					break;
				}
			}
		}
	}

	public void arrayListsss() {
		String[] itemsNeeded = { "Tomato", "Beans" };
		List<WebElement> products = getAllProducts();

//		waitToBeVisible(By.xpath("./ancestor::div[1]//button[contains(text(),'ADD TO CART')]"));

		List<String> items = Arrays.asList(itemsNeeded);

		String currentCartCount = driver
				.findElement(By.xpath("//div[@class='cart-info']//td[text()='Items']/following-sibling::td[2]/strong"))
				.getText();

		int count = Integer.parseInt(currentCartCount);

		for (WebElement product : products) {
			String name = product.getText().split("-")[0].trim();
			if (items.contains(name)) {
				product.findElement(By.xpath("./ancestor::div[1]//button[contains(text(),'ADD TO CART')]")).click();
				waitMehtod(product);

				if (checkCartCount(items.size() + count)) {
					System.out.println("method is used");
					break;
				}
			}
		}

	}

	public static void main(String[] args) {

		WebDriver driver = EdgeDriverFactory.edgeWebDriverFactory();
		Addcucumbertocart obj = new Addcucumbertocart(driver);
		obj.openProject();
		obj.addToCart("Cucumber");

		List<String> productToAdd = new ArrayList<String>();
		productToAdd.add("Cucumber");
		productToAdd.add("Beetroot");
		productToAdd.add("Carrot");
		obj.checkCartCount(productToAdd.size());
		obj.addListOfProductsToCart(productToAdd);
		obj.arrayListsss();
		obj.openCartList();
		obj.inputPromo();
	}

}
