package edu.cuny.brooklyn.cisc3120.project.game.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TargetGame {
    private static Logger LOGGER = LoggerFactory.getLogger(TargetGame.class);
    
    private final static int GAME_TARGET_AREA_WIDTH = 40;
    private final static int GAME_TARGET_AREA_HEIGHT = 40;
    private final static char TARGET_INDICATOR_ON_BOARD = 'X';
    
    private boolean gameStateChanged;
    
    private File theGameFile = new File("src/main/resources/statistics.txt");
    private Target target;
    private GameBoard gameBoard;
    private Random rng;
    
    private GameStatistics gameStatistics;

    public TargetGame() {
        gameStateChanged = false;
        gameBoard = new GameBoard(GAME_TARGET_AREA_HEIGHT, GAME_TARGET_AREA_WIDTH);
        rng = new Random();
        target = null;
        gameStatistics = new GameStatistics();
    }
    
    public boolean isGameStateChanged() {
        return gameStateChanged;
    }

    public void setGameStateChanged(boolean gameStateChanged) {
        this.gameStateChanged = gameStateChanged;
    }

    public void saveTheGame() throws FileNotFoundException, IOException {			// VLAD FUNCTION
        // TODO Auto-generated method stub
    	
		List<Integer> intList = new LinkedList<Integer>();
		intList.add(this.getGameStatistics().getNumOfTargetsShot());
		intList.add(this.getGameStatistics().getNumOfShotsFired());
		intList.add(this.getGameStatistics().getNumOfTargetsMade());
		intList.add(this.getGameStatistics().getNumOfRoundsWon());
		intList.add(this.getGameStatistics().getNumOfRoundsPlayed());
			
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(theGameFile))) {
            intList.forEach(n -> {
                String fmt = n instanceof Integer ? "%d\n" : "%f\n";
                writer.format(Locale.getDefault(), fmt, n);
            });

		} catch(FileNotFoundException e) {
			LOGGER.debug("statistics.txt - not found.");
		}   
    }

    public File getTheGameFile() {
        return theGameFile;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Target getTarget() {
        return target;
    }
    
    public void setNewTarget() {
        target = getRandomTarget();
        addTargetToBoard(target);
    }

    private Target getRandomTarget() {
        int x = rng.nextInt(GAME_TARGET_AREA_WIDTH);
        int y = rng.nextInt(GAME_TARGET_AREA_HEIGHT);
        Target target = new Target(x, y);
        LOGGER.debug("Target: " + x + "," + y);
        return target;
    }

    private void addTargetToBoard(Target target) {
        gameBoard.setCell(target.getX(), target.getY(), TARGET_INDICATOR_ON_BOARD);
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }    
}
