package edu.cuny.brooklyn.cisc3120.project.game;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TargetGame {
	private static Logger logger = LoggerFactory.getLogger(TargetGame.class);
	
//	private final int GAME_TARGET_AREA_WIDTH = 80;
//	private final int GAME_TARGET_AREA_HEIGHT = 25;
	private final int NUM_OF_GUESS_TO_DIFFICULT = 3;
	private final int MAXIMUM_GUESS = 5;

	GameBoard gameBoard;      // having its own dimension: cells
	GameDisplay gameDisplay;  // having its own dimension: cells to characters
	private Random rng;
	private Scanner in;
	private int boardWidth;
	private int boardHeight;
	
	public TargetGame(int width, int height, int gameLevel) {
		boardWidth = width;
		boardHeight = height;
		gameBoard = new GameBoard(boardHeight, boardWidth);
		gameBoard.setLevel(gameLevel);
		gameDisplay = new GameDisplay(gameBoard);
		rng = new Random();
		in = new Scanner(System.in);
		in.useDelimiter("(\\p{javaWhitespace}|,)+");
	}
	
	public void play() {
		int guessCounter = 0;
		boolean won = false;
		setTarget();
		gameBoard.plotBorder();
		gameBoard.writeText(0, boardHeight-1, "Enter your target position (x, y):");
		while(!won) {
			if(gameBoard.isDifficult())
				gameBoard.writeText(0, 0, "GAME LEVEL 2 LAUNCHED ");
			else 
				gameBoard.writeText(0, 0, "GAME LEVEL 1 ");
			
			gameDisplay.draw();
			try {
				int xGuess = in.nextInt();
				int yGuess = in.nextInt();
				guessCounter++;
				logger.debug("Player guessed x = " + xGuess + ", y =" + yGuess + ".");
				if (gameBoard.getCell(xGuess, yGuess) == 'X') { 
					gameBoard.plotBorder();
					gameBoard.writeText(0, boardHeight-1, "You won. Game over.");
					won = true;
				} else if(guessCounter < MAXIMUM_GUESS) {
					gameBoard.plotBorder();
					gameBoard.writeText(0, boardHeight-1,"Try again. Enter your target position (x, y): ");
				}else {
					System.out.println("You lost!");
					break;
				}
				if(guessCounter == NUM_OF_GUESS_TO_DIFFICULT) {
					gameBoard.setLevel(2);
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				gameBoard.writeText(0, boardHeight-1, "Invalid input... Please try again!");
			}
			gameDisplay.draw();
		}
	}
	
	private void setTarget() {
		int x = rng.nextInt(boardWidth);
		int y = rng.nextInt(boardHeight);		
		gameBoard.setCell(x, y, 'X');
		logger.debug("Target: " + x + "," + y);	
	}
	
}
