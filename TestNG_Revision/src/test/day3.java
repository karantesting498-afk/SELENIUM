package test;

import org.testng.annotations.Test;

@Test(groups = {"Smoke"})
public class day3 {
	
	@Test(groups = {"Smoke"})
	public void webLoginCarLoan()
	{
		System.out.println("Web Car Login");
		System.out.println("Combination of class and method smoke");
	}
	
	
	@Test(groups = {"regression"})
	public void mobileLoginCarLoan()
	{
		System.out.println("Mobile  Car Login");
		System.out.println("regression");
	}
	
	@Test
	public void loginAPICarLoan()
	{
		System.out.println("API Car Login");
		System.out.println("No grouped");
	}

}
