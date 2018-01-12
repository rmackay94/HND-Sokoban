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
* Robbie Mackay
* Student Number: 16003059
* HND Computer Science
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
        assertEquals("Floor",instance.getMapElementName(0,0));
        assertEquals("Floor",instance.getMapElementName(0,4));
        assertEquals("Floor",instance.getMapElementName(4,0));
        assertEquals("Floor",instance.getMapElementName(4,4));
    }

    /**
     * Test of restartLevel method, of class Level.
     */
    @Test
    public void testRestartLevel() {
        System.out.println("restartLevel");
        Level instance = new Level(0);
        instance.setElementPosition(0,0);
//        instance.crates[0].setCurrentPosition(0,0);
//        instance.crates[1].setCurrentPosition(0,0);
//        instance.crates[2].setCurrentPosition(0,0);
        
//        Coordinate temp = new Coordinate(1,2);
        instance.restartLevel();
        
        assertEquals(2,instance.getElementXPosition());
        assertEquals(1,instance.getElementYPosition());
        //assertEquals(temp,instance.warehouseKeeper.getCurrentPosition());
    }
    
    
    @Test
    public void testMoveElement() {
        System.out.println("moveElement");
        Level instance = new Level(0);
        
        assertFalse(instance.moveElement("up"));
        assertEquals(2,instance.getElementXPosition());
        assertEquals(1,instance.getElementYPosition());
        assertTrue(instance.moveElement("left"));
        assertEquals(1,instance.getElementXPosition());
        assertEquals(1,instance.getElementYPosition());
    }
    
}
