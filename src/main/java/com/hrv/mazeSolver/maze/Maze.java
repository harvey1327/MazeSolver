package com.hrv.mazeSolver.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<MazeSection> maze = new ArrayList<MazeSection>();
    private int width;
    private int height;
    private boolean solved = false;

    /**
     * Creates a maze object with height and width
     * @param width
     * @param height
     */
    public Maze(int width, int height){
        this.width=width;
        this.height=height;
    }


    /**
     * Returns a List<MazeSection> which effectively holds
     * the maze
     * @return
     */
    public List<MazeSection> getSections(){
        return maze;
    }

    /**
     * Returns a section of the maze
     * @param index
     * @return
     */
    public MazeSection getSection(int index){
        return maze.get(index);
    }

    /**
     * Add a section to the maze
     * @param section
     */
    public void addSection(MazeSection section){
        maze.add(section);
    }

    /**
     * Returns the size of the List
     * @return
     */
    public int getSize(){
        return maze.size();
    }

    /**
     * Sets the maze as solved
     */
    public void setSolved(){
        this.solved=true;
    }

    /**
     * Returns solved boolean
     * @return
     */
    public boolean isSolved(){
        return solved;
    }

    /**
     * Pretty prints the maze
     */
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
