package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.PixelMatrix;

public class BurningShipEscapesTests {
	
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
		int[][] constant = _canvas.juliaEscapes(255, -1.7, 1.7, -1.0, 1.0);

		double xStep = (1.7 - (-1.7)) / 2048;
		double yStep = (1.0 - (-1.0)) / 2048;

		double xCalc = -1.7 + (0 * xStep); // 45
		double yCalc = 1.0 - (0 * yStep); // and 23 are here, is this just to
											// show how the random point is
											// calculated?

		dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));

		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + -0.72689;
			yCalc = 2 * tempX * tempY  + 0.188887;

			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		//System.out.println(passes + " " + constant[0][0]);

		// point (0,0)
		assertEquals(constant[0][0], passes);
	}
	
	
	@Test
	public void pixelCoordinateTranslation2() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(2048, 2048);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.juliaEscapes(255, -1.8, 1.7, -0.08, 0.025);

		double xStep = (1.7 - (-1.8)) / 2048;
		double yStep = (0.025 - (-0.08)) / 2048;

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
		//System.out.println(passes + " " + constant[45][23]);

		// random point (x, y)
		assertEquals(constant[176][90], passes);
	}
	
	@Test
	public void pixelCoordinateTranslation3() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(2048, 2048);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.juliaEscapes(255, -1.8, 1.7, -0.08, 0.025);

		double xStep = (1.7 - (-1.8)) / 2048;
		double yStep = (0.025 - (-0.08)) / 2048;

		double xCalc = -1.8 + (2048 * xStep); 
		double yCalc = 0.025 - (2048 * yStep);
		
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
		//System.out.println(passes + " " + constant[511][511]);

		// point (2048, 2048)
		assertEquals(constant[2044][2044], passes);
	}
	
	@Test
	public void noZeroOrOne() {
		PixelMatrix p = new PixelMatrix(2048,2048);
		p.setEscapeDistance(2);
		int[][] escapes = p.burningShipEscapes(255, -1.8, -1.7, -0.08, 0.025);
		boolean badValue = false;
		
		for(int x = 0; x < escapes.length; x++){
			for(int y = 0; y < escapes[0].length; y++){
				if(escapes[x][y] == 0 || escapes[x][y] == 1){
					badValue = true;
					//System.out.print(escapes[x][y] + " ");
				}
				//System.out.print(escapes[x][y] + " ");
			}
			//System.out.println("");
		}
		
		assertFalse(badValue);
		
		}
	

	@Test
	public void newPhaseTwoTest(){
		PixelMatrix p = new PixelMatrix(2048,2048);
		p.setEscapeDistance(3);
		int[][] escapes = p.burningShipEscapes(255, -1.8, -1.7, -0.08, 0.025);
		
		if(escapes[2044][1620] >= 10){
			assertTrue(true);
		}
		else{
			//System.out.println(escapes[511][405]);
			assertTrue(false);
		}
	}
	
	@Test
	public void phaseThreeEDTest() {
		PixelMatrix px = new PixelMatrix(2048,2048);
		px.setEscapeDistance(2);
		int[][] constant = px.burningShipEscapes(135, -1.8, -1.7, -0.08, 0.025);
		assertEquals(constant[1140][1220],135);
	}
	
}
