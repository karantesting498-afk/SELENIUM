/*
 * Q10. Employee Attendance and Salary Processing – Hard
Write a Java program that accepts the number of working days and attendance days for multiple employees.

Requirements:
1. Accept the number of employees.
2. Use a loop to accept each employee's attendance.

3. Calculate attendance percentage.

4. Classify employees using an if-else ladder:

Attendance percentage	Status
90% or above	Excellent
75%–89%	Good
60%–74%	Average
Below 60%	Poor

5. Calculate salary based on attendance days and daily wage.
6. Reject invalid attendance (negative or greater than working days).
7. Display the total number of employees in each category.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Scanner;

public class Q10_Step11 {
	
	static int workingDays=30;
	int dailyWage =1000;
	
	int excellentCount , goodCount, avgCount, poorCount=0;
	
	public void cal(int days)
	{
		int percentage = (days*100)/workingDays;
		
		String status = (percentage>=90)? "Excellent" : (percentage>=75 && percentage<90)? "Good":
			
			(percentage>=65 && percentage<75)? "Average": "Poor";
			System.out.println(percentage + "   "+ status);
			
			if(status.equalsIgnoreCase("Excellent"))
			{
				excellentCount++;
			}
			else if(status.equalsIgnoreCase("Good"))
			{
				goodCount++;
			}
			else if(status.equalsIgnoreCase("Average"))
			{
				avgCount++;
			}
			else
			{
				poorCount++;
			}
			
			

	}
	
	public void displayCount()
	{
		System.out.println("Excellent Count: "+excellentCount);
		System.out.println("Good Count: "+goodCount);
		System.out.println("Average Count: "+avgCount);
		System.out.println("Poor Count: "+poorCount);
	}
	
	public void calSalary(int days)
	{
		int salary = days*dailyWage;
		System.out.println(salary);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q10_Step11 obj= new Q10_Step11();
		if(!sc.hasNextInt())
		{
			System.out.println("Invalid input type");
			return;
		}
		
		int numEmplyees = sc.nextInt();
		
		for(int i=0; i<numEmplyees; i++)
		{
			System.out.println("Enter working days for employee");
			if(!sc.hasNextInt())
			{
				System.out.println("Invalid input type");
				return;
			}

			int attendanceDays = sc.nextInt();
			
			if(attendanceDays<0 || attendanceDays>workingDays)
			{
				System.out.println("Invalid attendance Days");
				continue;
			}
			
			obj.cal(attendanceDays);
			obj.calSalary(attendanceDays);
		}
		
		obj.displayCount();
		
	}
	

}
