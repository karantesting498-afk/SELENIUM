package com.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
public class EdgeDriverFactory {

	public static WebDriver edgeWebDriverFactory()
	{
		return new EdgeDriver();
	}
	
	public static WebDriver edgeWebDriverFactory(EdgeOptions options)
	{
		return new EdgeDriver(options);
	} 
}
