package Selenium.revision.date_07_Oct;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Alert_Ques_Step2 {
	
	WebDriver driver;
	/*
	 * 1. 
	 * Q1 — Delayed confirmation alert
You click:
driver.findElement(By.id("deleteEmployee")).click();

A confirmation alert appears after 2–3 seconds:
Are you sure you want to delete this employee?

Write Selenium code that:
- Uses WebDriverWait
- Waits for the alert
- Reads the alert text
- Verifies the text
- Clicks OK only if the text matches exactly
- Otherwise dismisses the alert
Do not use Thread.sleep().
	 */
	
	public void ques_01()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.id("deleteEmployee")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		if(alert.getText().equals("Are you sure you want to delete this employee?"))
		{
			alert.accept();
		}
		else
		{
			alert.dismiss();
		}
		
		
	}
	
	
	/*2. Q2 — Prompt alert with validation
A prompt alert appears:
Enter employee code

Requirement:
- Wait for the alert
- Verify the alert text
- Enter:
EMP-1024

- Click OK
Then answer:
- Which method is used to enter text into the prompt?
- Can sendKeys() be used on every type of alert?
- What happens if you try sendKeys() on an alert that does not support text input?
	 * 
	 * 
	 */
	
	public void ques_02()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		if(alert.getText().equals("Enter employee code"))
		{
			alert.sendKeys("EMP-1024");
			alert.accept();
		}
		
	}
	
	//1.sendKeys method used to enter data in alert.
	//2. No, sendKeys can only be used to prompt alerts
//3. A standard JavaScript alert() or confirm() does not have a text input field. 
	//Attempting sendKeys() on one is unsupported, and Selenium may throw a WebDriverException or a more specific driver-dependent exception. 
	//It is not a NoSuchElementException merely because there is no text field.
	
	
	
	
	/*
	 * Q3 — Alert vs HTML modal trap
You see this popup:
<div class="confirmation-modal">
    <p>Do you want to deactivate this employee?</p>

    <button id="yesBtn">Yes</button>
    <button id="noBtn">No</button>
</div>

A tester writes:
Alert alert = driver.switchTo().alert();
alert.accept();

Answer:
- Will this work?
- Why or why not?
- What kind of popup is this?
- How should Selenium handle it?
- Which exception may occur when switchTo().alert() is used here?
Then write the correct Selenium approach.
	 */
	
	public void ques_03()
	{
			/*
			 * 1. Alert alert = driver.switchTo().alert();
alert.accept();
 this will not work as alert is not browser alert, it is html alert
 
 2. Becuase alert is of html type not browser alert. Alert interface only work for browser alert
 
 3. It is a html alert
 
 4. driver.findElement(By.xpath("//div[@class='confirmation-modal']/child::button[@id='yesBtn']")).click();
 
 5. NoAlertPresentException
			 */
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		By yesbtn = By.xpath("//div[@class='confirmation-modal']/child::button[@id='yesBtn']");
		
//		WebElement yes = wait.until(ExpectedConditions.visibilityOfElementLocated(yesbtn));
		
		   WebElement yes = wait.until(
			        ExpectedConditions.elementToBeClickable(yesbtn)
			    );
		
		yes.click();
		
	}
	
	/*4. 
	 * 
	 * Q4 — Unexpected alert during normal execution
Your script is:
driver.findElement(By.id("save")).click();

driver.findElement(By.id("username")).sendKeys("Karan");

But after clicking Save, an unexpected alert appears:
Session will expire soon

The script then fails while trying to interact with username.
Answer:
- Which exception can occur?
- Why can Selenium not continue normal DOM interaction?
- How should you detect and handle the alert safely?
- After accepting/dismissing the alert, can Selenium continue interacting with the page?
Write defensive Selenium code for this situation.



	 * 
	 * 
	 */
	
	public void ques_04()
	{
		/*
		 * 1. Which exception can occur?- UnexpectedAlertPresentException
		 * 2. Why can Selenium not continue normal DOM interaction? - because when alert is present, Selenium may not be able to interact with the webpage because the alert is blocking it.
			3. How should you detect and handle the alert safely? - By switching to alert
			driver.switchTo().alert().accept();
			4. - After accepting/dismissing the alert, can Selenium continue interacting with the page?- yes
			5. 
			
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.id("save")).click();

		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		alert.accept();
		
		driver.findElement(By.id("username")).sendKeys("Karan");
		
		
		
	}
	
	/*
	 * 
	 * Q5 — Multiple alerts in sequence
Suppose clicking Delete triggers:
First alert:
Are you sure?

After clicking OK, a second alert appears:
Employee deleted successfully

Write Selenium code that:
1. Clicks Delete
2. Waits for the first alert
3. Verifies:Are you sure?
4. Accepts it
5. Waits for the second alert
6. Verifies:Employee deleted successfully
7. Accepts the second alert
8. Then verifies that the page is usable again
Also answer:
Why should you not store the first Alert object and assume it can be reused for the second alert?



	 */

	public void ques_05()
	{
		WebElement delete = driver.findElement(By.id("delete"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert;
		delete.click();
		String msg;
		

		wait.until(ExpectedConditions.alertIsPresent());
		 alert = driver.switchTo().alert();

		
		if(alert.getText().equals("Are you sure?"))
		{
			alert.accept();
		}
		else
		{
			msg =  alert.getText();
			alert.dismiss();
			throw new AssertionError("Unexpected text : "+msg);
		}
		

		
		wait.until(ExpectedConditions.alertIsPresent());
		 alert = driver.switchTo().alert();

		
		if(alert.getText().equals("Employee deleted successfully"))
		{
			alert.accept();
		}
		
		else
		{
			msg =  alert.getText();
			alert.dismiss();
			throw new AssertionError("Unexpected text : "+msg);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("Body")));
		
		
	
		
		
	}
}
