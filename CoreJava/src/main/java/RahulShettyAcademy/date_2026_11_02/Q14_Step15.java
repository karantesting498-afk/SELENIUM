/*
 * Q9. Real-World Employee Bonus Calculator
Create an employee salary calculator.

Requirements:
1. Store employee name, employee ID and base salary.
2. Declare a static company bonus percentage.
3. Calculate the bonus using a local variable.
4. Calculate final salary.
5. Check whether the employee qualifies for an additional incentive:
   - Salary greater than ₹50,000.
   - Employee ID is even.
6. Use a ternary operator to classify the employee as "Eligible" or "Not Eligible".
7. Create three employee objects and display their information.
Expected learning: Combining variables, operators, type conversion and conditional expressions.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q14_Step15 {
	
	String employeeName;
	int employeeId;
	int salary;
	
	static int percentage = 50;
	
	public Q14_Step15(String employeeName, int employeeId, int salary) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
	}
	
	public void calculateBonus(String eligibility, Q14_Step15 obj)
	{
		int bonusAmount=1000;
		int finalSalary;
		
		displayDetails(obj);
		if(eligibility.equalsIgnoreCase("Eligible"))
		{
			
			finalSalary = obj.salary+ bonusAmount +(obj.salary * percentage)/100;
		}
		else
		{
			finalSalary = obj.salary +(obj.salary * percentage)/100;
		}
		
		System.out.println("Final Salary after bonus is :" + finalSalary);

	}
	
	
	public void displayDetails(Q14_Step15 obj)
	{
		System.out.println("Name is :"+ obj.employeeName);
		System.out.println("Id is :"+ obj.employeeId);
		System.out.println("Base salary is :"+ obj.salary);
	}

	public void calculateEligibility(Q14_Step15 obj)
	{
		String result =(obj.salary>50000 && (obj.employeeId%2==0))? "Eligible": "Non- Eligible";
		System.out.println(result);
		
		obj.calculateBonus(result,obj);

		
		
	}


	public static void main(String[] args) {
		
		Q14_Step15 obj1 = new Q14_Step15("A",2,51000);
		Q14_Step15 obj2 = new Q14_Step15("B",3,5000);
		Q14_Step15 obj3 = new Q14_Step15("C",4,10000);
		
		obj1.calculateEligibility(obj1);
		obj2.calculateEligibility(obj2);
		obj3.calculateEligibility(obj3);
		

		
		
	}
	

}
