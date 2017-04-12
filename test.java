
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

        ////////////////////////////////////////////////////////////////////

    }
    
    private static double jTheta(Matrix[] trainingData, Matrix[] outputData, Matrix[] thetaValues, double lambdaValue) {
        
        int n = trainingData.length;
        
        double sum = 0.0;
        
        for(int m = 1; m < n; m++){
            
            Matrix hypot = computeHypothesis(trainingData[m], thetaValues[0], thetaValues[1]);
            
            for(int k = 1; k < n; k++ ){
                
                
                if(outputData[m].get(k,0) == 1){
                    sum += Math.log(hypot.get(k,0));
                }
                else if(outputData[m].get(k,0) == 0){
                    sum += Math.log(1 - hypot.get(k,0));
                }
                else{
                    System.err.print("Unsxpected non binary numeral in the output matrix");
                }
            }
        }

        return sum;

    }
    
    /* 
     * This method takes as input a single input vector (without bias unit -- you'll need to add that), along with the weight matrices, and
     * computes the output vector of the neural network. That is, it performs forward propagation.
     */
    private static Matrix computeHypothesis(Matrix input, Matrix theta1, Matrix theta2){

        System.out.println("Computing Hypothesis...");
        
        System.out.println("-----------------------");
        
        
        System.out.println("input: " + input.getRowDimension() + " x " + input.getColumnDimension());
        System.out.println("theta1: " + theta1.getRowDimension() + " x " + theta1.getColumnDimension());
        System.out.println("theta2: " + theta2.getRowDimension() + " x " + theta2.getColumnDimension());
        
        //i think multiple input * theta1
        //then apply sigmoid function to each value of the output lets call that z1
        //then multiply z1 * theta2
        //then apply sigmoid function to each value of the output lets call that z2
        //then return that matrix;
        
        if (input.getColumnDimension() != 1) {
            System.err.println("Error: input not a column vector!\n");
            //System.exit(1);
        }
        
        if((input.getRowDimension() + 1) != theta1.getColumnDimension()){
            System.err.println("Innapropriate theta matrix: wrong number of rows");
            //System.exit(1);
        }
        
        //add check to make sure number of rows in theta1 are equal to number of columns in theta2
    
        if((theta1.getRowDimension() + 1) != (theta2.getColumnDimension())){
                System.err.println("Innapropriate theta matrix: theta matrices are not the same size");
                //System.exit(1);
            }
        
        double biasVal = 1.0;
            
        Matrix inputWithBias = addBiasUnit(input, biasVal);  
        
        //System.out.println("inputWithBias: " + inputWithBias.getRowDimension() + " x " + inputWithBias.getColumnDimension());
        
        Matrix result1 = logisticFunction(theta1.times(inputWithBias));
        
        Matrix result1WithBias = addBiasUnit(result1, biasVal);
        
        Matrix output = logisticFunction(theta2.times(result1WithBias));
        
        output.print(1, 3);
   
        return output;
    }
    
    


    public static void aidanTest(){
        double val = 0.5;
        
        int numInputs = 4;
        int numOutputs = 4;
        int hiddenLayer = 4;
        
        Matrix testInput = new Matrix(numInputs, 1, 1);
        Matrix testTheta1 = new Matrix(hiddenLayer, numInputs + 1, 1);
        Matrix testTheta2 = new Matrix(numOutputs, hiddenLayer + 1, 1);

        Matrix finalOutput = computeHypothesis(testInput, testTheta1, testTheta2);
        
        finalOutput.print(1, 3);

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
    
    private static Matrix addBiasUnit(Matrix inputs, double biasVal){
        
        if (inputs.getColumnDimension() != 1) {
            System.out.print("Error: input not a column vector!\n");
            System.exit(1);
        }
        
        int numRows = inputs.getRowDimension();
        
        System.out.println("Num rows: " + numRows);
        
        Matrix mWithBias = new Matrix(numRows + 1, 1, biasVal);
        
        for(int i = 1; i < numRows + 1; i++){
            
            mWithBias.set(i, 0, inputs.get(i - 1, 0));
            
        }
        
        return mWithBias;
    }
}
