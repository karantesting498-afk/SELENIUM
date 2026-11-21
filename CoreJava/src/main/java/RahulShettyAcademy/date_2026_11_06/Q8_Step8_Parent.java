/*
 * Q8. IS-A vs HAS-A Relationship
Advanced
Create a real-world example using:
- Vehicle
- Car
- Engine
Requirements:
1. Car should inherit from Vehicle.
2. Car should contain an Engine object.
3. Vehicle should have a method start().
4. Engine should have a method startEngine().
5. Car should have a method startCar() that uses the Engine object.
6. Demonstrate both IS-A and HAS-A relationships.
7. Explain why Engine should not necessarily inherit from Vehicle.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q8_Step8_Parent {
	
	public void start()
	{
		System.out.println("Vehicle started");
	}

	
}


