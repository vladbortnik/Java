package edu.cuny.brooklyn.cisc3120;

import java.util.ArrayList;

/*
 * Wrapper for ArrayList 
 */
public class FruitArrayList {
	ArrayList<String> fruits;
	
	public FruitArrayList() {
		fruits = new ArrayList<String>();
	}
	
	
	public void add(String fruitName) {
		fruits.add(fruitName);
	}
	
	public void delete(String fruitName) {
		fruits.remove(fruitName); 	
											// MY TEST SHOWED THAT THIS METHOD IS CASE SENSITIVE
											// THE FOLLOWING CODE WILL FIX IT
		
		for(int i=0; i<fruits.size(); i++) {
			if(fruits.get(i).equalsIgnoreCase(fruitName))
				fruits.remove(i);
		}
		
		
	}
	
	public void printAll() {
		for (int i=0; i<fruits.size(); i++) {
			System.out.println("fruits[" + i + "] = \"" + fruits.get(i) + "\"");
		}
	}
	
	public int getSize() {				// THIS METHOD IS ADDED FOR TEST PURPOSES.
		return fruits.size();
	}
	
	public String get(int i){			// THIS METHOD IS ADDED FOR TEST PURPOSES.
		return fruits.get(i);
	}
}
