/*
 * Q1. Execution Flow and Instance Variables
Type: Code Analysis + Theory | Hard

Consider the following code:
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeTest {

    int count = 10;

    @BeforeClass
    public void setupClass() {
        count += 5;
        System.out.println("Before Class: " + count);
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

    @Test
    public void testC() {
        count += 4;
        System.out.println("Test C: " + count);
    }
}

Tasks:
1. Write the complete console output, assuming execution order A → B → C.
2. How many times will setupClass() execute?
3. Will the value of count be shared across all three test methods?
4. What would happen if count were declared as a local variable inside setupClass()?
5. If @BeforeClass were replaced with @BeforeMethod, how would the execution behaviour change?
 */
package Selenium.revision.date_2026_10_25;

public class EmployeeTest_Step2 {

	/*
	 * 1. Output
	 * 
	 * Before Class: 15
	 * Test A: 17
	 * Test B: 20
	 * Test C: 24
	 * 
	 * 2. only once.
	 * 
	 * 3. Yes because count is a class variable.
	 * 
	 * 4. Then TestA,B,C cannot access the count variable.
	 * This is correct.

However, you should also explain why.
@BeforeClass
public void setupClass() {
    int count = 10;
    count += 5;
}


Here, count becomes a local variable.

Its scope is limited to the setupClass() method. Therefore:
- setupClass() can access count.
- testA(), testB(), and testC() cannot directly access it.
- The local variable is destroyed when setupClass() finishes execution.
Also, the instance variable declared at class level would remain unchanged if a separate local variable with the same name were declared inside setupClass().




	 * 
	 * 5. 	Then setupClass() will be executed before every test method.
	 * 
	 * 
	 */
}
