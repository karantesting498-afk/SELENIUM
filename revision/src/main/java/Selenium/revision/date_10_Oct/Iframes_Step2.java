// This class contains iframes question
package Selenium.revision.date_10_Oct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Iframes_Step2 {
	
	WebDriver driver;
	
	/*
	 * Q1. Multiple iframes with similar attributes
A page contains three iframes:
<iframe title="Payment" src="/payment/card"></iframe>
<iframe title="Payment" src="/payment/wallet"></iframe>
<iframe title="Offers" src="/offers"></iframe>


Your task is to switch specifically into the card payment iframe and enter a card number.
- How will you uniquely identify the correct iframe?
- Why could driver.switchTo().frame("Payment") fail?
- Write the Selenium Java code without relying on a hardcoded frame index.
- How would you handle the situation if the iframe's src changes dynamically?
	 */
	
	public void ques_01()
	{
		/*
		 * 1. WebElement cardPayment = driver.findElement(By.xpath("//iframe[@src='/payment/card']"));
		 * We can identify using this x path.
		 * 
		 * 2. driver.switchTo().frame("Payment") fail? because frame("parameter")here paramter should be either id or name.
		 * But in html payment is only title.
		 * 
		 * 3. WebElement cardPayment = driver.findElement(By.xpath("//iframe[@src='/payment/card']"));
		 * 
		 * 4. don't know
		 * 
		 * Use a stable attribute if one exists, such as a unique id, name, or another reliable attribute. 
		 * If the src changes but continues to contain a stable path fragment, you could use:

WebElement cardPayment = driver.findElement(
    By.xpath("//iframe[contains(@src, '/payment/card')]")
);

This works only if that fragment remains stable and uniquely identifies the card iframe.

Important: If the src changes to an entirely different value, contains() will not solve the problem.
 Identify the iframe through another stable attribute or a reliable relationship with its surrounding elements.
		 */
	}
	
	/*
	 * Q2. Iframe reloads after clicking a button
You switch into an iframe and click a button named Continue. After the click, the iframe reloads and displays a new input field with ID otp.
driver.switchTo().frame("verificationFrame");
driver.findElement(By.id("continue")).click();

driver.findElement(By.id("otp")).sendKeys("123456");


The test intermittently throws NoSuchElementException or StaleElementReferenceException.
- Why might these exceptions occur?
- Does Selenium automatically switch back to the main page when an iframe reloads?
- How would you wait for the new iframe content and enter the OTP reliably?
- Would storing the OTP field as a WebElement before clicking Continue be safe?
	 */
	
	public void ques_02()
	{
		/*
		 * 1. Exception occur because of wait time during reload, selenium is not able find the opt field.
		 * 
		 * 1. Why might the exceptions occur?

Your explanation is partly correct. The problem is not simply that Selenium needs more waiting time.

NoSuchElementException: Selenium searches for otp while the new input is not yet present or accessible in the current browsing context.

StaleElementReferenceException: Selenium tries to use a previously located element that is no longer attached to the current DOM.

An iframe reload can temporarily remove its old content and create new elements.


		 * 
		 * 2. no , selenium focus remain on iframe unless we manually move it main page.
		 * 
		 * 3. We can add wait condtion for iframe - frameToBeAvailableAndSwitchToIt
		 * 
		 * Your answer mentions frameToBeAvailableAndSwitchToIt(), which is useful when the iframe itself must be located or re-entered. However, if you are already inside the same iframe and it reloads, you should also wait for the new OTP field to become available.

For example:

WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

driver.switchTo().frame("verificationFrame");

driver.findElement(By.id("continue")).click();

WebElement otp = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("otp"))
);

otp.sendKeys("123456");

This approach assumes the iframe remains the current browsing context and Selenium can locate the new OTP field inside it. If the application replaces the iframe element itself, you should wait for that replacement and switch into the new iframe before locating the OTP field.
		 * 
		 * 4. no, it will not be safe because otp field is displayed after continue button is clicked
		 */
		
		
		
	}

	
	/*
	 * Q3. Iframe inside Shadow DOM
A web application has this structure:
Main Page
 └── Shadow Host
      └── Shadow Root
           └── iframe#loginFrame
                └── input#username


The iframe cannot be located using:
driver.findElement(By.id("loginFrame"));


Your task is to enter a username inside the iframe.
- Why does the normal locator fail?
- How can Selenium 4's getShadowRoot() help?
- Write the Java code to locate the iframe inside the Shadow DOM, switch into it, and enter the username.
- After switching into the iframe, can you directly use the original Shadow Root to locate username? Explain.
	 */
	
	public void ques_03()
	{
		/*
		 * 1. driver.findElement(By.id("loginFrame")); when we are searching login frame using this id, it will fail because
		 * currently selenium focus is on the main page, whereas loginframe exist in the frame. not on main page.
		 * to enter username we have to first switch focus to loginframe and then input username.
		 * 
		 * 1. Why does the normal locator fail?

You wrote that Selenium's focus is on the main page and the iframe is inside another frame. That is the main misconception.

The iframe is inside a Shadow DOM, not necessarily inside another iframe. A normal call such as:

driver.findElement(By.id("loginFrame"));

searches the regular document DOM. It does not automatically penetrate a Shadow DOM boundary to find elements inside the shadow root.



		 * 
		 * 
		 * 2. don't know
		 * 
		 * 2. How does getShadowRoot() help?

Selenium 4 provides getShadowRoot() on a WebElement representing the shadow host. It returns a SearchContext that you can use to locate elements inside that shadow root.



		 * 
		 * 4. No we cannot use shadow root to access username as username is in iframe.
		 * we ahve to first switch to iframe to locate username.
		 */
		
		WebElement shadowRoot = driver.findElement(By.id("shadow_root"));
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='loginFrame']"));
		
		driver.switchTo().frame(frame);
		
		WebElement input = driver.findElement(By.id("username"));
		
		input.sendKeys("username");
		
		
/*
 * 3. // Locate the shadow host in the regular DOM
WebElement shadowHost =
    driver.findElement(By.id("shadowHost"));

// Access the shadow root
SearchContext shadowRoot = shadowHost.getShadowRoot();

// Locate the iframe inside the shadow root
WebElement frame =
    shadowRoot.findElement(By.id("loginFrame"));

// Switch into the iframe
driver.switchTo().frame(frame);

// Locate the input inside the iframe
WebElement username =
    driver.findElement(By.id("username"));

username.sendKeys("username");

 */
		
		
	}
	
	/*
	 * Q4. Cross-origin iframe security
The main application runs on:
https://example.com
The embedded payment iframe runs on:
https://payments.example.net
You need to enter payment details inside the iframe.
- Can Selenium WebDriver switch into an iframe hosted on a different origin?
- Would the browser's same-origin policy prevent Selenium from interacting with its elements?
- What limitations might apply if you use JavascriptExecutor to access the iframe's document?
- If the iframe is present but its content is controlled by a third-party payment provider, what practical issues might still prevent automation?
	 */
	
	public void ques_04()
	{
		/*
		 * 1. don't know
		 * 2. don't know
		 * 3. don't know
		 * 4. don't know
		 * 
		 * 1. Can Selenium switch into a cross-origin iframe?

Yes. Selenium WebDriver can switch into an iframe hosted on a different origin, provided the iframe is accessible and the browser and application permit the interaction.

WebElement paymentFrame =
    driver.findElement(By.cssSelector("iframe.payment-frame"));

driver.switchTo().frame(paymentFrame);

driver.findElement(By.id("cardNumber"))
      .sendKeys("1234567890123456");

The selector and input ID are illustrative.

2. Does the same-origin policy prevent Selenium from interacting with its elements?

Not directly.

The browser's same-origin policy primarily restricts JavaScript running in one origin from accessing certain resources and DOM content belonging to another origin.

WebDriver's frame-switching and element-location commands operate through the WebDriver protocol. Therefore, cross-origin status alone does not prevent Selenium from interacting with an iframe's elements.

3. What limitations apply to JavascriptExecutor?

JavaScript executed in the main page generally cannot directly access a cross-origin iframe's document through properties such as:

iframe.contentDocument

The browser's same-origin policy restricts that access.

After switching into the iframe, Selenium can execute JavaScript in the frame's current browsing context, subject to browser and application restrictions. That is different from trying to access the cross-origin iframe's document directly from the parent page.

4. What practical issues might prevent automation?

Even when WebDriver can switch into the iframe, automation may face:

CAPTCHA or bot-detection challenges.

Third-party payment flows that restrict automated testing.

Dynamic iframe loading or replacement.

Authentication, redirects, or additional verification.

Elements that are hidden, disabled, or not yet interactable.

Payment-provider restrictions or test-environment requirements.

For payment testing, use the provider's supported sandbox and test credentials rather than real payment details.
		 */
	}
	
	/*
	 * Q5. Switching between sibling iframes
Consider this structure:
Main Page
 └── Frame A
      ├── Frame B
      │    └── Button: Save
      └── Frame C
           └── Text: Success


You are currently inside Frame B. After clicking Save, you need to read the Success text inside Frame C.
- Why can't you directly switch from Frame B to Frame C using frame("frameC")?
- Write the correct sequence of frame-switching commands.
- After reading Success, how would you return to Frame A and interact with another element there?
- Explain the difference between switching to a sibling frame and switching to a child frame.
	 */
	public void ques_05()
	{
		/*
		 * 1. We cannot directly switch between sibling frames.
		 * We have to go back to parent and then switch to sibling
		 * 
		 * 2. driver.switchTo().parentFrame();
		 * WebElement frameB = driver.findElement(By.xpath(//iframe[@id='text']));
		 * driver.switchTo().frame(frameB);
		 * 
		 * 3. using parentFrame() method
		 * 
		 * 4. In parent to child switch we can directly switch using child frame location
		 * but in sibling switch we have to first go back to parent frame and then switch to sibling
		 * 
		 * 4. Child frame versus sibling frame

Your explanation is correct, with one clarification.

Operation

	

Correct approach




Parent frame → child frame

	

Locate the child iframe and switch into it




Child frame → parent frame

	

parentFrame()




One child frame → sibling frame

	

parentFrame(), then locate and switch to the sibling




Any nested frame → main document

	

defaultContent()

One important detail: parentFrame() moves up exactly one frame level. defaultContent() returns directly to the main document, regardless of nesting depth.



		 */
	}
	
	/*
	 * Q6. Dynamic iframe selection with explicit waits
A page initially contains one iframe. After clicking a category dropdown, the application replaces it with another iframe. Both iframes use the same ID, contentFrame, during the transition.
Your current code is:
driver.findElement(By.id("category")).click();

driver.switchTo().frame(
    driver.findElement(By.id("contentFrame"))
);

driver.findElement(By.id("result")).click();


This test is flaky: sometimes it interacts with the old iframe, and sometimes it fails because the iframe is not ready.
- Why can duplicate or temporarily overlapping iframe elements cause problems?
- How would you wait for the old iframe to become stale before switching to the replacement?
- How would you use ExpectedConditions.stalenessOf() and frameToBeAvailableAndSwitchToIt() together?
- Why is an explicit wait more reliable here than Thread.sleep()?
	 */
	
	public void ques_06()
	{
		/*
		 * 1. We are location frames using same locator that's why we are having issues during duplicate frame.
		 * 
		 * 
		 * 1. Why can duplicate or overlapping iframe elements cause problems?

Your answer is partially correct.

The issue is not merely that the same locator is used. Both old and new iframes share the same ID, contentFrame, during the transition.

If both temporarily exist, this locator:

driver.findElement(By.id("contentFrame"));

may return the old iframe because findElement() returns the first matching element in the current search context.

If the old iframe has already been removed, a previously stored reference to it may become stale.


		 * 2. By adding stalenessOfelemet condition
		 * 
		 * First, store a reference to the old iframe before clicking the category dropdown.

Then wait for that element to become stale using ExpectedConditions.stalenessOf().



		 * 
		 * 3. We first wait for old frame to be stale , then frameToBeAvailableAndSwitchToIt condition for next frame to be available.
		 * 
		 * WebDriverWait wait =
    new WebDriverWait(driver, Duration.ofSeconds(10));

// Store the old iframe before triggering replacement
WebElement oldFrame =
    driver.findElement(By.id("contentFrame"));

// Trigger the iframe replacement
driver.findElement(By.id("category")).click();

// Wait until the old iframe is detached from the DOM
wait.until(ExpectedConditions.stalenessOf(oldFrame));

// Wait for the replacement iframe and switch into it
wait.until(
    ExpectedConditions.frameToBeAvailableAndSwitchToIt(
        By.id("contentFrame")
    )
);

// Interact with the new iframe
wait.until(
    ExpectedConditions.elementToBeClickable(By.id("result"))
).click();



		 * 
		 *  4. 
		 *  Your answer is correct in principle, but saying explicit waits are more reliable in every scenario is too broad.

Explicit wait: Repeatedly checks a specified condition until it succeeds or times out.

Thread.sleep(): Pauses for a fixed duration without checking whether the required condition has occurred.

For example, if the iframe loads in 500 milliseconds, an explicit wait can proceed immediately. If it takes 4 seconds, the wait can continue checking until the condition succeeds, subject to the timeout.

A fixed sleep may be unnecessarily long or too short for the actual loading time.
		 */
	}
}
