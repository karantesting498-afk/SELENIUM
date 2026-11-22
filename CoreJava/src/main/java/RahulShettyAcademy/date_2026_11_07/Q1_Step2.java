/*
 * Q1. Employee Encapsulation
(Medium) Encapsulation, Getters, Setters, Validation

Create an Employee class with the following private variables:
- employeeId – int
- employeeName – String
- age – int
- salary – double
Requirements:
1. Create public getters and setters for all variables.
2. Employee ID should be greater than 0.
3. Employee name should not be null or empty.
4. Age should be between 18 and 60 (inclusive).
5. Salary should be greater than 0.
6. If invalid data is provided, display an appropriate error message and do not update the existing value.
7. Create two employee objects and demonstrate that their data is independent.
Expected demonstration:
- Create an employee with valid details.
- Try updating age with an invalid value.
- Try updating salary with a negative value.
- Display employee details before and after invalid updates.
 */
package RahulShettyAcademy.date_2026_11_07;

public class Q1_Step2 {
	
	private int employeeId;
	private String employeeName;
	private int age;
	private double salary;
	
	public int getEmpId()
	{
		return employeeId;
	}
	
	public String getEmpName()
	{
		return employeeName;
	}
	

	public int getEmpAge()
	{
		return age;
	}
	
	public double getEmpSalary()
	{
		return salary;
	}
	
	
	public void setEmpId(int employeeId)
	{
		if(employeeId>0)
		{
			this.employeeId = employeeId;
		}
		else
		{
			System.out.println("Invalid data : "+ employeeId);
		}
	}
	
	public void setEmpName(String employeeName)
	{
		if(employeeName!=null && !employeeName.isEmpty())
		{
			this.employeeName = employeeName;
		}
		else
		{
			System.out.println("Invalid data : "+ employeeName);
		}
	}
	

	public void setEmpAge(int age)
	{
		if(age>=18 && age <=60)
		{
			this.age = age;
		}
		else
		{
			System.out.println("Invalid data : "+ age);
		}
	}
	
	public void setEmpSalary(double salary)
	{
		if(salary>0)
		{
			this.salary = salary;
		}
		else
		{
			System.out.println("Invalid data : "+ salary);
		}
	}
	
	public static void main(String[] args) {
		
		Q1_Step2 obj = new Q1_Step2();
		
		obj.setEmpId(1);
		obj.setEmpName("Karan");
		obj.setEmpAge(18);
		obj.setEmpSalary(2000);
		
		System.out.println(obj.getEmpId());
		System.out.println(obj.getEmpName());
		System.out.println(obj.getEmpAge());
		System.out.println(obj.getEmpSalary());
		
		obj.setEmpAge(-10);
		obj.setEmpId(-5);
		obj.setEmpName(null);
		obj.setEmpSalary(-90);
		
		System.out.println(obj.getEmpId());
		System.out.println(obj.getEmpName());
		System.out.println(obj.getEmpAge());
		System.out.println(obj.getEmpSalary());
	}
	
	
}
