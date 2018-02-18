package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Floor extends MazeSection {

    private boolean start = false;
    private boolean end = false;
    private List<Floor> neighbours;


    public Floor(Coordinates coordinates) {
        super(coordinates);
        neighbours = new ArrayList<Floor>();
    }

    public String toString() {
        return super.getCoordinates().toString();
    }

    public void addNeighbour(Floor floor){
        neighbours.add(floor);
    }

    public List<Floor> getNeighbour(){
        return neighbours;
    }

    public boolean isStart(){
        return start;
    }

    public boolean isEnd(){
        return end;
    }

    public void setStart() {
        this.start = true;
    }

    public void setEnd() {
        this.end = true;
    }

}
