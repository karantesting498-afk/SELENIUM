package RahulShettyAcademy.date_2026_11_06;

public class Step7_Child extends Q7_Step7_Parent{

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}
	
	@Override
	public int calculate(int a, int b, int c) {
		// TODO Auto-generated method stub
		return a*b*c;
	}
	
	public double calculate(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}
	
	public static void main(String[] args) {
		
		Step7_Child obj = new Step7_Child();
		
		System.out.println(obj.calculate(5, 10)); // Resolved at compile time && Resolved at dispatched time
		System.out.println(obj.calculate(2, 2, 2));// Resolved at compile time & Resolved at dispatched time
		System.out.println(obj.calculate(2.2, 3.3));// Resolved at compile time
		
		Q7_Step7_Parent obj2 = new Step7_Child();
		
		System.out.println(obj2.calculate(2,3));// Resolved at dispatched time &&  Resolved at compile time
		System.out.println(obj2.calculate(3, 3, 3));// Resolved at dispatched time && Resolved at compile time
		
		
		/*
		 * Changing only return type will not make method overload.
		 * To make method overload we need to make make sure
		 * 1. method name is same.
		 * 2. Different parameters types used. e.g(int int) , (double, double)
		 * 3. Different sequence of parameters.e.g (int , double), (double, int)
		 * 4. Different quantitiy of parameters e.g (int,int), (int, int, int)
		 */
		
	}
	
	
}
