/*
 * Q7. String vs StringBuilder Performance – Hard
Write a Java program to compare repeated concatenation using String and StringBuilder.

Requirements:
1. Start with an empty String.
2. Append numbers from 1 to 10,000 using String concatenation.
3. Perform the same operation using StringBuilder.
4. Calculate the execution time of both operations using System.nanoTime().
5. Display both execution times.
6. Verify that both approaches produce identical final content.
Important: Don't assume one execution proves a universal performance result.
 Explain why StringBuilder is generally more efficient for repeated modifications.
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q7_Step8 {
	
	public static void main(String[] args) {
		
		String s = new String();
		StringBuilder sb = new  StringBuilder();
		
		for(int i=0; i<=10000; i++)
		{
			
			s= s.concat(String.valueOf(i));
			sb.append(String.valueOf(i));
		}
		System.out.println(s);
		System.out.println(System.nanoTime());
		System.out.println(sb);
		System.out.println(System.nanoTime());
		
		System.out.println(s.equals(sb.toString()));

	}

}
