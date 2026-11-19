/*
 * Q5. Character and Word Analysis – Hard
Accept a sentence from the user.

Example:
Java is easy and Java is powerful

Requirements:
1. Count the total characters.
2. Count the number of spaces.
3. Count vowels.
4. Count consonants.
5. Count digits.
6. Count special characters.
7. Count the number of words.
8. Display the first and last character.
9. Convert the sentence into uppercase.
10. Explain how charAt() helps process each character.
For this question, use loops and String methods. Don't use regular expressions or collections.
 */
package RahulShettyAcademy.date_2026_11_04;

import java.util.Scanner;

public class Q5_Step6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int spaceCount = 0;
		int vowelCount = 0;
		int consonantCount = 0;
		int digitCount = 0;
		int specialCharCount = 0;

		String s1 = sc.nextLine();

		System.out.println("1. Count the total characters. \n");
		System.out.println(s1.replaceAll(" ", "").length());

		//

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ' ') {
				spaceCount++;
			}

			if (s1.charAt(i) == 'A' || s1.charAt(i) == 'a' || s1.charAt(i) == 'E' || s1.charAt(i) == 'e'
					|| s1.charAt(i) == 'I' || s1.charAt(i) == 'i' || s1.charAt(i) == 'O' || s1.charAt(i) == 'o'
					|| s1.charAt(i) == 'U' || s1.charAt(i) == 'u') {
				vowelCount++;

			}

			char ch = s1.charAt(i);

			if (ch != 'A' && ch != 'a' && ch != 'E' && ch != 'e'
					&& ch != 'I' && ch != 'i' && ch != 'O' && ch != 'o'
							&& ch != 'U' && ch != 'u' && !Character.isWhitespace(ch) && !Character.isDigit(ch) && Character.isAlphabetic(ch)) {
				consonantCount++;
			}

			if (s1.charAt(i) >= 0 && s1.charAt(i) <= 9) {
				digitCount++;
			}

			if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
				specialCharCount++;
			}

		}

		System.out.println("2. Count the number of spaces.");
		System.out.println(spaceCount);
		System.out.println("3. Count vowels.");
		System.out.println(vowelCount);

		System.out.println("4. Count consonants..");
		System.out.println(consonantCount);
		System.out.println("5. Count digits.");
		System.out.println(digitCount);

		System.out.println("6. Count special characters.");
		System.out.println(specialCharCount);

		System.out.println("7. Count the number of words.");

		System.out.println(s1.strip().split(" ").length);

		System.out.println("8. Display the first and last character.");
		System.out.println(s1.charAt(0));
		System.out.println(s1.charAt(s1.length() - 1));

		// Convert the sentence into uppercase.
		s1 = s1.toUpperCase();
		System.out.println(s1);
	}

}
