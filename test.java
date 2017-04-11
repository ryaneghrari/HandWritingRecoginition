
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import Jama.Matrix;

public class test{
   
    private static final int NUM_OUTPUT_CLASSES = 10;
    private static final int INPUT_VECTOR_DIMENSION = 20;  // The number of input units, not counting the bias unit.
    private static final int HIDDEN_LAYER_SIZE = 20;
    
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


        System.out.println("Santi testing starts here");
    
    
        double val = 0.5;

        Matrix temp = new Matrix(9, 1, val);
        Matrix temp2 = new Matrix(10, 1, 1.0);
        
        System.out.println("BiasINput before multiply:");
        temp2.print(1, 1);
    
        Matrix multi = temp2.arrayTimes(temp); 
        
        System.out.println("BiasINput before multiply:");
        multi.print(1, 1);
   
        System.out.println("Santi Testing ends here");


        ////////////////////////////////////////////////////////////////////

    }
    
    /* 
     * This method takes as input a single input vector (without bias unit -- you'll need to add that), along with the weight matrices, and
     * computes the output vector of the neural network. That is, it performs forward propagation.
     */
    private Matrix computeHypothesis(Matrix input, Matrix theta1, Matrix theta2) {

        //i think multiple input * theta1
        //then apply sigmoid function to each value of the output lets call that z1
        //then multiply z1 * theta2
        //then apply sigmoid function to each value of the output lets call that z2
        //then return that matrix;
        
        if (input.getColumnDimension() != 1) {
            System.out.print("Error: input not a column vector!\n");
            System.exit(1);
        }
        
        if((input.getRowDimension() + 1) != theta1.getColumnDimension()){
            System.out.print("Innapropriate theta matrix: wrong number of rows");
            System.exit(1);
        }
        
        //add check to make sure number of rows in theta1 are equal to number of columns in theta2
    
        if((theta1.getRowDimension()) != theta2.getColumnDimension()){
                System.out.print("Innapropriate theta matrix: theta matrices are not the same size");
                System.exit(1);
            }
        
            
            
        Matrix result1 = new Matrix(HIDDEN_LAYER_SIZE, 1);
        Matrix result2 = new Matrix(NUM_OUTPUT_CLASSES, 1);
    
        Matrix BiasInput = new Matrix(HIDDEN_LAYER_SIZE + 1, 1, 1);

        BiasInput = BiasInput.arrayTimes(input);
    
        result1 = theta1.times(BiasInput);
        result1 = logisticFunction(result1);
    
            
            
        return null;

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
