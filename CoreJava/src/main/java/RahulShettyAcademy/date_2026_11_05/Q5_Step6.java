/*
 * Q5. Practical Employee Management Class
(Hard)

Create an Employee class that represents an employee management system.
Variables
Variable	Type	Access
employeeId	int	private
employeeName	String	private
designation	String	private
monthlySalary	double	private
companyName	String	static


Requirements
1. Create a parameterized constructor to initialize employee details.
2. Use this wherever required.
3. Create getter methods for private variables.
4. Create a setter method to update employee designation.
5. Create a method calculateAnnualSalary().
6. Create a method displayEmployeeDetails().
7. Create a static method changeCompanyName() to update the company name.
8. Create at least three objects.
9. Update the designation of one employee.
10. Change the company name and verify that all employees display the updated name.
11. Demonstrate that private variables cannot be accessed directly from the main() method.
Validation requirement:
- Employee ID should not accept zero or negative values.
- Employee name should not be null or empty.
- Monthly salary should not be negative.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q5_Step6 {
	
	private int employeeId;
	private String employeeName;
	private String designation;
	private double monthlySalary;
	static String companyName = "Insightgeeks";
	
	public Q5_Step6(int employeeId, String employeeName, String designation, double monthlySalary) {
		super();
		
		if(employeeId<=0)
		{
			throw new IllegalArgumentException("Invalid employee id");
		}
		
		if(employeeName==null || employeeName.isEmpty())
		{
			throw new IllegalArgumentException("Invalid employee name");

		}
		
		if(monthlySalary<= 0)
		{
			throw new IllegalArgumentException("Invalid employee monthly salary");

		}
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.monthlySalary = monthlySalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double calculateAnnualSalary()
	{
		return monthlySalary*12;
	}
	
	
	
	@Override
	public String toString() {
		return "Q5_Step6 [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", monthlySalary=" + monthlySalary + " | Annual: " + calculateAnnualSalary() +", companyName= "+Q5_Step6.companyName + "]";
	}

	public void displayEmployeeDetails()
	{
		System.out.println(toString());
	}
	
	public static void changeCompanyName(String company)
	{
		Q5_Step6.companyName = company;
	}
	

	public static void main(String[] args) {
		
		 Q5_Step6 obj1 = new Q5_Step6(1, "A", "QA1", 10000);
		 obj1.displayEmployeeDetails();

		 Q5_Step6 obj2 = new Q5_Step6(2, "B", "QA2", 20000);
		 obj2.displayEmployeeDetails();

		 Q5_Step6 obj3 = new Q5_Step6(3, "C", "QA3", 30000);
		 obj3.displayEmployeeDetails();
		 
		 obj1.setDesignation("Java Developer");
		 obj1.displayEmployeeDetails();
		 
		 Q5_Step6.changeCompanyName("Updated company");
		 
		 obj1.displayEmployeeDetails();
		 obj2.displayEmployeeDetails();
		 obj3.displayEmployeeDetails();
		 
		obj1.employeeId = 101;
		obj1.displayEmployeeDetails();
	}
	
	

}
