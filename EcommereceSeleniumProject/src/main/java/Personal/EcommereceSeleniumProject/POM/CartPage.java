package Personal.EcommereceSeleniumProject.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Personal.EcommereceSeleniumProject.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	By cartItems = By.xpath("//div[@class='cart']//ul");
	By checkOutButton = By.xpath("//div[contains(@class,'subtotal cf ng-star-inserted')]//button");
	
	@FindBy(xpath = "//div[contains(@class,'subtotal cf ng-star-inserted')]//button")
	WebElement checkout;
	
	
	@FindBy(xpath = "//div[@class='cart']//ul")
	List<WebElement> freshCartItems;
	
	
	public List<WebElement> getCartItems()
	{
		visibilityOfElement(cartItems);
		return freshCartItems;
	}
	
	public boolean verifyProductAdded(String name)
	{
		boolean value = getCartItems().stream().anyMatch(d-> d.findElement(By.xpath(".//h3")).getText().contains(name));
		System.out.println(value);

		return value;
	}
	
	public PaymentPage checkOut()
	{
		elementToBeClickable(checkOutButton);
		checkout.click();
		
		return new PaymentPage(driver);
	}
	

}
