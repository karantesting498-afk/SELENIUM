/*
 * Q6. Logical Operators and Short-Circuit Evaluation
Create a program that:
1. Accepts three integer values.
2. Checks whether all three are positive.
3. Checks whether at least two are even.
4. Checks whether exactly one number is negative.
5. Demonstrates short-circuit evaluation using && and ||.
6. Uses a method that prints a message to demonstrate when the second condition is skipped.
Expected learning: Logical operators, nested conditions and short-circuit evaluation.
 */
package RahulShettyAcademy.date_2026_11_02;

import java.util.Scanner;

public class Q11_Step12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a > 0 && b > 0 && c > 0) {
			System.out.println("All positive");
		}

		if ((a % 2 == 0 && b % 2 == 0) || (b % 2 == 0 && c % 2 == 0) || (c % 2 == 0 && a % 2 == 0)

		) {
			System.out.println("At least two numbers are even");
		}

		if ((a < 0 && b >= 0 && c >= 0)
		        || (b < 0 && a >= 0 && c >= 0)
		        || (c < 0 && a >= 0 && b >= 0)) {

		    System.out.println("Exactly one number is negative");
		}
	}

}
