package Selenium.revision.date_6_oct;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto_suggestion_DD_Ques_Step6 {
	
	WebDriver driver;
	
	/*1. 
	 * Q1 — Delayed suggestions after typing
HTML:
<input id="citySearch" type="text">

<ul class="city-suggestions">
    <li>Delhi</li>
    <li>Delhi NCR</li>
    <li>Delhi Airport</li>
</ul>

The suggestions appear 2–3 seconds after typing.
Write Selenium code that:
- Types Del
- Uses WebDriverWait
- Waits until suggestions are visible
- Gets all suggestions
- Selects exactly Delhi
- Does not use Thread.sleep()
You should use:
sendKeys()
WebDriverWait
ExpectedConditions
findElements()
getText()
click()

	 * 
	 * 
	 */
	public void ques_01()
	{
		WebElement as1 = driver.findElement(By.id("citySearch"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		as1.sendKeys("Del");
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='city-suggestions']/child::li")));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Delhi"))
			{
				option.click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	/*2. 
	 * Q2 — Suggestions refresh while typing
Suppose the behavior is:
Type "D"
→ suggestions appear

Type "e"
→ suggestions refresh

Type "l"
→ suggestions refresh again

You write:
city.sendKeys("D");

List<WebElement> suggestions =
        driver.findElements(By.cssSelector(".suggestion"));

city.sendKeys("el");

suggestions.get(0).click();

Answer:
- What problem might occur?
- Which Selenium exception might be thrown?
- Why are the old WebElement references unsafe?
- What should you do after completing "Del"?
Then write the safer approach.

	 * 
	 * 
	 */
	
	public void ques_02()
	{
		
		/*
		 * 1. Since we are inputing the search text after the options are fetched in a list
		 * then new suggestions after input will not be loaded in the list and when user select first option, then the selected options
		 * will not be found in the suggestion.
		 * 
		 * old WebElement references might no longer represent valid elements after the suggestion list refreshes.
		 * 
		 * 
		 * 
		 * 2. Error thrown will be : StaleElementReferenceException
		 * 3. Becuase old element refrence gets stale. and using those reference leads to error
		 * 
		 * 4. After inputing del, user should wait for 2-3 seconds for suggestions to load and then fetch all the suggestions in a list.
		 * The better approach is to use an explicit wait rather than waiting a fixed 2–3 seconds. 
		 * After typing "Del", wait for the relevant suggestions to be visible, then retrieve fresh WebElement references.
		 */
		
		WebElement as2 = driver.findElement(By.id("citySearch"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		as2.sendKeys("Del");
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='city-suggestions']/child::li")));
		
		options.get(0).click();
		
		
	}
	
	/*3.
	 * Q3 — Duplicate suggestion names
HTML:
<input id="employeeSearch">

<div class="suggestions">

    <div class="employee-option"
         data-id="101">
        Rahul
    </div>

    <div class="employee-option"
         data-id="102">
        Karan
    </div>

    <div class="employee-option"
         data-id="103">
        Rahul
    </div>

</div>

You type:
Rah

Two suggestions display:
Rahul
Rahul

Requirement:
Select only Rahul whose data-id="103".

Write Selenium code that:
- Types Rah
- Waits for suggestions
- Gets all suggestions
- Checks both:
  - visible text = Rahul
  - data-id = 103
- Clicks the correct one
Do not solve it using XPath index such as:
(//div[normalize-space(.)='Rahul'])[2]

	 * 
	 * 
	 */
	
	public void ques_03()
	{
		WebElement as3 = driver.findElement(By.id("employeeSearch"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		as3.sendKeys("Rah");
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggestions']/child::div[@class='employee-option']")));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Rahul") && option.getAttribute("data-id").equalsIgnoreCase("103"))
			{
				option.click();
				break;
			}
		}
		
	}
	
	/*4.
	 * 
	 * Q4 — Exact match vs partial match trap
After typing:
Del

suggestions are:
<li>Delhi</li>
<li>Delhi NCR</li>
<li>New Delhi</li>
<li>Delhi Airport</li>

Consider:
if (suggestion.getText().contains("Delhi")) {
    suggestion.click();
}

Answer:
- How many suggestions could match?
- Why is contains("Delhi") risky here?
- What comparison would you prefer if the requirement is exactly Delhi?
- How would you make the comparison case-insensitive and ignore leading/trailing spaces?
Then write the correct selection code.
	 * 
	 * 
	 */
	
	public void ques_04()
	{
		/*
		 * 1. suggestion match = 4
		 * 2. Becuase contain keyword checks whether the string have delhi in between or not. Multiple string might have delhi word
		 * which will make section impossible.
		 * 
		 * 3. if (suggestion.getText().equalsIgnoreCase("Delhi")) {
    suggestion.click();
}

		4. to make case insensitve we can use .equalsIgnoreCase and
		to handle trailing and leading space we can use trim method
		suggestion.getText().trim().equalsIgnoreCase("Delhi")
		 */
	}
	
	/*
	 * 
	 * 5.
	 * Q5 — Interview-level auto-suggest scenario
HTML behaves like this:
<input id="locationSearch"
       placeholder="Search Location">

<div class="suggestion-container">

    <div class="suggestion"
         data-type="city">
        Delhi
    </div>

    <div class="suggestion"
         data-type="airport">
        Delhi Airport
    </div>

    <div class="suggestion"
         data-type="city">
        Delhi NCR
    </div>

</div>

Requirement:
Type Delhi and select only the suggestion where:
- visible text is Delhi
- data-type="city"

Write complete Selenium code that:
1. Locates the input.
2. Clears any existing value.
3. Types Delhi.
4. Waits for the suggestions.
5. Gets all suggestions.
6. Verifies both text and attribute.
7. Clicks the correct suggestion.
8. Stops iterating after the click.
Also answer:
Why is checking both text and data-type safer than checking only the visible text?
	 */
	
	public void ques_05()
	{
		// also adding attribute check is good because if we only check the text, there might be another delhi text with different data-type
		WebElement as5= driver.findElement(By.id("locationSearch"));
		as5.clear();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		as5.sendKeys("Delhi");
		
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggestion-container']/child::div")));
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Delhi") && option.getAttribute("data-type").equalsIgnoreCase("city"))
			{
				option.click();
				break;
			}
		}
	}
}
