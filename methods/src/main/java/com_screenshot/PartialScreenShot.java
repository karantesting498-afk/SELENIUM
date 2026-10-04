package com_screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class PartialScreenShot {
	
	private WebDriver driver;

	public PartialScreenShot(WebDriver driver) {
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
	
	
	
	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		PartialScreenShot obj = new PartialScreenShot(driver);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String parent = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/course-library");
		
		obj.visibilityWait(
				By.xpath("//section[contains(@class,'max-w-6xl')]//h3[1]"));

		String name = driver
				.findElement(By
						.xpath("//section[contains(@class,'max-w-6xl')]//h3[1]"))
				.getText();

		driver.switchTo().window(parent);

		obj.clickableWait(By.xpath("//input[@name='name']"));

		WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
		nameInput.sendKeys(name);
		
		File file = nameInput.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("partialSS.png"));
		
		nameInput.getRect().getDimension().getHeight();
		
		String str = "Karan";
		
	}

}
