package com.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.webdrivers.EdgeDriverFactory;

public class Fluentwait {
	
	private WebDriver driver;
	
	
	public Fluentwait(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	}
	
	public void start()
	{
		driver.findElement(By.xpath("//div[@id='start']//button")).click();
		
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement el = wait.until(driver -> { WebElement ele = driver.findElement(By.xpath("//div[@id='finish']//h4"));
		return ele.isDisplayed() ? ele : null;
		}); 
		System.out.println(el.getText());
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		Fluentwait obj = new Fluentwait(driver);
		obj.openProject();
		obj.start();
	}

}
