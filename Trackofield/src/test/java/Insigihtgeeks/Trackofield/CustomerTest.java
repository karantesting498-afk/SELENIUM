package Insigihtgeeks.Trackofield;

import org.testng.Assert;
import org.testng.annotations.Test;

import trackofield.pom.pages.CustomerPage;
import trackofield.pom.pages.DashboardPage;
import trackofiled.test_component.BaseTest;

public class CustomerTest extends BaseTest {

	String customerName = "Selenium customer" + System.nanoTime();
	String customerName2 = "Selenium customer" + System.nanoTime();

	String geofenceName = "Selenium customer geofence" + System.nanoTime();

	public CustomerPage openCustomerPage() {
		DashboardPage dashboard = loginToApp();
		CustomerPage customer = dashboard.navigateToCustomerPage();
		return customer;
	}

	@Test(groups = { "Positive" })
	public void addCustomerWithNameAndGeofence() {
		CustomerPage customer = openCustomerPage();
		String msg = customer.addCustomer(customerName, geofenceName);
		System.out.println(msg);

		Assert.assertTrue(msg.equalsIgnoreCase("Customer record saved successfully"));

		System.out.println(customerName);

		System.out.println("Step-1");

		driver.get("https://tfqa.trackofarm.in/web/0/customer/list?lang=en#");

		String addedCustomerName = customer.checkAddedNameInCustomerList();
		System.out.println(addedCustomerName);
		Assert.assertEquals(addedCustomerName, customerName);

		
		System.out.println("Step-2");

		driver.get("https://tfqa.trackofarm.in/web/0/customer/list?lang=en#");

		String text = customer.Search(customerName);
		System.out.println(text);

		Assert.assertEquals(text, customerName);

		System.out.println("Step-3");

	}

	@Test(groups = { "Positive" })
	public void addCustomerWithNameOnly() {
		CustomerPage customer = openCustomerPage();
		String msg = customer.addCustomerWithoutGeofence(customerName2);

		System.out.println(msg);

		Assert.assertTrue(msg.equalsIgnoreCase("Customer record saved successfully"));

		System.out.println("Step-4");

		driver.get("https://tfqa.trackofarm.in/web/0/customer/list?lang=en#");

		String addedCustomerName = customer.checkAddedNameInCustomerList();
		System.out.println(addedCustomerName);
		Assert.assertEquals(addedCustomerName, customerName2);

		System.out.println("Step-5");

		driver.get("https://tfqa.trackofarm.in/web/0/customer/list?lang=en#");

		String text = customer.Search(customerName2);
		System.out.println(text);

		Assert.assertEquals(text, customerName2);

		System.out.println("Step-6");

	}

	
	@Test(groups = {"Negative"})
	public void addCustomerWithoutName()
	{
		CustomerPage customer = openCustomerPage();
		customer.addCustomerWithoutGeofence("");
		String style = customer.returnStyleOfName();
		System.out.println(style);
		Assert.assertTrue(style.contains("red"));
		
		System.out.println("Step-7");

		
	}

}
