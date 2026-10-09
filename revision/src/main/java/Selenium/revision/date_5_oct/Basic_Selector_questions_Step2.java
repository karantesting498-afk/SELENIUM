package Selenium.revision.date_5_oct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Basic_Selector_questions_Step2 {
	
	WebDriver driver;
	
	/*1. Write a Selenium locator using only By.id() to locate the username field.
	 * <input type="text"
       id="employee_username_7845"
       name="username"
       placeholder="Enter Username">
       
       2. Write a Selenium statement that: Locates the button using By.id() , Stores it inside a WebElement and Clicks it
       
       	<button id="saveEmployee"
        class="btn btn-primary"
        type="submit">
    	Save Employee
		</button>
		
		3. Locate this element using only By.name().
		
		<input type="email"
       id="employeeEmail"
       name="official_email"
       placeholder="Official Email">
       
       4. Answer: How many elements match?  Which element will findElement() return? How would you retrieve both matching elements?
       
       <input type="text" name="employeeCode">
		<input type="hidden" name="employeeCode">
		
		5.
		
		<button class="btn primary-action save-employee active">
    		Save
		</button>
		
		Which of these are valid?
		
		By.className("btn")

		By.className("save-employee")

		By.className("btn primary-action")

		By.className("primary-action save-employee active")
		
		
		6.
		<button class="btn action">Add</button>

		<button class="btn action">Edit</button>

		<button class="btn action disabled">Delete</button>
		
		List<WebElement> elements =
        driver.findElements(By.className("action"));
        
        Answer:

		What will elements.size() return?
		Can By.className() uniquely locate the Delete button using "action disabled"?
		Why?

		7. 
		Write Selenium code using By.tagName() to:

		Find all <input> elements
		Print how many input elements exist
		
		<input type="text">
		<input type="email">
		<input type="password">
		<button>Login</button>
		<input type="hidden">
		
		8. 
		Write Selenium code using only tagName() to retrieve all links and print their visible text.

You cannot use XPath, CSS, linkText(), or partialLinkText().


		<a>Home</a>
<a>Customers</a>
<a>Employees</a>
<a>Reports</a>
<a>Logout</a>


9. 
By.linkText("Forgot Password")

By.linkText("Forgot")

By.linkText("Password")

By.linkText("forgot password")



<a href="/forgot-password">
      Forgot Password
</a>

10. Write a locator using linkText() that selects only: Employee Management/ Then explain why it doesn't select the second link.

<a href="/employee">Employee Management</a>
<a href="/employee/report">Employee Management Report</a>



11. driver.findElement(
    By.partialLinkText("Attendance Report")
);

Which element will Selenium return?



<a href="/reports/daily">Daily Attendance Report</a>

<a href="/reports/monthly">Monthly Attendance Report</a>

<a href="/reports/expense">Expense Report</a>


12.  Use question 11 html
Write partialLinkText() locators that uniquely identify:	Daily Attendance Report and Monthly Attendance Report
 without using the entire link text.
 
 
 CSS Selector: 
 
 <input type="text"
       name="username"
       data-testid="login-user"
       autocomplete="off">
       
       Write a CSS selector that identifies the element using:

		type
		name
		data-testid

All three attributes must be included.


13.Write a CSS selector using starts-with attribute matching.

 <input id="username_729812"
       type="text"
       name="username">
       
       <input id="username_842951"
       type="text"
       name="username">
       
       The constant portion is: username_
       
  14. Write the CSS selector.
  
  <input id="qa_784_emailField"
       name="email">
       
            qa_784_
			qa_927_	
			qa_165_
		but it always ends with: _emailField

16. <button data-testid="employee-create-submit-button"
        type="submit">
    Create Employee
</button>

You only know that data-testid will always contain:
create-submit

Write a CSS selector using substring matching.

17. Requirements:

Locate the element using CSS where:

ID starts with employee_phone_
type is tel
name is phoneNumber
data-status is enabled

Do not use the complete ID.



<input id="employee_phone_98273"
       type="tel"
       name="phoneNumber"
       class="form-control employee-input active"
       data-status="enabled">
       
       
       XPATH
    
       18. 
       <input type="text"
       name="employeeCode"
       data-active="true"
       placeholder="Employee Code">
       
       Write an XPath where all three must match:

type="text"
name="employeeCode"
data-active="true"

Use and.


19.

 <button id="approve_leave_837462"
        type="button">
    Approve
</button>

The numeric portion changes every time.
Write XPath using:
starts-with()
	to locate this button.
	
	20. 
	<input data-testid="trackofield-employee-username-field"
       type="text">
       
       You only know that data-testid contains:
       employee-username
       Write the XPath.
       
    21. 
    
       <button type="submit"
        data-action="employee-save">
      Save Employee
</button>

Write an XPath that verifies both:
data-action = employee-save
and visible text:

Save Employee

22. 

<button type="button">
        Approve Leave
</button>

Because formatting/indentation may introduce spaces, you don't want to depend on:
//button[text()='Approve Leave']
///Write a more reliable XPath using:  normalize-space()
///that matches: Approve Leave
///
///
///
///23. <input id="manager_92837"
       type="text"
       name="managerUsername"
       class="form-control searchable employee-filter"
       data-filter-type="manager"
       data-active="true">
       
       Create four different valid locators for the exact same element:
       By.id(...)
By.name(...)
By.cssSelector(...)
By.xpath(...)
For CSS and XPath, do not use the complete dynamic ID.




	 */
	
	public void first_01_Question()
	{
		WebElement id1 =driver.findElement(By.id("employee_username_7845"));
	}
	
	public void second_02_Question()
	{
		WebElement id2 =driver.findElement(By.id("saveEmployee"));
		id2.click();
	}
	
	public void third_03_Question()
	{
		WebElement name1 =driver.findElement(By.name("official_email"));
		name1.sendKeys("Karan Bajaj");
	}
	
	public void fourth_04_Question()
	{
		WebElement name2 =driver.findElement(By.name("employeeCode"));
		
		// it will retrieve first element. TO retrive both use : 
		List<WebElement> name3 = driver.findElements(By.name("employeeCode"));
	}
	
	public void fifth_05_Question()
	{
		//		By.className("btn") - valid
		//By.className("save-employee")- valid
		//		By.className("btn primary-action") - invalid as there cannot be space between class name
		//		By.className("primary-action save-employee active") - invalid as there cannot be space between class name in the Locator name. it should use (.) to connect classes
	
	}

	public void sixth_06_Question()
	{
		// size will be 3
		// no By.className() uniquely locate the Delete button using "action disabled" as  because class name cannot have space in between
	}
	
	public void seventh_07_Question()
	{
		List<WebElement> tag1 = driver.findElements(By.tagName("input"));
		System.out.println(tag1.size());
		
		
	}
	
	public void eigth_08_Question()
	{
		List<WebElement> tag2 = driver.findElements(By.tagName("a"));
		for(WebElement link : tag2)
		{
			System.out.println(link.getText());
		}
		
		
	}
	
	public void ninth_09_Question()
	{
		
		// It will be By.linkText("Forgot Password")

	}
	
	public void tenth_10_Question()
	{
		
	WebElement link2 = driver.findElement(By.linkText("Employee Management"));// it will select 1st link. linkText operator checks the paramter value should be equal to the element text. It does not use contains to verify so second will not be considered

	}
	
	public void elevnth_11_Question()
	{
		
		// It will be Daily Attendance Report and Monthly Attendance Report because partial link text verify using contains. 
		//If element text contains the parameter, then that element will be selected.
		
		//In our case since we are not using list, then first of the element will be returned <a href="/reports/daily">Daily Attendance Report</a>
	}
	
	public void twelth_12_Question()
	{
		WebElement daily1 = driver.findElement(By.partialLinkText("Daily Attendance"));
		System.out.println(daily1.getText());
		
		WebElement daily2 = driver.findElement(By.partialLinkText("Monthly Attendance"));
		daily2.getText();
	}
	
	public void thirteen_13_Question()
	{
		WebElement css1 = driver.findElement(By.cssSelector("input[type='text'][name='username'][data-testid='login-user']"));
	}
	
	public void fourteenth_14_Question() {
		
		WebElement css2 = driver.findElement(By.cssSelector("input[id^='username_']"));
		
	}
	
	public void fifteen_15_Question() {
		
		WebElement css3 = driver.findElement(By.cssSelector("input[id$='_emailField']"));
		
	}
	
	public void sixteen_16_Question() {
		
		WebElement css4 = driver.findElement(By.cssSelector("button[data-testid*='create-submit']"));
		
	}
	
	public void seventeen_17_Question() {
		
		WebElement css5 = driver.findElement(By.cssSelector("input[id^='employee_phone_'][type='tel'][name='phoneNumber'][data-status='enabled']"));
		
	}
	
	public void eigtheen_18_Ques()
	{
		WebElement xpath1 = driver.findElement(By.xpath("//input[@type='text' and @name='employeeCode' and @data-active='true']"));
	}
	
	
	public void nineteen_19_Ques()
	{
		WebElement xpath2 = driver.findElement(By.xpath("//button[starts-with(@id,'approve_leave_')]"));
	}
	
	public void twenty_20_Ques()
	{
		WebElement xpath3 = driver.findElement(By.xpath("//input[contains(@data-testid,'employee-username')]"));
	}
	
	public void twentone_21_Ques()
	{
		WebElement xpath4 = driver.findElement(By.xpath("//button[@data-action='employee-save' and normalize-space(.)=' Save Employee']"));
		System.out.println(xpath4.getAttribute("value"));
	}
	
	public void twentytwo_22_Ques()
	{
		WebElement xpath5 = driver.findElement(By.xpath("//button[normalize-space(.)='Approve Leave']"));
	}
	
	public void twentythree_23_Ques()
	{
		WebElement id23 = driver.findElement(By.id("manager_92837"));
		WebElement name23 = driver.findElement(By.name("managerUsername"));
		WebElement css23 = driver.findElement(By.cssSelector("input[id*='manager_']"));
		WebElement xpath23 = driver.findElement(By.xpath("//input[contains(@id,'manager_')]"));
	}
	
	
	
}
