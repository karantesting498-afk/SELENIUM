package RahulShettyAcademy.date_2026_11_06;

public class Step10_DashboardPage extends Q10_Step10_BaseClass{

	public void verifyDashboard() {
		System.out.println("Dashboard verified");
	}
	
	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		System.out.println("Open Dashboard Page");
	}
	


	public Step10_DashboardPage(int pageName) {
		super(pageName);
	}
	
	public static void main(String[] args) {
		
		Q10_Step10_BaseClass o1 = new Step10_DashboardPage(10);
		o1.openPage(); // Run time polymorphism
		o1.displayPageName(); // Run time polymorphism
		
		Q10_Step10_BaseClass o2 = new Step10_Login(20);
		o2.openPage(); // Run time polymorphism
		o2.displayPageName(); // Run time polymorphism
		
		
//		o2.login(); It is showing error because reference type is base class. even if refrence holding it is of login page. but reference type is of base class. if we want to access login page, then we will have to type case it into login page like (Step10_Login) new Step10_Login(10);
	
		/*
		 * 8. BasePage holds what every page shares (pageName, openPage(),
   displayPageName()). LoginPage and DashboardPage each extend it, so every web
   page is one class, which is the Page Object Model. Each page overrides
   openPage() and adds only its own actions (login(), verifyDashboard()). Tests
   can use a BasePage reference and call openPage() on any page, and the correct
   page's version runs (runtime polymorphism). In a real framework, BasePage
   would hold the WebDriver, waits and common helpers, so they are written once
   and reused by every page. If the UI changes, only that page class needs
   updating, not every test.
		 */
	}
}

