package trackofield.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import trackofield.pom_components.PomComponents;

public class LoginPage extends PomComponents {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="companyIdentifier")
	WebElement companyIdentifiier;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="app-login-btn")
	WebElement loginButton;
	
	
	public void login(String cId, String uName, String pwd)
	{
		companyIdentifiier.sendKeys(cId);
		username.sendKeys(uName);
		password.sendKeys(pwd);
		
		loginButton.click();
	}
}
