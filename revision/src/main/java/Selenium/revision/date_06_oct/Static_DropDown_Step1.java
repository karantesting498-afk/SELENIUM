// THis class is about the static drop-down

package Selenium.revision.date_06_oct;

public class Static_DropDown_Step1 {
	
	/*
	 * Static drop-down are created using <select> tag
	 * 
	 * e.g
	 * 
	 * <select id="country">
    <option value="IN">India</option>
    <option value="US">USA</option>
    <option value="UK">United Kingdom</option>
</select>

-------------------

For this, Selenium provides the Select class.

import org.openqa.selenium.support.ui.Select;

WebElement countryDropdown  = drier.findElement(By.xpath("//select[@id='country']")); 

^^that WebElement is pointing to the actual <select> element.

Select country = new Select(countryDropdown); 

^^you are telling Selenium:Treat this particular WebElement as a dropdown.

After that, the Select object works on that same <select> element.

---------------------------------------------------------------------------------------

The three main ways to select an option are:
country.selectByVisibleText("India"); This selects based on the text visible to the user.
country.selectByValue("IN"); This selects based on the value visible to the user.
country.selectByIndex(0);This selects based on the position


---------------------------------------------

Unlike XPath indexing, Select index starts from 0: just like java
-------------------------------------


You can also get all dropdown options:  List<WebElement> options = country.getOptions();

then we can get all options text print
for (WebElement option : options) {
    System.out.println(option.getText());
}


To get the currently selected option:
WebElement selectedOption =
        country.getFirstSelectedOption();

System.out.println(selectedOption.getText());


-------------------------------------------


To check whether a dropdown allows multiple selections:

boolean multiple = country.isMultiple();

System.out.println(multiple);

If HTML contains:

<select id="skills" multiple>

then it is a multi-select dropdown.

-------------------------------------

You can select multiple options:

Select skills = new Select(
        driver.findElement(By.id("skills"))
);

skills.selectByVisibleText("Java");
skills.selectByVisibleText("Selenium");

-------------------------------------------

For multi-select dropdowns, you can deselect options:

skills.deselectByVisibleText("Java");

skills.deselectByValue("selenium");

skills.deselectByIndex(1);

skills.deselectAll();

---------------------------------------

methods to remember 
selectByVisibleText()
selectByValue()
selectByIndex()

getOptions()
getFirstSelectedOption()
getAllSelectedOptions()

isMultiple()

deselectByVisibleText()
deselectByValue()
deselectByIndex()
deselectAll()



--------------

Exception you get in this case is : UnexpectedTagNameException


	 */

}
