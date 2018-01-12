/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
 */
public class SokobanGame extends JComponent implements ActionListener{
    
    private int currentLevelNum;
    private final JFrame mainWindow;
    private StartMenu mainMenu;
    private Level currentLevel;

    private JButton moveUpButton;
    private JButton moveLeftButton;
    private JButton moveDownButton;
    private JButton moveRightButton;
    private JButton nextLevelButton;
    
    
    SokobanGame() {
        mainWindow = new JFrame();
        mainWindow.setSize(1000,600);
        mainWindow.setLayout(null);      
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        StartMenu startMenu = new StartMenu();
//        mainWindow.add(startMenu);
//        SokobanControls controls = new SokobanControls();
//        mainWindow.add(controls);
        
        
        nextLevelButton = new JButton("Go to next Level");
        mainWindow.add(nextLevelButton);
        nextLevelButton.setBounds(100,70,140,20);
        nextLevelButton.setVisible(false);
        nextLevelButton.setEnabled(false);

        moveUpButton = new JButton("Up");
        mainWindow.add(moveUpButton);
        moveUpButton.setBounds(120,10,100,20);
        moveUpButton.setVisible(true);
        
        moveLeftButton = new JButton("Left");
        mainWindow.add(moveLeftButton);
        moveLeftButton.setBounds(10,35,100,20);
        moveLeftButton.setVisible(true);
        
        moveDownButton = new JButton("Down");
        mainWindow.add(moveDownButton);
        moveDownButton.setBounds(120,35,100,20);
        moveDownButton.setVisible(true);
        
        moveRightButton = new JButton("Right");
        mainWindow.add(moveRightButton);
        moveRightButton.setBounds(230,35,100,20);
        moveRightButton.setVisible(true);
        
        moveUpButton.addActionListener(this);
        moveLeftButton.addActionListener(this);
        moveDownButton.addActionListener(this);
        moveRightButton.addActionListener(this);
        nextLevelButton.addActionListener(this);
        
        currentLevelNum = 0;
        
        loadLevel(currentLevelNum);
    }
    
    public void loadLevel(int levelNumber) {
        currentLevel = new Level(currentLevelNum);
        mainWindow.add(currentLevel);
        currentLevel.repaint();
    }    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.moveUpButton) {
            System.out.println("Try to move up");
            currentLevel.moveElement("up");
            nextLevel();
        } else if (e.getSource() == this.moveLeftButton) {
            System.out.println("Try to move left");
            currentLevel.moveElement("left");
            nextLevel();
        } else if (e.getSource() == this.moveDownButton) {
            System.out.println("Try to move down");
            currentLevel.moveElement("down"); 
            nextLevel();
        } else if (e.getSource() == this.moveRightButton) {
            System.out.println("Try to move right");
            currentLevel.moveElement("right");
            nextLevel();
        } else if (e.getSource() == this.nextLevelButton) {
            currentLevelNum ++;
            
            mainWindow.remove(currentLevel);
            mainWindow.repaint();
            loadLevel(currentLevelNum);
            moveUpButton.setEnabled(true);
            moveLeftButton.setEnabled(true);
            moveDownButton.setEnabled(true);
            moveRightButton.setEnabled(true);
            
            nextLevelButton.setEnabled(false);
            nextLevelButton.setVisible(false);
        }
    }
    
    
    public void nextLevel() {
        if (checkForWin() == true) {
            moveUpButton.setEnabled(false);
            moveLeftButton.setEnabled(false);
            moveDownButton.setEnabled(false);
            moveRightButton.setEnabled(false);
            
            nextLevelButton.setEnabled(true);
            nextLevelButton.setVisible(true);
        }
    }
    

    public boolean checkForWin() {
        boolean win = true;
        int i = 0;
        while (i < currentLevel.getNumberOfCrates()) {
            if (currentLevel.getElementRepresentingCharecter (currentLevel.getElementXPosition(i), currentLevel.getElementYPosition(i)) != ".") {                
                win = false;
                currentLevel.toggleCrateOnDiamond(i, false);
                System.out.println("Crate number: " + i + " false");
            } else {
                currentLevel.toggleCrateOnDiamond(i, true);
                System.out.println("Crate number: " + i + " true");
            }
            i++;
        }
        
        if (win == true) {
            JLabel winBox = new JLabel("You have won!");
            this.add(winBox, new Integer(1));
            winBox.setVisible(true);
            winBox.setBounds(10,30,100,50);
        }
        
        
        return win;
    }


}
