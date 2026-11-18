/*
 * Part 2 – Hard Questions
Q3. Prime, Palindrome and Armstrong Number
Write a Java program that accepts an integer and checks:
1. Whether it is a prime number.
2. Whether it is a palindrome number.
3. Whether it is an Armstrong number.
4. Whether it is a perfect number.
Requirements:
- Use separate methods for each validation.
- Use loops and conditional statements.
- Do not use built-in methods to perform these checks.
- Handle zero and negative numbers appropriately.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q4_Step5 {
	
	static int n;
	public void inputNumber(Scanner sc)
	{
		
		n = sc.nextInt();
		
	}
	
	
	//Prime
	
	public void prime()
	{
		if(n<1)
		{
			System.out.println("Number is not prime");
			return;
		}
		else
		{
			for(int i=2; (int)i <= Math.sqrt(n); i++)
			{
				if(n%i==0)
				{
					System.out.println("Number is not prime");
					return;

				}
					
			}
			System.out.println("Number is  prime");

		}

	}

	public void palindrome()
	{
		if(n<1)
		{
			System.out.println("Not palindrome");
			return;
		}
		
		else
		{
			int reversed =0;
			int temp =n;
			int lastDigit =0;
			while(temp>0)
			{
				lastDigit = temp%10;
				reversed = reversed*10 + lastDigit;
				temp = temp/10;
			}
			
			if(reversed == n)
			{
				System.out.println("Number is palindrome");
			}
		}
		

	}
	
	
	
	public void armstrong()
	{
		
		if(n<1)
		{
			System.out.println("Not armstrong");
			return;
		}
		
		int digit =0;
		int temp =n;
		int temp2 =n;

		
		while(temp>0)
		{
			temp = temp/10;
			digit ++;
		}
		
		System.out.println(digit);
		double sum=0;
		
		while(temp2 >=1)
		{
			int remainder = temp2%10;
			
			double power =Math.pow(remainder, digit);
			
			sum+=power;
			
			temp2 /=10;
		}
		
		if(sum==n)
		{
			System.out.println("Number is armstrong");
		}
		else
		{
			System.out.println("Number is not armstrong");
			return;
		}
		
		
	}
	
	public void perfect()
	{
		int sum =0;
		if(n<0)
		{
			System.out.println("Not perfect");
			return;
		}
		for(int i=1; i<n; i++)
		{
			if(n % i==0)
			{
				sum +=i;
			}
		}
		
		if(sum==n)
		{
			System.out.println("Yes a perfect number");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q4_Step5 obj = new Q4_Step5();
		
		obj.inputNumber(sc);
		
		obj.prime();
		obj.palindrome();
		obj.armstrong();
		obj.perfect();
		
	}
	
}
