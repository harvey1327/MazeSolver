package com.hrv.mazeSolver;

import com.hrv.mazeSolver.io.FileIO;
import com.hrv.mazeSolver.maze.Maze;
import com.hrv.mazeSolver.maze.MazeParser;
import com.hrv.mazeSolver.solver.DepthFirst;

import java.util.List;

public class Main {

    public static void main(String args[]){
        List<String> list = new FileIO().readFileIntoList("input.txt");
        MazeParser mazeParser = new MazeParser(list);
        Maze maze = mazeParser.getMaze();

        DepthFirst depthFirst = new DepthFirst(maze);
        depthFirst.solve();

        maze.print();
    }
}
