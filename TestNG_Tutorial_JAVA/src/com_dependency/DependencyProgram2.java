package com_dependency;

import org.testng.annotations.Test;

public class DependencyProgram2 {
	
	@Test(groups = "Positive", enabled = true)
	public void login()
	{
		System.out.println("Web Login");
	}
	
	@Test(groups = "Negative",dependsOnMethods = "login")
	public void homePage()
	{
		System.out.println("HomePage");
//		Assert.assertTrue(false);
	}
	
	@Test(dependsOnGroups = "Positive")
	public void logout()
	{
		System.out.println("Logout");
	}

}
