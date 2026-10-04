package Personal.EcommereceSeleniumProject.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Personal.EcommereceSeleniumProject.AbstractComponents.AbstractComponent;

public class ProductCatelog extends AbstractComponent {

	WebDriver driver;

	public ProductCatelog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "//div[@class='card-body']")
	List<WebElement> products;
	
	By freshProduct = By.xpath("//div[@class='card-body']");
	By addToCartButton = By.xpath(".//button[contains(text(),'Add To Cart')]");
	By successfullyAddedToCartMsg = By.xpath("//div[@id='toast-container']");
	
	public List<WebElement> getProductList()
	{
		visibilityOfElement(freshProduct);
		return products;
	}
	
	public WebElement getProductByName(String name)
	{
	    List<WebElement> freshList = driver.findElements(By.xpath("//div[@class='card-body']"));

	    freshList.forEach(d -> 
        System.out.println("Product name: [" + d.findElement(By.xpath(".//h5/b")).getText() + "]")
    );
	    
		WebElement prod = getProductList().stream().filter(d->d.findElement(By.xpath(".//h5/b")).getText().contains(name)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String prodName)
	{
		WebElement add = getProductByName(prodName).findElement(By.xpath(".//button[contains(text(),'Add To Cart')]"));
		elementToBeClickable(addToCartButton);
		
		add.click();
		System.out.println("Added");
		
		visibilityOfElement(successfullyAddedToCartMsg);
		invisibilityOfElement(successfullyAddedToCartMsg);

	}

}
