//To store element in the list and found which element in the list starts with a
package com_java_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

import com.webdrivers.EdgeDriverFactory;

public class Base {
	public void Test1()
	{
		int count =0;
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		for(String item : items)
		{
			if(item.charAt(0) == 'a' || item.startsWith("A"))
			{
				System.out.println(item);
				count++;
				
			}
		}
		System.out.println(count);
	}
	
	public void Test2()
	{
		//Streams
		
		int count =0;
		ArrayList<String> items = new ArrayList<String>();
		items.add("abhijeet");
		items.add("rahul");
		items.add("Karan");
		items.add("Aditya");
		items.add("Disha");
		
		Long c =items.stream().filter(item->(item.charAt(0)=='a' || item.charAt(0)=='A')).count();
		System.out.println(c);
		
		Long d = Stream.of("Alok", "Kanak", "Anmol", "Aivek").filter(item -> (item.charAt(0)=='a'|| item.charAt(0)=='A')).count();
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		
		Base obj = new  Base();
		
		obj.Test1();
		obj.Test2();

		
		
	}

}
