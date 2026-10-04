package com.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.webdrivers.EdgeDriverFactory;

public class Tablegridhandling {

	private WebDriver driver;

	public Tablegridhandling(WebDriver driver) {
		this.driver = driver;
	}

	public void openProject() {
		int sum = 0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));

		System.out.println("Rows are :" + rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']//tr[1]//th"));

		System.out.println("columns are :" + columns.size());

		System.out.println("2nd Row");
		
		List<WebElement> secondRow = rows.get(2).findElements(By.xpath("//td"));
		
		System.out.println("Instructor are : "+ secondRow.get(0).getText());
		System.out.println("Courses are : "+ secondRow.get(1).getText());
		System.out.println("price are : "+ secondRow.get(2).getText());


		
		
	}
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Tablegridhandling obj = new Tablegridhandling(driver);
		obj.openProject();
	}

}
