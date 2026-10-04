package com.manage;

import org.openqa.selenium.WebDriver;

import com.webdrivers.EdgeDriverFactory;

public class Cookiemanager {
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("login session");
		//Tap on any link
		// user should be redirected to login or homepage
		
		
		
	}

}
