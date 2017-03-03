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
	 * A series of tests that checks if the value of a random chosen x and y coordinate
	 * matches the calculated value
	 */
	
	@Test
	public void pixelCoordinateTranslationTest1() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3);

		double xStep = (.6 - -2.15) / 512;
		double yStep = (1.3 - -1.3) / 512;
		
		double xCalc = -2.15 + (45 * xStep);
		double yCalc = 1.3 - (23 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = 2 * tempX * tempY + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[0][0]);

		// point (0,0)
		assertEquals(constant[0][0], passes);
	}
	
	@Test
	public void pixelCoordinateTranslationTest2() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3);

		double xStep = (.6 - -2.15) / 512;
		double yStep = (1.3 - -1.3) / 512;
		
		double xCalc = -2.15 + (89 * xStep);
		double yCalc = 1.3 - (26 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = 2 * tempX * tempY + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[89][26]);

		// point (89,26)
		assertEquals(constant[89][26], passes);
	}
	
	@Test
	public void pixelCoordinateTranslationTest3() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3);

		double xStep = (.6 - -2.15) / 512;
		double yStep = (1.3 - -1.3) / 512;
		
		double xCalc = -2.15 + (512 * xStep);
		double yCalc = 1.3 - (512 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = 2 * tempX * tempY + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[511][511]);

		// point (512,512)
		assertEquals(constant[511][511], passes);
	}
		
	
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
	
	/*
	 * a test that checks the height of the matrix is correct
	 */
	@Test
	public void correctLength() {
		_canvas = new PixelMatrix(512,512);
		int[][] mandelbrotPaint = _canvas.mandelbrotEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		assertEquals(mandelbrotPaint.length,512);
	}
	
	/*
	 * a test that checks the width of the matrix is correct
	 */
	@Test
	public void correctWidth() {
		_canvas = new PixelMatrix(512,512);
		int[][] mandelbrotPaint = _canvas.mandelbrotEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		assertEquals(mandelbrotPaint[0].length,512);
	}
	
	/*
	 * a test that checks if the value of a random chosen x and y coordinate matches the calculated value
	 */
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512,512);
		int[][] constant = _canvas.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3);
		
		double xStep = (.6 - -2.15) / 512;
		double yStep = (1.3 - -1.3) / 512;
		
		double xCalc = -2.15 + (45 * xStep);
		double yCalc = 1.3 - (23 * yStep);
		
		dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));
		
		while(dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			
			xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
			yCalc = 2 * tempX * tempY + tempY;
			
			passes++;
			dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
		}
		System.out.println(passes+" "+constant[45][23]);
		
		assertEquals(constant[45][23],passes);
	}
}
