// This class contains knowledge regarding the classes and objects
package RahulShettyAcademy.date_2026_11_05;

public class Classes_And_Objects_Step1 {

	
	/*
	 * Day 4 – Classes and Objects in Java
Day 4 is about understanding how Java programs are designed using classes and objects. This is also an important foundation for Selenium Page Object Model (POM).

We'll start from the basics and gradually move towards interview-level concepts.

Day 4 learning module (Core Java)
10
Core concepts
10
Coding questions
1. What is a Class?
A class is a blueprint or template used to create objects.

For example, imagine an employee in a company.

An employee can have:
- Employee ID
- Employee Name
- Salary
- Department
And can perform actions:
- Display details
- Calculate salary
- Update department
We can represent this structure using a Java class.
public class Employee {

    int employeeId;
    String employeeName;
    double salary;

    void displayDetails() {
        System.out.println(employeeId);
        System.out.println(employeeName);
        System.out.println(salary);
    }
}

Here:
- Employee is the class name.
- employeeId, employeeName, salary are instance variables.
- displayDetails() is an instance method.
Important: A class defines the structure and behaviour. It does not automatically create an object.
	 */
	
	
	
	/*
	 * 2. What is an Object?
An object is an instance of a class.

We create objects using the new keyword.
Employee emp1 = new Employee();

emp1.employeeId = 101;
emp1.employeeName = "Karan";
emp1.salary = 30000;

emp1.displayDetails();

Understand this statement:
Employee emp1 = new Employee();


| Part | Meaning |
|--------|--------|
| `Employee` | Reference variable type |
| `emp1` | Reference variable |
| `new` | Creates an object |
| `Employee()` | Calls the constructor |

An object has:
1. State: Data stored in its variables.
2. Behaviour: Actions performed through its methods.
3. Identity: Its individual object identity.



Multiple objects from one class
Employee emp1 = new Employee();
Employee emp2 = new Employee();

emp1.employeeName = "Karan";
emp2.employeeName = "Rahul";

Both objects have separate instance variables.

Changing emp1.employeeName will not change emp2.employeeName.
	 */

	/*
	 * 3. Instance Variables vs Local Variables
This is a common interview topic.
Instance variables
Variables declared inside a class but outside methods, constructors and blocks.
public class Employee {

    int employeeId;
    String employeeName;

    void display() {
        System.out.println(employeeId);
    }
}

Each object gets its own copy of instance variables.


Default values:

| Data type | Default value |
|--------|--------|
| int | 0 |
| double | 0.0 |
| boolean | false |
| char | `'\u0000'` |
| Object references | null |


Local variables
Variables declared inside a method, constructor or block.
void calculateSalary() {

    double bonus = 5000;

    System.out.println(bonus);
}

- Local variables exist within their declared scope.
- They do not receive automatic default values.
- You must initialize them before using them.
	 */
	
	
	/*
	 * 4. Methods in Java
A method is a block of code designed to perform a particular task.
Basic method
void display() {
    System.out.println("Hello Java");
}

Method with parameters
void add(int a, int b) {
    System.out.println(a + b);
}

Calling it:
add(10, 20);

Method with a return value
int add(int a, int b) {
    return a + b;
}

Calling it:
int result = add(10, 20);

Types of methods based on parameters and return values


| Type | Example |
|--------|--------|
| No parameters, no return | `void display()` |
| Parameters, no return | `void add(int a, int b)` |
| No parameters, return | `int getNumber()` |
| Parameters and return | `int add(int a, int b)` |


Important interview point: void means the method does not return a value.
	 */
	
	
	/*
	 * 5. Constructors
A constructor is a special member of a class used to initialize objects.

Important characteristics:
1. Constructor name must match the class name.
2. It has no return type, not even void.
3. It is called when an object is created.
4. Constructors can be overloaded.
5. Constructors are not inherited.
Default constructor
If you don't declare any constructor, the Java compiler provides a default constructor.


public class Employee {

    int employeeId;
    String employeeName;
}

The compiler provides a no-argument constructor.
No-argument constructor written by developer
public class Employee {

    Employee() {
        System.out.println("Employee object created");
    }
}

Parameterized constructor
public class Employee {

    int employeeId;
    String employeeName;

    Employee(int id, String name) {
        employeeId = id;
        employeeName = name;
    }
}

Object creation:
Employee emp1 = new Employee(101, "Karan");

Default constructor vs no-argument constructor


| Default constructor | No-argument constructor |
|--------|--------|
| Provided by compiler | Can be written by developer |
| Only when no constructor is declared | Explicitly declared with zero parameters |
| Has no parameters | Has no parameters |


Important: If you declare a parameterized constructor, Java will not automatically provide a default constructor.




	 */
	
