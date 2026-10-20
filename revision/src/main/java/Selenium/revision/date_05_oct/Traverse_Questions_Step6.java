package Selenium.revision.date_05_oct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Traverse_Questions_Step6 {
	
	WebDriver driver;
	
	//1. parent::
	
	/*
	 * Q1. 
	 * 		Starting from the input, locate its immediate parent <div>.
		Requirements:
- Use parent::
- Identify input using name
- Parent must have class field-wrapper

	 * <div class="field-wrapper">
    		<input type="text"
           name="employeeCode"
           data-status="active">
		</div>
		

	 */
	
	public void first_01_Ques()
	{
		WebElement p1 = driver.findElement(By.xpath("//input[@name='employeeCode']/parent::div"));
	}
	
	/*2.Starting from: name="officialEmail"
	 * locate only: <div class="input-box"> 
	 * 
	 * 
	 * <section class="form-section">
    <div class="input-box">
        <input type="email" name="officialEmail">
    </div>
</section>
	 */
	
	public void second_02_Ques()
	{
		WebElement p2 = driver.findElement(By.xpath("//input[@name='officialEmail']/parent::div"));
	}
	
	/*3. Starting from the second Edit button, locate its parent div.
You may use XPath indexing.
	 * 
	 * 
	 * <div class="active-user">
    <button type="button" data-action="edit">
        Edit
    </button>
</div>

<div class="inactive-user">
    <button type="button" data-action="edit">
        Edit
    </button>
</div>
	 */
	
	public void third_03_Ques()
	{
		WebElement p3 = driver.findElement(By.xpath("(//button[@type='button' and @data-action='edit'])[2]/parent::div"));
	}
	
	/*4. Starting from:
	 * <input name="username">
	 * 
	 * locate its parent only if the parent's:data-status = active
	 * 
	 * 
	 * <div class="employee-row" data-status="active">
    <input name="username" value="karan">
</div>
	 */

	public void fourth_04_Ques()
	{
		WebElement p4 = driver.findElement(By.xpath("//input[@name='username']/parent::div[@data-status='active']"));
	}
	
	/*5. Would this locate the form?
	 * 
	 * //input[@name='designation']/parent::form
	 * 
	 * If not, write an XPath using only parent:: traversal that reaches the <form>.
	 * 
	 * 
	 * <form class="employee-form">
    <div class="control">
        <input name="designation">
    </div>
</form>
	 */
	
	public void fifth_05_Ques()
	{
		// No //input[@name='designation']/parent::form this will not work. Parent:: can only find direct parent element
		//to access form we need following xpath
		WebElement p5 = driver.findElement(By.xpath("//input[@name='designation']/parent::div/parent::form"));
	}
	
	//2. child::
	
	/*6. Starting from: <div class="login-form">
	 * locate the direct child whose: name = password
	 *  
	 * <div class="login-form">
    <input name="username">
    <input name="password">
    <button type="submit">Login</button>
</div>
	 */
	
	public void sixth_06_Ques()
	{

		WebElement c1 = driver.findElement(By.xpath("//div[@class='login-form']/child::input[@name='password']"));
	}
	
	
	/*7. Locate the second direct button child of .actions.
Do not use button text.
	 * 
	 * 
	 * <div class="actions">
    <span>Available Actions</span>
    <button type="button">Approve</button>
    <button type="button">Reject</button>
</div>
	 */
	
	public void sixth_07_Ques()
	{

		WebElement c2 = driver.findElement(By.xpath("//div[@class='actions']/child::button[2]"));
	}
	
	
	/*8. Write an XPath using child:: that selects only: <input type="text">
	 * It must not select the nested email input.
	 * 
	 * <div class="employee">
    <input type="text">
    
    <section>
        <input type="email">
    </section>
</div>
	 */
	
	public void eigth_08_Ques()
	{

		WebElement c3 = driver.findElement(By.xpath("//div[@class='employee']/child::input[@type='text']"));
	}
	
	/*9. Using child::, locate the last direct select child.
Do not use name="date".
	 * 
	 * 
	 * <div id="filters">
    <select name="employee">
    </select>

    <select name="status">
    </select>

    <select name="date">
    </select>
</div>
	 */
	public void ninth_09_Ques()
	{

		WebElement c4 = driver.findElement(By.xpath("//div[@id='filters']/child::select[3]"));
	}
	
	
	/*10. Locate the second direct span using:
	 * 
	 * 
	 * <div class="card">
    <span class="title">Employee</span>
    <span class="status">Active</span>
    <span class="date">09 Oct 2026</span>
</div>


	 */
	
	public void tenth_10_Ques()
	{

		WebElement c5 = driver.findElement(By.xpath("//div[@class='card']/child::span[2]"));
	}
	
	//3. ancestor::
	
	/*11. Starting from: <input name="employeeCode">
	 * locate: <form class="employee-form">
	 * 
	 * 
	 * <form class="employee-form">
    <section>
        <div class="field">
            <input name="employeeCode">
        </div>
    </section>
</form>
	 */
	
	public void eleven_11_ques()
	{
		WebElement a1 = driver.findElement(By.xpath("//input[@name='employeeCode']/ancestor::form"));
	}
	
	/*12.Starting from the button, locate the ancestor with: class="panel"
	 * 
	 * <div class="page">
    <div class="panel">
        <div class="row">
            <button data-action="approve">Approve</button>
        </div>
    </div>
</div>
	 */
	public void twelve_12_ques()
	{
		WebElement a2 = driver.findElement(By.xpath("//button[@data-action='approve']/ancestor::div[@class='panel']"));
	}
	
	/*13.Starting from Edit, locate: <div class="employee-row" data-id="101">
	 * 
	 * <div class="employee-table">
    <div class="employee-row" data-id="101">
        <div class="actions">
            <button>Edit</button>
        </div>
    </div>
</div>
	 * 
	 * 
	 */
	
	public void thirteen_13_ques()
	{
		WebElement a3 = driver.findElement(By.xpath("//button/ancestor::div[@class='employee-row' and @data-id='101']"));
	}
	
	/*14.Starting from the button identified using:normalize-space(.)='Approve Leave'
	 * locate its form ancestor having:
	 * 
	 * <form data-form="leave">
    <section>
        <div>
            <button>
                 Approve Leave
            </button>
        </div>
    </section>
</form>
	 * 
	 * 
	 */
	
	public void fourteen_14_ques()
	{
		WebElement a4 = driver.findElement(By.xpath("//button[normalize-space(.)='Approve Leave']/ancestor::form[@data-form='leave']"));
	}
	
	
	/*15. Starting from the input: //input[@name='username']/ancestor::div
	 * 
	 * How many div elements potentially match?
Then write an XPath that selects only the nearest ancestor div.
	 * 
	 * 
	 * <div class="outer">
    <div class="inner">
        <span>
            <input name="username">
        </span>
    </div>
</div>
	 * 
	 * 
	 */
	public void fifteen_15_Ques()
	{
		//it will match 2 div
		//to reach nearest ancestor div
		
		WebElement a5 =driver.findElement(By.xpath("//input[@name='username']/ancestor::div[@class='inner'][1]"));
	}
	
	//4. descendant:: 
	
	/*16. Starting from .employee-form, locate the nested username input using:descendant
	 * 
	 * 
	 * <div class="employee-form">
    <section>
        <div>
            <input name="username">
        </div>
    </section>
</div>


	 */
	
	public void sixteen_16_Ques()
	{
		WebElement d1 = driver.findElement(By.xpath("//div[@class='employee-form']/descendant::input[@name='username']"));
	}
	
	/*17.
	 * Locate all input descendants of: id="registration"
	 * 
	 * <div id="registration">
    <div>
        <input type="text">
    </div>

    <section>
        <input type="email">
    </section>

    <aside>
        <input type="password">
    </aside>
</div>
	 */
	public void seventeen_17_Ques()
	{
		List<WebElement> d2 = driver.findElements(By.xpath("//div[@id='registration']/descendant::input"));
		System.out.println(d2.size());
	}
	
	/*18. Starting from employee-panel, locate only the descendant button where:type="submit"
	 * 
	 * <div class="employee-panel">
    <section>
        <button type="button">Edit</button>
    </section>

    <section>
        <button type="submit">Save</button>
    </section>
</div>
	 */
	
	public void eigtheen_18_Ques()
	{
		WebElement d3 = driver.findElement(By.xpath("//div[@class='employee-panel']/descendant::button[@type='submit']"));
	}
	
	/*19. Locate the second descendant having:class="report-name"
	 * 
	 * 
	 * <div class="reports">
    <section>
        <div>
            <span class="report-name">Attendance</span>
        </div>
    </section>

    <section>
        <span class="report-name">Expense</span>
    </section>
</div>
	 */
	
	public void nineteen_19_Ques()
	{
		WebElement d3 = driver.findElement(By.xpath("//div[@class='reports']/descendant::span[@class='report-name'][2]"));
	}
	
	/*20. Locate the second descendant button whose normalized text is Save.
	 * 
	 * 
	 * <div class="module">
    <div>
        <div>
            <button>Save</button>
        </div>
    </div>

    <div>
        <button>Save</button>
    </div>
</div>
	 */
	
	public void twenty_20_Ques()
	{
		WebElement d3 = driver.findElement(By.xpath("//div[@class='module']/descendant::button[normalize-space(.)='Save'][2]"));
	}
	
	
	//5. following-sibling::
	
	/*21. Starting from:<label>Username</label>
	 * locate the username input using following-sibling::.
	 * 
	 * 
	 * <label>Username</label>
<input name="username">

<label>Password</label>
<input name="password">


	 */
	
	public void twentyone_21_ques()
	{
		WebElement fs1 = driver.findElement(By.xpath("//label[normalize-space(.)='Username']/following-sibling::input[@name='username']"));
	}
	
	
	/*
	 * 22.
	 * Starting from the input, locate the second following button sibling.
Do not use button text.
	 * 
	 * <input name="employee">
<button>Edit</button>
<button>Delete</button>
<button>Deactivate</button>
	 */
	
	public void twentytwo_22_ques()
	{
		WebElement fs2 = driver.findElement(By.xpath("//input[@name='employee']/following-sibling::button[2]"));
	}
	
	/*23. Starting from:<span class="label">
	 * 
	 * locate the immediate next span sibling.
	 * 
	 * <span class="label">Employee Status</span>
<span class="value">Active</span>
<span class="message">Verified</span>
	 */
	
	public void twentythree_23_ques()
	{
		WebElement fs3 = driver.findElement(By.xpath("//span[@class='label']/following-sibling::span"));
	}
	
	/*24. Starting from Approve, locate the first following button sibling.
Be careful: a <div> exists between them.
	 * 
	 * <button>Approve</button>
<div>Information</div>
<button>Reject</button>
<button>Cancel</button>
	 */
	public void twentyfour_24_ques()
	{
		WebElement fs4 = driver.findElement(By.xpath("//button[normalize-space(.)='Approve']/following-sibling::button"));
	}
	
	/*25. Starting from the label identified using: normalize-space(.)='Employee'
	 * locate the third following input sibling.
	 * 
	 * <label>
    Employee
</label>

<input name="employee">

<input name="manager">

<input name="executive">
	 */
	public void twentyfive_25_ques()
	{
		WebElement fs5 = driver.findElement(By.xpath("//label[normalize-space(.)='Employee']/following-sibling::input[3]"));
	}
	
	//6. preceding-sibling:: 
	
	/*26.Starting from the input, locate its preceding label.
	 * 
	 * <label>Username</label>
<input name="username">
	 */
	
	public void twentysix_26_ques()
	{
		WebElement ps1 = driver.findElement(By.xpath("//input[@name='username']/preceding-sibling::label"));
	}
	
	/*27. Starting from the input, locate the nearest preceding button sibling.
Which button should be selected?
	 * 
	 * <button>Save</button>
<button>Edit</button>
<button>Delete</button>
<input name="employee">
	 */
	
	public void twentyseven_27_ques()
	{
		WebElement ps2 = driver.findElement(By.xpath("//input[@name='employee']/preceding-sibling::button[1]"));
		// it will select delete button
	}
	
	/*28. Starting from the Details button, locate the second nearest preceding span sibling.
Do not use text.
	 * 
	 * <span>Created</span>
<span>Approved</span>
<span>Completed</span>
<button data-action="details">Details</button>
	 */
	
	public void twentyeigth_28_ques()
	{
		WebElement ps3 = driver.findElement(By.xpath("//button[@data-action='details']/preceding-sibling::span[2]"));
	}
	
	/*29. 
	 * Starting from the input, locate the preceding label.
Your XPath should ignore the <div> between them.
	 * 
	 * <label>Employee</label>
<div class="help">Select employee</div>
<input name="employee">
	 */
	public void twentynine_29_ques()
	{
		WebElement ps4 = driver.findElement(By.xpath("//input[@name='employee']/preceding-sibling::label[normalize-space(.)='Employee']"));
		
		
	}
	
	/*30. Starting from marker, locate the third nearest preceding button.
Do not use button text.
	 * 
	 * <button class="action">Add</button>
<button class="action">Edit</button>
<button class="action">Delete</button>
<button class="action">Restore</button>
<input id="marker">
	 */
	
	public void thirty_30_ques()
	{
		WebElement ps5 = driver.findElement(By.xpath("//input[@id='marker']/preceding-sibling::button[3]"));
		
		
	}
	
	//7. following:: — 5 Hard Questions
	
	/*31. Starting from username, locate the Login button using following::.
	 * 
	 * <div>
    <input id="username">
</div>

<section>
    <button type="submit">Login</button>
</section>
	 */
	
	
	public void thirtyone_31_Ques()
	{
		WebElement f1 = driver.findElement(By.xpath("//input[@id='username']/following::button[@type='submit']"));
	}
	
	/*32. Starting from the employee input, locate the second following button in document order.
Do not use button text.
	 * 
	 * <input name="employee">

<div>
    <button>Edit</button>
</div>

<section>
    <button>Delete</button>
</section>

<button>Deactivate</button>
	 */
	public void thirtytwo_32_Ques()
	{
		WebElement f2 = driver.findElement(By.xpath("//input[@name='employee']/following::button[2]"));
	}
	
	/*33 Starting from id="start", locate the third following input.
	 * 
	 * <div>
    <span id="start">Employee</span>
</div>

<div>
    <input type="text">
    <input type="email">
    <input type="password">
</div>
	 */
	
	public void thirtythree_33_Ques()
	{
		WebElement f3 = driver.findElement(By.xpath("//span[@id='start']/following::input[3]"));
	}
	
	/*34. 
	 * Starting from data-action="start", locate the following button whose normalized text is:Complete
	 * 
	 * <button data-action="start">
    Start
</button>

<div>
    <span>Processing</span>
</div>

<section>
    <button>
        Complete
    </button>
</section>
	 */
	
	public void thirtyfour_34_Ques()
	{
		WebElement f4 = driver.findElement(By.xpath("//button[@data-action='start']/following::button[normalize-space(.)='Complete']"));
	}
	
	
	/*35.
	 * 
	 * Starting from marker, locate the second following button having type="submit".
	 * 
	 * <input id="marker">

<div>
    <button type="button">One</button>
</div>

<div>
    <button type="submit">Two</button>
</div>

<div>
    <button type="submit">Three</button>
</div>
	 */
	
	public void thirtyfive_35_Ques()
	{
		WebElement f5 = driver.findElement(By.xpath("//input[@id='marker']/following::button[@type='submit'][2]"));
	}
	
	
	//8. preceding::
	
	
	/*36. Starting from employee input, locate the preceding button.
	 * 
	 * <button>Save</button>

<div>
    <input id="employee">
</div>
	 */
	public void thirtysix_36_Ques()
	{
		WebElement p1 = driver.findElement(By.xpath("//input[@id='employee']/preceding::button"));
	}
	
	/*37 
	 * Starting from marker, locate the nearest preceding input.
	 * 
	 * <input type="text">
<input type="email">

<section>
    <div>
        <span id="marker">Marker</span>
    </div>
</section>
	 */
	
	public void thirtyseven_37_Ques()
	{
		WebElement p2 = driver.findElement(By.xpath("//span[@id='marker']/preceding::input[1]"));
	}
	
	/*38 
	 * 
	 * Starting from end, locate the second nearest preceding button where:type="submit"
	 * 
	 * <button type="button">Add</button>

<div>
    <button type="submit">Save</button>
</div>

<section>
    <button type="submit">Update</button>
</section>

<input id="end">
	 */
	
	public void thirtyeight_38_Ques()
	{
		WebElement p3 = driver.findElement(By.xpath("//input[@id='end']/preceding::button[@type='submit'][2]"));
	}
	
	/*39
	 * Starting from current, locate the third nearest preceding element having class status.
Do not use the status text.
	 * 
	 * <span class="status">Created</span>

<div>
    <span class="status">Approved</span>
</div>

<section>
    <span class="status">Completed</span>
</section>

<input id="current">
	 */
	
	public void thirtynine_39_Ques()
	{
		WebElement p4 = driver.findElement(By.xpath("//input[@id='current']/preceding::span[@class='status'][3]"));
	}
	
	
	/*40 
	 * 
	 * Starting from marker, locate the preceding button whose normalized text is:Create Employee
	 * 
	 * <button>
      Create Employee
</button>

<div>
    <button>
      Edit Employee
    </button>
</div>

<section>
    <input id="marker">
</section>
	 */
	
	public void fourty_40_Ques()
	{
		WebElement p5 = driver.findElement(By.xpath("//input[@id='marker']/preceding::button[normalize-space(.)='Create Employee']"));
	}
	
	
	//Mixed Traversal Questions
	
	
	/*41
	 * Start from:username = karan
	 * using normalize-space().
Then:
1. Go to the employee-row using ancestor::
2. From that employee row, locate the descendant button:
   data-action="delete"
Your final XPath should locate Delete, not the row.
	 * 
	 * 
	 * <div class="employee-row" data-id="101">
    <div class="employee-info">
        <span class="username">
            karan
        </span>
    </div>

    <div class="actions">
        <button data-action="edit">Edit</button>
        <button data-action="delete">Delete</button>
    </div>
</div>
	 */
	public void fourtyone_41_Ques()
	{
		WebElement m1 = driver.findElement(By.xpath("//span[@class='username' and normalize-space(.)='karan']/ancestor::div[@class='employee-row']/descendant::button[@data-action='delete']"));
	}
	
	
	/*42
	 * Starting from:
Karan

Requirements:
1. Locate Karan's employee-row ancestor.
2. Move to its next employee-row using following-sibling::.
3. Locate the descendant button inside that row.
	 * 
	 * <div class="employee-row">
    <div>
        <span class="username">Karan</span>
    </div>
</div>

<div class="employee-row">
    <div class="information">
        <span>Rahul</span>
    </div>

    <div class="actions">
        <button>Edit</button>
    </div>
</div>
	 */
	
	public void fourtytwo_42_Ques()
	{
		WebElement m2 = driver.findElement(By.xpath("//span[@class='username' and normalize-space(.)='Karan']/ancestor::div[@class='employee-row']/following-sibling::div[@class='employee-row']/descendant::button"));
	}
	
	
	/*43
	 * Starts from <input name="employee">
	 * Requirements:
1. Go to its parent.
2. Move to the following sibling having class actions.
3. Locate its second button child.
Do not use button text.
	 * 
	 * <div class="field">
    <label>Employee</label>
    <input name="employee">
</div>

<div class="actions">
    <button>Save</button>
    <button>Save & New</button>
    <button>Cancel</button>
</div>
	 */
	
	
	public void fourtythree_43_Ques()
	{
		WebElement m3 = driver.findElement(By.xpath("//input[@name='employee']/parent::div/following-sibling::div[@class='actions']/child::button[2]"));
	}
	
	
	/*44 
	 * starts from Employee B
	 * 
	 * Requirements:
1. Use normalize-space()
2. Move to its employee-row ancestor
3. Move to the preceding employee-row
4. Find the descendant button
Your locator should ultimately locate: Edit A

without directly using Edit A text.


	 * 
	 * <div class="employee-row">
    <div class="information">
        <span>Employee A</span>
    </div>

    <div>
        <button>Edit A</button>
    </div>
</div>

<div class="employee-row">
    <div class="information">
        <span>Employee B</span>
    </div>

    <div>
        <button>Edit B</button>
    </div>
</div>
	 */
	
	
	
	public void fourtyfour_44_Ques()
	{
		WebElement m4 = driver.findElement(By.xpath("//span[normalize-space(.)='Employee B']/ancestor::div[@class='employee-row']/preceding-sibling::div[@class='employee-row'][1]/descendant::button"));
	}
	
	
	/*45
	 * 
	 * You know only: karan
	 * 
	 * 	Write one XPath that:
1. Finds Karan using normalize-space(.)
2. Moves to Karan's employee-row using ancestor::
3. Verifies the row has:data-status="active"
data-status="active"

data-status="active"


Moves to the next employee-row using following-sibling::
Locates its descendant:data-action="deactivate"

1. data-action="deactivate"

The final element returned must be Aman's Deactivate button.
	 * 
	 * 
	 * <div class="employee-row" data-status="inactive">
    <div class="details">
        <span class="username">
              Rahul
        </span>
    </div>

    <div class="actions">
        <button data-action="edit">Edit</button>
        <button data-action="activate">Activate</button>
    </div>
</div>

<div class="employee-row" data-status="active">
    <div class="details">
        <span class="username">
             Karan
        </span>
    </div>

    <div class="actions">
        <button data-action="edit">Edit</button>
        <button data-action="deactivate">Deactivate</button>
    </div>
</div>

<div class="employee-row" data-status="active">
    <div class="details">
        <span class="username">
             Aman
        </span>
    </div>

    <div class="actions">
        <button data-action="edit">Edit</button>
        <button data-action="deactivate">Deactivate</button>
    </div>
</div>
	 */
	
	
	public void fourtyfive_45_Ques()
	{
		WebElement m5 =driver.findElement(By.xpath("//span[@class='username' and normalize-space(.)='Karan']/ancestor::div[@class='employee-row' and @data-status='active'][1]/following-sibling::div[@class='employee-row']/descendant::button[@data-action='deactivate']"));
	}
	
	
	
}


