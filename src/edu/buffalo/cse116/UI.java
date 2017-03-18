package edu.buffalo.cse116;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.IndexColorModel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.buffalo.cse116.ColorModelFactory;
import edu.buffalo.cse116.FractalCanvas;
import edu.buffalo.cse116.PixelMatrix;
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
	FractalCanvas _fc;
	IndexColorModel _icm;
	static int ROWS = 2;
	static int COLUMNS = 1;
	static int BUTTON_SIZE =2;
	
	public UI(){
		
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
              
              _fc.setFractal(_model.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3));
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
        	   //_model = new PixelMatrix(512,512);
              //_window.add(new FractalCanvas(_model.juliaEscapes(2, 255, -1.7, 1.7, -1.0, 1.0), ColorModelFactory.createRainbowColorModel(256)));
              _fc.setFractal(_model.juliaEscapes(2, 255, -1.7, 1.7, -1.0, 1.0));
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
              //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
        	   _fc.setFractal(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025));
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
              _fc.setFractal(_model.multibrotEscapes(2,255,-1.0 ,1.0, -1.3, 1.3));
              _fc.setColor(_icm);
              _fc.updateCanvas();
              _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(mulE);
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