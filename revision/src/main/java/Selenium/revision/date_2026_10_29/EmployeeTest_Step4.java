/*
 * Question 3 – Practical debugging challenge
Difficulty: Hard

You have the following TestNG class:
public class EmployeeTest {

    @Test(enabled = false)
    public void createEmployee() {
        System.out.println("Create Employee");
    }

    @Test
    public void updateEmployee() {
        System.out.println("Update Employee");
    }

    @Test
    public void deleteEmployee() {
        System.out.println("Delete Employee");
    }

    @Test
    public void viewEmployee() {
        System.out.println("View Employee");
    }
}


Your requirement is:
- Disable createEmployee() temporarily.
- Execute updateEmployee() and viewEmployee().
- Execute deleteEmployee() only if updateEmployee() passes.
- If updateEmployee() fails, deleteEmployee() should be skipped.
- Do not disable the entire class.
 */
package Selenium.revision.date_2026_10_29;

import org.testng.annotations.Test;

public class EmployeeTest_Step4 {


	    @Test(enabled = false)
	    public void createEmployee() {
	        System.out.println("Create Employee");
	    }

	    @Test(enabled=true)
	    public void updateEmployee() {
	        System.out.println("Update Employee");
	    }

	    @Test(dependsOnMethods = {"updateEmployee"}, enabled=true)
	    public void deleteEmployee() {
	        System.out.println("Delete Employee");
	    }

	    @Test(enabled=true)
	    public void viewEmployee() {
	        System.out.println("View Employee");
	    }
	}

