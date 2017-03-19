package edu.buffalo.cse116;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.IndexColorModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


/* This class will visualize the basic set up for Menu Bar.
 * for each menus are added to the menu bar such as file, fractal, color
 * file: 	file close is added
 * fractal: Mandelbrot, BurningShipe, Multibrot, and Julia escapes are added
 * color:   rainbow, grey, blue, and UBhackathon are added
 * 
 * based on each menuitem selection, 
 * the pixelmatrix methods and colors will be changed and display to visualize.
 * 
 * @author Yongbong Kwon
 * 
 * */



public class UI implements ActionListener {
	
	
	/*----------------||||------------------------------------------||||-------
	 * ---------------||||----under eh lane, it is yong's lane----||||-------
	 * ---------------VVVV------------------------------------------VVVV-------*/
	
	PixelMatrix _model;
	// UI elements
	JFrame _window;
	JPanel _mainPanel;	
	JPanel _buttonGrid;
	FractalCanvas _fc;
	IndexColorModel _icm;
	private double _escapeDistance;
	static int ROWS = 2;
	static int COLUMNS = 1;
	static int BUTTON_SIZE =2;
	int _mostRecentEscape;
	/*
	 * Action Listeners are added to each menu items to
	 * run the methods for colors and pixelMatrix
	 * 
	 * */
	public UI(){
		
		_escapeDistance = 2;
        JMenuBar menuBar = new JMenuBar(); // menubar FTW yea~
        _window = new JFrame("Fractals");  
        _icm = ColorModelFactory.createRainbowColorModel(256);
        _model = new PixelMatrix(512,512);
        _fc = new FractalCanvas();
        _window.add(_fc);
        //
        //
        //file
        JMenu file= new JMenu("File");       
        menuBar.add(file);
        //file-close
        JMenuItem close= new JMenuItem("File Close");
        close.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              System.exit(0);
           }
        });
        file.add(close); 
        //
        //
        //Color
        JMenu color = new JMenu("Color");
        color.setMnemonic(KeyEvent.VK_R);
        menuBar.add(color);
        //color sets ( 3 )
        JMenuItem clr1 = new JMenuItem("Rainbow");
        clr1.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		_icm = ColorModelFactory.createRainbowColorModel(256);
        		
        		_fc.setColor(_icm);
        		_fc.updateCanvas();
        		_fc.updateCanvas();
        		
        	}
        });
        color.add(clr1);
        JMenuItem clr2 = new JMenuItem("Blue");
        clr2.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		_icm = ColorModelFactory.createBluesColorModel(256);
        		
        		_fc.setColor(_icm);
        		_fc.updateCanvas();
        		_fc.updateCanvas();
        		
        	}
        });
        color.add(clr2);
        JMenuItem clr3 = new JMenuItem("Gray");
        clr3.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		_icm = ColorModelFactory.createGrayColorModel(256);
        		
        		_fc.setColor(_icm);
        		_fc.updateCanvas();
        		_fc.updateCanvas();
        		
        	}
        });
        color.add(clr3);   
        JMenuItem clr4 = new JMenuItem("UB Hackathon");
        clr4.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		_icm = ColorModelFactory.createUBHackathonColorModel(256);
        		
        		_fc.setColor(_icm);
        		_fc.updateCanvas();
        		_fc.updateCanvas();
        		
        	}
        });
        color.add(clr4);
        //
        //
        //Fractal
        JMenu fractal = new JMenu("Fractal Escapes");
        fractal.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fractal);
        //MandelBrot
        JMenuItem manE = new JMenuItem("Mandelbrot");
        //action listener
        manE.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
        	   _model = new PixelMatrix(512,512);
              //_window.add(new FractalCanvas(_model.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3), ColorModelFactory.createRainbowColorModel(256)));
              _model.setEscapeDistance(_escapeDistance);
              _fc.setFractal(_model.mandelbrotEscapes(255,-2.15,.6,-1.3,1.3));
              _mostRecentEscape = 0;
              _fc.setColor(_icm);
              _fc.updateCanvas();
              _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(manE);
        //Julia
        JMenuItem julE = new JMenuItem("Julia");
        //action listener
        julE.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
        	   _model = new PixelMatrix(512,512);
        	   _model.setEscapeDistance(_escapeDistance);
              //_window.add(new FractalCanvas(_model.juliaEscapes(2, 255, -1.7, 1.7, -1.0, 1.0), ColorModelFactory.createRainbowColorModel(256)));
              _fc.setFractal(_model.juliaEscapes( 255, -1.7, 1.7, -1.0, 1.0));
              
              _mostRecentEscape = 1;
              _fc.setColor(_icm);
              _fc.updateCanvas();
              _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
              
           }
        });
        fractal.add(julE);
        //BurningShip
        JMenuItem burE = new JMenuItem("BurningShip");
        //action listener
        burE.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
        	   _model = new PixelMatrix(512,512);
        	   _model.setEscapeDistance(_escapeDistance);
              //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
        	   _fc.setFractal(_model.burningShipEscapes( 255, -1.8, -1.7, -0.08, 0.025));
        	   _mostRecentEscape = 2;
               _fc.setColor(_icm);
               _fc.updateCanvas();
               _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(burE);
        JMenuItem mulE = new JMenuItem("Multibrot");
        //action listener
        mulE.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
        	   _model = new PixelMatrix(512,512);
        	   _model.setEscapeDistance(_escapeDistance);
              _fc.setFractal(_model.multibrotEscapes(255,-1.0 ,1.0, -1.3, 1.3));
              _mostRecentEscape = 3;
              _fc.setColor(_icm);
              _fc.updateCanvas();
              _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(mulE);
        
        
        
        /*
         * @author Baker Brett
         * 
         * JTextField is added to provide input for user
         * button is added to execute based on the user's input 
         * */
        
        
        JTextField et = new JTextField("Enter Distance");
        JButton set = new JButton("Set Distance");
        JLabel wrongAnswer = new JLabel("");
        set.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(Double.parseDouble(et.getText()) > 0 && Double.parseDouble(et.getText()) <= 255){
            		wrongAnswer.setText("");
            	_escapeDistance = Double.parseDouble(et.getText());
            	_model = new PixelMatrix(512,512);
            	_model.setEscapeDistance(_escapeDistance);
               //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
            	if (_mostRecentEscape == 0) {
            		_fc.setFractal(_model.mandelbrotEscapes(255,-2.15,.6,-1.3,1.3));
            	}
            	else if(_mostRecentEscape == 1) {
            		_fc.setFractal(_model.juliaEscapes(255,-2.15,.6,-1.3,1.3));
            	}
            	else if(_mostRecentEscape == 2) {
            		_fc.setFractal(_model.burningShipEscapes(255,-2.15,.6,-1.3,1.3));
            	}
            	else {
            		_fc.setFractal(_model.multibrotEscapes(255,-2.15,.6,-1.3,1.3));
            	}
                _fc.setColor(_icm);
                _fc.updateCanvas();
                _fc.updateCanvas();
               _window.pack();
               _window.setVisible(true);
            	}
            	else wrongAnswer.setText("Invalid Selection");
            }
         });
        menuBar.add(set);
        menuBar.add(et);
        menuBar.add(wrongAnswer);
        
        menuBar.setLayout(new FlowLayout());
        _window.setJMenuBar(menuBar);
        
        _window.pack();
        _window.setVisible(true);
        _window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/*----------------^^^^------------------------------------------^^^^-------
* ---------------||||----above eh lane, it is yong's lane----||||-------
* ---------------||||------------------------------------------||||-------*/
        
      
       
        }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}