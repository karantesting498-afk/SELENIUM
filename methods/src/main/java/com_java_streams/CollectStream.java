package com_java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class CollectStream {
	
	public void Test1()//collect and show first
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		List<String> names = Arrays.asList("Alok", "Kanak", "Anmol", "Don");
		List<String> flag = Stream.concat(items.stream(), names.stream()).filter(n->n.length()>5).map(n->n.toUpperCase()).collect(Collectors.toList());
		System.out.println(flag.get(0));
		
	}
	
	public void Test2()// to print unique
	{

		
		List<Integer> names = Arrays.asList(3,2,2,2,3,4,5,6,4,5,6);
		
		Set<Integer> name = names.stream().collect(Collectors.toSet());
		System.out.println(name);
		
		System.out.println("123456789");
	 names.stream().distinct().forEach(n->System.out.println(n));
		
		
	}
	
	public void Test3()//sorted and 2nd index element
	{
		List<Integer> names = Arrays.asList(3,2,2,2,3,4,5,6,4,5,6);
		int n = names.stream().distinct().sorted().collect(Collectors.toList()).get(2);
		System.out.println(n);
	}
	
	public static void main(String[] args) {

		CollectStream obj = new CollectStream();

		obj.Test1();

		System.out.println("=========");
		obj.Test2();
		
		System.out.println("================");
		obj.Test3();
	}

}
