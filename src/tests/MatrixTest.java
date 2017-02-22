package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

// import [insert name of code package].[insert name of matrix building class]*/;

public class MatrixTest {
	
	/* This code assumes that the class that will build the matrix will contain a method that will
	 * take two arguments, one to designate the matrix' length, and one to designate its width.
	 * If you guys need me to change something to work with the matrix builder that hasn't been written
	 * yet just text me. I'll check up before the week is over to make sure it works once the
	 * builder class has been written.
	 * 
	 * There are several lines of code that cause errors now, but will work once the builder class has
	 * been written. Those lines of code will be commented out until then.
	 */
	
	int _matrixRows;
	int _matrixColumns;
	PixelMatrix _canvas;
	int[][] _grid;
	
	@Test
	public void correctNumberOfRows() {
		_matrixRows = 1;
		_matrixColumns = 179;
		_canvas = new PixelMatrix(_matrixRows,_matrixColumns);
		_grid = _canvas.giveGrid();
		assertEquals(_matrixRows,_grid.length);
	}
	
	@Test
	public void correctNumberOfColumns() {
		_matrixRows = 37;
		_matrixColumns = 3;
		_canvas = new PixelMatrix(_matrixRows,_matrixColumns);
		_grid = _canvas.giveGrid();
		assertEquals(_matrixColumns,_grid[0].length);
	}
	
	@Test
	public void negativeSize() {
		/* this method assumes that, if the builder is given a negative number, it will
		 * negate it
		 */
		_matrixRows = 12;
		_matrixColumns = -5;
		int correctColumns = 5;
		_canvas = new PixelMatrix(_matrixRows,_matrixColumns);
		_grid = _canvas.giveGrid();
		assertEquals(correctColumns,_grid[0].length);
	}
	
	@Test
	public void zeroSize() {
		_matrixRows = 0;
		_matrixColumns = 179;
		_canvas = new PixelMatrix(_matrixRows,_matrixColumns);
		_grid = _canvas.giveGrid();
		assertEquals(_matrixRows,_grid.length);
	}
}
