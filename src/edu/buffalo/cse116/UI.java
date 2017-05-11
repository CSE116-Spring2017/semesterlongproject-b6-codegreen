package edu.buffalo.cse116;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.IndexColorModel;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import edu.buffalo.fractal.ComputePool;

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
	JPanel _mainPanel,coordPanel,_bigPanel;
	JPanel _buttonGrid;
	JLabel coordLabelXY,coordLabelXXYY;
	FractalCanvas _fc;
	JLayeredPane _layeredPane;
	IndexColorModel _icm;
	JTextField coords;
	double _currentXMax;
	double _currentXMin;
	double _currentYMax;
	double _currentYMin;

	private double _escapeDistance;
	private int _escapeTime;
	int _threadCount;
	static int ROWS = 2;
	static int COLUMNS = 1;
	static int BUTTON_SIZE = 2;
	private int pixelDimX = 2048;
	int _mostRecentEscape;

	/*
	 * Action Listeners are added to each menu items to run the methods for
	 * colors and pixelMatrix
	 * 
	 */
	public UI(){
		
		_escapeDistance = 2;
        JMenuBar menuBar = new JMenuBar(); // menubar FTW yea~
        _window = new JFrame("Fractals");  
        _icm = ColorModelFactory.createRainbowColorModel(256);
        _model = new PixelMatrix(pixelDimX,pixelDimX); //makes it 2048 pixels by 2048 pixels
        _fc = new FractalCanvas();
        _mainPanel = new JPanel();
        coordPanel = new JPanel();
        _mainPanel.add(_fc);
        _layeredPane = new JLayeredPane();
        _layeredPane.setBounds(_fc.getX(), _fc.getY(), _fc.getWidth(), _fc.getHeight());
        coordLabelXY = new JLabel();
		coordLabelXXYY = new JLabel();
        coords = new JTextField("Clicked Coordinates");
		//menuBar.add(coords);
        coordPanel.add(coordLabelXY);
		coordPanel.add(coordLabelXXYY);
		coordLabelXY.setText("click xy");
		coordLabelXXYY.setText("drag xy");
        _mainPanel.add(_fc);
        //_window.add(_layeredPane);
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
        	   _model = new PixelMatrix(pixelDimX,pixelDimX); //I DONT KNOW WHY BUT ONLY NUMBERS < 512 WORK
              //_window.add(new FractalCanvas(_model.mandelbrotEscapes(2,255,-2.15,.6,-1.3,1.3), ColorModelFactory.createRainbowColorModel(256)));
              _model.setEscapeDistance(_escapeDistance);
              _currentXMin = -2.15;
              _currentXMax = 0.6;
              _currentYMin = -1.3;
              _currentYMax = 1.3;
              
              _model.setThreadCount(_threadCount);
              //Instanitate SwingWorker[Thread];
              SwingWorker[] SwingArray = new SwingWorker[_threadCount];
              
              //for (int i = 0; i<_ui._threadCount; i++){
          		//= 2048/_ui._threadCount + 2048%_ui._threadCount;
          	  //}
              
              //generatFractal()
              ComputePool computePool = new ComputePool();
              computePool.generateFractal(_threadCount, SwingArray);
              //clearPool()
              computePool.clearPool();
              
              
              
              _fc.setFractal(_model.mandelbrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
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
        	   _model = new PixelMatrix(pixelDimX,pixelDimX); //I DONT KNOW WHY BUT ONLY NUMBERS < 512 WORK
        	   _model.setEscapeDistance(_escapeDistance);
              //_window.add(new FractalCanvas(_model.juliaEscapes(2, 255, -1.7, 1.7, -1.0, 1.0), ColorModelFactory.createRainbowColorModel(256)));
        	   _currentXMin = -1.7;
               _currentXMax = 1.7;
               _currentYMin = -1.0;
               _currentYMax = 1.0;
        	   _fc.setFractal(_model.juliaEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
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
        	   _model = new PixelMatrix(pixelDimX,pixelDimX);  //I DONT KNOW WHY BUT ONLY NUMBERS < 512 WORK
        	   _model.setEscapeDistance(_escapeDistance);
              //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
        	   _currentXMin = -1.8;
               _currentXMax = -1.7;
               _currentYMin = -0.08;
               _currentYMax = 0.025;
        	   _fc.setFractal(_model.burningShipEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
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
        	   _model = new PixelMatrix(pixelDimX,pixelDimX);  //I DONT KNOW WHY BUT ONLY NUMBERS < 512 WORK
        	   _model.setEscapeDistance(_escapeDistance);
        	   _currentXMin = -1;
               _currentXMax = 1;
               _currentYMin = -1.3;
               _currentYMax = 1.3;
              _fc.setFractal(_model.multibrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
              _mostRecentEscape = 3;
              _fc.setColor(_icm);
              _fc.updateCanvas();
              _fc.updateCanvas();
              _window.pack();
              _window.setVisible(true);
           }
        });
        fractal.add(mulE);
        
        MouseDragHandler itchy = new MouseDragHandler(this);
        _fc.addMouseListener(itchy);
        _layeredPane.addMouseListener(itchy);
        _fc.addMouseMotionListener(itchy);
        
        /*
         * @author Baker Brett
         * 
         * JTextField is added to provide input for user
         * button is added to execute based on the user's input 
         * */
        
        
        JTextField et = new JTextField("Enter Distance", 10);
        JButton set = new JButton("Set Distance");
        JLabel wrongAnswer = new JLabel("");
        set.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(et.getText().equals("Enter Distance")){
            		et.setText("2");
            	}
            	else if(Double.parseDouble(et.getText()) > 0 && Double.parseDouble(et.getText()) <= 255){
            		wrongAnswer.setText("");
            	_escapeDistance = Double.parseDouble(et.getText());
            	_model = new PixelMatrix(pixelDimX,pixelDimX);
            	_model.setEscapeDistance(_escapeDistance);
               //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
            	if (_mostRecentEscape == 0) {
            		_fc.setFractal(_model.mandelbrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else if(_mostRecentEscape == 1) {
            		_fc.setFractal(_model.juliaEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else if(_mostRecentEscape == 2) {
            		_fc.setFractal(_model.burningShipEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else {
            		_fc.setFractal(_model.multibrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		
            	}
                _fc.setColor(_icm);
                _fc.updateCanvas();
                _fc.updateCanvas();
               _window.pack();
               _window.setVisible(true);
            	}
            	else {
            		wrongAnswer.setText("Invalid Selection");
            		_window.pack();
            	}
            	
            }
         });
        menuBar.add(set);
        menuBar.add(et);
        menuBar.add(wrongAnswer);
        //----------------------------------------------------------
	/*
         * @author Yongbong Kwon
         * 
         * JTextField is added to provide input for user
         * button is added to execute based on the user's input 
         * */
       //-------------------------------------------------------------------------------------------------------------------- 
           
        JTextField t_jtxt = new JTextField("Enter Time", 10);
        JButton t_set = new JButton("Set Time");
        JLabel wrong_Answer = new JLabel("");
        t_set.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(t_jtxt.getText().equals("Enter Time")){
            		t_jtxt.setText("255");
            	}
            	else if(Integer.parseInt(t_jtxt.getText()) > 0 && Integer.parseInt(t_jtxt.getText()) <= 255){
            		wrong_Answer.setText("");
            		_escapeTime = Integer.parseInt(t_jtxt.getText());
            		_model = new PixelMatrix(2048,2048);
            		_model.setEscapeTime(_escapeTime);
            		//_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
            		if (_mostRecentEscape == 0) {
            			_fc.setFractal(_model.mandelbrotEscapes(_escapeTime,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		}
            		else if(_mostRecentEscape == 1) {
            			_fc.setFractal(_model.juliaEscapes(_escapeTime,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		}
            		else if(_mostRecentEscape == 2) {
            			_fc.setFractal(_model.burningShipEscapes(_escapeTime,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		}
            		else {
            			_fc.setFractal(_model.multibrotEscapes(_escapeTime,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		
            		}
	                _fc.setColor(_icm);
	                _fc.updateCanvas();
	                _fc.updateCanvas();
	               _window.pack();
	               _window.setVisible(true);
            	}
            	else {
            		wrong_Answer.setText("Invalid Selection");
            		_window.pack();
            	}
            	
            }
         });
        menuBar.add(t_set);
        menuBar.add(t_jtxt);
        menuBar.add(wrong_Answer);
	//------------------------------------------------------------------------------------------------------------	
        /**JButton reset = new JButton("Reset Zoom");
        reset.addActionListener(new ActionListener());
        @Override
        public void actionPerformed(ActionEvent e){
        	_model = new PixelMatrix(512,512);
        	_model.setEscapeDistance(_escapeDistance);
        	
        	 _fc.setColor(_icm);
             _fc.updateCanvas();
             _fc.updateCanvas();
            _window.pack();
            _window.setVisible(true);
        }
        
        menuBar.add(reset);
        **/
        JTextField threads = new JTextField("Enter Thread Count", 10);
        JButton setThread = new JButton("Set ThreadCount");
        JLabel wrongAnswer_ = new JLabel("");
        set.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(threads.getText().equals("Enter Thread Count")){
            		threads.setText("1");
            	}
            	else if(Integer.parseInt(threads.getText()) >= 1 && Integer.parseInt(threads.getText()) <= 128){
            		wrongAnswer_.setText("");
            	_threadCount = Integer.parseInt(threads.getText());
            	_model = new PixelMatrix(2048,2048);
            	_model.setThreadCount(_threadCount);
               //_window.add(new FractalCanvas(_model.burningShipEscapes(2, 255, -1.8, -1.7, -0.08, 0.025), ColorModelFactory.createRainbowColorModel(256)));
            	if (_mostRecentEscape == 0) {
            		_fc.setFractal(_model.mandelbrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else if(_mostRecentEscape == 1) {
            		_fc.setFractal(_model.juliaEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else if(_mostRecentEscape == 2) {
            		_fc.setFractal(_model.burningShipEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            	}
            	else {
            		_fc.setFractal(_model.multibrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
            		
            	}
                _fc.setColor(_icm);
                _fc.updateCanvas();
                _fc.updateCanvas();
               _window.pack();
               _window.setVisible(true);
            	}
            	else {
            		wrongAnswer_.setText("Invalid Selection");
            		_window.pack();
            	}
            	
            }
         });
        menuBar.add(setThread);
        menuBar.add(threads);
        menuBar.add(wrongAnswer);
        
        menuBar.setLayout(new FlowLayout());
        _bigPanel.add(menuBar);
        _bigPanel.add(_mainPanel);
        _bigPanel.add(coordPanel);
        
        
        //_window.setPreferredSize(new Dimension(2048,2048));
        //_window.setResizable(false);
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
	
	public void zoomIn(int mouseXStart, int mouseYStart, int mouseXEnd, int mouseYEnd){
		int newMaxX = mouseXStart > mouseXEnd ? mouseXStart : mouseXEnd;
		int newMinX = mouseXStart < mouseXEnd ? mouseXStart : mouseXEnd;
		int newMaxY = mouseYStart > mouseYEnd ? mouseYStart : mouseYEnd;
		int newMinY = mouseYStart < mouseYEnd ? mouseYStart : mouseYEnd;
		
		Dimension win = _fc.getSize();
		
		
		double windowXDim = win.getWidth();
		double windowYDim = win.getHeight();
		
		double xStep = (_currentXMax - _currentXMin)/windowXDim;
		double yStep = (_currentYMax - _currentYMin)/windowYDim;
		
		_currentXMax = (newMaxX * xStep) + _currentXMin;
		_currentXMin = (newMinX * xStep) + _currentXMin; //hello, newMin
		_currentYMax = (newMaxY * yStep) + _currentYMin; //hello, JRE
		_currentYMin = (newMinY * yStep) + _currentYMin;
		
		System.out.println("Mouse Max X: " + newMaxX);
		System.out.println("Mouse Min X: " + newMinX);
		System.out.println("Mouse Max Y: " + newMaxY);
		System.out.println("Mouse Min Y: " + newMinY);
		
		System.out.println("currentXMax: " + _currentXMax);
		System.out.println("currentXMin: " + _currentXMin);
		System.out.println("currentYMax: " + _currentYMax);
		System.out.println("currentYMin: " + _currentYMin);
		System.out.println("Window X: " + windowXDim);
		System.out.println("Window Y: " + windowYDim);
		System.out.println("\n");
		
		if (_mostRecentEscape == 0) {
    		_fc.setFractal(_model.mandelbrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else if(_mostRecentEscape == 1) {
    		_fc.setFractal(_model.juliaEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else if(_mostRecentEscape == 2) {
    		_fc.setFractal(_model.burningShipEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else {
    		_fc.setFractal(_model.multibrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    		
    	}
		_fc.updateCanvas();
        _fc.updateCanvas();
       _window.pack();
       _window.setVisible(true);
		
	}
	
	public void drawZoomBox(int minX, int minY, int maxX, int maxY){
		RectangleComp box = new RectangleComp(minX, minY, maxX - minX, maxY - minY);
		_layeredPane.add(box);
	}
	
	public void showCoordinates(int a, int b, int c,int d) {
		double xStep,yStep;
		xStep = _model.getXStep();
		yStep = _model.getYStep();
		coordLabelXY.setText("("+a*yStep+","+b*xStep+")");
		coordLabelXXYY.setText("("+c*yStep+","+d*xStep+")");
		if (a == 0 && b == 0 && c == 0 && d == 0) {
			coordLabelXY.setText("click xy");
			coordLabelXXYY.setText("drag xy");
		}
        _window.pack();
        _window.setVisible(true);
	}

	
	public void resetZoom(){
		if (_mostRecentEscape == 0) {
			_currentXMin = -2.15;
            _currentXMax = 0.6;
            _currentYMin = -1.3;
            _currentYMax = 1.3;
            _fc.setFractal(_model.mandelbrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else if(_mostRecentEscape == 1) {
    		_currentXMin = -1.7;
            _currentXMax = 1.7;
            _currentYMin = -1.0;
            _currentYMax = 1.0;
     	   _fc.setFractal(_model.juliaEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else if(_mostRecentEscape == 2) {
    		_currentXMin = -1.8;
            _currentXMax = -1.7;
            _currentYMin = -0.08;
            _currentYMax = 0.025;
     	   _fc.setFractal(_model.burningShipEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    	}
    	else {
    		_currentXMin = -1;
            _currentXMax = 1;
            _currentYMin = -1.3;
            _currentYMax = 1.3;
           _fc.setFractal(_model.multibrotEscapes(255,_currentXMin,_currentXMax,_currentYMin,_currentYMax));
    		
    	}
		_fc.updateCanvas();
        _fc.updateCanvas();
       _window.pack();
       _window.setVisible(true);
	}

}
