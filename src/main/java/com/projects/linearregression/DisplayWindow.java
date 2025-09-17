package com.projects.linearregression;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * The display window class that displays the graph.
 */
public class DisplayWindow extends JPanel{
    /**
     * The application handler parent.
     */
    ApplicationHandler parent;
    /**
     * The size of the screen.
     */
    Dimension screenSize;
    /**
     * The degree of polynomial.
     */
    int n;
    /**
     * The 2d array of points.
     */
    double[][] points;

    /**
     * Constructor of display window.
     * @param parent The parent application handler
     * @param screenSize The size of the screen.
     * @param n The degree of polynomial.
     * @param points The 2d array of points.
     */
    public DisplayWindow(ApplicationHandler parent, Dimension screenSize, int n, double[][] points){
        this.parent = parent;
        this.screenSize = screenSize;
        this.n = n;
        this.points = points;

    }
    /**
     * Paints the polynomial regression line on the panel.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        RegressionSolver r = new RegressionSolver();
        r.getRegressionPoly(n, points);
        Polynomial poly = new Polynomial(screenSize, r);
        Gridline grid = new Gridline(screenSize, 1, -50, 50, 10, 000, screenSize.getHeight()/2, screenSize.getWidth() + 10);
        grid.draw(g2);
        Gridline vert = new Gridline(screenSize, 2, -50, 50, 10, 000, screenSize.getWidth()/2, screenSize.getHeight() + 10);
        vert.draw(g2);
        poly.draw(g2, grid, vert);
        for(var point : points){
            double ratioX = (point[0] - grid.getMinTick()) / (grid.getMaxTick() - grid.getMinTick());
            double x1 = grid.getLength() * ratioX + grid.getPixelMinPos();
            double ratioY = (point[1] - vert.getMinTick()) / (vert.getMaxTick() - vert.getMinTick());
            double y1 = vert.getLength() * ratioY + vert.getPixelMinPos();
            Line pointLine = new Line(x1, y1, x1, y1, screenSize, 10);
            pointLine.draw(g2);
        }
    }
}
