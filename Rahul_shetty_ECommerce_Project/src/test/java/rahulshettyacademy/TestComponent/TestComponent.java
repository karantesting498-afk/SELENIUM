package rahulshettyacademy.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pageobjects.LandingPage;

public class TestComponent {
	public WebDriver driver;
	
	
	

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public LandingPage getLanding() {
		return landing;
	}

	public LandingPage landing ;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Selenium\\SELENIUM\\Rahul_shetty_ECommerce_Project\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		
		FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		
		// Since above property name is too long, then we can remove local project name and replace it with System.getProperty("user.dir");
		properties.load(fis2);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):  properties.getProperty("browser");
//		String browserName = properties.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{

			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<String, Object>();

			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-save-password-bubble");
			if(browserName.contains("headless"))
			{
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1440,900");
				
			}

			 driver = new ChromeDriver(options);
			
			
		}
		
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		
		if(!browserName.contains("headless"))
		{
			driver.manage().window().maximize();
		}
		
		return driver;

	}
	
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launch() throws IOException
	{
		driver= initializeDriver();
		
		landing = new LandingPage(driver);
		
		landing.goTo("https://rahulshettyacademy.com/client/#/auth/login");
		
		return landing;
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		 System.out.println("========== AFTER METHOD STARTED ==========");

		    if (driver != null) {

		        System.out.println("Driver is not null. Closing browser.");

		        driver.quit();
		        driver = null;

		        System.out.println("Browser closed successfully.");
		    }
		    else {
		        System.out.println("Driver is already null.");
		    }

		    System.out.println("========== AFTER METHOD COMPLETED ==========");
	}
	
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException
	{
		// Read json to string
		String json =FileUtils.readFileToString(new File(filePath),  StandardCharsets.UTF_8);
	
		// String to hashMap; we have to use jackson data bind
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data=mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;
		
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		this.driver = driver;
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+ "//reports//"+ testCaseName + " "+ System.nanoTime()+".png";
		
		Files.copy(file.toPath(), Path.of(path));
		
		return path;
		
	}

	
}
