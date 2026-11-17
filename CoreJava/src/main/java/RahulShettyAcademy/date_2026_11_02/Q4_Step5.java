/*
 * Question 4 – Hard
Hard

Wrapper Classes and Autoboxing/Unboxing

Write a Java program that:
1. Stores five integer values in an ArrayList<Integer>.
2. Adds primitive integer values directly to the collection.
3. Retrieves the values and calculates their sum.
4. Converts a String "250" into an integer.
5. Converts an Integer object back into a primitive int.
6. Demonstrates what happens when an Integer containing null is unboxed.
Expected learning: Wrapper classes, autoboxing, unboxing, parsing and null handling.
 */
package RahulShettyAcademy.date_2026_11_02;

import java.util.ArrayList;
import java.util.List;

public class Q4_Step5 {
	
	
	public static void main(String args[])
	{
		List<Integer> numList = new ArrayList<Integer>();
		String value = "250";
		Integer unbox =null;
		
		numList.add(1);
		numList.add(2);
		numList.add(3);
		numList.add(4);
		numList.add(5);
		
		
		int total = numList.stream().mapToInt(Integer:: intValue).sum();
		System.out.println(total);
		
		Integer converted = Integer.parseInt(value);
		System.out.println(converted);
		
		int newConverted = (int)converted;
		System.out.println(newConverted);
		
		try {
			int x = unbox;// nUll pointer exception
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
