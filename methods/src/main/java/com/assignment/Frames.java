package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdrivers.EdgeDriverFactory;

/*
 * currently page is not opening - 
 * An error occurred in the application and your page could not be served.
 *  If you are the application owner, check your logs for details. 
 *  You can do this from the Heroku CLI with the command
heroku logs --tail

haven't verified code but i am sure it will work
 */

public class Frames {

	
	private WebDriver driver;
	private String parent ;
	


	public Frames(WebDriver driver) {
		this.driver = driver;

	}
	
	public void openProject()
	{
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Frames obj = new Frames(driver);
		obj.openProject();
	}
}
