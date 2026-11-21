//This class contains knowledge regardning oops concept
package RahulShettyAcademy.date_2026_11_06;

public class Oops_Step1 {
	
	/*
	 * 1. What is Inheritance?
Inheritance is an OOP feature in which one class acquires accessible properties and methods from another class.

It helps us:
- Reuse existing code.
- Avoid unnecessary duplication.
- Create parent-child relationships.
- Extend existing functionality.
Real-world example
Imagine a company has different types of employees:
- Manager
- Developer
- Tester
All employees have common information:
- Employee ID
- Name
- Salary
But each role has different responsibilities.

Instead of writing the common employee details separately in every class, we can create a parent class called Employee.
Java implementation
Parent class
class Employee {

    int employeeId;
    String employeeName;

    void displayDetails() {
        System.out.println(employeeId);
        System.out.println(employeeName);
    }
}

Child class
class Developer extends Employee {

    String programmingLanguage;

    void writeCode() {
        System.out.println("Developer is writing code");
    }
}

Main class
public class Main {

    public static void main(String[] args) {

        Developer dev = new Developer();

        dev.employeeId = 101;
        dev.employeeName = "Karan";
        dev.programmingLanguage = "Java";

        dev.displayDetails();
        dev.writeCode();
    }
}

Notice:
- Employee is the parent class (superclass).
- Developer is the child class (subclass).
- extends establishes inheritance.
- The Developer object can access inherited accessible members and its own members.
Important: Private members are not directly accessible in the child class. Also, constructors are not inherited.
	 */
	
	
	
	/*
	 * 2. Types of Inheritance
Java supports several forms of inheritance through classes.
A. Single inheritance
One child class inherits from one parent class.
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

Here, Dog inherits from Animal.





B. Multilevel inheritance
A class inherits from another child class, creating a chain.
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

class Puppy extends Dog {

    void weep() {
        System.out.println("Weeping");
    }
}

A Puppy object can access the accessible methods of both Dog and Animal.




C. Hierarchical inheritance
Multiple child classes inherit from the same parent class.
class Vehicle {

    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {

    void drive() {
        System.out.println("Driving car");
    }
}

class Bike extends Vehicle {

    void ride() {
        System.out.println("Riding bike");
    }
}

Both Car and Bike inherit the accessible start() method.


Multiple inheritance means a child inherits from more than one parent.

Java does not support multiple inheritance through classes.

The following is invalid:
class A {
}

class B {
}

// Invalid Java
class C extends A, B {
}

Why does Java restrict this?

One reason is ambiguity, commonly illustrated by the diamond problem: if both parent classes provide the same method, which implementation should the child inherit?

Java supports multiple inheritance of type through interfaces, which we'll study on Day 6.



Quick comparison

| Type | Supported through classes? |
|--------|--------|
| Single | Yes |
| Multilevel | Yes |
| Hierarchical | Yes |
| Multiple | No |
| Hybrid | Not directly through classes |



	 *
	 */

	
	/*
	 * 
	 * 3. super Keyword
The super keyword refers to the immediate parent-class portion of the current object.

It has three important uses.
A. Accessing parent-class variables


class Employee {

    String name = "Employee";
}

class Manager extends Employee {

    String name = "Manager";

    void display() {

        System.out.println(name);
        System.out.println(super.name);
    }
}

Output:
Manager
Employee

- name accesses the child variable.
- super.name accesses the parent variable.


B. Calling parent-class methods
class Employee {

    void display() {
        System.out.println("Employee details");
    }
}

class Manager extends Employee {

    void display() {

        super.display();

        System.out.println("Manager details");
    }
}

Here, super.display() explicitly invokes the parent implementation.


C. Calling parent-class constructors
class Employee {

    Employee() {
        System.out.println("Employee constructor");
    }
}

class Manager extends Employee {

    Manager() {

        super();

        System.out.println("Manager constructor");
    }
}

Output:
Employee constructor
Manager constructor

Important rules:
- super() calls the parent constructor.
- It must be the first statement in a constructor.
- If you don't explicitly write super(), Java attempts to insert an implicit no-argument super() call.
- If the parent has no accessible no-argument constructor, you must explicitly call a suitable parent constructor.



	 */
	
	
	/*
	 * 4. Constructor Execution in Inheritance
This is a very important interview topic.

Remember: constructors are not inherited, but a child object's construction always involves its parent constructor.

Consider:
class A {

    A() {
        System.out.println("A constructor");
    }
}

class B extends A {

    B() {
        System.out.println("B constructor");
    }
}

class C extends B {

    C() {
        System.out.println("C constructor");
    }
}

Now create an object:
C obj = new C();

Output:
A constructor
B constructor
C constructor

Why?

The constructor chain starts from the highest parent class and proceeds down to the child.


Constructor execution order
1. Class A constructor executes.
2. Class B constructor executes.
3. Class C constructor executes.

Parameterized parent constructor
class Employee {

    Employee(String name) {
        System.out.println(name);
    }
}

class Manager extends Employee {

    Manager() {
        super("Karan");
        System.out.println("Manager created");
    }
}

Output:
Karan
Manager created


Without super("Karan"), Java would try to call Employee() with no arguments, which does not exist.

	 */

