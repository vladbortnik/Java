package edu.cuny.brooklyn.cisc3120.project.game;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuny.brooklyn.cisc3120.project.game.Target.PointTargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.RectangleTargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.TargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.TriangleTargetShape;

public class TargetGame {
	private static Logger logger = LoggerFactory.getLogger(TargetGame.class);
	
	private final int GAME_TARGET_AREA_WIDTH = 80;
	private final int GAME_TARGET_AREA_HEIGHT = 25;

	GameBoard gameBoard;      // having its own dimension: cells
	GameDisplay gameDisplay;  // having its own dimension: cells to characters
	private Random rng;
	private Scanner in;
	
	public TargetGame() {
		gameBoard = new GameBoard(GAME_TARGET_AREA_HEIGHT, GAME_TARGET_AREA_WIDTH);
		gameDisplay = new GameDisplay(gameBoard);
		rng = new Random();
		in = new Scanner(System.in);
		in.useDelimiter("(\\p{javaWhitespace}|,)+");
	}
	
	public void play() {
		boolean won = false;
		
		int x = rng.nextInt(3);								// THIS IS TO CHOOSE RANDOM TARGET SHAPE.
		if(x==2) setTarget(new TriangleTargetShape());
		else if(x==1) setTarget(new RectangleTargetShape());
		else setTarget(new PointTargetShape());
		
		gameBoard.plotBorder();
		gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT-1, "Enter your target position (x, y):");
		while(!won) {
			gameDisplay.draw();

			int xGuess = in.nextInt();
			int yGuess = in.nextInt();
			logger.debug("Player guessed x = " + xGuess + ", y =" + yGuess + ".");
			if (targetHit(xGuess, yGuess)) {
				gameBoard.plotBorder();
				gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT-1, "You won. Game over.");
				won = true;
			} else {
				gameBoard.plotBorder();
				gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT-1,"Try again. Enter your target position (x, y): ");
			}
			gameDisplay.draw();
		}
	}
	
	private void setTarget(TargetShape target) {
		int y = rng.nextInt(GAME_TARGET_AREA_WIDTH - 24) + 2;
		int x = rng.nextInt(GAME_TARGET_AREA_HEIGHT - 24) + 2;
		gameBoard.setTarget(x, y, target);
		logger.debug("Target: " + x + "," + y);
	}
	
	private boolean targetHit(int xGuess, int yGuess) {
		return gameBoard.getCell(xGuess, yGuess) == 'X';
	}
}
