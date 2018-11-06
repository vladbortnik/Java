package edu.cuny.brooklyn.cisc3120.ShapeObjects;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShapeSorterTest {
	@Test
	public void testShapeSorterByName() {
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		shapeList.add(new Circle("C123456789", 10.));
		shapeList.add(new Circle("C12345678", 8.));
		shapeList.add(new Circle("C1234567890", 11.));
		shapeList.add(new Rectangle("C12", 10., 80.));
		
		ArrayList<Shape> expectedShapeList = new ArrayList<Shape>();
		expectedShapeList.add(new Rectangle("C12", 10., 80.));
		expectedShapeList.add(new Circle("C12345678", 8.));
		expectedShapeList.add(new Circle("C123456789", 10.));
		expectedShapeList.add(new Circle("C1234567890", 11.));
		
		shapeList.sort(new ShapeNameComparator());
		assertEquals(expectedShapeList, shapeList);
		
	}
	
	@Test
	public void testShapeSorterByArea() {
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		shapeList.add(new Circle("C1", 1));
		shapeList.add(new Circle("C3", 3));
		shapeList.add(new Circle("C2", 2));
		shapeList.add(new Rectangle("R1", 1, 1));
		
		ArrayList<Shape> expectedShapeList = new ArrayList<Shape>();
		expectedShapeList.add(new Rectangle("R1", 1, 1));
		expectedShapeList.add(new Circle("C1", 1));
		expectedShapeList.add(new Circle("C2", 2));
		expectedShapeList.add(new Circle("C3", 3));
		
		shapeList.sort(new ShapeAreaComparator());
		assertEquals(expectedShapeList, shapeList);
		
	}
	
	@Test
	public void testShapeSorterByArea2() {
		ArrayList<Shape> shapeList = new ArrayList<Shape>();
		shapeList.add(new Circle("1", 10));
		shapeList.add(new Circle("30", 30));
		shapeList.add(new Circle("20", 20));
		shapeList.add(new Rectangle("300", 200, 300));
		
		ArrayList<Shape> expectedShapeList = new ArrayList<Shape>();
		expectedShapeList.add(new Circle("1", 10));
		expectedShapeList.add(new Circle("20", 20));
		expectedShapeList.add(new Circle("30", 30));
		expectedShapeList.add(new Rectangle("300", 200, 300));
		
		shapeList.sort(new ShapeAreaComparator());
		assertEquals(expectedShapeList, shapeList);
		
	}
	
}
   