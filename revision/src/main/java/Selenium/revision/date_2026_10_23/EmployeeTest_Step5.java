/*
 * Question 3 — Modify Existing Code (Hard)
You are given this incomplete class:
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest {

    int testCount = 0;

    public void setup() {
        testCount++;
        System.out.println("Test execution number: " + testCount);
    }

    public void testEmployeeName() {
        System.out.println("Testing employee name");
    }

    public void testEmployeeSalary() {
        System.out.println("Testing employee salary");
    }

    public void testEmployeeDepartment() {
        System.out.println("Testing employee department");
    }
}

Requirements:

Modify the code so that:
1. setup() executes before every test method.
2. All three employee methods execute as TestNG tests.
3. The execution counter increments before each test.
4. The counter value is printed before the corresponding test begins.
Your task: Rewrite the complete corrected class.
 */

package Selenium.revision.date_2026_10_23;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeTest_Step5 {
	

	    int testCount = 0;

	    @BeforeMethod
	    public void setup() {
	        testCount++;
	        System.out.println("Test execution number: " + testCount);
	    }

	    @Test
	    public void testEmployeeName() {
	        System.out.println("Testing employee name");
	    }

	    @Test
	    public void testEmployeeSalary() {
	        System.out.println("Testing employee salary");
	    }

	    @Test
	    public void testEmployeeDepartment() {
	        System.out.println("Testing employee department");
	    }
	

}
