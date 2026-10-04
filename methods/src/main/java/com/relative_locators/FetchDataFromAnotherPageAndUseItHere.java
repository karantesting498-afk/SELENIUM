package com.relative_locators;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;
import com.window_handles.Windowswitcher;

public class FetchDataFromAnotherPageAndUseItHere {

	private WebDriver driver;

	public FetchDataFromAnotherPageAndUseItHere(WebDriver driver) {
		this.driver = driver;
	}

	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void visibilityWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		FetchDataFromAnotherPageAndUseItHere obj = new FetchDataFromAnotherPageAndUseItHere(driver);

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String parent = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/course-library");

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
				break;
			}
		}

		obj.visibilityWait(
				By.xpath("//h3[contains(text(),'Playwright JS/TS Automation Testing from Scratch & Framework')]"));

		String name = driver
				.findElement(By
						.xpath("//h3[contains(text(),'Playwright JS/TS Automation Testing from Scratch & Framework')]"))
				.getText();

		driver.switchTo().window(parent);

		obj.clickableWait(By.xpath("//input[@name='name']"));

		WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
		nameInput.sendKeys(name);

	}

}
