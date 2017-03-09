package edu.buffalo.cse116.;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;
import model.*;
import observer_pattern.*;

public class FractalGUI implements Observer {
	
	Model _model;
	
	// UI elements
	JFrame _window;
	JPanel _mainPanel;
	
	JPanel _buttonGrid;
	static int ROWS = 4;
	static int COLUMNS = 5;
	static int BUTTON_SIZE = 40;
	
	public FractalGUI(PixelMatrix m) {
		
		// Keep a permanent reference to the Model in order to notify it of user input
		_model = m;
		
		/* The UI is taking care of itself here - it's making sure the model
		 * will know to call it when it's time for visual updates. */
		_model.addObserver(this);
		
		// Perform some setup tasks that only need to be done once.
		initialize();
		
		// Bring the UI to a ready state.
		update();
	}
	
	//Yong please. just please lol
	public void initialize() {
		
		_window = new JFrame();
		
		// Give the main panel two sections (two rows, one column)
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new GridLayout(3, 1));
		
		// Set up the JPanel and GridLayout where the grid of buttons will go
		_buttonGrid = new JPanel();
		_buttonGrid.setLayout(new GridLayout(ROWS, COLUMNS));
		
		_mainPanel.add(_buttonGrid);
		
		JButton increase = new JButton("Increase Numbers");
		increase.addActionListener(new NumberButtonHandler(_model));
		_mainPanel.add(increase);
		
		JButton thickness = new JButton("Increase Thickness");
		
		/* Here I'm using an anonymous inner class. Notice that I still have access to UI's instance variables. 
		 * Doing this is much more convenient than creating a whole separate class and setting up an association 
		 * relationship with UI. */
		thickness.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_model.increaseBorderThickness();
			}
		});
		_mainPanel.add(thickness);
		
		// Final steps to display the window
		_window.setContentPane(_mainPanel);
		_window.setVisible(true);
		
	}

	
	/** Change information displayed on the UI based on what has changed in the Model.*/
	@Override
	public void update() {
		FractalPanel magic = new FractalPanel();
		magic.updateImage(_model.mandelbrotEscapes);
		
	}
	/**	
		// Update the button grid
		_buttonGrid.removeAll();
		
		int num = _model.getNumber();
		for (int i = 0; i < ROWS * COLUMNS; i++) {
			JButton b = new JButton();
			b.setText("" + num);
			int t = _model.getBorderThickness();
			b.setBorder(BorderFactory.createMatteBorder(t, t, t, t, Color.BLUE));
			b.setPreferredSize(new Dimension((int) (BUTTON_SIZE * 1.6), BUTTON_SIZE));
			
			_buttonGrid.add(b);
			
			b.setOpaque(true);	// this is necessary to back the background color visible
			if (num % 3 == 0) { // if the button's number is divisible by three, make it red
				b.setBackground(Color.RED);
			} else {
				b.setBackground(Color.GREEN);
			}
			
			num++;
		}
		
		// This is necessary to actually see the changes that have been made
		_window.pack();
	}**/
}
