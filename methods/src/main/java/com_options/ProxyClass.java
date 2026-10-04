package com_options;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.webdrivers.EdgeDriverFactory;

public class ProxyClass {
	
	private WebDriver driver;

	public ProxyClass(WebDriver driver) {
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
		
		Proxy p = new  Proxy();
		p.setHttpProxy("ipaddress:4444");
		
		options.setCapability("proxy", p);
		
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));//block disbale allow location poups;
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory","/directory/path");// default downlaod is set to download files in directory/path folder
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory(options);
		
		ProxyClass obj = new ProxyClass(driver);
		obj.openProject();
	}
	


}
