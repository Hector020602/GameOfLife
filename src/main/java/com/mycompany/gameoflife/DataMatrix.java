/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife;

/**
 *
 * @author alu10571073
 */
public class DataMatrix {
    
    private boolean [][] cells;
    
    public DataMatrix(int numRows, int numCols){
        cells = new boolean[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col ++) {
                cells[row][col] = false;
            }
        }
    }
    
    public void kill(int row, int col) {
        cells[row][col] = false;
    }
    
    public void born(int row, int col) {
        cells[row][col] = true;
    }
    
    
    
}
