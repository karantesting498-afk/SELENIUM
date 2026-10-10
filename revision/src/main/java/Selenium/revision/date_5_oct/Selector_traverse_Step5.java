// This class is basically for traverse among elements

package Selenium.revision.date_5_oct;

public class Selector_traverse_Step5 {

	
	/*
	 * 1. Parent → Child
	 * <div class="login">
	 * 
    		<input id="username">
    		
		</div>
		
		Using child::
		
		By.xpath("//div[@class='login']/child::input");
		or
		
		By.xpath("//div[@class-'login']/input"); --> Here single slash / because it will search direct child
	 */
	
	
	/*
	 * 2. Child → Parent
	 * 
	 * By.xpath("//input[@id='username']/parent::div")
	 * 
	 * or
	 * 
	 * By.xpath("//input[@id='username']/..")
	 * 
	 */
	
	/*
	 * 3. Parent → Descendant
	 * 
	 * <div class="form">

    		<section>
        		<div>
            		<input id="username">
        		</div>
    		</section>

		</div>
		
		input is not an immediate child of .form.
		By.xpath("//div[@class='form']/descendant::input");
		
		or
		
		By.xpath("//div[@class='form']//input")--> here double 
	 */
	
	/*
	 * Note :  
	 * 		/    → immediate child
			//   → any level below
	 */
	
	/*
	 * 4. Child → Ancestor
	 * 
	 * 	<div class="main">
    			<section>
        				<div>
            					<input id="username">
        				</div>
    			</section>
		</div>
		
		By.xpath("//input[@id='username']/ancestor::div")
		This can locate div elements at multiple levels above.
		
		So to find parent we have parent::
		to find grandparent we have : ancestor::
		
		
	 */
	
	/*
	 * 5. Following Sibling
	 * 
	 * <input id="username">
			<button>Save</button>
			<button>Cancel</button>
			
			By.xpath("//input[@id='username']/following-sibling::button")--> This can match both buttons.
			so first sibline we have --> By.xpath("//input[@id='username']/following-sibling::button[1]");
			
	 */
	
	/*
	 * 6. Preceding Sibling
	 * <button>Save</button>
		<button>Cancel</button>
		<input id="username">
		
		By.xpath("//input[@id='username']/preceding-sibling::button")
	 */
	
	/*
	 * 7. following::
	 * This is different from following-sibling::.
	 * 
	 * <div>
    			<input id="username">
		</div>

		<section>
    		<button>Save</button>
		</section>
		
		button is not a sibling of input.
		So this will not work:
		//input[@id='username']/following-sibling::button
		
		By.xpath("//input[@id='username']/following::button")
		following:: can search later in the DOM, not just at the same level.
		
		
	 */
	
	/*
	 * 8. preceding::
	 * 
	 * Opposite of following::.
	 * 
	 * <button>Save</button>

<div>
    <input id="username">
</div>


		By.xpath("//input[@id='username']/preceding::button")
		It searches elements that occur before the current element in the document.
	 */
	
	/*
	 * 9. self::
	 * 
	 */
	
	
	/*
	 * 
	 * parent::              → current node's parent only
child::               → current node's direct children only
ancestor::            → current node's upward hierarchy
descendant::          → current node's subtree only
following-sibling::   → same-parent area only
preceding-sibling::   → same-parent area only
following::           → broader document area after current node
preceding::           → broader document area before current node
	 */
}
