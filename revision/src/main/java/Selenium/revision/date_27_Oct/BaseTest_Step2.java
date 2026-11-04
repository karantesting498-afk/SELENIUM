/*
 * Q1. Execution Flow — Multiple XML <test> Tags
Consider the following configuration:

BaseTest.java
public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @Test
    public void testOne() {
        System.out.println("TestOne");
    }

    @Test
    public void testTwo() {
        System.out.println("TestTwo");
    }
}


testng.xml
<suite name="Suite">

    <test name="TestOne">
        <classes>
            <class name="tests.BaseTest"/>
        </classes>
    </test>

    <test name="TestTwo">
        <classes>
            <class name="tests.BaseTest"/>
        </classes>
    </test>

</suite>


Answer the following:
1. How many times will @BeforeTest execute?
2. How many times will @BeforeClass execute?
3. How many times will @BeforeMethod execute?
4. Will the instance variable values be shared between the two XML <test> executions?
5. Explain why the execution scope of these annotations differs.
 */
package Selenium.revision.date_27_Oct;

public class BaseTest_Step2 {
	
	/*
	 * 1. 2 times for testOne and testTwo.
	 * 2. 2 times because class BaseTest is executed twice.
	 * 3. 4 times because there ARE 2 METHODS in BaseTest and BaseTest is executed twice.
	 * 4. No, instance variable will not be shared in two tests.
	 *5. 
	 *BeforeTest is an XML level Annotation.
	 *It will be configured in XML file.
	 *It will be executed once per test suite.
	 *It will not be dependent on number of classes or Test methods.
	 *
	 *BeforeClass is executed once per class.
	 *
	 *BeforeMethoed will be executed once per every test method in that classa
	 */

}
