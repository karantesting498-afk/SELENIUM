/*
 * Q7. Method Overloading vs Method Overriding
Hard
Create a parent class Calculator with overloaded methods:
int calculate(int a, int b)

int calculate(int a, int b, int c)


Create a child class AdvancedCalculator.

Requirements:
1. Override calculate(int a, int b) in the child class to perform multiplication instead of addition.
2. Overload calculate() in the child class to accept two double values.
3. Call all available methods using a child object.
4. Create a parent reference pointing to a child object.
5. Call the overridden method through the parent reference.
6. Explain which methods are resolved at compile time and which are dispatched at runtime.
7. Explain why changing only the return type does not create method overloading.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q7_Step7_Parent {
	
	public  int calculate(int a, int b)
	{
		return a+b;
	}
	
	public  int calculate(int a, int b, int c)
	{
		return a+b+c;
	}

	
	
}
