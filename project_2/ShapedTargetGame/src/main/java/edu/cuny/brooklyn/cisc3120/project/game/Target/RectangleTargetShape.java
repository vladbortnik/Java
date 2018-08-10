package edu.cuny.brooklyn.cisc3120.project.game.Target;

import java.util.Random;

public class RectangleTargetShape extends TargetShape {
	public RectangleTargetShape() {
		Random rng = new Random();
		int x = rng.nextInt(20) + 1;
		int y = rng.nextInt(20) + 1;
		int[][] targetCells = new int[x][y];
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				targetCells[i][j] = 'X';
			}
		}
		super.setTargetCells(targetCells);
		super.setHeight(x);
		super.setWidth(y);
		

	}
}
