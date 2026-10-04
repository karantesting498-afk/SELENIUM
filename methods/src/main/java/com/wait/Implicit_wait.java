package com.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Implicit_wait {
	

	static WebDriver driver;
	
	public static void webDriverFactory()
	{
		driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	public void navigate()
	{
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Sign Up")).click();
		switchTab();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("otp-login-btn")).click();
		
		
	}
	
	public void getErrorText()
	{
		String error = driver.findElement(By.id("my-error-id")).getText();
		System.out.println(error);
		
	}
	
	public void switchTab()
	{

		String parent = driver.getWindowHandle();
		
		for(String child : driver.getWindowHandles())
		{
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
			}
		}
	}
	
	public static void main(String[] args) {
		
		webDriverFactory();
		Implicit_wait iWait = new Implicit_wait();
		iWait.navigate();
		iWait.getErrorText();
	}
	

}
