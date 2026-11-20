/*
 * Create a Calculator class with overloaded methods named calculate().

Requirements:
1. calculate(int a, int b) – addition of two integers.
2. calculate(double a, double b) – addition of two decimal numbers.
3. calculate(int a, int b, int c) – addition of three integers.
4. calculate(int a, double b) – multiplication of an integer and a decimal.
5. calculate(double a, int b) – subtraction of an integer from a decimal.
6. Call all overloaded methods from main().
7. Explain how Java identifies which overloaded method to execute.
8. Demonstrate what happens if you try to overload methods by changing only their return type.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Calculator_Step7 {
	/*
	 * 1 -6 code
	 * 
	 * 7. Java identified overloaded method through the parameters types, parameter count, order of parameter.
	 * 
	 * 8. If we only change return type but do not change the parameters, then error will be displayed
	 */
	
	public int calculate(int a, int b)
	{
		return a+b;
	}
	
	
//	public double calculate(int a, int b)
//	{
//		return a+b +0.5;
//	}
	
	public double calculate(double a, double b)
	{
		return a+b;
	}
	
	public int calculate(int a, int b, int c)
	{
		return a+b+c;
	}
	
	public double calculate(int a, double b)
	{
		return a*b;
	}
	
	public double calculate(double a, int b)
	{
		return a-b;
	}
	
	public static void main(String[] args) {
		
		Calculator_Step7 obj = new  Calculator_Step7();
		
		System.out.println(obj.calculate(10, 15));
		System.out.println(obj.calculate(23.1, 16.9));
		System.out.println(obj.calculate(5, 5, 20));
		System.out.println(obj.calculate(5, 20.5));
		System.out.println(obj.calculate(23.5, 23));
	}

}
