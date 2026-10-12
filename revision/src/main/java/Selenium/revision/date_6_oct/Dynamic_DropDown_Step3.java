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



	 */

}
