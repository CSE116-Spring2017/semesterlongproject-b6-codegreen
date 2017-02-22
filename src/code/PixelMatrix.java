package pixelMatrix;

public class PixelMatrix {
	
	
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
					yCalc = 2 * tempX * tempY + 0.188887;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	
	
	}
	
	public int[][] burningShipEscapes(double distance, double maxSteps, double xMin, double xMax, double yMin, double yMax){
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