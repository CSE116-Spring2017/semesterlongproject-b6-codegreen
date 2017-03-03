package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

public class BurningShipEscapesTests {
	
	PixelMatrix _canvas;
	
	/*
	 * A series of tests that checks if the value of a random chosen x and y coordinate
	 * matches the calculated value
	 */
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.juliaEscapes(2, 255, -1.8, 1.7, -0.08, 0.025);

		double xStep = (1.7 - (-1.8)) / 512;
		double yStep = (0.025 - (-0.08)) / 512;

		double xCalc = -1.8 + (0 * xStep); 
		double yCalc = 0.025 - (0 * yStep); 

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = Math.abs(2*tempX*tempY) + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[0][0]);

		// point (0,0)
		assertEquals(constant[0][0], passes);
	}
	
	@Test
	public void pixelCoordinateTranslation2() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.juliaEscapes(2, 255, -1.8, 1.7, -0.08, 0.025);

		double xStep = (1.7 - (-1.8)) / 512;
		double yStep = (0.025 - (-0.08)) / 512;

		double xCalc = -1.8 + (45 * xStep); 
		double yCalc = 0.025 - (23 * yStep); 

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = Math.abs(2*tempX*tempY) + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[45][23]);

		// random point (x, y)
		assertEquals(constant[45][23], passes);
	}
	
	@Test
	public void pixelCoordinateTranslation3() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512, 512);
		int[][] constant = _canvas.juliaEscapes(2, 255, -1.8, 1.7, -0.08, 0.025);

		double xStep = (1.7 - (-1.8)) / 512;
		double yStep = (0.025 - (-0.08)) / 512;

		double xCalc = -1.8 + (512 * xStep); 
		double yCalc = 0.025 - (512 * yStep);
		
		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			double origX = xCalc;
			double origY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + origX;
			yCalc = Math.abs(2*tempX*tempY) + origY;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[511][511]);

		// point (512, 512)
		assertEquals(constant[511][511], passes);
	}
	
	@Test
	public void noZeroOrOne() {
		PixelMatrix p = new PixelMatrix(512,512);
		int[][] escapes = p.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025);
		boolean badValue = false;
		
		for(int x = 0; x < escapes.length; x++){
			for(int y = 0; y < escapes[0].length; y++){
				if(escapes[x][y] == 0 || escapes[x][y] == 1){
					badValue = true;
				}
				System.out.print(escapes[x][y] + " ");
			}
			System.out.println("");
		}
		
		assertFalse(badValue);
		
		}
	
}
