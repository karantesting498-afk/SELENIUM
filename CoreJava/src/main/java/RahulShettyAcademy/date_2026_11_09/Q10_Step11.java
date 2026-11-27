/*
 * Q10. Selenium-Oriented Scenario – Validate Multiple Expected Values
Imagine you are automating an application where you need to validate the displayed employee IDs against expected employee IDs.

Expected values:
int[] expectedIds = {101, 102, 103, 104, 105};


Actual values:
int[] actualIds = {101, 102, 999, 104, 105};


Create a Java program that:
1. Compares expected and actual arrays element by element.
2. Identifies the indexes where values do not match.
3. Prints expected and actual values for mismatches.
4. Counts the total number of mismatches.
5. Prints a final validation status.
6. Handles arrays of different lengths safely.
Expected output:
Mismatch found at index: 2
Expected: 103
Actual: 999

Total mismatches: 1
Validation Status: FAILED


Use only arrays and loops. Do not use Collections, Streams, or TestNG assertions.
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q10_Step11 {
	public static void main(String[] args) {
		
		int[] expectedIds = {101, 102, 103, 104, 105};
		
		int[] actualIds = {101, 102, 999, 104, 105};
		
		int mismatchCount=0;
		

		if(expectedIds.length>=actualIds.length)
		{
			int diff = expectedIds.length-actualIds.length;
			
			for(int i=0; i<actualIds.length;i++)
			{
				if(actualIds[i]!=expectedIds[i])
				{
					System.out.println("Mismatch found at index: " + i);
					System.out.println("Expected: " + expectedIds[i]);
					System.out.println("Actual: " + actualIds[i]);
					mismatchCount++;
				}
			}
			for(int i=actualIds.length; i<expectedIds.length; i++)
			{
				System.out.println("Missing value found at "+i);
				mismatchCount++;

			}
		}
		
		else if(expectedIds.length<actualIds.length)
		{
			int diff = actualIds.length-expectedIds.length;
			
			for(int i=0; i<expectedIds.length;i++)
			{
				if(actualIds[i]!=expectedIds[i])
				{
					System.out.println("Mismatch found at index: " + i);
					System.out.println("Expected: " + expectedIds[i]);
					System.out.println("Actual: " + actualIds[i]);
					mismatchCount++;
				}
			}
			for(int i=expectedIds.length; i<actualIds.length; i++)
			{
				System.out.println("Missing value found at "+i);
				mismatchCount++;

			}
		}
		
		System.out.println(mismatchCount);
		
		if (mismatchCount == 0) {
		    System.out.println("Validation Status: PASSED");
		} else {
		    System.out.println("Validation Status: FAILED");
		}	}

}
