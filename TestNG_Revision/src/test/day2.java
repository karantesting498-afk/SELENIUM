package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = {"Smoke"})
public class day2 {
	
	@Test
	public void pLoan()
	{
		System.out.println("Personal Loan");
		System.out.println("Whole class smoke");
	}
	
	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("I will be printed before suite");
	}
	
	@AfterSuite
	public void suiteSetup2()
	{
		System.out.println("I will be printed after suite");
	}

}
