package com.projects.linearregression;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.WindowConstants;

/**
 * The main class.
 */
public class Main {
    public static void main(String[] args) {

        double[][] points = new double[][]{};
        try {
            File myObj = new File("linearregression/src/main/resources/points.txt");
            Scanner scanner = new Scanner(myObj);
            int num = Integer.parseInt(scanner.nextLine());
            points = new double[num][2];
            for(int i = 0; i < num; i++){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if(parts.length == 2){
                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);
                    points[i][0] = x;
                    points[i][1] = y;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the degree of the polynomial");
        int n = in.nextInt();
        ApplicationHandler handler = new ApplicationHandler(n, points);
        handler.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        handler.setVisible(true);
    }
}