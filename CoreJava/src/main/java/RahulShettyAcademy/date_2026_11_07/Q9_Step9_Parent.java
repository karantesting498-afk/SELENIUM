/*
 * Q9. Encapsulation + Abstraction – Banking System
(Advanced) Complete OOP Design

Design a simple banking system.

Abstract class: BankAccount

Private variables:
- accountNumber
- accountHolderName
- balance
Requirements:
1. Create a parameterized constructor.
2. Provide getters where appropriate.
3. Do not provide a direct setter for balance.
4. Create a concrete method deposit(double amount).
5. Create an abstract method withdraw(double amount).
6. Create a concrete method displayBalance().
Child classes:

SavingsAccount
- Withdrawal should be allowed only when sufficient balance exists.
- Minimum withdrawal amount should be ₹100.
CurrentAccount

- Withdrawal should be allowed even if the balance becomes negative, but the overdraft limit is ₹10,000.

Additional requirements:
1. Validate deposit amount.
2. Prevent invalid withdrawal.
3. Do not allow external classes to modify balance directly.
4. Create one object of each child class.
5. Perform deposit and withdrawal operations.
6. Display updated balances.
7. Demonstrate that a parent reference can refer to either account type.
Use only concepts covered up to Day 6.
 */
package RahulShettyAcademy.date_2026_11_07;

public abstract class Q9_Step9_Parent {
	
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	
	public Q9_Step9_Parent(String accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public double getBalance() {
		return balance;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	
	public double deposit(double amount)
	{
		return balance+ amount;
	}
	
	public abstract double  withdraw(double amount);
	
	
	public void displayBalance()
	{
		System.out.println(balance);
	}
	
}


