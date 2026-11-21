/*
 * Q4. Constructor Execution in Inheritance
Hard
Create three classes:

Company → Employee → Manager

Requirements:
1. Company should have a no-argument constructor.
2. Employee should have a parameterized constructor accepting employee name.
3. Manager should have a parameterized constructor accepting employee name and department.
4. Use super() appropriately to call parent constructors.
5. Print a message from every constructor.
6. Create a Manager object.
7. Predict the complete constructor execution order before running the program.
8. Explain what happens if the required parent constructor is not explicitly called.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q4_Step4_Parent {
	
	public Q4_Step4_Parent() {
		System.out.println("This is parent class default constructo");
	}

}


