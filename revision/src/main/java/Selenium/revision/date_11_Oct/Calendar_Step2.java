// This class contain calendar questions

package Selenium.revision.date_11_Oct;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.input.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar_Step2 {
	WebDriver driver;

	/*
	 * Q1. Dynamic calendar with month/year navigation A web application contains a
	 * custom date picker. The calendar opens on the current month, and the target
	 * date is 15 March 2027. The current system date is October 2026. HTML
	 * structure: <input id="startDate" readonly>
	 * 
	 * <div class="calendar"> <button id="prev">Previous</button> <span
	 * id="monthYear">October 2026</span> <button id="next">Next</button>
	 * 
	 * <button class="day" data-date="2026-10-20">20</button> </div>
	 * 
	 * 
	 * The calendar regenerates its date elements whenever you click Previous or
	 * Next. Your tasks: 1. Write a reusable Java method that selects any given
	 * date. 2. Navigate dynamically without hardcoding the number of clicks. 3.
	 * Handle calendar re-rendering without encountering
	 * StaleElementReferenceException. 4. Use an explicit wait to verify the
	 * displayed month/year after each navigation. 5. Explain how you would handle a
	 * target date that is earlier than the currently displayed month.
	 */

	public void ques_01() {
		WebElement calendar = driver.findElement(By.id("startDate"));
		Scanner sc = new Scanner(System.in);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		calendar.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendar']")));

		System.out.println("Enter the Year");
		String year = sc.next();

		System.out.println("Enter the month");
		String month = sc.next();

		System.out.println("Enter the date");
		String date = sc.next();

		WebElement currentMonthYear = driver
				.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
		String currentMonth = currentMonthYear.getText().trim().split(" ")[0];
		String currentYear = currentMonthYear.getText().trim().split(" ")[1];

		if (currentYear.equalsIgnoreCase(year)) {
			if (currentMonth.equalsIgnoreCase(month)) {
				currentMonthYear = driver
						.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
				currentMonth = currentMonthYear.getText().trim().split(" ")[0];
				currentYear = currentMonthYear.getText().trim().split(" ")[1];

				List<WebElement> monthDates = driver
						.findElements(By.xpath("//div[@class='calendar']/child::button[@class='day']"));

				for (WebElement selectedDate : monthDates) {
					if (selectedDate.getText().equalsIgnoreCase(date)) {
						selectedDate.click();
						break;
					}
				}

			} else {

				int currentMonthCount = Month.valueOf(currentMonth.toUpperCase()).getValue();
				int inputMonthCount = Integer.parseInt(month);

				if (currentMonthCount < inputMonthCount) {
					currentMonthYear = driver
							.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
					currentMonth = currentMonthYear.getText().trim().split(" ")[0];
					currentYear = currentMonthYear.getText().trim().split(" ")[1];
					WebElement next;

					while (currentMonthCount != inputMonthCount) {
						next = driver.findElement(By.xpath("//div[@class='calendar']/child::button[@id='next']"));

						next.click();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendar']")));

						currentMonthYear = driver
								.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
						currentMonth = currentMonthYear.getText().trim().split(" ")[0];
						currentYear = currentMonthYear.getText().trim().split(" ")[1];

						currentMonthCount = Month.valueOf(currentMonth.toUpperCase()).getValue();
						inputMonthCount = Integer.parseInt(month);
					}
				}

				else if (currentMonthCount > inputMonthCount) {
					currentMonthYear = driver
							.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
					currentMonth = currentMonthYear.getText().trim().split(" ")[0];
					currentYear = currentMonthYear.getText().trim().split(" ")[1];
					WebElement previous;

					while (currentMonthCount != inputMonthCount) {

						previous = driver.findElement(By.xpath("//div[@class='calendar']/child::button[@id='prev']"));

						previous.click();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendar']")));

						currentMonthYear = driver
								.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
						currentMonth = currentMonthYear.getText().trim().split(" ")[0];
						currentYear = currentMonthYear.getText().trim().split(" ")[1];

						currentMonthCount = Month.valueOf(currentMonth.toUpperCase()).getValue();
						inputMonthCount = Integer.parseInt(month);
					}
				}

			}
		}
	}

	public void ques_01_2_approach() {
		WebElement calendarField = driver.findElement(By.id("startDate"));

		calendarField.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement calendarMenu = driver.findElement(By.xpath("//div[@class='calendar']"));

		wait.until(ExpectedConditions.visibilityOf(calendarMenu));

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Date in yyyy/mm/dd format");
		String inputDate = sc.next();

		WebElement currentSelectedMonthYear = driver
				.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
		String currentDate = currentSelectedMonthYear.getText().trim();
		// Now we have to convert input date and current month year in java date object

		/*
		 * Think of DateTimeFormatter as a language translator and a quality checker for
		 * dates in Java. Computers see dates as data objects (like LocalDate), but
		 * humans see dates as text (like "2026/10/21"). DateTimeFormatter is the tool
		 * that translates between the two.
		 */

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

		LocalDate inputDate2 = LocalDate.parse(inputDate, formatter);// local date expect complete date format
		YearMonth currentDate2 = YearMonth.parse(currentDate, monthYearFormatter);

		YearMonth targetDate = YearMonth.from(inputDate2);// this will convert 2026/12/23 into december 2026

		// now while loop for date change

		while (!currentDate2.equals(targetDate)) {
			By navigation = null;
			YearMonth expectedMonth = null;

			if (currentDate2.isBefore(targetDate)) {
				expectedMonth = currentDate2.plusMonths(1);
				navigation = By.id("next");
			} else if (currentDate2.isAfter(targetDate)) {
				expectedMonth = currentDate2.minusMonths(1);
				navigation = By.id("prev");
			}

			driver.findElement(navigation).click();

			wait.until(ExpectedConditions.textToBe(By.id("monthYear"), expectedMonth.format(monthYearFormatter)));

			currentSelectedMonthYear = driver
					.findElement(By.xpath("//div[@class='calendar']/child::span[@id='monthYear']"));
			currentDate = currentSelectedMonthYear.getText().trim();

			inputDate2 = LocalDate.parse(inputDate, formatter);// local date expect complete date format
			currentDate2 = YearMonth.parse(currentDate, monthYearFormatter);

			targetDate = YearMonth.from(inputDate2);// this will convert 2026/12/23 into december 2026

		}

		int targetedDate = inputDate2.getDayOfMonth();

		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='calendar']/child::button[@class='day' and @data-date='"
						+ inputDate2.toString() + "'] "));

		for (WebElement date : dates) {
			int intDate = Integer.parseInt(date.getText());
			if (intDate == targetedDate) {
				date.click();
				break;
			}
		}

	}

	/*
	 * Q2. Duplicate day numbers and adjacent-month dates A calendar displays the
	 * last few dates of the previous month and the first few dates of the next
	 * month. The target date is 5 November 2026, but the calendar currently
	 * displays October 2026.
	 * 
	 * HTML: <div class="calendar"> <span class="monthYear">October 2026</span>
	 * 
	 * <button class="day other-month" data-date="2026-09-30">30</button>
	 * 
	 * <button class="day" data-date="2026-10-05">5</button>
	 * 
	 * <button class="day other-month" data-date="2026-11-05">5</button> </div>
	 * 
	 * 
	 * Assume the actual application may render multiple elements with the same
	 * visible day number.
	 * 
	 * Your tasks: 1. Explain why //button[text()='5'] is unreliable. 2. Write a
	 * locator strategy that selects exactly 5 November 2026. 3. Explain how you
	 * would verify that the selected date belongs to the currently intended month.
	 * 4. Handle the possibility that the target element is present in the DOM but
	 * not clickable. 5. Explain whether selecting an adjacent-month date is always
	 * incorrect or depends on the application's requirements.
	 */

	public void ques_02() {
		/*
		 * 1. //button[text()='5'] it is unreliable because calendar may show current
		 * month by default. And if we use //button[text()='5'], then it will select 5th
		 * date of current month.
		 * 
		 * 1. Why is //button[text()='5'] unreliable? Your explanation is partially
		 * correct. The bigger issue is that the calendar can contain multiple buttons
		 * whose visible text is 5.
		 * 
		 * For example: - data-date="2026-10-05" — October 5 - data-date="2026-11-05" —
		 * November 5 Both buttons display 5, so //button[text()='5'] can match both
		 * elements. findElement() returns the first matching element, which may not be
		 * the intended date.
		 * 
		 * Your answer should emphasize duplicate matches, rather than only saying the
		 * calendar displays the current month.
		 * 
		 * 
		 * 
		 * 
		 * 2. driver.findElement(By.xpath(
		 * "//div[@class='calendar']/child::button[@data-date='2026-11-05']"));
		 * 
		 * 5. Yes it depends upon application req. In calendar we can have option like
		 * last month date, or next month date
		 */

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String intendenMonth = "March 2026";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate inputDate = LocalDate.parse(intendenMonth, formatter);

		WebElement currentYearMonth = driver
				.findElement(By.xpath("//div[@class='calendar']/child::span[@class='monthYear']"));
		String currentYearMonth2 = currentYearMonth.getText();

		DateTimeFormatter YearMonthFormatter = DateTimeFormatter.ofPattern("MMMM uuuu", Locale.ENGLISH);

		YearMonth currentMonth = YearMonth.parse(currentYearMonth2, YearMonthFormatter);

		YearMonth targetMonth = YearMonth.from(inputDate);

		if (currentMonth.equals(targetMonth)) {
			System.out.println("Yes we are in targetted month");
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@class='calendar']/child::button[@data-date='" + intendenMonth + "']")));
		} else {
			System.out.println("no we are not in targetted month.");
		}

	}
	
	

	/*
	 * Q3. Date-range picker with business rules An employee leave application has
	 * Start Date and End Date fields.
	 * 
	 * Requirements: - Start Date must not be in the past. - End Date must be on or
	 * after Start Date. - Weekends are disabled. - The calendar re-renders after
	 * selecting Start Date. - The End Date calendar opens on the month of the
	 * selected Start Date. Your tasks: 1. Automate selecting 10 November 2026 as
	 * Start Date and 13 November 2026 as End Date. 2. Ensure that your script does
	 * not use fixed sleeps. 3. Handle the calendar re-rendering after Start Date
	 * selection. 4. Explain how you would verify that the selected range is valid.
	 * 5. Describe how you would test an invalid range in which End Date precedes
	 * Start Date. Assume the application exposes reliable date attributes in its
	 * calendar cells, but you must determine how to use them.
	 */

	public void ques_03() {

		WebElement calendar = driver.findElement(By.id("calendar"));
		calendar.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("calendar-menu")));

		WebElement inputStartDate = driver.findElement(By.id("startDate"));

		WebElement inputEndDate = driver.findElement(By.id("endDate"));

		WebElement currentCalendarMonthYear = driver
				.findElement(By.xpath("//div[@class='calendar']/child::span[@class='monthYear']"));

		DateTimeFormatter reqFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter appFormat = DateTimeFormatter.ofPattern("MMMM uuuu", Locale.ENGLISH);

		LocalDate inputStartDate2 = LocalDate.parse(inputStartDate.getText(), reqFormat);
		LocalDate inputEndDate2 = LocalDate.parse(inputEndDate.getText(), reqFormat);

		YearMonth currentCalendarMonthYear2 = YearMonth.parse(currentCalendarMonthYear.getText(), appFormat);

		YearMonth targetStartDate = YearMonth.from(inputStartDate2);

		YearMonth targetEndDate = YearMonth.from(inputEndDate2);

		while (!targetStartDate.equals(currentCalendarMonthYear2)) {

			YearMonth ExpectedMonth = null;
			By navigation = null;

			if (targetStartDate.isBefore(currentCalendarMonthYear2)) {
				System.out.println("leave cannot be applied for previous dates");
				break;
			}

			else if (targetStartDate.isAfter(currentCalendarMonthYear2)) {
				ExpectedMonth = currentCalendarMonthYear2.plusMonths(1);
				navigation = By.id("next");
			}

			driver.findElement(navigation).click();

		}

		int startDateInt = inputStartDate2.getDayOfMonth();
		int endDateInt = inputEndDate2.getDayOfMonth();

		if (endDateInt < startDateInt) {
			System.out.println("End date cannot be less than start date");
		}

		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='calendar']/child::button[contains(@class,'day')]"));

		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase("2026/11/10")) {
				wait.until(ExpectedConditions.elementToBeClickable(date));
				date.click();

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("calendar-menu")));

				if (date.getText().equalsIgnoreCase("2026/11/13")) {
					wait.until(ExpectedConditions.elementToBeClickable(date));

					date.click();
				}
			}

		}
		
		/*
		 * 4. TO verify range , we can check get attribute value of the calendar.
		 * 5. to verify end date before start date, we can first select end date, and then select date of preceding start date by -1.
		 */

	}
	
	

}
