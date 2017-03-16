package edu.buffalo.cse116;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.event.MenuEvent;


public class EventHandler implements ActionListener  {
	private PixelMatrix _pix;
	private UI d;
	public EventHandler(PixelMatrix p, int x, int y){
		_pix = p;
	}
    //public void actionPerformed(ActionEvent e) {            
       // .setText(e.getActionCommand() 
       //    + " MenuItem clicked.");
    	
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
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub			
		}		
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub			
		}
		//program exit
		public void menuSelected(ActionEvent e){
			d = new UI();
			/*if (e.getActionCommand().equals("fopen")){
				System.exit(0);
				}
			*/				
			
			if (e.getActionCommand().equals("fclose")){
				System.exit(0);				
			}			
			if (e.getActionCommand().equals("clr1")){
				System.out.println("clr1 clicked");
			}
			if (e.getActionCommand().equals("clr2")){
				System.out.println("clr2 clicked");
			}
			if (e.getActionCommand().equals("clr3")){
				System.out.println("clr3 clicked");
			}
			if (e.getActionCommand().equals("manE")){
				System.out.println("manE clicked");
			}
			if (e.getActionCommand().equals("julE")){
				System.out.println("julE clicked");
			}
			if (e.getActionCommand().equals("burE")){
				System.out.println("burE clicked");
			}
			if (e.getActionCommand().equals("mulE")){
				System.out.println("mulE clicked");
			}
		}	
		public void menuDeselected(MenuEvent me){
			//it will not be used, 
			//but component MUST have these 2 methods below
		}
		public void menuCanceled(MenuEvent me){
			//same buddies
		}
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}    
		}