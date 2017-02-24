package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.PixelMatrix;

public class BurningShipEscapesTests {
	
	PixelMatrix _canvas;
	
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
