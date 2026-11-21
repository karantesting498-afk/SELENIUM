/*
 * Q1. Basic Inheritance and Code Reusability
Medium
Create a parent class Employee with:
- employeeId
- employeeName
- salary
- displayEmployeeDetails()
- calculateAnnualSalary()
Create a child class Developer that inherits Employee.

Additional child-class variable:

- programmingLanguage

Requirements:
1. Initialize employee details.
2. Create a method writeCode().
3. Display all employee details, including programming language.
4. Calculate and display annual salary.
5. Demonstrate that the child class can access inherited methods and accessible variables.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q1_Step1_Parent {
	
	int employeeId;
	String employeeName;
	int salary;
	
	
	
	public Q1_Step1_Parent(int employeeId, String employeeName, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public String displayEmployeeDetails()
	{
		return "Employee Details : [ Employee id : "+ this.employeeId + " , Employee name : " + this.employeeName + " , monthly Salary : "+ this.salary +", Annual salary : "+ calculateAnnualSalary() +" ]";
	}
	
	public int calculateAnnualSalary()
	{
		return this.salary*12;
	}

}
