package edu.buffalo.cse116;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.buffalo.fractal.FractalPanel;


public class UI implements ActionListener {
	
	
	/*----------------||||------------------------------------------||||-------
	 * ---------------||||----under eh lane, it is yong's lane----||||-------
	 * ---------------VVVV------------------------------------------VVVV-------*/
	
	PixelMatrix _model;
	// UI elements
	JFrame _window;
	JPanel _mainPanel;	
	JPanel _buttonGrid;
	static int ROWS = 2;
	static int COLUMNS = 1;
	static int BUTTON_SIZE =2;
	private EventHandler eh;
	
	public UI(){
		
			JMenuBar menuBar = new JMenuBar(); // menubar FTW yea~
			_window = new JFrame();		
			//file
			JMenu file= new JMenu("File");
			file.addActionListener(eh);
			menuBar.add(file);
			//file-open
			JMenuItem open= new JMenuItem("File Open");
			open.addActionListener(eh);
			open.setActionCommand("fopen");
			file.add(open);
			//file-close
			JMenuItem close= new JMenuItem("File Close");
			close.addActionListener(eh);
			close.setActionCommand("fclose");
			file.add(close);		
			//Color
			JMenu color = new JMenu("Color");
			color.setMnemonic(KeyEvent.VK_R);
			color.addActionListener(eh);
			menuBar.add(color);
			//color sets ( 3 )
			JMenuItem clr1 = new JMenuItem("Color 1");
			clr1.addActionListener(eh);
			clr1.setActionCommand("clr1");
			color.add(clr1);
			JMenuItem clr2 = new JMenuItem("Color 2");
			clr2.addActionListener(eh);
			clr2.setActionCommand("clr2");
			color.add(clr2);
			JMenuItem clr3 = new JMenuItem("Color 3");
			clr3.addActionListener(eh);
			clr3.setActionCommand("clr3");
			color.add(clr3);	
			JMenuItem clr4 = new JMenuItem("Color 4");
			clr4.addActionListener(eh);
			clr4.setActionCommand("clr4");
			color.add(clr4);
			//Fractal
			JMenu fractal = new JMenu("Fractal Escapes");
			fractal.setMnemonic(KeyEvent.VK_F);
			fractal.addActionListener(eh);
			menuBar.add(fractal);
			//Fractal sets ( 4 )
			JMenuItem manE = new JMenuItem("Mandelbrot");
			//manE.addmenuSelected(eh);
			manE.setActionCommand("mandelbrotEscapes");
			fractal.add(manE);
			JMenuItem julE = new JMenuItem("Julia");
			julE.addActionListener(eh);
			julE.setActionCommand("juliaEscapes");
			fractal.add(julE);
			JMenuItem burE = new JMenuItem("BurningShip");
			burE.addActionListener(eh);
			burE.setActionCommand("burningShipEscapes");
			fractal.add(burE);
			JMenuItem mulE = new JMenuItem("Multibrot");
			mulE.addActionListener(eh);
			mulE.setActionCommand("multibrotEscapes");
			fractal.add(mulE);
			menuBar.setLayout(new FlowLayout());
			_window.setJMenuBar(menuBar);
			_window.add(menuBar);
/*----------------^^^^------------------------------------------^^^^-------
 * ---------------||||----above eh lane, it is yong's lane----||||-------
 * ---------------||||------------------------------------------||||-------*/
			
			
			// Give the main panel two sections (two rows, one column)
		
		/*	_mainPanel = new JPanel();
			_mainPanel.setSize(300, 300);
			_mainPanel.setLayout(new GridLayout(300,300));			*/	
			
			
			
			
			_model = new PixelMatrix(512,512);
			_window.add(new FractalCanvas(_model.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3),ColorModelFactory.createRainbowColorModel(256)));
			
			
			
			//increase.addActionListener(new NumberButtonHandler(_model));	
		//	JButton thickness = new JButton("Increase Thickness");
			//use the actioncommand to call the method input so we don't need to create all the methodcalls.
			/* eg) 
			*public class MenuItemListener implements ActionListener {
	    		public void actionPerformed(ActionEvent e) {            
	        	use.PixelMatrix(e.getActionCommand());
			*
			*/
			//_window.add(_mainPanel);
			_window.pack();
			_window.setVisible(true);
			
	
			// Keep a permanent reference to the Model in order to notify it of user input
			//_model = m;
			
			/* The UI is taking care of itself here - it's making sure the model
			 * will know to call it when it's time for visual updates. */
			//_model.addObserver(eh);
			
			// Perform some setup tasks that only need to be done once.
	
			
			// Bring the UI to a ready state.
			update();
		
		
	
		//JButton thickness = new JButton("Increase Thickness");
		
		/* Here I'm using an anonymous inner class. Notice that I still have access to UI's instance variables. 
		 * Doing eh is much more convenient than creating a whole separate class and setting up an association 
		 * relationship with UI. */
		/*thickness.addActionListener(new ActionListener(){
			
		});
		_mainPanel.add(thickness);
		*/
		// Final steps to display the window
		
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
		 * Doing eh is much more convenient than creating a whole separate class and setting up an association 
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	}
	