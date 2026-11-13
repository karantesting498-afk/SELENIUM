package rahulshettyacademy.Components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Components {
	
	WebDriver driver;
	public Components(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}


	public void waitForElementToAppear(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitForElementToClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForInvisibilityOfElement(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}

}
