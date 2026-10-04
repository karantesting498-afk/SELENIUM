package com_paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Progam1 {
	
	@Parameters({"url","browser"})
	@Test
	public void WhichBrowser(String url , String browser)
	{
		System.out.println("Url is : " + url);
		System.out.println("Browser  is : " + browser);
	}
	
	@Parameters({"userName", "password"})
	@Test
	public void login(String userName , String password)
	{
		System.out.println("userName is : " + userName);
		System.out.println("password  is  : " + password);

	}
	
	
}
