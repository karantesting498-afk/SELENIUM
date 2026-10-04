package com_grouping;

import org.testng.annotations.Test;

public class Program1 {

	@Test(groups = "Smoke")
	public void smoke1()
	{
		System.out.println("Smoke 1");
	}
	
	@Test(groups = "Smoke")
	public void smoke2()
	{
		System.out.println("Smoke 2");
	}
	
	@Test(groups = "Regression")
	public void regression1()
	{
		System.out.println("Regression 1");
	}
	
	@Test(groups = "Regression")
	public void regression2()
	{
		System.out.println("Regression 2");
	}
	
	@Test(groups = {"Regression", "Smoke"})
	public void edge1()
	{
		System.out.println("Edge_Case 1");
	}
	
	@Test(groups = {"Regression", "Smoke"})
	public void edge2()
	{
		System.out.println("Edge_Case 2");
	}
}
