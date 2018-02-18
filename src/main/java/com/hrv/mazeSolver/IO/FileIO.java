package com.hrv.mazeSolver.IO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIO {

    public List<String> readFileIntoList(String fileName){
        List<String> list = null;
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            Stream<String> stream = Files.lines(path);
            list = stream.collect(Collectors.toList());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
