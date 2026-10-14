// This class contains knowledge for auto suggestion drop-down
package Selenium.revision.date_6_oct;

public class Auto_Suggestion_DD_Step5 {
	
	/*
	 * 
	 * An auto-suggestion dropdown is a dropdown where suggestions appear or change after you type something into an input field.
	 * 
Typical examples are city search, airport search, employee search, Google search, customer search, etc.
The normal flow is:

=======
Locate input
↓
Type partial text
↓
Wait for suggestions
↓
Get all suggestions
↓
Compare suggestion text
↓
Click required suggestion

------------------------------------------------------

For example, suppose the HTML is:
<input id="city" type="text">

<ul class="suggestions">
    <li>Delhi</li>
    <li>Delhi NCR</li>
    <li>Delhi Airport</li>
</ul>

You first type partial text:

WebElement city =
        driver.findElement(By.id("city"));

city.sendKeys("Del");

After typing Del, the application may load suggestions dynamically.
Then get the suggestions:
List<WebElement> suggestions =
        driver.findElements(
            By.cssSelector(".suggestions li")
        );

Then iterate:


for (WebElement suggestion : suggestions) {

    if (suggestion.getText().trim().equals("Delhi")) {
        suggestion.click();
        break;
    }
}



So the complete basic flow becomes:
WebElement city =
        driver.findElement(By.id("city"));

city.sendKeys("Del");

List<WebElement> suggestions =
        driver.findElements(
            By.cssSelector(".suggestions li")
        );

for (WebElement suggestion : suggestions) {

    if (suggestion.getText().trim().equals("Delhi")) {
        suggestion.click();
        break;
    }
}


---------------------------------------------


Why explicit wait is important
In real applications, suggestions normally don't appear immediately.
For example:
User types "Del"
↓
Frontend calls API
↓
API returns cities
↓
Suggestions appear

Therefore, avoid relying on:
Thread.sleep(3000);

Prefer an explicit wait:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

Then:
WebElement city =
        driver.findElement(By.id("city"));

city.sendKeys("Del");

List<WebElement> suggestions =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".suggestions li")
            )
        );

Then select:
for (WebElement suggestion : suggestions) {

    if (suggestion.getText().trim().equals("Delhi")) {
        suggestion.click();
        break;
    }
}



------------------------------------------------------

A practical implementation is therefore:
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement city =
        driver.findElement(By.id("city"));

city.sendKeys("Del");

List<WebElement> suggestions =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".suggestions li")
            )
        );

for (WebElement suggestion : suggestions) {

    if (suggestion.getText().trim().equals("Delhi")) {
        suggestion.click();
        break;
    }
    
    }
    
    ----------------------------------------------------------------
    
    
    Directly locating the required suggestion
If you already know the exact suggestion and have a stable locator, you don't necessarily need to iterate.
For example:
city.sendKeys("Del");

WebElement delhi =
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath(
                    "//li[normalize-space(.)='Delhi']"
                )
            )
        );

delhi.click();

Both approaches are valid.
Use iteration when you want to inspect or validate the entire suggestion list. Use direct location when the target value is known and uniquely identifiable.

------------------------


Auto-suggestion vs dynamic dropdown
This difference is important.
A normal dynamic dropdown usually works like:
Click dropdown
↓
options appear
↓
choose option

Example:
Select Employee ▼
Karan
Rahul
Aman

An auto-suggestion dropdown works like:
Type something
↓
suggestions are generated/filtered
↓
choose suggestion

Example:
Del_

Delhi
Delhi NCR
Delhi Airport

So the main trigger is different:
Dynamic dropdown
→ usually CLICK

Auto-suggestion dropdown
→ TYPE / sendKeys()

Suggestions can change after every character
Suppose you type:
D

Suggestions could be:
Delhi
Dubai
Doha

Then:
De

might become:
Delhi
Denver

Then:
Del

might become:
Delhi
Delhi NCR
Delhi Airport

That means the suggestion elements can be recreated by the frontend while you're typing.
Because of this, storing suggestions too early can cause issues.
For example:
List<WebElement> suggestions =
        driver.findElements(...);

city.sendKeys("h");

If typing another character causes the DOM to refresh, the old WebElement references may become stale.
So usually:
Finish typing
↓
wait for final suggestion list
↓
locate suggestions
↓
click

is safer.

-----------------------------------------------

What if you need partial matching?
Suppose suggestion text is:
Delhi, India

but you only know:
Delhi

You can use:
if (suggestion.getText().contains("Delhi")) {
    suggestion.click();
}

But be careful because this could also match:
Delhi NCR
Delhi Airport

If exact matching is possible, prefer:
equals()

or:
equalsIgnoreCase()

Example:
if (suggestion.getText().trim()
        .equalsIgnoreCase("Delhi")) {

    suggestion.click();
}


----------------------


What about keyboard selection?
Sometimes auto-suggest dropdowns support keyboard actions.
For example:
city.sendKeys("Del");

city.sendKeys(Keys.ARROW_DOWN);
city.sendKeys(Keys.ENTER);

This may select the first suggestion.
You can also do:
city.sendKeys("Del");
city.sendKeys(Keys.ARROW_DOWN);
city.sendKeys(Keys.ARROW_DOWN);
city.sendKeys(Keys.ENTER);

to navigate through suggestions.
But this is usually less reliable than locating the exact suggestion because option order may change.
For automation, direct element selection is generally better when possible.


---------------------

Common interview question: can Select be used?
Usually no, because auto-suggest fields are generally built using:
<input>
<div>
<ul>
<li>

rather than:
<select>

Example:
<input id="employeeSearch">

<ul>
    <li>Karan</li>
    <li>Rahul</li>
</ul>

So you would not use:
new Select(...)

Instead:
sendKeys()
↓
wait
↓
findElements()
↓
match
↓
click


----------------------------------

A more realistic employee example
HTML could behave like:
<input id="employeeSearch"
       placeholder="Search Employee">

<div class="employee-suggestions">
    <div class="employee-option">Karan</div>
    <div class="employee-option">Karan Sharma</div>
    <div class="employee-option">Karan Singh</div>
</div>

Selenium:
WebElement employee =
        driver.findElement(By.id("employeeSearch"));

employee.sendKeys("Karan");

List<WebElement> options =
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.className("employee-option")
            )
        );

for (WebElement option : options) {

    if (option.getText().trim()
            .equals("Karan Sharma")) {

        option.click();
        break;
    }
}


----------------------------------

Important points to remember
Auto-suggestion dropdown

1. Locate the input field
2. Enter partial text using sendKeys()
3. Wait for suggestions
4. Locate the suggestion elements
5. Get all suggestions if required
6. Compare using getText()
7. Click the required suggestion

And the easiest comparison for revision is:
STATIC DROPDOWN
<select>
→ Select class


DYNAMIC CUSTOM DROPDOWN
click()
→ options appear
→ select option


AUTO-SUGGEST DROPDOWN
sendKeys()
→ suggestions appear/change
→ select suggestion

One key interview point: auto-suggestion is essentially dynamic behavior triggered by typing, but we usually discuss it separately because its handling pattern is sendKeys → wait → suggestions → select.






	 */

}
