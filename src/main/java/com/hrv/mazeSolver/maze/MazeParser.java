package com.hrv.mazeSolver.maze;

import com.hrv.mazeSolver.solver.DepthFirst;

import java.util.ArrayList;
import java.util.List;

public class MazeParser {

    private int width;
    private int height;
    private Coordinates start;
    private Coordinates end;
    private List<MazeSection> maze = new ArrayList<MazeSection>();
    private String wall = "1";
    private String floor = "0";

    public MazeParser(List<String> list){
        //Index 0 is Width,Height
        this.width = getMeteData(list.get(0),0);
        this.height = getMeteData(list.get(0),1);
        //Index 1 is StartX,StartY
        this.start = new Coordinates(getMeteData(list.get(1),0), getMeteData(list.get(1),1));
        //Index 2 is EndX,EndY
        this.end = new Coordinates(getMeteData(list.get(2),0), getMeteData(list.get(2),1));
        //Index 3 onwards is the maze, so sublist
        generateMaze(list.subList(3, list.size()));
        populateNeighbours();
    }

    public void solve(){
        DepthFirst depthFirst = new DepthFirst(maze);
        List<MazeSection> solvedMaze = depthFirst.solve();
        for(int i=0; i<solvedMaze.size(); i++){
            if(i%width<width-1){
                System.out.print(solvedMaze.get(i));
            } else {
                System.out.println(solvedMaze.get(i));
            }
        }
    }

    private int getMeteData(String data, int index){
        return Integer.parseInt(data.split(" ")[index]);
    }

    private void populateNeighbours(){
        for(int i=0; i<maze.size(); i++){
            MazeSection mazeSection = maze.get(i);
            if(mazeSection instanceof Floor){
                //Check North,East,South,West for other floors
                int northIndex = i-width;
                int eastIndex = i+1;
                int southIndex = i+width;
                int westIndex = i-1;
                if(northIndex > 0 && maze.get(northIndex) instanceof Floor) {
                    ((Floor) mazeSection).addNeighbour((Floor) maze.get(northIndex));
                }
                if(eastIndex < maze.size() && maze.get(eastIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.get(eastIndex));
                }
                if(southIndex < maze.size() && maze.get(southIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.get(southIndex));
                }
                if(westIndex > 0 && maze.get(westIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.get(westIndex));
                }
            }
        }
    }

    private void generateMaze(List<String> list){
        for(int y=0; y<height; y++){
            String[] row = list.get(y).split(" ");
            for(int x=0; x<width; x++){
                String s = row[x];
                Coordinates coordinates = new Coordinates(x,y);
                MazeSection mazeSection = null;
                if(s.equals(wall)){
                    mazeSection = new Wall(coordinates);
                } else if(s.equals(floor)) {
                    mazeSection = getFloor(coordinates);
                }
                maze.add(mazeSection);
            }
        }
    }

    private MazeSection getFloor(Coordinates coordinates){
        MazeSection mazeSection = new Floor(coordinates);
        if(mazeSection.getCoordinates().compare(start)){
            ((Floor) mazeSection).setStart();
        } else if(mazeSection.getCoordinates().compare(end)){
            ((Floor) mazeSection).setEnd();
        }
        return mazeSection;
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
}
