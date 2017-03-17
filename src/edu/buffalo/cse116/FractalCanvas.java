package edu.buffalo.cse116;

import java.awt.image.IndexColorModel;

import edu.buffalo.fractal.FractalPanel;

public class FractalCanvas extends FractalPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FractalCanvas(int[][] e, IndexColorModel c) {
		updateImage(e);
		setIndexColorModel(c);
	}
}
