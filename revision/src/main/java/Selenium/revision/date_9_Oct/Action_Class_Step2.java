// This class is for the action class questions

package Selenium.revision.date_9_Oct;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Class_Step2 {
	WebDriver driver;
	
	/*
	 * 1. moveToElement() — 2 Questions
	 * 
	 * Q1 — Hover menu
HTML:
<div id="settingsMenu">
    Settings
</div>

<div class="submenu">
    <button id="profile">Profile</button>
    <button id="security">Security</button>
</div>

The .submenu becomes visible only after hovering over settingsMenu.
Write Selenium code to:
- Locate Settings
- Hover over it using Actions
- Wait until the submenu becomes visible
- Click Security
Do not directly click the Settings menu.
	 */
	
	public void ques_01()
	{
		WebElement setting = driver.findElement(By.id("settingsMenu"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		
		action.moveToElement(setting).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='submenu']")));
		WebElement button = driver.findElement(By.xpath("//div[@class='submenu']/child::button[@id='security']"));
		
		action.moveToElement(button).click().perform();

		
	}
	
	/*
	 * Q2 — Nested hover
Consider:
Employees
    ↓ hover
Manage Employees
    ↓ hover
Deactivate Employee

Write Selenium code where:
1. Hover over Employees
2. Wait for Manage Employees
3. Hover over Manage Employees
4. Wait for Deactivate Employee
5. Click Deactivate Employee
Use moveToElement() for both hover operations.
	 */
	
	public void ques_02()
	{
		WebElement employees = driver.findElement(By.id("Employees"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Actions action = new Actions(driver);
		action.moveToElement(employees).perform();
		
		WebElement manageEmp = driver.findElement(By.id("ManageEmployees"));
		
		wait.until(ExpectedConditions.visibilityOf(manageEmp));
		action.moveToElement(manageEmp).perform();
		
		WebElement deactivateEmp = driver.findElement(By.id("DeactivateEmployees"));
		wait.until(ExpectedConditions.visibilityOf(deactivateEmp));
		
		deactivateEmp.click();

	}
	
	/*
	 * 2. click() — 2 Questions
Q3 — Actions click vs normal click
You have:
WebElement save =
    driver.findElement(By.id("save"));

Normal:
save.click();

sometimes fails because the mouse must first be positioned over the element.
Write an Actions solution that:
- Moves the mouse to Save
- Clicks it
- Executes everything as one action chain
Also explain why Actions.click() may work in a scenario where normal WebElement.click() has problems.
	 */

	public void ques_03()
	{
		WebElement save = driver.findElement(By.id("save"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Actions action = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOf(save));
		
		action.moveToElement(save).click().perform();
		
		/*
		 * save.click() directly attempts to click the element using Selenium's element-click command.



action.moveToElement(save).click().perform() first moves the mouse pointer to the center of the 
Save element and then performs a mouse click.



The Actions approach may work when the UI requires the mouse to be positioned over the element first,
 or when the interaction depends on mouse-related events such as hover behavior.
		 */
	}
	
	/*
	 * Q4 — Click after keyboard operation
There is an input:
<input id="employeeSearch">
<button id="search">Search</button>

Using only one Actions chain:
- Click the input
- Type Karan
- Move to the Search button
- Click it
Finish with only one perform().

	 */
	public void ques_04()
	{
		WebElement id = driver.findElement(By.id("employeeSearch"));
		WebElement button = driver.findElement(By.id("search"));
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		action.moveToElement(id).click().sendKeys("Karan").moveToElement(button).click().perform();
		
		
	}
	
	//3. doubleClick()
	
	
	/*
	 * Q5 — Edit on double click
An employee row enters edit mode only when double-clicked.
<div class="employee-row" data-id="104">
    Karan
</div>

Write Selenium code to:
- Locate the row using data-id
- Double-click it
- Verify that an input field appears afterward
	 */
	
	public void ques_05()
	{
		WebElement row = driver.findElement(By.xpath("//div[@class='employee-row' and @data-id='104']"));
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		action.moveToElement(row).doubleClick().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeNames")));
		
		
		
	}
	
	/*
	 * Q6 — Double-click exact element
HTML:
<div class="file">Report.xlsx</div>
<div class="file">Employee.xlsx</div>
<div class="file">Attendance.xlsx</div>

Only Employee.xlsx should be double-clicked.
Requirements:
- Find all files
- Identify Employee.xlsx using visible text
- Double-click it using Actions
- Stop iterating after the double-click
	 */
	
	public void ques_06()
	{
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='file']"));
		Actions action = new Actions(driver);
		
		for(WebElement file : files)
		{
			if(file.getText().equals("Employee.xlsx"))
			{
				action.moveToElement(file).doubleClick().perform();
				break;
			}
		}
	}
	
	
	//4. contextClick()
	
	/*
	 * Q7 — Right-click context menu
Right-clicking:
<div id="employee101">Karan</div>

opens:
Edit
Deactivate
View History

Write Selenium code to:
- Right-click Karan
- Wait for the context menu
- Click View History
	 */
	
	public void ques_07()
	{
		WebElement id = driver.findElement(By.id("employee101"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Actions action = new Actions(driver);
		action.moveToElement(id).contextClick().perform();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contextMenu")));
		
		WebElement button = driver.findElement(By.xpath("//div[@id='contextMenu']/child::button[normalize-space(.)='View History']"));

		action.moveToElement(button).click().perform();
		
	}
	
	/*
	 * Q8 — Dynamic employee right-click
You have multiple employee rows.
<div class="employee" data-status="active">Rahul</div>
<div class="employee" data-status="inactive">Karan</div>
<div class="employee" data-status="active">Aman</div>

Find the employee whose:
text = Karan
data-status = inactive

Then right-click that element using contextClick().
	 */
	
	public void ques_08()
	{
		WebElement emp = driver.findElement(By.xpath("//div[@class='employee' and @data-status='inactive' and normalize-space(.)='Karan']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(emp).contextClick().perform();
	}
}
