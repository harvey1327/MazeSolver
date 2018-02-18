package com.hrv.mazeSolver.maze;

public abstract class MazeSection {

    private Coordinates coordinates;

    public MazeSection(Coordinates coordinates){
        this.coordinates=coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }
}
