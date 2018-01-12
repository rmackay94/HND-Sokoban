/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class Level extends JLayeredPane implements ActionListener{
    
    private MapElement map[][];                 //Arary of MapElements that will not move ie. walls, floors and diamonds
    private WarehouseKeeper warehouseKeeper;    //one WarehouseKeeper object
    private Crate crates[];                     //Array of all crates
    private int numberOfMoves;
    private JLabel numberOfMovesLabel;
    private JButton restartLevelButton;
    
    private int levelWidth;     //Width of level will be the length of each line. This assumes all levels will be rectangular
    private int levelHeight;    //Height of level will be number of lines
    private int numberOfCrates; 
    
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
            this.setBounds(10,100,330,levelHeight*20+100);
        } else {
            this.setBounds(10,100,levelWidth*20,levelHeight*20+100);
        }
        this.setVisible(true);
        
        
        //populating map array and creating crate and warehousekeeper objects
            
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
            
        System.out.println("Arrays Populated");
    }    
    
    public void restartLevel() {
        int i = 0;
        while (i < crates.length) {
            crates[i].resetPosition();
            i++;
        }
        warehouseKeeper.resetPosition();   
        numberOfMoves = 0;
        numberOfMovesLabel.setText(String.valueOf(numberOfMoves));
    }
    
    public String getMapElementName(int x, int y) {
        return map[y][x].getElementName();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.restartLevelButton) {
            restartLevel();
        }
    }
            
    public boolean moveElement(String direction) {
        boolean canMove = true;
        Coordinate p;
        if (direction == "up") {
            p = new Coordinate(warehouseKeeper.getXPosition(),warehouseKeeper.getYPosition()-1);
        } else if (direction == "left") {
            p = new Coordinate(warehouseKeeper.getXPosition()-1,warehouseKeeper.getYPosition());
        } else if (direction == "down") {
            p = new Coordinate(warehouseKeeper.getXPosition(),warehouseKeeper.getYPosition()+1);
        } else {
            p = new Coordinate(warehouseKeeper.getXPosition()+1,warehouseKeeper.getYPosition());
        }
        
        if (map[p.getY()][p.getX()].getElementName() == "Wall") {
            System.out.println("Warehouse keeper tried to walk into wall at" + warehouseKeeper.getX() +" , " + warehouseKeeper.getY()+1);
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
        }        
        return canMove;
    }
    
    // Setting warehouseKeeper position. used for testing
    public void setElementPosition(int newX, int newY) {
        warehouseKeeper.setCurrentPosition(newX, newY);
    }    
    
    // Setting crate position. Used in testing
    public void setElementPosition(int crateNumber, int newX, int newY) {
        crates[crateNumber].setCurrentPosition(newX, newY);
    }
    
    //Getting warehouseKeeper X position
    public int getElementXPosition() {
        return warehouseKeeper.getXPosition();
    }
    
    //Getting warehouseKeeper Y position
    public int getElementYPosition() {
        return warehouseKeeper.getYPosition();
    }
    
    //Getting crate X position
    public int getElementXPosition(int crateNumber) {
        return crates[crateNumber].getXPosition();
    }
    
    //Getting crate Y position
    public int getElementYPosition(int crateNumber) {
        return crates[crateNumber].getXPosition();
    }
    
    public String getElementRepresentingCharecter(int x, int y) {
        return map[y][x].getRepresentingCharecter();
    }
        
    public int getNumberOfCrates() {
        return numberOfCrates;
    }
    
    public void toggleCrateOnDiamond(int crateNumber, boolean onDiamond) {
        if (onDiamond == true) {
            crates[crateNumber].setElementColour(Color.DARK_GRAY);
        } else {
            crates[crateNumber].setElementColour(Color.red);
        }
    }
}
