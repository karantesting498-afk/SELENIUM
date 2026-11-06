/*
 * Question 3 – Practical debugging challenge
Hard
You are automating an employee login workflow using Selenium and TestNG.
public class EmployeeTest {

    WebDriver driver;

    @Test(timeOut = 5000)
    public void loginTest() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://example.com");

        Thread.sleep(7000);

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.quit();
    }
}


Your requirements:
1. The complete test method should not exceed 5 seconds.
2. The browser should be closed even if the test fails due to timeout.
3. Replace Thread.sleep() with an appropriate Selenium wait.
4. Explain whether WebDriverWait alone can guarantee that the complete test finishes within 5 seconds.
5. Identify the problems in the existing code and provide a corrected implementation.
 */
package Selenium.revision.date_30_Oct;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EmployeeTest_Step4 {
	
	WebDriver driver;
	
	/*
	 * No wait aalone cannot gurantee test to be completed within 5 seconds
	 * it only waits for the event.
	 * 
	 * 
	 */
	
	@Test(timeOut = 5000)
	public void loginTest() throws TimeoutException
	{

			driver= new ChromeDriver();
			
	        driver.get("https://example.com");

	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
	        
	        driver.findElement(By.id("username")).sendKeys("admin");

	        driver.quit();
		} 
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
	}


