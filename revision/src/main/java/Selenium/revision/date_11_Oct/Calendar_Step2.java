// This class contain calendar questions

package Selenium.revision.date_11_Oct;

import java.time.Duration;
import java.time.Month;
import java.util.List;
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
	
	
	
	public void ques_01_2_approach()
	{
		
	}
	
	
	
}


