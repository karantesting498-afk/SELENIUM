package com.rahul_shetty_website_navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class childToParentTraverse {
	
	private WebDriver driver;

	public childToParentTraverse(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]")));
	}
	
	public void childToDirectParent()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/parent::ul")).getText());

	}
	
	public void childToGrandtParent()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/parent::ul/parent::div")).getText());

	}
	
	public void childToNNumberAboveParent()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/ancestor::div[@class='home_flight_search']")).getText());

	}
	
	public void childToAllParent()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/ancestor::*")).getText());

	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		childToParentTraverse cpt = new childToParentTraverse(driver);
		
		cpt.openProject();
		cpt.childToDirectParent();
		cpt.childToGrandtParent();
		cpt.childToNNumberAboveParent();
		cpt.childToAllParent();
	}

}
