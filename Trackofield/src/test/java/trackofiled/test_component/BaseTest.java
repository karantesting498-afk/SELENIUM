package trackofiled.test_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	
	public WebDriver initializeDriver()
	{
		driver= new ChromeDriver();
		
		return driver;
	}
	
	public void setUp()
	{
		driver = initializeDriver();
		
		driver.get("https://tfqa.trackofarm.in/?lang=en");
		
	}

}
