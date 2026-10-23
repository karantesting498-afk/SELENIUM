// this class contain screenshot question
package Selenium.revision.date_18_Oct;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import javax.xml.transform.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScreenShot_Step2 {

	WebDriver driver;

	/*
	 * Q1. Medium — Capture a full screenshot Coding task: Open a login page, enter
	 * the username and password, click Login, and capture a screenshot after the
	 * dashboard is displayed. Save it as dashboard.png.
	 * 
	 * Theory questions: 1. Why do we typecast WebDriver to TakesScreenshot? 2. Does
	 * getScreenshotAs(OutputType.FILE) capture the entire webpage, including
	 * content below the scroll position?
	 */

	public void ques_01() {

		/*
		 * Theory 1. SO that driver can take screenshot?
		 * 
		 * WebDriver does not directly declare the getScreenshotAs() method. Selenium's
		 * TakesScreenshot interface provides that method. The typecast allows you to
		 * access the screenshot functionality implemented by the driver.
		 * 
		 * 2. no it will only take screen shot of the content currently shown on the
		 * screen
		 */

		driver.get("https://tfqa.trackofarm.im");

		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));

		userName.sendKeys("username");
		password.sendKeys("password");

		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));

		File fullSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(fullSS.toPath(), Path.of("D:\\selenium\\Screenshots\\dashboard.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Q2. Medium — Capture a specific element Coding task: A webpage contains a
	 * login form with ID loginForm. Write Selenium Java code to capture only that
	 * form and save it as login-form.png.
	 * 
	 * Theory questions: 1. What is the difference between driver.getScreenshotAs()
	 * and element.getScreenshotAs()? 2. Which Selenium version supports taking
	 * screenshots of individual elements?
	 */
	public void ques_02() {

		/*
		 * theory
		 * 
		 * 1. driver screenshot captures complete view of the screen element screenshot
		 * captures screenshot of element only.
		 * 
		 * 2. selenium 4 supports partial screenshot
		 */
		driver.get("https://tfqa.trackofarm.in");

		WebElement loginForm = driver.findElement(By.id("loginForm"));

		File partialSS = loginForm.getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(partialSS.toPath(), Path.of("D:\\selenium\\Screenshots\\login-form.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/*
	 * Q3. Hard — Capture a screenshot when a test fails Coding task: You have a
	 * test that verifies whether the login button is displayed. If the assertion
	 * fails, capture a screenshot named login-failure.png. Make sure the screenshot
	 * is captured before the browser is closed.
	 * 
	 * Theory questions: 1. Why should the screenshot be captured before
	 * driver.quit()? 2. What could happen if an exception occurs while capturing
	 * the screenshot?
	 */

	public void ques_03() {

		/*
		 * theory
		 * 
		 * 1. Because we cannot capture ScreenShot after quiting. 2. The screenshot may
		 * not be saved. If the screenshot exception is not handled separately, it can
		 * mask the original test failure. That is why screenshot capture should have
		 * its own exception handling, while preserving the original assertion failure.
		 */

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginbtn")));

			Assert.assertTrue(driver.findElement(By.id("loginbtn")).isDisplayed(), "Login Button is not displayed");
		} catch (Exception | AssertionError e) {
			// TODO: handle exception
			e.printStackTrace();

			File fullSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				Files.copy(fullSS.toPath(), Path.of("D:\\selenium\\Screenshots\\login-failure.png"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}

			throw e;

		}

		finally {
			driver.quit();
		}

	}

	/*
	 * Q4. Hard — Save screenshots in a folder Coding task: Write reusable Java code
	 * that saves a full-page viewport screenshot in a folder named screenshots. If
	 * the folder does not exist, your code should create it automatically. Save the
	 * file as home.png.
	 * 
	 * Theory questions: 1. What is the purpose of Files.createDirectories()? 2.
	 * What happens if a screenshot with the same filename already exists when using
	 * Files.copy()?
	 */

	public void ques_04() {
		/*
		 * theory 1. Q1. What is the purpose of Files.createDirectories()?
		 * 
		 * Your answer is correct, but it can be more precise: - Creates the specified
		 * directory and any missing parent directories. - Does not fail simply because
		 * the directory already exists. - Throws an IOException if the directory cannot
		 * be created.
		 * 
		 * 
		 * 
		 * 2. By default, if the destination file already exists, Java throws a
		 * FileAlreadyExistsException. It does not overwrite the file.
		 * 
		 * To overwrite it, explicitly use: Files.copy( fullSS.toPath(), screenshotPath,
		 * StandardCopyOption.REPLACE_EXISTING );
		 * 
		 */

		String folderName = "D:\\selenium\\screenshots";

		Path folderPath = Paths.get(folderName);
		Path screenshotPath = folderPath.resolve("home.png");

		try {
			Files.createDirectories(folderPath);

			File fullSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			Files.copy(fullSS.toPath(), screenshotPath);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Q5. Hard — Element screenshot with fallback Coding task: You need to capture
	 * a specific element with ID paymentDetails. If the element is not found,
	 * capture the full browser viewport instead. Save the resulting screenshot as
	 * payment-details.png.
	 * 
	 * Theory questions: 1. Why might findElement() throw an exception? 2. Why is a
	 * full screenshot useful as a fallback when an element screenshot fails?
	 */

	public void ques_05() throws Throwable {
		/*
		 * theory
		 * 
		 * 1. It might throw exception because payment details is not displayed or
		 * loaded, or overlapped
		 * 
		 * 2. If element is not found, then exception is displayed, in this case we have
		 * to get the full screen shot.
		 */
		String folderName = "D:\\selenium\\Screenshots";

		Path folderPath = Paths.get(folderName);

		Path targetPath = folderPath.resolve("payment-details.png");

		try {

			WebElement payment = driver.findElement(By.id("paymentDetails"));

			Assert.assertTrue(payment.isDisplayed(), "Payment details not displayed");

			File elementSS = payment.getScreenshotAs(OutputType.FILE);

			Files.copy(elementSS.toPath(), targetPath);

		} catch (AssertionError | Exception e) {

			e.printStackTrace();

			try {

				File fullSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				Files.copy(fullSS.toPath(), targetPath);

			} catch (Exception e2) {
				// TODO: handle exception

			}

			throw e;

		}

		finally {
			driver.quit();

		}

	}

}
