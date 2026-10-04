package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Actionmethods {
	
	private WebDriver driver;
	


	public Actionmethods(WebDriver driver) {
		this.driver = driver;

	}
	
	public Actions actionObject()
	{
		Actions a = new Actions(driver);
		return a;

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
	
	public void openProject()
	{
		driver.get("https://www.amazon.com/");
		
		visibilityWait(By.xpath("//div[@role='alertdialog']"));

		driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();
		
		inVisibilityWait(By.xpath("//div[@role='alertdialog']"));
	}
	

	
	public void hover()
	{
		Actions a  = actionObject();
		a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).build().perform();
		
	}
	
	public void inputInUpperCase()
	{
		Actions a  = actionObject();

		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("bat").build().perform();
	}
	
	public void doubleClick()
	{
		Actions a  = actionObject();

		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).doubleClick().build().perform();
	
	}
	
	public void rightClick()
	{
		Actions a  = actionObject();

		a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-link-accountList']"))).contextClick().build().perform();
	}
	
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		Actionmethods obj = new Actionmethods(driver);
		
		obj.openProject();
		obj.hover();
		obj.inputInUpperCase();
		obj.doubleClick();
		obj.rightClick();
	}
	

}
