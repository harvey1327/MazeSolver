package com.hrv.mazeSolver.maze;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MazeParserTest {

    @Test
    public void testParseList(){
        int height = 4;
        int width = 4;
        List<String> dataList1 = new ArrayList<String>();
        dataList1.add(height+" "+width);
        dataList1.add("1 1");
        dataList1.add("2 2");
        dataList1.add("1 1 1 1");
        dataList1.add("1 0 1 1");
        dataList1.add("1 0 0 1");
        dataList1.add("1 1 1 1");

        MazeParser parser = new MazeParser(dataList1);
        Assert.assertNotNull(parser.getMaze());
        Assert.assertEquals((height*width), parser.getMaze().getSize());
    }
}
