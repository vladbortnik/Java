package edu.cuny.brooklyn.cisc3120.project.game.Target;

import java.util.Random;

public class TriangleTargetShape extends TargetShape{
	public TriangleTargetShape() {
		Random rng = new Random();
		int x = rng.nextInt(20) + 1;
//		int y = rng.nextInt(10) + 1;
		int[][] targetCells = new int[x][x];
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				if(x-j>i)
					targetCells[i][j] = 'X';
				else
					targetCells[i][j] = ' ';
			}
		}
		super.setTargetCells(targetCells);
		super.setHeight(x);
		super.setWidth(x);
		

	}
}
