// This class contains scrolling questions
package Selenium.revision.date_12_Oct;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TimeoutException;
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
	 * Q1. Scroll to an element and click it A web page is very long. A button with
	 * id="submitBtn" is located near the bottom of the page. - How will you scroll
	 * until the button becomes visible? - How will you wait until it is clickable?
	 * - How will you click it and verify that the action succeeded? - Why might
	 * scrollIntoView() followed by click() still fail?
	 */

	public void ques_01() {
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
		 * ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
		 * 
		 * if (message.isDisplayed()) { System.out.println("Button action successful");
		 * }
		 * 
		 * 
		 * 
		 * 4. don't know
		 * 
		 * Even after scrolling, a click can fail for several reasons: - An overlay or
		 * sticky header obstructs the button: another element covers the clickable
		 * area. - The element is not yet clickable: it may be disabled or still
		 * loading. - The page layout changes: an animation or asynchronous update moves
		 * the button after scrolling. - The element becomes stale: the DOM changes and
		 * the previously located element is no longer attached to it. - The element is
		 * outside the actual usable viewport: scrolling does not guarantee that its
		 * clickable center is unobstructed.
		 */
	}

	/*
	 * Q2. Scroll inside a modal, not the page A modal contains 100 employee records
	 * and has its own vertical scrollbar. You need to click the Delete button for
	 * employee EMP-105, located near the bottom of the modal.
	 * 
	 * However, your code scrolls the main page instead of the modal. - Why is this
	 * happening? - How will you scroll the correct container using
	 * JavascriptExecutor? - How would you solve the same problem using the Actions
	 * class? - How will you verify that the correct employee's Delete button was
	 * clicked?
	 */

	public void ques_02() {
		/*
		 * 1. It may be because modal is an iframe. and user did not switch to iframe.
		 * 
		 * 1. Why is the main page scrolling instead of the modal? Your answer: It may
		 * be because modal is an iframe and user did not switch to iframe.
		 * 
		 * Not necessarily correct. A modal is not automatically an iframe. Most modals
		 * are ordinary HTML elements, such as a div, with their own scrollable content.
		 * 
		 * The main page scrolls when your scrolling action targets the page rather than
		 * the modal's scrollable container.
		 * 
		 * For example, the HTML might look like this: <div id="employeeModal"> <div
		 * id="employeeList" style="overflow-y: auto; height: 300px;"> <!-- 100 employee
		 * records --> </div> </div>
		 * 
		 * 
		 * Here, employeeList is the scrollable container. You must scroll this element,
		 * not the main page.
		 * 
		 * You need to switch to an iframe only if the modal content is actually inside
		 * an iframe.
		 * 
		 * 
		 * 
		 * 
		 * 2. code
		 * 
		 * 3. You can scroll directly to the target button using scrollToElement().
		 * WebElement deleteBtn = driver.findElement( By.xpath(
		 * "//tr[td[normalize-space()='EMP-105']]//button[normalize-space()='Delete']")
		 * );
		 * 
		 * Actions actions = new Actions(driver);
		 * 
		 * actions.scrollToElement(deleteBtn).perform();
		 * 
		 * 
		 * Important distinction: Actions.scrollToElement() scrolls the element into
		 * view, but it does not guarantee that a particular nested container will be
		 * scrolled in every layout. If the modal's scrollable container is not handled
		 * correctly, target the container explicitly with JavaScript.
		 * 
		 * You could also scroll the modal itself with wheel input:
		 * 
		 * 
		 * 
		 * 
		 * 4. delete success message
		 */

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement employeeList = driver.findElement(By.id("employeeList"));

		executor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", employeeList);

		WebElement deleteBtn = driver
				.findElement(By.xpath("//tr[td[normalize-space()='EMP-105']]//button[normalize-space()='Delete']"));

		deleteBtn.click();

	}

	/*
	 * Q3. Infinite scrolling with dynamically loaded records A web page loads 20
	 * records initially. More records load whenever you scroll near the bottom. You
	 * need to collect all 200 records. - How will you implement scrolling until all
	 * records are loaded? - Why is checking document.body.scrollHeight only once
	 * insufficient? - How will you wait for newly loaded records without using
	 * Thread.sleep()? - How will you prevent an infinite loop if no more records
	 * are available?
	 */

	public void ques_03() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> records;
		int previousRecordCount = 0;
		int attempt = 0;

		records = driver.findElements(By.id("records"));

		while (records.size() < 200 && attempt < 3) {

			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

			previousRecordCount = records.size();

		    try
	        {
	            wait.until(ExpectedConditions
	                .numberOfElementsToBeMoreThan(
	                    By.id("records"), previousRecordCount));

	            records = driver.findElements(By.id("records"));

	            attempt = 0;
	        }
	        catch (TimeoutException e)
	        {
	            attempt++;

	            records = driver.findElements(By.id("records"));
	        }
	    }
			records = driver.findElements(By.id("records"));

			if (records.size() > previousRecordCount) {
				attempt = 0;
			}

		}
	/*
	 * 1. code
	 * 
	 * 2. checking
	 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); once is
	 * insufficient is because when we are bottom of the page, loader loads next 200
	 * records. but our js script only loaded previous records. so it is not
	 * reliable
	 * 
	 * 3. code 4. code
	 */