	/*
	 * 5. Method Overriding
Method overriding happens when a child class provides its own implementation of an inherited instance method using the same method signature.
Example
class Employee {

    void work() {
        System.out.println("Employee is working");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Developer is writing code");
    }
}

Calling:
Developer dev = new Developer();

dev.work();

Output:
Developer is writing code

The child class has overridden the parent's work() method.


Why use @Override?
@Override is an annotation that tells the compiler you intend to override a parent method.

It helps identify mistakes such as:
- Incorrect method names.
- Incorrect parameter lists.
- Incorrect method signatures.
Rules of method overriding

The method name must match.
The parameter list must match.
Return type must be the same or covariant (a compatible subtype).
Access visibility cannot be reduced.
final methods cannot be overridden.
private methods are not overridden because they are not inherited.
Static methods are hidden, not overridden.
Constructors cannot be overridden.


Overriding with different access modifiers
For example, if the parent method is protected, the child can override it using protected or public, but not private.

	 */

	
	/*
	 * 6. Polymorphism
Polymorphism means one thing can take multiple forms.

In Java, two commonly discussed forms are:
1. Compile-time polymorphism – method overloading.
2. Runtime polymorphism – method overriding.
A. Compile-time polymorphism
You studied this on Day 4.


class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

Java determines which overloaded method to call using the arguments during compilation.


B. Runtime polymorphism
Runtime polymorphism is achieved through method overriding and a parent reference referring to a child object.
class Employee {

    void work() {
        System.out.println("Employee working");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Developer coding");
    }
}

class Tester extends Employee {

    @Override
    void work() {
        System.out.println("Tester testing");
    }
}

Now:
Employee emp;

emp = new Developer();
emp.work();

emp = new Tester();
emp.work();

Output:
Developer coding
Tester testing

Although the reference type is Employee, the actual object determines which overridden method runs.


This is runtime polymorphism.


	 */

	/*
	 * 7. Dynamic Method Dispatch
Dynamic method dispatch is the mechanism Java uses to decide which overridden instance method should execute at runtime.

Consider:
class Parent {

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child");
    }
}

Now:
Parent obj = new Child();

obj.show();

Output:
Child

Why?
- Reference type: Parent.
- Actual object type: Child.
- Overridden method implementation: Child's show().
The JVM determines the appropriate overridden method using the actual object type.
Very important: Reference type vs object type
Parent obj = new Child();


| What? | Value |
|--------|--------|
| Reference type | Parent |
| Actual object type | Child |
| Accessible members | Determined primarily by reference type at compile time |
| Overridden method executed | Determined by actual object at runtime |


Important limitation
class Parent {

    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {

    void display() {
        System.out.println("Child display");
    }

    void childMethod() {
        System.out.println("Child method");
    }
}

Now:
Parent obj = new Child();

obj.display();
// obj.childMethod(); // Compilation error

Even though the actual object is Child, the reference type Parent does not expose childMethod() directly.

This distinction is fundamental to understanding runtime polymorphism.


8. Method Overloading vs Method Overriding
You have already studied overloading. Now compare both concepts.

| Method overloading | Method overriding |
|--------|--------|
| Same method name | Same method signature |
| Different parameter lists | Same parameter list |
| Usually within the same class | Requires inheritance |
| Compile-time polymorphism | Runtime polymorphism |
| Return type alone cannot differentiate methods | Return type must be compatible |
| Static methods can be overloaded | Static methods are hidden, not overridden |


Interview trap: Method overloading is not necessarily runtime polymorphism, even if it involves inheritance.



	 */

	/*
	 * 9. IS-A Relationship
IS-A represents inheritance.

For example:
- Dog IS-A Animal.
- Developer IS-A Employee.
- Car IS-A Vehicle.
Java implementation:
class Vehicle {
}

class Car extends Vehicle {
}

A Car is a Vehicle.

This relationship is established using extends for classes.
10. HAS-A Relationship
HAS-A represents a relationship where one class contains a reference to another class.

For example:
- Car HAS-A Engine.
- Employee HAS-A Address.
- LoginPage HAS-A WebDriver reference.
Example
class Engine {

    void start() {
        System.out.println("Engine started");
    }
}

class Car {

    Engine engine = new Engine();

    void startCar() {
        engine.start();
        System.out.println("Car started");
    }
}

Here, Car has an Engine object.
IS-A vs HAS-A


| IS-A | HAS-A |
|--------|--------|
| Inheritance relationship | Object reference relationship |
| Uses `extends` for classes | Uses object references |
| Example: Dog IS-A Animal | Example: Car HAS-A Engine |
| Represents specialization | Represents composition or association |

Selenium connection: A Page Object class may HAS-A WebDriver reference, while a base page class and child page classes may demonstrate IS-A through inheritance.


	 */
	
	/*
	 * 11. Important interview questions and common mistakes
Before the assignment, make sure you can answer these:
1. Why doesn't Java support multiple inheritance through classes?
2. Can a constructor be inherited?
3. Can a constructor be overridden?
4. What is the difference between this() and super()?
5. Why must super() be the first constructor statement?
6. Can we override a static method?
7. Can we override a private method?
8. Can we override a final method?
9. What happens when the parent reference points to a child object?
10. What is dynamic method dispatch?
11. What is the difference between overloading and overriding?
12. Can a parent reference access child-specific methods directly?

12. Day 5 quick revision sheet

| Keyword / Concept | Purpose |
|--------|--------|
| `extends` | Inheritance |
| `super.variable` | Access parent variable |
| `super.method()` | Call parent method |
| `super()` | Call parent constructor |
| `@Override` | Mark intended method overriding |
| Overloading | Same name, different parameters |
| Overriding | Child redefines inherited instance method |
| Runtime polymorphism | Actual object decides overridden method |
| IS-A | Inheritance |
| HAS-A | Object relationship |


	 */
}
