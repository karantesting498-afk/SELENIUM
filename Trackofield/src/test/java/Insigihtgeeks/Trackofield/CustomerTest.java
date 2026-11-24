package Insigihtgeeks.Trackofield;

import org.testng.Assert;
import org.testng.annotations.Test;

import trackofield.pom.pages.CustomerPage;
import trackofield.pom.pages.DashboardPage;
import trackofield.pom.pages.LoginPage;
import trackofiled.test_component.BaseTest;

public class CustomerTest extends BaseTest{
	
	String customerName = "Selenium customer" + System.nanoTime();
	String geofenceName = "Selenium customer geofence" + System.nanoTime();

	public CustomerPage openCustomerPage()
	{
		DashboardPage dashboard = loginToApp();
		CustomerPage customer =dashboard.navigateToCustomerPage();
		return customer;
	}

	@Test(groups =  {"Positive"})
	public void CustomerAdd()
	{
		CustomerPage customer =openCustomerPage();
		customer.addCustomer(customerName, geofenceName);
		
		System.out.println(customerName);
		
	}
	
	@Test(groups = {"Positive"}, dependsOnMethods = "CustomerAdd")
	public void checkAddedName()
	{
		CustomerPage customer =openCustomerPage();
		
		String addedCustomerName = customer.checkAddedName();
		System.out.println(addedCustomerName);
		Assert.assertEquals(addedCustomerName, customerName);
	}
}
