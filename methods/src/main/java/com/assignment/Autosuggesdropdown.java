package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Autosuggesdropdown {
	
	private WebDriver driver;

	public Autosuggesdropdown(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickableWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void openProject() {
		int sum = 0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement dd = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		dd.click();
		dd.sendKeys("ind");
		
		clickableWait(By.xpath("//ul[@id='ui-id-1']"));
		
		List<WebElement> countires = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		System.out.println(countires.size());
		
		Actions a = new Actions(driver);
		
		for(WebElement c: countires)
		{
			String text = c.getText();
			
			if(text.equals("India"))
			{
				
				
//				c.click();
				break;
			}
			
		}
		
		System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value"));
		


		
		
	}
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Autosuggesdropdown obj = new Autosuggesdropdown(driver);
		obj.openProject();
	}

}
