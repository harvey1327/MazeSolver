package com.hrv.mazeSolver.maze;

public class Floor extends MazeSection {

    private boolean start = false;
    private boolean end = false;


    public Floor(Coordinates coordinates) {
        super(coordinates);
    }

    public String toString() {
        if(start){
            return "S";
        } else if(end){
            return "E";
        } else {
            return " ";
        }
    }

    public void setStart() {
        this.start = true;
    }

    public void setEnd() {
        this.end = true;
    }

}
