/*
 * Q5. Method Overriding
Hard
Create a parent class Bank with a method:
void calculateInterest()


Create three child classes:
- SBI
- HDFC
- ICICI
Requirements:
1. Override calculateInterest() in all three child classes.
2. Display a different interest rate for each bank.
3. Use the @Override annotation.
4. Create objects of all three child classes.
5. Call their overridden methods.
6. Explain why this is method overriding rather than method overloading.
7. Demonstrate what happens if the child method has a different parameter list.
For this exercise, use illustrative interest rates of your choice.
 */
package RahulShettyAcademy.date_2026_11_06;

public class Q5_Step5_Parent {
	
	int interentRate = 10;
	int principle = 5000;
	int time = 5;
	
	public int calculateInterest()
	{
		return interentRate*principle*time;
	}

}


