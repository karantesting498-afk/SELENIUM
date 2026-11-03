/*
 * Question 4: Failure Handling and Cleanup
Type: Theory + Code Analysis | Hard

Consider this implementation:
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FailureTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Setup started");
        throw new RuntimeException("Setup failed");
    }

    @Test
    public void testA() {
        System.out.println("Test A executed");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Cleanup executed");
    }
}

Tasks:
1. Will testA() execute if setup() throws an exception? Explain.
2. Can you assume @AfterMethod will always execute after a failed setup? Explain why setup failures require special consideration.
3. Modify the setup and cleanup logic so that a partially initialized resource can be cleaned up safely.
4. Explain the difference between a test failure and a configuration-method failure in TestNG.
Constraint: You may use a simulated resource such as a boolean flag; Selenium is not required for this question.
 */
package Selenium.revision.date_24_Oct;

public class FailureTest_Step5 {
	
	
	/*
	 * 1. Yes, Even if setup throws an exception, testA will still execute - wrong
	 * 
	 * Correct answer: No.

Consider:
@BeforeMethod
public void setup() {
    System.out.println("Setup started");
    throw new RuntimeException("Setup failed");
}

@Test
public void testA() {
    System.out.println("Test A executed");
}


TestNG executes @BeforeMethod before the test method.

When setup() throws an exception:
1. Setup started is printed.
2. RuntimeException is thrown.
3. The setup configuration method is marked as failed.
4. testA() is not executed because its required setup failed.
The test method is generally reported as SKIPPED due to the configuration failure.

Expected output includes:
Setup started


It does not include:
Test A executed


Remember: A failed @BeforeMethod is different from a failed @Test.
	 * 
	 * 
	 * 
	 * 2. Yes, we can assumen @AfterMethod will always execute after a failed setup. - wrong
	 * 
	 * 
	 * By default, @AfterMethod has alwaysRun = false.

If a preceding configuration method fails, TestNG does not guarantee that the corresponding cleanup configuration method will execute.

To ensure cleanup is attempted even when setup fails, use:
@AfterMethod(alwaysRun = true)
public void teardown() {
    System.out.println("Cleanup executed");
}


Important distinction:
Situation	Cleanup behavior
Test method passes	Normally executes
Test method fails	Normally executes
Setup configuration fails	Use alwaysRun = true to ensure cleanup is attempted

Why does setup failure require special consideration?

Because setup might fail halfway through initialization.

For example:
boolean resourceCreated = false;

@BeforeMethod
public void setup() {
    System.out.println("Setup started");

    resourceCreated = true;

    throw new RuntimeException("Setup failed");
}


Although setup failed, the resource was already created.

If cleanup is skipped, that resource may remain allocated.


	 * 
	 * 
	 * 3. = wrong
	 * 
	 *     public void setup() {
	 *     
        
        try{
        System.out.println("Setup started");
        }catch(Exception  e)
        {
        	e.printStackTrace();
        };
        
    }
    
        @AfterMethod
    public void teardown() {
        try
        {
        System.out.println("Cleanup executed");
        }catch(Exception e)
        {
        	        	e.printStackTrace();

        };
    }
    
    Correct- 
    
    package Selenium.revision.date_24_Oct;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FailureTest_Step5 {

    boolean resourceCreated = false;

    @BeforeMethod
    public void setup() {

        System.out.println("Setup started");

        resourceCreated = true;

        throw new RuntimeException("Setup failed");
    }

    @Test
    public void testA() {
        System.out.println("Test A executed");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {

        System.out.println("Cleanup started");

        if (resourceCreated) {

            System.out.println("Resource cleaned up");

            resourceCreated = false;
        } else {

            System.out.println("No resource available for cleanup");
        }
    }
}
    
    
    
    4. Test failure means our assertion is failed.
    Configuration fail means failure due to exception, DIV changes, code deprecations.
    
    
    Test failure										Configuration-method failure
    
Occurs inside a @Test method.							Occurs inside @BeforeMethod, @AfterMethod, or another configuration method.


Example: assertion fails.								Example: browser initialization fails.


TestNG marks the test as FAILED.						TestNG marks the configuration method as FAILED.

Other independent tests can normally continue.			Can affect whether associated test methods or subsequent configuration methods execute.

Examples:

Test failure:
@Test
public void testA() {
    Assert.assertEquals(10, 20);
}


The assertion fails, so TestNG marks testA() as FAILED.

Configuration failure:
@BeforeMethod
public void setup() {
    throw new RuntimeException("Browser initialization failed");
}


The configuration method fails, so TestNG generally skips the associated test method.

Your examples of deprecated code and DIV changes are not necessarily configuration failures. 
They become configuration failures only if they cause an exception or another failure inside a configuration method.
    
    
    
    
	 */

}
