/*
 * Q1. Employee Class and Multiple Objects
(Medium)

Create an Employee class with the following instance variables:
- employeeId
- employeeName
- designation
- salary
Requirements:
1. Create two Employee objects.
2. Assign different values to each object.
3. Create a method displayDetails() to display employee information.
4. Create a method calculateAnnualSalary() that returns annual salary.
5. Display the details and annual salary of both employees.
6. Demonstrate that changing one employee's instance variable does not affect the other employee.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q1_Employee_Step2 {
	
	int employeeId;
	String employeeName;
	String designation;
	int salary;
	
	
	
	public Q1_Employee_Step2(int employeeId, String employeeName, String designation, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
	}
	
	



	@Override
	public String toString() {
		return "Q1_Employee_Step2 [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation="
				+ designation + "]";
	}
	
	public int calculateAnnualSalary()
	{
		System.out.println("[ Salary = "+ (salary*12) + " ]");

		return salary*12;
		
	}
	
	public void displayDetails()
	{
		System.out.println(toString());
	}





	public static void main(String[] args) {
		
		Q1_Employee_Step2 obj1 = new Q1_Employee_Step2(1,"A","Manager", 1000);
		Q1_Employee_Step2 obj2 = new Q1_Employee_Step2(2,"B", "Executive" , 2000);
		
		obj1.displayDetails();
		obj1.calculateAnnualSalary();
		obj2.displayDetails();
		obj2.calculateAnnualSalary();
		
		//Updating first object employeeid. it will not impact obj2 details
		obj1.employeeId=101;
		
		obj1.displayDetails();
		obj2.displayDetails();
		
	}

}
