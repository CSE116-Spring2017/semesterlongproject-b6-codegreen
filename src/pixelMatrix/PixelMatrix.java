package pixelMatrix;

public class PixelMatrix {
	
	/*
	 * note from Brett: I added the if statements in the class definition because I think that
	 * the definition failed  my negative number test and I added the method giveGrid so that I 
	 * could access the _m variable from my test class
	 */
	
	int[][] _m;
	
	public PixelMatrix(int x, int y){
		if (x<0) {x = x * -1;}
		if (y<0) {y = y * -1;}
		int[][] matrix = new int[x][y];
		_m = matrix;
	}
	
	public int[][] giveGrid() {
		int[][] retVal;
		retVal = _m;
		return retVal;
	}
	
	public int[][] mandlebrotEscapes(int distance, int maxSteps){
		int[][] retVal = new int[_m.length][_m[0].length];
		
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m.length; y++){
				int xCalc = x;
				int yCalc = y;
				
				double dist = Math.sqrt((x*x) + (y*y));
				int passes = 0;
				while(dist <= distance && passes < maxSteps){
					int tempX = xCalc;
					int tempY = yCalc;
					//change these for each different set
					xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
					yCalc = 2 * xCalc * yCalc + tempY;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	
	//:D
	}
	
	 public int[][] juliaEscapes(int distance, int maxSteps){
		int[][] retVal = new int[_m.length][_m[0].length];
		
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m.length; y++){
				double xCalc = x;
				double yCalc = y;
				
				double dist = Math.sqrt((x*x) + (y*y));
				int passes = 0;
				while(dist <= distance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					//change these for each different set
					xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
					yCalc = 2 * xCalc * yCalc + 0.188887;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	
	
	}
	
	 public int[][] burningShipEscapes(int distance, int maxSteps){
			int[][] retVal = new int[_m.length][_m[0].length];
			
			for(int x = 0; x < _m.length; x++){
				for(int y = 0; y < _m.length; y++){
					int xCalc = x;
					int yCalc = y;
					
					double dist = Math.sqrt((x*x) + (y*y));
					int passes = 0;
					while(dist <= distance && passes < maxSteps){
						int tempX = xCalc;
						int tempY = yCalc;
						xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
						yCalc = Math.abs(2*tempX*tempY);
						passes++;
						dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
					}
					retVal[x][y] = passes;
				}
			}
			return retVal;
		}
	
	
}
