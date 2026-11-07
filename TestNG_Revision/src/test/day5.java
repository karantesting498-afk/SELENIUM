
package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class day5 {
	
	WebDriver driver;
	
	@Parameters({"Browser", "username"})
	@Test
	public void setup(String name, String name2)
	{
		driver = name.equalsIgnoreCase("Chrome")? new ChromeDriver() : name.equalsIgnoreCase("FireFox")? new FirefoxDriver(): null;
		
		if(driver==null)
		{
			throw new IllegalArgumentException("Driver found null, Invalid name");
		}
		
		System.out.println(name2);
		driver.get("https://tfqa.trackofarm.in");
		
		driver.quit();
		
		
	}

}
