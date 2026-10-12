// THis class contains static drop-down questions

package Selenium.revision.date_6_oct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Static_dd_Ques_Step2 {
	
	WebDriver driver;
	
	
	/*1. 
	 * Write Selenium code to:
- Locate the dropdown.
- Create a Select object.
- Select India using selectByVisibleText().
- Then select United States using selectByValue().
- Then select United Kingdom using selectByIndex().
Also answer:
What index should be used for United Kingdom?
	 * 
	 * <select id="country">
    <option value="">Select Country</option>
    <option value="IN">India</option>
    <option value="US">United States</option>
    <option value="UK">United Kingdom</option>
</select>	
	 */
	
	public void ques_1()
	{
		WebElement countryDd= driver.findElement(By.xpath("//select[@id='country']"));
		
		Select country = new Select(countryDd);
		country.selectByVisibleText("India");
		country.selectByValue("US");
		country.selectByIndex(3);
		// Since select works from index 0 and position of united kingdom is 3, then index should be 3
	}
	
	/*2.
	 * 
	 * Write Selenium code that:
1. Locates the dropdown.
2. Gets all available options using getOptions().
3. Prints every option.
4. Prints the total number of options.
5. Verifies whether QA Engineer exists in the dropdown.
Do not directly select QA Engineer.

	 * 
	 * <select id="designation">
    <option value="">Select Designation</option>
    <option value="SE">Software Engineer</option>
    <option value="QA">QA Engineer</option>
    <option value="BA">Business Analyst</option>
    <option value="PM">Project Manager</option>
</select>
	 */

	public void ques_2()
	{
		WebElement countrydd2 = driver.findElement(By.id("designation"));
		Select country2 = new Select(countrydd2);
		
		List<WebElement> options = country2.getOptions();
		boolean exist = false;
		for(WebElement option : options)
		{
			System.out.println(option.getText());
			
			System.out.println("---------");
			System.out.println(options.size());
			
			if(option.getText().equalsIgnoreCase("QA Engineer"))
			{
				System.out.println("Print qa engineer exist");
				exist  = true;
			}
	
		}
		if(exist==false)
		{
			System.out.println("QA Engineer does not exist");
		}
	}
	
	
	
	/*3. 
	 * Suppose Selenium executes: status.selectByValue("inactive");
	 * 
	 * Write code to:
- Retrieve the currently selected option.
- Store its visible text in a String.
- Verify that the selected value is Inactive.
	 * 
	 * <select id="employeeStatus">
    <option value="active">Active</option>
    <option value="inactive">Inactive</option>
    <option value="deactivated">Deactivated</option>
</select>
	 */
	
	
	public void ques_03()
	{
		WebElement dd3 = driver.findElement(By.id("employeeStatus"));
		
		Select  status = new Select(dd3);
		
		status.selectByValue("inactive");
		
		String st = status.getFirstSelectedOption().getText();
		
		if(st.equalsIgnoreCase("Inactive"))
		{
			System.out.println("Print matches");
		}
		else
		{
			System.out.println("does not match");
		}
		
		
	}
	
	
	
	/*4.
	 * 
	 * Write Selenium code to:
1. Verify that this is a multi-select dropdown.
2. Select:
   - Java
   - Selenium
   - API Testing
3. Retrieve all selected options.
4. Print their visible text.
5. Deselect Selenium.
6. Verify how many options remain selected.
7. Finally deselect everything.
Use methods such as:
isMultiple()
getAllSelectedOptions()
deselectByVisibleText()
deselectAll()
	 * 
	 * <select id="skills" multiple>
    <option value="java">Java</option>
    <option value="selenium">Selenium</option>
    <option value="api">API Testing</option>
    <option value="sql">SQL</option>
    <option value="git">Git</option>
</select>
	 */
	
	
	public void ques_04()
	{
		WebElement dd4 = driver.findElement(By.id("skills"));
		
		Select language = new Select(dd4);
		System.out.println("is multiple seletion allowed??"+ language.isMultiple());
		
		language.selectByVisibleText("Java");
		language.selectByValue("selenium");
		language.selectByIndex(2);
		
		
		List<WebElement> options = language.getAllSelectedOptions();
		
		for(WebElement option : options)
		{
			System.out.println(option.getText());
		}
		
		language.deselectByVisibleText("Selenium");
		
		List<WebElement> selected = language.getAllSelectedOptions();
		System.out.println("Remaining selected are :"+ selected.size());
		
	}
	
	/*And Selenium code:
	 * 
	 * WebElement countryDropdown =
        driver.findElement(By.id("country"));

Select country =
        new Select(countryDropdown);

country.selectByVisibleText("India");






Answer:
- Will this code work?
- If not, at which line will the problem occur?
- Why will it fail?
- What type of HTML element does Select require?
- What exception can Selenium throw in this situation?
The key thing these questions are testing is whether you understand that:


WebElement
↓
must actually represent a <select>

Select object
↓
provides dropdown operations

<option>
↓
represents the available values
	 * 
	 * <div id="country">
    <div>India</div>
    <div>USA</div>
    <div>UK</div>
</div>
	 */
	
	public void ques_05()
	{
		
		/*
		 * 1. no it will not work
		 * 2. HTML tag is not of select so select object will not work here
		 * 3. HTML tag is not of select so select object will not work here
		 * 4. UnexpectedTagNameException
		 */
	}
}

