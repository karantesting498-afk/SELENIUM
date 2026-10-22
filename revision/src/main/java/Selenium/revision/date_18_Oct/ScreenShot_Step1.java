// This page contain knowledge regarding screenshot and partial screenshot
package Selenium.revision.date_18_Oct;

public class ScreenShot_Step1 {
	
	/*
	 * There are two main techniques you should know for interviews:
1. Full-page/browser screenshot — captures the visible browser viewport.
2. Partial screenshot — captures a particular WebElement, such as a login form, button, table, or error message.
	 */
	
	
	/*
	 * 1. Take a full screenshot
Selenium provides the TakesScreenshot interface to capture a screenshot of the browser's current viewport.
Code example
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotExample {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.example.com");

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.copy(
                source.toPath(),
                Path.of("screenshot.png")
        );

        driver.quit();
    }
}


Understand the important lines
- TakesScreenshot — interface used to capture screenshots.
- getScreenshotAs(OutputType.FILE) — returns the screenshot as a temporary file.
- Files.copy() — saves the screenshot to your chosen path.
- driver.quit() — closes the browser session.
Important: The code above captures the current viewport, not necessarily the entire webpage if the page is longer than the screen.
	 */

	
	
	/*
	 * 
	 * 2. Take a partial screenshot of a WebElement
Suppose you want to capture only the login form instead of the entire browser.

Selenium 4 supports taking a screenshot directly from a WebElement.







launchidea.in


Code example
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ElementScreenshot {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.example.com");

        WebElement element = driver.findElement(
                By.id("loginForm")
        );

        File source = element.getScreenshotAs(OutputType.FILE);

        Files.copy(
                source.toPath(),
                Path.of("login-form.png")
        );

        driver.quit();
    }
}


Here, element.getScreenshotAs(OutputType.FILE) captures the specified element rather than the full viewport.

You can use the same approach for a button, table, error message, or any other supported WebElement.
	 */
	
	
	/*
	 * 3. Full screenshot vs partial screenshot
Feature	Full screenshot	Partial screenshot
Method	driver.getScreenshotAs()	element.getScreenshotAs()
Captures	Browser viewport	Specific WebElement
Best use	Overall page evidence	Specific component evidence
Selenium interface	TakesScreenshot	WebElement screenshot support
Typical example	Entire visible page	Login form or error message
	 */
	
	
	/*
	 * 
	 * 4. Save screenshots to a specific folder
In real projects, you generally save screenshots in a dedicated folder.
Path screenshotPath =
        Path.of("screenshots", "login-failure.png");

Files.createDirectories(screenshotPath.getParent());

File source = ((TakesScreenshot) driver)
        .getScreenshotAs(OutputType.FILE);

Files.copy(source.toPath(), screenshotPath);


This creates the screenshots directory if it does not exist and saves the screenshot there.

If the destination file already exists, Files.copy() will normally throw an exception unless you specify an appropriate replacement option.
	 */
	
	
	/*
	 * 5. Take a screenshot when a test fails
This is a common Selenium interview question and a useful automation practice.

The basic logic is:
1. Execute the test.
2. Detect a failure or exception.
3. Capture the screenshot before closing the browser.
4. Save it with a useful name.
5. Attach it to the test report if required.
Example of a basic exception-based approach:


try {
    driver.findElement(By.id("submitButton")).click();

} catch (Exception e) {

    File source = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);

    Files.copy(
            source.toPath(),
            Path.of("screenshots", "test-failure.png")
    );

    throw e;
}
This is a simple illustration, not a complete framework implementation. 
In TestNG, you can usually centralize failure screenshots using an ITestListener and its onTestFailure() callback.


	 */

	/*
	 * 
	 * 6. Important interview points
- Does Selenium capture the entire webpage automatically? Not necessarily. Standard WebDriver screenshots generally capture the viewport; full-page capture depends on browser and driver capabilities.
- Can you take a screenshot of a single button? Yes, using element.getScreenshotAs(OutputType.FILE).
- Can you save a screenshot as bytes? Yes, use OutputType.BYTES.
- Can you return a Base64 screenshot? Yes, use OutputType.BASE64, which can be useful for reporting.
- Should you close the browser before capturing a failure screenshot? No. Capture it before quit() closes the session.
- What if the element is not found? The element lookup will fail, so you may need a full screenshot as fallback evidence.
	 */
	
	/*
	 * Quick revision
// Full viewport screenshot
File full = ((TakesScreenshot) driver)
        .getScreenshotAs(OutputType.FILE);

// Element screenshot
File partial = driver.findElement(By.id("loginForm"))
        .getScreenshotAs(OutputType.FILE);

// Screenshot as Base64
String base64 = ((TakesScreenshot) driver)
        .getScreenshotAs(OutputType.BASE64);


For your current Selenium learning level, 
focus first on taking full screenshots, capturing a specific element, saving files, and taking screenshots when a test fails. After that, practise automatic failure screenshots with TestNG listeners.
	 */
}
