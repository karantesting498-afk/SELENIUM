// TO display all names.

// TO display name with char >4
package com_java_streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Base2 {
	
	public void Test2()
	{
		//Streams
		
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		items.stream().forEach(item-> System.out.println(item));
		
		Stream.of("Alok", "Kanak", "Anmol", "Don").forEach(item -> System.out.println(item));
	}
	
	public void Test1()
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		items.stream().filter(item-> item.length()>5).forEach(item-> System.out.println(item));
		
		Stream.of("Alok", "Kanak", "Anmol", "Don").filter(item-> item.length()>=4).forEach(item -> System.out.println(item));
	}
	
	public void Test3()
	{
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		items.stream().filter(item-> item.length()>5).limit(1).forEach(item-> System.out.println(item));
		
		Stream.of("Alok", "Kanak", "Anmol", "Don").filter(item-> item.length()>=4).limit(1).forEach(item -> System.out.println(item));
	}
	public static void main(String[] args) {
		
		Base2 obj = new  Base2();
		
		obj.Test2();
		
		System.out.println("=========");
		obj.Test1();
		
		System.out.println("=========");

		obj.Test3();

		
		
	}
}
