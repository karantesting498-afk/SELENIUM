// This class contains question regarding After method
package Selenium.revision.date_24_Oct;

public class ExecutionTest_Step2 {
	
	/*
	 * Question 1: Execution Flow and Instance Variables
Type: Practical + Theory | Hard

Study the following code:
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExecutionTest {

    int count = 0;

    @BeforeMethod
    public void setup() {
        count++;
        System.out.println("Setup: " + count);
    }

    @Test
    public void testA() {
        count += 2;
        System.out.println("Test A: " + count);
    }

    @Test
    public void testB() {
        count += 3;
        System.out.println("Test B: " + count);
    }

    @AfterMethod
    public void teardown() {
        count++;
        System.out.println("Teardown: " + count);
    }
}

Assume:
- testA() executes before testB().
- TestNG uses the same instance of the class for both methods.
- Both tests execute successfully.
Tasks:
1. Write the complete console output in execution order.
2. Explain how count changes during each phase.
3. What would change if count were reset to 0 inside setup() instead of being initialized at the class level?
4. Does TestNG guarantee that test methods will execute in the order they appear in the source code? Explain.
	 */
	
	
	public void ques_01()
	{
		/*
		 * 1. Output:
		 * Setup: 1
		 * Test A: 3
		 * TearDown: 4
		 * Setup: 5
		 * Test B: 8
		 * TearDown: 9
		 * 
		 * 
		 * 2. Intial count =0;
		 * TestA Execution start, so setup method is called which increment count =1 and print Setup: 1
		 * Then testA is executed , which increment count by 2 so count =3  and print  Test A: 3
		 * After TestA is executed, TearDown is executed so count =4 and print  TearDown: 4
		 * 
		 * TestB is called then, so setup is executed, which incement count by 1 so count =5 and print Setup: 5
		 * Then testB is executed , which increment count by 3 so count =8  and print  Test B: 8
		 * After TestB is executed, TearDown is executed so count =9 and print  TearDown: 9
		 * 
		 * 
		 * 3. If count is initialized in setup method then for every test method execution, count will start form 0.
		 * 
		 * 4. By default they execute in order of the source code but we can change order by using annotations
		 * 
		 * 
		 * 4. Does TestNG guarantee source-code execution order?
Your answer needs a small correction.

TestNG does not guarantee that test methods will execute in source-code order. You should not rely on the order in which methods appear in the Java file.

You can control ordering explicitly using mechanisms such as:
@Test(priority = 1)
public void testA() {
    // Test logic
}

@Test(priority = 2)
public void testB() {
    // Test logic
}


Lower priority values execute before higher values under normal TestNG ordering rules. Other factors, 
such as dependencies and suite configuration, can also influence execution.

Your statement that annotations can change the order is directionally correct, but @Test(priority = ...) 
is the specific mechanism to remember here.


		 */
	}

}
