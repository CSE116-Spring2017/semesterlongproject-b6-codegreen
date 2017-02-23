package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

public class GridSizeTests {
	
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
