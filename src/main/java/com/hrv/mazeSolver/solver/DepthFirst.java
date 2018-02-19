package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.Maze;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst {

    private Maze maze;
    private Stack<Floor> finalStack= new Stack<Floor>();

    public DepthFirst(Maze maze){
        this.maze=maze;
    }

    public List<MazeSection> solve(){
        //Get Start Position
        Stack<Floor> stack=new Stack<Floor>();
        for(MazeSection section : maze.getSections()){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(floor.isStart()){
                    recursionDF(floor, stack);
                }
            }
        }
        List<MazeSection> solvedMaze = updateMazeWithPath(maze.getSections());
        return solvedMaze;
    }

    private List<MazeSection> updateMazeWithPath(List<MazeSection> maze){
        List<MazeSection> solvedMaze = new ArrayList<>(maze);
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(finalStack.contains(floor)){
                    floor.setPath();
                }
            }
        }
        return solvedMaze;
    }

    private Stack<Floor> recursionDF(Floor floor, Stack<Floor> stack){
        stack.add(floor);
        floor.setVisited();
        List<Floor> neighbours = floor.getNeighbour();
        if(!floor.isEnd()){
            if(!neighbours.isEmpty()){
                for(Floor neighbourFloor : neighbours) {
                    if (!neighbourFloor.isVisited()) {
                        stack=recursionDF(neighbourFloor, stack);
                    }
                }
                //If all neighbours have been visited then pop
                boolean unVisited=false;
                for(Floor neighbourFloor : neighbours){
                    if (!neighbourFloor.isVisited()) {
                        unVisited=true;
                    }
                }
                if(!unVisited){
                    stack.pop();
                }
            }
        } else {
            finalStack.addAll(stack);
        }
        return stack;
    }
}