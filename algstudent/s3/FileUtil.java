package util;

import java.io.*;
import java.util.*;


public abstract class FileUtil {
	
public static int loadFile (String fileName, List<Object> players) {
		
	    String line;
	    String[] productData= null;
	    int numPlayers = 0;
	    
	    try {
	    	   BufferedReader file = new BufferedReader(new FileReader(fileName));
	    	   line = file.readLine();
	    	   numPlayers = Integer.parseInt(line);
	    		while (file.ready()) {
	    			line = file.readLine();
	    			players.add(line);
	    		}
	    		file.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("File not found.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("I/O Error.");
	    } 
	    return numPlayers;
	  }
	
	
}
