/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class WarehouseKeeper extends MoveableMapElement implements KeyListener{
    
    WarehouseKeeper(int newX, int newY) {
        super(newX, newY);
        elementName = "Warehouse Keeper";
        representingCharecter = "@";  
        setText(representingCharecter);
        elementColour = Color.blue;
    }
    
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
