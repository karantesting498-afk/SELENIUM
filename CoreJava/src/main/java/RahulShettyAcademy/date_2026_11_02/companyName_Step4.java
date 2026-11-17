/*
 * Question 3 – Hard
Hard

Variables, Scope and Static Keyword

Create a Java class with:
- One static variable called companyName.
- One instance variable called employeeName.
- One instance variable called employeeId.
- One local variable inside a method called bonus.
Requirements:
1. Create three objects of the class.
2. Assign different employee names and IDs.
3. Change the company name using one object.
4. Display all three employees' information.
5. Demonstrate that changing the static variable affects all objects but changing an instance variable affects only its respective object.
Expected learning: Static vs instance variables, object creation and variable scope.
 */
package RahulShettyAcademy.date_2026_11_02;

public class companyName_Step4 {
	
	static String companyName ="NG";
	String employeeName;
	int employeeId;
	
	public int bonus()
	{
		int bonusAmount =101;
		
		return bonusAmount;
		
		
	}
	
	public static void main(String[] args) {
		 companyName_Step4 obj1 = new companyName_Step4();
		 companyName_Step4 obj2 = new companyName_Step4();
		 companyName_Step4 obj3 = new companyName_Step4();
		 
		 obj1.employeeId = 1;
		 obj1.employeeName ="A";
		 
		 obj2.employeeId = 2;
		 obj2.employeeName = "B";
		 
		 obj3.employeeId =3;
		 obj3.employeeName ="C";
		 
		 System.out.println(companyName);
		 
		 obj3.companyName ="IG";
		 System.out.println("Updated company name :"+ companyName);
		 
		 System.out.println(obj1.companyName);
		 System.out.println(obj1.employeeId);
		 System.out.println(obj1.employeeName);
		 System.out.println(obj1.bonus());
		 System.out.println("===============");
		 
		 System.out.println(obj2.companyName);
		 System.out.println(obj3.employeeId);
		 System.out.println(obj2.employeeName);
		 System.out.println(obj2.bonus());

		 System.out.println("===============");
		 
		 System.out.println(obj3.companyName);
		 System.out.println(obj3.employeeId);
		 System.out.println(obj3.employeeName);
		 System.out.println(obj3.bonus());

		 System.out.println("===============");
	}
	
	/*
	 * companyName_Step4 obj3 = new companyName_Step4();


Q1. How many copies of companyName exist?

Q2. How many copies of employeeName exist?

Q3. If you execute obj1.employeeId = 100, will obj2.employeeId also become 100? Why?

Q4. If bonus is declared inside bonus(), can you access it directly inside main()? Why?


Q1. How many copies of companyName exist? - since it is static and it will be present in class static area avaiable for all to access. 1 copy will exist only.
2. since it is a instance variable, then it will be avaiable as per object count.
3. No, because employeeId is a instance variable. obj1 will not impact obj2.
4. No, because bonus is a local variable we cannot access it outside class


	 */
	
	

}
