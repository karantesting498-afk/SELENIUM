package RahulShettyAcademy.date_2026_11_06;

public class Step1_Child extends Q1_Step1_Parent{
	
	String programmingLanguage;
	
	public Step1_Child(int employeeId, String employeeName, int salary , String programmingLanguage) {
		super(employeeId, employeeName, salary);
		this.programmingLanguage = programmingLanguage;
	}
	
	@Override
	public String displayEmployeeDetails()
	{
		return "Employee Details : [ Employee id : "+ this.employeeId + " , Employee name : " + this.employeeName + " , Programming language : "+this.programmingLanguage +" , monthly Salary : "+ this.salary +", Annual salary : "+ calculateAnnualSalary() +" ]";

	}
	
	public void writeCode()
	{
		System.out.println("Writing code...");
	}
	public static void main(String[] args) {
		Step1_Child obj = new Step1_Child(101, "Karan", 1000, "Java");
	
		System.out.println(obj.displayEmployeeDetails());
		
		System.out.println(obj.calculateAnnualSalary());
		
		obj.writeCode();
		
		
	}
}
