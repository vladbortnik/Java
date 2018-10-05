package edu.cuny.brooklyn.cisc3120.project.randomintegers;

import java.util.Random;

public class RandomInteger {
	
	int rand;
	
	public RandomInteger() {
		Random rand = new Random();
       	this.rand = rand.nextInt(100);
	}
	
	int getRandom() {
		return rand;
	}
	


}	
