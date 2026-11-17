/*
 * Q3. Static, Instance and Local Variables
Create an Employee class with:
- Static variable: companyName
- Instance variables: employeeName, employeeId, salary
- Method containing local variable: bonus
Requirements:
1. Create four employee objects.
2. Assign different employee details.
3. Update the company name using the class name.
4. Update the salary of only one employee.
5. Display all employee details.
6. Demonstrate that the static variable is shared but instance variables are independent.
7. Return the bonus from a method and display it.
Expected learning: Object creation, variable scope and static vs instance behaviour.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q8_Step9 {
	static String companyName = "NG";
	
	String employeeName;
	int employeeId;
	int salary;
	
	public int bonus()
	{
		int bonusAmount =10;
		return bonusAmount;
	}
	
	
	public static void main(String[] args) {
		
		Q8_Step9 obj1 = new Q8_Step9();
		
		obj1.employeeName="A";
		obj1.employeeId = 1;
		obj1.salary = 1001;
		
		Q8_Step9 obj2 = new Q8_Step9();
		
		obj2.employeeName="B";
		obj2.employeeId = 2;
		obj2.salary = 2001;
		
		Q8_Step9 obj3 = new Q8_Step9();
		
		obj3.employeeName="C";
		obj3.employeeId = 3;
		obj3.salary = 3001;
		
		Q8_Step9 obj4 = new Q8_Step9();
		
		obj4.employeeName="D";
		obj4.employeeId = 4;
		obj4.salary = 4001;
		
		System.out.println(obj1.employeeId+ obj1.employeeName+ obj1.salary+ obj1.companyName);
		System.out.println(obj2.employeeId+ obj2.employeeName+ obj2.salary+ obj2.companyName);
		System.out.println(obj3.employeeId+ obj3.employeeName+ obj3.salary+ obj3.companyName);
		System.out.println(obj4.employeeId+ obj4.employeeName+ obj4.salary+ obj4.companyName);
		
		
		
		Q8_Step9.companyName = "IG";
		System.out.println(companyName);
		
		System.out.println("=========");
		obj4.salary = obj4.salary+ obj4.bonus();
		System.out.println(obj4.salary);
		
		System.out.println(obj4.bonus());
		

	}

}
