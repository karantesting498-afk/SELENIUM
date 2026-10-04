package com_annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Program8 {

	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@Test
	public void signUP()
	{
		System.out.println("Sign in success");
	}
	
	
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("after Class");
	}
}
