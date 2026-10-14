// This class only contain info about the dynamic drop-down

package Selenium.revision.date_6_oct;


public class Dynamic_DropDown_Step3 {
	
	
	/*
	 * 
	 * A dynamic dropdown is a dropdown whose options are generated, loaded, filtered, or changed at runtime. In Selenium, the main thing is to inspect the HTML first.
A dynamic dropdown is often built using elements like:

<div>
<ul>
<li>
<span>


instead of a normal:

<select>
<option>

So in many dynamic dropdowns, Selenium's Select class cannot be used.
-------------
For example:
<div id="employeeDropdown">Select Employee</div>

<ul class="employee-list">
    <li>Karan</li>
    <li>Rahul</li>
    <li>Aman</li>
</ul>


------------
flow is 


Locate dropdown
↓
Click dropdown
↓
Wait for options to appear
↓
Find all options
↓
Compare required value
↓
Click required option
-------------------------
e.g

driver.findElement(By.id("employeeDropdown")).click();

List<WebElement> options =
        driver.findElements(By.cssSelector(".employee-list li"));

for (WebElement option : options) {

    if (option.getText().equals("Aman")) {
        option.click();
        break;
    }
}



------------------------

Here:
driver.findElement(By.id("employeeDropdown")).click();

opens the dropdown.

Then:

List<WebElement> options =
        driver.findElements(By.cssSelector(".employee-list li"));
        
        finds all currently loaded dropdown options and stores them in a list.
Then:


for (WebElement option : options)

checks each option one by one.
And:

if (option.getText().equals("Aman"))

compares the visible text.
Finally:

option.click();

selects that option.

--------------------------------------------------------------

Why is it called dynamic?
Suppose your Employee dropdown initially contains:
Karan
Rahul
Aman

After adding another employee, it may contain:
Karan
Rahul
Aman
Vishal

Or the values may come from an API only after you click the dropdown.
So the values are not necessarily permanently written in the page HTML.


-------------------------------------------------------------


Explicit wait is important
Dynamic dropdown values may take some time to load.
Avoid doing this:
Thread.sleep(3000);

Prefer:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

Then:
driver.findElement(By.id("employeeDropdown")).click();

List<WebElement> options =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".employee-list li")
            )
        );

Then:
for (WebElement option : options) {

    if (option.getText().trim().equals("Aman")) {
        option.click();
        break;
    }
}

So the more practical version is:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

driver.findElement(By.id("employeeDropdown")).click();

List<WebElement> options =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".employee-list li")
            )
        );

for (WebElement option : options) {

    if (option.getText().trim().equals("Aman")) {
        option.click();
        break;
    }
}

------------------------------------------------------------

You can also directly locate the required option
Instead of getting all options:
driver.findElement(By.id("employeeDropdown")).click();

driver.findElement(
        By.xpath("//li[normalize-space(.)='Aman']")
).click();

This is perfectly valid if the locator is stable and uniquely identifies the option.
For example:
WebElement dropdown =
        driver.findElement(By.id("employeeDropdown"));

dropdown.click();

WebElement aman =
        driver.findElement(
            By.xpath("//li[normalize-space(.)='Aman']")
        );

aman.click();

---------------------------------------------------



Dynamic does NOT automatically mean "not <select>"
This is an important interview point.
You might have:
<select id="employee">
    <option>Karan</option>
    <option>Rahul</option>
</select>

and those <option> values might have been dynamically loaded from an API.
Because the HTML is still:
<select>

you can still use Select:
WebElement element =
        driver.findElement(By.id("employee"));

Select employee = new Select(element);

employee.selectByVisibleText("Karan");

So don't decide based only on whether the values are dynamic.
Always check:
Is HTML tag <select>?
        ↓
YES → Select class can be used

NO → Handle using click/findElements/custom locators


--------------------------------------------------------------


Exception for old data - StaleElementReferenceException
	 */
	
	

}
