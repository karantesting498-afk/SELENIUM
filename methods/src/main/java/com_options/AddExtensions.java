package com_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.webdrivers.EdgeDriverFactory;

public class AddExtensions {
	private WebDriver driver;

	public AddExtensions(WebDriver driver) {
		this.driver = driver;
	}

	public void openProject() {
		int sum = 0;

		driver.get("https://expired.badssl.com/");

		
	}

	public static void main(String[] args) {

		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);//SSL
		options.addExtensions();// add extension
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory(options);
		
		AddExtensions obj = new AddExtensions(driver);

		
		
		obj.openProject();
	}
	


}
