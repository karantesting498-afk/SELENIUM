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

public class FetchPrice {
	
	private WebDriver driver;

	public FetchPrice(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		clickableWait(By.xpath("//tr//th[1]"));
		
		fetchPriceOperation();
	}
	
	public String getPrice(WebElement s)
	{		
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

	public String getDiscountedPrice(WebElement s)
	{
		
		String price = s.findElement(By.xpath("following-sibling::td[2]")).getText();
		return price;
	}
	
	public void fetchPriceOperation()
	{
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='table table-bordered']//tbody//tr//td[1]"));
		ele.stream().filter(s->s.getText().contains("Rice")).map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()).forEach(s->System.out.println(s));
		System.out.println("Get price");
		List<String> ricePrice = ele.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		ricePrice.stream().forEach(i->System.out.println(i));
		
		System.out.println("Get Discount price");
		List<String> riceDPrice = ele.stream().filter(s->s.getText().contains("Rice")).map(s->getDiscountedPrice(s)).collect(Collectors.toList());
		riceDPrice.stream().forEach(i->System.out.println(i));
		
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		FetchPrice obj = new FetchPrice(driver);
		obj.openProject();
	}

}
