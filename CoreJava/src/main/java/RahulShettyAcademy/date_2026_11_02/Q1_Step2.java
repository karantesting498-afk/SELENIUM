/*
 * Question 1 – Medium
Medium

Type Casting and Data Types

Write a Java program that:
1. Declares an int, a float, and a double.
2. Converts the int into a double using widening.
3. Converts the double into an int using narrowing.
4. Displays the original and converted values.
5. Demonstrates what happens to the decimal portion during narrowing.
Expected learning: Widening, narrowing and data loss.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q1_Step2 {
	
	int a =10;
	float b =20;
	double c =30.5;
	
	double d = a;
	int e = (int) c;
	
	public static void main(String[] args) {
		Q1_Step2 obj = new Q1_Step2();
		
		System.out.println(obj.a);
		System.out.println(obj.b);
		System.out.println(obj.c);
		System.out.println(obj.d);
		System.out.println("After narrowing :"+obj.e);
		
		/*
		 * 1. Widening means converting a lower size type data type into upper type. Like int to double or fload
		 * narrowing means converting a upper size type data type into lower type like double to int.
		 * 
		 * Widening: Converting a value from a type with a narrower range/precision to a compatible type with a wider range/precision. It is generally performed automatically.

Narrowing: Converting a value into a type with a narrower range/precision. Explicit casting is generally required and information may be lost.



		 */
	}

}
