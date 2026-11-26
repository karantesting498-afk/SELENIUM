/*
 * Q7. Pass an Array to a Method and Modify It
Create a class named ArrayOperations.

Requirements:
1. Create an integer array in the main() method.
2. Pass the array to a method called updateArray().
3. Inside updateArray(), multiply every element by 2.
4. Return the modified array from the method.
5. Print the array before and after calling the method.
6. Explain why the original array gets modified.
Example input:
int[] numbers = {5, 10, 15, 20};


Expected output:
Before: [5, 10, 15, 20]
After:  [10, 20, 30, 40]
 */
package RahulShettyAcademy.date_2026_11_09;

import java.util.Arrays;

public class Q7_Step8 {
	
	public int[] updateArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = arr[i]*2;
			
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {5, 10, 15, 20};

		Q7_Step8 obj = new Q7_Step8();
		
		System.out.println(Arrays.toString(numbers));
		int[] updated= obj.updateArray(numbers);
		System.out.println(Arrays.toString(updated));
		
		
	}
	
	// Original array numbers is modified is because we are passing the reference of that array to update method and that methodis modifying the original array and return it.

}
