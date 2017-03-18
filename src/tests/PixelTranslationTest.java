package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.PixelMatrix;

/*
 * PixelTranslationTest.java - a testClass that checks the ability of an escape method to translate the x and y coordinates of the matrix to the x and y coordinates on the Cartesian Plane
 * @author Brett Baker
 */

public class PixelTranslationTest {
	
	/*
	 * create an instance of the matrix painting class
	 */
	PixelMatrix _canvas;
	
	/*
	 * a test that checks if the value of a random chosen x and y coordinate matches the calculated value
	 */
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512,512);
		_canvas.setEscapeDistance(2);
		int[][] constant = _canvas.mandelbrotEscapes(255,-2.15,.6,-1.3,1.3);
		
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
