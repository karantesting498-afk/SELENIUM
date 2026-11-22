package RahulShettyAcademy.date_2026_11_07;

public class Step10_Child2 extends Q10_Step10_Parent  implements Step10_Interface2, Step10_Interface{

	public Step10_Child2(String pageName) {
		super(pageName);
	}

	@Override
	public void loadPage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void navigateTo(String url) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void search(String keyword) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Step10_Child1 child1 = new Step10_Child1("Login");
		Step10_Child2 child2 = new Step10_Child2("Dashboard");
		
		
		Q10_Step10_Parent p1 =  new Step10_Child1("Login");
		Q10_Step10_Parent p2 =new Step10_Child2("Dashboard");
		
		
//		p1.search("log");// Does not work because parent class does not have any search method
		
		/*
		 * THis design helps in selenium as we can write navigate , search code in an interface.
		 * Child class which requrire navigate or search can directly access this by simply implementing the methods and do code reusability.
		 * 
		 * 
		 */
		
	}
}
