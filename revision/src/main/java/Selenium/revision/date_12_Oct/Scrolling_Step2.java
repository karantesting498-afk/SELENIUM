// This class contains scrolling questions
package Selenium.revision.date_12_Oct;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrolling_Step2 {
	WebDriver driver;
	
	
	/*
	 * Q1. Scroll to an element and click it
A web page is very long. A button with id="submitBtn" is located near the bottom of the page.
- How will you scroll until the button becomes visible?
- How will you wait until it is clickable?
- How will you click it and verify that the action succeeded?
- Why might scrollIntoView() followed by click() still fail?
	 */
	
	public void ques_01()
	{
		Actions action = new Actions(driver);
		WebElement submit = driver.findElement(By.id("submitBtn"));

		
		action.scrollToElement(submit).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
		
		action.moveToElement(submit).click().perform();
		
		/*
		 * 3. We can click and verify by usin success message
		 * 
		 * WebElement message = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));

if (message.isDisplayed())
{
    System.out.println("Button action successful");
}



		 * 4. don't know
		 * 
		 * Even after scrolling, a click can fail for several reasons:
- An overlay or sticky header obstructs the button: another element covers the clickable area.
- The element is not yet clickable: it may be disabled or still loading.
- The page layout changes: an animation or asynchronous update moves the button after scrolling.
- The element becomes stale: the DOM changes and the previously located element is no longer attached to it.
- The element is outside the actual usable viewport: scrolling does not guarantee that its clickable center is unobstructed.
		 */
	}
	
	/*
	 * Q2. Scroll inside a modal, not the page
A modal contains 100 employee records and has its own vertical scrollbar. You need to click the Delete button for employee EMP-105, located near the bottom of the modal.

However, your code scrolls the main page instead of the modal.
- Why is this happening?
- How will you scroll the correct container using JavascriptExecutor?
- How would you solve the same problem using the Actions class?
- How will you verify that the correct employee's Delete button was clicked?
	 */
	
	public void ques_02()
	{
		/*
		 * 1. It may be because modal is an iframe.
		 * and user did not switch to iframe. 
		 * 
		 * 1. Why is the main page scrolling instead of the modal?
Your answer:
It may be because modal is an iframe and user did not switch to iframe.

Not necessarily correct. A modal is not automatically an iframe. Most modals are ordinary HTML elements, such as a div, with their own scrollable content.

The main page scrolls when your scrolling action targets the page rather than the modal's scrollable container.

For example, the HTML might look like this:
<div id="employeeModal">
    <div id="employeeList" style="overflow-y: auto; height: 300px;">
        <!-- 100 employee records -->
    </div>
</div>


Here, employeeList is the scrollable container. You must scroll this element, not the main page.

You need to switch to an iframe only if the modal content is actually inside an iframe.



		 * 
		 * 2. code
		 * 
		 * 3. You can scroll directly to the target button using scrollToElement().
WebElement deleteBtn = driver.findElement(
    By.xpath("//tr[td[normalize-space()='EMP-105']]//button[normalize-space()='Delete']")
);

Actions actions = new Actions(driver);

actions.scrollToElement(deleteBtn).perform();


Important distinction: Actions.scrollToElement() scrolls the element into view, but it does not guarantee that a particular nested container will be scrolled in every layout. If the modal's scrollable container is not handled correctly, target the container explicitly with JavaScript.

You could also scroll the modal itself with wheel input:



		 * 
		 * 4. delete success message
		 */
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement employeeList = driver.findElement(By.id("employeeList"));


		executor.executeScript(
			    "arguments[0].scrollTop = arguments[0].scrollHeight;",
			    employeeList
			);
		
		
		WebElement deleteBtn = driver.findElement(
			    By.xpath("//tr[td[normalize-space()='EMP-105']]//button[normalize-space()='Delete']")
			);
		
		deleteBtn.click();
		
		
	}

}