/*
 * Q4. StaleElementReferenceException after scrolling
You locate a product element and scroll down. The page then loads more products and rerenders the list. When you click the previously located element, Selenium throws StaleElementReferenceException.

Consider this code:
WebElement product =
    driver.findElement(By.id("product-15"));

JavascriptExecutor js =
    (JavascriptExecutor) driver;

js.executeScript(
    "arguments[0].scrollIntoView(true)", product
);

product.click();


- Why can this code fail?
- How would you redesign it to handle rerendering?
- Should you relocate the element before or after scrolling? Explain your reasoning.
- How would an explicit wait help?
 */
	
	public void ques_04()
	{
		/*
		 * 1. This code fails because we first find the element, and then scroll on the list.
		 * When we scroll andtap on the found element, it's location is changed due to scroll.
		 * That's why we get stale element.
		 * 
		 * 1. Why can the original code fail?

Your explanation:

When we scroll and tap on the found element, its location is changed due to scroll. That's why we get stale element.

Verdict: Partially correct.

The important distinction is that scrolling alone does not normally cause a StaleElementReferenceException.

The exception occurs when the previously located WebElement refers to a DOM element that is no longer attached to the current DOM, for example, because the product list was rerendered after more products loaded.

Your original code stores a reference to the product:

WebElement product = driver.findElement(By.id("product-15"));

If scrolling triggers a rerender that replaces this DOM element, the stored reference becomes stale. Calling product.click() can then throw StaleElementReferenceException.

Remember: An element changing its screen position is not the same as its DOM reference becoming stale.



		 * 
		 * 2. code
		 * 3. Yes we should always re find element after rerendering
		 * 
		 * Locate the element if needed to initiate scrolling.

Scroll to the target.

Re-locate the element using its stable locator, such as By.id("product-15").

Wait until the fresh element is clickable.

Click it.


		 * 4. code
		 */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		while(!found)
		{
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			List<WebElement> records = driver.findElements(By.className("records"));
			

			for(WebElement rec : records)
			{
				if(rec.getAttribute("id").equalsIgnoreCase("product-15"))
				{
					wait.until(ExpectedConditions.elementToBeClickable(rec));
					rec.click();
					found=true;
					break;
				}
			}
			
			
		}
	}
	
	/*
	 * public void ques_04()
{
    JavascriptExecutor js = (JavascriptExecutor) driver;

    WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(5));

    By productLocator = By.id("product-15");

    boolean found = false;
    int attempts = 0;

    while (!found && attempts < 3)
    {
        js.executeScript(
            "window.scrollTo(0, document.body.scrollHeight)"
        );

        try
        {
            WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(productLocator)
            );

            product.click();
            found = true;
        }
        catch (TimeoutException e)
        {
            attempts++;
        }
    }

    if (!found)
    {
        System.out.println("Product was not found or clickable.");
    }
}
	 */
	
	
	/*
	 * Q5. JavaScript scrolling works, but clicking fails
You scroll a Submit button into view using JavaScript. The button is visible, but Selenium throws ElementClickInterceptedException.
- What does this exception indicate?
- How will you investigate overlays, sticky headers, and other elements covering the button?
- How can you determine whether the button is enabled and actually clickable?
- When would you use Actions, and when would JavaScript clicking be justified?

	 */

	public void ques_05()
	{
		/*
		 * 1. This error indicate that there might be some overlay, loader, or something else which makes this button unclciable
		 * 2. Don't know
		 * 
		 * 2. How will you investigate overlays, sticky headers, and other covering elements?

You can investigate this using JavaScript and Selenium.

Step 1: Inspect the element's position and dimensions.

WebElement submit = driver.findElement(By.id("submitBtn"));

JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript(
    "arguments[0].scrollIntoView({block:'center'});",
    submit
);

Centering the button in the viewport can help avoid a sticky header.

Step 2: Identify the element at the button's clickable center.

Object coveringElement = js.executeScript(
    "let r = arguments[0].getBoundingClientRect();" +
    "return document.elementFromPoint(" +
    "r.left + r.width/2, r.top + r.height/2);",
    submit
);

System.out.println(coveringElement);

document.elementFromPoint() returns the topmost element at the specified viewport coordinates. If it returns an overlay or sticky header rather than the button, you have evidence of an obstruction.

This is a diagnostic technique; it does not guarantee that every click obstruction will be detected.

Step 3: Check the overlay.

If the covering element is a loading spinner, wait for it to disappear:

wait.until(ExpectedConditions.invisibilityOfElementLocated(
    By.id("loadingOverlay")
));

Replace loadingOverlay with the actual locator. If a sticky header is covering the button, adjust the scroll position or wait until the layout is stable.



		 * 3. Using wait condition
		 * 4. dont know
		 * 
		 * Use Actions when you need realistic pointer interaction

For example, moving the pointer to the button and clicking:

Actions actions = new Actions(driver);

actions.moveToElement(submit)
       .click()
       .perform();

This is useful when hover behavior or pointer positioning matters. However, Actions does not automatically solve an overlay obstruction.

Use JavaScript clicking only in justified cases
js.executeScript("arguments[0].click();", submit);

JavaScript triggers the element's DOM click behavior directly, bypassing Selenium's normal pointer-based hit-testing. It may be justified for a specific diagnostic or application-specific situation where DOM activation is intentionally what you want to test.

For normal UI automation, do not use JavaScript clicking simply to bypass an intercepted click. It can hide a real usability defect because it does not reproduce a normal user's pointer interaction.
		 * 
		 */
	}

}
