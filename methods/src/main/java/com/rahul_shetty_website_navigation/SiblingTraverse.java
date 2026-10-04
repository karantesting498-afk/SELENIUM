package com.rahul_shetty_website_navigation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class SiblingTraverse {
	
	private WebDriver driver;

	public SiblingTraverse(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]")));
	}
	
	public void selectSibling()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]")).getText());
		System.out.println("second element sibling"+driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/following-sibling::li[2]")).getText());
		System.out.println("third element sibling"+driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/following-sibling::li[3]")).getText());
		System.out.println("fourth element sibling"+driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[1]/following-sibling::li[4]")).getText());

		System.out.println("out of bound? element sibling"+driver.findElement(By.xpath("//div[@class='home_flight_search']//div[@class='button-align-center']/ul/li[0]/following-sibling::li[8]")).getText());

	
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		SiblingTraverse st = new SiblingTraverse(driver);
		st.openProject();
		st.selectSibling();
	}
}
