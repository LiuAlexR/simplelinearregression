package com.projects.linearregression;

import java.awt.Dimension;
import java.util.ArrayList;

public class Grid {

    private int width;
    private int height;
    private int spacing;
    private Dimension screenSize;
    public Grid(int width, int height, int spacing) {
        this.width = width;
        this.height = height;
        this.spacing = spacing;
    }

    public ArrayList<Line> getLines(){
        ArrayList<Line> gridLines = new ArrayList<>();

        for(int i = 0; i <=width; i +=spacing){
            gridLines.add(new Line(i, 0, i, height, screenSize));

        }

        for(int j = 0; j <= height; j+= spacing){
            gridLines.add(new Line(0, j, width, j, screenSize));
        }

        return gridLines;
    }
}
