package com_data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program1 {
	
	@DataProvider(name = "loginData")
	public Object[][] provideLoginData()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0] = "username1";
		obj[0][1]= "password1";
		
		obj[1][0] = "username2";
		obj[1][1] = "password2";
		
		obj[2][0] = "username3";
		obj[2][1] = "password3";
		
		return obj;
	}
	
	@Test(dataProvider = "loginData")
	public void login(String userName , String password)
	{
		System.out.println("User name = : "+ userName);
		System.out.println("User password = : "+ password);
		
		System.out.println("=======");

	}

}
