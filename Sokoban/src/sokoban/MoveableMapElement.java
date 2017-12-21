/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author 16003059
 */
public class MoveableMapElement extends MapElement {
    Coordinate positionInMap;
    
    MoveableMapElement(int newX, int newY) {
        positionInMap = new Coordinate(newX, newY);
    }
}
