/*
 * Q3. Debugging & Framework Design — Incorrect Configuration Scope
A developer has created the following framework:
public class BaseTest {

    protected String baseUrl;

    @BeforeTest
    public void setupEnvironment() {
        baseUrl = "https://qa.example.com";
        System.out.println("Environment initialized");
    }
}








public class LoginTest extends BaseTest {

    @Test
    public void login() {
        System.out.println(baseUrl);
    }
}




public class PaymentTest extends BaseTest {

    @Test
    public void payment() {
        System.out.println(baseUrl);
    }
}


The developer executes both classes using the following XML:
<suite name="Suite">

    <test name="Regression">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.PaymentTest"/>
        </classes>
    </test>

</suite>




The developer expects setupEnvironment() to execute only once for the entire XML <test>.

Answer:
1. Is the developer's expectation guaranteed by this inheritance-based design?
2. What happens when the configuration method is inherited by both test classes?
3. How would you redesign the configuration to ensure environment setup occurs once per XML <test>?
4. What would you change if each class needed a different environment?
5. Would moving the setup to @BeforeClass solve the original requirement? Explain.
 */
package Selenium.revision.date_2026_10_27;

public class Q3_Step4 {
	
	/*
	 * 1. Yes, SetupEnvironment will be executed once only.- wrong
	 * 
	 * 
	 * The @BeforeTest method is inherited by both LoginTest and PaymentTest.

TestNG processes the inherited configuration method in the context of each test class. Therefore, it is not guaranteed to execute only once across both classes.

With the given XML configuration, it executes once for each applicable class.

Expected execution count: 2 times.



	 * 2. Configuration will be shared with child classes. 
	 * 
	 * Correct answer:

Both child classes inherit the setupEnvironment() method from BaseTest.

TestNG discovers and executes the inherited @BeforeTest configuration method for each child class.

Expected execution:
LoginTest:
    setupEnvironment()
    login()

PaymentTest:
    setupEnvironment()
    payment()


Output:
Environment initialized
https://qa.example.com

Environment initialized
https://qa.example.com


Remember: Java inheritance allows child classes to access parent methods and variables, 
but it does not make TestNG execute an inherited configuration method only once across all child classes.


	 * 3. I think current works fine- wrong
	 * 
	 * Move environment initialization out of the inherited BaseTest configuration method and use a dedicated configuration mechanism.

One simple approach is to use a TestNG listener that initializes the environment once for each ITestContext (the context associated with an XML <test>).




	 * 4. We can execute both classes in different test suite and add paramter annotation to verify enviornment
	 * 
	 * Use separate XML <test> tags and assign a different environment parameter to each one.

You do not need separate XML suite files. Multiple <test> tags can exist inside the same suite.


<suite name="Suite">

    <test name="LoginRegression">

        <parameter name="environment" value="QA"/>

        <classes>
            <class name="tests.LoginTest"/>
        </classes>

    </test>

    <test name="PaymentRegression">

        <parameter name="environment" value="Staging"/>

        <classes>
            <class name="tests.PaymentTest"/>
        </classes>

    </test>

</suite>


The configuration mechanism reads the parameter from the current XML <test> context.

Result:
Test class	Environment	URL
LoginTest	QA	https://qa.example.com
PaymentTest	Staging	https://staging.example.com

Each XML <test> has its own environment configuration.


	 * 5. Yes we can do this, as Parent method will be executed before child method 
	 * 
	 * Correct answer: No.

@BeforeClass executes once per test class, not once per XML <test>.

Since your XML contains two classes:
- LoginTest → @BeforeClass executes once.
- PaymentTest → @BeforeClass executes once.
Expected execution count: 2 times.

Example:
@BeforeClass
public void setupEnvironment() {
    baseUrl = "https://qa.example.com";
    System.out.println("Environment initialized");
}


Expected output:
Environment initialized
LoginTest

Environment initialized
PaymentTest


The annotation scope is the deciding factor, not whether the method belongs to a parent or child class.
	 */

}
