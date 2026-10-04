package com_api_status_code_handling;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.webdrivers.EdgeDriverFactory;

public class BrokenLinkHandling {
	
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		System.out.println("   GIT");
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert sa = new SoftAssert();
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection con = (HttpURLConnection) new URI(url).toURL().openConnection();

			
//			con.setRequestMethod("Head");
			con.connect();
			
			sa.assertTrue(con.getResponseCode()<300, url);
		}
		
		sa.assertAll();//TO check if any failure exist. if failure exist then script fail
		
	}
	

}
