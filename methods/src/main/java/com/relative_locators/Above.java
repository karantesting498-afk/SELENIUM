package com.relative_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdrivers.EdgeDriverFactory;


import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class Above {

	public static void main(String[] args) {
		
		WebDriver driver = new  EdgeDriverFactory().edgeWebDriverFactory();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement dobLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		
		driver.findElement(with(By.xpath("//input[@name='bday']")).below(dobLabel)).sendKeys("10/29/1999");
		
		String label =  driver.findElement(with(By.xpath("//input[@name='bday']")).below(dobLabel)).getAttribute("value");
		System.out.println(label);
	}
}
