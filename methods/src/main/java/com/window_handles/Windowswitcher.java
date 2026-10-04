package com.window_handles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Windowswitcher {

	
	private WebDriver driver;
	private String parent ;
	


	public Windowswitcher(WebDriver driver) {
		this.driver = driver;

	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
	}
	
	public void switchWindow()
	{
		parent = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window : allWindows)
		{
			if(!window.equals(parent))
			{
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	public void switchBackToParent()
	{
		driver.switchTo().window(parent);
	}
	public void readText()
	{
		switchWindow();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='im-para red']")));
		
		String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at ")[1].split(" with")[0].trim();
		System.out.println(text);
		switchBackToParent();
		
	}
	
	public static void main(String[] args) {
		WebDriver driver= new EdgeDriverFactory().edgeWebDriverFactory();
		Windowswitcher obj = new Windowswitcher(driver);
		
		obj.openProject();
		obj.readText();
	}
	
}
