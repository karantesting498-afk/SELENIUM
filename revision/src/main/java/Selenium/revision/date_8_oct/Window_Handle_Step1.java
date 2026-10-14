// this class contain knowledge for window handles and tab switch
package Selenium.revision.date_8_oct;

public class Window_Handle_Step1 {
	
	/*
	 * 
	 * In Selenium, window/tab switching is handled using window handles.
A window handle is a unique ID that Selenium assigns to every browser window or tab.
For example:
Main tab    → CDwindow-1234
New tab     → CDwindow-5678
Another tab → CDwindow-9012

You normally use these methods:
driver.getWindowHandle();
driver.getWindowHandles();
driver.switchTo().window(handle);
======================================================================================

1. Get the current window/tab handle
String parentWindow = driver.getWindowHandle();

This stores the unique handle of the tab Selenium is currently controlling.
Example:
String parentWindow = driver.getWindowHandle();

System.out.println(parentWindow);

Think of it as:
getWindowHandle()
→ current tab only
→ returns String


=======================================================================================
2. Get handles of all open tabs/windows
Set<String> allWindows = driver.getWindowHandles();

You need:
import java.util.Set;

This gives the handles of all currently open browser windows/tabs.
getWindowHandles()
→ all opened tabs/windows
→ returns Set<String>

Notice the difference:
String parent = driver.getWindowHandle();

Set<String> windows = driver.getWindowHandles();


====================================================================


3. Switch from parent tab to child tab
Suppose clicking a button opens a new tab:
String parentWindow = driver.getWindowHandle();

driver.findElement(By.id("openReport")).click();

Set<String> allWindows = driver.getWindowHandles();

for (String window : allWindows) {

    if (!window.equals(parentWindow)) {

        driver.switchTo().window(window);
        break;
    }
}

Here:
if (!window.equals(parentWindow))

means:
If this window handle is not the original parent window, it must be the new tab/window.

Then:
driver.switchTo().window(window);

moves Selenium control to that tab.





=======================================================================


Why is switching necessary?
Suppose:
Tab 1
TrackoField

Click "Open Report"

Tab 2 opens
Report

Even though the new tab is visible in the browser, Selenium may still be controlling Tab 1.
You must explicitly do:


driver.switchTo().window(childWindow);

Otherwise:
driver.findElement(...)

continues looking in the old tab.



=========================================================================


Complete example
WebDriver driver = new ChromeDriver();

driver.get("https://example.com");

String parentWindow = driver.getWindowHandle();

driver.findElement(By.id("openNewTab")).click();

Set<String> allWindows = driver.getWindowHandles();

for (String window : allWindows) {

    if (!window.equals(parentWindow)) {

        driver.switchTo().window(window);

        System.out.println(driver.getTitle());

        break;
    }
}

Flow:
Open main page
↓
Store parent handle
↓
Click element
↓
New tab opens
↓
Get all handles
↓
Find handle != parent
↓
switchTo().window()







===============================================================


Switching back to parent window
Once you're finished with the child tab:
driver.close();

Then:
driver.switchTo().window(parentWindow);

Example:
driver.switchTo().window(childWindow);

driver.close();

driver.switchTo().window(parentWindow);

This is important because driver.close() closes the current tab, but Selenium does not automatically switch to another tab for you.





=============================================================================================

close() vs quit()
This is an important interview question.
driver.close();

closes only the currently controlled window/tab.
driver.quit();

closes:
All tabs
+
All windows
+
Entire WebDriver session

So:
close()
→ current tab/window only

quit()
→ complete browser session




================================================================

Multiple tabs/windows
Suppose there are:
Parent
Child 1
Child 2
Child 3

You can iterate:
Set<String> windows = driver.getWindowHandles();

for (String window : windows) {

    driver.switchTo().window(window);

    System.out.println(driver.getTitle());
}

Now Selenium visits each open tab/window.
You can identify the required tab using its title:
for (String window : driver.getWindowHandles()) {

    driver.switchTo().window(window);

    if (driver.getTitle().equals("Employee Report")) {
        break;
    }
}

Or by URL:
for (String window : driver.getWindowHandles()) {

    driver.switchTo().window(window);

    if (driver.getCurrentUrl().contains("/employee/report")) {
        break;
    }
}

This is more useful when multiple child tabs exist.




==========================================================================

Don't assume Set ordering
This is important.
getWindowHandles() returns:
Set<String>

A Set should not be treated as having a guaranteed parent-first/child-second order.
So this approach is less reliable conceptually:
List<String> windows =
        new ArrayList<>(driver.getWindowHandles());

driver.switchTo().window(windows.get(1));

It may work in many cases, but for robust automation, it is better to store the parent:
String parent = driver.getWindowHandle();

and compare:
if (!window.equals(parent))

For multiple tabs, identify by title, URL, or another known condition.





======================================

Wait for new tab/window
Sometimes the tab doesn't open immediately.
Use explicit wait:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

String parentWindow = driver.getWindowHandle();

driver.findElement(By.id("openReport")).click();

wait.until(ExpectedConditions.numberOfWindowsToBe(2));

Then:
for (String window : driver.getWindowHandles()) {

    if (!window.equals(parentWindow)) {

        driver.switchTo().window(window);
        break;
    }
}

======================================================

Selenium 4 — Open a new tab yourself
Selenium 4 provides:
driver.switchTo().newWindow(WindowType.TAB);

Example:
driver.switchTo().newWindow(WindowType.TAB);

driver.get("https://google.com");

For a new browser window:
driver.switchTo().newWindow(WindowType.WINDOW);

Imports:
import org.openqa.selenium.WindowType;

Difference:
WindowType.TAB
→ new tab

WindowType.WINDOW
→ new browser window

Selenium automatically switches control to the newly created tab/window when using newWindow().




=================================================================
Parent-child example
String parent = driver.getWindowHandle();

driver.findElement(By.id("openEmployee")).click();

WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

wait.until(ExpectedConditions.numberOfWindowsToBe(2));

for (String handle : driver.getWindowHandles()) {

    if (!handle.equals(parent)) {

        driver.switchTo().window(handle);

        System.out.println(driver.getTitle());

        driver.close();

        break;
    }
}

driver.switchTo().window(parent);


======================================================================

Common exception
If you try:
driver.switchTo().window("invalid-handle");

Selenium can throw:
NoSuchWindowException

It can also occur if you try interacting with a tab that has already been closed.


==================================================================

Window vs tab in Selenium
For switching purposes, Selenium treats browser tabs and separate browser windows similarly.
Both have:
window handle

and both are switched using:
driver.switchTo().window(handle);

So despite the method name being window(), it also works for tabs.



============================================================================

CURRENT TAB
--------------------------------
driver.getWindowHandle()

Returns:
String


ALL TABS/WINDOWS
--------------------------------
driver.getWindowHandles()

Returns:
Set<String>


SWITCH TAB/WINDOW
--------------------------------
driver.switchTo().window(handle)


CLOSE CURRENT TAB
--------------------------------
driver.close()


CLOSE COMPLETE BROWSER SESSION
--------------------------------
driver.quit()


NEW TAB - SELENIUM 4
--------------------------------
driver.switchTo()
      .newWindow(WindowType.TAB)


NEW WINDOW - SELENIUM 4
--------------------------------
driver.switchTo()
      .newWindow(WindowType.WINDOW)
      
      
      ======================================================
      
      Store parent handle
        ↓
Perform action that opens new tab
        ↓
Wait for number of windows to increase
        ↓
getWindowHandles()
        ↓
Loop through handles
        ↓
handle != parent
        ↓
switchTo().window(handle)
        ↓
Perform child-tab work
        ↓
close()
        ↓
switchTo().window(parent)







=============================================================

	Q if selenium click on a button and a new tab is opened.

then is selenium on page  1 or 2??

how parent and child tab window are defined here

and : 

If Selenium clicks a button on Page/Tab 1 and that click opens Page/Tab 2, Selenium usually remains focused on Page/Tab 1 until you explicitly switch.
Example:
Tab 1 = Parent
TrackoField
   ↓
click "Open Report"
   ↓
Tab 2 opens = Child

Even if Tab 2 becomes visible in the browser UI, Selenium's control may still be on Tab 1.
You can verify the current tab with:
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());

How parent and child are defined
The tab where your flow started is usually called the parent window/tab.


String parent = driver.getWindowHandle();

Then you click:
driver.findElement(By.id("openReport")).click();

Now there are two handles:
Set<String> windows = driver.getWindowHandles();


Conceptually:
Parent handle → Tab 1
Child handle  → Tab 2

Selenium itself doesn't officially label them "parent" and "child".
Those are names we give them in our code to make handling easier.
For example:

String parent = driver.getWindowHandle();

means:
Store the current tab's handle and call it parent.

Then:
for (String window : driver.getWindowHandles()) {

    if (!window.equals(parent)) {

        driver.switchTo().window(window);
        break;
    }
}


means:
Find the handle that is different from the original parent and switch to it.

That different handle is what we commonly call the child window/tab.
So the complete flow is:


String parent = driver.getWindowHandle();

driver.findElement(By.id("openReport")).click();

for (String handle : driver.getWindowHandles()) {

    if (!handle.equals(parent)) {
        driver.switchTo().window(handle);
        break;
    }
}

Now Selenium is controlling Tab 2.
To return:


driver.close();

driver.switchTo().window(parent);

So remember:
Before click:
Selenium → Tab 1

After click opens Tab 2:
Selenium → usually still Tab 1

After switchTo().window(child):
Selenium → Tab 2

After switchTo().window(parent):
Selenium → Tab 1


And the key interview point is:
Parent and child are not special Selenium window types. 
They are logical names we use: the original tab is usually called parent, and the newly opened tab is called child.



	 */

}
