package com.select_tool_and_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class StaticDropdownSelectionUsingSelectClass {
	
	private WebDriver driver;

	public StaticDropdownSelectionUsingSelectClass(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_DropDownListCurrency")));
	}
	
	public void selectStaticDropDown()
	{
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		System.out.println("====");
		dropdown.selectByContainsVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());

	}
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		StaticDropdownSelectionUsingSelectClass st = new StaticDropdownSelectionUsingSelectClass(driver);
		st.openProject();
		st.selectStaticDropDown();
		
	}

}
