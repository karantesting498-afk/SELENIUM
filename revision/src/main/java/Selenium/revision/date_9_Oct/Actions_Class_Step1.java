// This class contains knowledge regarding the Actions class

package Selenium.revision.date_9_Oct;

public class Actions_Class_Step1 {
	
	/*
	 * Actions is used for advanced user interactions such as mouse movement, hover, right-click, double-click, drag-and-drop, and keyboard combinations.
Creating an Actions object
Actions actions = new Actions(driver);

=====================================================================

Here:
driver
→ controls the browser

Actions
→ gives advanced mouse + keyboard operations

Then you can perform actions like:
actions.moveToElement(element).perform();

The important methods are below.

==========================================================

Mouse hover — moveToElement()
Used when hovering over an element reveals another menu or tooltip.
WebElement menu =
        driver.findElement(By.id("employeeMenu"));

actions.moveToElement(menu).perform();

Flow:
Locate element
↓
moveToElement()
↓
perform()


=========================================

Normal click — click()
You can click through Actions:
WebElement button =
        driver.findElement(By.id("save"));

actions.click(button).perform();

Normally, this is simpler:
button.click();

Use Actions.click() when combining it with other actions.


=============================================




Double-click — doubleClick()
WebElement element =
        driver.findElement(By.id("employee"));

actions.doubleClick(element).perform();

This simulates:
Mouse click
+
Mouse click

quickly on the same element.

====================================================================

Right-click — contextClick()
Used to open the browser/application context menu.
WebElement element =
        driver.findElement(By.id("employee"));

actions.contextClick(element).perform();

contextClick() means:
Right mouse button click.



=========================================================================

Drag and drop — dragAndDrop()
Suppose:
WebElement source =
        driver.findElement(By.id("source"));

WebElement target =
        driver.findElement(By.id("target"));

Then:
actions.dragAndDrop(source, target).perform();

Flow:
Source
↓
Click and hold
↓
Move
↓
Target
↓
Release

You can also manually perform the same sequence:
actions
    .clickAndHold(source)
    .moveToElement(target)
    .release()
    .perform();
    
    
    ==========================================================================
    
    
    clickAndHold()
Keeps the mouse button pressed.
actions.clickAndHold(element).perform();

Commonly used with:
moveToElement()
release()

Example:
actions
    .clickAndHold(source)
    .moveToElement(target)
    .release()
    .perform();
    
    
    ================================================================
    
    release()
Releases the pressed mouse button.
actions.release().perform();

Usually used after:
clickAndHold()


=================================================

Move by coordinates — moveByOffset()
Moves the mouse relative to its current position.
actions.moveByOffset(100, 50).perform();

Meaning:
X = 100 pixels
Y = 50 pixels

Be careful with coordinate-based automation because UI layout changes can break it.


=============================================================

Keyboard — sendKeys()
Actions can also send keyboard input:
actions.sendKeys("Karan").perform();

Or to a specific element:
WebElement username =
        driver.findElement(By.id("username"));

actions
    .click(username)
    .sendKeys("Karan")
    .perform();
    
    
    =======================================
    
    keyDown() and keyUp()
These are useful for keyboard combinations.
Example: CTRL + A
actions
    .keyDown(Keys.CONTROL)
    .sendKeys("a")
    .keyUp(Keys.CONTROL)
    .perform();

Example: CTRL + C
actions
    .keyDown(Keys.CONTROL)
    .sendKeys("c")
    .keyUp(Keys.CONTROL)
    .perform();

Import:
import org.openqa.selenium.Keys;


============================================================

Example — select multiple elements using CTRL
WebElement item1 =
        driver.findElement(By.id("item1"));

WebElement item2 =
        driver.findElement(By.id("item2"));

actions
    .keyDown(Keys.CONTROL)
    .click(item1)
    .click(item2)
    .keyUp(Keys.CONTROL)
    .perform();
    
    
    
    ====================================
    
    perform() — very important
If you write:
actions.moveToElement(menu);

you have only defined the action.
To execute it:
actions.moveToElement(menu).perform();

So:
Action method
→ defines what should happen

perform()
→ actually executes it


=======================================================

build() vs perform()
You may see:
Action action = actions
        .moveToElement(element)
        .click()
        .build();

action.perform();

Here, build() creates the complete action sequence.
Then:
action.perform();

executes it.
For most normal scenarios, you can simply use:
actions
    .moveToElement(element)
    .click()
    .perform();

because perform() can build and execute the sequence for you.
This is also where Action and Actions differ:
Actions
→ Selenium class used to create actions

Action
→ interface representing a built action



=========================================================

Chaining multiple actions
One of the biggest advantages of Actions is chaining.
Example:
actions
    .moveToElement(username)
    .click()
    .sendKeys("Karan")
    .doubleClick()
    .perform();

The sequence executes in order:
Move
↓
Click
↓
Type
↓
Double-click



==========================================================

Common Actions methods to remember
moveToElement()
click()
doubleClick()
contextClick()

clickAndHold()
release()
dragAndDrop()
moveByOffset()

sendKeys()
keyDown()
keyUp()

build()
perform()

=================================================================


When should you use Actions?
Use it mainly when normal WebElement methods are not enough.
For example:
Hover menu
Right-click
Double-click
Drag and drop
Click and hold
Keyboard combinations
Complex mouse + keyboard sequences

For something simple like:
element.click();

you normally don't need:
actions.click(element).perform();

============================================================

Actions actions = new Actions(driver);

Hover
→ moveToElement()

Right click
→ contextClick()

Double click
→ doubleClick()

Drag and drop
→ dragAndDrop()

Hold
→ clickAndHold()

Release
→ release()

Keyboard press
→ keyDown()

Keyboard release
→ keyUp()

Execute sequence
→ perform()


====================================


The line you should remember first is:
Actions actions = new Actions(driver);

Then build the required mouse/keyboard operation and finish it with:
.perform();

=============================================



1. What is build()?

The build() method is used to compile all chained actions into a single Action object.
• When you call methods like .moveToElement(), .click(), or .dragAndDrop(), they don't execute immediately. Instead, they are queued up.
• build() essentially bundles this entire sequence together and prepares it for execution.
• Calling build() does not perform the action on the browser; it only sets up the composite plan and resets the internal builder state.

2. What is perform()?

The perform() method is what actually executes the compiled actions in the browser.
• Without perform(), your automation script will do nothing on the screen, even if you have chained ten different movements.

=====================================

		/*
		 * 1. Actions is an class.It have functions like move, click , drag, perform
		 * 
		 * Actions is a class in Selenium that provides methods for constructing complex user interactions,
		 *  such as mouse movements, clicks, drag-and-drop operations, and keyboard actions.
		 * 
		 * 
		 * 
		 * 2. Action is an interface. Here we provide the combined action to performed in. 
		 * We provide combined action using build method.
		 * 
		 * Action is an interface that represents a composite user interaction that can be executed.
		 * 
		 * 
		 * 3. build() returns an Action object, not an Actions object.
		 * 
		 * 
===============================================================================
	 */

}
