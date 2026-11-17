/*
 * Question 5 – Hard
Hard

Operators, Type Conversion and Expression Evaluation

Write a Java program that:
1. Declares two integer variables and performs division.
2. Performs the same division after converting one operand into double.
3. Demonstrates the difference between pre-increment and post-increment.
4. Demonstrates short-circuit evaluation using && and ||.
5. Uses a bitwise operator to check whether a number is even or odd.
Display the output of every operation and explain why the results differ.

Expected learning: Integer division, type promotion, increment operators, short-circuit evaluation and bitwise operations.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q5_Step6 {
	
	public static void main(String[] args) {
		
		int a =10;
		int b =24;
		
		double c = a;
		double d = b;
		System.out.println(b/a);
		System.out.println(d/c);
		
		System.out.println("pre increment:" + (++a));//10
		System.out.println("INcremented a:" + a);//11
		
		System.out.println("post incrment: "+ (b++));//25
		
		if(a%5==0 && b%5==0)
		{
			System.out.println("using &&");
		}
		
		if(a%5==0 || b%5==0)
		{
			System.out.println("using or ||");
		}
		
	}

}
