/*
 * Q9. Employee Hierarchy – Practical OOP Scenario
Advanced
Design the following employee hierarchy:
Employee

employeeId, employeeName, salary

Developer

programmingLanguage


Tester

testingTool




Requirements:
1. Create the parent class Employee.
2. Create child classes Developer and Tester.
3. Add a performWork() method in the parent.
4. Override performWork() in both child classes.
5. Add a constructor in every class.
6. Use super() for parent constructor initialization.
7. Demonstrate runtime polymorphism using parent references.
8. Display employee details and role-specific information.
9. Explain how inheritance reduces code duplication.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q9_Step9_Parent {
	
	int employeeId;
	String employeeName;
	int salary;
	
	
	
	public Q9_Step9_Parent(int employeeId, String employeeName, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		
		System.out.println("Parent const. ");

	}
	
	public void performWork() {
		System.out.println("Parent is performing");
		
		
	}
	
	public String displayInfo()
	{
		return "[ "+ "Employee id : " + this.employeeId + " , "+  "Employee name : " + this.employeeName + " , "+ "Employee salary : " + this.salary + " ] ";

	}

}



