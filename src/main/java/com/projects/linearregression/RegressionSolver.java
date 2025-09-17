package com.projects.linearregression;

import org.ejml.simple.SimpleMatrix;

/**
 * Performs the polynomial regression using the least squares
 * method and uses EJML for matrix operations
 */
public class RegressionSolver {
    /**
     * Regression coefficients
     */
    public SimpleMatrix betaMat;

    public RegressionSolver(){

    }

    /**
     *Evaluates the polynomial function for the given degree and data points
     *
     * @param n the degree of the polynomail
     * @param points points the 2D array of (x, y) points to fit the regression
     */
    public void getRegressionPoly(int n, double[][] points){
        //BigDecimal[][] xMat = new BigDecimal[points.length][n+1];
        SimpleMatrix xMat = new SimpleMatrix(points.length, n + 1);
        SimpleMatrix yMat = new SimpleMatrix(points.length, 1);
        for (int point = 0; point < points.length; point++) {
            yMat.set(point, 0, points[point][1]);
            for (int beta = 0; beta < n + 1; beta++) {
                xMat.set(point, beta, Math.pow(points[point][0], (beta)));
            }
        }
        SimpleMatrix xTranspose = xMat.transpose();
        betaMat = xTranspose.mult(xMat).invert().mult(xTranspose.mult(yMat));
    }

    /**
     * Returns a string representation of the regression coefficient matrix
     *
     * @return a string containing the coefficients matrix
     */
    public String getPolyString(){
        return betaMat.toString();
    }

    /**
     * This evaluates the polynomail regression function at the given x value
     *
     * @param x the x value
     * @return the computed y value from the model
     */
    public double poly(double x){
        int size = betaMat.getNumElements();
        double yPoint = 0;
        for(int i = 0; i < size; i++){
            yPoint += betaMat.get(i, 0)*Math.pow(x, i);
        }
        return yPoint;
    }

}
