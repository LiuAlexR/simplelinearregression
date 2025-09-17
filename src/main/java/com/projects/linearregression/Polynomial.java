package com.projects.linearregression;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Provides the static method that draws the polynomial curve on
 * the graphic context based on the rgression solver
 */

public class Polynomial extends JComponent {
    private Dimension screenSize;
    private ArrayList<Line> sections = new ArrayList<>();
    RegressionSolver solver;
    public Polynomial(Dimension screenSize, RegressionSolver solver){
        this.screenSize = screenSize;
        this.solver = solver;
    }

    /**
     * Draws the polynomail curve calculated by the regressionsolver on the graphic object
     * Draws the curve across the width of the screen and center it
     * @param g the graphics context that it draws on
     * @param r the gression sovler containg the coefficient of the polynomail
     */
    public void createLines(Gridline horizontal, Gridline vertical){
        sections.clear();
        int minTickMark = horizontal.getMinTick();
        int maxTickMark = horizontal.getMaxTick();
        int minTickY = vertical.getMinTick();
        int maxTickY = vertical.getMaxTick();
        double gridMinPos = horizontal.getPixelMinPos();
        double gridLength = horizontal.getLength();
        double gridHeight = vertical.getLength();
        double gridLow = vertical.getPixelMinPos();
        double unitsPerPixel = (maxTickMark - minTickMark) / gridLength;
        for(double i = gridMinPos; i < gridMinPos + gridLength; i += 3){
            double x1 = i;
            double x2 = i+3;
            
            double y1 = solver.poly(minTickMark + unitsPerPixel * (i - gridMinPos));
            double ratio = (y1 - minTickY) / (maxTickY - minTickY);
            y1 = gridHeight * ratio + gridLow;
            double y2 = solver.poly(minTickMark + unitsPerPixel * (i + 3 - gridMinPos));
            ratio = (y2 - minTickY) / (maxTickY - minTickY);
            y2 = gridHeight * ratio + gridLow;           
            sections.add(new Line(x1, y1, x2, y2, screenSize, 2));
        }
    }
    public void draw(Graphics g, Gridline horizontal, Gridline vertical){
        Graphics2D g2 = (Graphics2D) g;
        createLines(horizontal, vertical);
        for(var line : sections){
            line.draw(g2);
        }
    }
    public void draw(Graphics g, int deprecated) {
        Graphics2D g2 = (Graphics2D) g;
        Line line;
        double increment = 10; //the smaller, the more precise and slow the program will be
        double end = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double endY = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        for (double i = 0; i < end; i += increment) {
            line = new Line(i, solver.poly(i), i+increment, solver.poly(i+increment), Toolkit.getDefaultToolkit().getScreenSize());
            line.draw(g2);
        }
    }
}
