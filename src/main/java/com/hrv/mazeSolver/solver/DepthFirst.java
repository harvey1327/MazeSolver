package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst {

    private List<MazeSection> maze;
    private Stack<Floor> stack= new Stack<Floor>();
    private boolean found = false;

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
        System.out.println("Stack: "+stack);
    }

    public void dfs(Floor floor){
        Stack<Floor> stack= new Stack<Floor>();
        stack.add(floor);
        floor.setVisited();
        while(!found){
            System.out.println("Stack: "+stack);
            Floor stackFloor = stack.peek();
            List<Floor> neighbours = stackFloor.getNeighbour();
            for(Floor neighbourFloor : neighbours){
                if (!neighbourFloor.isVisited()) {
                    stack.add(neighbourFloor);
                    neighbourFloor.setVisited();
                    if(neighbourFloor.isEnd()){
                        found = true;
                    }
                } else {
                    stack.pop();
                }
            }
        }
    }

    public void recursionDF(Floor floor){
        System.out.println("Adding Floor: "+floor);
        stack.add(floor);
        floor.setVisited();
        List<Floor> neighbours = floor.getNeighbour();
        if(!floor.isEnd()){
            for(Floor neighbourFloor : neighbours) {
                System.out.println("Looking at neighbour: "+neighbourFloor);
                if (!neighbourFloor.isVisited()) {
                    recursionDF(neighbourFloor);
                } else {
                    System.out.println(stack);
                    System.out.println("Popping: "+stack.peek() +" at "+floor);
                    stack.pop();
                }
            }
        }
    }
}
