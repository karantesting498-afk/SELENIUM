/*
 * Question 2 – Medium
Medium

Operators and Conditional Logic

Write a program that accepts three integer values and:
1. Finds the largest number using relational and logical operators.
2. Checks whether all three numbers are equal.
3. Checks whether at least two numbers are positive.
4. Uses the ternary operator to identify whether the largest number is even or odd.
Expected learning: Relational operators, logical operators, nested conditions and ternary operator.
 */
package RahulShettyAcademy.date_2026_11_02;

import java.util.ArrayList;
import java.util.List;

public class Q2_Step3 {
	
	int posCount;
	public void checkPostive(int num)
	{
		if(num>0)
		{
			posCount++;
		}
	}
	
	public static void main(String[] args) {
		
		Q2_Step3 obj = new Q2_Step3();
		int a =10;
		int b=20;
		int c=30;
		
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(a);
		numList.add(b);
		numList.add(c);
		
		int largest = (a>b && a>c)? a: (b>a && b>c)? b :(c>a && c>b)? c:0;
		
		System.out.println(largest);
		
		if(a==b && b==c)
		{
			System.out.println("ALL are equal");
		}
		
		for(int i=0; i<numList.size(); i++)
		{
			obj.checkPostive(numList.get(i));
		}
		
		if(obj.posCount>=2)
		{
			System.out.println("Atleast 2 are positive");
		}
		
		String evenOdd= (largest%2==0)? "even": "odd";
		
		System.out.println("Largest number is :"+evenOdd);
		
	}

}
