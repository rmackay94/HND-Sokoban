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
public class Coordinate {
    private int x;
    private int y;
    
    Coordinate(int newX, int newY){
        x = newX;
        y = newY;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int newX) {
        x = newX;
    }
    
    public void setY(int newY) {
        y = newY;
    }
    
    //Takes a Coordinate object and returns true if the values of x and y are the same in both Coordinates
    public boolean equals(Coordinate c) {
        if (c.getX() == getX() && c.getY() == getY()) {
            return true;
        } else {
            return false;
        }        
    }
}
