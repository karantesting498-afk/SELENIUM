/*
 * Q6. StringBuilder Operations – Medium
Create a StringBuilder object:
StringBuilder sb = new StringBuilder("Java");

Perform the following operations sequentially:
1. Append " Programming".
2. Insert " Core" at the appropriate position to get "Java Core Programming".
3. Replace "Core" with "Advanced".
4. Delete "Advanced ".
5. Append " Selenium".
6. Reverse the final content.
7. Display the final String.
8. Display its length and capacity.
9. Convert it into a normal String using toString().
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q6_Step7 {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Java");
		
		sb.append(" Programming");
		System.out.println(sb);
		
		sb.insert(4, " Core");
		System.out.println(sb);
		
		sb.replace(5, 10, "Advanced ");
		System.out.println(sb);
		
		sb.delete(4, 13);
		System.out.println(sb);
		
		sb.append(" Selenium");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		System.out.println(sb.toString());
	}

}
