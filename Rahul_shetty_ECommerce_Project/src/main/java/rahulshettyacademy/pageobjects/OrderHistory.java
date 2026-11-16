package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Components.Components;

public class OrderHistory extends Components{
	
	WebDriver driver;

	public OrderHistory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table/descendant::tr/descendant::td[2]")
	List<WebElement> productName;
	
	public boolean verifyOrderDisplay(String name)
	{
		waitForWebElementListToAppear(productName);
		System.out.println(productName.get(0).getText());
		return productName.get(0).getText().equalsIgnoreCase(name);
	}
}


