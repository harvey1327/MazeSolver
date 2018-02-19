package com.hrv.mazeSolver.maze;

public abstract class MazeSection {

    private Coordinates coordinates;

    /**
     * Abstract maze init with coordinates
     * @param coordinates
     */
    public MazeSection(Coordinates coordinates){
        this.coordinates=coordinates;
    }

    /**
     * Return coordinates
     * @return
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }
}
