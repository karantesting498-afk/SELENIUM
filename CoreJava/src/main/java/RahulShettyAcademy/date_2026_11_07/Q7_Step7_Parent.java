/*
 * 	Q7. Abstract Class vs Interface – Design Problem
(Hard) Abstraction, Interfaces, Design

You are designing an application with the following requirements:
- Every employee should have an employee ID and name.
- Every employee should have a common login() method.
- Some employees can generate reports.
- Some employees can approve expenses.
- Some employees can perform multiple capabilities.
Design the following:
1. An abstract class Employee containing employee ID, employee name, constructor, and login().
2. An interface Reportable containing generateReport().
3. An interface Approver containing approveExpense().
4. A Manager class that extends Employee and implements both interfaces.
5. A Tester class that extends Employee and implements only Reportable.
Demonstrate all methods through objects.

Theory questions:
- Why did you choose an abstract class for Employee?
- Why did you choose interfaces for Reportable and Approver?
- Can Manager extend two abstract classes?
- Can Manager implement three or more interfaces?
 */
package RahulShettyAcademy.date_2026_11_07;

public abstract class Q7_Step7_Parent {
	
	int employeeId;
	String employeename;
	
	public abstract void run();
	
	public Q7_Step7_Parent(int employeeId, String employeename) {
		super();
		this.employeeId = employeeId;
		this.employeename = employeename;
	}



	public void login()
	{
		System.out.println("Employee login");
	}

}


