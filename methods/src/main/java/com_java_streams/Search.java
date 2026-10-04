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

public class Search {
	
	private WebDriver driver;

	public Search(WebDriver driver) {
		this.driver = driver;
	}

	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void openProject() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		clickableWait(By.xpath("//input[@id='search-field']"));

		fetchPriceOperation();
	}
	
	public void fetchPriceOperation()
	{
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Be");
		
		clickableWait(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		List<String> price  =ele.stream().filter(i->i.getText().contains("Strawberry")).map(i->getPrice(i)).collect(Collectors.toList());
		price.stream().forEach(i->System.out.println(i));
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

		Search obj = new Search(driver);
		obj.openProject();
	}

}
