// THis class contains knowledge regarding oops concept like encapsulation , abstraction
package RahulShettyAcademy.date_2026_11_07;

public class OOPS_2_Step1 {
	
	/*
	 * 1. What is Encapsulation?
Encapsulation is an OOP concept in which we combine data (variables) and methods that operate on that data inside a class, while controlling access to that data.

Consider an employee:
- Employee has a name.
- Employee has an age.
- Employee has a salary.
- We should not allow anyone to assign an invalid age or salary directly.
Without proper encapsulation:
class Employee {

    String name;
    int age;
    double salary;
}

Anyone can create an object and assign invalid values:
Employee emp = new Employee();

emp.age = -10;
emp.salary = -50000;

There is no protection.

The problem: Anyone who has access to the object can directly modify its data.


2. How to achieve Encapsulation?
We generally achieve encapsulation by:
1. Declaring instance variables as private.
2. Providing public getter methods to read values.
3. Providing public setter methods to update values.
4. Adding validation inside setter methods when required.
Example:
class Employee {

    private String name;
    private int age;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {

        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {

        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }

    public double getSalary() {
        return salary;
    }
}

Usage:
public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Karan");
        emp.setAge(25);
        emp.setSalary(50000);

        System.out.println(emp.getName());
        System.out.println(emp.getAge());
        System.out.println(emp.getSalary());

        emp.setAge(-10);
    }
}

Here:
- private prevents direct access from outside the class.
- getAge() allows controlled reading.
- setAge() allows controlled modification.
- Validation prevents invalid age values from being assigned.

(Interview important)

Remember: Encapsulation is not simply making variables private.

 It is about bundling data and methods together and controlling how the data is accessed or modified.
	 */
	
	/*
	 * 3. What are Getters and Setters?
Method	Purpose
Getter	Returns the value of a variable
Setter	Updates the value of a variable


Example:
private String username;

// Getter
public String getUsername() {
    return username;
}

// Setter
public void setUsername(String username) {
    this.username = username;
    
    
    Why do we need this?
Consider:
public void setAge(int age) {
    this.age = age;
}

There are two variables named age:
- this.age refers to the instance variable.
- age refers to the method parameter.
this identifies the current object's instance variable.

Can we have a getter without a setter?
Yes.
private String employeeId;

public String getEmployeeId() {
    return employeeId;
}

This allows external classes to read the employee ID but not modify it through a setter.


Can we have a setter without a getter?
Yes.
private String password;

public void setPassword(String password) {
    this.password = password;
}

This allows the password to be updated without exposing its value through a getter.

This is useful for sensitive information.


	 */

	/*
	 * 4. Encapsulation vs Data Hiding
These concepts are related but not identical.


| Encapsulation | Data Hiding |
|--------|--------|
| Combines data and methods inside a class | Restricts direct access to internal data |
| Achieved through class design and access control | Commonly achieved using `private` |
| Broader OOP concept | One aspect of encapsulation |

For example, declaring an employee's salary as private is data hiding. Providing validated methods to read or update it is part of an encapsulated design.


	 */
	
	/*
	 * Part 2: Abstraction
5. What is Abstraction?
Abstraction means showing only essential functionality while hiding unnecessary implementation details.

Consider an ATM.

You can:
- Withdraw money.
- Check your balance.
- Deposit money.
You do not need to understand the internal banking server communication, database queries, or transaction-processing logic.

You use the functionality without knowing all its implementation details.

The same concept applies in Java.
Real-world example
Consider a Selenium WebDriver:

WebDriver driver = new ChromeDriver();

driver.get("https://example.com");
driver.findElement(By.id("username"));

You use methods such as get() and findElement() without needing to know all the internal browser communication implementation.

This is abstraction through an interface.

There are two major ways to achieve abstraction in Java:
1. Abstract classes.
2. Interfaces.
	 */
	
	/*
	 * Part 3: Abstract Classes
6. What is an Abstract Class?
An abstract class is a class declared using the abstract keyword.

It can contain:
- Abstract methods (methods without a body).
- Concrete methods (methods with a body).
- Instance variables.
- Static variables and methods.
- Constructors.
Example:

abstract class Animal {

    abstract void sound();

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

Here:
- sound() is an abstract method.
- sleep() is a concrete method.
An abstract method only declares what should happen. Its implementation is provided by a concrete child class.


7. How to use an Abstract Class?
abstract class Animal {

    abstract void sound();

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sound();
        dog.sleep();
    }
}

Output:
Dog barks
Animal is sleeping

The child class provides the implementation of the abstract method.


The child class provides the implementation of the abstract method.
Important rules of Abstract Classes
1. An abstract class cannot be instantiated directly.
2. It can have constructors.
3. It can have both abstract and concrete methods.
4. It can contain instance and static variables.
5. A child class must implement all inherited abstract methods unless the child is also abstract.
6. An abstract class can extend another abstract or concrete class.
7. An abstract class can implement interfaces.
8. Abstract class cannot have object.

Example of an invalid operation:
Animal animal = new Animal(); // Compilation error

But this is valid:
Animal animal = new Dog();

This is called upcasting, which we'll cover later.


8. Can an Abstract Class Have a Constructor?
Yes.

Even though you cannot create an abstract class object directly, its constructor executes when a child object is created.
abstract class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }

    abstract void sound();
}

class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

When you execute:
Dog dog = new Dog();

Output:
Animal constructor
Dog constructor

The parent constructor executes before the child constructor.
	 */
	
