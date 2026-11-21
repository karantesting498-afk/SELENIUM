package RahulShettyAcademy.date_2026_11_06;

public class Step5_Child3 extends Q5_Step5_Parent{

	int interentRate = 6;
	int principle = 5000;
	int time = 5;
	
	@Override
	public int calculateInterest() {
		// TODO Auto-generated method stub
		return interentRate*principle*time;
	}
//	
//	@Override = error The method calculateInterest(int) of type Step5_Child3 must override or implement a supertype method
//	public int calculateInterest(int time) { 
//		// TODO Auto-generated method stub
//		return interentRate*principle*time;
//	}
	
	public static void main(String[] args) {
		
		Step5Child1 c1 = new Step5Child1();
		
		System.out.println(c1.calculateInterest());
		
		Step5_Child2 c2 = new Step5_Child2();
		
		System.out.println(c2.calculateInterest());
		
		Step5_Child3 c3 = new Step5_Child3();
		
		System.out.println(c3.calculateInterest());
		
		/*
		 * This is override because we are using @Override annotation and
		 * child class are using same method name as parent method name.
		 * Child class provides the body to the method.
		 * 
		 *For override to be successfull , child class method name, paramter name, parameter sequence should be same as parent method.
		 *
		 *
		 */
	}
}
