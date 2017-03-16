package edu.buffalo.cse116;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.event.MenuEvent;

public class EventHandler implements ActionListener  {
	private PixelMatrix _pix;
	
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
		public void menuSelected(MenuEvent e){
			if (e.getSource().equals("fclose")){
				System.exit(0);				
			}			
			if (e.getSource().equals("clr1")){
				System.out.println("clr1 clicked");
			}
			if (e.getSource().equals("clr2")){
				System.out.println("clr2 clicked");
			}
			if (e.getSource().equals("clr3")){
				
			}
			if (e.getSource().equals("manE")){
		
			}
			if (e.getSource().equals("julE")){
				
			}
			if (e.getSource().equals("burE")){
		
			}
			if (e.getSource().equals("mulE")){
		
			}
		}	
		public void menuDeselected(MenuEvent me){
			//it will not be used but component of MUST have method
		}
		public void menuCanceled(MenuEvent me){
			//same buddies
		}
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}    
		}