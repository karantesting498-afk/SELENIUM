package com_java_streams;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.webdrivers.EdgeDriverFactory;

public class WebTableSorting {

	private WebDriver driver;

	public WebTableSorting(WebDriver driver) {
		this.driver = driver;
	}

	public void clickableWait(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void visibility(By locator)

	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void clickableWait10(By locator)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void openProject() {
		driver.get("https://live.trackofield.com/");

		clickableWait(By.id("companyIdentifier"));
		login();

	}

	public void login() {
		driver.findElement(By.id("companyIdentifier")).sendKeys("komal_testing");
		driver.findElement(By.id("username")).sendKeys("komal_testing");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("app-login-btn")).click();

		clickableWait(By.id("onDuty-executive-count"));
		openSideMenu();

	}

	public void openSideMenu() {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(
				"//div[@class='hidden-md-down dropdown-icon-menu position-relative']//a[@class='header-btn btn js-waves-off']")))
				.perform();
		driver.findElement(By.xpath(
				"//div[contains(@class,'hidden-md-down dropdown-icon-menu position-relative')]//a[@data-class='nav-function-minify']"))
				.click();

		clickableWait(By.xpath("//input[@id='nav_filter_input']"));

		driver.findElement(By.xpath("//input[@id='nav_filter_input']")).sendKeys("F.O. Settings");

		clickableWait(By.xpath("//a[contains(@title,'Field Operation Settings')]"));

		driver.findElement(By.xpath("//a[contains(@title,'Field Operation Settings')]")).click();

		clickableWait(By
				.xpath("//table[@id='operation-settings-table']//th[contains(@class,'operation-settings-name-data')]"));
		clickableWait(
				By.xpath("//table[@id='operation-settings-table']//tr//td[@class=' operation-settings-name-data']"));

		sortingCheck();
	}

	public void toSort() {
		WebElement name = driver.findElement(By
				.xpath("//table[@id='operation-settings-table']//th[contains(@class,'operation-settings-name-data')]"));
		name.click();
	}

	public List<String> sortingListFetch() {
		
		try { Thread.sleep(5000); } catch (InterruptedException e) {}

		List<WebElement> names = driver.findElements(
				By.xpath("//table[@id='operation-settings-table']//tr//td[contains(@class,'operation-settings-name-data')]"));
		System.out.println(names.size());

		List<String> settings = names.stream().map(n -> n.getText()).collect(Collectors.toList());

		return settings;
	}

	public void sortingCheck() {
		List<String> current = sortingListFetch();
		List<String> sortedByStream = current.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());

		sortedByStream.stream().forEach(i->System.out.println(i));
		toSort();

		List<String> afterSort = sortingListFetch();
		System.out.println("----");
		afterSort.stream().forEach(i->System.out.println(i));


		boolean flag = IntStream.range(0, afterSort.size())
				.allMatch(i -> afterSort.get(i).equals(sortedByStream.get(i)));
		System.out.println(flag);

		Assert.assertTrue(flag);

		System.out.println("====");

		toSort();

		List<String> afterSort2 = sortingListFetch();
		System.out.println(afterSort2);
		boolean flag2 = IntStream.range(0, afterSort.size())
				.allMatch(i -> afterSort2.get(i).equals(sortedByStream.get(i)));
		System.out.println(flag2);

		Assert.assertTrue(flag2);
	}

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriverFactory().edgeWebDriverFactory();

		WebTableSorting obj = new WebTableSorting(driver);
		obj.openProject();

	}
}
