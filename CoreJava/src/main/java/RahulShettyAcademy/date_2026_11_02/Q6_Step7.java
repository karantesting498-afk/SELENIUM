/*
 *Q1. Data Types and Type Conversion
Write a Java program that:
1. Declares variables of byte, short, int, long, float and double.
2. Performs widening conversions from smaller to larger compatible types.
3. Performs narrowing conversions from double to int and int to byte.
4. Displays the original and converted values.
5. Demonstrates what happens when a value exceeds the range of byte.
Expected learning: Primitive data types, widening, narrowing and data loss.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q6_Step7 {

	
	public static void main(String[] args) {
		
		byte a =10;
		short b =20;
		int c=30;
		long d =40;
		float e = 50.5f;
		double f = 130.5;
		
		System.out.println(a);

		System.out.println(b);

		System.out.println(c);

		System.out.println(d);

		System.out.println(e);

		System.out.println(f);
		
		System.out.println("=========");

		System.out.println((short) a);
		System.out.println("=========");

		System.out.println((int)b);
		System.out.println("=========");
		
		System.out.println((long) c);
		System.out.println("=========");

		System.out.println((float) d);
		System.out.println("=========");

		System.out.println((double) e);
		
		
		System.out.println("=========");
		System.out.println("=========");

		System.out.println((int) f);
		System.out.println("=========");

		System.out.println((byte) c);
		System.out.println("=========");

		
		System.out.println((byte) f);
		
		
	}
	
}
