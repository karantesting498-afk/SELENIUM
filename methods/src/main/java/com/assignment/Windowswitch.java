package com.assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;
import com.window_handles.Windowswitcher;

public class Windowswitch {
	
	
	private WebDriver driver;
	private String parent ;
	


	public Windowswitch(WebDriver driver) {
		this.driver = driver;

	}
	
	public void openProject()
	{
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	public void switchToChild()
	{
		parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for(String child : windows)
		{
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
				break;
			}
		}
	}
	
	public void openNewWindow()
	{
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		switchToChild();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/h3")));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		
	}
	
	public void backToParent()
	{
		driver.switchTo().window(parent);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}
	
	
	public static void main(String[] args) {
		WebDriver driver= new EdgeDriverFactory().edgeWebDriverFactory();
		Windowswitch obj = new Windowswitch(driver);
		
		obj.openProject();
		obj.openNewWindow();
		obj.backToParent();
		
	}

}
