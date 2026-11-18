/*
 * Q2. Loops, Number Operations and Patterns
Write a Java program that accepts a number N.

Requirements:
1. Print numbers from 1 to N using a for loop.
2. Print numbers from N to 1 using a while loop.
3. Calculate the sum of numbers from 1 to N.
4. Calculate the factorial of N.
5. Print the multiplication table of N.
6. Count the number of digits in N.
7. Print numbers from 1 to N, skipping multiples of 3 using continue.
8. Stop printing when the number reaches 15 using break.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q3_Step4 {
	
	static int n;
	public void inputNumber(Scanner sc)
	{
		
		n = sc.nextInt();
		
	}
	
	//Print numbers from 1 to N using a for loop
	public void calculate1()
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println(i);
		}
	}
	
	
	//Print numbers from N to 1 using a while loop
	public void calculate2()
	{
		while(n>0)
		{
			System.out.println(n);
			n--;
		}
	}
	
	//Calculate the sum of numbers from 1 to N.
	public void calculate3()
	{
		int sum =0;
		for(int i=1;i<=n;i++)
		{
			System.out.println(i);
			sum +=i;
		}
		System.out.println("sum is :"+sum);

		
	}
	
	//Calculate the factorial of N.
	public void calculate4()
	{
		int factorial =1;
		for(int i=1;i<=n;i++)
		{
			
			factorial *=i;
		}
		System.out.println("factorial is :"+factorial);

		
	}
	
	//Print the multiplication table of N.
	public void calculate5()
	{
		for(int i=1;i<=n;i++)
		{
			
			System.out.println(n +" * "+i +" = "+ n*i );
			System.out.println("-------");
		}

		
	}
	
	//Count the number of digits in N.
	public void calculate6()
	{
		int temp =n;
		int digitCount =0;
		
		while(temp>=1)
		{
			temp /=10;
			digitCount++;
		}

		System.out.println(digitCount);
		
	}
	
	
	//Print numbers from 1 to N, skipping multiples of 3 using continue.
	public void calculate7()
	{
		for(int i=1;i<=n;i++)
		{
			if(i%3==0)
			{
				continue;
			}
			System.out.println(i);

		}
	}
	
	//1. Stop printing when the number reaches 15 using break.
	public void calculate8()
	{
		for(int i=1;i<=n;i++)
		{
			if(i ==  15)
			{
				break;
			}
			System.out.println(i);

		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Q3_Step4 obj = new Q3_Step4();
		
		obj.inputNumber(sc);
		obj.calculate1();
		obj.calculate2();
		obj.calculate3();
		obj.calculate4();
		obj.calculate5();
		obj.calculate6();
		obj.calculate7();
		obj.calculate8();
		
		
	
		
		
		
}
	


}
