/*
 * Q10. Integrated Java Fundamentals Challenge
Create a Java program that processes five student marks.

Requirements:
1. Store five marks in an ArrayList<Integer>.
2. Calculate total and average.
3. Find the highest and lowest marks.
4. Check whether all marks are within the valid range of 0–100.
5. Count how many students passed (marks greater than or equal to 40).
6. Check whether at least three students passed.
7. Convert the average into a double and display it with decimal precision.
8. Use a bitwise operator to determine whether the total marks are even or odd.
9. Demonstrate autoboxing and unboxing in your implementation.
Expected learning: Applying multiple Day 1 concepts in one program.
 */
package RahulShettyAcademy.date_2026_11_02;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Q15_Step16 {

	public static void main(String[] args) {
		
		List<Integer> marks = new ArrayList<Integer>();

		marks.add(10);
		marks.add(20);
		marks.add(32);
		marks.add(21);
		marks.add(99);
		
		System.out.println("Sum is :"+ marks.stream().mapToInt(Integer::intValue).sum());
		System.out.println("Avg is :"+ marks.stream().mapToInt(Integer::intValue).average());
		
		List<Integer> sortedMarks = marks.stream().sorted().collect(Collectors.toList());
		System.out.println("Max is :"+sortedMarks.get((marks.size())-1));
		System.out.println("Miniumm =:"+ sortedMarks.get(0));
		
		boolean range= sortedMarks.stream().allMatch(s->(s>=0)&& s<=100);
		if(range)
		{
			System.out.println("Yes all in 0-100 range");
		}
		long count =sortedMarks.stream().filter(s->s>=40).count();
		
		System.out.println("Students with marks greater than 40 :"+ count);
		
		if(count>=3)
		{
			System.out.println("Yes atleast 3 student passed ");
		}
		
		double avg = sortedMarks.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(avg);
		
		int sum = sortedMarks.stream().mapToInt(Integer::intValue).sum();
		
		String result = (sum%2==0)?"Even": "Odd";
		System.out.println(result);
	}
}
