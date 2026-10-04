package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Waitassignment {
	
	private WebDriver driver;
	
	
	public Waitassignment(WebDriver driver) {
		this.driver = driver;
	}

	public void alertVisibilityWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void visibilityWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void inVisibilityWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void clickableWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	}
	
	public void inputUserName(String name)
	{
		driver.findElement(By.id("username")).sendKeys(name);
		
	}
	
	public void inputPassword(String pass)
	{
		driver.findElement(By.id("password")).sendKeys(pass);	
	}
	
	public void selectCheckBox()
	{
		driver.findElement(By.xpath("//div[@class='form-check-inline']//input[@value='user']/following-sibling::span")).click();

		WebElement userModal = driver.findElement(By.xpath("//div[@class='modal-content']"));
		visibilityWait(By.xpath("//div[@class='modal-content']"));
		
		driver.findElement(By.xpath("//div[@class='modal-content']//button[@id='okayBtn']")).click();
		
	}
	
	public void selectDropDown()
	{
		inVisibilityWait(By.xpath("//div[@class='modal-content']"));
		WebElement dropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select st = new Select(dropdown);
		st.selectByIndex(2);
		System.out.println(st.getFirstSelectedOption().getText());
		
	}
	
	public void termsAndCond()
	{
		clickableWait(By.id("terms"));
		driver.findElement(By.id("terms")).click();
	}
	
	public void signIn()
	{
		driver.findElement(By.id("signInBtn")).click();

	}
	
	public List<WebElement> getAllProducts()
	{
		clickableWait(By.xpath("//a[@class='nav-link']"));
		
		List<WebElement> products = driver.findElements(By.xpath("//app-card-list[@class='row']/app-card"));
		System.out.println(products.size());
		return products;
	}
	
	public void addToCart()
	{
		List<WebElement> prodcucts = getAllProducts();
		
		for(WebElement product : prodcucts)
		{
			product.findElement(By.xpath("//button[contains(@class,'btn-info')]")).click();
		}
	}
	
	public void checkOut()
	{
		List<WebElement> products = getAllProducts();
		int checkOutCount = Integer.parseInt(driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).getText().split("\\(")[1].replace(")","").trim());
		
		if(products.size() == checkOutCount)
		{
			driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).click();
			
			clickableWait(By.xpath("//button[contains(@class,'btn btn-success')]"));
			driver.findElement(By.xpath("//button[contains(@class,'btn btn-success')]")).click();
			
			clickableWait(By.id("country"));
			driver.findElement(By.id("country")).sendKeys("In");
			visibilityWait(By.xpath("//div[@class='suggestions']"));
			
			List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='suggestions']/ul"));
			
			for(WebElement suggest : suggestions)
			{
				if(suggest.getText().equalsIgnoreCase("India"))
				{
					suggest.click();
					break;
				}
			}
			
			inVisibilityWait(By.xpath("//div[@class='suggestions']"));
			driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
			
			driver.findElement(By.xpath("//input[contains(@class,'btn btn-success btn-lg')]")).click();
			
			System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]")).getText());
		}
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Waitassignment obj = new Waitassignment(driver);
		obj.openProject();
		obj.inputUserName("rahulshettyacademy");
		obj.inputPassword("Learning@830$3mK2");
		obj.selectCheckBox();
		obj.selectDropDown();
		obj.termsAndCond();
		obj.signIn();
		obj.getAllProducts();
		obj.addToCart();
		obj.checkOut();
	}

}
