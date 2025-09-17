package com.projects.linearregression;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Gridline extends JComponent {
    private Dimension screenSize;
    private int type, minDisplayed, maxDisplayed, numOfTicks;
    private double minPos, constant, length;
    private ArrayList<Line> tickmarks = new ArrayList<>();
    private Line mainLine;
    private final int TICK_SIZE = 10;
    public Gridline(Dimension screenSize, int type, int minDisplayed, int maxDisplayed, int numOfTicks, double minPos, double constant, double length){ //type = 1 to get horizontal
        this.screenSize = screenSize;
        this.type = type;
        this.minDisplayed = minDisplayed;
        this.maxDisplayed = maxDisplayed;
        this.numOfTicks = numOfTicks;
        this.minPos = minPos;
        this.length = length;
        this.constant = constant;
        if(this.type == 1){
            mainLine = new Line(minPos, constant, minPos+length, constant, screenSize);
            getHorizontalTickmarks();
        } else {
            mainLine = new Line(constant, minPos, constant, minPos+length, screenSize);
            getVerticalTickmarks();
        }
        
    }
    public int getMinTick(){
        return minDisplayed;
    }
    public int getMaxTick(){
        return maxDisplayed;
    }
    public double getLength(){
        return length;
    }
    public int getNumTicks(){
        return numOfTicks;
    }
    public double getPixelMinPos(){
        return minPos;
    }
    public double getConstant(){
        return constant;
    }
    public void getHorizontalTickmarks(){
        tickmarks.clear();
        for(double i = 0; i < minPos + length; i += length/ (double) numOfTicks) {
            tickmarks.add(new Line(minPos + i, constant + TICK_SIZE, minPos + i, constant - TICK_SIZE, screenSize));
        }
    }
    public void getVerticalTickmarks(){
        tickmarks.clear();
        for(double i = 0; i < minPos + length; i += length/numOfTicks) {
            tickmarks.add(new Line(constant + TICK_SIZE, minPos + i, constant - TICK_SIZE, minPos + i, screenSize));
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(type == 1){
            getHorizontalTickmarks();
        } else {
            getVerticalTickmarks();
        }
        g2.setPaint(new Color(0, 0, 0));
        mainLine.draw(g2);
        for(int i = 0; i < tickmarks.size(); i++){
            tickmarks.get(i).draw(g2);
            g2.drawString(String.format("%d", minDisplayed + i * (maxDisplayed - minDisplayed) / numOfTicks), Math.round(tickmarks.get(i).getCoords()[2]) + 2 * TICK_SIZE, Math.round(tickmarks.get(i).getCoords()[3]) + 2 * TICK_SIZE);
        }
    }


}
