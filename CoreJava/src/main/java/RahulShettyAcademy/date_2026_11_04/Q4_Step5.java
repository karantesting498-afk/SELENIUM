/*
 * Q4. Reverse a String and Check Palindrome – Hard
Accept a String from the user.

Requirements:
1. Reverse the String without using StringBuilder.reverse().
2. Display the original and reversed String.
3. Check whether the input is a palindrome.
4. Make the palindrome check case-insensitive.
5. Ignore spaces when checking the palindrome.
6. Display whether the input is a palindrome.
Examples:
Input	Expected result
madam	Palindrome
Level	Palindrome
Java	Not palindrome
nurses run	Palindrome
 */
package RahulShettyAcademy.date_2026_11_04;

import java.util.Scanner;

public class Q4_Step5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = new String();
		
		for(int i=s1.length()-1; i>=0; i--)
		{
			System.out.print(s1.charAt(i));
			s2 = s2 +(s1.charAt(i));
		}
		
		System.out.println();
		System.out.println(s1);

		//check palindrone
		if(s1.equals(s2))
		{
			System.out.println("Palindrone");
		}
		
		//Case sensitive
		System.out.println("case sensitive "+s1.equalsIgnoreCase(s2));
		
		//ignore spaces
		System.out.println(s1.strip().replaceAll(" ", "").equalsIgnoreCase(s2.strip().replaceAll(" ", "")));
	}

}
