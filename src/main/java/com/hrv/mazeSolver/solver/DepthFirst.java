package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.ArrayList;
import java.util.List;

public class DepthFirst {

    private List<MazeSection> maze;
    private List<Floor> path = new ArrayList<Floor>();

    public DepthFirst(List<MazeSection> maze){
        this.maze=maze;
    }

    public void solve(){
        //Get Start Position
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(floor.isStart()){
                    recursionDF(floor);
                }
            }
        }
        System.out.println(path);
    }

    public void recursionDF(Floor floor){
        System.out.println("Going into "+floor);
        if(!floor.isEnd()){
            System.out.println("Not End "+floor);
            List<Floor> neighbours = floor.getNeighbour();
            floor.setVisited();
            for(Floor neighbourFloor : neighbours) {
                System.out.println(floor+" has neighbour "+neighbourFloor);
                if (!neighbourFloor.isVisited()) {
                    recursionDF(neighbourFloor);
                }
            }
        } else {
            System.out.println("Is End "+floor);
        }
        System.out.println("Finished "+floor);
    }
}
