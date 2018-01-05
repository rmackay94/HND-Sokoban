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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class WarehouseKeeper extends MoveableMapElement implements KeyListener, MouseListener {
    
    WarehouseKeeper(int newX, int newY) {
        super(newX, newY);
        elementName = "Warehouse Keeper";
        representingCharecter = "@";  
        elementColour = Color.blue;
        this.setFocusable(true);
    }
    
    public void moveElement(KeyEvent ke) {
        if (ke.getKeyChar() == 'w'){
            moveTo(this.getXPosition()+1,this.getYPosition());
        } else if (ke.getKeyChar() == 'a'){
            moveTo(this.getXPosition(),this.getYPosition()-1);
        } else if (ke.getKeyChar() == 's'){
            moveTo(this.getXPosition()-1,this.getYPosition());
        } else if (ke.getKeyChar() == 'd'){
            moveTo(this.getXPosition(),this.getYPosition()+1);
        }
    }
    
//    public boolean canMoveTo(Coordinate c) {
//        
//        if (map[c.getX()][c.getY()].representingCharecter = 'X') {
//            return true;
//        }
//                       return true;
//    }
    
//    public boolean canMoveTo(int x, int y) {
//        
//        if (map[x][y].representingCharecter = 'X') {
//            return true;
//        }   
//        return true;
//    }
    
    public void moveTo(int newX, int newY) {        
        this.setCurrentPosition(newX, newY);
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        requestFocusInWindow();
        System.out.println("keybroad focus requested");
    }
        
    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        moveElement(ke);
        System.out.println("key pressed:" + ke.getKeyChar());
    }
    
    
    
    // Unused methods
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
