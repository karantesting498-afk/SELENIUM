package RahulShettyAcademy.date_2026_11_06;

public class Step8_Child2 extends Q8_Step8_Parent{

	Step8_Child1 obj = new Step8_Child1();// HAs A relationship

	public void startCar()
	{
		obj.startEngine();
		start();
		System.out.println("Start Car");
	}
	public static void main(String[] args) {
		
		Step8_Child2 obj2 = new Step8_Child2();
		
		obj2.start();//IS-A relation ship. Q8_Step8_Parent class is  parent of Step8_Child2
		obj2.startCar();// Has-A Relation ship. calling it's own class method using object
		
	}
	
	
	/*
	 * Engine should not inherit from Vehicle because an Engine is not a Vehicle,
   it is a part of one. Inheritance models "is a" and composition models
   "has a". With composition, the Engine can be reused in other classes
   (Bike, Truck) and changed without affecting the inheritance chain.
	 */
}
