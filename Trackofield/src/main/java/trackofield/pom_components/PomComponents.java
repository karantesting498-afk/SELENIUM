package trackofield.pom_components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


}

