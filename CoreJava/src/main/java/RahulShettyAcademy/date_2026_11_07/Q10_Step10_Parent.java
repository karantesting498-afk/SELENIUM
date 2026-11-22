/*
 * Q10. Selenium Framework – Encapsulation and Abstraction Design
(Advanced) Selenium-Oriented OOP, POM Design

You are designing a basic Selenium framework.

Create the following structure using Core Java concepts. You do not need actual Selenium libraries.

Abstract class: BasePage
- Private variable: pageName.
- Parameterized constructor.
- Public getter for pageName.
- Abstract method: loadPage().
- Concrete method: displayPageName().
Interface: Searchable

- Abstract method: search(String keyword).

Interface: Navigable

- Abstract method: navigateTo(String url).

Child classes:

LoginPage
- Extends BasePage.
- Implements Navigable.
- Implements loadPage() and navigateTo().
ProductPage
- Extends BasePage.
- Implements Searchable and Navigable.
- Implements all required methods.
Requirements:
1. Use encapsulation for pageName.
2. Use abstraction through BasePage.
3. Use interfaces for page capabilities.
4. Demonstrate multiple interface implementation.
5. Create objects of both pages.
6. Demonstrate upcasting using a BasePage reference.
7. Explain why the parent reference cannot directly call search().
8. Explain how this design makes a framework easier to extend.
Do not use WebDriver, By, or Selenium libraries. This question tests your Core Java OOP understanding.
 */
package RahulShettyAcademy.date_2026_11_07;

public abstract class Q10_Step10_Parent {

	private String pageName;

	public Q10_Step10_Parent(String pageName) {
		super();
		this.pageName = pageName;
	}

	public String getPageName() {
		return pageName;
	}
	
	
	public abstract void loadPage();
	
	public void displayPageName()
	{
		System.out.println(this.getPageName());
	}
}


