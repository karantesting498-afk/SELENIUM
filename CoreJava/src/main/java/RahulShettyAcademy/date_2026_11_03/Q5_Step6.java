/*
 * Q4. Array Operations and Duplicate Detection
Given:
int[] numbers = {45, 12, 89, 23, 67, 12, 90, 34, 45, 23};


Write a Java program to:
1. Print all elements using a traditional for loop.
2. Print all elements using an enhanced for loop.
3. Find the maximum and minimum values.
4. Calculate the sum and average.
5. Reverse the array while displaying its elements.
6. Find duplicate elements without using collections.
7. Count the frequency of every element.
8. Sort the array in ascending order.
9. Search for a user-entered number.
10. Display the positions of all matching elements.
 */
package RahulShettyAcademy.date_2026_11_03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q5_Step6 {
	
	
	int[] numbers = {45, 12, 89, 23, 67, 12, 90, 34, 45, 23};

	//Print all elements using a traditional for loop.
	public void calculate1()
	{
		for(int i=0; i<numbers.length;i++)
		{
			System.out.println(numbers[i]);
		}
		
		System.out.println("------");
	}
	
	//Print all elements using an enhanced for loop.
	public void calculate2()
	{
		for(int a : numbers)
		{
			System.out.println(a);
		}
	}
	
	
	//Find the maximum and minimum values.
	public void calculate3()
	{
		List<Integer> boxed= Arrays.stream(numbers).boxed().collect(Collectors.toList());
		
		List<Integer> sorted = boxed.stream().sorted().collect(Collectors.toList());
		
		int max = sorted.get(boxed.size()-1);
		int min = sorted.get(0);
		
		System.out.println("Max is :"+ max);
		System.out.println("Min is :"+ min);
		
	}
	
	//Calculate the sum and average.
	public void calculate4()
	{
		List<Integer> boxed= Arrays.stream(numbers).boxed().collect(Collectors.toList());
		
		int sum = boxed.stream().mapToInt(Integer:: intValue).sum();
		double average = boxed.stream().mapToInt(Integer::intValue).average().getAsDouble();

		
		System.out.println("sum is :"+ sum);
		System.out.println("average is :"+ average);
		
	}
	
	//Reverse the array while displaying its elements.
	public void calculate5()
	{
		for(int i= numbers.length-1; i>=0; i--)
		{
			System.out.println(numbers[i]);
		}
		
	}
	
	
	//Find duplicate elements without using collections.
	public void calculate6()
	{
		
		List<Integer> boxed = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		
		Map<Integer, Long> map = boxed.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
		System.out.println(map);
		map.entrySet().stream().filter(s->s.getValue()>1).map(s->s.getKey()).forEach(s-> System.out.println(s));
	}
	
	
	//Count the frequency of every element.
		public void calculate7()
		{
			
			List<Integer> boxed = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			
			Map<Integer, Long> map = boxed.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
			
			System.out.println(map);
				
		}
		
		//Sort the array in ascending order.
		public void calculate8()
		{
			
			List<Integer> boxed = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			
			boxed.stream().sorted().forEach(s->System.out.println(s));
			
			//or
			
			Arrays.sort(numbers);
				
		}
		
		//Search for a user-entered number.
		public void calculate9()
		{
			int input =12;
			
			List<Integer> boxed = Arrays.stream(numbers).boxed().collect(Collectors.toList());
			if(boxed.stream().anyMatch(s->s==input))
			{
				System.out.println("Number found");
			}
		}
	public static void main(String[] args) {
		Q5_Step6 obj = new Q5_Step6();
		
		obj.calculate1();
		obj.calculate2();
		obj.calculate3();
		obj.calculate4();
		obj.calculate5();
		obj.calculate6();
		obj.calculate7();
		obj.calculate8();
		obj.calculate9();
		
	}

}
