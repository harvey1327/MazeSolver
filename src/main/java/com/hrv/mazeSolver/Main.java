package com.hrv.mazeSolver;

import com.hrv.mazeSolver.IO.FileIO;
import com.hrv.mazeSolver.maze.Maze;

import java.util.List;

public class Main {

    public static void main(String args[]){
        System.out.println("Start");
        List<String> list = new FileIO().readFileIntoList("medium_input.txt");
        System.out.println(list);

        Maze maze = new Maze(list);
        maze.print();
    }
}
