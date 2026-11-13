package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Components.Components;

public class Cart extends Components {

	WebDriver driver;

	public Cart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cart']/child::ul")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[normalize-space(.)='Checkout']")
	WebElement checkoutBtn;

	By productInCartVerification = By.xpath("//div[@class='cart']/child::ul[1]");

	public List<WebElement> fetchCartProduct() {
		waitForElementToAppear(productInCartVerification);
		return cartProducts;

	}

	public boolean verifyProductInCart(String name) {
		System.out.println("Cart Product Size : " + fetchCartProduct().size());
		return fetchCartProduct().stream()
				.anyMatch(s -> s.findElement(By.xpath(".//h3")).getText().equalsIgnoreCase(name));

	}
	
	public CardDetails checkOut()
	{
		waitForElementToClickable(checkoutBtn);
		checkoutBtn.click();
		
		CardDetails card = new CardDetails(driver);
		return card;

	}
}
