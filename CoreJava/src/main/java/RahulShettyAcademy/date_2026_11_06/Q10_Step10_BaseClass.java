/*
 * Q10. Selenium-Oriented Inheritance and Polymorphism
Advanced
Create a simplified Selenium framework design using Core Java only.

Create the following classes:

BasePage
- Variable: pageName
- Method: openPage()
- Method: displayPageName()
LoginPage extends BasePage
- Override openPage()
- Add method login()
DashboardPage extends BasePage
- Override openPage()
- Add method verifyDashboard()
Requirements:
1. Create a constructor in BasePage.
2. Initialize pageName through the constructor.
3. Use super() in child constructors.
4. Override openPage() in both child classes.
5. Use a BasePage reference to refer to LoginPage and DashboardPage objects.
6. Demonstrate runtime polymorphism.
7. Try calling login() through a BasePage reference and explain the result.
8. Explain how this structure relates to Selenium Page Object Model and reusable framework design.

 */
package RahulShettyAcademy.date_2026_11_06;

public class Q10_Step10_BaseClass {
	int pageName;
	
	
	
	public Q10_Step10_BaseClass(int pageName) {
		this.pageName = pageName;
	}

	public void openPage() {
		System.out.println("Open Page");
		
	}
	
	public void displayPageName() {
		System.out.println("Page Name is :" + this.pageName);
	}

}


