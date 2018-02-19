package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<MazeSection> maze = new ArrayList<MazeSection>();
    private int width;
    private int height;
    private boolean solved = false;

    public Maze(int width, int height){
        this.width=width;
        this.height=height;
    }


    public List<MazeSection> getSections(){
        return maze;
    }

    public MazeSection getSection(int index){
        return maze.get(index);
    }

    public void addSection(MazeSection section){
        maze.add(section);
    }

    public int getSize(){
        return maze.size();
    }

    public void print(){
        if(solved){
            System.out.println("Solved");
        } else {
            System.out.println("Unsolved");
        }
        for(int i=0; i<maze.size(); i++){
            if(i%width<width-1){
                System.out.print(maze.get(i));
            } else {
                System.out.println(maze.get(i));
            }
        }
    }
}
