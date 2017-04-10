
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import Jama.Matrix;

public class test{
    public test(){
    }
    private int getMax(Matrix m) {
        return 0;
    }

    public static void main(String[] args){
        
        /*
        test t = new test();
        Matrix m = new Matrix(10,1);
        System.out.println(m.get(9,0));
        m.set(9,0,3.0);
        System.out.println(m.get(9,0));

        double[][] arr = m.getArray();

        //System.out.println(arr.length);

        
        double[][] temp = m.getArray();

        int maxIndex    = 0; 
        double maxVal   = 0.0;

        for(int i = 0; i < temp.length; i++){

            if(temp[i][0] > maxVal){
                maxVal = temp[i][0];
                maxIndex = i;
            }

        }

        System.out.println("index: " + maxIndex);

        
        
        
        ////////////////////////////////////////////////////////////////

        String s = "4";

        int val = Integer.parseInt(s);

        Matrix temp1 = new Matrix(10,1);

        temp1.set(val,0,1.0);

        temp1.print(10,1);

        //////////////////////////////////////////////////////////////////
        
        //////////////////////////////////////////////////////////////////

        int INPUT_VECTROR_DIMENSION = 10;
        String input = "1000100000";

        Matrix temp2 = new Matrix(INPUT_VECTROR_DIMENSION,1);

        for(int i = 0; i < INPUT_VECTROR_DIMENSION; i++){
            if(input.charAt(i) == '1'){
                temp2.set(i,0,1.0);
            }
        }

        temp2.print(10,1);

        /////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////

        double[][] d = new double[3][1];

        Matrix mat = new Matrix(d);
        mat.print(3,1);

        /////////////////////////////////////////////////////////////////

        
        
        
        ///////////////////////////////////////////////////////////////////
        
        int rows = 5;
        int cols = 2;
        int epsilon = 1;

        int max = epsilon;
        int min = -1 * epsilon;

        double[][] matr = new double[rows][cols];

        //System.out.println(matr.length);
        //System.out.println(matr[0].length);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                Random rand = new Random();

                matr[i][j] = rand.nextDouble() * (max - min) + min;
            }
        }

        Matrix temp3 = new Matrix(matr);
        temp3.print(rows,cols);
        
        */

        System.out.println("Santi testing here");

        double val = 0.5;

        Matrix temp = new Matrix(10, 1, val);
	Matrix temp2 = new Matrix(10, 1, val);

	Matrix multi = temp2.times(temp.transpose());
	
	multi.print(1, 3);
	
	
	
        System.out.println("Logistic of " + val + " is: " + logisticFunction(val));

	
        ////////////////////////////////////////////////////////////////////

    }

    public static void aidanTest(){
        double val = 0.5;

        Matrix temp = new Matrix(10, 1, val);

        System.out.println("Logistic of " + val + " is: " + logisticFunction(val));

        Matrix logTemp = logisticFunction(temp);

        logTemp.print(1, 3);

    }

    public static Matrix createInitialTheta(int rows, int cols, double epsilon) {

        double max = epsilon;
        double min = (-1 * epsilon); //negative epsilon

        Matrix matr = new Matrix(rows, cols);

        Random rand = new Random();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matr.set(i, j, rand.nextDouble() * (max - min) + min);
            }
        }

        return matr;
    }

    private static double logisticFunction(double x) {

        //apply whatever the logistic function is to x
        double result = (1 / (1 + Math.pow(Math.E,(-1*x))));

        return result;
    }

    public static Matrix logisticFunction(Matrix x) {

        int numRows = x.getRowDimension();
        int numCols = x.getColumnDimension();

        if( numCols != 1){
            System.err.println("Passed incorrectly sized matrix to logisticFunction(Matrix m)");
        }

        Matrix logMatr = new Matrix(numRows, numCols);

        for(int i = 0; i < numRows; i++){
            double newVal = logisticFunction( x.get(i,0) );

            logMatr.set(i, 0, newVal); 
        }
        return logMatr;
    }
}
