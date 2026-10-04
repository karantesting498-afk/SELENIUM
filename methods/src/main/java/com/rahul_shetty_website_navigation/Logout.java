package com.rahul_shetty_website_navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.webdrivers.EdgeDriverFactory;

public class Logout {
	
	private WebDriver driver;
	public Logout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void openLoginPage()

	{
		driver.get("https://sso.teachable.com/secure/9521/identity/login/password?force=true");
	}
	
	public void loginUserDeatils()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type*='email']")));
		driver.findElement(By.cssSelector("input[type*='email']")).sendKeys("attempt1@mailinator.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'today!')]")));
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'today!')]")).isDisplayed());

		
	}
	
	public void getGreetingMessage()
	{
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'today!')]")).getText());
		
	}
	
	public void checkAssert()
	{
		String actual = driver.findElement(By.xpath("//h2[contains(text(),'today!')]")).getText();
		String expected = "Welcome back attempt. Let's learn something today!";
		Assert.assertTrue(actual.contains("Let's learn something today!"));
	}
	
	public void assertUserName(String userName)
	{
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'today!')]")).getText().contains(userName));
	}
	
	public void openMenu()
	{
		driver.findElement(By.cssSelector("button[type='button'][id='radix-:R17ah9ukq:']")).click();
	}
	public void logOut()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		Logout lg = new Logout(driver);
		lg.openLoginPage();
		lg.loginUserDeatils();
		lg.getGreetingMessage();
		lg.checkAssert();
		lg.assertUserName("attempt");
		lg.openMenu();
		lg.logOut();
		driver.close();
	}

}
