// This class contains knowlede of window alerts
package Selenium.revision.date_07_Oct;

public class Window_Alert_Step1 {
	
	/*
	 * Note : Alert is an interface
	 * 
	 * 
	 * In Selenium, alerts are browser-level JavaScript popups that appear on top of the webpage and block normal interaction until you handle them.
The main alert types you should learn are:

1. Simple Alert
This alert normally has only an OK button.

Example JavaScript:

alert("Employee created successfully");



It may look like:
Employee created successfully

        OK

In Selenium:

Alert alert = driver.switchTo().alert();

System.out.println(alert.getText());

alert.accept();

Here:


driver.switchTo().alert();

switches Selenium's control from the webpage to the alert.
alert.getText();

gets the alert message.
alert.accept();

clicks OK.

---------------------------------------------------------------------------

2. Confirmation Alert
A confirmation popup usually has:

OK
Cancel

Example:
confirm("Do you want to delete this employee?");

Selenium:

Alert alert = driver.switchTo().alert();

System.out.println(alert.getText());

alert.accept();

accept() means:
OK
Yes
Confirm

depending on the browser popup.

alert.dismiss();

So remember:


accept()  → OK / Yes

dismiss() → Cancel / No
To click Cancel:


-------------------------------------


3. Prompt Alert
A prompt contains an input field.
Example:
prompt("Enter employee name");

It could appear as:
Enter employee name

[____________]

OK    Cancel

Selenium:


Alert alert = driver.switchTo().alert();

alert.sendKeys("Karan");

alert.accept();

So prompt alerts allow:
alert.sendKeys("...");


------------------------------------------

Main Alert methods
You should know these four:
alert.accept();

Clicks OK.
alert.dismiss();

Clicks Cancel.
alert.getText();

Gets alert text.
alert.sendKeys("Karan");

Types into a prompt alert.
For revision:
accept()
dismiss()
getText()
sendKeys()

--------------------------


Complete example
Suppose:
driver.findElement(By.id("deleteEmployee")).click();

A confirmation alert appears:
Are you sure you want to delete this employee?

Then:
Alert alert = driver.switchTo().alert();

String message = alert.getText();

System.out.println(message);

alert.accept();

Complete flow:
Click button
↓
Alert appears
↓
switchTo().alert()
↓
getText()
↓
accept() / dismiss()


----------------------------------------

Why do we need switchTo().alert()?
Normally Selenium is controlling the webpage:
Driver
  ↓
HTML page

When an alert appears, it is not a normal HTML element.
So this will not work:
driver.findElement(By.id("alert"));

Instead, Selenium must shift its focus:
driver.switchTo().alert();

Conceptually:
Browser page
     ↓
Alert appears

driver
     ↓
switchTo().alert()
     ↓
Alert control

-------------------------------------------------------

Store alert in Alert object
Normally you write:
Alert alert = driver.switchTo().alert();

Here:
Alert

is an interface provided by Selenium.
Import:
import org.openqa.selenium.Alert;

Now:
alert

represents the currently open browser alert.
Then you can perform:
alert.getText();
alert.accept();
alert.dismiss();
alert.sendKeys();



-----------------------------------------

Explicit wait for an alert
Sometimes the alert does not appear immediately.
Instead of:
Thread.sleep(3000);

use:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

Then:
Alert alert =
        wait.until(ExpectedConditions.alertIsPresent());

Now:
System.out.println(alert.getText());

alert.accept();

This is a better real-world approach.
Full example:
driver.findElement(By.id("deleteEmployee")).click();

WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

Alert alert =
        wait.until(ExpectedConditions.alertIsPresent());

System.out.println(alert.getText());

alert.accept();




---------------------------------------------------

What if no alert is present?
If you execute:
driver.switchTo().alert();

when no alert exists, Selenium can throw:
NoAlertPresentException

Example:
try {

    Alert alert = driver.switchTo().alert();
    alert.accept();

} catch (NoAlertPresentException e) {

    System.out.println("No alert found");
}


-------------------------------------------------------

What happens if you ignore an alert?
Suppose an alert is open and then you try:
driver.findElement(By.id("username")).click();

Selenium may not be able to interact with the webpage because the alert is blocking it.
You can get an exception such as:
UnexpectedAlertPresentException

So usually handle the alert first:
Alert alert = driver.switchTo().alert();
alert.accept();

and then continue interacting with the page.




-----------------------------------------------------==============


Important: JavaScript alert vs HTML modal
This is a very important interview distinction.
Suppose this popup appears:
<div class="modal">
    <p>Delete employee?</p>

    <button>Yes</button>
    <button>No</button>
</div>

This is not a browser alert.
It is an HTML modal.
Therefore this will not work:
driver.switchTo().alert();

Instead, use normal Selenium locators:
driver.findElement(
    By.xpath("//button[normalize-space(.)='Yes']")
).click();

So always inspect the popup.
JavaScript/browser alert
Not part of normal DOM:
alert()
confirm()
prompt()

Handle with:
driver.switchTo().alert();

HTML modal
Part of DOM:
<div>
<button>

Handle with:
findElement()


================================================================================



SIMPLE ALERT
-----------------------------
Buttons:
OK

Methods:
getText()
accept()


CONFIRMATION ALERT
-----------------------------
Buttons:
OK + Cancel

Methods:
getText()
accept()
dismiss()


PROMPT ALERT
-----------------------------
Input + OK + Cancel

Methods:
getText()
sendKeys()
accept()
dismiss()


============================================================================

Common Selenium alert code
Accept
driver.switchTo().alert().accept();

Dismiss
driver.switchTo().alert().dismiss();

Get text
String text =
        driver.switchTo().alert().getText();

Enter value
Alert alert = driver.switchTo().alert();

alert.sendKeys("Karan");
alert.accept();

=======================================================================

Important points for your revision
1. Alert is not a normal WebElement.

2. Use:
   driver.switchTo().alert()

3. Store it:
   Alert alert = driver.switchTo().alert();

4. Main methods:
   accept()
   dismiss()
   getText()
   sendKeys()

5. Simple Alert
   → OK

6. Confirmation Alert
   → OK + Cancel

7. Prompt Alert
   → Input + OK + Cancel

8. alertIsPresent()
   → useful with explicit wait

9. No alert present
   → NoAlertPresentException

10. HTML modal ≠ JavaScript alert

The easiest line to remember is:
Alert alert = driver.switchTo().alert();

After that, you handle the popup through the Alert object.






	 */

}
