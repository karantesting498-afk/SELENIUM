package Insigihtgeeks.Trackofield;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import trackofield.pom.pages.DashboardPage;
import trackofield.pom.pages.LoginPage;
import trackofiled.test_component.BaseTest;

public class LoginTest extends BaseTest {

	By companyIdentifierDiv = By
			.xpath("//div[@id='companyIdentifierDiv']/child::div[contains(@class,'identifier-error')]");
	
	By userNameDiv = By.xpath("//div[@id='usernameDiv']/child::div[contains(@class,'username-error')]");
	
	By passDiv = By.xpath("//input[@id='password']/following-sibling::div[contains(@class,'password-error')]");
	
	By invalidUserError = By.xpath("//h2[@id='swal2-title']");
	

	@Test(groups = { "Positive" })
	public DashboardPage loginWithValidInfo() {
		LoginPage loginObj = new LoginPage(driver);

		DashboardPage dashboardObj = loginObj.login("ignoida", "m_karan3", "12345678");
		return dashboardObj;
	}

	@Test(groups = { "Negative" })
	public void loginWithAllBlankInfo() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("", "", "");
		Assert.assertEquals(driver.findElement(companyIdentifierDiv).getText(),
				"Please enter valid Company Identifier");
	}

	@Test(groups = { "Negative" })
	public void loginWithOnlyCompanyBlank() {
		LoginPage loginObj = new LoginPage(driver);

		loginObj.login("", "m_karan3", "12345678");

		Assert.assertEquals(driver.findElement(companyIdentifierDiv).getText(),
				"Please enter valid Company Identifier");

	}

	@Test(groups = { "Negative" })
	public void loginWithOnlyUserBlank() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("ignoida", "", "12345678");

		Assert.assertEquals(driver.findElement(userNameDiv).getText(), "Please enter valid username");
	}

	@Test(groups = { "Negative" })
	public void loginWithOnlyPassBlank() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("ignoida", "m_karan3", "");

		Assert.assertEquals(driver.findElement(passDiv).getText(), "Please enter valid password");
	}

	@Test(groups = { "Negative" })
	public void loginWithInvalidCompany() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("ignoida2", "m_karan3", "12345678");

		Assert.assertEquals(driver.findElement(invalidUserError).getText(), "User does not exists");
	}

	@Test(groups = { "Negative" })
	public void loginWithInvalidUser() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("ignoida3", "m_karan4", "12345678");

		Assert.assertEquals(driver.findElement(invalidUserError).getText(), "User does not exists");
	}

	@Test(groups = { "Negative" })
	public void loginWithInvalidPass() {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.login("ignoida", "m_karan3", "122112345678");

		Assert.assertEquals(driver.findElement(invalidUserError).getText(), "Password does not match");
	}

}
