package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

public class MandlebrotEscapesTests {
	
	PixelMatrix _canvas;
	
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512,512);
		int[][] constant = _canvas.mandlebrotEscapes(2,255,-2.15,.6,-1.3,1.3);
		
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