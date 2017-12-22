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
public class Crate extends MoveableMapElement{   
    
    public Crate(int newX, int newY) {
        super(newX, newY);
        elementName = "Crate";
        representingCharecter = "*";  
    }
    
}
