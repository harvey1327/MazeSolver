package com.hrv.mazeSolver.maze;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FloorTest {

    @Test
    public void testReturnStringIfStart(){
        Coordinates coordinates = new Coordinates(1,1);
        Floor floor = new Floor(coordinates);
        floor.setStart();
        assertEquals("S",floor.toString());
    }

    @Test
    public void testReturnStringIfEnd(){
        Coordinates coordinates = new Coordinates(1,1);
        Floor floor = new Floor(coordinates);
        floor.setEnd();
        assertEquals("E",floor.toString());
    }

    @Test
    public void testReturnStringIfPath(){
        Coordinates coordinates = new Coordinates(1,1);
        Floor floor = new Floor(coordinates);
        floor.setPath();
        assertEquals("X",floor.toString());
    }
}
