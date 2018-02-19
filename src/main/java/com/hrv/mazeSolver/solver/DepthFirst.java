package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.Maze;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst {

    /**
     * This holds the path from start to end
     */
    private Stack<Floor> finalStack= new Stack<Floor>();

    /**
     * Solve the maze provided by looking for the starting node
     * and applying recursion
     * @param maze
     */
    public void solve(Maze maze){
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
        if(!finalStack.isEmpty()){
            updateMazeWithPath(maze.getSections());
            maze.setSolved();
        }
    }

    /**
     * Update maze object with path to return a solved maze
     * @param sectionList
     */
    private void updateMazeWithPath(List<MazeSection> sectionList){
        for(MazeSection section : sectionList){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(finalStack.contains(floor)){
                    floor.setPath();
                }
            }
        }
    }

    /**
     * Recursion method based on Depth First which looks at
     * neighboring floors to decide a potential path. Relies
     * on a stack for Last In First Out
     * @param floor
     * @param stack
     * @return
     */
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