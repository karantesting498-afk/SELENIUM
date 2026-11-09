/*
 * Q2. Selenium Practical Coding — Environment Setup
You are developing a Selenium framework that supports three environments:
- QA: https://qa.example.com
- Staging: https://staging.example.com
- Production: https://example.com
You want to select the environment through testng.xml and make the selected URL available to multiple test classes.

Your task:
1. Write a BaseTest class using @BeforeTest.
2. Use TestNG's @Parameters annotation to receive the environment name from XML.
3. Select the correct URL based on the environment.
4. Throw an exception if an unsupported environment is provided.
5. Make the selected URL accessible to child test classes.
6. Write a sample LoginTest class that uses the URL.
7. Show the relevant testng.xml configuration.
 */
package Selenium.revision.date_2026_10_27;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest_Step3 {
	String url;
	WebDriver driver;

	
	@BeforeTest
	public void envSetup(String name)
	{
		if(name.equalsIgnoreCase("QA"))
		{
			url = "https://qa.example.com";
		}
		else if(name.equalsIgnoreCase("UAT"))
		{
			url = "https://staging.example.com"; 
		}
		else if(name.equalsIgnoreCase("prod"))
		{
			url = "https://example.com";
		}
		else
		{
			throw new RuntimeException("No Such environment available");
		}
	}
	
	@Test
	public void testA()
	{
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void testB()
	{
		driver.get(url);
		System.out.println(driver.getTitle());
	}

	
	/*
	 * package Selenium.revision.date_27_Oct;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected String url;

    @BeforeTest
    @Parameters("environment")
    public void envSetup(String name) {

        if (name.equalsIgnoreCase("QA")) {
            url = "https://qa.example.com";
        }
        else if (name.equalsIgnoreCase("Staging")) {
            url = "https://staging.example.com";
        }
        else if (name.equalsIgnoreCase("Production")) {
            url = "https://example.com";
        }
        else {
            throw new RuntimeException(
                "Unsupported environment: " + name
            );
        }
    }
}



	 */
	
	/*
	 * package Selenium.revision.date_27_Oct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLoginPage() {

        driver.get(url);

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }

    @Test
    public void verifyLoginPageAgain() {

        driver.get(url);

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}Notice this line:
public class LoginTest extends BaseTest


This is what makes the url variable from BaseTest accessible in LoginTest.

You don't need to declare another url variable in LoginTest.

	 */
	
	
	/*
	 * C. testng.xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="EnvironmentSuite">

    <test name="QATests">

        <parameter name="environment" value="QA"/>

        <classes>
            <class name="Selenium.revision.date_27_Oct.LoginTest"/>
        </classes>

    </test>

</suite>


To run against Staging, change:
<parameter name="environment" value="Staging"/>


To run against Production:
<parameter name="environment" value="Production"/>
	 */
}
