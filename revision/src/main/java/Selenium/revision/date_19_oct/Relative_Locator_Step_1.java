// This  class contain knowledge about relative locator

package Selenium.revision.date_19_oct;

public class Relative_Locator_Step_1 {

	
	/*
	 * Relative Locators in Selenium 4 help you locate a web element based on the position of another element, 
	 * rather than relying only on attributes such as id, name, or class.

They are useful when elements have no unique attributes but their visual relationship to other elements is known.
	 */
	
	/*
	 * 1. Why do we need Relative Locators?
Suppose a login page contains these elements:


Username
Enter username


Password
Enter password


Login


Illustrative layout: imagine the password field has no unique locator, but you can locate the Username field.

If the password field has no unique ID or name, you can locate it relative to the Username field using below().
	 */
	
	/*
	 * 2. The five Relative Locator methods
Selenium 4 provides five main positional relationships.








1. below()

Finds an element positioned below a reference element.
import static org.openqa.selenium.support.locators.RelativeLocator.with;

WebElement username = driver.findElement(By.id("username"));

WebElement password = driver.findElement(
    with(By.tagName("input")).below(username)
);
	
	 */
	
	/*
	 * 2. above()

Finds an element positioned above a reference element.
WebElement username = driver.findElement(
    with(By.tagName("input"))
        .above(driver.findElement(By.id("password")))
);
	
	 *
	 */
	
	
	/*
	 * 
	 * 3. toLeftOf()

Finds an element positioned to the left of a reference element.
WebElement leftButton = driver.findElement(
    with(By.tagName("button"))
        .toLeftOf(driver.findElement(By.id("rightButton")))
);
	 */
	
	
	/*
	 * 
	 * 4. toRightOf()

Finds an element positioned to the right of a reference element.
WebElement rightButton = driver.findElement(
    with(By.tagName("button"))
        .toRightOf(driver.findElement(By.id("leftButton")))
);
	
	 */
	
/*
 * 5. near()

Finds an element near a reference element, within a default distance of 50 CSS pixels.
WebElement nearbyElement = driver.findElement(
    with(By.tagName("input"))
        .near(driver.findElement(By.id("username")))
);

 */

	/*
	 * 3. Required import and syntax
The Relative Locator API is available in Selenium 4.
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

General syntax:
WebElement element = driver.findElement(
    with(By.tagName("input")).below(referenceElement)
);
	 */
	
	
	/*
	 * How it works:
1. referenceElement identifies an element you can already locate.
2. with(By.tagName("input")) defines the type of element you want to find.
3. .below(referenceElement) defines the positional relationship.
4. findElement() returns the first matching element according to Selenium's locator result.
Important: The relationship alone does not guarantee uniqueness. 
If multiple elements match, choose a more specific locator or use findElements() to inspect the matches.
	 */
	
	/*
	 * 4. Can we combine Relative Locators?
Yes. You can combine positional conditions to narrow down the target.

For example, find an input below the Username field and to the right of a label:
WebElement target = driver.findElement(
    with(By.tagName("input"))
        .below(username)
        .toRightOf(label)
);


The target must satisfy both positional conditions. 
If no element satisfies the conditions, findElement() will throw NoSuchElementException.
	 */
	
	/*
	 * 5. Relative Locators vs XPath
Feature	Relative Locator	XPath
Main purpose	Locate by geometric position	Locate by DOM structure and relationships
Example	below(username)	//label[@id='username']/following::input[1]
Parent/ancestor traversal	Not its main purpose	Supported
Depends on visual position	Yes	Usually no
Best suited for	Elements identified by relative layout	Complex DOM relationships and attribute conditions

Remember: below() is not equivalent to XPath's following-sibling. One is based on rendered position; the other is based on DOM structure.
	 */
	
	/*
	 * 6. Important limitations and interview points
- Relative Locators depend on the elements' rendered positions. A responsive layout or changed viewport can affect results.
- If the reference element is missing, locating it will fail before the Relative Locator runs.
- If the page contains multiple matching elements in the requested position, the result may not be the one you intended.
- near() uses a default distance of 50 CSS pixels; Selenium also supports specifying a custom distance.
- Relative Locators do not replace XPath or CSS selectors. They are another option when positional relationships are useful.
- Always verify that the locator identifies the intended element before interacting with it.
	 */
	
	
	/*
	 * 7. Quick revision
Test your recall
What Relative Locator would you use to find a Save button positioned above a Cancel button?

Answer: with(By.tagName("button")).above(cancelButton)
WebElement saveButton = driver.findElement(
    with(By.tagName("button")).above(cancelButton)
);
	 */
}


