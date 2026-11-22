/*
 * Q3. Abstract Class – Constructor and Method Execution
(Hard) Abstract Class, Constructors, Overriding

Study the following code:
abstract class Vehicle {

    Vehicle() {
        System.out.println("Vehicle Constructor");
    }

    abstract void start();

    void stop() {
        System.out.println("Vehicle Stopped");
    }
}

class Car extends Vehicle {

    Car() {
        System.out.println("Car Constructor");
    }

    @Override
    void start() {
        System.out.println("Car Started");
    }
}

class Bike extends Vehicle {

    Bike() {
        System.out.println("Bike Constructor");
    }

    @Override
    void start() {
        System.out.println("Bike Started");
    }
}

Tasks:
1. Create one Car object and one Bike object.
2. Predict the exact output.
3. Explain why the parent constructor executes before the child constructor.
4. Explain why Vehicle cannot be instantiated directly.
5. Can an abstract class have a constructor even though its object cannot be created directly? Explain.
6. What happens if Bike does not implement the abstract start() method but is not declared abstract?
 */
package RahulShettyAcademy.date_2026_11_07;

public class Q3_Step4 {

	/*
	 * 1. Vehicle v = new Vehicle();
	 *  
	 *  Car car = new Car();
	 *  Bike bike = Bike();
	 * 
	 *
	 * 2. Output
	 * Since we are only creating car and bike object and not calling any method then output will be only of constructor.
	 * 
	 * Vehicle Constructor
	 * Car Constructor
	 * Vehicle Constructor
	 * Bike Constructor
	 * 
	 * 3. When we create an object of a class, first comipler goes to that class constructor.
	 * In the class constructor first line by default is of super() which passes the control to the parent class
	 * constructor. that's why when we create an object, first parent class constructor is called and then child class constructor.
	 * 
	 * the JVM runs the child constructor, whose first statement is super(),
	 *  so the parent constructor body completes first. The reason is that the parent part of the object must be initialized before
	 *   the child part can use it.
	 * 
	 * 
	 * 
	 * 
	 * 4. Vehicle is an abstract class. we cannot create object for abstract class.
	 * You only restated the fact. The reason: it is declared abstract and has an abstract method start() with no body, 
	 * so a Vehicle object would have nothing to run if start() were called. The compiler blocks it.
	 * 
	 * 5. Yes abstract class can have constructor eventhough we cannot create it's object.
	 * Yes” is correct but there is no explanation. It is needed because child constructors call it via super() to initialize the parent’s fields. 
	 * It runs as part of creating a Car or Bike, never on its own.
	 * 
	 * 6. If parent class have any abstract method then it is compulsory for the child class to implement it and provide body to it.
	 * But if it is not an abstract class, then it is not necessary for child class to create constructor for it.
	 * 
	 * ❌ No. Your answer is off-topic (it talks about constructors). The correct answer: compile-time error (“Bike is not abstract and does not override abstract method start() in Vehicle”). 
	 * 
	 * Fix: implement start() or declare Bike as abstract.
	 * 
	 * 
	 * 
	 */
}
