package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import rahulshettyacademy.Components.Components;

public class CardDetails extends Components {
	WebDriver driver;

	public CardDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='title' and normalize-space(.)='Credit Card Number']/following-sibling::input")
	WebElement cardNumber;

	@FindBy(xpath = "//div[@class='title' and contains(text(),'CVV Code')]/following-sibling::input")
	WebElement cvvCode;

	@FindBy(xpath = "//div[@class='title' and normalize-space(.)='Name on Card']/following-sibling::input")
	WebElement nameOnCard;

	@FindBy(xpath = "//div[@class='title' and normalize-space(.)='Apply Coupon']/following-sibling::input")
	WebElement couponCode;

	@FindBy(xpath = "//button[@type='submit' and normalize-space(.)='Apply Coupon']")
	WebElement applyCoupon;

	@FindBy(xpath = "//a[contains(@class,'action__submit')]")
	WebElement placeOrder;

	@FindBy(xpath = "//div[@class='title' and normalize-space(.)='Expiry Date']/following-sibling::select[1]")
	WebElement expiryMonth;

	@FindBy(xpath = "//div[@class='title' and normalize-space(.)='Expiry Date']/following-sibling::select[2]")
	WebElement expiryDate;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryText;
	
	
	By cardPageVerification = By
			.xpath("//div[@class='title' and normalize-space(.)='Credit Card Number']/following-sibling::input");
	
	By countrySuggestionVisible = By.xpath("//section[contains(@class,'ta-results')]");
	

	public void selectDate(String date, WebElement element) {
		Select select = new Select(element);
		element.click();
		select.selectByContainsVisibleText(date);
	}

	public void addCardDetails(String newCardNumber, String newCVVCode, String newCardName, String newCouponCode,

			String newMonthDate, String newDayDate , String initals , String deliveryCountry) {
		
		waitForElementToAppear(cardPageVerification);
		cardNumber.clear();
		cardNumber.sendKeys(newCardNumber);

		cvvCode.sendKeys(newCVVCode);

		nameOnCard.sendKeys(newCardName);

		couponCode.sendKeys(newCouponCode);

		selectDate(newMonthDate, expiryMonth);

		selectDate(newDayDate, expiryDate);

		selectCountry(initals , deliveryCountry);
		
		placeOrder();
	}
	
	public void selectCountry(String initals , String deliveryCountry)
	{
		countryText.sendKeys(initals);
		
		waitForElementToAppear(countrySuggestionVisible);
		
		List<WebElement> suggestions = countryText.findElements(By.xpath("./following-sibling::section[contains(@class,'ta-results')]/descendant::button"));
		for (WebElement webElement : suggestions) {
			
			if(webElement.findElement(By.xpath(".//span")).getText().equalsIgnoreCase(deliveryCountry))
			{
				webElement.click();
				break;
			}
			
		}
		
		
	}
	
	public void placeOrder()
	{
		waitForElementToClickable(placeOrder);
		placeOrder.click();
	}

}
