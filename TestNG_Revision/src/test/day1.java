package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {

	@Test(groups = {"Smoke"})
	public void demo()
	{		System.out.println("Hello");
	
		System.out.println("Smoke test case");
	
	}
	
	@Test
	public void secondTest()
	{
		System.out.println("Bye");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		System.out.println("Before  method");
		System.out.println("==============================================");
	}
	
	
	@BeforeTest
	public void setup2()
	{
		System.out.println("Before test method");
		System.out.println("==============================================");
	}
	
	
	@AfterTest
	public void setup3()
	{
		System.out.println("After test method");
		System.out.println("==============================================");
	}
}
