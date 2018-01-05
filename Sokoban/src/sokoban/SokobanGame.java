/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class SokobanGame extends JComponent implements MouseListener {
    private int currentLevelNum;
    private final JFrame mainWindow;
    private StartMenu mainMenu;
    private String levelWonDialog;

    
    SokobanGame() {
        mainWindow = new JFrame();
        mainWindow.setSize(1000,600);
        mainWindow.setLayout(null);      
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartMenu startMenu = new StartMenu();
        mainWindow.add(startMenu);
        SokobanControls controls = new SokobanControls();
        mainWindow.add(controls);
        loadLevel(0);                                    
    }
    
    public void loadLevel(int levelNumber) {
        Level currentLevel = new Level(levelNumber);
        mainWindow.add(currentLevel);
        currentLevel.repaint();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        requestFocusInWindow();
        System.out.println("keybroad focus requested");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
