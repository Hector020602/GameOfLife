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
    
    public int getNumRows() {
        return cells.length;
    }
    
    public int getNumCols() {
        return cells[0].length;
    }
    
    public DataMatrix copy() {
        int rows = getNumRows();
        int cols = getNumCols();
        DataMatrix newDataMatrix = new DataMatrix(rows,
                cols);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col ++) {
                newDataMatrix.cells[row][col] = cells[row][col];
            }
        }
        return newDataMatrix;
    }
    
    public boolean isAlive(int row, int col) {
        return cells[row][col];
    }
    
}
