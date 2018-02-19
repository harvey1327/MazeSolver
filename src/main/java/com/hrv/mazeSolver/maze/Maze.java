package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<MazeSection> maze = new ArrayList<MazeSection>();
    private int width;
    private int height;

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
        System.out.println("Start: "+ getStart());
        System.out.println("End: "+ getEnd());
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        for(int i=0; i<maze.size(); i++){
            if(i%width<width-1){
                System.out.print(maze.get(i));
            } else {
                System.out.println(maze.get(i));
            }
        }
    }

    private Coordinates getStart(){
        Coordinates coordinates = null;
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(floor.isStart()){
                    coordinates = floor.getCoordinates();
                }
            }
        }
        return coordinates;
    }

    private Coordinates getEnd(){
        Coordinates coordinates = null;
        for(MazeSection section : maze){
            if(section instanceof Floor){
                Floor floor = (Floor) section;
                if(floor.isEnd()){
                    coordinates = floor.getCoordinates();
                }
            }
        }
        return coordinates;
    }
}
