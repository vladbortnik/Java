package edu.cuny.brooklyn.cisc3120.ShapeObjects;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
	
	@Override
	public int compare(Shape lhs, Shape rhs) {
		if (lhs.area() > rhs.area()) {
			return 1;
		} else if (lhs.area() < rhs.area()) {
			return -1;
		} else {
			return 0;
		}
	}

}
