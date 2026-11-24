/*
 * Q1. Exception Handling – Calculator
Medium
 try-catch, Multiple Catch, finally

Create a Java calculator that accepts two integer values and an operator.

Supported operators:
- + Addition
- - Subtraction
- * Multiplication
- / Division
- % Modulus
Requirements:
1. Perform the calculation using a switch statement.
2. Handle division by zero.
3. Handle invalid operators using an appropriate exception.
4. Handle invalid numeric input using InputMismatchException.
5. Display "Calculator execution completed" using a finally block.
6. The program should not terminate unexpectedly for the handled input errors.
Test scenarios:
Input	Expected behaviour
10, 5, +	Result 15
10, 0, /	Handle division by zero
10, 3, %	Result 1
10, 5, @	Handle invalid operator
ABC, 5, +	Handle invalid numeric input

Also explain the difference between checked and unchecked exceptions using examples.
 */
package RahulShettyAcademy.date_2026_11_08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1_Step2 {
	
	public double calculate(int a, int b, int ch)
	{
		double result = switch(ch)
		{
		case 1 -> a+b;
		
		case 2 -> a-b;
		
		case 3-> a*b;
		
		case 4 -> a/b;// unchecked exception in case of 0.
		
		case 5 -> a%b; // unchecked exception in case of 0. 
		
		default -> throw new InputMismatchException("Invalid input type");	
		
		};
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Q1_Step2 obj = new Q1_Step2();
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Input A");
			int a = sc.nextInt();
			
			System.out.println("Input B");
			int b = sc.nextInt();
			
			System.out.println("Input choice");
			int ch = sc.nextInt();
			
			obj.calculate(a, b, ch);
		} catch (InputMismatchException | NullPointerException | ArithmeticException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			System.out.println("Calculator execution completed");
			sc.close();
		}
	}

}
