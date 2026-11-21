package RahulShettyAcademy.date_2026_11_06;

public class Step9_Child2 extends Q9_Step9_Parent{
	String testingTool ;
	
	
	
	public Step9_Child2(int employeeId, String employeeName, int salary, String testingTool) {
		super(employeeId, employeeName, salary);
		this.testingTool = testingTool;
		System.out.println("Child 2 const. ");

		
	}

	public String displayInfo()
	{
		return (super.displayInfo() + "\n testing tool : "+  this.testingTool);

	}

	
	@Override
	public void performWork() {
		// TODO Auto-generated method stub
		System.out.println("Child 2 is performing");
		System.out.println(displayInfo());
	}
	
	public static void main(String[] args) {
		
		Step9_Child2 c2 = new Step9_Child2(101, "Karan", 1000, "Selenium");
		c2.performWork();//compile time
		
		Step9_Child1 c1 = new Step9_Child1(201, "Disha", 2000, "Java");
		c1.performWork();//compile time
		
		Q9_Step9_Parent p2 = new Step9_Child2(301, "Karan", 3000, "Test Ng");
		p2.performWork();// run time polymorphism  //compile time
		
		Q9_Step9_Parent p1 = new Step9_Child1(401, "Disha", 4000, "python");
		p1.performWork();// run time polymorphism//compile time
	}
	
	//Inheritance can reduce duplicate code by creating a common code in parent class and sharing it with all child class.In selnium we can add wait methods, driver initalization in parent class, and share it with all child class
}
