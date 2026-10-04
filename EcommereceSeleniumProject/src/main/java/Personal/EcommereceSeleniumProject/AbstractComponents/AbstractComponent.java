package Personal.EcommereceSeleniumProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Personal.EcommereceSeleniumProject.POM.CartPage;
import Personal.EcommereceSeleniumProject.POM.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement order;
	
	By orderButton = By.xpath("//button[@routerlink='/dashboard/myorders']");
	By cartButton = By.xpath("//button[@routerlink='/dashboard/cart']");


	public AbstractComponent(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void visibilityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public void invisibilityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}
	
	public void elementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
	public CartPage gotoCart()
	{
		elementToBeClickable(cartButton);

		cart.click();
		
		return new CartPage(driver);
	}
	
	public OrderPage goToOrder()
	{
		elementToBeClickable(orderButton);
		order.click();
		return new OrderPage(driver);
	}
	

}
