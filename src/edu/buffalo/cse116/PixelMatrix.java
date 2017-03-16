package edu.buffalo.cse116;


public class PixelMatrix {
	
	
	int[][] _m;
	int _xDim;
	int _yDim;
	FractalGUI _observer;
	
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
	
	 /*
	  * a method that returns a matrix of the mandlebrot escape time values
	  * @author Ethan Armbrust
	  * @param maxDistance: distance from the origin that a point will not exceed
	  * @param maxSteps: maximum times the while loop will execute
	  * @param xMin: minimum x coordinate
	  * @param xMax: maximum x coordinate
	  * @param yMin: minimum y coordinate
	  * @param yMax: maximum y coordinate
	  * @return array of escape values
	  */

	public int[][] mandelbrotEscapes(double maxDistance, int maxSteps, double xMin, double xMax, double yMin, double yMax ){
		int[][] retVal = _m;
		
			
		//This needs to be in every set 
		double xStep = (xMax - xMin) / _xDim;
		double yStep = (yMax - yMin) / _yDim;
		
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m[0].length; y++){
				double xCalc = xMin + (x * xStep);
				double yCalc = yMax - (y * yStep);
				double origX = xCalc;
				double origY = yCalc;
				
				double dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));
				int passes = 0;
				while(dist <= maxDistance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					//change these for each different set
					xCalc = (tempX * tempX) - (tempY * tempY) + origX;
					yCalc = 2 * tempX * tempY + origY;
					
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	
	//:D
	}
	 /*
	  * a method that returns a matrix of the Julia escape time values
	  * @author Yongbong Kwon
	  * @param maxDistance: distance from the origin that a point will not exceed
	  * @param maxSteps: maximum times the while loop will execute
	  * @param xMin: minimum x coordinate
	  * @param xMax: maximum x coordinate
	  * @param yMin: minimum y coordinate
	  * @param yMax: maximum y coordinate
	  * @return array of escape values
	  */
	
	 public int[][] juliaEscapes(double maxDistance, int maxSteps, double xMin, double xMax, double yMin, double yMax ){
			int[][] retVal = new int[_m.length][_m[0].length];
			
			double xStep = (xMax - xMin) / _xDim;
			double yStep = (yMax - yMin) / _yDim;
			
			for(int x = 0; x < _m.length; x++){
				for(int y = 0; y < _m[0].length; y++){
					double xCalc = xMin + (x * xStep);
					double yCalc = yMax - (y * yStep);
					
					double dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));
					int passes = 0;
					while(dist <= maxDistance && passes < maxSteps){
						double tempX = xCalc;
						double tempY = yCalc;
						xCalc = (tempX * tempX) - (tempY * tempY) + -0.72689;
						yCalc = 2 * tempX * tempY  + 0.188887;
						
						passes++;
						dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
					}
					retVal[x][y] = passes;
				}
			}
			return retVal;
		}
	 
	 /*
	  * a method that returns a matrix of the burning ship escape time values
	  * @author Brett Baker
	  * @param maxDistance: distance from the origin that a point will not exceed
	  * @param maxSteps: maximum times the while loop will execute
	  * @param xMin: minimum x coordinate
	  * @param xMax: maximum x coordinate
	  * @param yMin: minimum y coordinate
	  * @param yMax: maximum y coordinate
	  * @return array of escape values
	  */
	public int[][] burningShipEscapes(double maxDistance, int maxSteps, double xMin, double xMax, double yMin, double yMax){
		int[][] retVal = new int[_m.length][_m[0].length];
			
		double xStep = (xMax - xMin) / _xDim;
		double yStep = (yMax - yMin) / _yDim;
			
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m[0].length; y++){
				double xCalc = xMin + (x * xStep);
				double yCalc = yMax - (y * yStep);
				double origX = xCalc;
				double origY = yCalc;
				
				double dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));
				int passes = 0;
				while(dist <= maxDistance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					xCalc = (tempX * tempX) - (tempY * tempY) + origX;
					yCalc = Math.abs(2*tempX*tempY) + origY;
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	}
	
	 /*
	  * a method that returns a matrix of the multibrot escape time values
	  * @author Mohammed Sefath Chowdhury
	  * @param maxDistance: distance from the origin that a point will not exceed
	  * @param maxSteps: maximum times the while loop will execute
	  * @param xMin: minimum x coordinate
	  * @param xMax: maximum x coordinate
	  * @param yMin: minimum y coordinate
	  * @param yMax: maximum y coordinate
	  * @return array of escape values
	  */
	public int[][] multibrotEscapes(double maxDistance, int maxSteps, double xMin, double xMax, double yMin, double yMax){
		int[][] retVal = new int[_m.length][_m[0].length];
			
		double xStep = (xMax - xMin) / _xDim;
		double yStep = (yMax - yMin) / _yDim;
			
		for(int x = 0; x < _m.length; x++){
			for(int y = 0; y < _m[0].length; y++){
				double xCalc = xMin + (x * xStep);
				double yCalc = yMax - (y * yStep);
				
				double dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));
				int passes = 0;
				while(dist <= maxDistance && passes < maxSteps){
					double tempX = xCalc;
					double tempY = yCalc;
					xCalc = (tempX * tempX * tempX) - (3* tempX * tempY * tempY) + tempX;
					yCalc = ((3 * tempX * tempX * tempY) - (tempY * tempY * tempY));
					passes++;
					dist = Math.sqrt((xCalc*xCalc) + (yCalc*yCalc));	
				}
				retVal[x][y] = passes;
			}
		}
		return retVal;
	}
	
	public void updateObserver() {
		_observer.update();
	}

	public void addObserver(FractalGUI o) {
		_observer = o;
	}
	
}
