/*
 * Q3. Reverse an Array Without Using Another Array
Write a Java program to reverse an array without creating another array.

Input:
int[] numbers = {10, 20, 30, 40, 50};


Expected output:
[50, 40, 30, 20, 10]


Conditions:
1. Do not create another array.
2. Do not use Arrays.sort() or any built-in reverse method.
3. Reverse the original array itself.
4. Print the original array after reversal.
 */
package RahulShettyAcademy.date_2026_11_09;

import java.util.Arrays;

public class Q3_Step4 {
	
	public static void main(String[] args) {
		int[] numbers = {10, 20, 30, 40, 50,60};
		
		for(int i = numbers.length-1; i>=0; i--)
		{
			System.out.println(numbers[i]);
		}
		
		
		System.out.println("==========");

		for(int i=0; i<numbers.length/2; i++)
		{
			int temp = numbers[i];
			numbers[i] = numbers[numbers.length-i-1];
			numbers[numbers.length-i-1] = temp;
		}
		
		System.out.println(Arrays.toString(numbers));
	}

	
}
