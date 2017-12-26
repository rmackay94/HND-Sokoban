/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class MapElement extends JLabel{
    
    String elementName;
    String representingCharecter;
    Color elementColour = Color.gray;
    
    @Override
    public void paint(Graphics g){
        g.setColor(elementColour);
        g.fillRect(0,0,10,10);
    }
    
}