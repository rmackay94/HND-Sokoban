/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class MoveableMapElement extends MapElement {
    
    private Coordinate currentPositionInMap;
    private final Coordinate startingPositionInMap;
    
    MoveableMapElement(int newX, int newY) {
        currentPositionInMap = new Coordinate(newX, newY);
        startingPositionInMap = new Coordinate(newX, newY);
    }
    
    public void setCurrentPosition(int newX, int newY) {
        currentPositionInMap.setX(newX);
        currentPositionInMap.setY(newY);
        setBounds(newX,newY);
    }
    
    public void setCurrentPosition(Coordinate c) {
        currentPositionInMap.setX(c.getX());
        currentPositionInMap.setY(c.getY());
        setBounds(c.getX(),c.getY());
    }
    
    public Coordinate getCurrentPosition() {
        return currentPositionInMap;
    }
    
    public int getXPosition() {
        return currentPositionInMap.getX();
    }
    
    public int getYPosition() {
        return currentPositionInMap.getY();
    }
    
    
    public void resetPosition() {
        currentPositionInMap.setX(startingPositionInMap.getX());
        currentPositionInMap.setY(startingPositionInMap.getY());
        setBounds(startingPositionInMap.getX(),startingPositionInMap.getY());
   }
        
}
