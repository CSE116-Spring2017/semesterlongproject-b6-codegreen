package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

/*
 * A class that tests for coordinates with the maximum and minimum escape times
 * @author Brett Baker
 */

public class MandelbrotEscapesTest {
	
	/*
	 * create an instance of the matrix painting class
	 */
	PixelMatrix _canvas;
	
	/*
	 * finds a point whose escape time is the maximum value
	 */
	@Test
	public void maxEscapeTime() {
		int[] xy = new int[2];
		_canvas = new PixelMatrix(512,512);
		int[][] testGrid = _canvas.mandelbrotEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		for (int i=0;i<testGrid.length;i++) {
			for (int j=0;j<testGrid[0].length;j++) {
				System.out.print(testGrid[i][j] + " ");
				if (testGrid[i][j] == 255) {
					xy[0] = i;
					xy[1] = j;
				}
			}
			System.out.println("");
		}
		assertEquals(testGrid[xy[0]][xy[1]],255);
	}
	
	/*
	 * finds a point whose escape time is the minimum value
	 */
	@Test
	public void minEscapeTime() {
		int[] xy = new int[2];
		_canvas = new PixelMatrix(512,512);
		int[][] testGrid = _canvas.mandelbrotEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		for (int i=0;i<testGrid.length;i++) {
			for (int j=0;j<testGrid[0].length;j++) {
				if (testGrid[i][j] == 1) {
					xy[0] = i;
					xy[1] = j;
				}
			}
		}
		assertEquals(testGrid[xy[0]][xy[1]],1);
	}
}
