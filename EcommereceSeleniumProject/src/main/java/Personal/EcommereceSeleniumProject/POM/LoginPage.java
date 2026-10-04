package Personal.EcommereceSeleniumProject.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Personal.EcommereceSeleniumProject.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{

	WebDriver driver ;

	public LoginPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'toast-message ng-star-inserted')]")
	WebElement loginFailMsg;
	
	By loginButtonLocator = By.xpath("//input[@id='login']");
	
	By loginFail = By.xpath("//div[contains(@class,'toast-message ng-star-inserted')]");
	
	public ProductCatelog login(String loginEmail , String loginPass)
	{
		email.sendKeys(loginEmail);
		
		password.sendKeys(loginPass);
		
		elementToBeClickable(loginButtonLocator);
		
		loginButton.click();
		
		return new ProductCatelog(driver);
	}
	
	public void openLoginPage()
	{
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String getLoginFailMsg()
	{
		visibilityOfElement(loginFail);
		return loginFailMsg.getText();
	}
}
