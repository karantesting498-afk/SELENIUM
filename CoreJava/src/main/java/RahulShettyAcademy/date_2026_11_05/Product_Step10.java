/*
 * Q9. Constructor Chaining and Initialization Order
Advanced
Create a class named Product.

Requirements:
1. Declare instance variables productId, productName and price.
2. Add an instance initialization block.
3. Create three overloaded constructors:
   - No-argument constructor.
   - Constructor accepting productId.
   - Constructor accepting all three variables.
4. Use this() to implement constructor chaining.
5. Add a static initialization block.
6. Add a static variable category.
7. Create three objects using different constructors.
8. Predict and explain the complete execution order.
9. Explain the difference between constructor chaining and method calling.
 */
package RahulShettyAcademy.date_2026_11_05;

public class Product_Step10 {
	
	int productId;
	String productName;
	int price;
	static String category = "Bike";
	
	static
	{
		System.out.println("Static block initialized");
	}
	
	
	{
		System.out.println("NON Static block initialized");
	}
	
	public Product_Step10() {
		// TODO Auto-generated constructor stub
		
		System.out.println("Default const. initialized");
	}
	
	public Product_Step10(int productId) {
		// TODO Auto-generated constructor stub
		this();
		this.productId = productId;
		System.out.println("const.with only  productId initialized");
	}

	public Product_Step10(int productId, String productName, int price) {
		this(productId);
		this.productName = productName;
		this.price = price;
		
		System.out.println("All parameter const. created");
	}
	public static void main(String[] args) {
		
		Product_Step10 obj1 = new Product_Step10();
		Product_Step10 obj2 = new Product_Step10(101);
		Product_Step10 obj3 = new Product_Step10(201, "Gear Bike", 100);
	}
	
	/*
	 * Output
	 * Static block initialized
	 * NON Static block initialized
	 * Default const. initialized
	 * NON Static block initialized
	 * Default const. initialized
	 * const.with only  productId initialized
	 * NON Static block initialized
	 * Default const. initialized
	 * const.with only  productId initialized 
	 * All parameter const. created
	 * 
	 * Static block will be called once per class.
	 * Non static block will be called each time an object is created.
	 * 
	 * this() will we used to chain constructor.
	 * 
	 * Constructor chaining (this(...)) lets one constructor of the same class call
   another to reuse initialization code. It must be the first statement, can only
   be used inside a constructor, and runs during object creation, before the
   rest of that constructor's body. A normal method call can be made anywhere
   in any method, can be repeated any number of times, and works on an object
   that already exists. A constructor cannot be called like a method
   (obj.Product_Step10() is invalid).
	 * 
	 * 
	 */
	

}
