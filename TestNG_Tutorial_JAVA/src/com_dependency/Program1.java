package com_dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Program1 {
	
	@Test
	public void login()
	{
		System.out.println("Web Login");
	}
	
	@Test(dependsOnMethods = "login")
	public void homePage()
	{
		System.out.println("HomePage");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "homePage")
	public void logout()
	{
		System.out.println("Logout");
	}

}
