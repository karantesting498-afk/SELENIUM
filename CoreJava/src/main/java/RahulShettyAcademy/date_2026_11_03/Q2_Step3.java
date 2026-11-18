/*
 * Q1. Number Classification Using Conditions and Switch
Write a Java program that accepts an integer from the user.

Requirements:
1. Check whether the number is positive, negative or zero using if-else.
2. Check whether it is even or odd.
3. Use a traditional switch to display the corresponding day of the week based on a number from 1 to 7.
4. Display an invalid message for values outside 1–7.
5. Rewrite the switch using modern switch expression syntax.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q2_Step3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		if(number>0)
		{
			System.out.println("Number is positive and non zero");
		}
		else if (number<0) {
			System.out.println("number is negative and non zero");
			
		}
		else
		{
			System.out.println("Number is zero");
		}
		
		if(number%2==0)
		{
			System.out.println("number is even");
		}
		else
		{
			System.out.println("number is odd");
		}
		
		String week= switch(number)
		{
		 
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "Wednesday";
		case 4 -> "Thursday";
		case 5 -> "Friday";
		case 6 -> "Saturday";
		case 7 -> "Sunday";
		
		default -> "Number out of week range";
		};
				System.out.println(week);
				
				
			switch(number)
			{
			case 1 :
				System.out.println("Monday");
				break;
			
			case 2:
				System.out.println("Tuesday");
				break;
				
			case 3:
				System.out.println("Wednesday");
				break;
				
			case 4:
				System.out.println("Thursday");
				break;
				
			case 5:
				System.out.println("Friday");
				break;
				
			case 6:
				System.out.println("Saturday");
				break;
				
			case 7:
				System.out.println("Sunday");
				break;
				
			default:
				System.out.println("Invalid day");
				break;
			};
				
	}

}
