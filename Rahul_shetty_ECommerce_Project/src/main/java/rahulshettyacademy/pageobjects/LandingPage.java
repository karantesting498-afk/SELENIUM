package rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.Components.Components;

public class LandingPage extends Components {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * 
	 * WebElement email = driver.findElement(By.id("userEmail")); WebElement pass =
	 * driver.findElement(By.id("userPassword")); WebElement loginButton =
	 * driver.findElement(By.id("login"));
	 */

	// Page Factory
	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement pass;

	@FindBy(id = "login")
	WebElement loginButton;

	public ProductCatelogue loginApplication(String loginEmail , String loginPass) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys(loginEmail);
		pass.sendKeys(loginPass);
		loginButton.click();
		
		ProductCatelogue catelogue = new ProductCatelogue(driver);
		return catelogue;
	}
	
	
	public void goTo(String loginUrl)
	{
		driver.get(loginUrl);

	}

}
