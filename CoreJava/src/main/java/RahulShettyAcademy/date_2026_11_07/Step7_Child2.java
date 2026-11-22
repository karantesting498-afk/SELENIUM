package RahulShettyAcademy.date_2026_11_07;

public class Step7_Child2 extends Q7_Step7_Parent implements Step7_Interface1{

	public Step7_Child2(int employeeId, String employeename) {
		super(employeeId, employeename);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Child 2 run");
		
	}
	
	@Override
	public void generateReport() {
		// TODO Auto-generated method stub
		System.out.println("Tester generate report");
	}
	
	public static void main(String[] args) {
		

		
		Step7_Child2 child2 = new Step7_Child2(101, "Karan");
		child2.login();
		child2.generateReport();

		
		Step7_Child1 child1 = new Step7_Child1(201, "Disha");
		child1.login();
		child1.generateReport();
		child1.approveExpense();
	}
	
	/*
	 * 1. We made employee abstract because each employee must have id, name, can login. 
	 * Employee can be manager or tester. 
	 * some employee can generate report or expense approve and some can do both.
	 * 
	 * Reason: all employees share state (ID, name) and common behaviour (login()), which an abstract class can hold, 
	 * and it should not be instantiated directly because a plain “Employee” is too generic.
	 * 
	 * 2. Because through interface we forces every employee mush generate report, or expense approve and some can do both.
	 * Partial. “Forces every employee to generate report” is wrong. Interfaces are for optional capabilities that only some employees have.
	 *  A class can implement many interfaces but extend only one class, so Manager can combine both capabilities while Tester takes just one. They also have no state.
	 * 
	 * 3. No, it cannot extend 2 abstract classes.
	 * Add the reason: Java does not support multiple inheritance of classes (state and implementation ambiguity).
	 * 
	 * 4. yes class can implement multiple interfaces
	 * 
	 * ✅ Match on “Yes”. It can implement any number, as long as it implements all their abstract methods.
	 */
}
