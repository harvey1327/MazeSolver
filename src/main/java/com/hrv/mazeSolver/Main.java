package com.hrv.mazeSolver;

import com.hrv.mazeSolver.io.FileIO;
import com.hrv.mazeSolver.maze.Maze;
import com.hrv.mazeSolver.maze.MazeParser;
import com.hrv.mazeSolver.solver.DepthFirst;

import java.util.List;

public class Main {

    public static void main(String args[]){
        if(args.length==1){
            //Read file into List
            List<String> list = new FileIO().readFileIntoList(args[0]);
            //Parse list and get maze
            MazeParser mazeParser = new MazeParser(list);
            Maze maze = mazeParser.getMaze();
            //Solve the maze
            DepthFirst depthFirst = new DepthFirst();
            depthFirst.solve(maze);
            //Print maze
            maze.print();
        } else {
            System.out.println("Too many,none or negative args");
        }
    }
}
