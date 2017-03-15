package edu.buffalo.cse116.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import edu.buffalo.cse116.*;

public class ButtonHandler implements ActionListener {

	/* The ButtonHandler needs to have a association relationship with the Model so that it can notify the model
	 * when the button has been pressed. */
	PixelMatrix _model;
	
	public ButtonHandler(PixelMatrix m) {
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}	
	
	//Brett please take over lol
}
