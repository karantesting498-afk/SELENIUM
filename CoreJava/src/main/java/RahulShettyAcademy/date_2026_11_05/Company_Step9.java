/*
 * Q8. Static and Instance Method Restrictions
Hard
Create a class Company with:
- Static variable companyName.
- Instance variable employeeName.
- Static method displayCompany().
- Instance method displayEmployee().
Requirements:
1. Access the static variable from both static and instance methods.
2. Access the instance variable from the instance method.
3. Try accessing the instance variable directly from the static method.
4. Observe and explain the compilation error.
5. Correct the error by passing an object reference to the static method.
6. Demonstrate calling static methods without creating an object.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Company_Step9 {
	
	static String companyName = "Insightgeeks";
	String employeeName;
	
	public Company_Step9(String employeeName) {
		// TODO Auto-generated constructor stub
		this.employeeName = employeeName;
	}
	
	public static void displayCompany( Company_Step9 obj)
	{
		System.out.println(companyName);
		
//		System.out.println(employeeName);
		
		// error is displayed Cannot make a static reference to the non-static field employeeName. THis error because  static methods cannot directly access non static method or varibale. They can only access it using Class object
		
		System.out.println(obj.employeeName);
	}
	
	public void displayEmployee()
	{
		System.out.println(companyName);
	}

	public static void main(String[] args) {
		Company_Step9 obj = new Company_Step9("ABC");
		
		displayCompany(obj);
		obj.displayEmployee();
	}
}
