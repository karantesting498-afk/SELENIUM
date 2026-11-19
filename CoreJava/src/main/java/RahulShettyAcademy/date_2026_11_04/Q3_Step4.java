/*
 * Q3. String Immutability and Concatenation – Hard
Study and execute the following code:
String s1 = "Java";
String s2 = s1;

s1.concat(" Selenium");

System.out.println(s1);
System.out.println(s2);

s1 = s1.concat(" Testing");

System.out.println(s1);
System.out.println(s2);

Requirements:
1. Predict the output.
2. Explain why s1 and s2 initially have the same content.
3. Explain why concat() does not modify the original String.
4. Explain what happens after reassignment.
5. Modify the program to demonstrate String immutability using toUpperCase().
6. Demonstrate String concatenation using + and concat().
7. Explain the difference between 10 + 20 + "Java" and "Java" + 10 + 20.
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q3_Step4 {
	
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = s1;

		s1.concat(" Selenium");

		System.out.println(s1);
		System.out.println(s2);

		s1 = s1.concat(" Testing");

		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1.toUpperCase());

		System.out.println(s1+"using +");
		
		String s3 = s1.concat("Hello");

		System.out.println(s3);
		
		/*
		 * 1.output
		 * Java 
		 * Java
		 * Java Testing
		 * Java
		 * 
		 * 2. s1 = java  is initialized in java pool. When we use s2=s1, it will directly point of reference of object which holds s1.
		 * It copies the reference value that s1 holds, so both variables point to the same object.
		 *  This distinction is exactly what makes item 4 work: when s1 is later reassigned, 
		 *  s2 is unaffected because it never pointed to the variable s1, only to the object.
		 * 
		 * 3. String is immutable. concat creates a new string in heap area with updated details but original remain same.
		 * 
		 * 4. After reassignment, a new string is created in string pool and variable points to updated string.
		 * 
		 * the same point applies. After s1 = s1.concat(" Testing"), s1 points to a new heap object "Java Testing",
		 *  while s2 still points to the original pooled "Java".
		 * 
		 * 
		 * 5. code
		 * 6. code
		 * 7. 10 + 20 + "Java" = 30Java
		 * "Java" + 10 + 20 =  Java1020
		 * 
		 */
	}

}
