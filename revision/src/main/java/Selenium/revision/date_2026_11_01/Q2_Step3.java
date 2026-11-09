/*
 * Question 2 – Debugging listener registration
You have created the following listener:
public class MyListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
    }
}


Your test class:
public class LoginTest {

    @Test
    public void login() {
        Assert.fail("Login failed");
    }
}


Your testng.xml:
<suite name="Suite">

    <test name="Test">
        <classes>
            <class name="test.LoginTest"/>
        </classes>
    </test>

</suite>


The test fails, but Test Failed is never printed.

Questions:
1. What is the most likely reason?
2. How would you register the listener using XML?
3. Can you register the same listener using @Listeners?
4. If the listener class is in a different package, what should you consider while registering it?
5. If you register the same listener through both XML and @Listeners, what should you investigate?
 */
package Selenium.revision.date_2026_11_01;

public class Q2_Step3 {
	
	/*
	 * 1. Because in xml file we did not add listener tag.
	 * 2. Add listerner tag in xml file.
	 * 3.. Yes we also use @Listener annotation.
	 * 4. We can use listners.ClassName.class to access @listerner or listeners.ClassName in xml.
	 * 5. don't know
	 * 
	 * This is an important debugging scenario.

You should investigate whether the listener is being registered twice and whether that causes duplicate callback execution.

For example, if the listener is registered through both mechanisms, check whether:
- onTestFailure() executes twice.
- The same failure message is printed twice.
- Your TestNG version and execution configuration handle both registrations as separate registrations.
Do not assume duplicate registration is automatically harmless. Verify the actual behavior in your TestNG execution environment.
	 */

}
