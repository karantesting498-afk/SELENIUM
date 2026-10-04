package com_java_streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Pagination {

	private WebDriver driver;

	public Pagination(WebDriver driver) {
		this.driver = driver;
	}

	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void openProject() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		clickableWait(By.xpath("//tr//td[1]"));

		fetchPriceOperation();
	}

	public void fetchPriceOperation() {
		do {
			List<WebElement> ele = driver
					.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
			
			List<String> priceOfBean = ele.stream().filter(i -> i.getText().contains("Bean")).map(i -> getPrice(i))
					.collect(Collectors.toList());

			List<String> dPriceOfBeans = ele.stream().filter(i -> i.getText().contains("Bean")).map(i -> getDPrice(i))
					.collect(Collectors.toList());

			if (!dPriceOfBeans.isEmpty() && !priceOfBean.isEmpty()) {
				System.out.println("Price of Beans are :		 ");
				priceOfBean.stream().forEach(i -> System.out.print(i));

				System.out.println("Discounted Price of Beans are :		 ");
				dPriceOfBeans.stream().forEach(i -> System.out.print(i));

			}
			
			if(driver.findElement(By.xpath("//ul[contains(@class,'pagination pull-right')]//a[contains(@aria-label,'Next')]"))
					.getAttribute("aria-disabled").equals("true")) {
				break;
			}
			driver.findElement(By.xpath(
					"//ul[contains(@class,'pagination pull-right')]//a[contains(@aria-label,'Next')]"))
					.click();

			clickableWait(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		} while (true);

	}

	public String getPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

	public String getDPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[2]")).getText();
		return price;
	}

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		Pagination obj = new Pagination(driver);
		obj.openProject();
	}
}
