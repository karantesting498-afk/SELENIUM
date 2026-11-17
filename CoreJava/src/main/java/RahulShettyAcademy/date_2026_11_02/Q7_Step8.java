/*
 * Q2. Operators and Expression Evaluation
Write a Java program that:
1. Declares three integer variables.
2. Calculates their sum, average and product.
3. Finds the remainder when the largest number is divided by the smallest.
4. Checks whether the average is greater than 50.
5. Uses compound assignment operators (+=, -=, *=, /=).
6. Displays the result after each operation.
Expected learning: Arithmetic, relational and assignment operators.
 */
package RahulShettyAcademy.date_2026_11_02;

public class Q7_Step8 {
	
	public static void main(String[] args) {
		
		int a=10;
		int b = 20;
		int c = 30;
		
		int sum = a+b+c;
		System.out.println(sum);
		
		int product = a*b*c;
		System.out.println(product);
		
		int avg = (sum)/3;
		System.out.println(avg);
		
		int largest = (a>b && a>c)? a: (b>a && b>c)? b :c;
		int smallest = (a<b && a<c)? a: (b<a && b<c)? b :c;
		
		System.out.println(largest%smallest);
		
		if(avg>50)
		{
			System.out.println("Avg > 50");
		}
		
		a+=5;
		System.out.println(a);

		a-=5;
		System.out.println(a);
		
		a*=5;
		System.out.println(a);
		
		a/=5;
		System.out.println(a);
	}

}
