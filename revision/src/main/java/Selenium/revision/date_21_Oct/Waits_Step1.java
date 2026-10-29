// This class contain knowledge regarding wait
package Selenium.revision.date_21_Oct;

public class Waits_Step1 {
	
	/*
	 * 1. Why Do We Need Waits in Selenium?
Web applications don't always load every element immediately.

For example, suppose you click the Login button. The application sends a request to the server, validates the credentials, 
and then displays the dashboard.

If Selenium tries to find the dashboard element before it appears, you might get a NoSuchElementException.

Waits help Selenium handle timing differences between the browser and the application.

Consider this example:
driver.findElement(By.id("loginBtn")).click();

driver.findElement(By.id("dashboard")).click();

If the dashboard hasn't appeared yet, the second statement might fail.


	We can use waits to make Selenium wait for the required condition instead of immediately proceeding.

Selenium has three commonly discussed wait approaches:
1. Implicit Wait
2. Explicit Wait
3. Fluent Wait


====================================================================================================================================


	 */
	
	
	/*
	 * 2. Implicit Wait
	 * 
	 * 
What is Implicit Wait?
An implicit wait tells Selenium to wait for a specified amount of time when searching for elements.

If an element is immediately available, Selenium doesn't wait for the entire duration. 
If the element isn't immediately available, Selenium keeps trying until the element appears or the timeout expires.

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


Required import:
import java.time.Duration;

This configures an implicit wait of 10 seconds for the WebDriver session.


Example
Suppose an element appears after three seconds.
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("https://example.com");

WebElement loginButton = driver.findElement(By.id("loginBtn"));

loginButton.click();

What happens?
- Selenium searches for loginBtn.
- If the element is immediately available, Selenium returns it immediately.
- If it isn't available, Selenium continues searching.
- If it appears within 10 seconds, Selenium returns the element.
- If it doesn't appear before the timeout expires, Selenium throws NoSuchElementException.
Important: Implicit wait applies to element-finding operations.

 It doesn't automatically wait for an element to become clickable, visible, or enabled.


How to configure implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

This sets the implicit wait to five seconds.

To disable it:


driver.manage().timeouts().implicitlyWait(Duration.ZERO);

Advantages
- Easy to configure.
- Applies to element searches throughout the WebDriver session.
- Reduces failures caused by elements appearing slightly later than expected.


Disadvantages
- Doesn't wait for specific conditions such as clickability.
- Can make failures slower because every unsuccessful element search may wait until the timeout.
- Can create confusing timing behavior when mixed with explicit waits.


Interview question
Q: Does implicit wait wait for an element to become clickable?

No. Implicit wait applies to finding elements, not to checking whether they are clickable.


================================================================================================


/*
 * 3. Explicit Wait
What is Explicit Wait?
An explicit wait tells Selenium to wait until a specific condition is satisfied or the timeout expires.

It is particularly useful when an element must become visible, clickable, present in the DOM, or satisfy another supported condition.

Selenium provides WebDriverWait for this purpose.

1. Wait inheritance: WebDriverWait extends FluentWait<WebDriver>, and both support configurable polling.

Syntax
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

Required imports:


import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


Example 1: Wait for an element to be visible
Suppose the dashboard appears after successful login.
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement dashboard = wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("dashboard")
    )
);

How does it work?
1. Selenium starts checking the visibility condition.
2. If the element becomes visible, until() returns the element.
3. If the condition remains unsatisfied, Selenium keeps checking.
4. If the timeout expires, Selenium generally throws TimeoutException.
If the element becomes visible after two seconds, Selenium doesn't need to wait for all ten seconds.



Example 2: Wait until an element is clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement loginButton = wait.until(
    ExpectedConditions.elementToBeClickable(
        By.id("loginBtn")
    )
);

loginButton.click();

This condition checks whether the element is visible and enabled.

Important: Passing this condition doesn't guarantee that the click will succeed.
 An overlay, animation, or DOM change can still interfere with the click.


Example 3: Wait for an element to disappear
Suppose a loading spinner appears while the page loads.
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(
    ExpectedConditions.invisibilityOfElementLocated(
        By.id("loadingSpinner")
    )
);

Selenium waits until the spinner becomes invisible or is no longer present.


Common Explicit Wait Conditions


Expected Condition											Purpose

presenceOfElementLocated()									Waits until the element exists in the DOM.

visibilityOfElementLocated()								Waits until the element exists and is visible.

elementToBeClickable()										Waits until the element is visible and enabled.

invisibilityOfElementLocated()								Waits until the element is invisible or absent.

titleContains()												Waits until the browser title contains specified text.

alertIsPresent()											Waits until an alert is present.

textToBePresentInElementLocated()							Waits until an element contains specified text.

urlContains()												Waits until the current URL contains specified text.

frameToBeAvailableAndSwitchToIt()							Waits for a frame to be available and switches into it.



Important difference: Presence vs Visibility

Suppose an element exists in the HTML but is hidden using CSS.
- presenceOfElementLocated() can succeed.
- visibilityOfElementLocated() won't succeed until the element becomes visible.
This distinction is frequently tested in Selenium interviews.

Advantages

- Waits for a specific condition.
- Usually makes test failures easier to understand.
- Supports common conditions such as visibility, clickability, and text presence.
- Can wait for elements or changes in browser state.

Disadvantages

- Requires you to identify the appropriate condition.
- You may need to configure waits at different points in your test.
- A condition becoming true doesn't guarantee that every subsequent browser interaction will succeed.

============================================================================================================


 */
	 
