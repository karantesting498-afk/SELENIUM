package Selenium.revision.date_5_oct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selector_normalize_index_Question_Step4 {
	WebDriver driver;
	
	/*1. 
	 * <button type="button">
       
       Approve       Leave
       
		</button>

Write an XPath that uniquely locates this button using normalize-space().
Conditions:
- Do not use @type.
- Do not use contains().
- Exact normalized text must be matched.
	 */
	
	public void first_01_ques()
	{
		WebElement n1 = driver.findElement(By.xpath("//button[normalize-space(.)='Approve Leave']"));
	}
	
	/*2. Write an XPath using normalize-space() that selects only: Approve Leave
	 * 
	 * <button type="button">
    		Approve
		
		</button>

		<button type="button">
       		Approve Leave
		</button>

		<button type="button">
    		Approve Leave Request
		</button>
	 */

	public void second_02_ques()
	{
		WebElement n2 = driver.findElement(By.xpath("//button[normalize-space(.)='Approve Leave']"));
	}
	
	/*
	 * 3. Which XPath is more suitable? By.xpath("//button[normalize-space(text())='Save Employee']") or
	 * By.xpath("//button[normalize-space(.)='Save Employee']")
	 * 
	 * 		<button type="submit">
    			<span>
          				Save Employee
    			</span>
			</button>
	 */
	
	public void third_03_ques()
	{
		//By.xpath("//button[normalize-space(.)='Save Employee']") will work because (.) will check text in complete button node
	}
	
	
	
	/*4. Write an XPath that successfully matches: Leave Approved
	 * 	<div class="status">
       			Leave        Approved
		</div>
	 */
	
	public void fourth_04_ques()
	{
		WebElement n4 = driver.findElement(By.xpath("//div[@class='status'][normalize-space(.)='Leave Approved']"));
	}
	
	/*5. 
	 * Write an XPath that uses:
- data-action="leave-approve"
- normalize-space(.)
- Exact text Approve Leave
The XPath must select only the first button.
	 * 
	 * 	<button type="button"
        	data-action="leave-approve">

        		Approve     Leave

		</button>

		<button type="button"
        	data-action="task-approve">

        		Approve     Leave

			</button>
	 */
	
	public void fifth_05_Ques()
	{
		WebElement n5 = driver.findElement(By.xpath("//button[@data-action='leave-approve'][normalize-space(.)='Approve Leave']"));

	}
	
	
	/*
	 * 6.Write an XPath that selects the third element having:
	 * 
	 * type = text
	name = employee
	 * 
	 * 
	 * <input type="text" name="employee">

		<input type="text" name="employee">

	<input type="email" name="employee">

	<input type="text" name="employee">

	<input type="text" name="manager">
	 * 
	 */
	
	public void sixth_06_Ques()
	{
		List<WebElement> i1= driver.findElements(By.xpath("//input[@type='text' and @name='employee']"));
		i1.get(2);
	}
	
	/*7.Write two XPath locators:
	 * First element having class="action"
		Last element having class="action"
	 * 
	 * <button class="action">Save</button>
<button class="action">Edit</button>
<button class="action">Delete</button>
<button class="action">Approve</button>
<button class="action">Reject</button>
	 */
	
	public void seventh_07_Ques()
	{
		List<WebElement> i2= driver.findElements(By.xpath("//button[@class='action']"));
		System.out.println(i2.getFirst().getText());
		System.out.println(i2.getLast().getText());
		
		/*
		 * or
		 * List<WebElement> i2 = driver.findElements(By.xpath("//button[@class='action']"));

			System.out.println(i2.get(0).getText());
			System.out.println(i2.get(i2.size() - 1).getText());
		 */
	}
	
	
	/*8. Write an XPath that selects: Approve
	 * 
	 * <button class="action">Save</button>
<button class="action">Edit</button>
<button class="action">Delete</button>
<button class="action">Approve</button>
<button class="action">Reject</button>
	 */
	
	public void eigth_08_Ques()
	{
		WebElement i3 = driver.findElement(By.xpath("(//button[@class='action'])[4]"));
		System.out.println(i3.getText());
	}
	
	/*9. 
	 * Consider:List<WebElement> users =
    driver.findElements(By.xpath("//input[@name='username']"));
    
    1. Which XPath retrieves the third username?

2. Which Java List statement retrieves the third username?

3. What does users.get(0) return?

4. What happens if you execute users.get(4)?
	 * 
	 * <input type="text" name="username">
		<input type="text" name="username">
		<input type="text" name="username">
		<input type="text" name="username">
	 */
	
	public void ninth_09_Ques()
	{
		//1. By.xpath((//input[@name='username'])[3])
		//2. users.get(2);
		//3. First
		//4. error will be displayed.(IndexOutOfBoundsException) out of bound. as users.size will be 3.
	}
	
	/*
	 * 10. Requirement:
Locate the third active text input.

Write the XPath.
Be careful: you want the third active input, not the third input overall.
	 * 
	 * 
	 * 
	 * <input type="text" data-status="active">

<input type="text" data-status="inactive">

<input type="text" data-status="active">

<input type="text" data-status="active">

<input type="text" data-status="inactive">

<input type="text" data-status="active">
	 */
	
	public void tenth_10_Ques()
	{
		List<WebElement> i5= driver.findElements(By.xpath("//input[@type='text' and @data-status='active']"));
		i5.get(2);
	}
	
	/*11. Write an XPath that selects the second button whose normalized text is Save.
	 * 
	 * 
	 * <button class="action">
     		Save
		</button>

		<button class="action">
       		Save
		</button>

<button class="action">
    Cancel
</button>

<button class="action">
          Save
</button>
	 */
	
	public void eleventh_11_ques()
	{
		WebElement c1= driver.findElement(By.xpath("(//button[@class='action' and normalize-space(.)='Save'])[2]"));
		
	}
	
	
	/*
	 * 12.Locate the third element whose normalized text is:Employee Created
	 * do not use java list
	 * 
	 * <div class="notification">
       Employee Created
</div>

<div class="notification">
       Employee Updated
</div>

<div class="notification">
       Employee Created
</div>

<div class="notification">
       Employee Created
</div>


	 */
	
	public void twelth_12_ques()
	{
		WebElement c2= driver.findElement(By.xpath("(//div[@class='notification' and normalize-space(.)='Employee Created'])[3]"));
		
	}
	
	/*
	 * 13. 
	 * Locate the second button whose displayed text is Save Employee.
Requirements:
- Use normalize-space(.)
- Use XPath index
- Don't locate the <span> directly

	 * 
	 * 
	 * <button class="submit">
    <span>Save Employee</span>
</button>

<button class="submit">
    <span>
         Save Employee
    </span>
</button>

<button class="submit">
    <span>Save Customer</span>
</button>

<button class="submit">
    <span>
        Save Employee
    </span>
</button>
	 */
	public void thirteen_13_ques()
	{
		WebElement c3= driver.findElement(By.xpath("(//button[@class='submit' and normalize-space(.)='Save Employee'])[2]"));
		
	}
	
	
	/*14.What is the difference between: 
	 * driver.findElement(By.xpath("(//input[@class='field'])[3]"));
	 * and 
	 * List<WebElement> fields =
    driver.findElements(By.xpath("//input[@class='field']"));

fields.get(3);

Answer:
- Which element does the XPath return?
- Which element does .get(3) return?
- Why are they different?
This is a very common Selenium interview trap.
	 * 
	 * 
	 * <input class="field">
<input class="field">
<input class="field">
... 

* 

	 * 
	 *
	 */
	
	public void fourteen_14_Ques()
	{
		/*
		 * 1. it will return third element 
		 * 2. it will return error - IndexOutOfBoundsException( incorrect because (...) at 4th position means more elements which are not listed here
		 * Difference is that in xpath , first index start from 1 so First xpath will return 3rd element but in java, index starts
		 * from 0 position
		 * so 2 will return index our of bound exception
		 */
	}
	
	/*
	 * 15.Requirement:
Locate the third button displaying Approve Leave.

You are allowed to use only:
	 * 
	 * 
	 * <button type="button">
    <span>
        Approve Leave
    </span>
</button>

<button type="button">
    <span>
        Reject Leave
    </span>
</button>

<button type="button">
    <span>
         Approve Leave
    </span>
</button>

<button type="button">
    <span>
        Approve Leave
    </span>
</button>


	 */
	
	public void fifteen_15_Ques()
	{
		WebElement c5= driver.findElement(By.xpath("(//button[@type='button' and normalize-space(.)='Approve Leave'])[3]"));

		
	}
}
