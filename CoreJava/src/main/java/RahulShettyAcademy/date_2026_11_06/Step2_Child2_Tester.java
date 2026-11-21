package RahulShettyAcademy.date_2026_11_06;

public class Step2_Child2_Tester extends Step2_Parent3_Employee{

	public void childTester() {
		System.out.println("this is child class tester with parent employee");
	}
	
	public static void main(String[] args) {
		
		
		Step2_Child1_Car car = new Step2_Child1_Car();// it can access own and it's parent class methods. cannot access other class methods. Follows single level inheritance
		car.childCar();// child class method
		car.displayVehcile();// parent class method
		
		Step2_Child3_Puppy puppy = new Step2_Child3_Puppy();// it can access own,parent, grandparent class method. it follows multilevel inheritance.
		puppy.childPuppy();//child class method
		puppy.childDog();//parent class method
		puppy.displayAnimal();//grandparent class method.
		
		Step2_Child1_Developer dev = new Step2_Child1_Developer();// can access own and parent class methods. But cannot access sibling class methods like childTester
		dev.childDeveloper();// child class method.
		dev.displayEmployee();// Parent class method
		
		Step2_Child2_Tester test = new Step2_Child2_Tester();// can access own and parent class methods. But cannot access sibling class methods like childDeveloper
		test.childTester(); // Child class method
		test.displayEmployee();// Parent class method
		
		// Inheritance does not support multiple level inhertiance in case there is a method display() which is same in both parent class. Then compiler will be confused which method to call..
	}
}