	/*
	 * Part 4: Interfaces
9. What is an Interface?
An interface is a reference type in Java that defines a contract that implementing classes agree to follow.

It is declared using the interface keyword.

Example:
interface Vehicle {

    void start();

    void stop();
}

Here, start() and stop() are implicitly public abstract methods.

A class implements an interface using the implements keyword.
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

Usage:
public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.stop();
    }
}

Output:
Car started
Car stopped

Important interface rules
1. You cannot instantiate an interface directly.
2. A class uses implements to implement an interface.
3. A class can implement multiple interfaces.
4. Interface abstract methods are implicitly public and abstract.
5. Interface variables are implicitly public static final.
6. A class implementing an interface must implement its abstract methods unless it is abstract.
7. Interfaces do not have constructors.
8. An interface can extend multiple interfaces.


10. Can Interfaces Have Methods With Bodies?
Yes. Modern Java supports several types of interface methods.

| Method type | Introduced | Description |
|--------|--------|--------|
| Abstract method | Java 1.0 | No method body |
| Default method | Java 8 | Has a body and uses `default` |
| Static method | Java 8 | Has a body and belongs to the interface |
| Private method | Java 9 | Internal helper method for interface methods |

Example:
interface Vehicle {

    void start();

    default void fuelType() {
        System.out.println("Vehicle uses fuel or electricity");
    }

    static void companyInfo() {
        System.out.println("Vehicle manufacturing company");
    }

    private void helper() {
        System.out.println("Internal helper");
    }
}

A class can inherit and override the default method.
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void fuelType() {
        System.out.println("Car uses petrol");
    }
}

Important:
- Default methods are inherited by implementing classes.
- Static interface methods are called using the interface name.
- Private interface methods cannot be accessed directly by implementing classes.
- Private methods help reuse code inside the interface.


	 */

	/*
	 * Part 5: Multiple Inheritance Through Interfaces
11. Does Java Support Multiple Inheritance?
Java does not support multiple inheritance through classes.

This is invalid:
class A {
}

class B {
}

class C extends A, B { // Compilation error
}

Why?

Imagine both parent classes have a method named display() with different implementations. If the child inherits both, Java would need to resolve which implementation should be used.

This is commonly explained through the diamond problem.

However, Java supports multiple inheritance of type through interfaces.

Example:
interface Camera {

    void takePhoto();
}

interface MusicPlayer {

    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {

    @Override
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }
}

A class can implement multiple interfaces.
What if two interfaces have the same default method?
The implementing class must resolve the conflict by overriding the method.
interface A {

    default void display() {
        System.out.println("A display");
    }
}

interface B {

    default void display() {
        System.out.println("B display");
    }
}

class C implements A, B {

    @Override
    public void display() {
        System.out.println("C display");
    }
}

Alternatively, inside the overriding method, you can explicitly invoke a particular interface's default implementation:
A.super.display();

This resolves the ambiguity.
	 */
	
