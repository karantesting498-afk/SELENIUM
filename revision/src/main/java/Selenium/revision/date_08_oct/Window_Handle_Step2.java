// This class contains window handle questions
package Selenium.revision.date_08_oct;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Handle_Step2 {
	WebDriver driver;

	/*
	 * Q1 — Parent to child tab You are on the main page:
	 * driver.get("https://example.com");
	 * 
	 * Then Selenium clicks: driver.findElement(By.id("openReport")).click();
	 * 
	 * A new tab opens. Write Selenium code to: - Store the parent tab handle before
	 * clicking - Wait until exactly 2 windows/tabs are available - Get all window
	 * handles - Identify the child tab - Switch to the child tab - Print the child
	 * tab title and URL - Close the child tab - Switch back to the parent tab Do
	 * not use Thread.sleep().
	 */
	public void ques_01() {
		driver.get("https://example.com");
		String parent = driver.getWindowHandle();

		driver.findElement(By.id("openReport")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> tabs = driver.getWindowHandles();

		for (String tab : tabs) {
			if (!parent.equalsIgnoreCase(tab)) {
				driver.switchTo().window(tab);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				break;

			}
		}

		driver.close();
		driver.switchTo().window(parent);

	}

	/*
	 * Q2 — Three tabs open, identify correct one Suppose the browser now contains:
	 * Tab 1 → Dashboard Tab 2 → Employee Report Tab 3 → Attendance Report
	 * 
	 * You do not know which handle belongs to which tab. Write Selenium code that:
	 * - Gets all window handles - Switches through every tab one by one - Finds the
	 * tab whose title is exactly: Employee Report
	 * 
	 * - Stops looping once it finds it - Performs this action:
	 * driver.findElement(By.id("download")).click();
	 * 
	 * Question: Why is checking the window title safer than assuming the second
	 * handle belongs to the Employee Report tab?
	 * 
	 *
	 */

	public void ques_02()
	{
		String parent = driver.getWindowHandle();
		
		Set<String> tabs = driver.getWindowHandles();
		
		
		
		for(String tab : tabs)
		{
			if(!parent.equalsIgnoreCase(tab) )
					{
						
						driver.switchTo().window(tab);
						
						if(driver.getTitle().equals("Employee Report"))
						{
							break;
						}
					}
				
		}
		driver.findElement(By.id("download")).click();
		
		/*
		 * Question:
Why is checking the window title safer than assuming the second handle belongs to the Employee Report tab?

because there might be chance that second handler does not belong to employee report.
By verifying using window title
		 */
	}
	
	
	/*
	 * Q3 — Window opens after delay
Clicking:
driver.findElement(By.id("openCustomer")).click();

opens another tab after 3 seconds.
A tester writes:
String parent = driver.getWindowHandle();

driver.findElement(By.id("openCustomer")).click();

Set<String> windows = driver.getWindowHandles();

for (String window : windows) {
    if (!window.equals(parent)) {
        driver.switchTo().window(window);
    }
}

Sometimes this code does not switch to the new tab.
Answer:
- Why can this happen?
- What explicit wait condition should be used?
- Write the corrected code.
- Why should getWindowHandles() preferably be called after confirming the new window has opened?
	 */
	
	public void ques_03()
	{
		/*
		 * Why can this happen? - becuase when user tap on open customer button, new tab creates 2-3 second to open but user
		 * switch tab without any wait. because of this soemtimes switch does not work
		 * 
		 * - What explicit wait condition should be used?- we should use:
		 * ExpectedConditions.numberOfWindosToBe(2)
		 * 
		 * - Why should getWindowHandles() preferably be called after confirming the new window has opened?
		 * 
		 * becuase if we use getWindowHandles() before new window is opened, then new window data will not be fetched using getWindowHandles()
		 * 
		 * 
		 */
		
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.id("openCustomer")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String tab : tabs)
		{
			if(!parent.equals(tab))
			{
				driver.switchTo().window(tab);
				break;
			}
		}
	}
	
	
	/*
	 * Q4 — Child tab opens another child tab
Flow:
Tab 1 → Dashboard

Dashboard opens:
Tab 2 → Employee Details

Employee Details opens:
Tab 3 → Employee History

Write Selenium code that:
1. Stores the Dashboard handle.
2. Opens Employee Details.
3. Switches to Employee Details.
4. Stores its handle.
5. Opens Employee History.
6. Switches specifically to Employee History.
7. Closes Employee History.
8. Returns to Employee Details.
9. Closes Employee Details.
10. Returns to Dashboard.
Also answer:
In this scenario, is "parent" always the original Dashboard, or can Employee Details logically become the parent of Employee History?

	 */

	public void ques_04()
	{
		String dashboard;
		String employee_Details;
		
		dashboard= driver.getWindowHandle();
		
		driver.findElement(By.id("Employee Details")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> tabs;
		tabs= driver.getWindowHandles();
		
		for(String tab : tabs)
		{
			if(!dashboard.equals(tab))
			{
				driver.switchTo().window(tab);
				if(driver.getTitle().equals("Employee Details"))
				{
					break;
				}
				else
				{
					continue;
				}
			}
		}
		
		employee_Details = driver.getWindowHandle();
		driver.findElement(By.id("Employee History")).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		tabs= driver.getWindowHandles();

		for(String tab: tabs)
		{
			if(!employee_Details.equals(tab))
			{
				driver.switchTo().window(tab);
				
				if(driver.getTitle().equals("Employee History"))
				{
					break;
				}
				else
				{
					continue;
				}
			}
		}
		
		driver.close();
		driver.switchTo().window(employee_Details);
		driver.close();
		driver.switchTo().window(dashboard);
		
		/*
		 * In this scenario, is "parent" always the original Dashboard, 
		 * or can Employee Details logically become the parent of Employee History?
		 * 
		 * No, the parent is not necessarily always the original Dashboard.

Dashboard is the original window and opens Employee Details. Employee Details then opens Employee History, so Employee Details can logically be considered the parent/opener of Employee History.

However, Selenium's currently active window and a window's parent/opener are different concepts. The active window changes when we use driver.switchTo().window(handle), but switching focus does not change the actual parent/opener relationship.

We should store each window's handle separately and use the appropriate handle to switch back to the required window.
		 * 
		 * 
		 */
	}
	
	/*
	 * Q5 — Interview trap: closed window handle
Suppose:
String parent = driver.getWindowHandle();

driver.findElement(By.id("openReport")).click();

You switch to the new tab and then:
driver.close();

After that, the code executes:
driver.findElement(By.id("username")).sendKeys("Karan");

without switching back to the parent.
Answer:
- Will this work reliably?
- Which problem/exception may occur?
- Why doesn't driver.close() automatically mean Selenium has returned to the parent?
- What should be done immediately after closing the child tab?
Then write the correct sequence.
	 */
	
	public void ques_05()
	{
		/*
		 * Will this work reliably?- no it will not work
		 * Which problem/exception may occur?- after driver.close(), new tab is closed but selenium driver is focused still on the 
		 * child tab.
		 * when it execute sendKeys command, then exception- NoSuchWindowException will be displayed
		 * 
		 * Why doesn't driver.close() automatically mean Selenium has returned to the parent?
		 * 
		 * no driver.close just closes the tab. It does not return it directly to parent.
		 * we have to execute switchTo.window to switch tab
		 * 
		 * - What should be done immediately after closing the child tab?
		 * 
		 * we should switch back to parent tab
		 * 
		 * 
		 */
		
		String parent= driver.getWindowHandle();
		
		driver.findElement(By.id("openReport")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String tab : tabs)
		{
			if(!parent.equals(tab))
			{
				driver.switchTo().window(tab);
				break;
			}
		}
		
		driver.close();
		
		driver.switchTo().window(parent);
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));

		driver.findElement(By.id("username")).sendKeys("Karan");
	}
	
}
