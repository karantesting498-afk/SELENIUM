package Personal.EcommereceSeleniumProject.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Personal.EcommereceSeleniumProject.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "(//table[contains(@class,'table table-bordered table-hover ng-star-inserted')]//tr//td[2])[1]")
	WebElement orderList;
	
	public WebElement getOrderList()
	{
		WebElement lastOrder = orderList;
		return lastOrder;
	}
	
	public boolean matchOrderProduct(String name)
	{	
		return getOrderList().getText().contains(name);
	}
}
