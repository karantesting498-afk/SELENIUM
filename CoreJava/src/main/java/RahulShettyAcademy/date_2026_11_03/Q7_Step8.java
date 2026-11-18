/*
 * Q7. Menu-Driven Calculator – Medium
Create a calculator using a traditional switch statement.

Requirements:
1. Accept two numbers.
2. Display operations: Addition, Subtraction, Multiplication, Division and Modulus.
3. Accept the user's choice.
4. Perform the selected operation using switch.
5. Handle division and modulus by zero.
6. Display an invalid-choice message for unsupported options.
7. Repeat the calculator until the user chooses Exit.
Use a loop along with switch.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q7_Step8 {

	public int add(int a, int b) {
		return (a + b);
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {
		return a * b;
	}

	public int div(int a, int b) {
		return (a / b);
	}

	public int mod(int a, int b) {
		return a % b;
	}

	public void calculate(int ch, int a, int b) {
		
		int result = switch (ch) {

		case 1 -> add(a, b);
		case 2 -> sub(a, b);
		case 3 -> mul(a, b);
		case 4 -> div(a, b);
		case 5 -> mod(a, b);

		default -> 0;
		};

		
			System.out.println(result);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q7_Step8 obj = new Q7_Step8();
		
		if (!sc.hasNextInt()) {
			System.out.println("Invalid input");
			return;
		}
		
		
		int a = sc.nextInt();
		int b = sc.nextInt();


		
		char ch2;
		do
		{
			
			System.out.println("1. Addition \n 2.Subtraction \n 3. Multiply \n 4. Division \n 5. Modulus");
			System.out.println("Input Choice");
			
			
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input");
				return;
			}
			System.out.println("Enter choice");
			int ch = sc.nextInt();

			if(a!=0 && b!=0)
			{
				obj.calculate(ch, a, b);
		
			}
			else
			{
				System.out.println("Incorret values");
			}
			System.out.println("DO you wish to continue? Y/N");
			ch2 = sc.next().charAt(0);
		}while(ch2=='Y' || ch2 =='y');

	}

}
