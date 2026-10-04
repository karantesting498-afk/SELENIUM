package com_grouping;

import org.testng.annotations.Test;

public class Program2 {
	
	@Test(groups = "Positive")
	public void positive1()
	{
		System.out.println("Positive 1");
	}
	
	@Test(groups = "Positive")
	public void positive2()
	{
		System.out.println("Positive 2");
	}
	
	@Test(groups = "Negative")
	public void negative1()
	{
		System.out.println("Negative 1");
	}
	
	@Test(groups = "Negative")
	public void negative2()
	{
		System.out.println("Negative 2");
	}
	
	@Test(groups = {"Negative", "Positive"})
	public void edge1()
	{
		System.out.println("Edge_Case 1");
	}
	
	@Test(groups = {"Negative", "Positive"})
	public void edge2()
	{
		System.out.println("Edge_Case 2");
	}

}
