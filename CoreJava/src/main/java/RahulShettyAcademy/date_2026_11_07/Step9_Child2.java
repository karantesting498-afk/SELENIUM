package RahulShettyAcademy.date_2026_11_07;

public class Step9_Child2 extends Q9_Step9_Parent{

	public Step9_Child2(String accountNumber, String accountHolderName, double balance) {
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
		
		if(this.getBalance()-amount >-10000)
		{
			return this.getBalance()-amount;
		}
		else
		{
			System.out.println("you can only withdraw 10000");
			return this.getBalance();
		}
	}
	
	public static void main(String[] args) {
		
		Step9_Child1 o1 = new Step9_Child1("1223334444", "Karan", 20000);
		System.out.println(o1.deposit(1000));
		
		System.out.println(o1.withdraw(1000));
		
		System.out.println(o1.getBalance());
		
		Step9_Child2 o2 = new Step9_Child2("9988776655", "Disha", 1100);
		System.out.println(o2.deposit(100000));
		System.out.println(o2.withdraw(1000000));
		System.out.println(o2.getBalance());
		
		Q9_Step9_Parent p1 =  new Step9_Child1("1223334444", "Karan", 20000);
		System.out.println(p1.deposit(1000));
		System.out.println(p1.withdraw(20000));
		System.out.println(p1.getBalance());
		
		Q9_Step9_Parent p2 =  new Step9_Child2("9988776655", "Disha", 1100);
		System.out.println(p2.deposit(1000));
		System.out.println(p2.withdraw(20000));
		System.out.println(p2.getBalance());
		
	}
}
