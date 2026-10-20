// This class contains knowledge about iframes

package Selenium.revision.date_10_Oct;

public class Frames_Step_1 {

/*
 * In Selenium, an iframe is a webpage or HTML document embedded inside another webpage.
Think of it like this:
Main Page
│
├── Header
├── Menu
├── Normal Elements
│
└── iframe
      │
      ├── Input
      ├── Button
      └── Other Elements

If an element is inside an iframe, 
Selenium cannot directly interact with it from the main page. You first need to switch Selenium's control into that iframe.

=============================================================================================================================
Basic iframe example
HTML:
<html>
<body>

    <h1>Main Page</h1>

    <iframe id="employeeFrame" name="employeeFrame">

        <!-- Separate embedded document -->

    </iframe>

</body>
</html>

Inside that iframe there could be:
<input id="username">
<button id="save">Save</button>

If Selenium is currently on the main page, this may fail:
driver.findElement(By.id("username"));

because username is inside the iframe.
You first switch:
driver.switchTo().frame("employeeFrame");

Then:
driver.findElement(By.id("username"))
      .sendKeys("Karan");


=============================================================================================================================


Ways to switch into an iframe
Selenium provides three common ways.
1. Using index
driver.switchTo().frame(0);

The index starts from:
0

So:
driver.switchTo().frame(0); // first frame
driver.switchTo().frame(1); // second frame
driver.switchTo().frame(2); // third frame

This is different from XPath indexing, which starts from 1.
However, frame index is generally less reliable because if page structure changes, the frame number can change.

=============================================================================================================================


2. Using id or name
Suppose:
<iframe id="employeeFrame"
        name="employeeFrame">
</iframe>

You can switch using:
driver.switchTo().frame("employeeFrame");

Selenium can use the iframe's id or name.
This is usually cleaner than index if the identifier is stable.

=============================================================================================================================


3. Using WebElement
This is commonly used in real automation.
WebElement frame =
        driver.findElement(By.id("employeeFrame"));

driver.switchTo().frame(frame);

Then:
driver.findElement(By.id("username"))
      .sendKeys("Karan");

So the flow becomes:
Locate iframe
↓
Store it in WebElement
↓
switchTo().frame(frame)
↓
Interact with elements inside iframe

=============================================================================================================================



Complete example
WebDriver driver = new ChromeDriver();

driver.get("https://example.com");

WebElement frame =
        driver.findElement(By.id("employeeFrame"));

driver.switchTo().frame(frame);

driver.findElement(By.id("username"))
      .sendKeys("Karan");

driver.findElement(By.id("save"))
      .click();

At this point Selenium is still inside the iframe.

=============================================================================================================================


Return to main page
To leave the iframe and return to the main/default page:
driver.switchTo().defaultContent();

Example:
driver.switchTo().frame("employeeFrame");

driver.findElement(By.id("username"))
      .sendKeys("Karan");

driver.switchTo().defaultContent();

driver.findElement(By.id("logout"))
      .click();

Here:
frame()
→ enter iframe

defaultContent()
→ return all the way to main page

=============================================================================================================================


parentFrame()
Selenium also provides:
driver.switchTo().parentFrame();

This becomes important with nested iframes.
Suppose:
Main Page
   │
   └── Frame A
         │
         └── Frame B

You are inside Frame B.
If you use:
driver.switchTo().parentFrame();

you go:
Frame B
   ↑
Frame A

But:
driver.switchTo().defaultContent();

takes you:
Frame B
   ↑
Main Page

So:
parentFrame()
→ one frame level upward

defaultContent()
→ directly back to main document

=============================================================================================================================
Nested iframe
Example structure:
<iframe id="outerFrame">

    <iframe id="innerFrame">

        <button id="save">Save</button>

    </iframe>

</iframe>

You cannot directly switch from main page to innerFrame if it is inside outerFrame.
You usually switch level by level:
driver.switchTo().frame("outerFrame");

driver.switchTo().frame("innerFrame");

driver.findElement(By.id("save")).click();

Flow:
Main Page
↓
Outer Frame
↓
Inner Frame
↓
Save button

To return one level:
driver.switchTo().parentFrame();

Now you're inside:
Outer Frame

To return to the main page:
driver.switchTo().defaultContent();

=============================================================================================================================


Why NoSuchElementException commonly happens with iframe
Suppose:
<iframe id="paymentFrame">

    <input id="cardNumber">

</iframe>

You do:
driver.findElement(By.id("cardNumber"));

Selenium may throw:
NoSuchElementException

even though you can clearly see the field on screen.
Why?
Because Selenium is searching in:
Main DOM

while the element exists in:
iframe DOM

Solution:
driver.switchTo().frame("paymentFrame");

driver.findElement(By.id("cardNumber"));

This is a very common Selenium interview/debugging scenario.

=============================================================================================================================


Wait for iframe
Sometimes an iframe loads after a delay.
Avoid:
Thread.sleep(3000);

Use:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

Then:
wait.until(
    ExpectedConditions.frameToBeAvailableAndSwitchToIt(
        By.id("employeeFrame")
    )
);

This condition does two things:
Wait for frame
+
Switch into frame

After that:
driver.findElement(By.id("username"))
      .sendKeys("Karan");

A useful real-world example:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(
    ExpectedConditions.frameToBeAvailableAndSwitchToIt(
        By.id("employeeFrame")
    )
);

driver.findElement(By.id("username"))
      .sendKeys("Karan");

driver.switchTo().defaultContent();
=============================================================================================================================


Important iframe exceptions
If you try to switch to a frame that doesn't exist:
driver.switchTo().frame("wrongFrame");

you can get:
NoSuchFrameException

If the frame exists but an element you're looking for isn't inside the currently selected frame/document, you may get:
NoSuchElementException
=============================================================================================================================


iframe vs normal <div>
This is important.
Normal HTML:
<div id="employeeSection">
    <input id="username">
</div>

You do NOT need:
switchTo().frame(...)

Just:
driver.findElement(By.id("username"));

But:
<iframe id="employeeFrame">

is a separate document context.
So you must switch.
iframe vs window/tab
Do not confuse iframe switching with window switching.
For tabs/windows:
driver.switchTo().window(handle);

For iframe:
driver.switchTo().frame(...);

Think:
New browser tab
→ window handle

Embedded page inside current tab
→ iframe

===================================================================

How to identify if an element is inside an iframe
In browser DevTools:
1. Inspect the element.
2. Check whether it appears under an <iframe> element.
3. If yes, Selenium must first switch into that iframe.
For example:
iframe
  #document
     html
       body
         input

That #document inside an iframe is a strong sign you're dealing with a separate frame document.

=======================================================================

Important comparison
frame(index)
→ switch using numerical position
→ starts at 0

frame("idOrName")
→ switch using iframe id/name

frame(WebElement)
→ locate iframe as WebElement and switch

parentFrame()
→ move one iframe level upward

defaultContent()
→ return directly to main document

=====================================================

Revision flow
Element not found
↓
Inspect DOM
↓
Is it inside iframe?
↓
YES
↓
Locate/switch to iframe
↓
Interact with element
↓
parentFrame() or defaultContent()

The most important code to remember is:
WebElement frame =
        driver.findElement(By.id("employeeFrame"));

driver.switchTo().frame(frame);

driver.findElement(By.id("username"))
      .sendKeys("Karan");

driver.switchTo().defaultContent();

And for interviews, remember the key statement:
An iframe has its own document context. 
Selenium must switch into that frame before interacting with elements inside it,
 and use defaultContent() or parentFrame() to come back out.


================================================


suppose we have div--> frame A--> Frame B --> Frame C.

instead of using switchTo().parentFrame(), why can't we use switchtTo().frame(frameA0 or frameB.. siomething like this?

Worked for 28s
Good question! The key concept is that switchTo().frame() is used to enter a frame, whereas switchTo().parentFrame() is used to move one level upward in the frame hierarchy.

Let's understand why you cannot simply jump to Frame A or Frame B from Frame C.

1. Understand the frame hierarchy
Suppose your webpage has this structure:

Main Page (DIV)

Default content

Frame A

Iframe document

Frame B

Iframe document

Frame C

Selenium is currently here

Assume Selenium is currently inside Frame C.

2. Why can't you directly switch to Frame A?
Suppose you write:

driver.switchTo().frame("frameA");

This is not the correct way to navigate from Frame C to its ancestor Frame A.

Why? Because Selenium is currently operating in Frame C's document context. Frame A is an ancestor, not a child frame of the current document.

The frame() method is not a general-purpose command to jump anywhere in the frame hierarchy.

3. How can you navigate correctly?
Try navigating from Frame C

Select a Selenium command to see where control will move.

Current context: Frame C
To enter a specific frame from the main page, first return to Main Page, then enter its nested frames in order.

Case A: You want to access Frame B
Use:

driver.switchTo().parentFrame();

Movement:

Frame C
   ↓ parentFrame()
Frame B
You have moved up just one level.

Case B: You want to access Frame A
Call parentFrame() twice:

driver.switchTo().parentFrame(); // C → B

driver.switchTo().parentFrame(); // B → A

Case C: You want to return to the main page
Use:

driver.switchTo().defaultContent();

This returns directly to the main document, regardless of how deeply nested the current frame is.

4. Can you use frame(frameA) if you already stored Frame A?
There is a difference between these two forms:

driver.switchTo().frame("frameA");

Here, "frameA" is a string containing a frame's name or ID.

driver.switchTo().frame(frameA);

Here, frameA is a WebElement representing an iframe.

Even if you stored the WebElement earlier, you should not rely on it as a way to jump out of a nested frame. The frame element belongs to another document context, and using a reference from outside the current context may fail.

The reliable approach is to return to the appropriate context first.

For example, from Frame C, to access Frame B:

driver.switchTo().parentFrame();

Or, from Frame C, to access Frame B by entering the hierarchy again:

driver.switchTo().defaultContent();

driver.switchTo().frame("frameA");

driver.switchTo().frame("frameB");

Remember this for interviews
frame() — enter a frame that is accessible from the current context.

parentFrame() — move up exactly one frame level.

defaultContent() — return directly to the main document.

The important distinction: Selenium's frame switching follows the browsing-context hierarchy. parentFrame() is the natural way to move upward; frame() is used to enter a frame, not as a general command to navigate to an ancestor.

==========================================



 */
}
