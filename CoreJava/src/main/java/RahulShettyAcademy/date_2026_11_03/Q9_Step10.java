/*
 * Q9. Find the First Number Matching Multiple Conditions – Hard
Write a program that accepts a starting number and ending number.

Requirements:
1. Print all numbers divisible by both 3 and 5.
2. Print all numbers divisible by 7 but not by 2.
3. Find the first number divisible by both 3 and 5, then stop using break.
4. Skip numbers divisible by 4 using continue.
5. Count how many numbers satisfy each condition.
6. Handle cases where the starting number is greater than the ending number.
 */
package RahulShettyAcademy.date_2026_11_03;

public class Q9_Step10 {
	
	
	//1. Print all numbers divisible by both 3 and 5.

	public void cal1(int a, int b)
	{

		int count=0;
		for(int i=a; i<=b; i++)
		{
			if(i%3==0 && i%5==0)
			{
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	//2. Print all numbers divisible by 7 but not by 2.
	public void cal2(int a, int b)
	{

		int count=0;
		for(int i=a; i<=b; i++)
		{
			if(i%7==0 && i%2!=0)
			{
				System.out.println(i);
				count++;

			}
		}
		System.out.println(count);

	}
	
	//3. Find the first number divisible by both 3 and 5, then stop using break.


	public void cal3(int a, int b)
	{
		
		for(int i=a; i<=b; i++)
		{
			if(i%3==0 && i%5==0)
			{
				System.out.println(i);
				break;
			}
		}
	}
	
	//Skip numbers divisible by 4 using continue.

	public void cal4(int a, int b)
	{

		int count=0;
		for(int i=a; i<=b; i++)
		{
			if(i%4==0)
			{
				count++;
				continue;

			}
		}
		
		System.out.println(count);

	}

	public static void main(String[] args) {
		
		int a = 1;
		int b =100;
		
		if (a > b)
		{
			System.out.println("Invalid range: start is greater than end");
			return;
		}
		
		
		
		Q9_Step10 obj = new Q9_Step10();
		
		obj.cal1(a, b);
		obj.cal2(a, b);
		obj.cal3(a, b);
		obj.cal4(a, b);
		
	}
}
