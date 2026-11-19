/*
 * Q1. String Comparison and String Pool – Medium
Write a Java program using the following variables:
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
String s4 = new String("Java");
String s5 = s3.intern();

Requirements:
1. Compare s1 and s2 using ==.
2. Compare s1 and s3 using ==.
3. Compare s3 and s4 using ==.
4. Compare all relevant pairs using equals().
5. Compare s1 and s5 using ==.
6. Predict all outputs before running the program.
7. Explain why each result is true or false
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q1_Step2 {
	
	public static void main(String[] args) {
		
		String s1 = "Java";
		String s2 = "Java";
		String s3 = new String("Java");
		String s4 = new String("Java");
		String s5 = s3.intern();
		
		System.out.println(s1==s2);// True Because string points to same object in String Pool. When s2 = "Java" runs, Java finds the existing “Java” in the pool and reuses it, so both variables hold the same reference.
		System.out.println(s1==s3);//False because s3 is created using new object which will create a new object in String Pool
		System.out.println(s3==s4);//False because s3 is created using new object which will create a new object in String Pool
		System.out.println(s1.equals(s2));//True .equals() is used to compare text.
		System.out.println(s2.equals(s3));//True .equals() is used to compare text.
		System.out.println(s3.equals(s4));//true .equals() is used to compare text.
		System.out.println(s4.equals(s5));//true .equals() is used to compare text.
		System.out.println(s1==s5);//false- wrong it should be true. Because s5 points to s3 object and s1 points to s1 object in heap area. s3.intern() does not return s3 itself. It checks the String Pool for a string equal to “Java”. Since s1 already put “Java” in the pool, intern() returns that pooled reference. So s5 points to the same object as s1, not to s3.
	}

}
