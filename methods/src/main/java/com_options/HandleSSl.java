package com_options;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;

import com.assignment.Tablegridhandling;
import com.webdrivers.EdgeDriverFactory;

public class HandleSSl {

	private WebDriver driver;

	public HandleSSl(WebDriver driver) {
		this.driver = driver;
	}

	public void openProject() {
		int sum = 0;

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

	public static void main(String[] args) {

		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory(options);
		HandleSSl obj = new HandleSSl(driver);


		obj.openProject();
	}

}
