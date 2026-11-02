/*
 * Question 1 — Write a TestNG Class (Medium)
Task: Create a Java class named StudentTest that meets these requirements:
1. Create a method named setup() that prints "Preparing test environment".
2. Execute setup() before every TestNG test method.
3. Create a test method named testStudentName() that prints "Testing student name".
4. Create another test method named testStudentAge() that prints "Testing student age".
5. Both test methods must be recognized and executed by TestNG.
Your task:
Write the complete Java class, including all necessary imports and annotations.

Expected behaviour: The setup method should execute before each test method.
 */

package Selenium.revision.date_23_Oct;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentTest_Step3 {
	
	@BeforeMethod
	public void setup()
	{
			System.out.println("Preparing test environment");
			
	}
	
	
	@Test
	public void testStudentName()
	{
		System.out.println("Testing student name");
	}
	
	
	@Test
	public void testStudentAge()
	{
		System.out.println("Testing student age");
	}

}
