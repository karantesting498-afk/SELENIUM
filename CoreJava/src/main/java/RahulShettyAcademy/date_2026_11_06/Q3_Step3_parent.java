/*
 * Q3. super Keyword – Variables and Methods
Hard
Write a program using the following classes:
class Employee {

    String department = "General";

    void display() {
        System.out.println("Employee display");
    }
}

class Developer extends Employee {

    String department = "Development";

    void display() {
        System.out.println("Developer display");
    }

    void showDetails() {

        // Complete your implementation here
    }
}


Requirements:
1. Display the child-class department.
2. Display the parent-class department using super.
3. Call the parent-class display() method.
4. Call the child-class display() method.
5. Explain the difference between this and super.
6. Explain what happens if the parent and child have variables with the same name.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q3_Step3_parent {
	
	String department = "General";

    void display() {
        System.out.println("Employee display");
    }

}


