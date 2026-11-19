/*
 * Q9. Extract and Validate Information from a Text – Hard
Accept the following text:
Order ID: TF20261119 | Customer: Karan | Amount: 2499.50 | Status: SUCCESS

Requirements:
1. Extract the Order ID.
2. Extract the Customer name.
3. Extract the Amount.
4. Extract the Status.
5. Check whether the status is "SUCCESS".
6. Check whether the Order ID starts with "TF".
7. Check whether the amount is greater than 1000.
8. Display the extracted information in uppercase.
9. Build a final formatted message using StringBuilder.
Do not use JSON parsing or external libraries.
 */
package RahulShettyAcademy.date_2026_11_04;

public class Q9_Step10 {
	
	public static void main(String[] args) {
		
		String s = "Order ID: TF20261119 | Customer: Karan | Amount: 2499.50 | Status: SUCCESS";
		
		String orderId = s.split("\\|")[0].strip().split(":")[1].strip();
		System.out.println(orderId);
		
		String cutomerName = s.split("\\|")[1].strip().split(":")[1].strip();
		System.out.println(cutomerName);
		
		String amount = s.split("\\|")[2].split(":")[1].strip();
		System.out.println(amount);
		
		String status = s.split("\\|")[3].split(":")[1].strip();
		System.out.println(status);
		
		System.out.println(status.equalsIgnoreCase("Success"));
		
		System.out.println(orderId.startsWith("TF"));
		
		System.out.println(Double.parseDouble(amount) >1000);

		System.out.println("Order ID : "+ orderId.toUpperCase() + " | Customer: "+ cutomerName.toUpperCase() + " | Amount: "+ (amount) + " | Status: "+ status);
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("Order ID : ").append(orderId.toUpperCase()).append(" | Customer: ").append(cutomerName.toUpperCase()).append(" | Amount: ").append(amount).append(" | Status: ").append(status.toUpperCase());
		
		
		System.out.println(sb);
		

}

}
