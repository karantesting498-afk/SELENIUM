/*
 * Q1. Array Basics and Operations
Create a Java program that performs the following operations on an integer array:
int[] numbers = {15, 25, 10, 40, 30, 20};


Requirements:
1. Print all elements using a normal for loop.
2. Print all elements using an enhanced for loop.
3. Calculate the sum of all elements.
4. Calculate the average.
5. Find the maximum value.
6. Find the minimum value.
7. Count the even and odd numbers.
8. Update the element at index 2 to 100.
9. Print the updated array.
Expected output: Your program should display all requested results clearly.
 */
package RahulShettyAcademy.date_2026_11_09;

import java.util.Arrays;

public class Q1_Step2 {

	public static void main(String[] args) {
		int sum=0;
		double avg =0;
		int[] numbers = {15, 25, 10, 40, 30, 20};
		
		// 1. Print all elements using a normal for loop.
		for(int i=0; i<numbers.length; i++)
		{
			System.out.println(numbers[i]);
		}
		
		// 2. Print all elements using an enhanced for loop.
		for(int n: numbers)
		{
			System.out.println(n);
		}
		
		// 3. Calculate the sum of all elements.
		for(int n: numbers)
		{
			sum +=n;
		}
		System.out.println(sum);
	
		// 4. Calculate the average.
		avg = (double) sum/numbers.length;
		System.out.println(avg);
		
		// 5. Find the maximum value.
		int max = numbers[0];
		for(int n : numbers)
		{
			if(n>max)
			{
				max=n;
			}
		}
		System.out.println(max);
		
		// 6. Find the minimum value.
		
		int min = numbers[0];
		for(int n: numbers)
		{
			if(n<min)
			{
				min =n;
			}
		}
		System.out.println(min);

		
			// 7. Count the even and odd numbers.}
		int oddCount =0;
		int evenCount=0;
		
		for(int n: numbers)
		{
			if(n%2==0)
			{
				evenCount++;
			}
			else
			{
				oddCount++;
			}
		}
		
		System.out.println(evenCount);
		System.out.println(oddCount);
		
		// 8. Update the element at index 2 to 100.
		
		numbers[2]=100;
		System.out.println(numbers[2]);
		
		// 9. Print the updated array.
		System.out.println(Arrays.toString(numbers));
		
	
		
	}
	
}
