/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.gameoflife;

/**
 *
 * @author alu10571073
 */
public class ConfigData {
    
    private static final int MIN_ROWS_COLS = 100;
    private static final int MAX_ROWS_COLS = 1000;
    
    private static ConfigData configData;
    
    private int numRows = 100;
    private int numCols = 100;
    
    private ConfigData() {
        
    }

    public static ConfigData getInstance() {
        if (configData == null) {
            configData = new ConfigData();
        }
        return configData;
    }
    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        if (numRows < MIN_ROWS_COLS) {
            this.numRows = MIN_ROWS_COLS;
        }else if (numRows > MAX_ROWS_COLS) {
            this.numRows = MAX_ROWS_COLS;
        }else {
        this.numRows = numRows;
        }
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        if (numCols < MIN_ROWS_COLS) {
            this.numCols = MIN_ROWS_COLS;
        }else if (numCols > MAX_ROWS_COLS) {
            this.numCols = MAX_ROWS_COLS;
        }else {
        this.numCols = numCols;
        
        }
    }
}
