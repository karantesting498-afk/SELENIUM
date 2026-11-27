/*
 * Q5. Second Largest Distinct Element
Write a Java program to find the second-largest distinct element in an integer array.

Input:
int[] numbers = {10, 50, 30, 50, 40, 20};


Expected output:
Second largest: 40


Additional test cases to consider:
{10, 10, 10, 10}
{50, 40, 30}
{-10, -20, -5, -30}
{10}


Conditions:
1. Do not sort the array.
2. Do not use another array.
3. Do not assume all values are positive.
4. Handle cases where a second-largest distinct element does not exist.

 */
package RahulShettyAcademy.date_2026_11_09;

public class Q5_Step6 {
	
	public static void main(String[] args) {
		
		int[] numbers = {10, 50, 30, 50, 40, 20,50,50,-10};
		
		int max = numbers[0];
		int secondMax= numbers[0];
		
		for(int n: numbers)
		{
			if(n>max)
			{
				secondMax=max;
				max=n;
				
			}
			
			else if(n>secondMax && n<max)
			{
				secondMax=n;
			}
			
		}
		
		System.out.println(secondMax);
		System.out.println(max);
	}

}