	/*
	 * 6. Constructor Overloading
When a class contains multiple constructors with different parameter lists, it is called constructor overloading.
public class Employee {

    int employeeId;
    String employeeName;

    Employee() {
        employeeId = 0;
        employeeName = "Unknown";
    }

    Employee(int id) {
        employeeId = id;
        employeeName = "Unknown";
    }

    Employee(int id, String name) {
        employeeId = id;
        employeeName = name;
    }
}

You can create objects using different constructors:
Employee e1 = new Employee();
Employee e2 = new Employee(101);
Employee e3 = new Employee(102, "Karan");

The compiler selects the constructor based on the arguments passed.



	 */
	
	
	
	/*
	 * 7. this Keyword
this refers to the current object.

One of its most common uses is to differentiate instance variables from local variables or constructor parameters.

Without this:
public class Employee {

    int employeeId;

    Employee(int employeeId) {
        employeeId = employeeId;
    }
}

Here, both references point to the constructor parameter. The instance variable does not get initialized with the supplied value.

Correct approach:
public class Employee {

    int employeeId;

    Employee(int employeeId) {
        this.employeeId = employeeId;
    }
}

Here:
- this.employeeId refers to the instance variable.
- employeeId refers to the constructor parameter.



Other uses of this
1. Calling another method of the same object
void display() {
    System.out.println("Hello");
}

void show() {
    this.display();
}

2. Calling another constructor
Employee() {
    this(101);
}

Employee(int id) {
    System.out.println(id);
}

this() must be the first statement in a constructor.

3. Returning the current object
Employee getEmployee() {
    return this;
}
	 */

	
	/*
	 * 8. Static Variables and Static Methods
The static keyword means a member belongs to the class rather than to individual objects.
Static variable
public class Employee {

    int employeeId;
    String employeeName;

    static String companyName = "ABC Technologies";
}

All objects share the same static variable.
Employee e1 = new Employee();
Employee e2 = new Employee();

e1.employeeId = 101;
e2.employeeId = 102;

System.out.println(Employee.companyName);

Prefer accessing static members using the class name.
Static method
public class Calculator {

    static int add(int a, int b) {
        return a + b;
    }
}

Calling:
int result = Calculator.add(10, 20);


Static vs instance members

| Static | Instance |
|--------|--------|
| Belongs to class | Belongs to object |
| One shared copy of static variable | Separate variable per object |
| Can be accessed using class name | Requires an object reference |
| Cannot directly access instance members | Can access static and instance members |

Important interview rule: A static method cannot directly access instance variables or instance methods because it does not have a current object (this).



	 */
	
	
	
	
	
	
	
	/*
	 * 9. Static Block and Instance Initialization Block
These blocks execute automatically at particular stages of object/class initialization.
Static block
public class Demo {

    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}

Output:
Static block
Main method

A static block executes when the class is initialized, before the main method in this example.
Instance initialization block
public class Demo {

    {
        System.out.println("Instance block");
    }

    Demo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
    }
}

Output:
Instance block
Constructor
Instance block
Constructor

The instance initialization block executes whenever an object is created, before the constructor body.
Execution order to remember
For a simple class initialization:
1. Static variables and static blocks execute once during class initialization, in textual order.
2. Instance variables and instance initialization blocks execute during object creation, in textual order.
3. Constructor body executes afterward.
	 */
	
	
	/*
	 * 10. Access Modifiers
Access modifiers control where class members can be accessed.

| Modifier | Same class | Same package | Subclass in another package | Other package |
|--------|--------|--------|--------|--------|
| private | Yes | No | No | No |
| default (package-private) | Yes | Yes | No, unless access is through package membership | No |
| protected | Yes | Yes | Yes, subject to subclass access rules | No, except through subclass access rules |
| public | Yes | Yes | Yes | Yes |

Example
public class Employee {

    private int salary = 30000;

    public void displaySalary() {
        System.out.println(salary);
    }
}

The salary variable cannot be directly accessed from another class, but it can be accessed through the public method.

Note: A top-level class can be public or package-private. It cannot be declared private or protected.



	 */
	
	/*
	 * 11. Important interview concepts and common mistakes
	 * 
	 * | Concept | What to remember |
|--------|--------|
| Class vs Object | Blueprint vs instance |
| Constructor vs Method | Constructor initializes objects; method performs operations |
| Constructor return type | No return type |
| Constructor overloading | Different parameter lists |
| Method overloading | Same method name, different parameter lists |
| `this` | Current object reference |
| `static` | Belongs to class |
| Instance variable | Separate copy per object |
| Static variable | Shared across objects |
| Local variable | Must be initialized before use |
| Static block | Runs during class initialization |
| Instance block | Runs during object initialization |


Common interview traps
- Can a constructor be overloaded? Yes.
- Can a constructor be static? No.
- Can a constructor be private? Yes.
- Can a static method use this? No.
- Can a method be overloaded by changing only its return type? No.
- Can a class have multiple constructors? Yes.
- Does Java provide a default constructor if you declare your own constructor? No.
- Can a static method be called without creating an object? Yes.



	 */
}

