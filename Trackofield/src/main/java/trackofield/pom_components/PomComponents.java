package trackofield.pom_components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomComponents {
	
	WebDriver driver;
	
	public PomComponents(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public void waitForVisbilityOfElementsBy(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForVisibilityOfElementBy(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForVisibilityOfElement(WebElement locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public void waitForVisibilityOfElements(List<WebElement> locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}
	
	public void waitForInvisibilityOfElmentBy(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForInvisibilityOfElment(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToBeClickableElement(WebElement ele)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForElementToBeClickableBy(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}

