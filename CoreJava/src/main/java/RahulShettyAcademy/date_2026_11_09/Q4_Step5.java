/*
 * Q4. Find Duplicate Elements
Write a Java program to identify duplicate elements in an array.

Input:
int[] numbers = {10, 20, 30, 20, 40, 10, 50, 30};


Expected output:
Duplicate elements:
10
20
30


Conditions:
1. Do not use Collections.
2. Do not use Streams.
3. Do not use Arrays.sort().
4. Avoid printing the same duplicate multiple times.
5. Handle an array with no duplicates.
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q4_Step5 {

	public static void main(String[] args) {
		int[] numbers = {10, 20, 30, 20, 40, 10, 50, 30};
		int duplicateCount = 0;
		int[] duplicate = new int[numbers.length];
		
		for(int i=0; i<numbers.length;i++)
		{
			for(int j =i+1;j<numbers.length;j++)
			{
				if(numbers[i]==numbers[j])
				{
					boolean alreadyExists = false;

					for(int k =0; k<duplicate.length;k++)
					{
						if(numbers[i]==duplicate[k])
						{
							alreadyExists= true;
							break;
						}
							
					}
					
					
					if(!alreadyExists)
						{
							duplicate[duplicateCount]= numbers[i];
							duplicateCount++;						
					}
					
					break;

				}
			}
		}
		
		System.out.println("Duplicate elements are: ");
		
		for(int i=0; i<duplicate.length;i++)
		{
			if(duplicate[i]!=0)
			{
				System.out.println(duplicate[i]);
			}
		}
		
	}
}
