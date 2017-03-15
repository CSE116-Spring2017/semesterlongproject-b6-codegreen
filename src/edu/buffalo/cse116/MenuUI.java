package edu.buffalo.cse116;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuUI extends JFrame implements ActionListener, KeyListener, MenuListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6472615352356398264L;
	JMenuBar menuBar;
	JMenu color, file, fractal, exit;
	JMenuItem clr1, clr2, clr3;
	JMenuItem  open, close, clear, neww;
	JLabel meme;
	
	public static void main(String[] args){
		MenuUI frm = new MenuUI ();
		//maximiseFrame(frm);
		//center(frm);
		frm.setVisible(true);
	}
	public MenuUI(){
		setLayout(new FlowLayout());
		setSize(400, 300);
		setTitle("Fractal bro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(this); //key listener for menubar
		menuBar = new JMenuBar(); // menubar FTW yea~
		
		//file
		file= new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		file.addActionListener(this);
		menuBar.add(file);
		//file-open
		open= new JMenu("Open");
		open.addActionListener(this);
		file.add(open);
		//file-close
		close= new JMenu("Close");
		close.addActionListener(this);
		file.add(close);
		
		//close
		close = new JMenu("Exit");
		close.setMnemonic(KeyEvent.VK_X);
		close.addActionListener(this);
		menuBar.add(exit);
		
		//fractal
		fractal = new JMenu("Fractal");
		fractal.setMnemonic(KeyEvent.VK_R);
		fractal.addActionListener(this);
		menuBar.add(fractal);
		
		//color sets
		clr1 = new JMenu("Color 1");
		clr1.addActionListener(this);
		fractal.add(clr1);
		
		clr2 = new JMenu("Color 2");
		clr2.addActionListener(this);
		fractal.add(clr2);
		
		clr3 = new JMenu("Color 3");
		clr3.addActionListener(this);
		fractal.add(clr3);
		
		this.setJMenuBar(menuBar);
		add(meme);
		
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyChar()== 'x'){
			System.exit(0);}
		if(ke.getKeyChar()== 'r'){
			//gotta add some
		}
		if(ke.getKeyChar()== 'f'){	
			//same here
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	//program exit
	public void menuSelected(MenuEvent me){
		if (me.getSource().equals(exit)){
			System.exit(0);
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
	
	 * */
}
