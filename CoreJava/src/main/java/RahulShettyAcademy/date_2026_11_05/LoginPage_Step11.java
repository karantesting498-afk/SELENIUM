/*
 * Q10. Real-World Selenium Page Object Design
Advanced
Create a simplified Java class representing a Login Page using only the Core Java concepts covered in Day 4.

Class name: LoginPage
Variables
- browserName – static variable.
- pageName – instance variable.
- usernameField – private instance variable.
- passwordField – private instance variable.
- loginButton – private instance variable.
Requirements
1. Create a parameterized constructor to initialize all instance variables.
2. Create getter methods for private variables.
3. Create a method displayPageDetails().
4. Create a static method changeBrowserName().
5. Create two LoginPage objects representing different pages.
6. Change the browser name and verify that both objects display the updated value.
7. Explain how this design relates to Selenium Page Object Model.
8. Explain why private variables and public methods are useful in POM.
Note: Do not use Selenium WebDriver or locators in this question. This is a Core Java exercise.
 */
package RahulShettyAcademy.date_2026_11_05;

public class LoginPage_Step11 {
	
	static String browserName = "Chrome";
	String pageName;
	private int usernameField;
	private int passwordField;
	private String loginButton;
	
	public LoginPage_Step11(String pageName, int usernameField, int passwordField, String loginButton) {
		this.pageName = pageName;
		this.usernameField = usernameField;
		this.passwordField = passwordField;
		this.loginButton = loginButton;
	}

	public int getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(int usernameField) {
		this.usernameField = usernameField;
	}

	public int getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(int passwordField) {
		this.passwordField = passwordField;
	}

	public String getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(String loginButton) {
		this.loginButton = loginButton;
	}
	
	
	public  void displayPageDetails()
	{
		System.out.println(pageName);
	}
	
	public static void changeBrowserName()
	{
		browserName = "Edge";
	}
	
	
	
	@Override
	public String toString() {
		return "LoginPage_Step11 [pageName=" + pageName + ", usernameField=" + usernameField + ", passwordField="
				+ passwordField + ", loginButton=" + loginButton +", browserName=" + browserName + "]";
	}

	public static void main(String[] args) {
		
		LoginPage_Step11 obj1 = new LoginPage_Step11("Dashboard", 123, 456, "LoginButton 1");
		LoginPage_Step11 obj2 = new LoginPage_Step11("Analytical dashboard", 678, 890, "LoginButton 2");
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		changeBrowserName();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
		/*
		 * 7. In the Page Object Model, each web page is one class. LoginPage is that
   class: its fields stand for the page's elements (username field, password
   field, login button) and its methods for what a user can do on the page. In
   real Selenium the fields would be locators or WebElements and the methods
   would be actions like enterUsername() and clickLogin(). Each object represents
   one page. The static browserName is shared by all page objects, like one
   browser session used by every page in a test run, so changing it once
   updates all of them.


8. Private variables hide the page's internal details (locators, elements), so
   tests cannot depend on them or change them by accident. Tests call public
   methods such as login(user, pass) instead. If the UI changes, only the page
   class needs updating, not every test. This reduces duplication, makes tests
   easier to maintain, and keeps test logic separate from page details.
		 */
		

	}

}
