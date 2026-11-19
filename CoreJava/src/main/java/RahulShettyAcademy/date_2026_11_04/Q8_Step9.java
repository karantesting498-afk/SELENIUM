/*
 * Q8. StringBuffer and Thread Safety – Medium
Create a StringBuffer object:
StringBuffer sb = new StringBuffer("Java");

Requirements:
1. Append " Programming".
2. Insert " Core" at the appropriate position.
3. Replace "Core" with "Advanced".
4. Delete "Advanced ".
5. Reverse the content.
6. Display the final content.
7. Explain why StringBuffer is synchronized.
8. Explain the difference between StringBuffer and StringBuilder.
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q8_Step9 {
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java");
		sb.append(" Programming");
		System.out.println(sb);

		
		sb.insert(4, " Core");
		System.out.println(sb);
		
		sb.replace(4, 9, " Advanced");
		System.out.println(sb);
		
		sb.delete(5, 14);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		/*
		 * 1. String buffer syncronize the changes with all the threads, that's why it is considered synchronized.
		 * 
		 * String buffer is syncronized but builder is not.
		 * string buffer takes more time than builder due to syncronizing
		 */
		
		
	}

}
