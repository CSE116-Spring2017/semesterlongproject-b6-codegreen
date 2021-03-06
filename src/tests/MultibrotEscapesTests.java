package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.PixelMatrix;

public class MultibrotEscapesTests {
	
	PixelMatrix _canvas;
	
	/*
	 * A series of tests that checks if the value of a random chosen x and y coordinate
	 * matches the calculated value
	 */
	
	@Test
	public void pixelCoordinateTranslationTest1() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(2048, 2048);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.multibrotEscapes(255,-1,1,-1.3,1.3);

		double xStep = (1 - (-1)) / 2048;
		double yStep = (1.3 - (-1.3)) / 2048;

		double xCalc = -1 + (0 * xStep); 
		double yCalc = 1.3 - (0 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX * tempX) - (3* tempX * tempY * tempY) + tempX;
			yCalc = ((3 * tempX * tempX * tempY) - (tempY * tempY * tempY));

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
		_canvas = new PixelMatrix(2048, 2048);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.multibrotEscapes(255,-1,1,-1.3,1.3);

		double xStep = (1 - (-1)) / 2048;
		double yStep = (1.3 - (-1.3)) / 2048;

		double xCalc = -1 + (45 * xStep); 
		double yCalc = 1.3 - (23 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX * tempX) - (3* tempX * tempY * tempY) + tempX;
			yCalc = ((3 * tempX * tempX * tempY) - (tempY * tempY * tempY));

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[45][23]);

		//random point (x, y)
		assertEquals(constant[180][92],passes);
	}
	
	@Test
	public void pixelCoordinateTranslationTest3() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(2048, 2048);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.multibrotEscapes(255,-1,1,-1.3,1.3);

		double xStep = (1 - (-1)) / 2048;
		double yStep = (1.3 - (-1.3)) / 2048;

		double xCalc = -1 + (2048 * xStep); 
		double yCalc = 1.3 - (2048 * yStep);

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX * tempX) - (3* tempX * tempY * tempY) + tempX;
			yCalc = ((3 * tempX * tempX * tempY) - (tempY * tempY * tempY));

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		System.out.println(passes + " " + constant[511][511]);

		//point (2048, 2048)
		assertEquals(constant[2044][2044],passes);

	}
	
	
	@Test
	public void newPhaseTwoTest(){
		PixelMatrix p = new PixelMatrix(2048,2048);
		p.setEscapeDistance(3);
		int[][] escapes = p.multibrotEscapes(255, -1, 1, -1.3, 1.3);
		
		if(escapes[1736][588] >= 10){
			assertTrue(true);
		}
		else{
		
			assertTrue(false);
		}
	}
	
	@Test
	public void phaseThreeEDTest() {
		PixelMatrix px = new PixelMatrix(2048,2048);
		px.setEscapeDistance(2);
		int[][] constant = px.multibrotEscapes(135, -1, 1, -1.3, 1.3);
		assertEquals(constant[1624][832],135);
	}
}