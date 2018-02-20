package com.hrv.mazeSolver.solver;

import com.hrv.mazeSolver.maze.Maze;
import com.hrv.mazeSolver.maze.MazeParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstTest {

    @Test
    public void test(){
        List<String> dataList1 = new ArrayList<String>();
        dataList1.add("4 4");
        dataList1.add("1 1");
        dataList1.add("2 2");
        dataList1.add("1 1 1 1");
        dataList1.add("1 0 1 1");
        dataList1.add("1 0 0 1");
        dataList1.add("1 1 1 1");
        MazeParser parser = new MazeParser(dataList1);
        Maze maze = parser.getMaze();
        DepthFirst depthFirst = new DepthFirst();
        depthFirst.solve(maze);
        Assert.assertTrue(maze.isSolved());
    }
}
