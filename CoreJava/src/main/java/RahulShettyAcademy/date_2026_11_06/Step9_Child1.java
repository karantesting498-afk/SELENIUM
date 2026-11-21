package RahulShettyAcademy.date_2026_11_06;

public class Step9_Child1 extends Q9_Step9_Parent{

	String programmingLanguage;
	
	
	
	public Step9_Child1(int employeeId, String employeeName, int salary, String programmingLanguage) {
		super(employeeId, employeeName, salary);
		this.programmingLanguage = programmingLanguage;
		System.out.println("Child 1 const.");
	}

	public String displayInfo()
	{
		return (super.displayInfo() + "\nProgramming language : "+  this.programmingLanguage);

	}
	@Override
	public void performWork() {
		System.out.println("Child 1 is performing");
		System.out.println(displayInfo());
	}
}




