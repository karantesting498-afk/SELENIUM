package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Components.Components;

public class OrderConfirmation extends Components {

	WebDriver driver;
	
	public OrderConfirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h1[contains(@class,'hero-primary')]")
	WebElement ordermsg;
	
	By orderConfirmationMsg = By.xpath("//h1[contains(@class,'hero-primary')]");
	
	public String orderConfirmationAssertion()
	{
		waitForElementToAppear(orderConfirmationMsg);
		
		System.out.println("Order confirmation: " + ordermsg.getText());
		
		return ordermsg.getText();
	}
}
