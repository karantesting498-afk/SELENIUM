/*
 * Q4. Type Conversion and Overflow
Write a Java program that:
1. Stores 127 in a byte variable.
2. Increments it by one.
3. Displays the result after explicit narrowing conversion.
4. Converts 258 into a byte.
5. Converts -130 into a byte.
6. Explains the output based on the byte range and binary representation.
Expected learning: Overflow, narrowing conversion and primitive data representation.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q9_Step10 {
	
	public static void main(String[] args) {
		byte a = 127;
		a++;
		
		int b= 258;
		
		int c = -130;
		
		System.out.println((byte) a);
		
		System.out.println((byte) b);
		
		System.out.println((byte) c);
	}

}
