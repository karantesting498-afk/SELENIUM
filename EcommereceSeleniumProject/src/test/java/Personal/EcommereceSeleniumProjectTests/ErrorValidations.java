package Personal.EcommereceSeleniumProjectTests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import Personal.EcommereceSeleniumProject.POM.CartPage;
import Personal.EcommereceSeleniumProject.POM.LoginPage;
import Personal.EcommereceSeleniumProject.POM.ProductCatelog;
import Personal.EcommereceSeleniumProjectTests.TestComponents.BaseTest;
import Personal.EcommereceSeleniumProjectTests.TestComponents.Retry;

public class ErrorValidations extends BaseTest{
	
	@Test
	public void loginErrorValidation() throws IOException
	{
		
		
		
		loginPage.login("karan@mailinator.com", "123456");
		Assert.assertEquals("Incorrect email or password.", loginPage.getLoginFailMsg());
	
	}
	
	
	@Test(retryAnalyzer = Retry.class)
	public void productErrorValidation()
	{
		String productName = "ZARA COAT";
		
		ProductCatelog product = loginPage.login("karan@mailinator.com", "Admin@123");
		
		product.addToCart(productName);
		
		CartPage cart = product.gotoCart();
		
		boolean match = cart.verifyProductAdded("Samsung");
		
		Assert.assertFalse(match, "Failed");
				
		
	}
	
	
	

}
