package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Floor extends MazeSection {

    private boolean start = false;
    private boolean end = false;
    private boolean visited = false;
    private boolean path = false;
    private List<Floor> neighbours;


    /**
     * Init abstract super class with coordinates and
     * create new neighbor List
     * @param coordinates
     */
    public Floor(Coordinates coordinates) {
        super(coordinates);
        neighbours = new ArrayList<Floor>();
    }

    /**
     * Return string output of floor
     * @return
     */
    public String toString() {
        if(start){
            return "S";
        } else if(end){
            return "E";
        } else if(path) {
            return "X";
        } else {
            return " ";
        }
    }

    /**
     * Add neighboring floor to neighbours list
     * @param floor
     */
    public void addNeighbour(Floor floor){
        neighbours.add(floor);
    }

    /**
     * Returns all neighboring floors to this floor
     * @return
     */
    public List<Floor> getNeighbour(){
        return neighbours;
    }

    /**
     * Return boolean start
     * @return
     */
    public boolean isStart(){
        return start;
    }

    /**
     * Sets the floor as visited
     */
    public void setVisited(){
        visited = true;
    }

    /**
     * Return boolean visited
     * @return
     */
    public boolean isVisited(){
        return visited;
    }

    /**
     * Return boolean end
     * @return
     */
    public boolean isEnd(){
        return end;
    }

    /**
     * Set as startpoint in maze
     */
    public void setStart() {
        this.start = true;
    }

    /**
     * Set as endpoint in maze
     */
    public void setEnd() {
        this.end = true;
    }

    /**
     * Set as path based from solution
     */
    public void setPath(){
        this.path=true;
    }

}
