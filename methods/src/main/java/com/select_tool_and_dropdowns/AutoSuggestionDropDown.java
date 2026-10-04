package com.select_tool_and_dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class AutoSuggestionDropDown {

	private WebDriver driver;

	public AutoSuggestionDropDown(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autosuggest")));
	}
	
	public void selectOption(String txt)
	{
		driver.findElement(By.id("autosuggest")).sendKeys(txt);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
		
//		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		
		List<WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));

		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				System.out.println(option.getText());

				option.click();
				break;
			}
		}
		

	}
	
	public static void main(String[] args) {
		
		WebDriver driver = EdgeDriverFactory.edgeWebDriverFactory();
		
		AutoSuggestionDropDown obj = new AutoSuggestionDropDown(driver);
		
		obj.openProject();
		obj.selectOption("in");
	}
}
