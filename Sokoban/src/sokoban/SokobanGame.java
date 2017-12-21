/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class SokobanGame extends JComponent{
    int currentLevelNum = 1;
    JFrame mainWindow;
    StartMenu mainMenu;
    String levelWonDialog;
    
    SokobanGame() {
        mainWindow = new JFrame();
        mainWindow.setSize(500,500);
        mainWindow.setLayout(null);      
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void loadLevel(int levelNumber) {
        Level currentLevel = new Level(currentLevelNum);
    }
}
