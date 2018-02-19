package com.hrv.mazeSolver.maze;

public class Coordinates {

    private int x;
    private int y;

    Coordinates(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean compare(Coordinates coordinates){
        return coordinates.getX() == this.x && coordinates.getY() == this.y;
    }

    public String toString(){
        return x+":"+y;
    }
}
