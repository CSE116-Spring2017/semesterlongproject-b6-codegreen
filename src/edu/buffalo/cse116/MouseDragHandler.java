package edu.buffalo.cse116;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

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
		int newMaxX = startX > arg0.getX() ? startX : arg0.getX();
		int newMinX = startX < arg0.getX() ? startX : arg0.getX();
		int newMaxY = startY > arg0.getY() ? startY : arg0.getY();
		int newMinY = startY < arg0.getY() ? startY : arg0.getY();
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(SwingUtilities.isRightMouseButton(arg0)){
			_ui.resetZoom();
		}

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
		if(!(endX == startX && endY == startY) && SwingUtilities.isLeftMouseButton(arg0)){
			_ui.zoomIn(startX, startY, endX, endY);
		}
	}

}
