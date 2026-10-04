package com.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdrivers.EdgeDriverFactory;

public class Framesbasics {
	
	private WebDriver driver;
	private String parent ;
	


	public Framesbasics(WebDriver driver) {
		this.driver = driver;

	}
	
	public void openProject()
	{
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		a.dragAndDrop(source, target).perform();
	}
	

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		Framesbasics obj = new Framesbasics(driver);
		obj.openProject();
	
	}

}
