package com_java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class MatchStream {
	
	public void Test1()
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		List<String> names = Arrays.asList("Alok", "Kanak", "Anmol", "Don");
		boolean flag = Stream.concat(items.stream(), names.stream()).anyMatch(s-> s.equalsIgnoreCase("Rahul"));
		Assert.assertTrue(flag);
	}
	
	public static void main(String[] args) {

		MatchStream obj = new MatchStream();

		obj.Test1();
	
	}

}
