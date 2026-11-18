/*
 * Q8. Number Pattern and Loop Control – Hard
Write a program that accepts an integer N and prints the following patterns using nested loops.

Pattern A:
1
22
333
4444
55555


Pattern B:
    *
   **
  ***
 ****
*****

Pattern C:
1
23
456
78910

Requirements:
1. Use nested loops.
2. Do not hardcode individual rows.
3. Use appropriate loop conditions.
4. Explain the purpose of the outer and inner loops.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q8_Step9 {
	static int n;
	public void patternA()
	{
		for(int i=1; i<=n; i++)
		{	
			for(int j =0; j<i ; j++)
			{
				System.out.print(i);
			}
		System.out.println();
		}
	}
	
	public void patternB()
	{
		for(int i =0; i<=n; i++)
		{
		
			for(int s=0; s<n-i-1; s++)
			{
				System.out.print(" ");
			}

			for(int j=1; j<=i; j++)
			{
				System.out.print("x");
			}
			System.out.println();
		
		}
	}
	
	public void patternC()
	{
		int count =1;
		for(int i=0; i<n && count<=n; i++)
		{
			for(int j =0; j<i; j++)
			{
				System.out.print(count);
				count++;
			}

			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		if(!sc.hasNextInt())
		{
			System.out.println("Invalid");
		}

			n = sc.nextInt();
			
			Q8_Step9 obj = new Q8_Step9();
			obj.patternA();
			
			obj.patternB();
			
			obj.patternC();
		
}
	
	

}
