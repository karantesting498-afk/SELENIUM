// this class contain knowledge for  calendar
package Selenium.revision.date_11_Oct;

public class Calendar_step1 {
	
	/*
	 * 1. What is a calendar in web automation?
A calendar or date picker is a UI control that allows users to select a date, date range, month, year, or sometimes a date and time.
Common examples include:
- Date of joining in an employee form.
- Start date and end date in a report filter.
- Date of birth in a registration form.
- Travel booking dates.
- Leave dates and attendance dates.
- Appointment scheduling with date and time selection.
	 */
	
	/*
	 * 2. Types of calendars used in modern web applications
There isn't one universal classification. For Selenium automation, the most useful approach is to classify calendars by their HTML implementation and interaction behavior.









Type 1: Native HTML date picker
Built into the browser
The application uses an HTML input such as:
<input type="date" id="joiningDate">


The browser provides the calendar interface. Its appearance and interaction can vary by browser and operating system.
Automation approach: Usually use sendKeys() with a supported date format, or set the value through a supported interaction and verify it. The format and behavior must be checked in your target browser.












Type 2: Custom JavaScript calendar
Very common
Clicking a text field or calendar icon opens a custom popup with month/year navigation and clickable date cells.
Common implementations include React, Angular, Vue, and component libraries.
Automation approach: Open the popup, identify the displayed month and year, navigate as needed, locate the intended day, click it, and verify the selected value.












Type 3: Date-range picker
Used for reports, hotel reservations, leave applications, and analytics filters.
It supports a start date and an end date, sometimes across two calendars displayed side by side.
Automation approach: Select both dates in the required order, handle restrictions on valid ranges, and verify both fields and the resulting data.












Type 4: Month/year picker
Used when users need to select a month or year rather than a particular day.
Automation approach: Identify whether the control allows direct month/year selection or requires navigation. Select the target and validate the displayed result.












Type 5: Date-time or appointment picker
Combines date selection with a time field, time slots, or an AM/PM selector.
Automation approach: Select a valid date, wait for available time slots to update, select the required time, and verify the final date-time value.



Other variations include inline calendars permanently visible on the page, multi-date selection calendars, and calendar widgets embedded inside dialogs or iframes.
Important: These categories can overlap. For example, a custom date-range picker can also be implemented inside a modal dialog.
	 */
	
	
	/*
	 * 3. First skill: Identify the calendar type
Before writing Selenium code, inspect the HTML in Chrome DevTools (F12 → Inspect).
Look at the input's type attribute and the structure that appears when the calendar opens.
HTML or UI clue								Likely type									Starting strategy
<input type="date">							Native date picker							Try sendKeys()
<input type="text"> and a popup appears		Custom calendar								Inspect popup and date cells
Two date fields, Start and End				Date-range picker							Handle each date and range rules
Month/year grid instead of day cells		Month/year picker							Select month/year directly
Date field followed by time slots			Date-time picker							Select date, then wait for time slots
Calendar visible without clicking			Inline calendar								Locate and select the target date


Do not decide the type based only on how the calendar looks. Inspect the DOM, because the same visual design can have different implementations.
	 */
	
