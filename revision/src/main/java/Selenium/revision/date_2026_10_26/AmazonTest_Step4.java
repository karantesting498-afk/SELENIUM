/*
 * Q3. Debugging — Browser Not Closing
Consider this code:
public class AmazonTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchProduct() {
        driver.get("https://www.amazon.in");
    }

    @Test
    public void verifyTitle() {
        driver.get("https://www.amazon.in");
        System.out.println(driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

Answer:
1. Identify the problem with the cleanup logic.
2. What is the difference between driver.close() and driver.quit()?
3. Rewrite the @AfterClass method so it handles an uninitialized driver safely.
4. Suppose a test opens a second browser tab. Which cleanup method would you prefer, and why?
 */
package Selenium.revision.date_2026_10_26;

import org.testng.annotations.AfterClass;

public class AmazonTest_Step4 {
	
	/*
	 * 1. We are using driver.close();
	 * We should use driver.quit() with valid check for driver initialization.
	 * 
	 * 2. driver.close() only close the current window and do not terminate the driver resource allocation.
	 * but driver.quit() close all the browser windoes and clear the allocated resources.
	 * 
	 * 3. 	@AfterClass
	public void terminate()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
	
	
	4. driver.quit() close all the browser windoes and clear the allocated resources.
	 */

}
