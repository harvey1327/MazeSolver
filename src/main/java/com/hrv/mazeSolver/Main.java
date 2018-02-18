package com.hrv.mazeSolver;

import com.hrv.mazeSolver.io.FileIO;
import com.hrv.mazeSolver.maze.MazeParser;

import java.util.List;

public class Main {

    public static void main(String args[]){
        List<String> list = new FileIO().readFileIntoList("medium_input.txt");
        MazeParser maze = new MazeParser(list);
        maze.print();
        System.out.println("--------------------------");
        maze.solve();
    }
}