	/*
	 * 4. Fluent Wait
	 * 
	 * 
What is Fluent Wait?
Fluent Wait allows you to configure:
1. The maximum time to wait.
2. How frequently Selenium checks the condition.
3. Which exception types should be ignored while waiting.


	It is useful when you want more control over polling behavior or exception handling.

In Selenium Java, FluentWait is a general-purpose wait implementation. 

WebDriverWait extends FluentWait<WebDriver> and provides WebDriver-specific behavior.


Example
Suppose an element might take up to 20 seconds to appear. You want Selenium to check every two seconds.
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

FluentWait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementException.class);

WebElement element = wait.until(
    d -> d.findElement(By.id("dashboard"))
);

element.click();


Additional import:
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

How does it work?
- Timeout: Selenium will wait for up to 20 seconds.
- Polling interval: Selenium will check approximately every two seconds.
- Ignored exception: NoSuchElementException will not immediately terminate the wait.
- Condition: The lambda searches for the dashboard element.
- Success: Once the element is found, until() returns it.
If the element never appears, the wait eventually times out.

The actual time at which the wait stops can differ slightly from the configured timeout because of 
polling and the time taken by individual condition evaluations.

Fluent Wait with a Custom Condition
Suppose a status element must display "Completed".
FluentWait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementException.class);

WebElement status = wait.until(d -> {
    WebElement element = d.findElement(By.id("status"));

    if (element.getText().equals("Completed")) {
        return element;
    }
    
    
    
    	The lambda returns the element when the required condition is satisfied. Returning null tells until() to keep waiting.

Note: This example handles a missing element through the configured ignored exception. 

It does not automatically handle every possible exception, such as StaleElementReferenceException.


	 */
	
	
	/*
	 * 5. Implicit vs Explicit vs Fluent Wait
	 * 
	 * 
	 * 
This comparison is important for interviews.

Feature					Implicit Wait								Explicit Wait									Fluent Wait
Main purpose			Waits during element searches				Waits for a specific condition					Waits for a condition with configurable polling and exception handling

Configuration			implicitlyWait()							WebDriverWait									FluentWait

Maximum timeout			Configurable								Configurable									Configurable

Polling interval		Not normally configured by the user			Configurable through its FluentWait methods		Configurable

Specific conditions		No											Yes												Yes, including custom conditions

Exception handling		No per-wait ignored-exception 
						configuration								Supports configurable ignored exceptions 
																	through its inherited methods	
																													Supports configurable ignored exceptions
																													
Typical example	Finding an element	Waiting until a button is clickable	Waiting for a custom status while ignoring a specified exception
	 */
	
