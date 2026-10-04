package com.select_tool_and_dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class DynamicDropDownsWOthSameValueRepeated {
	
	private WebDriver driver;

	public DynamicDropDownsWOthSameValueRepeated(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_rbtnl_Trip_2")));
	}
	
	public void switchToMultiTrip()
	{
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MultiCityModelAlert")));

		driver.findElement(By.id("MultiCityModelAlert")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("MultiCityModelAlert")));

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
	}
	
	public void firstDeparture()
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//select banglore
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("glsctl00_mainContent_ddl_destinationStation1_CTNR")));
	}
	
	public void firstDestination()
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GAU']")));
		//select guwahati
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GAU']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation2_CTXT")));

		
	}
	
	
	public void secondDeparture()
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation2_CTNR']//a[@value='GAU']")));
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation2_CTNR']//a[@value='GAU']")).click();
		
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT")).getAttribute("value"));


		wait.until(ExpectedConditions.elementToBeClickable(By.id("glsctl00_mainContent_ddl_destinationStation2_CTNR")));


	}
	
	public void secondDestination()
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation2_CTXT")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation2_CTNR']//a[@value='BLR']")));
		//select banglore
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation2_CTNR']//a[@value='BLR']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation2_CTXT")).getAttribute("value"));


	}
	
	
	public static void main(String[] args) {
		WebDriver driver = EdgeDriverFactory.edgeWebDriverFactory();
		
		DynamicDropDownsWOthSameValueRepeated obj = new DynamicDropDownsWOthSameValueRepeated(driver);
		
		obj.openProject();
		obj.switchToMultiTrip();
		obj.firstDeparture();
		obj.firstDestination();
		
		obj.secondDeparture();
		obj.secondDestination();
	}

}
