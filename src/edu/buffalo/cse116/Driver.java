package edu.buffalo.cse116;

//driver will control execute the UI class.
/*@author Yongbong Kwon
* @param 	
* 			visualize and execute UI class.
*  
* */
public class Driver {
	
	public static void main(String[] args) {
		
		new UI();
		/* Notice that the Model will finish initializing first before the UI's constructor is even called.
		 * This means we'll be safe to call methods on the Model in the UI right away. */
	
	}

}
