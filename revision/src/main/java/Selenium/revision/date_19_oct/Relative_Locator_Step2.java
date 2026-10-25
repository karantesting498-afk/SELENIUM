// This class contains questions regarding the relative  locators.

package Selenium.revision.date_19_oct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue; 
public class Relative_Locator_Step2 {
	
	WebDriver driver;
	
	/*
	 * 1. above() — 2 Questions
Q1. Difficult — Locate an element among multiple matching elements
Consider this UI:
<div>
    <label>Email</label>
    <input id="email" type="text">

    <label>Password</label>
    <input id="password" type="password">

    <label>Confirm Password</label>
    <input id="confirmPassword" type="password">

    <button id="submit">Submit</button>
</div>

Tasks:
1. Using above(), locate the input positioned above the Submit button.
2. The page contains several input elements. Explain how you would verify that the returned element is the confirmPassword field.
3. Can you guarantee that above() will always return the immediately preceding input in the HTML? Explain why or why not.
	 */
	
	public void ques_01()
	{
		/*
		 * 1. code
		 * 2. 		
		String cPassId = cPass.getAttribute("id");
		
		Assert.assertEquals(cPassId, "confirmPassword");
		 * 
		 * 3. Your answer:

Yes, relative locator only select the nearest element.

Incorrect.

The important distinction is that above() uses the elements' visual positions on the rendered page, not their order in the HTML.

For example:

An input may appear above the Submit button visually, even if CSS changes its position.

Multiple inputs may satisfy the above() condition.

Layout changes, overlapping elements, or responsive design may change which input is closest to the button.

Therefore, you cannot guarantee that above() will always return the immediately preceding input in the HTML.
		 */
		WebElement submit = driver.findElement(By.id("submit"));
		
		WebElement cPass = driver.findElement(with(By.tagName("input")).above(submit)
				);
		
		String cPassId = cPass.getAttribute("id");
		
		Assert.assertEquals(cPassId, "confirmPassword");
	}
	
	
	/*
	 * Q2. Difficult — Locate a field using a reference element
Consider a registration form containing several text fields and buttons.

You can uniquely locate the label with ID employeeIdLabel, but the input field has no ID, name, or unique class.

Tasks:
1. Write code to locate the input positioned above employeeIdLabel.
2. Verify that the returned element is an input field.
3. Explain what could happen if another input is also positioned above the label.
	 */
	
	public void ques_02()
	{
		/*
		 * 1. code
		 * code
		 * 3. Your answer:

According to the CSS, or screen display, above locator will fetch the nearest field.

The concept is partly correct, but there is an important distinction: above() considers visual positioning, not merely CSS rules or HTML order. If multiple inputs are positioned above the label, more than one element may satisfy the relative locator.

When you use driver.findElement(), Selenium returns one matching element according to the relative locator's result ordering. You should not assume that it will always identify the intended input without checking the result.

A better interview answer would be:

If multiple input elements are positioned above the label, multiple elements may satisfy the relative locator. I would verify the returned element using its attributes or other identifying information. 
If necessary, I would refine the locator to uniquely identify the intended field.
		 */
		
		WebElement label = driver.findElement(By.id("employeeIdLabel"));
		
		WebElement input = driver.findElement(with(By.tagName("input")).above(label)
				
				);
		
		Assert.assertEquals(input.getTagName(), "input");
	}
	
	
	
	// 2. below()
	
	
	/*
	 * Q3. Difficult — Locate a field in a complex form
Consider this UI:
<div>
    <label>Username</label>
    <input id="username">

    <button id="checkAvailability">Check Availability</button>

    <label>Password</label>
    <input type="password">

    <label>Confirm Password</label>
    <input type="password">
</div>

You can uniquely locate the checkAvailability button, but the password fields have no unique attributes.

Tasks:
1. Using below(), locate the input positioned below the checkAvailability button.
2. Explain whether the returned element must be the Password field.
3. Describe how you would make the locator more reliable if the page layout changes.

	 */
	
