/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Graphics;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class Diamond extends MapElement {
    
    public Diamond() {
        elementName = "Floor";
        representingCharecter = ".";  
        setText(representingCharecter);
    }
    
//    @Override
//    public void paint(Graphics g){
//        g.setColor(Color.orange);
//        g.fillRect(0,0,10,10);
//    }
    
}
