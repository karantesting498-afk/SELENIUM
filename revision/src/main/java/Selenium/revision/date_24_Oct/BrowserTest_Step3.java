
package Selenium.revision.date_24_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserTest_Step3 {
	
	WebDriver driver;



	/*
	 * Question 2: Debug a TestNG Selenium Class
Type: Practical Coding + Debugging | Hard

A tester writes this code:
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BrowserTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void testExample() {
        driver.get("https://example.com");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

Tasks:
1. Identify at least three potential problems or weaknesses in this implementation.
2. Rewrite the teardown() method to handle browser cleanup more safely.
3. Explain the difference between driver.close() and driver.quit().
4. If testGoogle() fails, should @AfterMethod normally execute? Explain.
Write the corrected code for the relevant methods, not just a list of suggestions.
	 */
	
	public void ques_02()
	{
		/*
		 * 1. 
		 * A. Using driver. close instead of quit.
		 * B. Not checking whether driver = null
		 * C. After quit add => driver = null;
		 * 
		 * 
		 * 2.     @AfterMethod
    			public void teardown() {
        				if(driver!=null)
        				{
        				driver.quit();}
    				}
    				
    		3. driver.close() only close current window of the browser but quit closes all the windows of the browser.
    		
    		4. Yes even if google test fail , afterMethod will still execute
		 */
		

		
	}
	
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGoogle()
	{
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void testExample()
	{
		driver.get("https://example.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
			driver = null;
		}
	}
	
	
}
