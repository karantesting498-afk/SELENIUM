package RahulShettyAcademy.date_2026_11_07;

public class Step9_Child1 extends Q9_Step9_Parent{
	
	
	
	public Step9_Child1(String accountNumber, String accountHolderName, double balance) {
		super(accountNumber, accountHolderName, balance);
	}
	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount>0)
		{
			return this.getBalance()+amount;
		}
		else
		{
			return this.getBalance();
		}
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		
		if(amount>100 && amount<this.getBalance())
		
		{
			return this.getBalance() - amount;
		}
		else
		{
			return this.getBalance();
		}
	}
	

}


