package edu.buffalo.cse116;

import java.awt.image.IndexColorModel;

import edu.buffalo.fractal.FractalPanel;

public class FractalCanvas extends FractalPanel {
	
	/**
	 * 
	 */
	int[][] _e; 
	IndexColorModel _c;
	private static final long serialVersionUID = 1L;
	
	public FractalCanvas(){
		
	}

	public FractalCanvas(int[][] e, IndexColorModel c) {
		_e = e;
		_c = c;
		updateImage(_e);
		setIndexColorModel(_c);
	}
	
	public void setFractal(int[][] inFrac){
		_e = inFrac;
	}
	public void setColor(IndexColorModel c){
		_c = c;
	}
	
	public void updateCanvas(){
		if(_e != null){
		updateImage(_e);
		}
		if(_c != null){
		setIndexColorModel(_c);
		}
	}
	
}
