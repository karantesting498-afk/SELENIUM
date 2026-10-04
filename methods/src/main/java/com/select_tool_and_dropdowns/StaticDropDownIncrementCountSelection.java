package com.select_tool_and_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class StaticDropDownIncrementCountSelection {
	
	private WebDriver driver;

	public StaticDropDownIncrementCountSelection(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxinfo")));
	}
	
	public void addCount(int noOfA , int noOfC , int noOfI)
	{
		
		
		
		WebElement countDropDown = driver.findElement(By.id("divpaxinfo"));
		countDropDown.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		//Increment adult count
		for(int i =0; i<noOfA; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		//Increment child count

		for(int i =0; i<noOfC; i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		//Increment infant count

		for(int i =0; i<noOfI; i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		StaticDropDownIncrementCountSelection obj = new StaticDropDownIncrementCountSelection(driver);
		obj.openProject();
		obj.addCount(2, 3, 4);
	}

}
