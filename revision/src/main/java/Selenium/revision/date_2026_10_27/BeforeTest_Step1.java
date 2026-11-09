// this class contains knowledge regarding the beforeTest annotation
package Selenium.revision.date_2026_10_27;

public class BeforeTest_Step1 {
	
	/*
	 * 1. What is @BeforeTest?
@BeforeTest is a TestNG configuration annotation that executes once before the execution of test methods belonging to a particular <test> tag in testng.xml.

It is useful when you want to perform setup activities before a group of test classes runs.

Common use cases:
- Load environment configuration.
- Initialize test data.
- Set up resources required by multiple classes.
- Prepare a test environment.
- Perform setup before executing a particular group of tests.
Important: @BeforeTest is associated with the XML <test> tag, not an individual Java test class or @Test method.
===================================================================================================
	 */
	
	
	/*
	 * 	2. Understanding the execution scope
Let's compare the configuration annotations covered so far.

Annotation				Scope					Execution frequency
@BeforeMethod			Test method				Before each applicable @Test method

@AfterMethod			Test method				After each applicable @Test method

@BeforeClass			Java class				Once before test methods in that class
	
@AfterClass				Java class				Once after test methods in that class

@BeforeTest				XML <test>				Once before test methods in that XML <test>

For example, if one XML <test> contains three Java classes, an applicable @BeforeTest method runs once for that XML <test>, not three times.

==========================================================================================
	 */
	
	/*
	 * 3. Practical example with multiple classes
Suppose your project has three Java classes.

LoginTest.java
public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Valid Login");
    }

    @Test
    public void invalidLogin() {
        System.out.println("Invalid Login");
    }
}


LogoutTest.java
public class LogoutTest {

    @Test
    public void logout() {
        System.out.println("Logout");
    }
}


PaymentTest.java
public class PaymentTest {

    @Test
    public void payment() {
        System.out.println("Payment");
    }
}


Now create a configuration class:

BaseTest.java
public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Configuration");
    }
}


For this configuration method to be executed, BaseTest must be included in the XML execution.

testng.xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="AutomationSuite">

    <test name="RegressionTests">

        <classes>
            <class name="tests.BaseTest"/>
            <class name="tests.LoginTest"/>
            <class name="tests.LogoutTest"/>
            <class name="tests.PaymentTest"/>
        </classes>

    </test>

</suite>


The configuration method in BaseTest applies to this XML <test>.

Illustrative execution order; ordering among independent test methods/classes can depend on TestNG configuration.
@BeforeTest
    |
    v
LoginTest
    |-- validLogin()
    |-- invalidLogin()
    |
    v
LogoutTest
    |-- logout()
    |
    v
PaymentTest
    |-- payment()


The important point is that @BeforeTest runs once for the XML <test> execution.

==========================================================================================
	 */
	
	/*
	 * 4. What happens when there are multiple XML <test> tags?
Consider this testng.xml:
<suite name="AutomationSuite">

    <test name="SmokeTests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.LogoutTest"/>
        </classes>
    </test>

    <test name="RegressionTests">
        <classes>
            <class name="tests.PaymentTest"/>
        </classes>
    </test>

</suite>


There are two XML <test> tags.

If an applicable @BeforeTest method is configured for each XML <test> execution, it will execute once for each one.

Key takeaway
 The number of Java classes does not determine the number of @BeforeTest executions. The XML <test> configuration does
 ========================================================================================================
	
	 */

	/*
	 * 5. @BeforeTest vs @BeforeClass
This is an important interview question.

Suppose you have:

- One XML <test> tag.
- Three Java classes.
- Each Java class contains two @Test methods.

The execution frequency would be:

Annotation															Expected executions
@BeforeTest in an included configuration class								1
@BeforeClass in each of the three classes									3
@BeforeMethod across six test methods										6

This is why you should not use @BeforeTest and @BeforeClass interchangeably.
	 */
	
	
	/*
	 * 6. Selenium example
Suppose you want to load environment configuration before executing a set of Selenium tests.
public class BaseTest {

    protected String baseUrl;

    @BeforeTest
    public void loadConfiguration() {

        baseUrl = "https://www.google.com";

        System.out.println("Environment configuration loaded");
    }
}


A test class can extend BaseTest:
public class GoogleTest extends BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void verifyGoogleTitle() {

        driver.get(baseUrl);

        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}


Here:
- @BeforeTest loads the configuration for the XML <test>.
- @BeforeMethod launches a browser before each test method.
- @AfterMethod closes the browser after each test method.
Notice that the browser is not launched in @BeforeTest. This is intentional: browser setup is being handled independently for each test method.

====================================================================================================
	 */
	
	/*
	 * 7. What if @BeforeTest fails?
Suppose your @BeforeTest method loads an environment configuration, but that setup fails.
@BeforeTest
public void setup() {

    if (baseUrl == null) {
        throw new RuntimeException("Configuration missing");
    }
}


If this configuration method fails, TestNG normally cannot proceed with the dependent test methods under that XML <test>.

Those tests will generally be marked as skipped due to the configuration failure.

This is important because a failed configuration method is different from a failed @Test method.
====================================================================================================
	 */
	
	/*
	 * 8. Important interview points
1. @BeforeTest executes before test methods belonging to an XML <test> tag.
2. It is not executed before every Java class.
3. Multiple Java classes can belong to the same XML <test>.
4. Multiple XML <test> tags can cause multiple executions of @BeforeTest.
5. It can be declared in a configuration class included in the XML execution or inherited by included test classes.
6. It is commonly used for test-environment preparation and configuration loading.
7. It does not replace @BeforeMethod or @BeforeClass

=============================================================================================================
	 */

/*
 * 
 */
}

