package com_annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Program7 {
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I will run before every methods");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("I will run after every methods");
	}
	
	@Test
	public void webLogout()
	{
		System.out.println("WebLogout");
	}
	
	
	@Test
	public void androidLogout()
	{
		System.out.println("androidLogout");
	}
	
	
	@Test
	public void iosLogout()
	{
		System.out.println("iosLogout");
	}

}
