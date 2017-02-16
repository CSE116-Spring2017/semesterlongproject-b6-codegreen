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
}
