package com.select_tool_and_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Checkbox {
	

	private WebDriver driver;

	public Checkbox(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_chk_friendsandfamily")));
	}
	
	public void selectCheckBox()
	{
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Checkbox obj = new Checkbox(driver);
		obj.openProject();
		obj.selectCheckBox();
	}

}
