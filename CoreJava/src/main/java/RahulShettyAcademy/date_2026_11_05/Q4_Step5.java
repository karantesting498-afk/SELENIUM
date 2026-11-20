/*
 * Q4. Static Block, Instance Block and Constructor Execution
(Hard)

Write a Java program that demonstrates the execution order of:
- Static variable initialization
- Static initialization block
- Instance variable initialization
- Instance initialization block
- Constructor
Requirements:
1. Create a class named ExecutionDemo.
2. Add two static blocks.
3. Add two instance initialization blocks.
4. Add two constructors: one no-argument and one parameterized.
5. Create two objects using different constructors.
6. Print meaningful messages from every initialization stage.
7. Predict the complete execution order before running the program.
8. Explain which blocks execute once and which execute for every object.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Q4_Step5 {
	
	static String var;
	String com ;
	
	static
	{
		System.out.println("Static block 1 initialized");
		var = "ABC";
	}
	
	static
	{
		System.out.println("Static block 2 initialized");
		var = "XYZ";
	}
	
	{
		System.out.println("Instance block 1 initialized");
		com = "Company";
	}
	
	{
		System.out.println("Instance block 2 initialized");
		com = "Hello";
	}
	
	public Q4_Step5() {
		// TODO Auto-generated constructor stub
	}

	public Q4_Step5(String com) {
		// TODO Auto-generated constructor stub
		this.com = com;
	}
	
	public static void main(String[] args) {
		Q4_Step5 obj1 = new Q4_Step5();
		
		Q4_Step5 obj2 = new Q4_Step5("IG");
	}
	
	/*
	 * output
	 * Static block 1 initialized
	 * Static block 2 initialized
	 * Instance block 1 initialized
	 * Instance block 2 initialized--> After this obj1 will be initialized.
	 * Instance block 1 initialized
	 * Instance block 2 initialized--> after this obj2 will be initialized
	 * 
	 * 
	 * static blocks will be executed only once per class
	 * and instance block will be executed for each object creation before object is initialized
	 * 
	 * 
	 */
}
