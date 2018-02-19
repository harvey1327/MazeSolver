package com.hrv.mazeSolver.maze;

import java.util.List;

public class MazeParser {

    private int width;
    private int height;
    private Coordinates start;
    private Coordinates end;
    private Maze maze;
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
        this.maze = new Maze(width, height);
        //Index 3 onwards is the maze, so sublist
        generateMaze(list.subList(3, list.size()));
        populateNeighbours();
    }

    public Maze getMaze(){
        return maze;
    }

    private int getMeteData(String data, int index){
        return Integer.parseInt(data.split(" ")[index]);
    }

    private void populateNeighbours(){
        for(int i=0; i<maze.getSize(); i++){
            MazeSection mazeSection = maze.getSection(i);
            if(mazeSection instanceof Floor){
                //Check North,East,South,West for other floors
                int northIndex = i-width;
                int eastIndex = i+1;
                int southIndex = i+width;
                int westIndex = i-1;
                if(northIndex > 0 && maze.getSection(northIndex) instanceof Floor) {
                    ((Floor) mazeSection).addNeighbour((Floor) maze.getSection(northIndex));
                }
                if(eastIndex < maze.getSize() && maze.getSection(eastIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.getSection(eastIndex));
                }
                if(southIndex < maze.getSize() && maze.getSection(southIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.getSection(southIndex));
                }
                if(westIndex > 0 && maze.getSection(westIndex) instanceof Floor){
                    ((Floor) mazeSection).addNeighbour((Floor) maze.getSection(westIndex));
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
                maze.addSection(mazeSection);
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
}
