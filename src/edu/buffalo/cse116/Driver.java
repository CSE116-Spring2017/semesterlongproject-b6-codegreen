package edu.buffalo.cse116;

import edu.buffalo.cse116.ui.*;

/**
 * Creates the Model, the UI, and links them together.
 *
 */

public class Driver {
	
	public static void main(String[] args) {
		
		/* Notice that the Model will finish initializing first before the UI's constructor is even called.
		 * This means we'll be safe to call methods on the Model in the UI right away. */
		new FractalGUI(new PixelMatrix());
		
	}

}
