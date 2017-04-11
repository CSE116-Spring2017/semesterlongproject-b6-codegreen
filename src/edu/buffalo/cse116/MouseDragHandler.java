package edu.buffalo.cse116;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.awt.Component;

public class MouseDragHandler implements MouseListener, MouseMotionListener {
	
	private int startX, startY, endX, endY;
	private boolean df; //is dragging
	UI _ui;
	
	public MouseDragHandler(UI youEye){
		_ui = youEye;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		startX = arg0.getX();
		startY = arg0.getY();
		System.out.println("Pressed: " + startX + "," + startY);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		endX = arg0.getX();
		endY = arg0.getY();
		System.out.println("Released: " + endX + "," + endY);
		if(!(endX == startX && endY == startY)){
			_ui.zoomIn(startX, startY, endX, endY);
		}
	}

}
