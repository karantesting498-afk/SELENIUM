/*
 * Q7. Pre-Increment, Post-Increment and Bitwise Operators
Write a Java program that:
1. Declares two integer variables.
2. Demonstrates pre-increment and post-increment.
3. Demonstrates pre-decrement and post-decrement.
4. Uses a bitwise AND operator to check whether a number is even or odd.
5. Uses a bitwise OR operator on two integers.
6. Displays the binary representation of the original numbers and the results using Integer.toBinaryString().
Expected learning: Increment/decrement, bitwise operators and binary representation.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q12_Step13 {
	
	public static void main(String[] args) {
		
		int a =10;
		int b =20;
		int c = 30;
		int d =40;
		
		++a;
		System.out.println(a);
		b++;
		System.out.println(b);
		
		--c;
		System.out.println(c);
		
		d--;
		System.out.println(d);
	}

}
