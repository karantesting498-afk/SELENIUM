package RahulShettyAcademy.date_2026_11_07;

public class Step7_Child1 extends Q7_Step7_Parent implements Step7_Interface1, Step7_Interface2{

	public Step7_Child1(int employeeId, String employeename) {
		super(employeeId, employeename);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void generateReport() {
		// TODO Auto-generated method stub
		System.out.println("Manager generate report");
	}
	@Override
	public void approveExpense() {
		// TODO Auto-generated method stub
		System.out.println("Manager approve expense");
		
	}
}


