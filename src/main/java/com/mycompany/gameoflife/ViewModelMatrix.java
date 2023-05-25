/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameoflife;

/**
 *
 * @author alu10571073
 */
public class ViewModelMatrix {
    
    private DataMatrix dataMatrix;
    
    public ViewModelMatrix(int numRows, int numCols) {
        dataMatrix = new DataMatrix(numRows, numCols);
    }
    
    public void fillRandom(float ratioAlive) {
        int numRows = dataMatrix.getNumRows();
        int numCols = dataMatrix.getNumCols();
        int numCells = numRows * numCols;
        int numCellsToFill = (int) (numCells * ratioAlive);
        int counter = 0;
        while (counter  < numCellsToFill) {
            int randRow = (int) (Math.random() * numRows);
            int randCol = (int) (Math.random() * numCols);
            if (!dataMatrix.isAlive(randRow, randCol)) {
                dataMatrix.born(randRow, randCol);
                counter ++;
            }
        }
    }
    
    public void calculateNextGen() {
        DataMatrix previousDataMatrix = dataMatrix.copy();
        int numRows = dataMatrix.getNumRows();
        int numCols = dataMatrix.getNumCols();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                //Apply rules
                int numNeightbors = getNumNeightbors(previousDataMatrix,row, col);
                if (numNeightbors < 2) {
                    dataMatrix.kill(row, col);
                    
                }else if (numNeightbors >= 2 && numNeightbors <= 3 && previousDataMatrix.isAlive(row, col)) {
                    dataMatrix.born(row, col);
                    
                }else if (numNeightbors > 3) {
                    dataMatrix.kill(row, col);
                    
                }else if (numNeightbors == 3) {
                    dataMatrix.born(row, col);
                }
            }
        }
    }
    
    public int getNumNeightbors(DataMatrix previous, int row, int col) {
        int counter = 0;
        int numRows = previous.getNumRows();
        int numCols = previous.getNumCols();
        for (int i = -1;i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int checkRow = row + i;
                    int checkCol = col + j;
                    if (checkRow >= 0 && checkRow < numRows && checkCol >= 0 && checkCol < numCols) {
                        //Valid Position
                        if (previous.isAlive(checkRow, checkCol)) {
                            counter ++;
                        }
                    }
                }
            }
        }
        return counter;
    }
    
    public boolean isAlive(int row, int col) {
        return dataMatrix.isAlive(row, col);
    }
    
    public void kill(int row, int col) {
        dataMatrix.kill(row, col);
    }
    
    public void born(int row, int col) {
        dataMatrix.born(row, col);
    }
    
}
