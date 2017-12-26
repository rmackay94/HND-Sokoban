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
    
//    public void moveElement(KeyEvent ke) {
//        if (ke.getKeyChar() == 'w'){
//            moveTo(currentPositionInMap.getX()+1,currentPositionInMap.getY());
//        } else if (ke.getKeyChar() == 'a'){
//            moveTo(currentPositionInMap.getX(),currentPositionInMap.getY()-1);
//        } else if (ke.getKeyChar() == 's'){
//            moveTo(currentPositionInMap.getX()-1,currentPositionInMap.getY());
//        } else if (ke.getKeyChar() == 'd'){
//            moveTo(currentPositionInMap.getX(),currentPositionInMap.getY()+1);
//        }
//    }
//    
//    public boolean canMoveTo(Coordinate c) {
//        
//        if (map[c.getX()][c.getY()].representingCharecter = 'X') {
//            return true;
//        }
//                       return true;
//    }
//    
//        public boolean canMoveTo(int x, int y) {
//        
//        if (map[x][y].representingCharecter = 'X') {
//            return true;
//        }
//        
//        
//        return true;
//    }
//    
//    public void moveTo(int newX, int newY) {
//        
//        canMoveTo(newX, newY);
//        
//        int i = 0()
//    }
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        moveElement(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
