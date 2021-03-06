package com.hrv.mazeSolver.maze;

import java.util.List;

public class MazeParser {

    private Coordinates start;
    private Coordinates end;
    private Maze maze;
    private String wall = "1";
    private String floor = "0";

    /**
     * Parse File as List<String> to maze object
     * @param list
     */
    public MazeParser(List<String> list){
        //Index 0 is Width,Height
        int width = getMeteData(list.get(0),0);
        int height = getMeteData(list.get(0),1);
        //Index 1 is StartX,StartY
        this.start = new Coordinates(getMeteData(list.get(1),0), getMeteData(list.get(1),1));
        //Index 2 is EndX,EndY
        this.end = new Coordinates(getMeteData(list.get(2),0), getMeteData(list.get(2),1));
        //Index 3 onwards is the maze, so sublist
        this.maze = generateMaze(list.subList(3, list.size()), width, height);
        //Now we have the maze we can populate the neighbours for each floor
        populateNeighbours(width);
    }

    /**
     * Return populated maze object
     * @return
     */
    public Maze getMaze(){
        return maze;
    }

    /**
     * Get MetaData from data
     * @param data
     * @param index
     * @return
     */
    private int getMeteData(String data, int index){
        return Integer.parseInt(data.split(" ")[index]);
    }

    /**
     * Assign neighboring floors to a floor by looking N,E,S,W
     * @param width
     */
    private void populateNeighbours(int width){
        for(int i=0; i<maze.getSize(); i++){
            MazeSection mazeSection = maze.getSection(i);
            if(mazeSection instanceof Floor){
                int northIndex = i-width;
                int eastIndex = i+1;
                int southIndex = i+width;
                int westIndex = i-1;
                Floor floor = (Floor) mazeSection;
                if(northIndex > 0 && maze.getSection(northIndex) instanceof Floor) {
                    floor.addNeighbour((Floor) maze.getSection(northIndex));
                }
                if(eastIndex < maze.getSize() && maze.getSection(eastIndex) instanceof Floor){
                    floor.addNeighbour((Floor) maze.getSection(eastIndex));
                }
                if(southIndex < maze.getSize() && maze.getSection(southIndex) instanceof Floor){
                    floor.addNeighbour((Floor) maze.getSection(southIndex));
                }
                if(westIndex > 0 && maze.getSection(westIndex) instanceof Floor){
                    floor.addNeighbour((Floor) maze.getSection(westIndex));
                }
            }
        }
    }

    /**
     * Parse List<String> into maze objects
     * @param list
     * @param width
     * @param height
     */
    private Maze generateMaze(List<String> list, int width, int height){
        Maze maze = new Maze(width, height);
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
        return maze;
    }

    /**
     * Return Floor object as MazeSection,
     *  if object is start or end we set it here
     * @param coordinates
     * @return
     */
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
