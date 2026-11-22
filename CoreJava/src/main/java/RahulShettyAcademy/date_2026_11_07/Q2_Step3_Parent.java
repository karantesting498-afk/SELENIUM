/*
 * Q2. Abstract Class – Employee Salary Calculation
(Medium) Abstract Class, Abstract Method, Method Overriding

Create an abstract class Employee with:
- Instance variables: employeeName, employeeId.
- A parameterized constructor.
- An abstract method calculateSalary().
- A concrete method displayDetails().
Create two child classes:

FullTimeEmployee
- Monthly salary.
- Bonus.
- Calculate total salary = monthly salary + bonus.
PartTimeEmployee
- Hours worked.
- Hourly rate.
- Calculate total salary = hours worked × hourly rate.
Requirements:
1. Override calculateSalary() in both child classes.
2. Override displayDetails() only if you need to extend the parent's display behaviour.
3. Create objects of both child classes.
4. Display their details and calculated salaries.
 */
package RahulShettyAcademy.date_2026_11_07;

public abstract class Q2_Step3_Parent {
	
	String  employeeName;
	int employeeId;
	
	public Q2_Step3_Parent(String employeeName, int employeeId) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
	}
	
	public abstract void calculateSalary();
	
	public String displayDetails()
	{
		return "[ employee name : "+ employeeName + ", employeeid : "+ employeeId + " ]";
	}
	
}



