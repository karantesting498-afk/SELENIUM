package com.rahul_shetty_website_navigation;

import java.time.Duration;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.BrowserUtils;
import com.webdrivers.EdgeDriverFactory;

public class OpenrahulShettySignUpPage {
	
	private   WebDriver driver;
	String name , email,password;
	
	public OpenrahulShettySignUpPage() {
		// TODO Auto-generated constructor stub
	}

	public OpenrahulShettySignUpPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public OpenrahulShettySignUpPage(WebDriver driver, String name , String email , String password)
	{
		this.driver= driver;
		this.name= name;
		this.email =  email;
		this.password =  password;
	}
	
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void openRahulShettyWebsite()
	{
		driver.get("https://rahulshettyacademy.com/");

	}
	
	public void goToSignUpPage()
	{
		openRahulShettyWebsite();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign Up")));
		signUp.click();
	}

	public void signUpDetails()
	{
		BrowserUtils.switchTab(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		WebElement signUpName = driver.findElement(By.id("name"));
		signUpName.sendKeys(name);
		
		WebElement signUpEmail = driver.findElement(By.id("email"));
		signUpEmail.sendKeys(email);
		
		WebElement sendCode = driver.findElement(By.id("otp-login-btn"));
		sendCode.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='sign_up/email']")));
		driver.findElement(By.cssSelector("a[href*='sign_up/email']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
		driver.findElement(By.id("user_name")).sendKeys(name);
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	
	public static void main(String[] args) {
		

		WebDriver driver =  EdgeDriverFactory.edgeWebDriverFactory(); 
		
		OpenrahulShettySignUpPage sp = new OpenrahulShettySignUpPage(driver, "attempt 1", "attempt1@mailinator.com" , "123456");
		sp.goToSignUpPage();
		sp.signUpDetails();
	}
}
