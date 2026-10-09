// here we learn about normalize space and searching using index

package Selenium.revision.date_5_oct;

public class Selector_Step3 {
	
	/*
	 * Normalize-space
	 * 
	 * It is mainly used when text contains extra spaces, tabs or line breaks
	 * normalize-space()
	 * 
	 * 
	 * <button>
     		Approve Leave
		</button>
		
		Using this can be unreliable : By.xpath("//button[text()='Approve leave']");
		Safer approach is : By.xpath("//button[normalize-space(.)='Approve Leave']")
		Here (.) specify the complete current node
		
		we can also use this :
		By.xpath("//button[normalize-space(text())='Save Employee']")
		
		but it will only check direct node. 
		it will fail in case we have multiple tags in it.
		
		
		
		Finding element using index
		
		Note : xpath indexing start from 1 not 0.
		suppose : 
		
		<input type="text">
		<input type="text">
		<input type="text">

		so to access first we can use : By.xpath("(//input[@type='text'])[1]");
		so to access second we can use : By.xpath("(//input[@type='text'])[2]");
		so to access third we can use : By.xpath("(//input[@type='text'])[3]");
		
		
		Here we have bracket around the complete x path, which means  Find all matching inputs, then select the second one.
		
		
		Now In case we have 
		List<WebElement> elements =
    driver.findElements(By.xpath("//input[@type='text']"));
    
    to get 1 element in list we have to start from 0 not 1 as list first index is 0.
    
    to get first = elements.get(0);
    second : = elements.get(1);
    
    
	 */

}
