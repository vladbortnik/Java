package edu.cuny.brooklyn.cisc3120.project.game;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class TargetGameLauncher 
{
	public static void main(String[] args)
    {
		CommandLineParser parser = new DefaultParser();
    		int boardWidth=80, boardHeight=25, gameLevel=1;
    	
    		Options options=new Options();
    		options.addOption("w","width", true, "board width");
    		options.addOption("h","height", true, "board height");
    		options.addOption("l","level", true, "game level");

		try {
			CommandLine line = parser.parse(options, args);
			boardWidth = Integer.parseInt(line.getOptionValue("w", "80"));
			boardHeight = Integer.parseInt(line.getOptionValue("h", "25"));
			gameLevel = Integer.parseInt(line.getOptionValue("l", "1"));	
			
		} catch (ParseException exp) {
			System.out.println(exp.getMessage());
		}
		
		TargetGame game = new TargetGame(boardWidth, boardHeight, gameLevel);
        game.play();
    }
}
