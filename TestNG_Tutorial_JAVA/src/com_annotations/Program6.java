package com_annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Program6 {
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("I will run before first test");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("I will run after last test");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("I will run before suite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("I will run after suite");
	}
	
	@Test
	public void webLogin()
	{
		System.out.println("Web Login");
	}
	
	
	@Test
	public void androidLogin()
	{
		System.out.println("android Login");
	}
	
	@Test

	public void iosLogin()
	{
		System.out.println("ios");
	}

}
