// This class is for the action class questions

package Selenium.revision.date_09_Oct;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	//5. clickAndHold()
	
	/*
	 * Q9 — Hold element
A slider handle requires the mouse button to stay pressed before movement.
<div id="sliderHandle"></div>

Write Selenium code to:
- Move to the slider
- Click and hold
- Move 100 pixels horizontally
- Release
	 */
	
	public void ques_09()
	{
		WebElement handle = driver.findElement(By.id("sliderHandle"));
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(handle).moveByOffset(100, 0).release().perform();
	}
	
	/*
	 * Q10 — Manual drag operation
You have:
<div id="task101">Task 101</div>
<div id="completedArea">Completed</div>

Do not use dragAndDrop().
Instead use:
clickAndHold()
moveToElement()
release()

to move Task 101 to Completed.
	 */
	
	public void ques10()
	{
		WebElement task = driver.findElement(By.id("task101"));
		WebElement compArea = driver.findElement(By.id("completedArea"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(task).clickAndHold().moveToElement(compArea).release().perform();
	}
	
	//6. release()
	
	/*
	 * Q11 — Correct release location
Suppose:
actions
    .clickAndHold(source)
    .moveToElement(target)
    .perform();

The developer forgot to release the mouse.
Answer:
- What problem could this cause?
- Add the correct release() operation.
- Where should release() appear in the chain?
	 */
	public void ques_11()
	{
		/*
		 * 1. The mouse button remains pressed after the pointer reaches the target.

The drag-and-drop operation may not complete because the mouse button was never released.

The browser may continue treating the mouse as being in a pressed state until it is released or the interaction ends. 


		 * 2. after move to target
		 * 3. actions
    .clickAndHold(source)
    .moveToElement(target).release()
    .perform();
		 */
	}
	
	/*
	 * Q12 — Drop after offset
A draggable element must be:
- held
- moved 200 pixels right
- moved 50 pixels down
- released
Write one Actions chain.
	 */
	
	public void ques_12()
	{
	    WebElement element = driver.findElement(By.id("draggableElement"));

		Actions action = new Actions(driver);
		action.clickAndHold(element).moveByOffset(200, 50).release().perform();
	}
	
	//7. dragAndDrop()
	
	/*
	 * Q13 — Basic drag and drop
HTML:
<div id="employee">Karan</div>
<div id="teamA">Team A</div>

Drag employee Karan into Team A using dragAndDrop().
Then verify that the employee appears under Team A.
	 */
	
	public void ques_13()
	{
		WebElement emp = driver.findElement(By.id("employee"));

		WebElement team = driver.findElement(By.id("teamA"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		Actions action = new Actions(driver);
		
		action.dragAndDrop(emp, team).perform();
		
		//don't know how to verify
		
		  wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//div[@id='teamA']//div[@id='employee']")
			    ));
	}
	
	/*
	 * Q14 — dragAndDrop() fails
You write:
actions.dragAndDrop(source, target).perform();

but the application does not perform the drop.
Answer:
- Give possible reasons why dragAndDrop() may not work on some modern applications.
- Write the alternative sequence using:
  - clickAndHold()
  - moveToElement()
  - release()
	 */
	
	public void ques_14()
	{
		/*
		 * 1. don't know
		 * 1. Possible reasons why dragAndDrop() may fail

You can write these points in your answer:

Custom JavaScript drag-and-drop: The application may depend on specific mouse or drag events that are not triggered as expected by the standard action sequence.

HTML5 drag-and-drop: The application may rely on HTML5 drag events and the DataTransfer object, which can make the standard Selenium drag-and-drop operation insufficient.

Incorrect target location: The pointer may not reach the actual drop zone or an acceptable location within it.

Overlapping elements: An overlay or another element may intercept the interaction.

Timing issues: The application may need time to initialize the drag operation or update the target's state.
		 * 
		 *
		 */
		
		WebElement source = driver.findElement(By.id("source"));

		WebElement target = driver.findElement(By.id("target"));
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(source).moveToElement(target).release().perform();
	}
	
	//8. moveByOffset()
	
	/*
	 * Q15 — Horizontal slider
A slider starts at position 0.
You need to move its handle:
150 pixels right
0 pixels vertically

Write Selenium code using:
moveByOffset()
	 */
	
	
	public void ques_15()
	{
	    WebElement handle = driver.findElement(By.id("sliderHandle"));

	    
		Actions action = new Actions(driver);
		action.moveToElement(handle).clickAndHold().moveByOffset(150, 0).release().perform();
	}
	
	/*Q16 — Offset direction
You execute:
actions.moveByOffset(-100, 50).perform();

Answer:
- Which horizontal direction does -100 represent?
- Which vertical direction does 50 represent?
- What would (100, -50) represent?
	 * 
	 */
	
	public void ques_16()
	{
		/*
		 * 1. -100 represent left side of the screen.
		 * 2. 50 represent vertical downward line.
		 * 3. 100,-50 represent upper right
		 */
		
	}
	
	//9. sendKeys()
	
	/*
	 * Q17 — Actions typing
HTML:
<input id="username">

Using Actions:
- Move to username
- Click it
- Type karan.qa
- Do everything in one action chain
Do not use:
username.sendKeys(...)
	 */
	
	public void ques_17()
	{
		WebElement unmae = driver.findElement(By.id("username"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(unmae).click().sendKeys("karan.qa").perform();
	}
	
	/*
	 * Q18 — Search and Enter
You have:
<input id="employeeSearch">

Using Actions:
- Click the search field
- Type Rahul
- Press ENTER
Use only one perform().
	 */
	public void ques_18()
	{
		WebElement unmae = driver.findElement(By.id("employeeSearch"));

		Actions action = new Actions(driver);
		action.moveToElement(unmae).click().sendKeys("Rahul").sendKeys(Keys.ENTER).perform();
	}
	
	//10. keyDown()
	
	/*
	 * Q19 — CTRL + multiple selection
HTML:
<div id="employee1">Karan</div>
<div id="employee2">Rahul</div>
<div id="employee3">Aman</div>

The application supports multi-selection with CTRL.
Using Actions:
- Hold CTRL
- Click Karan
- Click Aman
- Keep CTRL pressed until both clicks are complete
Do not release CTRL yet in the first part of your answer.
Then explain what needs to happen afterward.
	 */
	
	public void ques_19()
	{
		WebElement empK = driver.findElement(By.id("employee1"));
		WebElement empR = driver.findElement(By.id("employee3"));

		
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).click(empR).click(empK);
		
		/*
		 * for next we have to
		 * 		action.keyDown(Keys.CONTROL).click(empR).click(empK).keyUp(Keys.CONTROL).perform();

		 */
	}
	
	/*
	 * Q20 — SHIFT selection
Suppose a list supports range selection.
You want to:
1. Click Employee 1
2. Hold SHIFT
3. Click Employee 5
Write the Actions sequence using keyDown(Keys.SHIFT).
	 */
	
	public void ques_20()
	{
		List<WebElement> emp = driver.findElements(By.xpath("//div[contains(@id,'employee')]"));
		
		Actions action = new Actions(driver);

		action.click(emp.get(0)).keyDown(Keys.SHIFT).click(emp.get(4)).keyUp(Keys.SHIFT).perform();
		
	}
	
	//11. keyUp() —
	
	/*
	 * Q21 — Why keyUp matters
A tester writes:
actions
    .keyDown(Keys.CONTROL)
    .click(employee1)
    .click(employee2)
    .perform();

They never call:
keyUp(Keys.CONTROL)

Answer:
- Why is this bad practice?
- What effect could it have on later interactions?
- Write the corrected chain.
	 */
	
	public void ques_21()
	{
		/*
		 * 1. It is bad practise becuase control key will remain pressed.
		 * 2. In later interaction control key will remain preseed which might fail the test case
		 * Subsequent clicks or keyboard operations may behave differently than expected. For example, 
		 * clicking another employee could add it to a selection instead of selecting it normally.
		 * 
		 * 
		 * 3. Correct chain is : action.keysDown(KEYS.CONTROL).click(employee1).click(employee2).keysUp(KEYS.CONTROL).perform();
		 */
		
	}

	/*
	 * Q22 — CTRL+A then type
You need to replace an existing value in:
<input id="employeeName" value="Old Employee">

Using Actions:
1. Click the field
2. Hold CTRL
3. Press A
4. Release CTRL
5. Type Karan Sharma
Use:
keyDown()
sendKeys()
keyUp()
	 */
	public void ques_22()
	{
		
		WebElement name = driver.findElement(By.id("employeeName"));
		Actions action = new Actions(driver);
		
		action.click(name).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("Karan Sharma").build().perform();;
	}

	
	//12. build()
	
	/*
	 * Q23 — Build now, perform later
Create the following action but do not immediately execute it:
Hover over menu
↓
Click menu
↓
Type "Employee"

Store the built sequence inside an:
Action

object.
Then execute it separately.
	 */
	
	public void ques_23()
	{
		WebElement menu = driver.findElement(By.id("menu"));
		Actions action = new Actions(driver);
		
		action.moveToElement(menu).click().sendKeys("Employee");
		
		org.openqa.selenium.interactions.Action builder = action.build();
		
		builder.perform();
	}
	
	/*
	 * Q24 — Difference between Actions and Action
Explain the difference between:
Actions actions = new Actions(driver);

and:
Action action = actions
    .moveToElement(element)
    .click()
    .build();

Answer:
- What is Actions?
- What is Action?
- What does build() return?
- When does the actual browser interaction happen?
	 */

	public void ques_24()
	{
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
		 * 4. When we use .perform() method
		 *
		 */
	}
	
	//13. perform()
	
	
	/*
	 * Q25 — Missing perform
A tester writes:
actions
    .moveToElement(menu)
    .click();

but nothing happens.
Why?
Correct the code.
Also explain the purpose of:
perform()
	 */
	
	public void ques_25()
	{
		/*
		 * actions
    .moveToElement(menu)
    .click();
    
    here nothing happens because browser interaction only start when perform() method is used.
    
    it should be 
    actions
    .moveToElement(menu)
    .click().perform();
    
    perform() method executes the browser interaction
    
    perform() executes the configured interaction sequence by sending the relevant interaction commands to the browser.

Also, perform() is not limited to mouse actions. It can execute keyboard actions and combinations of mouse and keyboard actions as well.

    
    
		 */
		
		
		
		
		/*
		 * Q26 — One perform vs multiple performs
Compare:
actions.moveToElement(menu).perform();
actions.click(menu).perform();
actions.sendKeys("Employee").perform();

with:
actions
    .moveToElement(menu)
    .click()
    .sendKeys("Employee")
    .perform();

Answer:
- Which creates a chained interaction?
- What role does the final perform() play?
- In what situations might separate perform() calls still be useful?
		 */
	}
	
	public void ques_26()
	{
		/*
		 * 1. this 
		 * actions
    .moveToElement(menu)
    .click()
    .sendKeys("Employee")
    .perform();
    
    creates chained interaction
    
    2. perform()method execute the browser interaction
    
    More precisely, it executes the configured sequence of actions.

Without the final perform(), the sequence is not executed.


    
    3. Separate perform() calls are useful when you want to execute interactions in distinct stages, particularly when you need to inspect the result of one interaction before deciding what to do next.

For example:

// Step 1: Hover over the menu
actions.moveToElement(menu).perform();

// Step 2: Check or locate the submenu
WebElement submenu = driver.findElement(By.id("submenu"));

// Step 3: Click the submenu
actions.click(submenu).perform();

Here, the hover executes first. You then locate the submenu and execute the click separately.

This is useful when:

An interaction reveals new elements that you need to locate.

You need to verify a UI state between interactions.

The next action depends on the result of the previous action.

You want to separate complex interactions for debugging.

One important distinction: multiple perform() calls do not automatically make the code better or worse.
 Use one chained sequence when the actions form a straightforward sequence; 
 use separate calls when you need distinct execution stages.
		 */
		
	}
	
	
	//Final 5 Combination Challenges
	
	/*
	 * Q27 — Hover + submenu + click + keyboard
Application flow:
Employees
    ↓ hover
Manage
    ↓ hover
Search Employee

After clicking Search Employee, an input appears.
Write Selenium code to:
1. Hover over Employees
2. Hover over Manage
3. Click Search Employee
4. Click the search field
5. Type Karan
6. Press ENTER
Use Actions extensively and minimize unnecessary perform() calls.
	 */
	
	public void ques_27()
	{

		WebElement emp = driver.findElement(By.id("employee"));

		WebElement man = driver.findElement(By.id("Manage"));
		

		WebElement Search = driver.findElement(By.id("search_employee"));
		WebElement Searchfield = driver.findElement(By.id("search_employee_field"));

		
		Actions action = new Actions(driver);
		
		action.moveToElement(emp).moveToElement(man).click(Search).click(Searchfield).sendKeys("Karan").keyDown(Keys.ENTER).keyUp(Keys.ENTER).release().perform();
	
		/*
		 * more effiecient:
		 * 
		 * 		action.moveToElement(emp).moveToElement(man).click(Search).click(Searchfield).sendKeys("Karan").sendKeys(Keys.Enter).release().perform();

		 * 
		 */
	}
	
	/*
	 * Q28 — CTRL select + drag and drop
Three tasks exist:
<div id="task1">Task 1</div>
<div id="task2">Task 2</div>
<div id="task3">Task 3</div>

<div id="completed">Completed</div>

The application allows multiple task selection using CTRL.
Requirement:
1. Hold CTRL
2. Select Task 1
3. Select Task 3
4. Release CTRL
5. Drag the selected tasks to Completed
Write the Actions logic.
	 */
	
	public void ques_28() {
		WebElement t1 = driver.findElement(By.id("task1"));
		

		WebElement t3 = driver.findElement(By.id("task3"));
		
		WebElement comp = driver.findElement(By.id("completed"));
		
		Actions action = new Actions(driver);
	
		
		action.keyDown(Keys.CONTROL).moveToElement(t1).click().moveToElement(t3).click().keyUp(Keys.CONTROL).clickAndHold().moveToElement(comp).release().perform();

	}
	
	/*
	 * Q29 — Context click + dynamic menu + hover
Right-clicking an employee opens:
Actions
    →
    Edit
    Deactivate
    More
        →
        View History

Write Selenium code to:
1. Right-click employee Karan
2. Wait for the context menu
3. Hover over More
4. Wait for View History
5. Click View History
Concepts required:
contextClick()
moveToElement()
click()
perform()
Explicit wait
	 */
	
	public void ques_29()
	{
		WebElement emp = driver.findElement(By.xpath("//div[@id='employee' and normalize-space(.)='Karan']"));
		Actions action = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		action.contextClick(emp).release().perform();
		
		WebElement menu = driver.findElement(By.id("menu"));
		wait.until(ExpectedConditions.visibilityOf(menu));
		
		WebElement more = driver.findElement(By.id("more"));

		action.moveToElement(more).release().perform();
		
		WebElement history = driver.findElement(By.id("history"));
		
		wait.until(ExpectedConditions.visibilityOf(history));
		
		action.moveToElement(history).release().click().perform()	;

		
	}
	
	/*
	 * Q30 — Select all, replace, double-click
Input contains:
Old Employee Name

Requirement:
1. Click the input
2. CTRL+A
3. Release CTRL
4. Type Karan Sharma
5. Double-click the entered value
Write one logical Actions sequence.

Be careful about where:
keyDown()
keyUp()
doubleClick()
perform()

should be used.
	 */
	
	public void ques_30()
	{
		WebElement input = driver.findElement(By.id("input"));
		
		Actions action = new Actions(driver);
		
		action.click(input).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys("Karan Sharma").doubleClick().release().perform();
		
		/*
		 * Q30 — Why specify the input again in doubleClick(input)?
You reasoned that the mouse is already focused on the input. There is an important distinction here:
- Keyboard focus determines which element receives keyboard input.
- Mouse pointer position determines where a mouse action such as a double-click occurs.
Your chain ends with:
.sendKeys("Karan Sharma")
.doubleClick()


The pointer will generally remain at the position established by click(input), so doubleClick() without an argument will often double-click the input successfully.

Therefore, your original doubleClick() is not necessarily wrong.

Using doubleClick(input) explicitly identifies the target element and moves the pointer to its interaction point before double-clicking. It makes the intended target clearer and avoids relying on the pointer's existing position.

One qualification: double-clicking the input does not guarantee selection of the entire text Karan Sharma; that depends on the pointer position and browser behavior.

Verdict: Your approach can work. Passing the element explicitly is clearer and more robust, but it is not mandatory when the pointer is already positioned correctly.
		 */
	}
	
	/*
	 * Q31 — Interview-level drag challenge
HTML:
<div class="task"
     data-id="101">
    Employee Verification
</div>

<div class="task"
     data-id="102">
    Customer Approval
</div>

<div class="column"
     data-status="completed">
    Completed
</div>

Requirement:
- Find Task 102 using data-id
- Move mouse to it
- Click and hold
- Move to the Completed column
- Move an additional 20px right and 10px down
- Release the mouse
- Execute the whole drag operation properly
- Verify afterward that Task 102 is inside the Completed section
Do not use:
dragAndDrop()

You must combine:
moveToElement()
clickAndHold()
moveToElement()
moveByOffset()
release()
perform()
	 */
	
	public void ques_31()
	{
		WebElement task = driver.findElement(By.xpath("//div[@data-id='102']"));
		WebElement comp = driver.findElement(By.xpath("//div[@data-status='completed']"));
		Actions action = new Actions(driver);
		
		action.moveToElement(task).clickAndHold().moveToElement(comp).moveByOffset(20,10).release().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-status='completed']/descendant::div[@data-id='102']")));
		
	}
}

