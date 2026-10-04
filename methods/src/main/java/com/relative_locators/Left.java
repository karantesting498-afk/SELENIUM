package com.relative_locators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdrivers.EdgeDriverFactory;

public class Left {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement checkBox = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));

		driver.findElement(with(By.xpath("//input[@id='exampleCheck1']")).toLeftOf(checkBox)).click();
	}

}
