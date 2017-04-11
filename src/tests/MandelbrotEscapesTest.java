package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.PixelMatrix;

/*
 * A class that tests for coordinates with the maximum and minimum escape times
 * @author Brett Baker
 */

public class MandelbrotEscapesTest {

	/*
	 * A series of tests that checks if the value of a random chosen x and y
	 * coordinate matches the calculated value
	 */

	@Test
	public void pixelCoordinateTranslationTest1() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.juliaEscapes(255, -1.7, 1.7, -1.0, 1.0);

		double xStep = (1.7 - (-1.7)) / 512;
		double yStep = (1.0 - (-1.0)) / 512;

		double xCalc = -1.7 + (0 * xStep); // 45
		double yCalc = 1.0 - (0 * yStep); // and 23 are here, is this just to
											// show how the random point is
											// calculated?

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + -0.72689;
			yCalc = 2 * tempX * tempY + 0.188887;

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
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.juliaEscapes(255, -1.7, 1.7, -1.0, 1.0);

		double xStep = (1.7 - (-1.7)) / 512;
		double yStep = (1.0 - (-1.0)) / 512;

		double xCalc = -1.7 + (45 * xStep); // 45
		double yCalc = 1.0 - (23 * yStep); // and 23 are here, is this just to
											// show how the random point is
											// calculated?

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + -0.72689;
			yCalc = 2 * tempX * tempY + 0.188887;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[45][23]);

		// random point (x, y)
		assertEquals(constant[45][23], passes);
	}

	@Test
	public void pixelCoordinateTranslationTest3() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.mandelbrotEscapes(255, -1, 1, -1.3, 1.3);

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
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] testGrid = _canvas.mandelbrotEscapes(255, -2.15, .6, -1.3, 1.3);
		for (int i = 0; i < testGrid.length; i++) {
			for (int j = 0; j < testGrid[0].length; j++) {
				System.out.print(testGrid[i][j] + " ");
				if (testGrid[i][j] == 255) {
					xy[0] = i;
					xy[1] = j;
				}
			}
			System.out.println("");
		}
		assertEquals(testGrid[xy[0]][xy[1]], 255);
	}

	/*
	 * finds a point whose escape time is the minimum value
	 */
	@Test
	public void minEscapeTime() {
		int[] xy = new int[2];
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] testGrid = _canvas.mandelbrotEscapes(255, -1, 1, -1.3, 1.3);
		for (int i = 0; i < testGrid.length; i++) {
			for (int j = 0; j < testGrid[0].length; j++) {
				if (testGrid[i][j] == 1) {
					xy[0] = i;
					xy[1] = j;
				}
			}
		}
		assertEquals(testGrid[xy[0]][xy[1]], 1);
	}

	/*
	 * a test that checks the height of the matrix is correct
	 */
	@Test
	public void correctLength() {
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] mandelbrotPaint = _canvas.mandelbrotEscapes(255, -2.15, .6, -1.3, 1.3);
		assertEquals(mandelbrotPaint.length, 512);
	}

	/*
	 * a test that checks the width of the matrix is correct
	 */
	@Test
	public void correctWidth() {
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] mandelbrotPaint = _canvas.mandelbrotEscapes(255, -2.15, .6, -1.3, 1.3);
		assertEquals(mandelbrotPaint[0].length, 512);
	}

	/*
	 * a test that checks if the value of a random chosen x and y coordinate
	 * matches the calculated value
	 */
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.mandelbrotEscapes(255, -2.15, .6, -1.3, 1.3);

		double xStep = (.6 - -2.15) / 512;
		double yStep = (1.3 - -1.3) / 512;

		double xCalc = -2.15 + (45 * xStep);
		double yCalc = 1.3 - (23 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
			yCalc = 2 * tempX * tempY + tempY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[45][23]);

		assertEquals(constant[45][23], passes);
	}

	@Test
	public void newPhaseTwoTest() {
		PixelMatrix p = new PixelMatrix(512, 512);
		p.setEscapeDistance(3);
		int[][] escapes = p.mandelbrotEscapes(255, -2.15, 0.6, -1.3, 1.3);

		if (escapes[486][189] >= 10) {
			assertTrue(true);
		} else {
			System.out.println(escapes[486][189]);
			assertTrue(false);
		}
	}

	@Test
	public void phaseThreeEDTest() {
		PixelMatrix px = new PixelMatrix(512, 512);
		px.setEscapeDistance(2);
		int[][] constant = px.mandelbrotEscapes(135, -2.15, 0.6, -1.3, 1.3);
		assertEquals(constant[203][483], 135);

	}
}
