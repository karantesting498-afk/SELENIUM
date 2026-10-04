package com.generics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import com.webdrivers.EdgeDriverFactory;

public class Calendardynamic {

	private WebDriver driver;
	
	private String month;
	private String year;
	private String day;

	private String emonth;
	private String eyear;
	private String eday;

	public Calendardynamic(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String monthName(String month)
	{
		int mon = Integer.valueOf(month);
		
		String name = Month.of(mon).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println(name);
		return name;
	}
	
	
	public Calendardynamic(WebDriver driver, String month, String year, String day , String emonth, String eyear, String eday) {
		this.driver = driver;
		this.month = month;
		this.year = year;
		this.day = day;
		this.emonth = emonth;
		this.eyear = eyear;
		this.eday = eday;
	}


	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickableWait10(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void openProject()
	{
		driver.get("https://live.trackofield.com/");
		
		clickableWait(By.id("companyIdentifier"));
		login();
		
	}
	
	public void login()
	{
		driver.findElement(By.id("companyIdentifier")).sendKeys("komal_testing");
		driver.findElement(By.id("username")).sendKeys("komal_testing");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("app-login-btn")).click();
		
		clickableWait(By.id("onDuty-executive-count"));
		openSideMenu();
		
	}
	
	public void openSideMenu()
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='hidden-md-down dropdown-icon-menu position-relative']//a[@class='header-btn btn js-waves-off']"))).perform();
		driver.findElement(By.xpath("//div[contains(@class,'hidden-md-down dropdown-icon-menu position-relative')]//a[@data-class='nav-function-minify']")).click();
		
		clickableWait(By.xpath("//input[@id='nav_filter_input']"));
		
		driver.findElement(By.xpath("//input[@id='nav_filter_input']")).sendKeys("regularize");
		
		clickableWait(By.xpath("//a[@title='Regularize Requests']"));
		
		driver.findElement(By.xpath("//a[@title='Regularize Requests']")).click();
		
		clickableWait10(By.xpath("//div[@class='panel-content']//li[2]"));
//		clickableWait(By.xpath("//a[@href='#attendance-override-history-tab']"));
		
		openRegHistory();
		
	}
	
	public void openRegHistory()
	{
		driver.findElement(By.xpath("//div[@class='panel-content']//li[2]")).click();
		
		clickableWait(By.xpath("//div[@class='treeSelector-input-box']"));
		changeDate();
		
	}
	
	public boolean navigateToStartMonth()
	{

		int tries=0;
		int maxTries=24;
		
		while(tries<maxTries)
		{
			String startYearString = driver.findElement(By.xpath("(//div[@class='calendar-table'])[2]//th[@class='month']")).getText();
			String currentSelectedStartYear = startYearString.split(" ")[1].trim();
			String currentSelectedStartMonth = startYearString.split(" ")[0].trim();

			
			if(currentSelectedStartYear.equals(year) && monthName(month).contains(currentSelectedStartMonth))
			{
				System.out.println("Date & month Matched");
				System.out.println(currentSelectedStartYear);
				return true;
			}
			
			else
			{
				driver.findElement(By.xpath("(//div[@class='calendar-table'])[1]//th[@class='prev available']")).click();
				tries++;

			}
		}
		
		if(tries==maxTries)
		{
			System.out.println("Not found");
		}
		return false;


	}
	
	public boolean navigateToEndDate()
	{
		int tries =0;
		int maxTries = 24;
		
		while(tries<maxTries)
		{
			String endDate = driver.findElement(By.xpath("(//div[@class='calendar-table'])[2]//th[@class='month']")).getText();
			String currentMonth = endDate.split(" ")[0].trim();
			String currentYear = endDate.split(" ")[1].trim();
			
			if(currentYear.equals(eyear) && monthName(emonth).contains(currentMonth))
			{
				System.out.println("Date & month Matched");
				return true;
			}
			
			else
			{
				driver.findElement(By.xpath("(//div[@class='calendar-table'])[2]//th[@class='next available']")).click();
				tries++;

			}
			

		}
		return false;


	}
	
	
	public void changeDate()
	{
		WebElement cal = driver.findElement(By.xpath("//input[@id='date-range-filter']"));
		cal.click();//cal open
		//now fetch current month and year.

		if(navigateToStartMonth())
		{
			List<WebElement> availDates = driver.findElements(By.xpath("(//div[@class='calendar-table'])[2]"+ 
					"//td[contains(@class,'available') and " +
					"not(contains(@class,'off')) and " +
					"not(contains(@class,'disabled'))]"));
			for(WebElement date : availDates)
			{
				if(date.getText().equals(day))
				{
					date.click();
					break;
				}
			}
			
			if(navigateToEndDate())
			{
				boolean clicked = false;
				List<WebElement> availEDates = driver.findElements(By.xpath("(//div[@class='calendar-table'])[2]"+ 
						"//td[contains(@class,'available') and " +
						"not(contains(@class,'off')) and " +
						"not(contains(@class,'disabled'))]"));
				for(WebElement date : availEDates)
				{
					if(date.getText().equals(eday))
					{
						date.click();
						clicked= true;
						break;
					}

					
				}
				if(!clicked)
				{
					Assert.fail("End date is out of range");

				}
			}
			
			driver.findElement(By.xpath("//div[@class='drp-buttons']//button[2]")).click();
		}
		
		
		
		assertTest();


	}
	
	public void assertTest()
	{
		WebElement cal = driver.findElement(By.xpath("//input[@id='date-range-filter']"));
		String calDate = cal.getAttribute("value");
		System.out.println(calDate);
		String calStart =calDate.split("-")[0].trim();
		String calEnd = calDate.split("-")[1].trim();
		
		System.out.println(calStart);
		System.out.println(calEnd);
		
		String inputStart = day+"/"+month+"/"+year;
		
		Assert.assertTrue(calStart.contains(inputStart), "Did not match");
		
		System.out.println("Matched");
		
		
	}
	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		Calendardynamic obj = new Calendardynamic(driver,"04","2025", "1", "05", "2025" , "1");
		
		obj.openProject();
	}
	
	
	
}
