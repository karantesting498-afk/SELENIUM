package trackofiled.test_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import trackofield.pom.pages.DashboardPage;
import trackofield.pom.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver initializeDriver()
	{
		driver= new ChromeDriver();
		
		return driver;
	}
	
	public DashboardPage loginToApp()
	{
		LoginPage obj = new LoginPage(driver);
		DashboardPage dashboard =obj.login("ignoida", "m_karan3", "12345678");
		return dashboard;
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver = initializeDriver();
		
		driver.get("https://tfqa.trackofarm.in/?lang=en");
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}

}