	public void ques_03()
	{
		/*
		 * 1. code
		 * 2. No. Your answer should explain that below() uses the elements' visual positions, not their HTML order.

Both password inputs are below the button in the given UI.
Therefore, you cannot assume that the first input returned is necessarily the Password field.


		 * 3. We can make code mre reliableby using:
		 * first find label text Password.
		 * Then find button using following-sibling
		 */
		WebElement avail = driver.findElement(By.id("checkAvailability"));
		
		WebElement pass = driver.findElement(with(By.tagName("input")).below(avail));
		
		WebElement label = driver.findElement(By.xpath("//label[normalize-space(.)='Password']"));
		
		WebElement passField = label.findElement(By.xpath("following-sibling::input"));

	}
	
	
	/*
	 * Q4. Difficult — Locate the correct field when multiple elements match
Consider this UI:
<div>
    <label id="addressLabel">Address</label>
    <input id="addressLine1">

    <label>City</label>
    <input id="city">

    <label>Postal Code</label>
    <input id="postalCode">
</div>

Assume the Address label is uniquely identifiable.

Tasks:
1. Use below() to locate an input positioned below the Address label.
2. Suppose the locator returns an input other than addressLine1. Explain why this might happen.
3. Write one additional verification that could help detect an incorrect match.
	 */
	
	public void ques_04()	
	{
		/*
		 * 1. code
		 * 2. Relativr locator uses visual representation to find locator.
		 * Relative locators use the elements' visual positions.

CSS positioning, responsive layouts, or overlapping elements can affect those positions.

Multiple inputs might satisfy the below() condition, so you cannot assume that the returned input is necessarily addressLine1.
		 * 
		 * 
		 * If due to css or responsiveness, relative locator might find another locator.
		 * 3. code
		 */
		WebElement address = driver.findElement(By.id("addressLabel"));
		
		WebElement input = driver.findElement(with(By.tagName("input")).below(address));
		
		Assert.assertEquals(input.getAttribute("id"), "addressLine1");
	}
	
	
	
	//3. toLeftOf()
	
	
	/*
	 * Q5. Difficult — Locate the correct button in a toolbar
Consider this UI:
<div class="toolbar">
    <button id="edit">Edit</button>
    <button>Duplicate</button>
    <button>Delete</button>
    <button id="export">Export</button>
</div>

You can uniquely locate the Export button, but the Duplicate button has no unique attribute.

Tasks:
1. Use toLeftOf() to locate a button positioned to the left of Export.
2. Explain why the returned button is not guaranteed to be Duplicate.
3. How could you verify the button's visible text after locating it?
	 */
	
	
	public void ques_05()
	{
		/*
		 * 1. code
		 * 2. 
		 * 2. Why is the returned button not guaranteed to be Duplicate?

Your explanation is partially correct.

toLeftOf(export) identifies an element based on its relative position to Export. It does not check the element's visible text.

In the given UI, Duplicate is the expected button immediately to the left of Export. However, the relative locator does not guarantee that the returned element is Duplicate. Layout changes, responsive design, or other matching buttons can affect the result.

One important distinction: toLeftOf() uses the elements' rendered positions, not merely their order in the HTML.


		 * Due to css or responsiveness, overlapping, left button might or might not be of duplicate
		 * 
		 * 3. 
		 */
		WebElement export = driver.findElement(By.id("export"));
		
		WebElement dupilicate = driver.findElement(with(By.tagName("button")).toLeftOf(export));
		
		Assert.assertEquals(dupilicate.getText(), "Duplicate");
	}
	
	/*
	 * Q6. Difficult — Locate a control in a data table
A table row contains several action buttons arranged horizontally:
<tr>
    <td>Employee A</td>
    <td>
        <button>View</button>
        <button>Edit</button>
        <button>Delete</button>
    </td>
</tr>

The Delete button can be uniquely identified using another available locator, but Edit cannot.

Tasks:
1. Use toLeftOf() to locate a button positioned to the left of Delete.
2. Explain why this approach could return View instead of Edit.
3. How could you restrict the search to the relevant table row to reduce ambiguity?
	 */
	
