package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

import edu.cuny.brooklyn.cisc3120.project.game.GameBoard;

public class ShotGun extends Gun {
	private int radius = 7;
	GameBoard board;
	private int x;
	private int y;

	public ShotGun(GameBoard board) {
		this.board = board;
	}

	@Override
	public void shoot(int x, int y) {		
		this.x = x;
		this.y = y;
		for (int i = -radius; i<=radius; i++) {
			for (int j = -radius; j<=radius; j++) {
				if (!board.outOfRange(i + x, j + y) && (i * i + j * j <= radius * radius)) {
					if(board.getCell(i + x, j + y) != 'X') {
						board.setCell(i + x, j + y, '.');
					}	
				}
			}
		}
	}

	@Override
	public boolean withinShootingArea() {
		for (int i = -radius; i<=radius; i++) {
			for (int j = -radius; j<=radius; j++) {
				if (!board.outOfRange(i + x, j + y) && (i * i + j * j<=radius * radius) && board.getCell(i + x, j + y) == 'X') {
					return true;
				}
			}
		}
		return false;
	}
}
