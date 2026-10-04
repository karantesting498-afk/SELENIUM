package com.rahul_shetty_website_navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.BrowserUtils;

public class NavigateToLoginPage {
	
	private WebDriver driver;
	
	public NavigateToLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	
	

	public void signUpToLoginWithOtp()
	{
		OpenrahulShettySignUpPage obj = new OpenrahulShettySignUpPage(driver);
		obj.goToSignUpPage();
		BrowserUtils.switchTab(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement loginWithOtp = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log in")));
		loginWithOtp.click();
	}
	
	public void loginWithOtpToPasswordLogin()
	{
		signUpToLoginWithOtp();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginWithPass = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("log in with a password")));
		loginWithPass.click();
	}
}
