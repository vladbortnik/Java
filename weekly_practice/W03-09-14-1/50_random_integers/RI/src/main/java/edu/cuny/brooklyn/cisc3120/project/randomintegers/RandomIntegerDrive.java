package edu.cuny.brooklyn.cisc3120.project.randomintegers;



public class RandomIntegerDrive 
{
    public static void main( String[] args )
    {
    	
    		RandomInteger rand1 = new RandomInteger();
    		int x = rand1.getRandom();
    	
    		for(int i=0; i<50; i++) {
    			
    			RandomInteger rand2 = new RandomInteger();
    			int y = rand2.getRandom();
    			
    			System.out.println("First is: " + x);
    			System.out.println("Last is: " + y);
    			
    			if(x > y) 
    				System.out.println("First is greater than last");
    			else 
    			{
    				if(x < y)
    					System.out.println("First is smaller than last");
    				else
    					System.out.println("Both are equal");
    			}
    				
    			x = y;
    		
    		}
    		
    }	
}