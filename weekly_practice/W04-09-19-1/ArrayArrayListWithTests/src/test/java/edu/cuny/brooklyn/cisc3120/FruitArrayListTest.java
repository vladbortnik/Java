package edu.cuny.brooklyn.cisc3120;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FruitArrayListTest {
	
	@Test
    public void testDeleteByDeleting1st() {				// THIS TEST WORKS FINE. NO BUGS FOUND.
		
		FruitArrayList fruits = new FruitArrayList();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.delete("Apple");
		
		FruitArrayList fruitsExpected = new FruitArrayList();
		fruitsExpected.add("Banana");
		fruitsExpected.add("Kiwi");
		fruitsExpected.add("Mango");
		fruitsExpected.add("Orange");
		
		assertEquals("The size of the FruitArrayList object is unexpected.", fruits.getSize(), fruitsExpected.getSize());
		for (int i = 0; i < fruitsExpected.getSize(); i++) {
			assertTrue(fruits.get(i).equals(fruitsExpected.get(i)));
		}
		
    }
	
	@Test
	public void testDeleteByDeleting3rd() {				// THIS TEST WORKS FINE. NO BUGS FOUND.

		FruitArrayList fruits = new FruitArrayList();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.delete("Kiwi");
		
		FruitArrayList fruitsExpected = new FruitArrayList();
		fruitsExpected.add("Apple");
		fruitsExpected.add("Banana");
		fruitsExpected.add("Mango");
		fruitsExpected.add("Orange");
		
		assertEquals("The size of the FruitArrayList object is unexpected.", fruits.getSize(), fruitsExpected.getSize());
		for (int i = 0; i < fruitsExpected.getSize(); i++) {
			assertTrue(fruits.get(i).equals(fruitsExpected.get(i)));
		}
		
    }
	
	@Test
	public void testDeleteByDeletingLast() {					// THIS TEST WORKS FINE. NO BUGS FOUND.

		FruitArrayList fruits = new FruitArrayList();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.delete("Orange");
		
		FruitArrayList fruitsExpected = new FruitArrayList();
		fruitsExpected.add("Apple");
		fruitsExpected.add("Banana");
		fruitsExpected.add("Kiwi");
		fruitsExpected.add("Mango");
		
		assertEquals("The size of the FruitArrayList object is unexpected.", fruits.getSize(), fruitsExpected.getSize());
		for (int i = 0; i < fruitsExpected.getSize(); i++) {
			assertTrue(fruits.get(i).equals(fruitsExpected.get(i)));
		}
		
    }
	
	@Test
	public void testDeleteIgnoreCaseByDeleting1st() {		// THIS TEST SHOWED THAT METHOD "DELETE()" IS CASE SENSITIVE.
				// I HAVE FIXED METHOD "DELETE()" AND THIS TEST WORKS NOW.
		
		FruitArrayList fruits = new FruitArrayList();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.delete("apple");
		
		FruitArrayList fruitsExpected = new FruitArrayList();
		fruitsExpected.add("Banana");
		fruitsExpected.add("Kiwi");
		fruitsExpected.add("Mango");
		fruitsExpected.add("Orange");
		
		assertEquals("The size of the FruitArrayList object is unexpected.", fruits.getSize(), fruitsExpected.getSize());
		for (int i = 0; i < fruitsExpected.getSize(); i++) {
			assertTrue(fruits.get(i).equals(fruitsExpected.get(i)));
		}
		
    }
	
	@Test
	public void testDeleteIgnoreCaseByDeletingLast() {		// THIS TEST SHOWED THAT METHOD "DELETE()" IS CASE SENSITIVE.
		// I HAVE FIXED METHOD "DELETE()" AND THIS TEST WORKS NOW.

		FruitArrayList fruits = new FruitArrayList();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.delete("orange");
		
		FruitArrayList fruitsExpected = new FruitArrayList();
		fruitsExpected.add("Apple");
		fruitsExpected.add("Banana");
		fruitsExpected.add("Kiwi");
		fruitsExpected.add("Mango");
		
		assertEquals("The size of the FruitArrayList object is unexpected.", fruits.getSize(), fruitsExpected.getSize());
		for (int i = 0; i < fruitsExpected.getSize(); i++) {
			assertTrue(fruits.get(i).equals(fruitsExpected.get(i)));
		}
		
    }
		

}
