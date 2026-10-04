package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.webdrivers.EdgeDriverFactory;

public class TravelWebsiteSearchFlight {
	
	private WebDriver driver;

	public TravelWebsiteSearchFlight(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void openProject()

	{
//		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_rbtnl_Trip_0")));
	}
	

	public void selectTripMode()
	{
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_DropDownListCurrency")));
		
	}
	
	public void selectCurrency()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		currency.click();
		
		Select cur = new Select(currency);
		cur.selectByContainsVisibleText("USD");
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ctl00_mainContent_DropDownListCurrency"), "USD"));
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getAttribute("value"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_chk_IndArm")));

	}
	
	
	public void selectCheckBox()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_chk_IndArm")));


		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
	}
	
	
	public void selectDeparture()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")));
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")));
	
		
	}
	
	public void selectArrival()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']")));

		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

	}
	
	public void selectDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		System.out.println("Selecting current Date");
		
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[normalize-space(@class)='ui-state-default ui-state-active']")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date1")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_view_date2")));
		
		SoftAssert sft = new SoftAssert();
		try
		{
			returnDate.click();
			{
				sft.assertTrue(true, "Clickable");
			}
		}catch (Exception e)
		{
			sft.fail("Not clickable");
		}
		
		driver.findElement(By.id("spclearDate")).click();
			
	}
	
	public void selectPassenger()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo")));
		driver.findElement(By.id("divpaxinfo")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("divpaxOptions")));
		
		//Add 4 adults , 3 child , 2 infants
		for(int i = 0; i<4; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		for(int i = 0; i<3; i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		for(int i = 0; i<2; i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divpaxOptions")));
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getAttribute("value"));
	}
	


	public void search()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_btn_FindFlights")));

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("searching");
		
		
	}
	
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();
		
		TravelWebsiteSearchFlight obj = new TravelWebsiteSearchFlight(driver);
		
		obj.openProject();
		obj.selectTripMode();
		obj.selectCheckBox();

		obj.selectDeparture();
		obj.selectArrival();
		obj.selectDate();
		obj.selectPassenger();
		obj.selectCurrency();

		obj.search();
		
	}
}
