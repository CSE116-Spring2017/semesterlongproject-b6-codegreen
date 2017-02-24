package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

/*  test runs for horizontal and vertical coordinates with min & max escape duration
 * @author Yongbong Kwon
 *  
 */
public class JuliaEscapesTest {

	/*
	 * create an instance of the matrix painting class
	 *
	 */
	PixelMatrix _canvas;
	
	/*
	 * finds a point whose escape time is the maximum value
	 */
	@Test
	public void maxEscapeTime() {
		int[] xy = new int[2];
		_canvas = new PixelMatrix(512,512);
		int[][] testGrid = _canvas.juliaEscapes(2, 255, -1., 1.7, -1.0, 1.0);
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
		int[][] testGrid = _canvas.juliaEscapes(2, 255, -1., 1.7, -1.0, 1.0);
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
