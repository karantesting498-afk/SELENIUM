package Personal.EcommereceSeleniumProjectTests.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Personal.EcommereceSeleniumProject.POM.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\Personal\\EcommereceSeleniumProject\\resources\\GlobalData.properties");

		prop.load(fis);

		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

		if (browserName.contains("Edge")) {
			
			EdgeOptions option = new EdgeOptions();

			if(browserName.contains("headless"))
			{
				option.addArguments("--headless");
			    option.addArguments("--window-size=1366,768");


			}
			

			driver = new EdgeDriver(option);
			System.out.println("Window size: " + driver.manage().window().getSize());

		}

		else if (browserName.equals("chrome")) {

			driver = new ChromeDriver();
			ChromeOptions option = new ChromeOptions();
	        option.addArguments("--disable-save-password-bubble");
		}
		
		else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();

		}
		
		


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;

	}
	
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApp() throws IOException
	{
		
		
		driver = initializeDriver();
		
		driver.manage().deleteAllCookies();

		loginPage = new LoginPage(driver);
		loginPage.openLoginPage();
		
		return loginPage;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent =  FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);

		
			//String to hashSet
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent , new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;

}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("users.dir")+" reports "+ testCaseName + ".png");
		FileUtils.copyFile(source,file);
		
		return System.getProperty("users.dir")+" reports "+ testCaseName + ".png";
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
