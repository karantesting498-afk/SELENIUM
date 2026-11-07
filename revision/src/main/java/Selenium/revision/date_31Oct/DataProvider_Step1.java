// This class contains  knowledge of data provider
package Selenium.revision.date_31Oct;

public class DataProvider_Step1 {
	
	
	/*
	 * Notee : 
	 * 
	 * You mean in original code, 

it will not work like one test set of login pass then dashboard executed?

instead it will first execute 3 test set first, if any fail then subsequent deendent method will be skipped altogether?

If all test set pass , then following dependent method will be executed


Exactly! Your understanding is now correct.

In TestNG, when a method uses a DataProvider and another method has a hard dependency on it, TestNG evaluates the dependency across all invocations of the data-driven method.

It does not execute the dependent method after each individual data set.



	 */
	
	/*
	 * TestNG – @DataProvider Annotation
The @DataProvider annotation in TestNG is used to perform Data-Driven Testing (DDT).

It allows us to execute the same test method multiple times with different sets of test data without writing
 separate test methods for each data set.

For example, suppose you want to test login functionality with:
- Valid username and password.
- Invalid username and password.
- Valid username with invalid password.
- Empty username and password.
Instead of creating four separate test methods, you can use one test method with a DataProvider.

========================================================================================
	 */
	
	/*
	 * 1. Basic syntax
A DataProvider consists of two parts:
1. A method annotated with @DataProvider that supplies test data.
2. A test method that consumes the data using dataProvider.
@DataProvider(name = "loginData")
public Object[][] getData() {

    return new Object[][] {
        {"admin", "admin123"},
        {"employee", "emp123"},
        {"manager", "manager123"}
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String username, String password) {

    System.out.println(username);
    System.out.println(password);
}


Execution:

The loginTest() method will execute three times.
Execution	Username	Password
1	admin	admin123
2	employee	emp123
3	manager	manager123


===============================================================================
	 */
	
	/*
	 * 2. Understanding Object[][]
This is one of the most important concepts in DataProvider.
return new Object[][] {
    {"admin", "admin123"},
    {"employee", "emp123"},
    {"manager", "manager123"}
};


Think of it as a table:
Row	Column 1	Column 2
0	admin	admin123
1	employee	emp123
2	manager	manager123

- Each row represents one test-data set.
- Each column represents one parameter passed to the test method.
Therefore:
- 3 rows = 3 test invocations.
- 2 columns = 2 arguments in the test method.
Important: The number and types of values in each row should match the test method's parameters.

===============================================================================================================
	 */
	
	
	/*
	 * 3. DataProvider with different data types
You are not restricted to passing only Strings.
@DataProvider(name = "employeeData")
public Object[][] getEmployeeData() {

    return new Object[][] {
        {"Karan", 25, true},
        {"Rahul", 30, false},
        {"Amit", 28, true}
    };
}

@Test(dataProvider = "employeeData")
public void employeeTest(String name, int age, boolean status) {

    System.out.println(name);
    System.out.println(age);
    System.out.println(status);
}


Here, the DataProvider supplies:
- String
- Integer
- Boolean
Java automatically unboxes the Integer and Boolean values when passed to primitive parameters.


================================================================================================
	 */
	
	
	/*
	 * 4. DataProvider with Object[]
You can also use a one-dimensional array when you need to pass only one parameter.
@DataProvider(name = "browserData")
public Object[] getBrowserData() {

    return new Object[] {
        "Chrome",
        "Firefox",
        "Edge"
    };
}

@Test(dataProvider = "browserData")
public void launchBrowser(String browser) {

    System.out.println(browser);
}


The test method executes three times, once for each browser.

=================================================================
	 */
	
	
	/*
	 * 	5. DataProvider with multiple test methods
You can reuse the same DataProvider for multiple test methods.
@DataProvider(name = "loginData")
public Object[][] getData() {

    return new Object[][] {
        {"admin", "admin123"},
        {"employee", "emp123"}
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String username, String password) {

    System.out.println("Login: " + username);
}

@Test(dataProvider = "loginData")
public void validateUserTest(String username, String password) {

    System.out.println("Validate: " + username);
}


Both test methods will consume the same data.

Each method will execute twice.

===================================================================
	 */
	
	
	/*
	 * 6. DataProvider in a different class
A DataProvider does not have to be in the same class as the test method.

You can use the dataProviderClass attribute to reference another class.

DataProvider class:
public class TestData {

    @DataProvider(name = "loginData")
    public static Object[][] getData() {

        return new Object[][] {
            {"admin", "admin123"},
            {"employee", "emp123"}
        };
    }
}




Test class:
public class LoginTest {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = TestData.class
    )
    public void login(String username, String password) {

        System.out.println(username + " " + password);
    }
}


Important points:
- dataProviderClass identifies the class containing the DataProvider.
- The DataProvider method should be static when it is in a different class.
- The DataProvider method must be accessible to TestNG.

================================================================================================
	 */
	
	
	/*
	 * 7. DataProvider with parallel = true
TestNG allows you to execute DataProvider invocations in parallel.
@DataProvider(name = "loginData", parallel = true)
public Object[][] getData() {

    return new Object[][] {
        {"admin", "admin123"},
        {"employee", "emp123"},
        {"manager", "manager123"}
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String username, String password) {

    System.out.println(
        username + " - " + Thread.currentThread().getId()
    );
}


Here, the three data sets can execute concurrently using separate threads.

Important:
- Execution order is not guaranteed.
- The number of parallel threads can be controlled through the suite's data-provider-thread-count setting.
- When using Selenium, avoid sharing the same WebDriver instance between parallel invocations. Use separate driver instances, commonly managed through ThreadLocal.


============================================================================================================
	 */
	
