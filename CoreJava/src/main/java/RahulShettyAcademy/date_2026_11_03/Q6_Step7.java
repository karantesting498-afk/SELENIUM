/*
 * Q6. Electricity Bill Calculator – Medium
Write a Java program that accepts electricity units consumed and calculates the bill using these slabs:
Units	Rate
0–100	₹2 per unit
101–200	₹3 per unit
201–300	₹5 per unit
Above 300	₹7 per unit

Requirements:
1. Accept consumed units from the user.
2. Calculate the bill using an if-else ladder.
3. Apply slab-wise calculation, not a single rate to all units.
4. Add a fixed meter charge of ₹50.
5. Reject negative units.
6. Display the final bill.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q6_Step7 {
	int unit;
	static int meterPrice =50;
	
	public void inputUnit(Scanner sc)
	{
		System.out.println("Enter unit consumed");
		unit = sc.nextInt();
		
		if(unit<0)
		{
			System.out.println("rejected");
			return;
		}
		System.out.println("Final Bill is : "+ (slab()+ meterPrice));
	}
	
	
	public int slab()
	{
		if(unit >0 && unit<=100)
		{
			return 2*unit;
		}
		else if(unit>=101 && unit <=200)
		{
			return (unit-100)*3 + 100*2;
		}
		else if(unit >=201 && unit <=300)
		{
			return (unit-200)*5 + 100*3 + 100*2;
		}
		
		else if(unit >300)
		{
			return (unit-300)*7 + 100*3 + 100*5 + 100*2;
		}


		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q6_Step7 obj = new Q6_Step7();
		
		obj.inputUnit(sc);
	}

}
