package com.hrv.mazeSolver.maze;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y){
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
        if(coordinates.getX() == this.x && coordinates.getY() == this.y){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "x:"+x+",y:"+y;
    }
}