	/*
	 * 8. DataProvider vs Parameters
This is a very important interview topic.
@Parameters	@DataProvider
Gets values from testng.xml.	Gets values from a Java method.
Commonly used for browser, environment and configuration values.	Commonly used for multiple test-data combinations.
Usually provides values for an XML <test> execution.	Executes the test method for each supplied data set.
Supports configuration methods and test methods.	Primarily used with test methods.
Uses @Parameters.	Uses @DataProvider.

Example:
- @Parameters: Run tests on Chrome or Firefox based on XML configuration.
- @DataProvider: Run login tests with 10 different username/password combinations.


=================================================================
	 */
	
	
	/*
	 * 9. Important DataProvider attributes
Attribute	Purpose
name	Assigns a name to the DataProvider.
parallel	Enables parallel execution of data sets.
dataProvider	Specifies which DataProvider the test should use.
dataProviderClass	Specifies the external class containing the DataProvider.



10. Important interview points
1. @DataProvider is used for Data-Driven Testing.
2. It can execute one test method multiple times with different data sets.
3. It commonly returns Object[][].
4. Each row represents one invocation.
5. Each column represents one method parameter.
6. It can supply different data types.
7. The same DataProvider can be reused by multiple test methods.
8. It can be placed in a separate class using dataProviderClass.
9. Parallel execution can be enabled using parallel = true.
10. The test method's arguments must match the supplied data.


11. Quick revision
Question	Answer
Which annotation provides test data?	@DataProvider
What is its common return type?	Object[][]
What does each row represent?	One test invocation
What does each column represent?	One method parameter
Can we pass multiple data types?	Yes
Can we reuse a DataProvider?	Yes
Can it be in another class?	Yes
Which attribute enables parallel execution?	parallel = true
Which attribute references another class?	dataProviderClass

Interview-ready answer:

"@DataProvider is a TestNG annotation used for Data-Driven Testing. It supplies multiple sets of test data to a test method, allowing the same method to execute multiple times with different inputs. It commonly returns an Object[][], where each row represents one test invocation and each column represents a method parameter."

Recommended practical exercise: Create a login test with five data sets, including positive, negative, and boundary scenarios. This will help you understand how DataProvider works in actual Selenium automation.

	 */

}
