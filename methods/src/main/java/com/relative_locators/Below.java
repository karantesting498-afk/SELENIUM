package com.relative_locators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdrivers.EdgeDriverFactory;

public class Below {
	
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));

		String label = driver.findElement(with(By.tagName("label")).above(name)).getText();
		System.out.println(label);
	}


}