	/*
	 * Part 6: The final Keyword
12. What is final in Java?
The final keyword restricts modification or extension depending on where it is used.

It can be applied to:
1. Variables.
2. Methods.
3. Classes.
A. Final Variable
Once assigned, a final variable cannot be reassigned.

final int age = 25;

age = 30; // Compilation error

A final instance variable must be initialized either at declaration, in an instance initializer, or in every applicable constructor.

Example:
class Employee {

    final int employeeId;

    Employee(int employeeId) {
        this.employeeId = employeeId;
    }
}

B. Final Method
A final method cannot be overridden by a child class.
class Parent {

    final void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {

    // Cannot override display()
}

C. Final Class
A final class cannot be extended.
final class Vehicle {
}

// class Car extends Vehicle { } // Compilation error

Example of a well-known final class:

String is a final class in Java.


13. Important: Final Reference vs Immutable Object

This is a common interview question.
final StringBuilder sb = new StringBuilder("Java");

sb.append(" Selenium"); // Allowed

// sb = new StringBuilder("Python"); // Not allowed

Why?
- The reference sb cannot point to another object.
- The object itself can still be modified.
Final reference does not automatically make an object immutable.


	 */
	
	
	/*
	 * Part 7: Upcasting and Downcasting
14. What is Upcasting?
Upcasting means assigning a child-class object to a parent-class reference.
class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.eat();
    }
}

Here:
- Actual object: Dog
- Reference type: Animal
This is valid and happens implicitly.

What can you access through the parent reference?
You can directly access only members available through the reference type.
Animal animal = new Dog();

animal.eat();  // Valid
// animal.bark(); // Compilation error

Even though the actual object is a Dog, bark() is not declared in the Animal reference type.

15. What is Downcasting?
Downcasting means converting a parent reference back into a child reference.
Animal animal = new Dog();

Dog dog = (Dog) animal;

dog.bark();

Output:
Dog barks

Unlike upcasting, downcasting requires an explicit cast.

What happens if the actual object is not of the target type?
Animal animal = new Animal();

Dog dog = (Dog) animal;

This compiles but throws:
ClassCastException

at runtime.
How to avoid unsafe downcasting?
Use instanceof.

Animal animal = new Dog();

if (animal instanceof Dog) {

    Dog dog = (Dog) animal;

    dog.bark();
}

Java 16+ also supports pattern matching for instanceof:
if (animal instanceof Dog dog) {
    dog.bark();
}

This avoids writing the explicit cast separately.



	 */
	
	/*
	 * Part 8: Abstract Class vs Interface
16. Important Interview Comparison

| Feature | Abstract Class | Interface |
|--------|--------|--------|
| Keyword | `abstract class` | `interface` |
| Object creation | Not directly possible | Not directly possible |
| Constructor | Yes | No |
| Instance variables | Yes | No ordinary instance variables |
| Static variables | Yes | Yes, implicitly public static final |
| Abstract methods | Yes | Yes |
| Concrete methods | Yes | Yes |
| Default methods | No special default-method feature | Yes |
| Static methods | Yes | Yes |
| Private methods | Yes | Yes, since Java 9 |
| Inheritance | A class extends only one class | A class can implement multiple interfaces |
| Interface inheritance | Can implement interfaces | Can extend multiple interfaces |

When should you use an Abstract Class?
Use an abstract class when related classes share:
- Common state.
- Common implementation.
- Common constructors.
- A common base structure.
Example: Employee, Manager, and Developer may share employee ID, name, and common employee functionality.

When should you use an Interface?
Use an interface when you want to define a common capability or contract across potentially unrelated classes.

Example:
- Runnable
- Comparable
- WebDriver
Different classes can implement the same interface while providing different implementations.

Can we use both together?
Absolutely.
abstract class Employee {

    abstract void work();

    void login() {
        System.out.println("Employee logged in");
    }
}

interface Reportable {

    void generateReport();
}

class Tester extends Employee implements Reportable {

    @Override
    void work() {
        System.out.println("Testing application");
    }

    @Override
    public void generateReport() {
        System.out.println("Test report generated");
    }
}

A class can extend one class and implement multiple interfaces.


	 */
	
	
	/*
	 * Part 10: Interview Revision
These are important questions you should be able to explain after completing Day 6.
No.	Interview question
1	What is encapsulation?
2	What is the difference between encapsulation and data hiding?
3	Why do we make variables private?
4	Can we have a getter without a setter?
5	What is abstraction?
6	What is an abstract class?
7	Can an abstract class have a constructor?
8	Can an abstract class have zero abstract methods?
9	What is an interface?
10	Why can't we create an interface object?
11	Can an interface extend multiple interfaces?
12	Can a class implement multiple interfaces?
13	What is the difference between extends and implements?
14	What is the diamond problem?
15	What are default and static methods in interfaces?
16	What is the difference between final variable, method, and class?
17	Does a final reference make an object immutable?
18	What is upcasting and downcasting?
19	What is ClassCastException?
20	Abstract class vs interface: when would you use each?


Day 6 – Quick Revision Sheet
Encapsulation
- Bind data and methods inside a class.
- Use private variables and controlled access.
- Getters read values; setters update values.
Abstraction
- Hide implementation details.
- Expose essential functionality.
- Achieved through abstract classes and interfaces.
Abstract Class
- Can have constructors, variables, abstract and concrete methods.
- Cannot be instantiated directly.
- A child class extends it.
Interface
- Defines a contract.
- A class implements it.
- Supports multiple interface implementation.
- Supports default and static methods since Java 8; private methods since Java 9.
Final
- Variable: cannot be reassigned.
- Method: cannot be overridden.
- Class: cannot be extended.
Casting
- Upcasting: child object to parent reference.
- Downcasting: parent reference to child reference.
- Unsafe downcasting can cause ClassCastException.
	 */

}
