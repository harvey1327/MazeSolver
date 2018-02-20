package com.hrv.mazeSolver.maze;

import org.junit.Assert;
import org.junit.Test;

public class CoordinatesTest {

    @Test
    public void testSetCoordinates(){
        int x = 1;
        int y = 1;
        Coordinates coordinates = new Coordinates(x,y);
        Assert.assertEquals(x, coordinates.getX());
    }

    @Test
    public void testCompareReturnsTrue(){
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(1,1);
        Assert.assertTrue(coordinates1.compare(coordinates2));
    }

    @Test
    public void testCompareReturnsFalse(){
        Coordinates coordinates1 = new Coordinates(1,1);
        Coordinates coordinates2 = new Coordinates(2,1);
        Assert.assertFalse(coordinates1.compare(coordinates2));
    }
}
