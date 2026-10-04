package com.java_Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class WindowAlerts {

	private WebDriver driver;
	String text;

	public WindowAlerts(WebDriver driver) {
		this.driver = driver;
	}

	public void openProject() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait wait 	= new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
	}

	public void sendtext(String text) {
		this.text = text;
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
	}

	public void alertFunction() {
		String error = driver.switchTo().alert().getText();

		System.out.println(error);
		if (error.contains(text)) {
			System.out.println("Text is present");
		} else {
			System.out.println("Not present");
		}
		driver.switchTo().alert().accept();
	}

	public void confirmButtonText() {

		driver.findElement(By.id("confirmbtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.alertIsPresent());

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

		driver.findElement(By.id("confirmbtn")).click();

		driver.switchTo().alert().accept();

	}

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		WindowAlerts obj = new WindowAlerts(driver);
		obj.openProject();
		obj.sendtext("Rahul");
		obj.alertFunction();
		obj.confirmButtonText();
	}

}
