/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class Level extends JLayeredPane implements ActionListener{
    
    private MapElement map[][];                 //Arary of MapElements that will not move ie. walls, floors and diamonds
    public WarehouseKeeper warehouseKeeper;    //one WarehouseKeeper object
    public Crate crates[];                     //Array of all crates
    private int numberOfMoves;
    JLabel numberOfMovesLabel;
    JButton restartLevelButton;
    
    JButton moveUpButton;
    JButton moveLeftButton;
    JButton moveDownButton;
    JButton moveRightButton;
    
    int levelWidth;     //Width of level will be the length of each line. This assumes all levels will be rectangular
    int levelHeight;    //Height of level will be number of lines
    int numberOfCrates; 
    
    Level(int levelNum) {
        try {
            loadMap(levelNum);
        } catch (FileNotFoundException ex){
            System.out.println("probloem with level.loadmap  message:" + ex.getMessage());
        };
        
        numberOfMovesLabel = new JLabel("0");
        add(numberOfMovesLabel, new Integer(0));
        numberOfMovesLabel.setBounds(5,20,30,20);
        numberOfMovesLabel.setVisible(true);
        
        
        restartLevelButton = new JButton("Restart");
        add(restartLevelButton, new Integer(0));
        restartLevelButton.setBounds(0,75,100,20);
        restartLevelButton.setVisible(true);
        restartLevelButton.addActionListener(this);
        
        
        
        moveUpButton = new JButton("Up");
        add(moveUpButton, new Integer(0));
        moveUpButton.setBounds(120,10,100,20);
        moveUpButton.setVisible(true);
        moveUpButton.addActionListener(this);
        
        moveLeftButton = new JButton("Left");
        add(moveLeftButton, new Integer(0));
        moveLeftButton.setBounds(10,35,100,20);
        moveLeftButton.setVisible(true);
        moveLeftButton.addActionListener(this);
        
        moveDownButton = new JButton("Down");
        add(moveDownButton, new Integer(0));
        moveDownButton.setBounds(120,35,100,20);
        moveDownButton.setVisible(true);
        moveDownButton.addActionListener(this);
        
        moveRightButton = new JButton("Right");
        add(moveRightButton, new Integer(0));
        moveRightButton.setBounds(230,35,100,20);
        moveRightButton.setVisible(true);
        moveRightButton.addActionListener(this);
    }
    
    public void loadMap(int levelNum) throws FileNotFoundException {
        String levelLocation = "resources/levels/level" + levelNum + ".txt";
        
        File levelFile = new File(levelLocation);

        Scanner levelScanner = new Scanner(levelFile);
        
        //Setting the sizes of map and crates array.
        levelWidth = levelScanner.nextInt();
        levelHeight = levelScanner.nextInt();
        numberOfCrates = levelScanner.nextInt();
        
        System.out.println(levelWidth);
        System.out.println(levelHeight);
        System.out.println(numberOfCrates);
        
        levelScanner.nextLine();  //uses an empty line as the first line-last line is then cut off
        
        map = new MapElement[levelHeight][levelWidth];
        crates = new Crate[numberOfCrates];
        //end of setting array sizes
        
        if (levelWidth*20 < 330) {
            this.setBounds(10,10,330,levelHeight*20+100);
        } else {
            this.setBounds(10,10,levelWidth*20,levelHeight*20+100);
        }
        this.setVisible(true);
        
        
        //populating map array and creating crate and warehousekeeper objects
        
            /*
            * When using swing the first component added is shown on top of others.
            * This means that for the warehous keeper and crates to be dsplaed on top of
            * the map elements they must be added to the level component first.
            */
            
        int i = 0; 
        int cratesAdded = 0;
        while (i < levelHeight) {            
            String currentLine = levelScanner.nextLine();
            char charecter[] = currentLine.toCharArray();
            int j = 0;
            while (j < charecter.length) {                            
                if (charecter[j] == ' ') {
                    map[i][j] = new Floor();
                } else if (charecter[j] == 'X') {
                    map[i][j] = new Wall();
                } else if (charecter[j] == '.') {
                    map[i][j] = new Diamond();
                } else if (charecter[j] == '*') {
                    map[i][j] = new Floor();                    
                    if (cratesAdded > numberOfCrates){ 
                        System.out.println("Too many crates");
                    } else {
                        crates[cratesAdded] = new Crate(j,i);
                        this.add(crates[cratesAdded], new Integer(1));
                        crates[cratesAdded].setBounds(j,i);
                        cratesAdded++;
                    }
                } else if (charecter[j] == '@') {
                    map[i][j] = new Floor();
                    warehouseKeeper = new WarehouseKeeper(j,i);
                    this.add(warehouseKeeper, new Integer(1));
                    this.addKeyListener(warehouseKeeper);
                    warehouseKeeper.setBounds(j,i);
                }
                j++;                               
            }
            System.out.println();
            i++;           
        }
        
        i = 0;
        while (i < levelHeight) {
            int j = 0;
            while (j < levelWidth) {
                System.out.println(map[i][j].getElementName());                
                this.add(map[i][j], new Integer(0));
                map[i][j].setBounds(j,i);
                j++; 
            }
            i++; 
        }
        
            /*
            * This line was used to test wether the warehousekeeper and crates would be displyed on top of other map elements.
            * As in swing components that are added first are displayed on top, the warehousekeeper can be moved to the first
            * map element added to test wether it it has been added before it and will bbe displayed on top of it.
            */
        //warehouseKeeper.setBounds(0,0,10,10);
        
        System.out.println("Arrays Populated");
    }
    
    public boolean checkForWin() {
        boolean win = true;
        int i = 0;
        while (i < crates.length) {
            if (map[crates[i].getYPosition()][crates[i].getXPosition()].getRepresentingCharecter() != ".") {
                win = false;
            }
            i++;
        }
        
        if (win == true) {
            restartLevelButton.setEnabled(false);
            moveUpButton.setEnabled(false);
            moveLeftButton.setEnabled(false);
            moveDownButton.setEnabled(false);
            moveRightButton.setEnabled(false);
            
            restartLevelButton.setVisible(false);
            moveUpButton.setVisible(false);
            moveLeftButton.setVisible(false);
            moveDownButton.setVisible(false);
            moveRightButton.setVisible(false);
            
            JLabel winBox = new JLabel("You have won!");
            this.add(winBox, new Integer(1));
            winBox.setVisible(true);
            winBox.setBounds(10,30,100,50);
        }
        
        
        return win;
    }
    
    public void restartLevel() {
        int i = 0;
        while (i < crates.length) {
            crates[i].resetPosition();
            i++;
        }
        warehouseKeeper.resetPosition();   
        numberOfMoves = 0;
    }
    
    public String getMapElementName(int x, int y) {
        return map[y][x].getElementName();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.moveUpButton) {
            System.out.println("Try to move up");
            moveElement(warehouseKeeper,"up");
        } else if (e.getSource() == this.moveLeftButton) {
            System.out.println("Try to move left");
            moveElement(warehouseKeeper,"left");
        } else if (e.getSource() == this.moveDownButton) {
            System.out.println("Try to move down");
            moveElement(warehouseKeeper,"down");                            
        } else if (e.getSource() == this.moveRightButton) {
            System.out.println("Try to move right");
            moveElement(warehouseKeeper,"right");
        }
    }
            
    public boolean moveElement(WarehouseKeeper w, String direction) {
        boolean canMove = true;
        Coordinate p;
        if (direction == "up") {
            p = new Coordinate(w.getXPosition(),w.getYPosition()-1);
        } else if (direction == "left") {
            p = new Coordinate(w.getXPosition()-1,w.getYPosition());
        } else if (direction == "down") {
            p = new Coordinate(w.getXPosition(),w.getYPosition()+1);
        } else {
            p = new Coordinate(w.getXPosition()+1,w.getYPosition());
        }
        
        if (map[p.getY()][p.getX()].getElementName() == "Wall") {
            System.out.println("Warehouse keeper tried to walk into wall at" + w.getX() +" , " + w.getY()+1);
            canMove = false;
        } else {
            for (int i=0; i < numberOfCrates; i++) {
                if (crates[i].getXPosition() == p.getX() && crates[i].getYPosition() == p.getY()) {
                    System.out.println("warehouse keper moved into crate " + i);
                    canMove = moveElement(i,direction);
                }
            }
        }                
        if (canMove == true) {           
            warehouseKeeper.setCurrentPosition(p);
            numberOfMoves++;
            numberOfMovesLabel.setText(String.valueOf(numberOfMoves));
        }        
        return canMove;
    }
    
    
    public boolean moveElement(int c, String direction) {
        boolean canMove = true;
        Coordinate p;
        if (direction == "up") {
            p = new Coordinate(crates[c].getXPosition(),crates[c].getYPosition()-1);
        } else if (direction == "left") {
            p = new Coordinate(crates[c].getXPosition()-1,crates[c].getYPosition());
        } else if (direction == "down") {
            p = new Coordinate(crates[c].getXPosition(),crates[c].getYPosition()+1);
        } else {
            p = new Coordinate(crates[c].getXPosition()+1,crates[c].getYPosition());
        }
        
        if (map[p.getY()][p.getX()].getElementName() == "Wall") {
            System.out.println("Crate keeper tried to move into wall at" + crates[c].getX() +" , " + crates[c].getY()+1);
            canMove = false;
        } else {
            for (int i=0; i < numberOfCrates; i++) {
                if (crates[i].getXPosition() == crates[c].getX() && crates[i].getYPosition() == crates[c].getY()) {
                    
                } else if (crates[i].getXPosition() == p.getX() && crates[i].getYPosition() == p.getY()) {
                    System.out.println("crate moved into crate " + i);
                    canMove = false;
                }
            }
        }                
        if (canMove == true) {           
            crates[c].setCurrentPosition(p);
            this.checkForWin();
        }        
        return canMove;
    }
    
}
