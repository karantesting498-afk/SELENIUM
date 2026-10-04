package com_java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMaps {

	public void Test1()// Name with lenght > 4 and print them in upper Case
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");

		List<String> upperNames = items.stream().filter(item -> item.length() > 5).map(item -> item.toUpperCase())
				.collect(Collectors.toList());

		System.out.println(upperNames);
		Stream.of("Alok", "Kanak", "Anmol", "Don").filter(item -> item.length() >= 4).map(item -> item.toUpperCase())
				.forEach(item -> System.out.println(item));
	}

	
	public void Test2()// Name with lenght > 4 and print them in upper Case and sorted order
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");

		List<String> upperNames = items.stream().filter(item -> item.length() > 5).sorted().map(item -> item.toUpperCase())
				.collect(Collectors.toList());
	

		System.out.println(upperNames);
		Stream.of("Alok", "Kanak", "Anmol", "Don").filter(item -> item.length() >= 4).sorted().map(item -> item.toUpperCase())
				.forEach(item -> System.out.println(item));
	}
	
	public void test3() // array sorting
	{
		String[] arr = new String[5];
		arr[0] = "100";
		arr[1] = "50";
		arr[2] = "70";
		arr[3] = "10";
		arr[4] = "99";
		
		List<String> arrs = Arrays.asList(arr);
		
		arrs.stream().map(item-> Integer.parseInt(item)).sorted().forEach(item-> System.out.println(item));
	}
	
	public void test4()// merge lists
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		List<String> names = Arrays.asList("Alok", "Kanak", "Anmol", "Don");
		Stream.concat(items.stream(), names.stream()).map(item-> item.toUpperCase()).sorted().forEach(s->System.out.println(s));

	}
	public static void main(String[] args) {

		StreamMaps obj = new StreamMaps();

		obj.Test1();
		
		System.out.println("==============");
		obj.Test2();
		
		System.out.println("+++++++++++++++");

		obj.test3();
		
		System.out.println("-----------------------");
		obj.test4();
	}

}


