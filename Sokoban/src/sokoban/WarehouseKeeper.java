/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class WarehouseKeeper extends MoveableMapElement {
    
    WarehouseKeeper(int newX, int newY) {
        super(newX, newY);
        setElementName("Warehouse Keeper");
        setRepresentingCharecter("@");
        setElementColour(Color.blue);
    }

}
