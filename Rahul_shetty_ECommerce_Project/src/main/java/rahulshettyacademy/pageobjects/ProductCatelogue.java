package rahulshettyacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.Components.Components;

public class ProductCatelogue extends Components {

	WebDriver driver;
	int add = 0;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	public ProductCatelogue(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//section[@id='products']/descendant::div[@class='card']/child::div[@class='card-body']")
	List<WebElement> products;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement successToast;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']/child::label")
	WebElement cartCount;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;

	By productVisibleVerification = By.xpath("//section[@id='products']/descendant::div[@class='card']");
	By spineer = By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted')]");
	By successMsg = By.xpath("//div[@id='toast-container']");

	public List<WebElement> getProductList() {

		waitForElementToAppear(productVisibleVerification);
		System.out.println("product list size:" + products.size());

		return products;
	}

	public WebElement getProductByName(String name) {
		WebElement productSelected = getProductList().stream()
				.filter(s -> s.findElement(By.xpath(".//h5")).getText().equalsIgnoreCase(name)).findFirst()
				.orElse(null);
		System.out.println(productSelected.getText());

		return productSelected;

	}

	public Cart addToCart(String name) {

		if (getProductByName(name) != null) {
			WebElement addToCart = getProductByName(name)
					.findElement(By.xpath(".//button[normalize-space(.)='Add To Cart']"));

			waitForElementToClickable(addToCart);

			addToCart.click();

			add++;
			
			checkCartCount(); 
			Cart cart = new Cart(driver);

			return cart;
			
		} else {
			System.out.println("Product Not Found");
			
			 throw new RuntimeException("Product Not Found");
		}
	}

	public void checkCartCount() {
		waitForInvisibilityOfElement(spineer);
		waitForElementToAppear(successMsg);

		System.out.println(successToast.getText());
		
		int CurrentProductCount = Integer.parseInt(cartCount.getText());
		
		if (CurrentProductCount == add) {
			System.out.println("Product  added");
			System.out.println("Current cart count is : " + CurrentProductCount);

			cart.click();
			
			
		} else {
			System.out.println("Product not added");
		}
		

	}

}
