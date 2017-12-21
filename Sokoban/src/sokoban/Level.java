/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author 16003059
 */
public class Level extends JComponent implements ActionListener{
    MapElement map[][];
    WarehouseKeeper warehouseKeeper;
    Crate crates[];
    int numberOfMoves;
    JLabel numberOfMovesLabel;
    JButton restartLevelButton;
    
    Level(int levelNum) {
        loadMap(levelNum);
    }
    
    public void loadMap(int levelNum) throws FileNotFoundException {
        String levelLocation = "resorces/levels/" + levelNum;
        
        //try {
            File levelFile = new File(levelLocation);
        //} catch (Exception ex) {
        //    System.out.println("exception happened");
        //}
        //try {
            Scanner levelScanner = new Scanner(levelFile);
        //} catch (Exception ex) {
            
        //}
        int levelWidth;
        int levelHeight;
        
        levelWidth = levelScanner.nextInt();
        levelHeight = levelScanner.nextInt();
        
        int i = 0;
        while (levelscanner.hasNextLine()) {
            
            lines[i] = scanner.nextLine();
            char charecters[] = lines[i].toCharArray();
            int j = 0;
            while (j < charecters.length) {
                charecters2[i][j] = charecters[j];
                System.out.println(charecters2[i][j]);
                j++;
            }

            i++;
        }
    }
    
    public void checkForWin() {
        
    }
    
    public void restartLevel() {
        
    }

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
