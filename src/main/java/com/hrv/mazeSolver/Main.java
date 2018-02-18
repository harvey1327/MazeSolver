package com.hrv.mazeSolver;

import com.hrv.mazeSolver.io.FileIO;
import com.hrv.mazeSolver.maze.Maze;

import java.util.List;

public class Main {

    public static void main(String args[]){
        List<String> list = new FileIO().readFileIntoList("input.txt");
        System.out.println(list);
        Maze maze = new Maze(list);
        maze.print();
    }
}