	/*
	 * The key relationship
Remember this:

WebDriverWait is a specialized form of FluentWait<WebDriver>.

Therefore, Fluent Wait isn't an entirely separate mechanism unrelated to Explicit Wait. Both can wait for specific conditions;
 Fluent Wait exposes the general-purpose configuration that WebDriverWait builds upon.
 
	 */
	
	
	/*
	 * Q1. Difference between Implicit and Explicit Wait
Your answer:
Implicit wait is handled globally whereas explicit wait is customized for every wait condition.

Implicit wait only works for searching element in DOM while explicit can work for clickable, visibility, invisibility, etc.

Result: Correct ✅

You've explained the two most important differences.

A slightly more polished interview answer would be:
- Implicit Wait: Sets a global timeout for element-finding operations throughout the WebDriver session.
- Explicit Wait: Waits until a specific condition is satisfied, such as visibility, clickability, or text presence.
Example:
// Implicit wait
driver.manage().timeouts()
      .implicitlyWait(Duration.ofSeconds(10));

// Explicit wait
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement button = wait.until(
    ExpectedConditions.elementToBeClickable(
        By.id("submit")
    )
);

Interview tip: Explicit wait is generally preferred for condition-specific synchronization because it lets you wait for the exact state your test requires.


Q2. presenceOfElementLocated() vs visibilityOfElementLocated()
Your answer:
Presence means, element present in the DOM. But visibility means visibility of the element in the DOM.

Result: Mostly correct ⚠️

Your understanding is correct, but the definition of visibility needs to be more precise.


Presence											Visibility
The element exists in the DOM.						The element exists in the DOM and is visible.
It may be hidden.									It must be displayed and have non-zero dimensions.
Does not guarantee that the user can see it.		Checks whether the element is visible.


Consider:
<button id="submit" style="display:none;">
    Submit
</button>

The element exists in the DOM but is hidden.

Therefore:
- presenceOfElementLocated() can succeed.
- visibilityOfElementLocated() will not succeed while the element remains hidden.
Important: Visibility does not guarantee that an element is clickable. It might still be disabled or obstructed by another element.


Q3. Default Polling Interval of WebDriverWait
Your answer:
1 second.

Result: Incorrect ❌

In Selenium Java 4, the default polling interval of WebDriverWait is 500 milliseconds (0.5 seconds).

For example:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

Unless you change the polling interval, Selenium checks the condition approximately every 500 milliseconds.

You can configure it using:
wait.pollingEvery(Duration.ofSeconds(2));

This changes the polling interval to two seconds.

Remember for interviews:
- Default polling interval: 500 milliseconds
- Configurable polling interval: Yes
- Maximum timeout: Specified when constructing the wait

how to configure?

// Sets a 30-second timeout with a 2-second polling interval
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(2));



Q4. Can We Use Implicit and Explicit Waits Together?
Your answer:
We can use both together but it is discouraged as wait time will increase as the sum of both.

Result: Partially correct ⚠️

You're right that combining them is generally discouraged, but the explanation that their timeouts simply add together is not accurate.

The actual behavior depends on how the waits and element lookups interact.

For example:
driver.manage().timeouts()
      .implicitlyWait(Duration.ofSeconds(10));

WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(15));

wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("dashboard")
    )
);

The explicit wait repeatedly evaluates its condition. That condition performs an element lookup, which can itself be affected by the implicit wait.

As a result, an individual condition evaluation may take a substantial amount of time, causing the overall wait to exceed the expected explicit timeout.

The delay is not necessarily the sum of the two configured timeouts.

Best practice: Keep implicit wait at zero and use explicit waits where needed, rather than mixing both mechanisms.



Q5. NoSuchElementException vs TimeoutException
Your answer:
NoSuchElement exception means element not found on the DOM, timeout means element not visible or clickable until the wait time.

Result: Mostly correct ⚠️

The main distinction is correct, but TimeoutException is not limited to visibility or clickability.
Exception	Meaning
NoSuchElementException	An element lookup failed to find a matching element.
TimeoutException	A wait did not satisfy its required condition within the configured timeout.


Example 1: NoSuchElementException
driver.findElement(By.id("unknownElement"));

If no matching element exists and the implicit wait expires, Selenium throws NoSuchElementException.
Example 2: TimeoutException
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(5));

wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("dashboard")
    )
);

If the dashboard never becomes visible within the timeout, Selenium throws TimeoutException.

Other conditions can also time out, such as waiting for an alert, a particular URL, or specific text.

Key difference: NoSuchElementException relates to a failed element lookup;

 TimeoutException relates to a wait condition that did not succeed in time.
 
 
 Q6. Relationship Between WebDriverWait and FluentWait
Your answer:
WebDriverWait is part of Fluent Wait. In Fluent Wait we can set polling time which is not possible in explicit wait. In Fluent Wait we can add exception to be ignored which is also not possible in explicit wait.

Result: Partially correct ⚠️

You correctly identified their relationship and the main configuration options. However, there is one important misconception.

WebDriverWait extends FluentWait<WebDriver>.

In other words, WebDriverWait is a specialized form of FluentWait for WebDriver.

Both support:
- Configurable timeout.
- Configurable polling interval.
- Configurable ignored exceptions.
- Waiting for a condition.
For example, you can configure the polling interval of WebDriverWait too:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

wait.pollingEvery(Duration.ofMillis(300));

You can also configure ignored exceptions through its inherited methods.
wait.ignoring(NoSuchElementException.class);

The difference is that WebDriverWait provides WebDriver-specific behavior, including ignoring NotFoundException by default.

Interview answer: WebDriverWait extends FluentWait<WebDriver> and provides a WebDriver-specific implementation of condition-based waiting.


Q7. Why Use a Custom Fluent Wait Condition?
Your answer:
We are working on a form. When we click on verify email button, then success message is displayed after verifying on backend. We need to test the success message. In explicit wait we can add visibility of message condition and it will check for msg every second, but we know sometimes success msg takes time to be visible. So through this we can add custom polling time.

Result: Good understanding, with one correction ✅

Your example is realistic. Waiting for a backend verification message is a good synchronization scenario.

However, you can configure polling with WebDriverWait as well. A custom Fluent Wait condition is useful when the condition itself requires custom logic, not just a different polling interval.

For example, suppose the status element must display "Verified".
FluentWait<WebDriver> wait =
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(NoSuchElementException.class);

String status = wait.until(d -> {
    WebElement element =
        d.findElement(By.id("emailStatus"));

    String text = element.getText();

    return "Verified".equals(text) ? text : null;
});

Here:
1. Selenium searches for the status element.
2. It reads the text.
3. If the text is "Verified", the wait succeeds.
4. Otherwise, it keeps waiting until the condition succeeds or times out.
Key lesson: Use a custom condition when you need to wait for a specific application state that a built-in expected condition does not directly cover.


Q8. Element Is Visible but Disabled
Your answer:
No, it will not succeed. Because our element is only visible and it is disabled, so clickable condition will fail.

Result: Correct ✅

ExpectedConditions.elementToBeClickable() checks that the element is visible and enabled.

For example:
WebElement button = wait.until(
    ExpectedConditions.elementToBeClickable(
        By.id("submit")
    )
);

If the button remains disabled, the condition will not succeed.

One important nuance: the condition checks visibility and enabled state. It does not guarantee that another element won't obstruct the click.


Q9. Condition Never Becomes True
Your answer:
It will throw timeout exception.

Result: Correct ✅

If the condition never becomes true within the configured timeout, Selenium throws TimeoutException.

Example:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(5));

wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("elementThatNeverAppears")
    )
);

If the element never becomes visible, the wait eventually times out.

The exception can be handled using try-catch, but you should not catch and ignore it without reporting the failure appropriately.


Q10. Element Appears After Three Seconds
Your answer:
No, Selenium will continue after element appears at 3 sec.

Result: Correct ✅

Suppose your wait is configured for 10 seconds and the element appears after 3 seconds.

Selenium returns as soon as the condition succeeds. It does not wait for the full 10 seconds.

Example:
WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.id("dashboard")
    )
);

If the element becomes visible after 3 seconds, the wait finishes shortly after that condition is detected.

The 10 seconds represents the maximum timeout, not a mandatory delay.








	 */

}
