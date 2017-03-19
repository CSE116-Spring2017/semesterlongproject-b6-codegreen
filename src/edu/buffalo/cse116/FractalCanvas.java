package edu.buffalo.cse116;

import java.awt.image.IndexColorModel;

import edu.buffalo.fractal.FractalPanel;

public class FractalCanvas extends FractalPanel {
	/*
	 * This class is extneds of FractalPanel which makes this class to work on
	 * with IdexColorModel input. it will draw the pictures on the window frame.
	 * 
	 * @author Brett Baker
	 * */
	int[][] _e; 
	IndexColorModel _c;
	private static final long serialVersionUID = 1L;
	
	public FractalCanvas(){
		
	}
	/*
	 * @param e
	 * 			declared to be used as 2D-array for updateImage
	 * @param c
	 * 			declared to be used as method call for setIndexColorModel
	 * @return updateImage with _e & setIndexColorModel _c.
	 * */

	public FractalCanvas(int[][] e, IndexColorModel c) {
		_e = e;
		_c = c;
		updateImage(_e);
		setIndexColorModel(_c);
	}
	/*
	 * setFractal's size 
	 * @param inFrac
	 * 			inFrac will take the input and set as _e
	 * */
	public void setFractal(int[][] inFrac){
		_e = inFrac;
	}
	/*
	 * @param c
	 * 			c will take the input and set as _c
	 * */
	public void setColor(IndexColorModel c){
		_c = c;
	}
	/*
	 * update the canvas in the condition of when _e and _c is not null.
	 * */
	public void updateCanvas(){
		if(_e != null){
		updateImage(_e);
		}
		if(_c != null){
		setIndexColorModel(_c);
		}
	}
	
}
