package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

import edu.cuny.brooklyn.cisc3120.project.game.GameBoard;

public class Rifle extends Gun {
	private int radius = 7;
	
	GameBoard board;
	
	private int xGuess, yGuess; 
	
	public Rifle(GameBoard board){
		this.board = board;
	}

	@Override
	public void shoot(int xGuess, int yGuess) {
		this.xGuess = xGuess;
		this.yGuess = yGuess;
		for (int i = -radius; i<=radius; i++) {
			for (int j = -radius; j<=radius; j++) {
				if (!board.outOfRange(i + xGuess, j + yGuess) && (i * i + j * j<=radius * radius)) {
					if(board.getCell(i + xGuess, j + yGuess) != 'X') {
						board.setCell(i + xGuess, j + yGuess, '.');
					}			
				}
			}
		}
	}
	
	
	@Override
	public boolean withinShootingArea() {
		for (int i = -radius; i<=radius; i++) {
			for (int j = -radius; j<=radius; j++) {
				if (!board.outOfRange(i + xGuess, j + yGuess) && (i * i + j * j<=radius * radius) && board.getCell(i + xGuess, j + yGuess) == 'X') {
					return true;
				}
			}
		}
		return false;
	}
}

