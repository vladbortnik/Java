package edu.cuny.brooklyn.cisc3120.project.game;

public class GameDisplay {
	private GameBoard gameBoard;
	
	public GameDisplay(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public void draw() {
		for (int[] row: gameBoard.getBoard()) {
			for (int cell: row) {
				if(!gameBoard.isDifficult())
					System.out.print((char)cell);
				else 
				{
					if(cell == 'X')
						System.out.print(' ');
					else
						System.out.print((char)cell);
				}
			}
			System.out.println();
		}
	}
}
