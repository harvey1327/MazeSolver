package com.hrv.mazeSolver.maze;

public class Coordinates {

    private int x;
    private int y;

    /**
     * Coordinate init by x,y values
     * @param x
     * @param y
     */
    public Coordinates(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Return x value
     * @return
     */
    public int getX(){
        return x;
    }

    /**
     * Return y value
     * @return
     */
    public int getY(){
        return y;
    }

    /**
     * Return true if this coordinate has equal x,y value to input coordinate
     * @param coordinates
     * @return
     */
    public boolean compare(Coordinates coordinates){
        return coordinates.getX() == this.x && coordinates.getY() == this.y;
    }

    /**
     * Return string output of coordinate
     * @return
     */
    public String toString(){
        return x+":"+y;
    }
}
