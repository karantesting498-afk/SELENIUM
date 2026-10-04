package Personal.EcommereceSeleniumProject.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Personal.EcommereceSeleniumProject.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	By creditCard = By.xpath("//div[contains(@class,'payment__type payment__type--cc active')]");
	By couponApplyButton = By.xpath("//button[contains(text(),'Apply Coupon')]");
	By couponMsg = By.xpath("//div[contains(@class,'field small')]//p[contains(@class,'mt-1 ng-star-inserted')]");
	By countryDropDown = By.xpath("//input[contains(@placeholder,'Select Country')]");
	By countrySuggestions = By.xpath("//section[contains(@class,'ta-results list-group ng-star-inserted')]");
	
	@FindBy(xpath = "//input[contains(@class,'input txt text-validated')]")
	WebElement cardNumber;
	
	@FindBy(xpath = "//div[contains(text(),'CVV Code')]/following-sibling::input[contains(@class,'input txt')]")
	WebElement CVV;
	
	@FindBy(xpath = "//div[contains(@class,'field small')]//select[contains(@class,'input ddl')][2]")
	WebElement expiryDate;
	
	@FindBy(xpath = "//div[contains(@class,'field small')]//select[contains(@class,'input ddl')][1]")
	WebElement expiryMonth;
	
	
	@FindBy(xpath = "//div[contains(text(),'Name on Card')]/following-sibling::input[contains(@class,'input txt')]")
	WebElement nameOnCard;
	
	@FindBy(xpath = "//input[contains(@name,'coupon')]")
	WebElement couponCode;
	
	@FindBy(xpath = "//button[contains(text(),'Apply Coupon')]")
	WebElement couponApply;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Select Country')]")
	WebElement country;
	
	@FindBy(xpath = "//section[contains(@class,'ta-results list-group ng-star-inserted')]//button")
	List<WebElement> countriesList;
	
	@FindBy(xpath = "//div[contains(@class,'actions')]//a[contains(@class,'btnn action__submit ng-star-inserted')]")
	WebElement placeOrder;
	
	public void inputCardDetails(String orgCardNumber, String orgCVV, String orgExpiryDate, String orgExpiryMonth, String name, String coupon)
	{
		elementToBeClickable(creditCard);
		cardNumber.sendKeys(orgCardNumber);
		CVV.sendKeys(orgCVV);
		selectDates(orgExpiryDate, expiryDate);
		selectDates(orgExpiryMonth, expiryMonth);
		nameOnCard.sendKeys(name);
		couponCode.sendKeys(coupon);
		applyCoupon();

	}
	
	public void selectDates(String Date, WebElement ele)
	{
		Select obj = new Select(ele);
		obj.selectByContainsVisibleText(Date);
	}
	
	public void applyCoupon()
	{
		elementToBeClickable(couponApplyButton);
		couponApply.click();
		System.out.println("Coupon added");
		
		visibilityOfElement(couponMsg);

	}
	
	public void selectDeliveryCountry(String countryToMatch)
	{
		elementToBeClickable(countryDropDown);
		country.sendKeys("Ind");
		
		visibilityOfElement(countrySuggestions);
		
		selectCountryFromSuggestion(countryToMatch);
		
	}
	
	public void selectCountryFromSuggestion(String countryToMatch)
	{
		List<WebElement> countriesSuggestion = countriesList;
		System.out.println(countriesSuggestion.size());
		
		countriesSuggestion.stream().filter(d -> d.findElement(By.xpath(".//span")).getText().equalsIgnoreCase(countryToMatch))
		.findFirst().ifPresent(d -> d.click());

	}
	
	public void placeOrderToCountry()
	{
		placeOrder.click();
	}

}
