/*
 * Question 3 – Practical coding challenge
You need to automate a login test using the following test data:
Username	Password	Expected Result
admin	admin123	Success
employee	emp123	Success
invalid	wrong123	Failure
blank	blank	Failure

Write a complete TestNG implementation that:
1. Uses @DataProvider to supply all four data sets.
2. Accepts username, password, and expected result in the test method.
3. Validates the actual login result against the expected result.
4. Uses assertions instead of only printing the result.
5. Handles the blank username/password scenario correctly.
You can use a placeholder login method instead of actual Selenium locators.
 */
package Selenium.revision.date_2026_10_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q3_Step3 {

	WebDriver driver;

	@DataProvider(name = "logindata")
	public static Object loginData() {
		Object loginTestData[][] = new Object[4][3];

		loginTestData[0][0] = "admin";
		loginTestData[0][1] = "admin123";
		loginTestData[0][2] = "Success";

		loginTestData[1][0] = "employee";
		loginTestData[1][1] = "emp123";
		loginTestData[1][2] = "Success";

		loginTestData[2][0] = "invalid";
		loginTestData[2][1] = "wrong123";
		loginTestData[2][2] = "Failure";

		loginTestData[3][0] = "";
		loginTestData[3][1] = "";
		loginTestData[3][2] = "Failure";

		return loginTestData;

	}

	@Test(dataProvider = "logindata")
	public void loginValidation(String username, String password, String expResult) {
		driver.findElement(By.id("userName")).sendKeys(username);
		;

		driver.findElement(By.id("password")).sendKeys(password);
		;

		driver.findElement(By.id("loginBtn")).click();
		String result = driver.findElement(By.id("loginMsg")).getText();

		if (username.isBlank() || password.isBlank()) {

			Assert.assertEquals(result, "Failure");

		}

		Assert.assertEquals(result, expResult);
	}

}
