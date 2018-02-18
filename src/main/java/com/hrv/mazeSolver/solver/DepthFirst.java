package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Floor;
import com.hrv.mazeSolver.maze.MazeSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst {

    private List<MazeSection> maze;
    private Stack<Floor> finalStack= new Stack<Floor>();

    public DepthFirst(List<MazeSection> maze){
        this.maze=maze;
    }

    public List<MazeSection> solve(){
        //Get Start Position
        Stack<Floor> stack=new Stack<Floor>();
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(floor.isStart()){
                    recursionDF(floor, stack);
                }
            }
        }
//        System.out.println(finalStack);
        List<MazeSection> solvedMaze = updateMazeWithPath(maze);
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
//        System.out.println("Adding Floor: "+floor);
        stack.add(floor);
        floor.setVisited();
        List<Floor> neighbours = floor.getNeighbour();
        if(!floor.isEnd()){
            if(!neighbours.isEmpty()){
                boolean canPop=true;
                for(Floor neighbourFloor : neighbours) {
                    canPop=true;
//                    System.out.println("Current Floor: "+floor+" n at: " + neighbourFloor);
                    if (!neighbourFloor.isVisited()) {
                        canPop=false;
                        stack=recursionDF(neighbourFloor, stack);
                    }
                }
                //If all neighbours have been visited then pop
                if(canPop) {
//                    System.out.println("Popping: "+stack.peek()+" at: "+floor);
                    stack.pop();
                }
            }
        } else {
//            System.out.println("FOUND END WITH STACK: "+stack);
            finalStack.addAll(stack);
        }
        return stack;
    }
}