package com.practise1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Linkcount {

	
	private WebDriver driver;
	private String parent ;
	


	public Linkcount(WebDriver driver) {
		this.driver = driver;

	}
	
	public void switchToChild()
	{
		parent = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		
		for(String child : tabs)
		{
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
				break;
			}
		}
		
	}
	
	public void clickableWait(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void switchToParent()
	{
		driver.switchTo().window(parent);
	}
	
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	public void findLinkCount()
	{
		System.out.println((driver.findElements(By.tagName("a"))).size());
	}
	
	public void findFooterLinkCount()
	{
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
	}
	
	public void findLinkCountOfFooterFirstSection()
	{
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//table[@class='gf-t']//td[1]//a")).size());
		
	}

	
	public void openEachLinkInTheFooter()
	{
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		
		Actions a = new Actions(driver);
		int count=1;
		
		for(WebElement ele : links)
		{
			a.moveToElement(ele).keyDown(Keys.CONTROL).click(ele).build().perform();
			switchToChild();
			System.out.println(driver.getTitle() + count);
			System.out.println(driver.getCurrentUrl());
			System.out.println("===============================");
			driver.close();
			switchToParent();
			
			clickableWait(By.xpath("//div[@id='gf-BIG']//a"));
			count++;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		Linkcount obj = new Linkcount(driver);
		obj.openProject();
		obj.findLinkCount();
		
		obj.findFooterLinkCount();
		
		obj.findLinkCountOfFooterFirstSection();
		obj.openEachLinkInTheFooter();
	}
	

}
