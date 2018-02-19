package com.hrv.mazeSolver.maze;

public class Wall extends MazeSection {

    /**
     * Init abstract super class with coordinates
     * @param coordinates
     */
    public Wall(Coordinates coordinates){
        super(coordinates);
    }

    /**
     * Return string output of wall
     * @return
     */
    public String toString(){
        return "#";
    }
}
