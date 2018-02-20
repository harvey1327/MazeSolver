package com.hrv.mazeSolver.maze;

import org.junit.Assert;
import org.junit.Test;

public class CoordinatesTest {

    @Test
    public void setCoordinates(){
        int x = 1;
        int y = 1;
        Coordinates coordinates = new Coordinates(x,y);
        Assert.assertEquals(x, coordinates.getX());
    }
}
