package RahulShettyAcademy.date_2026_11_07;

public class Step3_Child2 extends Q2_Step3_Parent{

	int hoursWorked;
	int hourlyRate;
	
	
	public Step3_Child2(String employeeName, int employeeId, int hoursWorked, int hourlyRate) {
		super(employeeName, employeeId);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public String displayDetails() {
		// TODO Auto-generated method stub
		 return super.displayDetails()+ ", hours Worked :  "+ hoursWorked + ", hourly Rate :" + hourlyRate + " ]";
	}
	
	@Override
	public void calculateSalary() {
		System.out.println("Salary is :"+ (hourlyRate*hoursWorked));
		
	}
	
	public static void main(String[] args) {
		
		Step3_Child1 o1 = new Step3_Child1("Karan", 1, 1000, 200);
		System.out.println(o1.displayDetails());
		
		Step3_Child2 o2 = new Step3_Child2("Disha", 2, 10, 50);
		System.out.println(o2.displayDetails());
		
		
	}
	
}