	public void ques_06()
	{
		/*
		 * 1. code
		 * 
		 * 
		 * 2. In the html it is not specified which button is on the left position of delete button.
		 * so when we use leftof() , it will find the nearest left element of delete.
		 * So it might select view or edit.
		 * 2. Why could it return View instead of Edit?

Your explanation is partly correct, but this statement needs correction:

so when we use leftof(), it will find the nearest left element of delete.

toLeftOf() does not guarantee that it returns the nearest button to the left. It identifies matching elements based on their rendered positions relative to Delete. If multiple buttons qualify, you should not assume which one findElement() will return.

Therefore, View and Edit can both qualify, and the returned element is not guaranteed to be Edit.



		 * 3. We can use xpath(//td[normalize-space(.)='Employee A']/following-sibling::td/child::button[normalize-space(.)='Delete']);
		 */
		WebElement delete = driver.findElement(By.xpath("//button[normalize-space(.)='Delete']"));
		WebElement edit = driver.findElement(with(By.tagName("button")).toLeftOf(delete));
		
	}
	
	
	//4. toRightOf()
	
	
	/*
	 * Q7. Difficult — Locate a field next to a label
Consider this UI:
<div class="search">
    <label>Search Employee</label>
    <input type="text">
    <button id="searchButton">Search</button>
</div>

The input has no unique attributes, but the Search button is uniquely identifiable.

Tasks:
1. Use toRightOf() to locate an input positioned to the right of the label.
2. Explain why using the Search button as a reference might produce a different result.
3. Would toRightOf() guarantee that the input is inside the same <div> as the label? Explain.
	 */
	
	
	public void ques_07()
	{
		/*
		 * 1. code
		 * 2. Using rightOf() search might lead different result because due to css or overlapping or responsiveness,
		 * input field is not displayed at right position
		 * More importantly, in the given HTML, the input is positioned to the left of the Search button.
		 *  Therefore, using toRightOf(searchButton) would not normally locate that input. 
		 *  	It could fail to find a match or select a different input elsewhere on the page.
		 * 
		 * 
		 * 
		 * 3. Does toRightOf() guarantee the input is inside the same <div>?

Your answer is incorrect.

A relative locator uses the elements' visual positions; it does not restrict the search to the same parent node.

To ensure the input is inside div.search, scope the search to that container:

WebElement container = driver.findElement(
    By.cssSelector("div.search")
);

WebElement label = container.findElement(By.tagName("label"));

WebElement input = container.findElement(
    with(By.tagName("input")).toRightOf(label)
);
		 */
		WebElement label = driver.findElement(By.xpath("//button[@id='searchButton']/preceding-sibling::label[normalize-space(.)='Search Employee']"));
		
		WebElement input = driver.findElement(with(By.tagName("input")).toRightOf(label));
		
	}
	
	/*
	 * Q8. Difficult — Locate a button in a group of similar controls
Consider a form with several buttons arranged horizontally:
<div>
    <button id="cancel">Cancel</button>
    <button>Save as Draft</button>
    <button>Submit</button>
    <button id="help">Help</button>
</div>

You can uniquely locate the Cancel button, but Save as Draft has no unique attributes.

Tasks:
1. Use toRightOf() to locate a button positioned to the right of Cancel.
2. Verify that the returned button's text is Save as Draft.
3. Explain what could go wrong if the layout changes and another button moves between Cancel and Save as Draft.
	 */
	
	public void ques_08()
	{
		/*
		 * 1. code
		 * 2. code
		 * 
		 * 3. Using rightof() will go wrong in case css is changes, responsiveness , overlapping.
		 * 
		 * When right of uses visual representation to find due to above listed issues, locating save as draft button might
		 * go wrong
		 * 
		 * 
		 * 3. What could go wrong if the layout changes?

Your explanation is partially correct. CSS changes, responsive layouts, and overlapping elements can affect relative positioning.

The specific issue in this question is that if another button moves between Cancel and Save as Draft, toRightOf(cancel) might return that button instead. The relative locator does not guarantee that it selects the immediately adjacent button or the button with the expected text.

Your assertion helps detect an incorrect match, but it does not prevent one.
		 */
		WebElement cancel = driver.findElement(By.id("cancel"));
		
		WebElement save = driver.findElement(with(By.tagName("button")).toRightOf(cancel));
		
		Assert.assertEquals(save.getText(), "Save as Draft");
		
		
	}
	
	
	
	//5. near() —
	
	
	/*
	 * 
	 * Q9. Difficult — Locate a nearby field
Consider a form containing several input fields:
<div>
    <label>First Name</label>
    <input id="firstName">

    <label>Last Name</label>
    <input>

    <label>Mobile Number</label>
    <input>
</div>

You can uniquely locate the First Name field, but the Last Name input has no unique attributes.

Tasks:
1. Use near() to locate an input near the First Name field.
2. Explain why the returned element might be First Name itself rather than Last Name.
3. How would you verify the result and reduce the chance of selecting the wrong input?
	 */
	
	public void ques_09()
	{
		/*
		 * 1. code
		 * 
		 * 2. Returned element might be first name itself because near only find in the radisus of 50 pixels.
		 * 
		 * If no other input is found then it will return first name.
		 * It might not found other due to css, responsiveness, overlapping
		 * 
		 * 3. code
		 */
		WebElement first = driver.findElement(By.id("firstName"));
		
		WebElement last = driver.findElement(with(By.tagName("input")).near(first));
		
		WebElement otherApproach = driver.findElement(By.xpath("//label[normalize-space(.)='Last Name']/following-sibling::input[1]"));
		
		Assert.assertTrue(last.equals(otherApproach));
		
	}
	
	
	
