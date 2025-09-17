package com.projects.linearregression;

import javax.swing.JFrame;
import java.awt.*;

/**
 * The application handler.
 */
public class ApplicationHandler extends JFrame{
    /**
     * The screen size as a dimension.
     */
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * The state tracker.
     */
    private int state = 0;
    /**
     * The homepage class.
     */
    Homepage homepage = new Homepage(this, screenSize);
    /**
     * The polynomial level.
     */
    int n;
    /**
     * The points as a 2d array.
     */
    double[][] points;
    /**
     * The display window.
     */
    DisplayWindow mainPanel;
    /**
     * Constructor of the application handler.
     * @param n The polynomial level.
     * @param points The points as a 2d array.
     */
    public ApplicationHandler(int n, double[][] points){
        screenSize.setSize(screenSize.getWidth(), screenSize.getHeight() - 50);
        setSize(screenSize);
        add(homepage);
        this.n = n;
        this.points = points;
        mainPanel = new DisplayWindow(this, screenSize, n, points);
    }

    /**
     * Changes the state from zero to one.
     */
    public void changeState0To1(){
        state = 1;
        remove(homepage);
        add(mainPanel);
        revalidate();
        repaint();
    }
}
