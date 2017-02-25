
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

    }

}


