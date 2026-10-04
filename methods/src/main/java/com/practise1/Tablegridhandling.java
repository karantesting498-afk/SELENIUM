package com.practise1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.Scroll;
import com.webdrivers.EdgeDriverFactory;

public class Tablegridhandling {
	
	private WebDriver driver;

	public Tablegridhandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		int sum =0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		
		for(WebElement am : amounts)
		{
			int amount = Integer.parseInt(am.getText());
			sum = sum+amount;
			System.out.println(sum);
		}
		
		String displayAmount = driver.findElement(By.xpath("//div[@class='tableFixHead']/following-sibling::div[@class='totalAmount']")).getText().split(":")[1].trim();

		Assert.assertFalse(sum==Integer.valueOf(displayAmount),"True");
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Tablegridhandling obj = new Tablegridhandling(driver);
		obj.openProject();
	}
	
	

}


