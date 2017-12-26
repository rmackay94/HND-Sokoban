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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class Level extends JComponent implements ActionListener{
    
    MapElement map[][];                 //Arary of MapElements that will not move ie. walls, floors and diamonds
    WarehouseKeeper warehouseKeeper;    //one WarehouseKeeper object
    Crate crates[];                     //Array of all crates
    int numberOfMoves;
    JLabel numberOfMovesLabel;
    JButton restartLevelButton;
    
    int levelWidth;     //Width of level will be the length of each line
    int levelHeight;    //Height of level will be number of lines
    int numberOfCrates; 
    
    Level(int levelNum) {
        try {
            loadMap(levelNum);
        } catch (FileNotFoundException ex){
            System.out.println("probloem with level.loadmap  message:" + ex.getMessage());
        };
        
        setBounds(10,10,levelWidth*10,levelHeight*10);
        setVisible(true);
        
        int i = 0;
        while (i<levelHeight) {
            int j = 0;
            while (j < levelWidth) {
                
//                this.add(map[i][j]);
//                map[i][j].setVisible(true);
//                map[i][j].repaint();
//
//                this.add(map[i][j]);
//                map[i][j].setBounds(i*10,j*10,10,10);
                j++;
            }
            i++;
        }
        
        
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
        
        map = new MapElement[levelWidth][levelHeight];
        crates = new Crate[numberOfCrates]; 
        //end of setting array sizes
        
        //populating map array and creating crate and warehousekeeper objects
        int i = 1;
        while (i<levelHeight) {
            
            String line = levelScanner.nextLine();
            char charecter[] = line.toCharArray();
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
                    crates[0] = new Crate(i,j);
                } else if (charecter[j] == '@') {
                    map[i][j] = new Floor();
                    warehouseKeeper = new WarehouseKeeper(i,j);
                }
                System.out.println(map[i][j].elementName);
                j++;
                
                
            }
            System.out.println();
            i++;
        }
        // End of populating arrays.
        System.out.println("sdfg");
    }
    
    public void checkForWin() {
        
    }
    
    public void restartLevel() {
        
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
    }

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
