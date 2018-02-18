package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<MazeSection> maze = new ArrayList<>();
    private int width;
    private int height;
    private Coordinates start;
    private Coordinates end;

    public Maze(List<String> list){
        //Index 0 is Width,Height
        this.width = getMeteData(list, 0,0);
        this.height = getMeteData(list, 0,1);
        //Index 1 is StartX,StartY
        this.start = new Coordinates(getMeteData(list, 1,0), getMeteData(list, 1,1));
        //Index 2 is EndX,EndY
        this.end = new Coordinates(getMeteData(list, 2,0), getMeteData(list, 2,1));
        generateMaze(list);
    }

    public void print(){
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        for(int i=0; i<maze.size(); i++){
            if(i%width<width-1){
                System.out.print(maze.get(i));
            } else {
                System.out.println(maze.get(i));
            }
        }
    }

    private int getMeteData(List<String> list, int firstIndex, int secondIndex){
        return Integer.parseInt(list.get(firstIndex).split(" ")[secondIndex]);
    }

    private void generateMaze(List<String> list){
        for(int y=3; y<list.size(); y++){
            String[] row = list.get(y).split(" ");
            for(int x=0; x<row.length; x++){
                String s = row[x];
                Coordinates coordinates = new Coordinates(x,y-3);
                MazeSection mazeSection = null;
                if(s.equals("1")){
                    mazeSection = new Wall(coordinates);
                } else if(s.equals("0")) {
                    mazeSection = new Floor(coordinates);
                    if(mazeSection.getCoordinates().compare(start)){
                        ((Floor) mazeSection).setStart();
                    } else if(mazeSection.getCoordinates().compare(end)){
                        ((Floor) mazeSection).setEnd();
                    }
                }
                maze.add(mazeSection);
            }
        }
    }
}
