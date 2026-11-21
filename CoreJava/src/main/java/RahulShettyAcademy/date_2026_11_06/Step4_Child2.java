package RahulShettyAcademy.date_2026_11_06;

public class Step4_Child2 extends Step4_Child1{
	
	String employeeName;
	String department;
	public Step4_Child2(String employeeName, String department) {
		
		super(employeeName);
		this.department = department;
		
		System.out.println("This is child class manager parameterized constructor");

		
	}
	
	public static void main(String[] args) {
		
		Step4_Child2 obj = new Step4_Child2("Karan", "Testing");
	}
	
	/*
	 * output:
	 * 
	 * This is parent class default constructo
	 * This is child class empploye parameterized constructor
	 * This is child class manager parameterized constructor
	 * 
	 * if we do not explicitly call parent class constructor using super then error will  be displayed to acknowledge parent class constructor.
	 */
	
	
	

}
