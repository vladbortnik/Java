package edu.cuny.brooklyn.cisc3120;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 * API documentation: http://junit.org/junit4/javadoc/latest/index.html
 * Example: https://github.com/junit-team/junit4/wiki/getting-started
 */

public class FruitArrayTest
{
	// TODO: 1. Add a test class FruitArrayListTest.java, and design and implement 
	//          a few tests for the delete method in the FruitArrayList class. When
	//          designing your test cases, consider test coverage and the quality
	//          of the both of the code under test and testing code. 
	// TODO: 2. If your code does not pass the tests, fix your code. Explain the bugs
	//          found in a comment in both FruitArray.java and FruitArrayList.java. 
	//          If you do not find any bugs, you still need to write a comment in both
	//          FruitArray.java and FruitArrayList.java, and the comment reads, "no 
	//          bugs found" or similar. 
	// TODO: 3. Explain why I gave up the idea of using assertArrayEquals. It seems to
	//          be simpler if I used it. Write your explanation as a comment in this 
	//          Java file. 
	
    /**
     * Test the delete method thoroughly
     */
	@Test
    public void testDeleteByDeleting1st() {
    	// why not this: String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Orange"};
	// IT LOOKS THE SAME FOR ME. IT'S JUST A SHORTCUT SINTAX.
        String[] fruits = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        FruitArray fruitArray = new FruitArray(fruits);    

        fruitArray.delete(new String("Apple"));
        String[] fruitsExpected = {new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        
        assertEquals("The size of the FruitArray object is unexpected.", fruitArray.getSize(), fruitsExpected.length);
        assertEquals(fruitArray.getCapacity(), fruitsExpected.length + 1);
        // why not assertArrayEquals( ... )
        // I DID NOT FIND TWO STRING ARRAY COMPARISON METHODS IN CLASS ASSERT.
        // MEANING THERE IS NO METHOD LIKE THIS:
        // assertArrayEquals(java.lang.String message, String[] expecteds, String[] actuals)
        // REFERED TO: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		for (int i = 0; i < fruitsExpected.length; i++) {
			assertTrue(fruitArray.getFruitsAsArray()[i].equals(fruitsExpected[i]));
		}
    }

	@Test
    public void testDeleteByDeleting3rd() {
    	// why not this: String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Orange"};
	// IT LOOKS THE SAME FOR ME. IT'S JUST A SHORTCUT SINTAX.
        String[] fruits = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        FruitArray fruitArray = new FruitArray(fruits);    
        
        fruitArray.delete(new String("Kiwi"));
        String[] fruitsExpected = {new String("Apple"), new String("Banana"), new String("Mango"), new String("Orange")};

        assertEquals("The size of the FruitArray object is unexpected.", fruitArray.getSize(), fruitsExpected.length);
        assertEquals(fruitArray.getCapacity(), fruitsExpected.length + 1);
        // why not assertArrayEquals( ... )
        // I DID NOT FIND TWO STRING ARRAY COMPARISON FUNCTION IN CLASS ASSERT.
        // MEANING THERE IS NO METHOD LIKE THIS:
        // assertArrayEquals(java.lang.String message, String[] expecteds, String[] actuals)
        // REFERED TO: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
        for (int i = 0; i < fruitsExpected.length; i++) {
			assertTrue(fruitArray.getFruitsAsArray()[i].equals(fruitsExpected[i]));
		}
    }  

	@Test
    public void testDeleteByDeletingLast() {
    	// why not this: String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Orange"};
	// IT LOOKS THE SAME FOR ME. IT'S JUST A SHORTCUT SINTAX.
        String[] fruits = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        FruitArray fruitArray = new FruitArray(fruits);    
        
        fruitArray.delete(new String("Orange"));
        String[] fruitsExpected = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango")};
        
        assertEquals("The size of the FruitArray object is unexpected.", fruitArray.getSize(), fruitsExpected.length);
        assertEquals(fruitArray.getCapacity(), fruitsExpected.length + 1);
        // why not assertArrayEquals( ... )
        // I DID NOT FIND TWO STRING ARRAY COMPARISON FUNCTION IN CLASS ASSERT.
        // MEANING THERE IS NO METHOD LIKE THIS:
        // assertArrayEquals(java.lang.String message, String[] expecteds, String[] actuals)
        // REFERED TO: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		for (int i = 0; i < fruitsExpected.length; i++) {
			assertTrue(fruitArray.getFruitsAsArray()[i].equals(fruitsExpected[i]));
		}
    } 
    
	@Test
    public void testDeleteIgnoreCaseByDeleting1st() {
    	// why not this: String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Orange"};
	// IT LOOKS THE SAME FOR ME. IT'S JUST A SHORTCUT SINTAX.
        String[] fruits = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        FruitArray fruitArray = new FruitArray(fruits);    
        
        fruitArray.delete(new String("apple"));
        String[] fruitsExpected = {new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};

        assertEquals("The size of the FruitArray object is unexpected.", fruitArray.getSize(), fruitsExpected.length);
        assertEquals(fruitArray.getCapacity(), fruitsExpected.length + 1);
        // why not assertArrayEquals( ... )
        // I DID NOT FIND TWO STRING ARRAY COMPARISON FUNCTION IN CLASS ASSERT.
        // MEANING THERE IS NO METHOD LIKE THIS:
        // assertArrayEquals(java.lang.String message, String[] expecteds, String[] actuals)
        // REFERED TO: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		for (int i = 0; i < fruitsExpected.length; i++) {
			assertTrue(fruitArray.getFruitsAsArray()[i].equals(fruitsExpected[i]));
		}
    }


	@Test
    public void testDeleteIgnoreCaseByDeletingLast() {
    	// why not this: String[] fruits = {"Apple", "Banana", "Kiwi", "Mango", "Orange"};
	// IT LOOKS THE SAME FOR ME. IT'S JUST A SHORTCUT SINTAX.
        String[] fruits = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango"), new String("Orange")};
        FruitArray fruitArray = new FruitArray(fruits);    
        
        fruitArray.delete(new String("orangE"));
        String[] fruitsExpected = {new String("Apple"), new String("Banana"), new String("Kiwi"), new String("Mango")};

        
        assertEquals("The size of the FruitArray object is unexpected.", fruitArray.getSize(), fruitsExpected.length);
        assertEquals(fruitArray.getCapacity(), fruitsExpected.length + 1);
        // why not assertArrayEquals( ... )
        // I DID NOT FIND TWO STRING ARRAY COMPARISON FUNCTION IN CLASS ASSERT.
        // MEANING THERE IS NO METHOD LIKE THIS:
        // assertArrayEquals(java.lang.String message, String[] expecteds, String[] actuals)
        // REFERED TO: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
		for (int i = 0; i < fruitsExpected.length; i++) {
			assertTrue(fruitArray.getFruitsAsArray()[i].equals(fruitsExpected[i]));
		}
    }     
    
}
