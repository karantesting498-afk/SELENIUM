/*
 * Q10. Selenium-Oriented Web Text Validation – Hard
Consider the following product details retrieved from a web page:
String actualProduct = "  ZARA COAT 3  ";
String expectedProduct = "zara coat 3";

String actualPrice = "₹ 2,499.50";
String expectedPrice = "2499.50";

Requirements:
1. Remove leading and trailing spaces from the product name.
2. Compare actual and expected product names without considering case.
3. Remove the rupee symbol and spaces from the actual price.
4. Compare the cleaned price with the expected price.
5. Build a validation result using StringBuilder.
6. Display separate results for product-name and price validation.
7. Explain how these operations can be applied to getText() values retrieved through Selenium.
 */


package RahulShettyAcademy.date_2026_11_04;

public class Q10_Step11 {
	
	
	
	public static void main(String[] args) {
		
		String actualProduct = "  ZARA COAT 3  ";
		String expectedProduct = "zara coat 3";

		String actualPrice = "₹ 2,499.50";
		String expectedPrice = "2499.50";
		
		actualProduct = actualProduct.strip();
		
		System.out.println(actualProduct.equalsIgnoreCase(expectedProduct));
		
		String[] actualPriceArray = actualPrice.split(" ")[1].strip().split(",");
		actualPrice = actualPriceArray[0] + actualPriceArray[1];
		System.out.println(actualPrice.equalsIgnoreCase(expectedPrice));
		
		StringBuilder sb = new StringBuilder();
		
//		Assert.assertTrue(actualPrice.equalsIgnoreCase(expectedPrice));
//		Assert.assertTrue(actualProduct.equalsIgnoreCase(expectedProduct));
//		
//		Assert.assertTrue(...) stops the test at the first failure. 
//		If the product-name assert fails, the price check never runs. Use SoftAssert if you want both checks reported.
//		Give the assertion a message, so a failure tells you what went wrong:
		
		
		
	}

}
