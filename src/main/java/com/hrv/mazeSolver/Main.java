package com.hrv.mazeSolver;

import com.hrv.mazeSolver.io.FileIO;
import com.hrv.mazeSolver.maze.Maze;

import java.util.List;

public class Main {

    public static void main(String args[]){
        List<String> list = new FileIO().readFileIntoList("Harvey_test.txt");
        Maze maze = new Maze(list);
        maze.print();
        maze.solve();
        //maze.print();
    }
}
