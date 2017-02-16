package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

// import [insert name of code package].[insert name of matrix building class]*/;

public class MatrixTest {
	
	/* This code assumes that the class that will build the matrix will contain a method that will
	 * take two arguments, one to designate the matrix' length, and one to designate its width.
	 * If you guys need me to change something to work with the matrix builder that hasn't been written
	 * yet just text me. I'll check up before the week is over to make sure it works once the
	 * builder class has been written.
	 * 
	 * There are several lines of code that cause errors now, but will work once the builder class has
	 * been written. Those lines of code will be commented out until then.
	 */
	
	int matrixRows;
	int matrixColumns;
	int[][] canvas;
	
	@Test
	public static void correctNumberOfRows() {
		matrixRows = 1;
		matrixColumns = 179;
		
		/// nombc stands for "name of matrix building class ; bm stands for "builder method"
		
	///	canvas = [insert nombc here].[insert bm name here](matrixRows,matrixColumns);
	///	assertEquals(matrixRows,canvas.length);
	}
	
	@Test
	public static void correctNumberOfColumns() {
		matrixRows = 37;
		matrixColumns = 3;
		
		/// nombc stands for "name of matrix building class ; bm stands for "builder method"
		
	///	canvas = /*insert nombc here*/./*insert bm name here*/(matrixRows,matrixColumns);
	///	assertEquals(matrixRows,canvas[0].length);
	}
	
	@Test
	public static void negativeSize() {
		matrixRows = 12;
		matrixColumns = -5;
		
		/* this method assumes that, if the builder is given a negative number, it will
		 * negate it
		 */
		
		/// nombc stands for "name of matrix building class ; bm stands for "builder method"
		
	///	canvas = /*insert nombc here*/./*insert bm name here*/(matrixRows,matrixColumns);
	///	assertEquals(matrixRows,(canvas[0].length * -1));
	}
	
	@Test
	public static void zeroSize() {
		matrixRows = 0;
		matrixColumns = 179;
		
		/// nombc stands for "name of matrix building class ; bm stands for "builder method"
		
	///	canvas = [insert nombc here].[insert bm name here](matrixRows,matrixColumns);
	///	assertEquals(matrixRows,canvas.length);
	}
}
