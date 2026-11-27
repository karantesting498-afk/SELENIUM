/*
 * Q8. Jagged Array – Employee Monthly Attendance
An organization stores employee attendance for different months.

Each employee may have a different number of working days in a month.

Create a jagged array:
int[][] attendance = {
    {22, 24, 23},
    {20, 21},
    {25, 23, 24, 22}
};


Requirements:
1. Print attendance of each employee.
2. Calculate total attendance for each employee.
3. Calculate average attendance for each employee.
4. Find the employee with the highest total attendance.
5. Calculate the total attendance of all employees.
6. Your code must work even when rows have different lengths.
Assume each row represents one employee.
 */
package RahulShettyAcademy.date_2026_11_09;

public class Q8_Step9 {

	public static void main(String[] args) {

		int[][] attendance = { { 22, 24, 23 }, { 20, 21 }, { 25, 23, 24, 22 } };

		int totalSum = 0;
		int empIndex=-1;
		int max = 0;
		for (int i = 0; i < attendance.length; i++) {
			int rowSum = 0;
			int count = 0;

			for (int j = 0; j < attendance[i].length; j++) {

				System.out.print(attendance[i][j] + " ");
				rowSum += attendance[i][j];
				count++;
				totalSum += attendance[i][j];

			}
			System.out.println();
			
			System.out.println(rowSum);
			System.out.println((double) rowSum / count);
			if (rowSum > max) {
				max = rowSum;
				empIndex=i;
			}

			System.out.println();
		}



		System.out.println(max);
		System.out.println(totalSum);
		System.out.println(empIndex);
	}

}
