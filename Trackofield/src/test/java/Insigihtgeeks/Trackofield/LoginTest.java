package Insigihtgeeks.Trackofield;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import trackofield.pom.pages.LoginPage;
import trackofiled.test_component.BaseTest;

public class LoginTest extends BaseTest {
	WebDriver driver;
	
	@Test
	public void loginTest()
	{
		driver = new ChromeDriver();
		
		driver.get("https://tfqa.trackofarm.in/?lang=en");
		driver.manage().window().maximize();
		
		LoginPage loginObj = new  LoginPage(driver);
		
		loginObj.login("ignoida", "m_karan3", "12345678");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='cardListView']/child::div[contains(@class,'mb-3')]")));
		
		
	}
	
	

}
