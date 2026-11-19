/*
 * Q2. String Methods and Text Analysis – Medium
Accept a sentence from the user.

Example:
Welcome to Java Programming

Requirements:
1. Display the total number of characters.
2. Convert the sentence to uppercase and lowercase.
3. Remove leading and trailing spaces.
4. Check whether the sentence contains "Java".
5. Check whether it starts with "Welcome".
6. Check whether it ends with "Programming".
7. Find the first occurrence of 'a'.
8. Find the last occurrence of 'a'.
9. Extract "Java" using substring().
10. Check whether the input is empty or blank.
 */
package RahulShettyAcademy.date_2026_11_04;

import java.util.Scanner;

public class Q2_Step3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		
		//Display the total number of characters.
		System.out.println(s1.length());

		
		//Remove leading and trailing spaces.
		s1 =s1.strip();
		System.out.println(s1);
		
		
		//Check whether the sentence contains "Java".
		System.out.println(s1.contains("Java"));
		
		//Check whether it starts with "Welcome".
		
		System.out.println(s1.startsWith("Welcome"));
		
		
		
		//Check whether it ends with "Programming".
		System.out.println(s1.endsWith("Programming"));
		
		//Find the first occurrence of 'a'.
		
		System.out.println(s1.indexOf('a'));
		
		//Find the last occurrence of 'a'.
		
		System.out.println(s1.lastIndexOf('a'));
		
		//Extract "Java" using substring().
		
		int searchStart = s1.indexOf("Java");
		if(searchStart!=-1)
		{
			System.out.println(s1.substring(searchStart, searchStart+4));
		}
		
		
		//Check whether the input is empty or blank.
		System.out.println(s1.isBlank());
		System.out.println(s1.isEmpty());
		
		
		//Convert the sentence to uppercase and lowercase.
		
		s1 = s1.toUpperCase();
		System.out.println(s1);
		
		s1=s1.toLowerCase();
		System.out.println(s1);
	}

}
