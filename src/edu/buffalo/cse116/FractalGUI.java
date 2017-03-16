package edu.buffalo.cse116;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.MenuEvent;

import observer_pattern.*;
import edu.buffalo.cse116.PixelMatrix;


public class FractalGUI implements Observer, ActionListener {
	/*----------------||||------------------------------------------||||-------
	 * ---------------||||----under this lane, it is yong's lane----||||-------
	 * ---------------VVVV------------------------------------------VVVV-------*/
	
	PixelMatrix _model = new PixelMatrix(30, 30); 
	// UI elements
	JFrame _window;
	JPanel _mainPanel;	
	JPanel _buttonGrid;
	static int ROWS = 4;
	static int COLUMNS = 5;
	static int BUTTON_SIZE =20;
	
	public FractalGUI(PixelMatrix m){
			JMenuBar menuBar = new JMenuBar(); // menubar FTW yea~
			_window = new JFrame();		
			//file
			JMenu file= new JMenu("File");
			file.addActionListener(this);
			menuBar.add(file);
			//file-open
			JMenuItem open= new JMenuItem("File Open");
			open.addActionListener(this);
			file.add(open);
			//file-close
			JMenuItem close= new JMenuItem("File Close");
			close.addActionListener(this);
			file.add(close);
			
			//Color
			JMenuItem color = new JMenu("Color");
			color.setMnemonic(KeyEvent.VK_R);
			color.addActionListener(this);
			menuBar.add(color);
			//color sets (1,2,3)
			JMenuItem clr1 = new JMenuItem("Color 1");
			clr1.addActionListener(this);
			color.add(clr1);
			JMenuItem clr2 = new JMenuItem("Color 2");
			clr2.addActionListener(this);
			color.add(clr2);
			JMenuItem clr3 = new JMenuItem("Color 3");
			clr3.addActionListener(this);
			color.add(clr3);
			
			//Fractal
			JMenu fractal = new JMenu("Fractal Escapes");
			fractal.setMnemonic(KeyEvent.VK_F);
			fractal.addActionListener(this);
			menuBar.add(fractal);
			JMenuItem manE = new JMenuItem("Mandelbrot");
			manE.addActionListener(this);
			manE.setActionCommand("mandelbrotEscapes");
			fractal.add(manE);
			JMenuItem julE = new JMenuItem("Julia");
			julE.addActionListener(this);
			julE.setActionCommand("juliaEscapes");
			fractal.add(julE);
			JMenuItem burE = new JMenuItem("BurningShip");
			burE.addActionListener(this);
			burE.setActionCommand("burningShipEscapes");
			fractal.add(burE);
			JMenuItem mulE = new JMenuItem("Multibrot");
			mulE.addActionListener(this);
			mulE.setActionCommand("multibrotEscapes");
			fractal.add(mulE);
			menuBar.setLayout(new FlowLayout());
			_window.setJMenuBar(menuBar);
			_window.add(menuBar);
			
			
/*----------------^^^^------------------------------------------^^^^-------
 * ---------------||||----above this lane, it is yong's lane----||||-------
 * ---------------||||------------------------------------------||||-------*/
			
			
			// Give the main panel two sections (two rows, one column)
		
			_mainPanel = new JPanel();
			_mainPanel.setLayout(new FlowLayout());		
			
			// Set up the JPanel and GridLayout where the grid of buttons will go
			_buttonGrid = new JPanel();
			_buttonGrid.setLayout(new GridLayout(ROWS, COLUMNS));		
			_mainPanel.add(_buttonGrid);		
			JButton increase = new JButton("Increase Numbers");
			//increase.addActionListener(new NumberButtonHandler(_model));
			_mainPanel.add(increase);		
		//	JButton thickness = new JButton("Increase Thickness");
			//use the actioncommand to call the method input so we don't need to create all the methodcalls.
			/* eg) 
			*public class MenuItemListener implements ActionListener {
	    		public void actionPerformed(ActionEvent e) {            
	        	use.PixelMatrix(e.getActionCommand());
			*
			*/
			_window.add(_mainPanel);
			_window.setVisible(true);
			_mainPanel.setVisible(true);
			menuBar.setVisible(true);
			
	
			// Keep a permanent reference to the Model in order to notify it of user input
			//_model = m;
			
			/* The UI is taking care of itself here - it's making sure the model
			 * will know to call it when it's time for visual updates. */
			//_model.addObserver(this);
			
			// Perform some setup tasks that only need to be done once.
	
			
			// Bring the UI to a ready state.
			update();
		
		
	
		//JButton thickness = new JButton("Increase Thickness");
		
		/* Here I'm using an anonymous inner class. Notice that I still have access to UI's instance variables. 
		 * Doing this is much more convenient than creating a whole separate class and setting up an association 
		 * relationship with UI. */
		/*thickness.addActionListener(new ActionListener(){
			
		});
		_mainPanel.add(thickness);
		*/
		// Final steps to display the window
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
		//_model.increaseBorderThickness();
		}
		@Override
		public void keyPressed(KeyEvent ke) {
			if(ke.getKeyChar()== 'x'){
				System.exit(0);}
			if(ke.getKeyChar()== 'r'){
				//gotta add some
				//do the job
			}
			if(ke.getKeyChar()== 'f'){	
				//same here
				//do the job
			}
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void ActionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
		@Override
		//program exit
		public void menuSelected(MenuEvent me){
			if (me.getSource().equals(me)){
				System.exit(0);
			}
			if (me.getSource().equals(me)){
				
			}
			if (me.getSource().equals(me)){
				
			}
			if (me.getSource().equals(me)){
		
			}
			if (me.getSource().equals(me)){
		
			}
		}
		
	
		@Override
		public void menuDeselected(MenuEvent me){
			//it will not be used but component of MUST have method
		}
		
		@Override
		public void menuCanceled(MenuEvent me){
			//same buddies
		}
		/* actionListener code here for example.
		 example of adding actions to the menu option clicks
		if (e.getSource().equals(menuoption)){
			
		}

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
		/*thickness.addActionListener(new ActionListener())
			@Override
			public void actionPerformed(ActionEvent e) {
				_model.increaseBorderThickness();
			}*/
		
	
	public void update() {
		//FractalPanel magic = new FractalPanel();
		//magic.updateImage(_model.mandelbrotEscapes);
		
	}
	}
	