	/*
	 * Q10. Difficult — Use a custom distance
Consider a dashboard containing a uniquely identifiable notification icon and several nearby buttons.

You need to locate a button within 30 CSS pixels of the notification icon.

Tasks:
1. Write Selenium Java code using near() with a custom distance of 30 pixels.
2. Explain the purpose of specifying a custom distance.
3. If two buttons fall within the specified distance, how would you determine which one is the intended target?
	 */
	
	public void ques_10()
	{
		/*
		 * 1. code
		 * 2. By default near search in radius of 50 pixels. but we can custom set this range through this
		 * 
		 * 
		 * 2. Purpose of specifying a custom distance

Your explanation is partially correct.

The default distance for near() is 50 CSS pixels.

You can specify a custom distance, such as 30 pixels, to narrow the set of elements considered nearby.

The distance is not restricted to a range of 0–50; you can specify other non-negative distances as appropriate.

A smaller distance can reduce ambiguity, but it does not guarantee that the correct button will be selected.
		 * 
		 * 3.code
		 */
		WebElement notification = driver.findElement(By.id("notification"));
		
		WebElement button = driver.findElement(with(By.tagName("button")).near(notification, 30));
		
		Assert.assertEquals(button.getText(),"intended button");
		
		
	}
	
	
	
	//6. Combination of Relative Locators
	
	/*
	 * 
	 * Q11. Difficult — Combine two positional conditions
Consider this UI:
<div class="form">
    <label id="usernameLabel">Username</label>
    <input id="username">

    <label>Password</label>
    <input type="password">

    <label>Confirm Password</label>
    <input type="password">

    <button id="submit">Submit</button>
</div>

You can uniquely locate the Username label and the Submit button. The Password and Confirm Password inputs do not have unique attributes.

Tasks:
1. Use a combination of below() and above() to locate an input positioned below the Username label and above the Submit button.
2. Explain what happens if both password inputs satisfy the positional conditions.
3. How would you verify that the returned element is the Confirm Password input rather than the Password input?
4. Interview follow-up: Does combining two Relative Locator conditions guarantee a unique result?
	 */
	
	public void ques_11()
	{
		/*
		 * 1. code
		 * 2. IN the code both password and confirm password satisfy the condition.
		 * Either of these 2 input can be selected as per visual represenation
		 * 
		 * 3. code
		 * 
		 * 4. It may depend upon css , responsiveness of the page.
		 * 
		 * No. Combining below() and above() narrows the set of matching elements, but it does not guarantee that only one element satisfies both conditions. 
		 * Multiple elements can still meet both positional conditions.
		 */
		WebElement usernameLabel  = driver.findElement(By.id("usernameLabel"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		WebElement password = driver.findElement(with(By.tagName("input")).below(usernameLabel).above(submit));

		
		WebElement label = driver.findElement(By.xpath("//label[normalize-space(.)='Confirm Password']/following-sibling::input[1]"));
		
		Assert.assertTrue(password.equals(label));
		
	}
	
	
	
	/*
	 * Q12. Difficult — Combine three positional conditions
Consider a toolbar:
<div class="toolbar">
    <button id="refresh">Refresh</button>
    <button>Filter</button>
    <button>Sort</button>
    <button>Export</button>
    <button id="help">Help</button>
</div>

You can uniquely locate the Refresh and Help buttons, but the Filter, Sort, and Export buttons have no unique attributes.

Tasks:
1. Use a combination of toRightOf(), toLeftOf(), and near() to locate a button that satisfies all three conditions.
2. Explain how the conditions can help narrow down the matching elements.
3. If more than one button satisfies all three conditions, what would you change to make your solution more reliable?
4. Interview follow-up: What are the limitations of using geometric relationships to locate elements in responsive layouts?
	 */
	
	public void ques_12()
	{
		/*
		 * 1. code
		 * 2. Using combination condtion helps narrowing down but any change in css or responsiveness makes it go wrong.
		 * even without these, it only narrows , it does not gurantee that correct element will be found.
		 * 
		 * 3. We can use assert condition to check our simply use xpath
		 * "//div[@class='toolbar']/child::button[normalize-space(.)='Sort']";
		 * 
		 * 
		 * 4. In responsive layout, position of button changes with screen size.
		 * and relative locator uses visual representation for finding element.
		 * so change in responsiveness might find incorrect element
		 */
		WebElement refresh = driver.findElement(By.id("refresh"));
		WebElement help = driver.findElement(By.id("help"));
		
		WebElement button = driver.findElement(with(By.tagName("button")).toLeftOf(help).toRightOf(refresh).near(refresh));
		
		
	}
	
	
	
	
	
}
