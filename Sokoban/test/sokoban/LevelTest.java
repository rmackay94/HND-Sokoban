/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robbie
 */
public class LevelTest {
    
    public LevelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadMap method, of class Level.
     */
    @Test
    public void testLoadMap() throws Exception {
        System.out.println("loadMap");
        int levelNum = 0;
        Level instance = new Level(0);
        instance.loadMap(levelNum);
        // TODO review the generated test code and remove the default call to fail.
        
            //Checking that all four corners of the map are floor objects.
        assertEquals("Floor",instance.map[0][0].elementName);
        assertEquals("Floor",instance.map[4][0].elementName);
        assertEquals("Floor",instance.map[0][4].elementName);
        assertEquals("Floor",instance.map[4][4].elementName);
    }

    /**
     * Test of checkForWin method, of class Level.
     */
    @Test
    public void testCheckForWin() {
        System.out.println("checkForWin");
        Level instance = null;
        boolean expResult = false;
        boolean result = instance.checkForWin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restartLevel method, of class Level.
     */
    @Test
    public void testRestartLevel() {
        System.out.println("restartLevel");
        Level instance = new Level(0);
        instance.warehouseKeeper.currentPositionInMap.setX(0);
        instance.warehouseKeeper.currentPositionInMap.setY(0);
        instance.restartLevel();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1,instance.warehouseKeeper.currentPositionInMap.getX());
        assertEquals(2,instance.warehouseKeeper.currentPositionInMap.getY());
    }
    
}
