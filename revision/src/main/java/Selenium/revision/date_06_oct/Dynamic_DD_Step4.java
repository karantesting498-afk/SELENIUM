// This class contains dynamic dropdown questions

package Selenium.revision.date_06_oct;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamic_DD_Step4 {
	
	WebDriver driver;
	
	/*1. 
	 * The <li> options take 2–3 seconds to appear after clicking the dropdown.
Write Selenium code that:
- Clicks the dropdown.
- Uses WebDriverWait, not Thread.sleep().
- Waits until the options become visible.
- Gets all available options using findElements().
- Selects Aman.
- Stops iterating after selecting it.
You should use concepts like:

WebDriverWait
ExpectedConditions
List<WebElement>
getText()
click()
	 * 
	 * <div id="employeeDropdown">
    Select Employee
</div>

<ul class="employee-options">
    <li>Karan</li>
    <li>Rahul</li>
    <li>Aman</li>
    <li>Vishal</li>
</ul>
	 */
	
	public void ques_01()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement dd1 = driver.findElement(By.id("employeeDropdown"));
		
		dd1.click();
		
		
		List<WebElement> options=	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='employee-options']/child::li")));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Aman"))
			{
				option.click();
				break;

			}
			
		}
		 
	}
	
	/*2. 
	 * 
	 * There are two managers named Rahul.
Requirement:
Select only the Rahul whose data-id="103".

Write Selenium code that:
- Opens the dropdown.
- Gets all manager options.
- Checks both:
  - visible text = Rahul
  - data-id = 103
- Clicks only the correct option.
Do not use XPath indexing like:
(//li[text()='Rahul'])[2]


	 * 
	 * <div id="managerDropdown">Select Manager</div>

<ul class="manager-list">
    <li data-id="101">Rahul</li>
    <li data-id="102">Karan</li>
    <li data-id="103">Rahul</li>
    <li data-id="104">Aman</li>
</ul>
	 */
	
	public void ques_02()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement dd2 = driver.findElement(By.id("managerDropdown"));
		dd2.click();
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='manager-list']/child::li")));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Rahul") && option.getAttribute("data-id").equalsIgnoreCase("103"))
			{
				option.click();
				break;
			}
		}
	}
	

	
	/*3. Suppose your code does:
List<WebElement> options =
        driver.findElements(By.cssSelector(".team-options li"));

Then, before clicking an option, the application refreshes the dropdown options through an API.
The old WebElement references are no longer attached to the current DOM.
Answer:
- What Selenium exception may occur if you try to click one of the old elements?
- Why does it happen?
- How should you handle this situation?
- Should you reuse the old List<WebElement> or locate the options again?
Then write improved Selenium code that safely selects QA after the dropdown refresh.


	 * 
	 * 
	 * <div id="teamDropdown">Select Team</div>

<ul class="team-options">
    <li>QA</li>
    <li>Development</li>
    <li>BA</li>
</ul>
	 */
	
	public void ques_03()
	{
		/*
		 * 1. StaleElementReferenceException
		 * 2. old WebElement reference becomes stale after the application replaces the corresponding DOM elements.
		 * 3. locate the elements again after the DOM refresh and wait until the refreshed options are available.
				You can also use an explicit wait to detect staleness and then wait for the new elements.
		 * 4.The list contains references to the elements located at the time the list was created. You must locate the elements again to obtain fresh references.
		 * 
		 * 
		 
		 */
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		WebElement dd3 = driver.findElement(By.id("teamDropdown"));
		dd3.click();
		
		By locator = By.xpath("//ul[@class='team-options']/child::li");
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		wait.until(ExpectedConditions.stalenessOf(options.get(0)));
		List<WebElement> options2 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		
		for(WebElement option : options2)
		{
			if(option.getText().equalsIgnoreCase("QA"))
			{
				option.click();
				break;
				
				
			}
		}

	}
	
	
	
	/*4. 
	 * 
	 * 
	 * Suppose the employee dropdown contains 1000 employees, but initially only 20 are loaded.
	 * 
	 * More options load when the dropdown is scrolled.
You need to select:

Employee 86

Answer conceptually:
- Why might this fail?
driver.findElement(
    By.xpath("//div[@class='option' and normalize-space(.)='Employee 86']")
);

- Why might findElements() initially return only 20 elements?
- What would you need to do before locating Employee 86?
- How would you know when new options have loaded?
You do not need advanced JavaScript code yet. Explain the Selenium strategy/pseudocode.



HTML:
	 * <div id="employeeDropdown">Select Employee</div>

<div class="dropdown-list">
    <div class="option">Employee 1</div>
    <div class="option">Employee 2</div>
    ...
    <div class="option">Employee 20</div>
</div>
	 */
	
	public void ques_04()
	{
		/*
		 * 
		 * 1. Because when we are fetching the data using findElements, it will fetch the current provided 20 data only. and error
		 * NoSuchElementException will be shown
		 * 
		 * If new data is loaded and we again fetch then if size = 20 then it will fetch 40 data and so on
		 * 
		 * 2. We can use scroll functionality of selenium here.
		 * Open the dropdown.

Check whether Employee 86 is present.

If not, scroll the dropdown's scrollable container.

Wait for additional options to load.

Locate the options again and check for Employee 86.

Repeat until Employee 86 is found or a reliable stopping condition is reached.


		 * 
		 * 3. we can check the list size to verify.
		 * 
		 * Better signals include:

The number of loaded options increases.

A new option appears in the DOM.

A loading indicator disappears.

The target option, Employee 86, becomes present or visible.
		 * 
		 */
	}
	
	
	/*5.
	 * Q5 — Interview trap: dynamic data inside <select>
The options are loaded from an API after the page opens:
<select id="designation">
</select>

After two seconds, the DOM changes to:
<select id="designation">
    <option value="qa">QA Engineer</option>
    <option value="dev">Software Developer</option>
    <option value="ba">Business Analyst</option>
</select>

A developer tells you:
"This is a dynamic dropdown, so Selenium's Select class cannot be used."

Answer:
- Is the developer correct?
- What actually decides whether the Select class can be used?
- What problem could occur if you create/select before the options have loaded?
- How would you use an explicit wait here?
- Write Selenium code to wait for QA Engineer to become available and then select it.
This question tests an important distinction:
Dynamic DATA
        ≠
Custom dropdown HTML

A dropdown may have dynamically loaded data and still be a perfectly valid <select>.
	 * 
	 * 
	 * 	
	 */
	
	public void ques_05()
	{
		/*
		 * 1. No, developer is incorrect. If select tag exist then we can use select class
		 * 2. Select tag decide whether select class can be used
		 * 3. The Select object wraps the existing <select> element. It does not permanently store a snapshot of all its options when constructed.

If you create it before the API loads the options, a later call to selectByVisibleText("QA Engineer") can still work if the options have loaded by then. If they have not loaded, Selenium may throw a NoSuchElementException because it cannot find the requested option.

The key issue is selecting before the option becomes available, not creating the Select object early.


		 * 4. We can add wait for visibility of the drop-down options
		 * 
		 */
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement dd5 = driver.findElement(By.id("designation"));
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//select[@id='designation']/child::option[@value='qa']")
			    ));		
		Select options = new Select(dd5);
		
		options.selectByVisibleText("QA Engineer");
		
		
	}
}
