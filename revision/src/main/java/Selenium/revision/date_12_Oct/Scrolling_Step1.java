// this class contains knowledge regarding the scrolling
package Selenium.revision.date_12_Oct;

public class Scrolling_Step1 {

	
	/*
	 * 1. Why do we need scrolling?
Scrolling is required when an element is outside the visible viewport or when the application loads content dynamically as the user scrolls.

Common scenarios:
- Clicking a button at the bottom of a long page.
- Filling a form with fields below the fold.
- Handling infinite-scroll pages.
- Scrolling inside a specific container or modal.
- Verifying elements that appear only after scrolling.
	 */
	
	/*
	 * 2. Different ways to scroll
Method										Best use case
JavaScriptExecutor							Scroll to an element, page position, or specific coordinates
Actions class								Wheel-based scrolling and user-like interactions
Keyboard keys								Scroll using PAGE_DOWN, HOME, END, or arrow keys
WebElement scrolling						Scroll within a particular element/container
	 */
	
	/*
	 * 3. Method 1 — JavaScriptExecutor
JavascriptExecutor is one of the most commonly used approaches for precise scrolling.

First, create the executor:
JavascriptExecutor js =
    (JavascriptExecutor) driver;


A. Scroll down by pixels
js.executeScript("window.scrollBy(0, 500)");


- 0 = horizontal scroll distance.
- 500 = vertical scroll distance in pixels.
- Positive vertical values scroll down; negative values scroll up.
B. Scroll to the bottom of the page
js.executeScript(
    "window.scrollTo(0, document.body.scrollHeight)"
);


document.body.scrollHeight represents the height of the document body.
C. Scroll to the top
js.executeScript("window.scrollTo(0, 0)");


D. Scroll to a specific element
WebElement element =
    driver.findElement(By.id("submitBtn"));

js.executeScript(
    "arguments[0].scrollIntoView(true)",
    element
);


- arguments[0] refers to the first argument passed to executeScript().
- Here, the first argument is the element WebElement.
- true aligns the element with the top of the viewport.
To align it near the bottom instead:
js.executeScript(
    "arguments[0].scrollIntoView(false)",
    element
);


Interview point: Scrolling an element into view does not guarantee that it is clickable. Overlays, animations, disabled states, and sticky headers can still prevent interaction.
E. Scroll to an element and click it
WebElement button =
    driver.findElement(By.id("submitBtn"));

js.executeScript(
    "arguments[0].scrollIntoView({block: 'center'})",
    button
);

button.click();


Prefer Selenium's normal click() after scrolling. Use JavaScript clicking only when there is a specific reason, because it can bypass normal user-interaction behavior.
	 */
	
	/*
	 * 4. Method 2 — Actions class
The Actions class supports wheel input and other user-like interactions.
A. Scroll down
Actions actions = new Actions(driver);

actions.scrollByAmount(0, 500).perform();


B. Scroll up
actions.scrollByAmount(0, -500).perform();


C. Scroll until an element is in view
WebElement element =
    driver.findElement(By.id("submitBtn"));

new Actions(driver)
    .scrollToElement(element)
    .perform();


Remember: Call .perform() to execute the built action.
	 */
	
	/*
	 * 5. Method 3 — Keyboard scrolling
Keyboard scrolling is useful when the page or a scrollable element has keyboard focus.
driver.findElement(By.tagName("body"))
      .sendKeys(Keys.PAGE_DOWN);


Other useful keys:
Keys.PAGE_UP
Keys.HOME
Keys.END
Keys.ARROW_DOWN
Keys.ARROW_UP


Example:
driver.findElement(By.tagName("body"))
      .sendKeys(Keys.END);


This approach depends on focus and page behavior. It may not scroll the intended container if focus is elsewhere.
	 */
	
	/*
	 * 6. Scrolling inside a specific container
Suppose a page contains a scrollable table or modal, and you need to scroll inside that container rather than the whole page.
Using JavaScript
WebElement container =
    driver.findElement(By.id("tableContainer"));

js.executeScript(
    "arguments[0].scrollTop = arguments[0].scrollHeight",
    container
);


To scroll the container by 300 pixels:
js.executeScript(
    "arguments[0].scrollTop += 300",
    container
);


To scroll horizontally:
js.executeScript(
    "arguments[0].scrollLeft = arguments[0].scrollWidth",
    container
);


Key distinction:
- window.scrollBy() scrolls the page viewport.
- element.scrollTop scrolls vertically inside that element.
- element.scrollLeft scrolls horizontally inside that element.
	 */
	
	/*
	 * 7. Handling infinite scrolling
On an infinite-scroll page, additional records may load when you reach the bottom. A single scroll may not be enough.

Example approach:
JavascriptExecutor js =
    (JavascriptExecutor) driver;

long previousHeight = 0;

while (true) {
    long currentHeight = (long) js.executeScript(
        "return document.body.scrollHeight"
    );

    if (currentHeight == previousHeight) {
        break;
    }

    previousHeight = currentHeight;

    js.executeScript(
        "window.scrollTo(0, document.body.scrollHeight)"
    );

    // In real tests, wait for new content or
    // for the loading indicator to disappear.
}


This illustrates the basic idea, but it is not a complete synchronization strategy. Some sites load content after a delay, and some stop loading when a particular record count is reached. Use explicit waits for the application's actual loading condition when possible.
	 */
	
	/*
	 * 8. Important interview differences
Question	Answer
Does scrollIntoView() click an element?	No. It only scrolls the element into view.
Does scrolling guarantee a successful click?	No. Other interactability issues may remain.
Is Thread.sleep() the preferred way to wait after scrolling?	No. Prefer explicit waits for a meaningful condition.
How do you scroll within a modal?	Scroll the modal's scrollable element, not necessarily the page.
How do you scroll to the bottom?	Use window.scrollTo() or scroll the relevant container to its scrollHeight.
Can scrolling trigger lazy loading?	Yes. Applications often load content when elements approach the viewport.
Can JavaScript scrolling behave differently from user scrolling?	Yes. JavaScript changes scroll position directly, while wheel and keyboard input more closely resemble user actions.
	 */
	/*
	 * 9. Common mistakes to avoid
1. Using page scrolling when the target is inside a scrollable table or modal.
2. Finding an element once and reusing a stale reference after the page rerenders.
3. Assuming an element is clickable immediately after scrolling.
4. Using fixed pixel scrolling when the target element can be located directly.
5. Using JavaScript click as the first solution to every click failure.
6. Using fixed sleeps instead of waiting for the expected content or state.
	 */
	
	/*
	 * 
	 */
}
