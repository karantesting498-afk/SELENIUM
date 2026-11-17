/*
 * Q5. Wrapper Classes and Collections
Write a program that:
1. Creates an ArrayList<Integer>.
2. Adds at least eight primitive integer values.
3. Retrieves the values and calculates their sum and average.
4. Finds the maximum and minimum values.
5. Converts "450" into an integer.
6. Converts an Integer object into a primitive int.
7. Demonstrates what happens when a null Integer is unboxed.
8. Handles the exception appropriately.
Expected learning: Wrapper classes, autoboxing, unboxing, parsing and null handling.
 */
package RahulShettyAcademy.date_2026_11_02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q10_Step11 {
	
	public static void main(String[] args) {
		
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(10);
		numList.add(20);
		numList.add(30);
		numList.add(40);
		numList.add(50);
		numList.add(60);
		numList.add(70);
		numList.add(80);
		
		String s = "450";
		Integer b = 10;
		Integer d = null;
		
		System.out.println("Sum :" + numList.stream().mapToInt(Integer::intValue).sum());
		System.out.println("Avg :"+ numList.stream().mapToInt(Integer::intValue).average());
		List<Integer> sortedList = numList.stream().sorted().collect(Collectors.toList());
		System.out.println("Max vlaue :"+ sortedList.get((numList.size())-1));
		System.out.println("min Value :" + sortedList.get(0));
		
		int a = Integer.parseInt(s);
		System.out.println(a);
		int c = b;
	
		try {
			int e = d;// WIll give nullPointerExceptions
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
