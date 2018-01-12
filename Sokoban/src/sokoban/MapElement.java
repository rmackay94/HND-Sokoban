/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class MapElement extends JPanel{
    
    private String elementName;
    private String representingCharecter;
    private Color elementColour = Color.gray;
    
    @Override
    public void paint(Graphics g){
        g.setColor(elementColour);
        g.fillRect(0,0,20,20);
    }
    
    public String getElementName() {
        return elementName;
    }
    
    public String getRepresentingCharecter() {
        return representingCharecter;
    }
    
    //This method positions the map element correctly on the screen so that the reset button and number of moves label are displayed above it 
    public void setBounds(int x, int y) {
        int size = 20;
        setBounds(x*size,100+y*size,size,size);
    }
    
    public void setElementName(String newName) {
        elementName = newName;
    }
    
    public void setRepresentingCharecter(String newCharecter) {
        representingCharecter = newCharecter;
    }
    
    public void setElementColour(Color newColor) {
        elementColour = newColor;
    }
}