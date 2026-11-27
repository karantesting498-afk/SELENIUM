/*
 * Q6. Two-Dimensional Array Processing
Create a Java program using this 2D array:
int[][] marks = {
    {70, 80, 90},
    {60, 75, 85},
    {90, 95, 80}
};


Requirements:
1. Print all elements in matrix format.
2. Calculate the sum of each row.
3. Calculate the sum of each column.
4. Find the highest mark in the entire matrix.
5. Calculate the average of all elements.
6. Print the total number of rows and columns.
Expected output should clearly identify row totals, column totals, maximum mark, and average.
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q6_Step7 {
	
	public static void main(String[] args) {

		int[][] marks = {
			    {70, 80, 90},
			    {60, 75, 85},
			    {90, 95, 80}
			};
		
		int max= marks[0][0];
		int totalElementSum=0;
		for(int i=0;i<marks.length;i++)
		{
			int rowSum =0;

			for(int j=0; j<marks[i].length;j++)
			{
				System.out.print(marks[i][j] + " ");
				rowSum += marks[i][j];
				totalElementSum += marks[i][j];
				
				if(marks[i][j]>max)
				{
					max= marks[i][j];
				}
			}
			System.out.println();
			System.out.println(rowSum);
		}
		
		
		System.out.println(max);
		
		System.out.println("==========");
		for(int j =0; j<marks[0].length;j++)
		{
			int colSum=0;
			
			for(int i=0; i<marks.length;i++)
			{
				colSum += marks[i][j];
			}
			
			System.out.println(colSum);
		}
		
		System.out.println("Avg");
		double avg = (double) totalElementSum/(marks.length*marks[0].length);
		System.out.println(avg);
		
		System.out.println(marks.length);
		System.out.println(marks[0].length);
	}
	

}
