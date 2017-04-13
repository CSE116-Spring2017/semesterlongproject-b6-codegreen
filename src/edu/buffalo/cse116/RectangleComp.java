package edu.buffalo.cse116;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


import javax.swing.JComponent;


public class RectangleComp extends JComponent
{

    Rectangle _box;

    RectangleComp(){
    }

    RectangleComp(int x, int y, int width, int height){
        _box = new Rectangle(x, y, width, height);
        repaint();
    }

    public void paintComponent(Graphics g)
    {  
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;

        // Change the color
        Color c = new Color(1.0F,0.0F,1.0F); 
        g2.setColor(c);

        // Draw a rectangle
        g2.draw(_box);


    }

}