package com_screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.webdrivers.EdgeDriverFactory;

public class Screenshot {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		driver.get("https://rahulshettyacademy.com/practice");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\karan\\screenshot.png"));
	}



}
