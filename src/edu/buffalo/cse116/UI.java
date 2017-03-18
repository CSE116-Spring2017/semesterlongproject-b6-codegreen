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
	static int ROWS = 2;
	static int COLUMNS = 1;
	static int BUTTON_SIZE =2;
	
	public UI(){
		
        JMenuBar menuBar = new JMenuBar(); // menubar FTW yea~
        _window = new JFrame();      
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
        JMenuItem clr1 = new JMenuItem("Color 1");
        color.add(clr1);
        JMenuItem clr2 = new JMenuItem("Color 2");
        color.add(clr2);
        JMenuItem clr3 = new JMenuItem("Color 3");
        color.add(clr3);   
        JMenuItem clr4 = new JMenuItem("Color 4");
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
              _window.add(new FractalCanvas(_model.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3),
                    ColorModelFactory.createRainbowColorModel(256)));
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
              _window.add(new FractalCanvas(_model.juliaEscapes(2, 255, -1.7, 1.7, -1.0, 1.0),
                    ColorModelFactory.createRainbowColorModel(256)));
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
              _window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025),
                    ColorModelFactory.createRainbowColorModel(256)));
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
              _window.add(new FractalCanvas(_model.mandelbrotEscapes(2,255,-1.0 ,1.0, -1.3, 1.3),
                    ColorModelFactory.createRainbowColorModel(256)));
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(mulE);
        menuBar.setLayout(new FlowLayout());
        _window.setJMenuBar(menuBar);
        
        _window.pack();
        _window.setVisible(true);
/*----------------^^^^------------------------------------------^^^^-------
* ---------------||||----above eh lane, it is yong's lane----||||-------
* ---------------||||------------------------------------------||||-------*/
        
      
       
        }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}