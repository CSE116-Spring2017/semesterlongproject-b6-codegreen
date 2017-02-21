package pixelMatrix;

public class PixelMatrix {
	
	/*
	 * note from Brett: I added the if statements in the class definition because I think that
	 * the definition failed  my negative number test and I added the method giveGrid so that I 
	 * could access the _m variable from my test class
	 */
	
	int[][] _m;
	int _xDim;
	int _yDim;
	
	public PixelMatrix(int x, int y){
		if (x<0) {x = x * -1;}
		if (y<0) {y = y * -1;}
		int[][] matrix = new int[x][y];
		_m = matrix;
		_xDim = x;
		_yDim = y;
	}
	
	public int[][] giveGrid() {
		int[][] retVal;
		retVal = _m;
		return retVal;
	}
	// make sure every set has these parameters 
	public int[][] mandlebrotEscapes(double distance, double maxSteps, double xMin, double xMax, double yMin, double yMax ){
		int[][] retVal = new int[_m.length][_m[0].length];
		
			
		//This needs to be in every set 
		double xStep = (xMax - xMin) / _xDim;
		double yStep = (yMax - yMin) / _yDim;
		
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m.length; y++){
				double xCalc = xMin + (x * xStep);
				double yCalc = yMin + (y * yStep);
				
				double dist = Math.sqrt((x*x) + (y*y));
				int passes = 0;
				while(dist <= distance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					//change these for each different set
					xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
					yCalc = 2 * tempX * tempY + tempY;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	
	//:D
	}
	
	 public int[][] juliaEscapes(double distance, double maxSteps, double xMin, double xMax, double yMin, double yMax ){
		int[][] retVal = new int[_m.length][_m[0].length];
		
		double xStep = (xMax - xMin) / _xDim;
		double yStep = (yMax - yMin) / _yDim;
		
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m.length; y++){
				double xCalc = xMin + (x * xStep);
				double yCalc = yMin + (y * yStep);
				
				double dist = Math.sqrt((x*x) + (y*y));
				int passes = 0;
				while(dist <= distance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					xCalc = (tempX * tempX) - (tempY * tempY) + tempX;
					yCalc = 2 * tempX * tempY + tempY;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
		//thx Ethan!
	
	}
	
	 public int[][] burningShipEscapes(int distance, int maxSteps, double xMin, double xMax, double yMin, double yMax){
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
