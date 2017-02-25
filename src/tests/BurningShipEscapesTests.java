package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

/*
 * a class that checks all of the testable properties of the burningShipEscapes method
 * @author Ethan Armbrust
 */

public class BurningShipEscapesTests {
	
	/*
	 * create an instance of the matrix painting class
	 */
	PixelMatrix _canvas;
	
	/*
	 * a test that checks for any occurrences of zero or one in the bSE matrix
	 */
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
				//System.out.print(escapes[x][y] + " ");
			}
			//System.out.println("");
		}
		
		assertFalse(badValue);
		
		}
	
	/*
	 * a test that checks if the value of a random chosen x and y coordinate matches the calculated value
	 */
	@Test
	public void pixelCoordinateTranslation() {
		double dist = 0.0;
		int passes = 0;
		_canvas = new PixelMatrix(512,512);
		int[][] constant = _canvas.burningShipEscapes(2,255,-2.15,.6,-1.3,1.3);
		
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
	
	/*
	 * finds a point whose escape time is the maximum value
	 */
	@Test
	public void maxEscapeTime() {
		int[] xy = new int[2];
		_canvas = new PixelMatrix(512,512);
		int[][] testGrid = _canvas.burningShipEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		for (int i=0;i<testGrid.length;i++) {
			for (int j=0;j<testGrid[0].length;j++) {
			//	System.out.print(testGrid[i][j] + " ");
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
		int[][] testGrid = _canvas.burningShipEscapes(2.0,255,-2.15,.6,-1.3,1.3);
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
		int[][] burningShipPaint = _canvas.burningShipEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		assertEquals(burningShipPaint.length,512);
	}
	
	/*
	 * a test that checks the width of the matrix is correct
	 */
	@Test
	public void correctWidth() {
		_canvas = new PixelMatrix(512,512);
		int[][] burningShipPaint = _canvas.burningShipEscapes(2.0,255,-2.15,.6,-1.3,1.3);
		assertEquals(burningShipPaint[0].length,512);
	}
}
