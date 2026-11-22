package RahulShettyAcademy.date_2026_11_07;

public class Step3_Child1 extends Q2_Step3_Parent{

	int monthlySalary;
	int bonus;
	
	
	public Step3_Child1(String employeeName, int employeeId, int monthlySalary, int bonus) {
		super(employeeName, employeeId);
		this.monthlySalary = monthlySalary;
		this.bonus = bonus;
	}


	@Override
	public String displayDetails() {
		// TODO Auto-generated method stub
		 return super.displayDetails()+ ", monthly salary :  "+ monthlySalary + ", bonus :" + bonus + " ]";
	}
	
	@Override
	public void calculateSalary() {
		System.out.println("Calculated salary : "+ (monthlySalary*12 + bonus) );
		
	}
	
}



