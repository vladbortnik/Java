package edu.cuny.brooklyn.cisc3120.simpleeditor.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleEditor {
    private final static int BUFFER_SIZE = 1024000;
    private static char [] buffer = new char [BUFFER_SIZE];

    
    /*
     * "
     *    Programmers are not to be measured by their ingenuity and their logic but by 
     *    the completeness of their case analysis.
     *                    -- Alan Perlis
     * " 
     * 
     * 
     * Problem: If content changed, then notify a user before the user
     *      - closes this file,
     *      - open a new file
     *      - exit the app
     *     Otherwise, the user loses the changes made to the file. This reasoning may be incomplete.
     * 
     * Solution: we can model the application logic with a state machine (to reason with discipline)
     * 
     * State:  (), (changed), (unchanged), (data lose), ((no data lose))
     *         state in (( )) is designated as desired final state.
     *         state "()" indicates a special state that the program has not stated yet.
     * Action: [app starts], 
     *         [create a new file], 
     *         [open a file], 
     *         [close the file], 
     *         [save the file], 
     *         [edit content], 
     *         [app exits from the menu],
     *         [app exits from "x" button],
     *         [app exits unexpectedly]  
     * Transition: expressed in arrow -->, indicates state change, triggered by an action. We
     *         use this format
     *            (state 1)--[action]-->(state 2)
     *            
     * When at a state, test whether an action can be applied. For instance when at the "()" state, only
     * the [app starts] action can be applied.
     * 
     *             (open a file)                   [app exits unexpectedly]
     *           (create a new file)              [app exits from "x" button]
     *                      +---+   +--------------[app exits from the menu]------------->((no data lose))
     *                      |   |  / .
     *                      V   | /.
     * ()--[app starts]-->(unchanged)--[edit content]-->(changed)--[app exits unexpectedly]-->(data lose)      
     *                      ^                             /|
     *                      |                            / | 
     *                      +----(save the file)--------+  |  
     *                      |                              |    
     *                      +-----------[close the file]---+    
     * 
     * This belongs to application logic. It should be implemented in the model. In this version,
     * unfortunately only part of the logic is in this model (editorContentChanged).
     */
    private boolean editorContentChanged;
    
    private File theFile;
    
    public SimpleEditor() {
        editorContentChanged = false;
        theFile = null;
    }
    
    public File getTheFile() {
        return theFile;
    }

    public void setTheFile(File theFile) {
        this.theFile = theFile;
    }

    public String readFile() throws FileNotFoundException, IOException {
        // TODO: task 1
    		FileReader inputStream = null;
    		inputStream = new FileReader(this.getTheFile());
    		
    		int c;
    		int i = 0;
        while ((c = inputStream.read()) != -1) {
        		   buffer[i] = (char) c;
        		   i++; 
        }
        
        while(i<BUFFER_SIZE) {
        		buffer[i] = ' ';
        		i++;
        }
        
        String html = new String(buffer);
    		inputStream.close();
    		return html;    		
    }
    		
    	

    
    public void setEditorContentChanged(boolean changed) {
        editorContentChanged = changed;
    }
    
    public boolean isEditorContentChanged() {
        return editorContentChanged;
    }

    public void saveTheFile(String htmlText) throws FileNotFoundException, IOException {
        // TODO: task 2
    		FileWriter outputStream = null;
    		
    		outputStream = new FileWriter(this.getTheFile());
    		outputStream.write(htmlText);
    		outputStream.flush();
    		outputStream.close();

    	
    }
    
    
    
    
    
    
    
    
    
}
