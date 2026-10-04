package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdrivers.EdgeDriverFactory;

public class Assignment1 {
	
	private WebDriver driver;


	public Assignment1(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	}
	
	public void openProject()
	{
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}
	
	public void inputName(String name)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='name'])")));
		
		driver.findElement(By.xpath("(//input[@name='name'])")).sendKeys(name);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='email'])[1]")));
		
	}
	
	public void inputEmail(String email)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleInputPassword1")));

	}
	
	public void inputPass()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleCheck1")));

	}
	
	public void selectCheckBox()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.id("exampleCheck1")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleFormControlSelect1")));
	}
	
	public void dropDown()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement dd= driver.findElement(By.id("exampleFormControlSelect1"));
		dd.click();
		Select drop = new Select(dd);
		
		drop.selectByVisibleText("Male");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("inlineRadio1")));
	}
	
	public void selectCheckBox2()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.id("inlineRadio1")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.form-control")));
	}
	
	public void selectDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
		date.sendKeys("10/29/1999");

		
	}
	
	public void submit()
	{
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();
		
//		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success'] strong")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success'")).getText());
	}
	public static void main(String[] args) {
		
		WebDriver driver = EdgeDriverFactory.edgeWebDriverFactory();
		Assignment1 obj = new Assignment1(driver);
		
		obj.openProject();
		obj.inputName("Karan");
		obj.inputEmail("assign1@mailinator.com");
		obj.inputPass();
		obj.selectCheckBox();
		obj.dropDown();
		obj.selectCheckBox2();
		obj.selectDate();
		obj.submit();
	}
	
}
