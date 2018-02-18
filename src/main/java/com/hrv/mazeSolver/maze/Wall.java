package com.hrv.mazeSolver.maze;

public class Wall extends MazeSection {

    public Wall(Coordinates coordinates){
        super(coordinates);
    }

    public String toString(){
        return "#";
    }
}
