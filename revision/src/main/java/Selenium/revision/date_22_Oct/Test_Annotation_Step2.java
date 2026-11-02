// This class contains questions for test annotation
package Selenium.revision.date_22_Oct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_Annotation_Step2 {
	WebDriver driver;
	
	/*
	 * Q1. What is TestNG, and why do we use it with Selenium WebDriver?
	 * 
	 * Ans: TestNg is a testing framework, it helps with organizing the test scripts and execution order.
	 *
	 */

	
	/*
	 * Q2. Suppose you write a Java method that opens Google using Selenium, but you don't annotate it with @Test. 
	 * 
	 * What is the difference between running that method as an ordinary Java method and having TestNG recognize it as a test?
	 * 
	 * 
	 * Ans: suppose we have written a method Test1, to open browser and print title.
	 * Without annoation @Test, it will simply open browser and print title
	 * But with annotation @Test, it will print the outcome and generate execution result as pass or fail.
	 *  
	 */
	
	/*
	 * Q3. Suppose your test prints Login Successful to the console, even though the login actually failed. 
	 * Will TestNG automatically mark the test as failed just because the login failed? Explain your reasoning.
	 * 
	 * Ans: In case we have added assertion for next page after login, then @Test will mark login failed.
	 * 
	 */
	
	/*
	 * Q4. Can TestNG open a browser and click a button without Selenium WebDriver or another browser automation mechanism? 
	 * Why or why not?
	 * 
	 * Ans: No , TestNg cannot alone open browser and click button.
	 * Browser interaction is done by selenium webDriver not testNG.
	 * TestNG only organize test scripts, and report the execution result
	 */
	
	/*
	 * Q5. You have ten test methods in one Java class. 
	 * Why might using TestNG be more useful than manually calling all ten methods from main()?
	 * 
	 * Ans: BEcause TestNG by default call all the methods with @Test annotation.
	 * We don't need to manually call each
	 */
	
	/*
	 * Q6. Understanding @Test
Consider the following code:
public class LoginTest {

    public void testLogin() {
        System.out.println("Login test executed");
    }

    @Test
    public void testSearch() {
        System.out.println("Search test executed");
    }
}

Assume the class is executed using TestNG.

Questions:
1. Which method will TestNG recognize as a test method?
2. Will testLogin() execute automatically as a TestNG test? Why or why not?
	 */
	
	public void ques_06()
	{
		/*
		 * 1. testSearch() will be automatically recognized as test method.
		 * 2. No, TestNg will not execute testLogin(). TestNg only execute methods with @Test Annotations
		 */
	}
	
	
	/*
	 * Q7. TestNG vs Selenium
You need to automate a login scenario on a website.
- Open the browser.
- Enter a username and password.
- Click the Login button.
- Verify that the user reaches the dashboard.
Question: Which responsibilities belong to Selenium WebDriver, and which belong to TestNG? Explain with examples.
	 */
	
	@Test
	public void ques_07()
	{
		/*
		 * Your responsibility comments are mostly correct:
		 * 
- Selenium WebDriver: Opens the website, locates elements, enters credentials, clicks buttons, and retrieves UI state.

- TestNG: Recognizes the @Test method, executes it, evaluates assertion outcomes, and reports the test result.

One subtle point: Assert.assertTrue() belongs to TestNG, not Selenium. Selenium supplies the result of isDisplayed(),
 and TestNG evaluates that result.



		 */
		driver.get("https://google.com");// Responsiblity of webDriver
		WebElement user = driver.findElement(By.id("username")); // Responsiblity of webDriver
		WebElement pass = driver.findElement(By.id("password")); // Responsiblity of webDriver
		
		user.sendKeys("Karan"); // Responsiblity of webDriver
		pass.sendKeys("123456"); // Responsiblity of webDriver
		
		driver.findElement(By.id("loginBtn")).click(); // Responsiblity of webDriver
		
		Assert.assertTrue(driver.findElement(By.id("dashboard_User")).isDisplayed());// // Responsiblity of webDriver and testNg will share output result

	}
	
	
	/*
	 * Q8. Identifying Test Results
Consider the following test:
@Test
public void verifyLogin() {
    System.out.println("Login Successful");
}

Suppose the actual login operation fails, but the method still prints Login Successful.

Questions:
1. Will TestNG automatically know that the login failed?
2. What would you need to add to the test to verify that login actually succeeded?
Instructions: Answer Q1 first. I'll review your answer like a technical interviewer before we move to Q2.
 I won't reveal the solutions until you attempt each question.
	 */
	
	public void ques_08()
	{
		/*
		 * 1. No we have to add the assertion
		 * 2. Assertion to check next page after login is displayed
		 */
	}
	
	
	/*
	 * Q9. TestNG execution and assertions

Consider the following code:
@Test
public void testLogin() {
    System.out.println("Step 1");
    Assert.assertTrue(false);
    System.out.println("Step 2");
}

@Test
public void testSearch() {
    System.out.println("Step 3");
}


Assume both methods are discovered by TestNG, and no dependencies or special execution-order settings are configured.

Question 1: What happens after Assert.assertTrue(false) executes inside testLogin()? 
Explain whether "Step 2" will print and whether testSearch() can still execute.
	 */
	
	public void ques_09()
	{
		/*
		 * 1. TestNg will print test fail for the method testLogin() 
		 * 
		 * Correct. Assert.assertTrue(false) immediately throws an AssertionError because the condition is false. 
		 * TestNG catches the failure and reports testLogin() as FAILED.
		 * 
		 * 
		 * 
		 * 2. yes it will still execute testSearch();
		 * 
		 * 2. Will testSearch() still execute?

Correct. Since there is no dependency between the methods, TestNG can execute testSearch() even though testLogin() failed.

3. Will "Step 2" print?

You didn't answer this part.

The answer is No. Once Assert.assertTrue(false) throws an AssertionError,
 execution of the current method stops at that statement. The next line is not executed.
		 */
	}
	
	
	/*
	 * Q10. Code-based
public class SampleTest {

    @Test
    public void testA() {
        System.out.println("A");
    }

    public void testB() {
        System.out.println("B");
    }

    @Test
    public void testC() {
        System.out.println("C");
        testB();
    }
}


Assume the required TestNG import is present.
1. How many test methods will TestNG recognize?
2. Will testB() execute during the test execution?
3. If yes, will TestNG count testB() as a separate test case?
	 */
	
	public void ques_10()
	{
		/*
		 * 1. TestNg will recognize only 2 methods : testA() and testC()
		 * 
		 * 2. Yes, because testB() method is called in testC().
		 * 
		 * 3. No it will not be counted as seperate test case. TestNG only count those methods with @Test annotation as separate test 
		 * casee.
		 */
	}
	
	
	/*
	 * Q11. Practical

Suppose you have 10 Selenium test methods in a class. You want TestNG to execute only 7 of them.

How would you control which methods TestNG recognizes for execution?
	 */
	
	public void ques_11()
	{
		/*
		 * There are two common ways to control which methods TestNG executes.

Method 1: Use enabled = false

Suppose you have ten test methods and want to exclude three temporarily.
@Test
public void test1() {
    // Test logic
}

@Test
public void test2() {
    // Test logic
}

@Test(enabled = false)
public void test3() {
    // This test will not execute
}


Apply @Test(enabled = false) to each of the three methods you want to exclude. The remaining seven enabled test methods can execute.

Method 2: Use testng.xml

You can also configure TestNG to include or exclude methods using a TestNG XML suite configuration.
 This is useful when you want to control execution without modifying the test methods themselves.

For example:
<suite name="RegressionSuite">
    <test name="SelectedTests">
        <classes>
            <class name="Selenium.revision.SampleTest">
                <methods>
                    <include name="test1"/>
                    <include name="test2"/>
                    <include name="test4"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>


This configuration selects only the listed methods from the specified class, subject to the suite's configuration.

Interview answer: I can use @Test(enabled = false) to disable individual test methods or configure testng.xml 
to include only the methods I want to execute.
		 */
		
		
	}
	
	/*
	 * Q12. Conceptual

Can we create a TestNG test class without writing a main() method? Explain why.


	 */
	
	public void ques_12()
	{
		/*
		 * 1. Yes we can create testNg class withput main method and run the class as testNg 
		 */
	}
}



