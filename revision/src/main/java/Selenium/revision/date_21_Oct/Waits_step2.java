//This class contain knowledge regarding the wait questions
package Selenium.revision.date_21_Oct;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits_step2 {
	
	WebDriver driver;
	
	//Section 1: Implicit Wait — 3 Questions
	
	
	/*
	 * Q1. Element Appears After a Delay
Consider this code:
driver.manage().timeouts()
      .implicitlyWait(Duration.ofSeconds(10));

driver.get("https://example.com");

WebElement element = driver.findElement(By.id("dashboard"));

System.out.println(element.getText());

Suppose the dashboard element appears four seconds after the page loads.

Answer the following:
1. Will Selenium wait for four seconds, ten seconds, or some other duration?
2. What happens if the element never appears?
3. Does implicit wait guarantee that the element will be visible before getText() executes?
	 */
	
	public void ques_01()
	{
		/*
		 * 1. It will wait for 4 seconds and as soon as element is found, it will continue the code.
		 * 2. If element never appears, then NoSuchElementException will be displayed.
		 * 3. yes, implicit wait will work till element is appeared.
		 * 
		 * No. Implicit wait does not guarantee that the element is visible.

It waits for the element to be found in the DOM. The element may exist but still be hidden.

In that situation, findElement() can return the element, and getText() may return an empty string if the element has no visible text.
		 */
		driver.manage().timeouts()
	      .implicitlyWait(Duration.ofSeconds(10));

	driver.get("https://example.com");

	WebElement element = driver.findElement(By.id("dashboard"));

	System.out.println(element.getText());
	}
	
	/*
	 * Q2. Implicit Wait and Multiple Element Searches
Consider:
driver.manage().timeouts()
      .implicitlyWait(Duration.ofSeconds(5));

driver.findElement(By.id("username"));
driver.findElement(By.id("password"));
driver.findElement(By.id("loginButton"));

Suppose none of these elements exists in the DOM.

Answer the following:
1. Approximately how long might each lookup wait before failing?
2. Could the total execution time approach 15 seconds?
3. Does implicit wait guarantee that the entire block will finish within five seconds?
4. What exception will be thrown when an individual lookup fails?
	 */
	
	public void ques_02()
	{
		/*
		 * 1. It will wait for 5 seconds
		 * 2. yes
		 * 3. No, implicit wait will work for specified time for each element searching in dom.
		 * 4. NoSuchElementException will be thrown
		 */
		driver.manage().timeouts()
	      .implicitlyWait(Duration.ofSeconds(5));

	driver.findElement(By.id("username"));
	driver.findElement(By.id("password"));
	driver.findElement(By.id("loginButton"));
	}

	/*
	 * Q3. Implicit Wait and Visibility
Suppose an element exists in the DOM but is hidden using CSS:
<button id="submit" style="display:none;">
    Submit
</button>

Your Selenium code is:
driver.manage().timeouts()
      .implicitlyWait(Duration.ofSeconds(5));

WebElement button = driver.findElement(By.id("submit"));

System.out.println(button.isDisplayed());

Answer the following:
1. Will findElement() wait for five seconds?
2. What will isDisplayed() return?
3. Will implicit wait continue waiting until the button becomes visible?
4. Which type of wait would you use if the button must become visible before proceeding?
	 */
	
	public void ques_03()
	{
		/*
		 * 1. Yes, max wait time is 5 seconds but if element found before 5 seconds like in second, then code will proceed after 
		 * 2 seconds.
		 * 
		 * 2. boolean value
		 * 
		 * 3. No. Implicit wait does not wait for visibility. 
		 * It waits for the element to be located in the DOM.

Since the button already exists, Selenium returns it immediately.
 Calling isDisplayed() then returns false.

No exception is thrown merely because the button is hidden. 
NoSuchElementException occurs when Selenium cannot locate the element within the implicit wait period. 
		 * 
		 * 
		 * 4. Explicit wait with visibilityOfElement Condition
		 */
		driver.manage().timeouts()
	      .implicitlyWait(Duration.ofSeconds(5));

	WebElement button = driver.findElement(By.id("submit"));

	System.out.println(button.isDisplayed());
	}
	
	//Section 2: Explicit Wait — 3 Questions
	
	
	/*
	 * Q4. Presence vs Visibility
Consider:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement element = wait.until(
    ExpectedConditions.presenceOfElementLocated(
        By.id("successMessage")
    )
);

System.out.println(element.getText());

Suppose the element exists in the DOM but is hidden.

Answer the following:
1. Will presenceOfElementLocated() succeed?
2. Will the element necessarily be visible when the condition succeeds?
3. Rewrite the wait using visibilityOfElementLocated().
4. What exception will occur if the required condition never becomes true before the timeout?
	 */
	
	public void ques_04()
	{
		/*
		 * 1. Yes
		 * 2. Not necessarily. presenceOfElementLocator only checks for presence of button not visibility.
		 * It might be present but not visible
		 * 
		 * 3. code
		 * 
		 * 4. TimeoutException
		 */
		WebDriverWait wait =
			    new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement element = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.id("successMessage")
			    )
			);
			
	}
	
	
	/*
	 * Q5. Waiting for a Clickable Button
Suppose a Submit button is visible immediately but remains disabled for three seconds.
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement submitButton = wait.until(
    ExpectedConditions.elementToBeClickable(
        By.id("submit")
    )
);

submitButton.click();

Answer the following:
1. Will the wait succeed immediately when the button becomes visible?
2. What additional condition does elementToBeClickable() check?
3. If the button becomes enabled after three seconds, approximately when will Selenium proceed?
4. Does elementToBeClickable() guarantee that the click will succeed if an overlay covers the button?
	 */
	
	public void ques_05()
	{
		/*
		 * 1. No , wait will continue to wait until button becomes clickable. Not just visible.
		 * 
		 * 2. element is visible and enabled
		 * 
		 * 3. At 3rd second.
		 * 
		 * 4. Yes, if element is clickable even with overlay, then yes we can click it- wrong
		 * 
		 * No. An overlay can intercept the click even when Selenium considers the button clickable.

			elementToBeClickable() checks visibility and enabled state. 

			It does not guarantee that another element is not covering the button.

			Selenium may throw ElementClickInterceptedException when you call click().
			
		 */
		WebDriverWait wait =
			    new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement submitButton = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.id("submit")
			    )
			);

			submitButton.click();
	}
	
	/*
	 * Q6. Default Polling and Early Completion
Consider:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("dashboard")
    )
);

Suppose the dashboard becomes visible after approximately three seconds.

Answer the following:
1. What is the default polling interval of WebDriverWait in Selenium Java 4?
2. Will Selenium necessarily wait for all ten seconds?
3. If the condition succeeds after three seconds, what happens?
4. How would you change the polling interval to 200 milliseconds?
	 */
	
	public void ques_06()
	{
		/*
		 * 1. 500 milisecond
		 * 2. No it will wait until the condition is fulfilled.
		 *3.  It will proceed at 3rd second
		 *4.  WebDriverWait wait =
			    new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
		 *
		 */
		WebDriverWait wait =
			    new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.id("dashboard")
			    )
			);
			
			
	}
	
	//Section 3: Fluent Wait — 3 Questions
	
	/*
	 * Q7. Custom Polling and Ignored Exceptions
Consider:
FluentWait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(12))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementException.class);

WebElement element = wait.until(
    d -> d.findElement(By.id("dashboard"))
);

Answer the following:
1. What is the maximum configured timeout?
2. How frequently will Selenium attempt to evaluate the condition?
3. Why is NoSuchElementException ignored?
4. What happens if the element never appears?
5. Does the two-second polling interval guarantee that the condition is evaluated at exactly two-second intervals?
	 */
	
	public void ques_07()
	{
		/*
		 * 1. 12 seconds maximum timeout
		 * 2. 2 seconds polling time.
		 * 3. Because we know element with id dashboard exist but it might show NoSuchElementException due to some overlay 
		 * or something - wrong
		 * 
		 * 
		 * The exception does not mean an overlay is covering the element. It means Selenium could not locate the element.

The exception is ignored so the wait can retry the condition: the dashboard might not have been added to the DOM yet, 
but it could appear during a subsequent poll.

If the exception were not ignored, it could propagate immediately instead of allowing the wait to retry.


		 * 
		 * 4. TimeoutException will be thrown
		 * 5.  yes , it will be evaluated every 2 seconds
		 * 
		 * No. Two seconds is the configured polling interval, not a guarantee of perfectly timed evaluations.

Each evaluation takes time, and scheduling or WebDriver communication overhead can affect when the next evaluation occurs.


		 */
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(12))
		        .pollingEvery(Duration.ofSeconds(2))
		        .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(
		    d -> d.findElement(By.id("dashboard"))
		);
	}
	
	/*
	 * Q8. Wait for a Specific Status
Suppose a status element initially displays "Processing" and eventually changes to "Completed".
FluentWait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);

WebElement status = wait.until(d -> {
    WebElement element = d.findElement(By.id("status"));

    if (element.getText().equals("Completed")) {
        return element;
    }

    return null;
});

Answer the following:
1. Why does the lambda return null while the status is "Processing"?
2. What happens when the status changes to "Completed"?
3. Why is this a custom condition rather than a simple element-presence check?
4. What happens if the status element is never found?
5. Is NoSuchElementException the only exception that this wait can encounter?
	 */
	public void ques_08()
	{
		
	}
}
