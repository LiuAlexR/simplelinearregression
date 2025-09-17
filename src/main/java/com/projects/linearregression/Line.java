package com.projects.linearregression;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

/**
 * The Line class of each individual line that is drawn on the homepage.
 */
public class Line extends JComponent {
    /**
     * Each x and y coordinate, both the start and end pairs.
     */
    private double x1, x2, y1, y2;
    Dimension screenSize;
    Line2D.Double line;
    /**
     * The width of the lines
     */
    private int strokeWidth;
    /**
     * Constructor for the Line. Sets default strokeWidth to 2.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param screenSize
     */
    public Line(double x1, double y1, double x2, double y2, Dimension screenSize) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = screenSize.getHeight() - y1;
        this.y2 = screenSize.getHeight() - y2;
        this.screenSize = screenSize;
        line = new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
        strokeWidth = 2;
    }
    /**
     * Constructor for the Line. Allows the user to specify the width
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param screenSize
     * @param strokeWidth
     */
    public Line(double x1, double y1, double x2, double y2, Dimension screenSize, int strokeWidth) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = screenSize.getHeight() - y1;
        this.y2 = screenSize.getHeight() - y2;
        line = new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
        this.strokeWidth = strokeWidth;
    }

    /**
     * Draws the line.
     * @param g The graphics.
     */
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeWidth));
        g2.setPaint(new Color(0, 0, 0));
        g2.draw(line);
    }

    /**
     * Moves the lines.
     * @param dx The end x.
     * @param dy The end y.
     */
    public void translate(int dx, int dy){
        x1 += dx;
        x2 += dx;
        y1 -= dy;
        y2 -= dy;
        line.setLine(x1, y1, x2, y2);
    }
    /**
     * Gets coordinates
     * @return
     */
    public double[] getCoords(){
        return new double[]{x1, y1, x2, y2};
    }
}