	/*
	 * 4. Automating a native HTML date picker
Consider this HTML:
<input type="date" id="joiningDate">


Example Selenium Java code:
WebDriver driver = new ChromeDriver();

driver.get("https://example.com");

WebElement dateField =
        driver.findElement(By.id("joiningDate"));

dateField.sendKeys("10/20/2026");


The date format accepted by sendKeys() can depend on the browser and its locale. For an HTML date input, the underlying value format is normally yyyy-MM-dd, so a common alternative is:
dateField.sendKeys("2026-10-20");


However, don't assume every browser accepts the same keyboard representation. Verify the field value and application behavior in your actual environment.
You can inspect the underlying value:
String selectedDate = dateField.getAttribute("value");

System.out.println(selectedDate);


Expected underlying value:
2026-10-20


Interview point: The native date picker popup is browser-controlled. Its internal calendar cells generally aren't ordinary page DOM elements that Selenium can locate using XPath. Automate the input itself when possible rather than trying to click the browser's popup dates.
	 * 
	 */
	
	
	/*
	 * 5. Automating a custom JavaScript calendar
Imagine a calendar with HTML similar to this:
<input id="startDate" readonly>

<div class="calendar">
    <button class="prev">Previous</button>
    <span class="month-year">October 2026</span>
    <button class="next">Next</button>

    <button class="day">18</button>
    <button class="day">19</button>
    <button class="day">20</button>
</div>


This is an illustrative example. Real applications may use different elements, attributes, and accessibility labels.
The general automation flow is:
1

Open the date picker
Click the date field or calendar icon.


2

Read the displayed month and year
For example, October 2026.


3

Navigate to the target month
Use Previous/Next or a month/year selector.


4

Identify the correct date cell
Avoid selecting an adjacent month's duplicate day.


5

Select and verify
Check the input value and any resulting UI changes.



Example: Select a date using XPath
Suppose the application uses a date cell with an accessible label like October 20, 2026.
WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

driver.findElement(By.id("startDate")).click();

By targetDate = By.xpath(
    "//*[@aria-label='October 20, 2026']"
);

WebElement date = wait.until(
    ExpectedConditions.elementToBeClickable(targetDate)
);

date.click();


Imports for the wait and locator code:
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


This approach is reliable only if the real application exposes that exact aria-label. Inspect the DOM and adapt the locator accordingly.
If the target date isn't currently rendered, navigate to the appropriate month before locating it.
	 */
	
	
	/*
	 * 6. The hardest part: Selecting dates reliably
Modern calendars often contain multiple elements with the same visible day number.
For example, a calendar for October 2026 may display the end of September and the beginning of November. The number 1 might appear more than once.
Avoid blindly using:
driver.findElement(By.xpath("//button[text()='1']")).click();


That XPath may match more than one element or select the wrong month's date.
Better strategies include:
- Locate the exact date using a complete accessible label.
- Scope the day locator to the currently displayed calendar.
- Check attributes such as data-date, aria-label, or a full date value, if available.
- Exclude disabled dates and adjacent-month dates when required.
- Use explicit waits when the calendar renders asynchronously.
For example, if the application provides data-date="2026-10-20":
By targetDate = By.cssSelector(
    "[data-date='2026-10-20']"
);

wait.until(
    ExpectedConditions.elementToBeClickable(targetDate)
).click();


CSS is used here because it provides a straightforward attribute selector. XPath is equally suitable when you need relationships between elements.

/*
 * 7. Month navigation and date calculation
A common interview challenge is selecting a date several months away without clicking Next a fixed number of times.
Java's date API can help calculate the target month:
import java.time.LocalDate;
import java.time.YearMonth;

LocalDate target = LocalDate.of(2027, 3, 15);
YearMonth targetMonth = YearMonth.from(target);

System.out.println(targetMonth);
System.out.println(target.getDayOfMonth());


Output:
2027-03
15


A robust calendar automation method can:
1. Read the currently displayed month and year.
2. Convert it to a YearMonth.
3. Compare it with the target YearMonth.
4. Navigate forward or backward as needed.
5. Re-read the displayed month after each change.
6. Select the target date only when the correct month is visible.
This is safer than hardcoding a number of clicks, especially when the calendar opens on today's date or preserves the previous selection.
 */
	 /*
	  * Problem	Likely 						cause														Recommended handling
NoSuchElementException						Calendar hasn't opened or the locator is incorrect			Wait for the popup and inspect the locator
ElementClickInterceptedException			Overlay, animation, or another element blocks the date		Wait until clickable and investigate the overlay
StaleElementReferenceException				Calendar re-rendered after month navigation					Re-locate the month and date elements
Wrong date selected							Duplicate day numbers or adjacent-month dates				Use full-date attributes and scope the locator
Disabled date cannot be selected			Business rule prevents the selection						Validate disabled-state handling
Date appears selected but isn't saved		Selection and form submission are separate operations		Verify the field value and saved result
End date is rejected						End date precedes start date or violates range rules		Test valid and invalid date ranges
Avoid using Thread.sleep() as the default solution. Explicit waits provide better synchronization for dynamically rendered calendars.
	  */
	
	/*
	 * 9. Calendar testing checklist
As a QA and automation engineer, you should test more than the happy path.
- [ ] Select today's date.
- [ ] Select a past and a future date.
- [ ] Navigate across December to January.
- [ ] Navigate across years.
- [ ] Handle February in leap and non-leap years.
- [ ] Verify the 28th, 29th, 30th, and 31st where applicable.
- [ ] Attempt to select disabled dates.
- [ ] Select dates from an adjacent month.
- [ ] Verify start-date and end-date restrictions.
- [ ] Verify clearing and resetting a selected date.
- [ ] Check date format and timezone behavior.
- [ ] Verify that the selected date persists after saving or refreshing, where applicable.
For a date-range picker, also test selecting an end date earlier than the start date, changing the start date after setting the end date, and selecting the same date for both endpoints if the requirements permit it.
	 */
	
	/*
	 * 10. Your learning sequence
We'll study calendars in this order:
1. Native HTML date picker — input handling and browser differences.
2. Custom calendar — open, inspect, locate, and select a date.
3. Dynamic month/year navigation using LocalDate and YearMonth.
4. Date-range picker — start/end dependencies and validation.
5. Advanced scenarios — disabled dates, duplicate day numbers, re-rendering, waits, and stale elements.
Let's start with a quick practical question before moving to the code exercises.
Suppose you inspect a date field and find this HTML:
<input type="text" id="dob" readonly>


When you click it, a calendar popup appears with Previous and Next buttons and clickable date cells.
Would you automate this field using sendKeys(), Selenium's Select class, or by interacting with the calendar popup? Explain your choice and why.
	 */

}
