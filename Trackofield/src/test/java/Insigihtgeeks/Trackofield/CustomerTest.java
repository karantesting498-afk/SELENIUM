package Insigihtgeeks.Trackofield;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import trackofield.pom.pages.CustomerPage;
import trackofield.pom.pages.DashboardPage;
import trackofiled.test_component.BaseTest;

public class CustomerTest extends BaseTest {

	String customerName = "Selenium customer" + System.nanoTime();
	String customerName2 = "Selenium customer" + System.nanoTime();
	String status;
	String geofenceName = "Selenium customer geofence" + System.nanoTime();

	public CustomerPage openCustomerPage() {
		DashboardPage dashboard = loginToApp();
		CustomerPage customer = dashboard.navigateToCustomerPage();
		return customer;
	}

	@Test(groups = { "Positive" })
	public void webAddCustomerWithNameAndGeofence() {
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

		WebElement searchedCustomer = customer.Search(customerName2);
		String text = searchedCustomer.findElement(By.xpath(".//a")).getAttribute("title");
		System.out.println(text);

		Assert.assertEquals(text, customerName);

		System.out.println("Step-3");

	}

	@Test(groups = { "Positive" })
	public void webAddCustomerWithNameOnly() {
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

		WebElement searchedCustomer = customer.Search(customerName2);
		String text = searchedCustomer.findElement(By.xpath(".//a")).getAttribute("title");
		System.out.println(text);

		Assert.assertEquals(text, customerName2);

		System.out.println("Step-6");

	}

	@Test(groups = { "Negative" })
	public void webAddCustomerWithoutName() {
		CustomerPage customer = openCustomerPage();
		customer.addCustomerWithoutGeofence("");
		String style = customer.returnStyleOfName();
		System.out.println(style);
		Assert.assertTrue(style.contains("red"));

		System.out.println("Step-7");
	}

	@Test(groups = { "Positive" })
	public void webCustomerChangeStatus() {
		CustomerPage customer = openCustomerPage();
		
		status = customer.returnCustomerStatus(customerName);

		Assert.assertTrue(status.equalsIgnoreCase("Active"));

		customer.statusChange();

		driver.get("https://tfqa.trackofarm.in/web/0/customer/list?lang=en#");

		status = customer.returnCustomerStatus(customerName);

		Assert.assertTrue(status.equalsIgnoreCase("InActive"));
		customer.statusChange();

	}
	
	@Test(groups= {"Positive"})
	public void webCustomerViewLocation()
	{
		CustomerPage customer = openCustomerPage();
		
		customer.Search(customerName);
		
		Boolean b = customer.viewLocation();
		
		Assert.assertTrue(b);// View location opened
		
		Boolean b2 = customer.checkLeafletMap();
		Assert.assertTrue(b2);// Check for leaflet map by default.
		
		Boolean b3 = customer.checkGeofenceOnMap();
		
		Assert.assertTrue(b3);// Check geofence on Map
		
		WebElement geofenceName = customer.checkGeofenceDisplayName();
		
		Assert.assertEquals(geofenceName.getText(), geofenceName);// Verify geofence name
		
	}
	
}
