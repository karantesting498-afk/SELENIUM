package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Scroll {
	
	private WebDriver driver;

	public Scroll(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		driver.manage().window().maximize();
		
		js.executeScript("window.scrollBy(0,500)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		js.executeScript("document.querySelector(\"div[class='tableFixHead']\").scrollTop=5000");
		
		
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Scroll obj = new Scroll(driver);
		obj.openProject();
	}
	

}
