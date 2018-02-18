package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.List;

public class DepthFirst {

    private List<MazeSection> maze;

    public DepthFirst(List<MazeSection> maze){
        this.maze=maze;
    }

    public void solve(){
        //Get Start Position
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                System.out.println("Cord: "+floor.getCoordinates()+" neigh: "+floor.getNeighbour());
            }
        }
    }
}
