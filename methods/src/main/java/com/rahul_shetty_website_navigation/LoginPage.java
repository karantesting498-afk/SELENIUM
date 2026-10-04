package com.rahul_shetty_website_navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.BrowserUtils;
import com.webdrivers.EdgeDriverFactory;

public class LoginPage {
	String email,password;
	
	private  WebDriver driver;

	public LoginPage( WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	
	public void loginPageNavigation()
	{

		NavigateToLoginPage obj =  new NavigateToLoginPage(driver);
		obj.loginWithOtpToPasswordLogin();
	}
	
	public void loginUserDeatils(String email , String password)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type*='email']")));
		driver.findElement(By.cssSelector("input[type*='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		
	}
	public static void main(String[] args) {
		

		WebDriver driver =  EdgeDriverFactory.edgeWebDriverFactory(); 
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPageNavigation();
		
		OpenrahulShettySignUpPage sp = new OpenrahulShettySignUpPage(driver, "attempt 1", "attempt1@mailinator.com" , "123456");
		System.out.println("email = "+sp.getEmail());
		lp.loginUserDeatils(sp.getEmail(), sp.getPassword());
	}
}
